{
	create: function(data){
		if(data.content < 0)
			return {element: $("<div>").css({left:data.x,top:data.y})};
		
		var elem = $("<div>").html(widgetStorage[data.content].element)
			.css({left:data.x,top:data.y}).addClass("fixedPanel");
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
};//FixedPanel end
