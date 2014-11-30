{
	create: function(data, id){
		var elements = [];
		var actSel = 0;
		var elem = $("<div>");
		
		var switcher = $("<div>");
		var container = $("<div>").addClass("tabcontainer");
		
		function setCallback(i, elem)
		{
			$(elem).click(function(){
					if(elements[actSel].id >= 0)
						elements[actSel].elem = $(elements[actSel].elem).detach();
					
					actSel = i;
					container.html(elements[i].elem);
					$(".tabsw" + id).removeClass("tabswsel");
					$(this).addClass("tabswsel");
				});
		}
		
		for(var i = 0; i < data.content.length; ++i)
		{
			if(data.content[i].widget < 0)
			{
				elements[i] = {};
				elements[i].elem = $("<div>");
				elements[i].id = -1;
				
				var sw = $("<a>").html(data.content[i].name)
					.addClass("tabswitch").addClass("tabsw" + id);
				setCallback(i, sw);
				switcher.append(sw);
			}
			else
			{
				elements[i] = {};
				elements[i].elem = $("<div>")
					.html(widgetStorage[data.content[i].widget].element);
				elements[i].id = data.content[i].widget;
				
				elements[i].button = $("<a>").html(data.content[i].name)
					.addClass("tabswitch").addClass("tabsw" + id);;
				setCallback(i, elements[i].button);
				switcher.append(elements[i].button);
			}
		}
		container.html(elements[0].elem);
		elements[0].button.addClass("tabswsel");
		actSel = 0;
		elem.append(switcher);
		elem.append(container);
		return {element: elem, data: {elements: elements}};
	},
	update: function(widget, data){
		for(var i = 0; i < data.content.length; ++i)
		{			
			if(data.content[i] == widget.data.elements[i].id)continue;
			if(widget.data.elements[i].id >= 0){
				widgetStorage[widget.data.elements[i].id].element = $(widgetStorage[widget.data.elements[i].id].element).detach();
			}
			if(data.content[i] < 0)continue;			
			$(widget.data.elements[i].elem).html(widgetStorage[data.content[i].widget].element);
			widget.data.elements[i].id = data.content[i].widget;						
		}
	}
		
};//TabbedPanel end
