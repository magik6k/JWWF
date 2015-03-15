function CheckBox(selected, label){
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
	
	this.setState = function(state, label)
	{
		this.checked = state;
		this.checkbox.prop('checked', state);
		this.label.html("").append(this.checkbox).append(label)
	}
	
	var that = this;
	this.checkbox = $("<input type=\"checkbox\">")
		.change(function() {
			that.checked=this.checked;
			if(typeof that.oncheckfn == "function")that.oncheckfn(that.checked);
		});

	this.label = $("<label>").append(this.checkbox).append(label)
	this.element = $("<div>").addClass("checkbox").html(this.label)
}

