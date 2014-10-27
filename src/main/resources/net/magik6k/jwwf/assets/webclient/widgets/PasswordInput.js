{
	create: function(data,id){
		var snd = 0;
		
		var elem = $("<input>").attr("type","password")
			.attr("placeholder", data.placeholder)
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
		$(widget.element).attr("placeholder", data.placeholder);
	}
		
};//PasswordInput end
