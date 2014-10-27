{
	create: function(data){
		return {element: $("<a>").html(data.label).attr("href", data.url)};
	},
	update: function(widget, data){
		$(widget.element).html(data.label).attr("href", data.url);
	}
		
};//ExternalLink end
