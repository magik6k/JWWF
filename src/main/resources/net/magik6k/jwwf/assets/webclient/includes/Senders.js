function sendButton(id){
	socket.send("B"+id);
}

function sendText(id,text){
	socket.send("T"+id+";"+text);
}

function sendSlide(id,text){
	socket.send("L"+id+";"+text);
}

function sendCheck(id, checked){
	socket.send("C"+id+";"+(checked?"1":"0"));
}

function sendSelect(id){
	socket.send("S"+id+";1");
}
