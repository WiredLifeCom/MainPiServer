import java.util.Random;

import org.joda.time.DateTime;

import com.wiredlife.jsonformatjava.model.status.OnlineStatus;
import com.wiredlife.jsonformatjava.model.unload.Unload;
import com.wiredlife.jsonformatjava.model.unload.User;
import com.wiredlife.jsonformatjava.model.unload.Zone;

public class Test {

	public static void main(String[] args) {
		// StringBuilder builder = new StringBuilder();
		// builder.append("{");
		// // builder.append("\"data\": {");
		// builder.append("\"user\":{");
		// builder.append("\"username\":\"bejbejpomp\"");
		// builder.append("},");
		// builder.append("\"zones\":[");
		// builder.append("{");
		// builder.append("\"latitude\":55.61592,");
		// builder.append("\"longitude\":12.987113,");
		// builder.append("\"radius\":30,");
		// builder.append("\"material\":\"Dirt\",");
		// builder.append("\"arrival\":\"2015-04-21T11:42:11.000+02:00\",");
		// builder.append("\"departure\":\"2015-04-21T11:58:32.000+02:00\"");
		// builder.append("}");
		// builder.append("],");
		// builder.append("\"materials\":[");
		// builder.append("\"Dirt\",");
		// builder.append("\"Dirt\",");
		// builder.append("\"Stone\"");
		// builder.append("],");
		// builder.append("\"unload\":\"2015-04-21T13:04:54.000+02:00\"");
		// // builder.append("}");
		// builder.append("}");
		//
		// System.out.println(builder.toString());

		int loops = 50;
		for (int i = 0; i < loops; i++) {
			System.out.println("Loops left: " + (loops - i));

			Random random = new Random();

			int randomNumber;

			Unload unload = new Unload();

			User user = new User();
			user.setUsername("bejbejpomp");

			unload.setUser(user);

			Zone z1 = new Zone(55.5421, 21.4621, 20, "Dirt", 30);

			randomNumber = random.nextInt(60);
			z1.setArrival(DateTime.now().plusHours(randomNumber).plusMinutes(randomNumber).plusSeconds(randomNumber).plusMillis(randomNumber));
			z1.setDeparture(z1.getArrival().plusHours(randomNumber).plusMinutes(randomNumber).plusSeconds(randomNumber).plusMillis(randomNumber));

			randomNumber = random.nextInt(60);
			Zone z2 = new Zone(52.5421, 23.4621, 30, "Wood", 50);
			z2.setArrival(DateTime.now().plusHours(randomNumber).plusMinutes(randomNumber).plusSeconds(randomNumber).plusMillis(randomNumber));
			z2.setDeparture(z1.getArrival().plusHours(randomNumber).plusMinutes(randomNumber).plusSeconds(randomNumber).plusMillis(randomNumber));

			unload.addZone(z1);
			unload.addZone(z2);

			unload.addMaterial("Dirt");
			unload.addMaterial("Dirt");
			unload.addMaterial("Dirt");
			unload.addMaterial("Dirt");
			unload.addMaterial("Wood");
			unload.addMaterial("Wood");
			unload.addMaterial("Wood");
			unload.addMaterial("Wood");

			unload.setUnload(DateTime.now().plusHours(1).plusMinutes(30));

			RequestPoster.doPost("http://localhost:7070/unload", Unload.toJson(unload));

			OnlineStatus status = new OnlineStatus();
			status.setUsername("hello");
			status.setHome(false);
			status.setIpAddress("1.2.3.4");

			RequestPoster.doPost("http://localhost:7070/onlinestatus", OnlineStatus.toJson(status));
			// try {
			// Thread.sleep(50);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}
}
