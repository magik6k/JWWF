var radioGroups = {}

function RadioButton(group, uid){
	this.selected = false;
	
	this.isSelected = function(){
		return this.selected;
	}
	
	this.select = function(f)
	{
		this.onselectfn = f;
	}
	var that = this;
	this.element = $("<div>").addClass("jwwfElement")
		.addClass("radio").html(" ")
		.click(function(){
			if(radioGroups[group] == undefined)
			{
				radioGroups[group] = uid;
				that.selected = true;
			}else if(radioGroups[group] != uid){
				widgetStorage[radioGroups[group]].radio.unselect();
				radioGroups[group] = uid;
				that.selected = true;
			}
			if(that.selected)$(that.element).html("<div class='jwwfElement radiodot'>");
			else $(that.element).html(" ");
			
			if(that.selected&&typeof that.onselectfn == "function")that.onselectfn();
		});
	
	this.unselect = function(){
		this.selected = false;
		$(this.element).html(" ");
	}
}

//RadioButton end

