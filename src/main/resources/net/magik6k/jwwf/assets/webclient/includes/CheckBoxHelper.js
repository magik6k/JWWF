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
	var that = this;
	this.element = $("<div>").addClass("checkbox").html(" ")
		.click(function(){
			that.checked=!that.checked;
			if(that.checked)$(that.element).html("<div class='check'>");
			else $(that.element).html(" ");
			
			if(typeof that.oncheckfn == "function")that.oncheckfn(that.checked);
		});
	
}

