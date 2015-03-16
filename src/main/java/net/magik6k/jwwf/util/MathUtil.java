package net.magik6k.jwwf.util;

public class MathUtil {
	public static double scale(double inMin, double inMax, double outMin, double outMax, double in) {
		return ((outMax - outMin) * ((in - inMin) / inMax)) + outMin;
	}
}
