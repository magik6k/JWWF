{
	create: function(data){
		return new ProgressBar(data.width, data.progress);
	},
	update: function(widget, data){
		widget.data.update(data.width, data.progress);
	}		
};//ProgressBar end
