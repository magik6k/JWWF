{
	create: function(data,id){
		var snd = 0;
		
		var elem = $("<input>").addClass("form-control").attr("type","range")
			.attr("min", data.min)
			.attr("max", data.max)
			.on("input change propertychange",function(){ 
					clearTimeout(snd);
					snd = setTimeout(function(){
						sendSlide(id,$(elem).val());
					},250);
				});
		if(data.text)$(elem).val(data.text);
		return {element: elem};
	},
	update: function(widget, data){
		if(data.text)$(widget.element).val(data.text);
		$(widget.element).attr("placeholder", data.placeholder);
	}
		
};//TextInput end
