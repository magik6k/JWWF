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
		
			if(data.id < 0 && data.type == "global")
			{
				global[data.handler](data.data)
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
		$("body").html("<h2>Connection to service has been closed</h2><small>Powered by Java Web Widget Framework</small>");
	};
});

