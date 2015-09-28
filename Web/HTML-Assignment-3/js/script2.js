
<!--Get current  position by geo location-->
function getLocation()
{
	var x = document.getElementById("findLocation");
    if (navigator.geolocation) 
    {
    	<!-- finds the position and returns it-->
        navigator.geolocation.getCurrentPosition(showPosition);
    }
    else
    { 
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

<!-- Position used and divided into Latitude and Longitude-->
function showPosition(position) 
{
	var x = document.getElementById("findLocation");
    x.innerHTML = "Latitude: " + position.coords.latitude + 
    "<br>Longitude: " + position.coords.longitude;	
}
