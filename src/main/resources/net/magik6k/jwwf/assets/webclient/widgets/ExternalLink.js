{
	create: function(data){
		return {element: $("<a>").addClass("jwwfElement").addClass("jwwfA").html(data.label).attr("href", data.url)};
	},
	update: function(widget, data){
		$(widget.element).html(data.label).attr("href", data.url);
	}
		
};//ExternalLink end
