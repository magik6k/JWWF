{
	create: function(data) {
		var elements = [];
		var elem = $("<div>").addClass("col-md-"+data.width)

		for(var i = 0; i < data.content.length; ++i) {
			if(data.content[i] < 0) {
				elements[i] = {};
				elements[i].elem = $("<div>")

				elements[i].id = -1;
			} else {
				elements[i] = {};
				elements[i].elem = widgetStorage[data.content[i]].element
				elements[i].id = data.content[i];
			}
			elem.append(elements[i].elem)
		}

		return {element: elem, data: {width: data.width, elements: elements}};
	},
	update: function(widget, data) {
		if(widget.data.width != data.width) {
			widget.element.removeClass(function(i, j) {
				return j.match(/col-md-/g).join(" ");
			});
			widget.element.addClass("col-md-"+data.width)
		}
		for(var i = 0; i < data.content.length; ++i) {
			if(data.content[i] < 0)continue;//TODO: Is this ok?
			if(data.content[i] == widget.data.elements[i].id)continue;

			if(widget.data.elements[i].id > 0) {
				widgetStorage[widget.data.elements[i].id].element = $(widgetStorage[widget.data.elements[i].id].element).detach();
			}

			if(i === 0) {
				$(widget.element).prepend(widgetStorage[data.content[i]].element);
			} else {
				$(widget.element).children().eq(i - 1).after(widgetStorage[data.content[i]].element);
			}
			//$(widget.data.elements[i].elem).html(widgetStorage[data.content[i]].element);
			widget.data.elements[i].id = data.content[i];
		}
	}
};//Row end