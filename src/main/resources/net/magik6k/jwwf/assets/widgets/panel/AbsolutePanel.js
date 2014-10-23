{
	create: function(data){
		var elem = $("<div>").css("position","relative");
	
		if(data.content < 0)
		{
			var content = $("<div>").css({left:data.x,top:data.y});
			$(elem).html(content);
			return {element: elem, data:{content:content}};
		}
		
		var content = $("<div>").html(widgetStorage[data.content].element)
			.css({left:data.x,top:data.y}).addClass("absolutePanel");
		$(elem).html(content);
		
		return {element: elem, data: {id: data.content}};
	},
	update: function(widget, data){
		if(widget.data.id > 0)
		{
			widgetStorage[widget.data.id].element = $(widgetStorage[widget.data.id].element).detach();
		}
		if(data.content < 0)
		{
			$(widget.element).html("").css({left:data.x,top:data.y});
		}
		else
		{
			$(widget.element).html(widgetStorage[data.content].element)
				.css({left:data.x,top:data.y});
		}
	}
};//AbsolutePanel end
