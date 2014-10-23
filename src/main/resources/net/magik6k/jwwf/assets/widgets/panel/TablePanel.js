{
	create: function(data){
		var rows = []; 
		var elem = $("<table>");
		
		for(var i = 0; i < data.content.length; ++i)
		{
			rows[i] = {}
			rows[i].elem = $("<tr>");
			rows[i].cells = []
			for(var j = 0; j < data.content[i].length; ++j)
			{
				if(data.content[i][j] < 0)
				{
					var cell = $("<td>").css("padding-right",data.hspace+"px")
							.css("padding-bottom",data.vspace+"px");
					
					if(data.align == "topleft")		cell.addClass("tatl");
					if(data.align == "top")			cell.addClass("tatc");
					if(data.align == "topright")	cell.addClass("tatr");
					if(data.align == "middleleft")	cell.addClass("taml");
					if(data.align == "middle")		cell.addClass("tamc");
					if(data.align == "middleright")	cell.addClass("tamr");
					if(data.align == "bottomleft")	cell.addClass("tabl");
					if(data.align == "bottom")		cell.addClass("tabc");
					if(data.align == "bottomright")	cell.addClass("tabr");
					
					rows[i].cells[j] = {};
					rows[i].cells[j].elem = cell;
					rows[i].cells[j].id = -1;
					$(rows[i].elem).append(cell);
				}
				else
				{
					var cell = $("<td>").html(widgetStorage[data.content[i][j]].element)
							.css("padding-right",(j+1<data.content[i].length?data.hspace:0)+"px")
							.css("padding-bottom",(i+1<data.content.length?data.vspace:0)+"px")
					
					if(data.align == "topleft")		cell.addClass("tatl");
					if(data.align == "top")			cell.addClass("tatc");
					if(data.align == "topright")	cell.addClass("tatr");
					if(data.align == "left")		cell.addClass("taml");
					if(data.align == "middle")		cell.addClass("tamc");
					if(data.align == "right")		cell.addClass("tamr");
					if(data.align == "bottomleft")	cell.addClass("tabl");
					if(data.align == "bottom")		cell.addClass("tabc");
					if(data.align == "bottomright")	cell.addClass("tabr");
					
					rows[i].cells[j] = {};
					rows[i].cells[j].elem = cell;
					rows[i].cells[j].id = data.content[i][j];
					$(rows[i].elem).append(cell);
				}
			}
			elem.append(rows[i].elem);
		}
		
		return {element: elem, data: {rows: rows}};
	},
	update: function(widget, data){
		for(var i = 0; i < data.content.length; ++i)
		{
			for(var j = 0; j < data.content[i].length; ++j)
			{
				if(data.content[i][j] < 0)
				{
					widget.data.rows[i].cells[j].elem.html("");
				}else{
					if(widget.data.rows[i].cells[j].id > 0 && widget.data.rows[i].cells[j].id != data.content[i][j]){
						widgetStorage[widget.data.rows[i].cells[j].id].element 
							= $(widgetStorage[widget.data.rows[i].cells[j].id].element).detach();
					}
					
					if(widget.data.rows[i].cells[j].id != data.content[i][j])
					{
						widget.data.rows[i].cells[j].elem.html(widgetStorage[data.content[i][j]].element);
						widget.data.rows[i].cells[j].id = data.content[i][j];
					}
					
					if(data.align == "topleft")		widget.data.rows[i].cells[j].elem.addClass("tatl");
					if(data.align == "top")			widget.data.rows[i].cells[j].elem.addClass("tatc");
					if(data.align == "topright")	widget.data.rows[i].cells[j].elem.addClass("tatr");
					if(data.align == "left")		widget.data.rows[i].cells[j].elem.addClass("taml");
					if(data.align == "middle")		widget.data.rows[i].cells[j].elem.addClass("tamc");
					if(data.align == "right")		widget.data.rows[i].cells[j].elem.addClass("tamr");
					if(data.align == "bottomleft")	widget.data.rows[i].cells[j].elem.addClass("tabl");
					if(data.align == "bottom")		widget.data.rows[i].cells[j].elem.addClass("tabc");
					if(data.align == "bottomright")	widget.data.rows[i].cells[j].elem.addClass("tabr");
				}
			}
		}
	}
		
};//TablePanel end
