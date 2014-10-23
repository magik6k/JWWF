{
	create: function(data){
		return {element: $("<span>").html(data.text)};
	},
	update: function(widget, data){
		$(widget.element).html(data.text);
	}
};//TextLabel end
