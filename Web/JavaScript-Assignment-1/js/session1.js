
				
	
		
		function activateSubmit() {
			if(document.getElementById("check").checked == true) {
				document.getElementById("submit").disabled = false;
			}
			else {
				document.getElementById("submit").disabled = true;
			}
		}
		function validate() {
			var count = 0;
			if(document.getElementById("first").value.trim() == "") {
				count++;
				alert("First Name Is Empty");
			
				
			} 
			
			if(document.getElementById("last").value.trim() == "") {
				count++
				alert("Last Name Is Empty");
				
			}
			
			if(document.getElementById("password").value.length < 8 ){
				count++;
				alert("Password Length should be greater than 8");
				
			}
			
			
			if(document.getElementById("password").value != document.getElementById("confirm").value) {
				count++;
				alert("Password & Re-Enter Password  mismatch!!");
				
			}
			
			if(document.getElementById("age").value< 10 ||document.getElementById("age").value >100 ){
				count++;
				alert("age  should between 18 and 100");
				
			}
			if(document.getElementById("state").selectedIndex == 0) {
				count++;
				alert("Please select state") ;
				
			}
			if(document.getElementById("address").value.trim() == "") {
				count++
				alert("address Is Empty");
				
			}
			if(count==0) {
				
				
				alert("Form successfully submitted");
			}
			}
		
		function createCity() {
			var cityObject = document.getElementById("city");
			var stateObject = document.getElementById("state");
			switch(stateObject.value) {
				case "Rajsthan" :
					cityObject.innerHTML = "<Option>Jaipur</option><Option>Bikaner</option><Option>Kota</option><Option>Ajmer</option>";
					break;
				case "MP" :
					cityObject.innerHTML = "<Option>Bilaspur</option><Option>Bhopal</option><Option>Gwalior</option><Option>Mandi</option>";
					break;
				case "UP" :
					cityObject.innerHTML = "<Option>Agra</option><Option>Kanpur</option><Option>Aligarh</option><Option>Mathura</option>";
					break;
				case "Maharastra":
					cityObject.innerHTML = "<Option>Mumbai</option><Option>Pune</option><Option>Aurangabad</option><Option>Thane</option>";
					break;
			}
		}
	
		