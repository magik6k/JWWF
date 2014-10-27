 {
	create: function(data){
		return {element: $("<pre>").html(data.text)};
	},
	update: function(widget, data){
		$(widget.element).html(data.text);
	}
		
};//PreformattedTextLabel end
