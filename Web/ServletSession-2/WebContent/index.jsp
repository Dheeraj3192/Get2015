<html>
	<head>
		<title>Registration Form</title>
		<link rel = "stylesheet" href ="./CSS/style.css">
		<script type="text/javascript" src="./JS/session1.js"></script>
	</head>
	<body>
		
		<form id="myform" action="Signin">
			<fieldset>
				<legend>Login</legend>
					<table align ="center">
						<tr>
                    		<td id="error"colspan="2" align="center">${a}
                		</tr>
						<tr>
							<td class="text">User Name *</td> 
							<td><input type="text" id="username"  maxlength="15" placeholder="Enter username" class="field" name="username"></td>
						</tr>
						<tr>
							<td class="text">Password *</td>
							<td><input type="password" id="password"  maxlength="15" placeholder="Enter password" class="field" name="password"></td>
						</tr>
					
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="Create"  onclick="return validate()" class="button">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<a href="signup.jsp">New User..</a>
							</td>
						</tr>
					</table>
				
				</fieldset>
		</form>
		
		
	</body>
</html>