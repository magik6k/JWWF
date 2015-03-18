{
	create: function(data) {
		var elements = [];
		var body = $("<div>").addClass("panel-body")

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
			body.append(elements[i].elem)
		}
		var heading = $("<div>").addClass("panel-heading").html(data.name)
		var elem = $("<div>").addClass("panel").addClass("panel-"+data.type)
			.append(heading).append(body)
		return {element: elem, data: {body: body, elements: elements}};
	},
	update: function(widget, data) {
		widget.element.removeClass(function(i, j) {
			return j.match(/panel-/g).join(" ");
		});
		widget.element.addClass("panel-"+data.type)

		for(var i = 0; i < data.content.length; ++i) {
			if(data.content[i] < 0)continue;//TODO: Is this ok?
			if(data.content[i] == widget.data.elements[i].id)continue;

			if(widget.data.elements[i].id > 0) {
				widgetStorage[widget.data.elements[i].id].element = $(widgetStorage[widget.data.elements[i].id].element).detach();
			}

			if(i === 0) {
				$(widget.data.body).prepend(widgetStorage[data.content[i]].element);
			} else {
				$(widget.data.body).children().eq(i - 1).after(widgetStorage[data.content[i]].element);
			}
			//$(widget.data.elements[i].elem).html(widgetStorage[data.content[i]].element);
			widget.data.elements[i].id = data.content[i];
		}
	}
};//Row end