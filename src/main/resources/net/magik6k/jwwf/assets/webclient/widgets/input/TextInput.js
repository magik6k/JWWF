{
	create: function(data,id){
		if(data.type=="danger")data.type="error"
		var snd = 0;
		
		var input = $("<input>").addClass("form-control").attr("type","text")
			.attr("placeholder", data.placeholder)
			.on("keypress",function(){ 
					clearTimeout(snd);
					snd = setTimeout(function(){
						sendText(id,$(input).val());
					},250);
				});
		if(data.text)
			input.val(data.text);

		var container = $("<div>")
			.addClass("form-group")
			.addClass("has-feedback")
			.addClass("has-" + data.type)

		container.append("<label class=\"control-label sr-only\"></label>")
			.append(input)

		if(data.type == "success") container.append("<span class=\"glyphicon glyphicon-ok form-control-feedback\"></span>")
		if(data.type == "warning") container.append("<span class=\"glyphicon glyphicon-warning-sign form-control-feedback\"></span>")
		if(data.type == "error") container.append("<span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>")

		return {element: container, data: {input: input}};
	},
	update: function(widget, data){
		if(data.type=="danger")data.type="error"
		if(data.text)$(widget.data.input).val(data.text);
		$(widget.data.input).attr("placeholder", data.placeholder);

		$(widget.element).removeClass(function(i, j) {
			return j.match(/has-(?!feedback)\w+/g).join(" ");
		});

		$(widget.element).addClass("has-"+data.type).html(data.label);

		if(widget.element.children().last().is("span"))
			widget.element.children().last().remove()

		if(data.type == "success") widget.element.append("<span class=\"glyphicon glyphicon-ok form-control-feedback\"></span>")
		if(data.type == "warning") widget.element.append("<span class=\"glyphicon glyphicon-warning-sign form-control-feedback\"></span>")
		if(data.type == "error") widget.element.append("<span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>")
	}

};//TextInput end
