{
	create: function(data,id){
		var chButton = new CheckButton(data.label, data.state);
		chButton.oncheck(function(c){sendCheck(id, c)});				
	
		return {element: chButton.element, data: {ch: chButton}};
	},
	update: function(widget, data){
		widget.data.ch.setState(data.state);
		widget.data.ch.setLabel(data.label);
	}
		
};//CheckButton end
