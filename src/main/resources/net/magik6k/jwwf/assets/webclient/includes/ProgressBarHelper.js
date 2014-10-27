function ProgressBar(width, progress){
	var pBar = $("<div>").addClass("progressBar").width(progress+"%");
	this.element = $("<div>").addClass("progressContainer").width(width+"px").html(pBar);
	this.data = this;
	this.update = function(width, progress){
		pBar.width(progress+"%");
		this.element.width(width+"px");
	}
}//ProgressBar end

