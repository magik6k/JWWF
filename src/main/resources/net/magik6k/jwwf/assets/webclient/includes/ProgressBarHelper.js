function ProgressBar(progress){
	var bar = $("<div>").addClass("progress-bar")
		.attr("role", "progressbar")
		.attr("aria-valuenow", progress)
		.css('width', progress+'%')
		.attr("aria-valuemin", "0")

	this.element = $("<div>").addClass("progress").html(bar);
	this.data = this;
	this.update = function(progress){
		bar.css('width', progress+'%').attr("aria-valuenow", progress)
	}
}//ProgressBar end

