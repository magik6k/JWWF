{
	create: function(data,id){
		return {element: $("<button>").addClass("btn").addClass("btn-"+data.type).html(data.label)
			.click(function(){sendButton(id);}),data:{id:id}};
	},
	update: function(widget, data) {
		$(widget.element).removeClass(function(i, j) {
			return j.match(/btn-.+/g).join(" ");
		});

		$(widget.element).addClass("btn-"+data.type).html(data.label);
	}
};//Button end
