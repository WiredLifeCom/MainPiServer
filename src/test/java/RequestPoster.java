import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RequestPoster {

	public static final String doGet(String address) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(address);
		Response response = target.request().get();
		String result = response.readEntity(String.class);

		return result;
	}

	public static String doPost(String address, String query) {
		System.out.println("Query: " + query);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(address);
		Response response = target.request().post(Entity.json(query));
		String result = response.readEntity(String.class);
		
		return result;
	}

}
