{
	create: function(data){
		var elements = []; 
		var elem = $("<div>").addClass("horizontalcontainer");
		
		if(data.align == "middle"){elem.addClass("hpmid");}
		if(data.align == "top"){elem.addClass("hptop");}
		if(data.align == "bottom"){elem.addClass("hpbot");}
		
		for(var i = 0; i < data.content.length; ++i)
		{
			if(data.content[i] < 0)
			{
				elements[i] = {};
				elements[i].elem = $("<div>").addClass("horizontal").css("margin-right", data.spacing);
				
				elements[i].id = -1;
			}
			else
			{
				elements[i] = {};
				elements[i].elem = $("<div>").addClass("horizontal").css("margin-right", data.spacing)
					.html(widgetStorage[data.content[i]].element);
				elements[i].id = data.content[i];
			}
			elem.append(elements[i].elem)
		}
		
		return {element: elem, data: {elements: elements}};
	},
	update: function(widget, data){
	
		if(data.align == "middle"){widget.element.addClass("hpmid");}
		if(data.align == "top"){widget.element.addClass("hptop");}
		if(data.align == "bottom"){widget.element.addClass("hpbottom");}
	
		for(var i = 0; i < data.content.length; ++i)
		{
			
			
			
			if(data.content[i] < 0)continue;//TODO: Is this ok?
			if(data.content[i] == widget.data.elements[i].id)continue;
			
			if(widget.data.elements[i].id > 0){
				widgetStorage[widget.data.elements[i].id].element = $(widgetStorage[widget.data.elements[i].id].element).detach();
			}
			$(widget.data.elements[i].elem).html(widgetStorage[data.content[i]].element);
			widget.data.elements[i].id = data.content[i];						
		}
	}
	
};//HorizontalPanel end
