package rest;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class RESTServicesConsumer {

static final String USERNAME = "dheerajkumar1@metacube.com";
static final String PASSWORD = "Dheeraj#1230FNh1oulvOvL260WNhnEK0bg";
static final String LOGINURL = "https://login.salesforce.com";
static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
static final String CLIENTID = "3MVG9ZL0ppGP5UrAv__KjlDHYc_wbYMgijmdv7hRSGJ67FlK2CwbMYzX0LrOCGXwEjfI6hy9Un.NfQTZ9Q9yU";
static final String CLIENTSECRET = "2198511896896844526";
private static String REST_ENDPOINT = "/services/apexrest";
private static String baseUri;
private static String loginAccessToken;
private static String loginInstanceUrl;

public static void main(String[] args) throws ParseException, IOException {

	JSONObject authJsonObject = null;
	try {
		authJsonObject = OAuthServlet.oAuthSessionProvider(LOGINURL, USERNAME, PASSWORD,CLIENTID, CLIENTSECRET);
		loginAccessToken = authJsonObject.getString("access_token");
		loginInstanceUrl = authJsonObject.getString("instance_url");
	} catch (JSONException e) {
		e.printStackTrace();
	}
	baseUri = loginInstanceUrl + REST_ENDPOINT;
	System.out.println("Successful login");
	System.out.println("access token/session ID: " + loginAccessToken);
	System.out.println("baseUri: " + baseUri);
	queryContacts();
	createStudents();
}

public static void createStudents() {
	System.out.println("\n_______________ Student INSERT _______________");

	String uri = baseUri +"/insertstudent" ;
	Client client = Client.create();
	WebResource webResource = client.resource(uri);
	WebResource.Builder builder = webResource.header("Authorization", "OAuth "+ loginAccessToken);
	JSONObject student = new JSONObject();
	try {
		student.put("name", "test rest");
		student.put("firstName", "Web");
		student.put("lastName","Service");
		student.put("className", "10th");
	} catch (JSONException e1) {
		e1.printStackTrace();
	}
	ClientResponse response = builder.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, student.toString());
	String output = response.getEntity(String.class);
	System.out.println("Student is "+output);
	try {
		JSONObject jsonObject = new JSONObject(output);
		System.out.println("Student inserted  "+jsonObject.toString(2));
		System.out.println("student id is "+jsonObject.getString("Id"));
	} catch (JSONException e) {
		e.printStackTrace();
	}
}
	public static void queryContacts() {
		String uri = baseUri + "/getcontacts?name=dheeraj";
		Client client = Client.create();
		WebResource webResource = client.resource(uri);
		System.out.println("Login Access token"+loginAccessToken);
		WebResource.Builder builder = webResource.header("Authorization", "OAuth "+ loginAccessToken);
		ClientResponse response = builder.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		JSONObject jsonObject= null;
		try {
			 jsonObject = new JSONObject(output);
			 System.out.println("Contact is "+jsonObject.toString(2));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	
	}
	  
}
