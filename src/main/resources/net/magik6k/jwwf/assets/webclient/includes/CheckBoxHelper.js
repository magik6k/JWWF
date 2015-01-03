function CheckBox(selected){
	this.checked = false;
	
	if(selected == true)
	{
		this.checked = true;
	}
	
	this.isChecked = function(){
		return this.checked;
	}
	
	this.oncheck = function(f)
	{
		this.oncheckfn = f;
	}
	
	this.setState = function(state)
	{
		this.checked = state;
		if(this.checked)$(that.element).html("<div class='check'>").addClass("jwwfElement");
		else $(this.element).html(" ");
	}
	
	var that = this;
	this.element = $("<div>").addClass("jwwfElement").addClass("checkbox").html(" ")
		.click(function(){
			that.checked=!that.checked;
			if(that.checked)$(that.element).html("<div class='check jwwfElement'>");
			else $(that.element).html(" ");
			
			if(typeof that.oncheckfn == "function")that.oncheckfn(that.checked);
		});
	
}

