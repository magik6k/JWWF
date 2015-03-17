{
	create: function(data){
		return new ProgressBar(data.progress, data.type);
	},
	update: function(widget, data){
		widget.data.update(data.progress, data.type);
	}		
};//ProgressBar end
