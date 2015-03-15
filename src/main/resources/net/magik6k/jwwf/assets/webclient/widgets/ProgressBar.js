{
	create: function(data){
		return new ProgressBar(data.progress);
	},
	update: function(widget, data){
		widget.data.update(data.progress);
	}		
};//ProgressBar end
