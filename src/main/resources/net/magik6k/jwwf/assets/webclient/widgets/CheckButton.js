{
	create: function(data,id){
		var chButton = new CheckButton(data.label);
		chButton.oncheck(function(c){sendCheck(id, c)});				
	
		return {element: chButton.element, data: {ch: chButton}};
	},
	update: function(widget, data){
		//TODO: ?
		widget.data.ch.setLabel(data.label);
	}
		
};//CheckButton end
