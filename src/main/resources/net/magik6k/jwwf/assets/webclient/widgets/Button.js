{
	create: function(data,id){
		return {element: $("<button>").addClass("jwwfElement").addClass("jwwfButton").html(data.label)
			.click(function(){sendButton(id);}),data:{id:id}};
	},
	update: function(widget, data){
		$(widget.element).html(data.label);
	}
		
};//Button end
