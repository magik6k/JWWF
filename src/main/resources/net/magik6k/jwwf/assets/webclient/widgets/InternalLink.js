{
	create: function(data,id){
		return {element: $("<a>").html(data.label)
			.attr("href","javascript:void(0);").click(function(){sendButton(id);}),data:{id:id}};
	},
	update: function(widget, data){
		$(widget.element).html(data.label);
	}
		
};//InternalLink end
