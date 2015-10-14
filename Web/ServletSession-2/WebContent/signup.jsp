<html>
	<head>
		<title>Registration Form</title>
		<link rel = "stylesheet" type = "text/css" href ="./CSS/style.css">
		<script type="text/javascript" src="./JS/session1.js"></script>
	</head>
	<body>
		
		<form id="myform" action="signup">
			<fieldset>
				<legend>Registration</legend>
					<table align ="center">
						<tr>
                    		<td id="error"colspan="2" align="center">${a}
                		</tr>
						<tr>
							<td class="text">Name *</td> 
							<td><input type="text" id="first"  maxlength="15" placeholder="Enter name" class="field" name="name"></td>
						</tr>
						<tr>
							<td class="text">User Name *</td> 
							<td><input type="text" id="username"  maxlength="15" placeholder="Enter username" class="field" name="username"></td>
						</tr>
						<tr>
							<td class="text">Password *</td>
							<td><input type="password" id="password"  maxlength="15" placeholder="Enter password min 4" class="field" name="password"></td>
						</tr>
						<tr>
							<td class="text">Re-Enter Password *</td>
							<td><input type="password" id="confirm"   maxlength="15"  placeholder="Re enter password" class="field"></td>
						</tr>
						<tr>
							<td class="text">Enter Your Email Id *</td>
							<td><input type="email" id="email"   maxlength="30"  placeholder="Enter mail ID" class="field" name="email"></td>
						</tr>
						<tr>
							
							<td colspan="2" align="center">
								<input type="checkbox" id="check" onChange="activateSubmit()" class="fieldcheck">
								<label for="check">I Accept All </label><a href="#">Terms & Condition</a>
							</td>
						</tr>
						
						
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="Create" id="submit" onclick="return validate2()" disabled class="button">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<a href="index.jsp">Go to Login..</a>
							</td>
						</tr>
					</table>
				
				</fieldset>
		</form>
		
		
	</body>
</html>