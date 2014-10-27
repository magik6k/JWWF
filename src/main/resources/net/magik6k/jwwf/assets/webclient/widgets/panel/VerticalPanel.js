{
	create: function(data){
		var elements = []; 
		var elem = $("<div>").addClass("vcontainer");
		
		for(var i = 0; i < data.content.length; ++i)
		{
			if(data.content[i] < 0)
			{
				elements[i] = {};
				elements[i].elem = $("<div>").css("margin-bottom", data.spacing+"px");
				if(data.align == "middle")elements[i].elem.addClass("horizontallymiddle");
				if(data.align == "right")elements[i].elem.addClass("right");
				elements[i].id = -1;
			}
			else
			{
				elements[i] = {};
				elements[i].elem = $("<div>").css("margin-bottom", data.spacing+"px")
					.html(widgetStorage[data.content[i]].element);
				if(data.align == "middle")elements[i].elem.addClass("horizontallymiddle");
				if(data.align == "right")elements[i].elem.addClass("right");
				elements[i].id = data.content[i];
			}
			elem.append(elements[i].elem)
		}
		
		return {element: elem, data: {elements: elements}};
	},
	update: function(widget, data){
		for(var i = 0; i < data.content.length; ++i)
		{
			if(data.align == "middle"){widget.data.elements[i].elem.removeClass("right").addClass("horizontallymiddle");}
			if(data.align == "right"){widget.data.elements[i].elem.removeClass("horizontallymiddle").addClass("right");}
			if(data.align == "left"){widget.data.elements[i].elem.removeClass("horizontallymiddle").removeClass("right");}
			if(data.content[i] < 0)continue;//TODO: Is this ok?
			if(data.content[i] == widget.data.elements[i].id)continue;
			if(widget.data.elements[i].id > 0){
				widgetStorage[widget.data.elements[i].id].element = $(widgetStorage[widget.data.elements[i].id].element).detach();
			}
			$(widget.data.elements[i].elem).html(widgetStorage[data.content[i]].element);
			widget.data.elements[i].id = data.content[i];						
		}
	}
		
};//VerticalPanel end
