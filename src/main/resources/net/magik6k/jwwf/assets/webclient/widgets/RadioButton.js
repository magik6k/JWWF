{
	create: function(data,id){					
		var button = new RadioButton(data.group, id);
		button.select(function(){
			sendSelect(id);
		});
		return {element: button.element, radio: button};
		
	},
	update: function(widget, data){
		//TODO: ?
	}
		
};//RadioButton end
