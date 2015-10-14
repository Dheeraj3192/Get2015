

		function activateSubmit() {
			if(document.getElementById("check").checked == true) {
				document.getElementById("submit").disabled = false;
			}
			else {
				document.getElementById("submit").disabled = true;
			}
		}
		
		
		function validate2() {
			var flag = true;
			if(document.getElementById("first").value.trim() == "") {
				flag = false;
				alert("First Name Is Empty");
				return false;
				
			} 
			
			else if(document.getElementById("username").value.trim() == "") {
				flag = false;
				alert("User Name Is Empty");
				return false;
			}
			
			else if(document.getElementById("password").value.length < 4 ){
				flag = false;
				alert("Password Length should be greater than 4");
				return false;
			}
			
			
			else if(document.getElementById("password").value != document.getElementById("confirm").value) {
				flag = false;
				alert("Password & Re-Enter Password  mismatch!!");
				return false;
			}
			
			else if(document.getElementById("email").value.trim() == "") {
				flag = false;
				alert("Email Id Is Empty");
				return false;
			}
			if(flag == true) {
				
				
				return true;
			}
		}
		
	
					
		
		function validate() {
			var flag = true;
			
			if(document.getElementById("username").value.trim() == "") {
				flag = false;
				alert("User Name Is Empty");
				return false;
			}
			
			else if(document.getElementById("password").value.trim() == ""){
				flag = false;
				alert("Password is empty");
				return false;
			}
			
			if(flag == true) {
				
				
				return true;
			}
		}
		
	
		