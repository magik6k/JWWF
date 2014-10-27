$(function(){
	socket = new WebSocket(apiServer);
	
	socket.onopen = function()
	{
		$("title").html("JavaWebWidgetFrmework - connected");
	};
	socket.onmessage = function (event) 
	{
		try{
			var data = JSON.parse(event.data);
		}catch(e){
			console.error("Error parsing data:", event.data);
		}
		//console.log(data);
		
		try{
		
			if(data.id < 0)
			{
				if(data.type == "storageSet")
				{
					localStorage.setItem(data.key, data.value);
				}else if(data.type == "storageGet"){
					if(localStorage.getItem(data.key))
						socket.send("U"+data.key+";"+localStorage.getItem(data.key));
				}
			}
			else if(widgetStorage[data.id] == undefined)
			{
				widgetStorage[data.id] = widgets[data.type].create(data.data,data.id);
			}
			else
			{
				widgets[data.type].update(widgetStorage[data.id], data.data);
			}
		
		}catch(e){
			console.error("Error in logic:", e);
		}
	};
	socket.onclose = function()
	{ 
		alert("Connection closed"); 
	};
});

