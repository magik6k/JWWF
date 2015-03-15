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
	
	this.setState = function(state)
	{
		this.checked = state;
		if(that.checked)$(that.element).addClass("active");
		else $(that.element).removeClass("active")
	}
	
	this.oncheck = function(f)
	{
		this.oncheckfn = f;
	}
	var that = this;
	this.element = $("<div>").addClass("btn").addClass("btn-default").html(this.label)
		.click(function(){
			that.checked=!that.checked;
			if(that.checked)$(that.element).addClass("active");
			else $(that.element).removeClass("active")
			
			if(typeof that.oncheckfn == "function")that.oncheckfn(that.checked);
		});
	
}

