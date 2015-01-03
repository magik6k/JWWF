 {
	create: function(data){
		return {element: $("<pre>").addClass("jwwfElement").addClass("jwwfPre").html(data.text)};
	},
	update: function(widget, data){
		$(widget.element).html(data.text);
	}
		
};//PreformattedTextLabel end
