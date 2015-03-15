{
	create: function(data){
		document.title = data.title;
		if(data.content < 0)
			return {element: $("#mainContainer")};
		
		$("#mainContainer").html(widgetStorage[data.content].element);
		return {element: $("#mainContainer"), data:{id: data.content}};
	},
	update: function(widget, data){
		document.title = data.title;
		if(widget.data!=undefined&&widget.data.id > 0)
		{
			widgetStorage[data.id].element = $(widgetStorage[data.id].element).detach();
		}
		if(data.content < 0)
		{
			$("#mainContainer").html("");
		}
		else
		{						
			$("#mainContainer").html(widgetStorage[data.content].element);
		}
	}
};//MainFrame end
