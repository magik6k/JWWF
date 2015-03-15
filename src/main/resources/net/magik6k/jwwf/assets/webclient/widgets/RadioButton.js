{
	create: function(data,id){
		var button = new RadioButton(data.group, id, data.label);
		button.select(function(){
			sendSelect(id);
		});
		return {element: button.element, data: button};
	},
	update: function(widget, data){
		//TODO: ?
	}

};//RadioButton end
