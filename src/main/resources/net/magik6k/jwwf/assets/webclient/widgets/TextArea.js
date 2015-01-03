{
	create: function(data,id){
		var snd = 0;
		
		var elem = $("<textarea>").addClass("jwwfElement").addClass("jwwfTextarea").attr("type","text")
			.attr("placeholder", data.placeholder)
			.attr("cols",data.cols)
			.attr("rows",data.rows)
			.on("keypress",function(){ 
					clearTimeout(snd);
					snd = setTimeout(function(){
						sendText(id,$(elem).val());
					},250);
				});
		if(data.text)$(elem).val(data.text);
		return {element: elem};
	},
	update: function(widget, data){
		if(data.text)$(widget.element).val(data.text);
		$(widget.element).attr("placeholder", data.placeholder)
			.attr("cols",data.cols)
			.attr("rows",data.rows);
	}
		
};//TextArea end
