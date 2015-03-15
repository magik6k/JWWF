var radioGroups = {}

function RadioButton(group, uid, label){
	this.selected = false;
	
	this.isSelected = function(){
		return this.selected;
	}
	
	this.select = function(f) {
		this.onselectfn = f;
	}

	this.setLabel = function(label) {
		this.label = $("<label>").append(this.radio).append(label)
		this.element.addClass("radio").html(label)
	}

	var that = this;
	this.radio = $("<input type=\"radio\" name=\""+group+"\">")
		.change(function(){
			that.selected = $(this).is(':checked')
			if(that.selected) {
				radioGroups[group] = uid;
			}
			
			if(that.selected && typeof that.onselectfn == "function") that.onselectfn();
		});

	this.label = $("<label>").append(this.radio).append(label)
	this.element = $("<div>").addClass("radio").html(this.label)
}

//RadioButton end

