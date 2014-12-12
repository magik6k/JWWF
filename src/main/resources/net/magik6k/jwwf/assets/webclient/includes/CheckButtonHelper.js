function CheckButton(label, selected){
	this.checked = false;
	this.label = label;
	if(selected == true)
	{
		this.checked = true;
	}
	
	this.isChecked = function(){
		return this.checked;
	}
	
	this.setLabel = function(label){
		this.label = label;
		this.element.html(this.label);
	}
	
	this.oncheck = function(f)
	{
		this.oncheckfn = f;
	}
	var that = this;
	this.element = $("<div>").addClass("checkbutton").html(this.label)
		.click(function(){
			that.checked=!that.checked;
			if(that.checked)$(that.element).addClass("checkbuttonchecked");
			else $(that.element).removeClass("checkbuttonchecked")
			
			if(typeof that.oncheckfn == "function")that.oncheckfn(that.checked);
		});
	
}

