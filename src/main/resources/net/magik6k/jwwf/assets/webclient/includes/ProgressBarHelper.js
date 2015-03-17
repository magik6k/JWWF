function ProgressBar(progress, type){
	var bar = $("<div>").addClass("progress-bar")
		.addClass("progress-bar-" + type)
		.attr("role", "progressbar")
		.attr("aria-valuenow", progress)
		.css('width', progress+'%')
		.attr("aria-valuemin", "0")

	this.element = $("<div>").addClass("progress").html(bar);
	this.data = this;
	this.update = function(progress, type){
		bar.css('width', progress+'%').attr("aria-valuenow", progress)

		bar.removeClass(function(i, j) {
		console.log(j);
			return j.match(/progress-bar-.+/g).join(" ");
		});

		bar.addClass("progress-bar-" + type)
	}
}//ProgressBar end

