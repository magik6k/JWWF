{
	create: function(data,id){
		var chBox = new CheckBox(data.state);
		chBox.oncheck(function(c){sendCheck(id, c)});				
	
		return {element: chBox.element,data:{ch:chBox}};
	},
	update: function(widget, data){
		widget.data.ch.setState(data.state)
	}
		
};//CheckBox end
