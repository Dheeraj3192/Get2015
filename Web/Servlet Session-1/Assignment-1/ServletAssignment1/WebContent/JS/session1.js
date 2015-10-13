function activateSubmit() {
	if (document.getElementById("check").checked == true) {
		document.getElementById("submit").disabled = false;
	} else {
		document.getElementById("submit").disabled = true;
	}
}

function createCity() {
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("state");
	switch (stateObject.value) {
	case "Select State":
		cityObject.innerHTML = "<option>Select City</option>";
		break;
	case "Rajsthan":
		cityObject.innerHTML = "<Option>Jaipur</option><Option>Bikaner</option><Option>Kota</option><Option>Ajmer</option>";
		break;
	case "MP":
		cityObject.innerHTML = "<Option>Bilaspur</option><Option>Bhopal</option><Option>Gwalior</option><Option>Mandi</option>";
		break;
	case "UP":
		cityObject.innerHTML = "<Option>Agra</option><Option>Kanpur</option><Option>Aligarh</option><Option>Mathura</option>";
		break;
	case "Maharastra":
		cityObject.innerHTML = "<Option>Mumbai</option><Option>Pune</option><Option>Aurangabad</option><Option>Thane</option>";
		break;
	}
}
