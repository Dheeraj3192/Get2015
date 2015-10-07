
var noOfRows;
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}


function printtable(){
	var table=document.getElementById("inputtable");
	noOfRows = document.getElementById("TotalRow").value*1;
	if( noOfRows <= 0 || noOfRows > 50 ) {
		alert("Please enter rows between 1 to 50  ");
		
	}
	else if (Math.ceil(noOfRows*1) != noOfRows) {
		alert("Please enter rows in integer form ");
		
		
	} else {
		document.getElementById("printbutton").disabled=true;
		document.getElementById("resetbutton").disabled=false;
		var string="<tr><th>Name</th><th> Min </th><th> Max </th></tr>";
		for(i=1; i<=noOfRows; i++) {
			string+="<tr><td><input type='text' id='name"+i+"'></td><td><input type='number' id='min"+i+"' min=0 max=10></td><td><input type='number' id='max"+i+"' min=0 max=10></td></tr>";
		}
		string+="<tr><td colspan='3' align='center'><input type='button' value='ok' onclick='drawTable()'>&nbsp;<input type='Reset' value='Reset' onclick='resetTable()'></td></tr>";
		table.innerHTML=string;
		
	}
}

function resetAll(){
	window.location.reload();
}



function resetTable(){
	
	var table=document.getElementById("displaytable");
	var string="";
	table.innerHTML=string;
	
}

function drawTable(){
	
	var table=document.getElementById("displaytable");
	var string="";
	
		for(i=1;i<=noOfRows;i++){
			
			var name = document.getElementById("name"+i).value.trim();
			var min = document.getElementById("min"+i).value;
			var max = document.getElementById("max"+i).value;
			
		
			if(name == "" || max == "" || min == ""){
				continue;
			}
			else if( max<0 || max>10 || min<0 || min>10 ){
				alert("Enter Input in row "+i+" max value and min value should between 0-10");
				continue;
			}
			else if(max*1<=min){
				alert(""+name+" has Max value less than or equal from Min value");
				continue;
			}	
			
			string+="<tr><td class='name'>"+name+"</td>";
			for(j=0;j<=10;j++){
				
				if( j<max && j>=min ) {
					string+="<td class='red'></td>";
				}
				else {
					string+="<td class='notred'></td>";
				}		
			}
			string+="</tr>";
		}
		if(string == "") {
			alert("Please fill atleast one row ");
		}
		else {
			table.innerHTML=string;
		}
}