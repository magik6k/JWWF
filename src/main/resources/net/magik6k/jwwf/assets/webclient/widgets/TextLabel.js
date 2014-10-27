{
	create: function(data){
		return {element: $("<span>").html(data.text).css("white-space", data.nowrap ? "nowrap" : "normal")};
	},
	update: function(widget, data){
		$(widget.element).html(data.text).css("white-space", data.nowrap ? "nowrap" : "normal");
	}
};//TextLabel end
