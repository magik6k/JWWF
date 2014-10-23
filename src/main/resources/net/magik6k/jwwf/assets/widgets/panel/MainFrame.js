{
	create: function(data){
		if(data.content < 0)
			return {element: $("body")};
		
		$("body").html(widgetStorage[data.content].element);
		return {element: $("body"), data:{id: data.content}};
	},
	update: function(widget, data){
		if(widget.data!=undefined&&widget.data.id > 0)
		{
			widgetStorage[data.id].element = $(widgetStorage[data.id].element).detach();
		}
		if(data.content < 0)
		{
			$("body").html("");
		}
		else
		{						
			$("body").html(widgetStorage[data.content].element);
		}
	}
};//MainFrame end
