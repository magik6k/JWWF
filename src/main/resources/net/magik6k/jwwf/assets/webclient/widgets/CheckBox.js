{
	create: function(data,id){
		var chBox = new CheckBox();
		chBox.oncheck(function(c){sendCheck(id, c)});				
	
		return {element: chBox.element};
	},
	update: function(widget, data){
		//TODO: ?
	}
		
};//CheckBox end
