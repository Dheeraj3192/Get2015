package rest;

import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.commons.httpclient.HttpException;
import org.json.JSONException;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class OAuthServlet {

	public static JSONObject oAuthSessionProvider(String loginHost, String username, String password, String clientId, String secret)
			throws HttpException, IOException, JSONException {

		String tokenUrl = loginHost + "/services/oauth2/token";
		Client client = Client.create();
		WebResource webResource = client.resource(tokenUrl);
		MultivaluedMap<String,String> formData = new MultivaluedMapImpl();
		formData.add("grant_type", "password");
		formData.add("client_id", clientId);
		formData.add("client_secret",secret);
		formData.add("username", username);
		formData.add("password", password);
		ClientResponse response =  webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
		                         .post(ClientResponse.class, formData);
		String output = response.getEntity(String.class);
		JSONObject jsonObject = new JSONObject(output);
		System.out.println("Oauth Response "+jsonObject.toString(2));
				
	return jsonObject;
	}
}
