{
	create: function(data){
		return {element: $("<img>").addClass("jwwfElement").addClass("jwwfImg").attr("src",data.url)
			.css("width",data.size[0]<0?"auto":(data.size[0]+"px"))
			.css("height",data.size[1]<0?"auto":(data.size[1]+"px"))
			.attr("alt",data.alt?data.alt:"[Loading..]")};
	},
	update: function(widget, data){
		$(widget.element).attr("src",data.url)
			.css("width",data.size[0]<0?"auto":(data.size[0]+"px"))
			.css("height",data.size[1]<0?"auto":(data.size[1]+"px"));
	}
		
};//Image end
