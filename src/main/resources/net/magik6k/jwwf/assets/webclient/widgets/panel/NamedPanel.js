{
	create: function(data) {
		var element;
		var body = $("<div>").addClass("panel-body")

		if(data.content < 0) {
			element = {};
			element.elem = $("<div>")

			element.id = -1;
		} else {
			element = {};
			element.elem = widgetStorage[data.content].element
			element.id = data.content;
		}
		body.html(element.elem)

		var heading = $("<div>").addClass("panel-heading").html(data.name)
		var elem = $("<div>").addClass("panel").addClass("panel-"+data.type)
			.append(heading).append(body)
		return {element: elem, data: {body: body, element: element}};
	},
	update: function(widget, data) {
		widget.element.removeClass(function(i, j) {
			return j.match(/panel-/g).join(" ");
		});
		widget.element.addClass("panel-"+data.type)

		if(data.content < 0) return;//TODO: Is this ok?
		if(data.content == widget.data.element.id) return;

		if(widget.data.element.id > 0) {
			widgetStorage[widget.data.element.id].element = $(widgetStorage[widget.data.element.id].element).detach();
		}

		$(widget.data.body).html(widgetStorage[data.content].element);
		widget.data.elements[i].id = data.content[i];

	}
};//Row end