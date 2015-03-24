package net.magik6k.jwwf.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * From apache libs
 */
class ReaderInputStream extends InputStream {
	private static final int BYTE_MASK = 255;
	private Reader in;
	private String encoding;
	private byte[] slack;
	private int begin;

	public ReaderInputStream(Reader reader) {
		this.encoding = System.getProperty("file.encoding");
		this.in = reader;
	}

	public ReaderInputStream(Reader reader, String encoding) {
		this(reader);
		if(encoding == null) {
			throw new IllegalArgumentException("encoding must not be null");
		} else {
			this.encoding = encoding;
		}
	}

	public synchronized int read() throws IOException {
		if(this.in == null) {
			throw new IOException("Stream Closed");
		} else {
			byte result;
			if(this.slack != null && this.begin < this.slack.length) {
				result = this.slack[this.begin];
				if(++this.begin == this.slack.length) {
					this.slack = null;
				}
			} else {
				byte[] buf = new byte[1];
				if(this.read(buf, 0, 1) <= 0) {
					return -1;
				}

				result = buf[0];
			}

			return result & 255;
		}
	}

	public synchronized int read(byte[] b, int off, int len) throws IOException {
		if(this.in == null) {
			throw new IOException("Stream Closed");
		} else if(len == 0) {
			return 0;
		} else {
			while(this.slack == null) {
				char[] buf = new char[len];
				int n = this.in.read(buf);
				if(n == -1) {
					return -1;
				}

				if(n > 0) {
					this.slack = (new String(buf, 0, n)).getBytes(this.encoding);
					this.begin = 0;
				}
			}

			if(len > this.slack.length - this.begin) {
				len = this.slack.length - this.begin;
			}

			System.arraycopy(this.slack, this.begin, b, off, len);
			this.begin += len;
			if(this.begin >= this.slack.length) {
				this.slack = null;
			}

			return len;
		}
	}

	public synchronized void mark(int limit) {
		try {
			this.in.mark(limit);
		} catch (IOException var3) {
			throw new RuntimeException(var3.getMessage());
		}
	}

	public synchronized int available() throws IOException {
		if(this.in == null) {
			throw new IOException("Stream Closed");
		} else {
			return this.slack != null?this.slack.length - this.begin:(this.in.ready()?1:0);
		}
	}

	public boolean markSupported() {
		return false;
	}

	public synchronized void reset() throws IOException {
		if(this.in == null) {
			throw new IOException("Stream Closed");
		} else {
			this.slack = null;
			this.in.reset();
		}
	}

	public synchronized void close() throws IOException {
		if(this.in != null) {
			this.in.close();
			this.slack = null;
			this.in = null;
		}

	}
}