global["JWWF-storageSet"] = function(data){
	localStorage.setItem(data.key, data.value);
}

global["JWWF-storageGet"] = function(data){
	if(localStorage.getItem(data.key))
		socket.send("U"+data.key+";"+localStorage.getItem(data.key));
	else
		socket.send("U"+data.key+";");
}
