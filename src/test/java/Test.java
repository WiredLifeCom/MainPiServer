import com.wiredlife.jsonformatjava.model.status.OnlineStatus;

public class Test {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		// builder.append("\"data\": {");
		builder.append("\"user\":{");
		builder.append("\"username\":\"bejbejpomp\"");
		builder.append("},");
		builder.append("\"zones\":[");
		builder.append("{");
		builder.append("\"latitude\":55.61592,");
		builder.append("\"longitude\":12.987113,");
		builder.append("\"radius\":30,");
		builder.append("\"material\":\"Dirt\",");
		builder.append("\"arrival\":\"2015-04-21T11:42:11.000+02:00\",");
		builder.append("\"departure\":\"2015-04-21T11:58:32.000+02:00\"");
		builder.append("}");
		builder.append("],");
		builder.append("\"materials\":[");
		builder.append("\"Dirt\",");
		builder.append("\"Dirt\",");
		builder.append("\"Stone\"");
		builder.append("],");
		builder.append("\"unload\":\"2015-04-21T13:04:54.000+02:00\"");
		// builder.append("}");
		builder.append("}");

		System.out.println(builder.toString());

		//RequestPoster.doPost("http://localhost:7070/unload", builder.toString());
		//RequestPoster.doPost("http://localhost:7070/unload", builder.toString());
		
		OnlineStatus status = new OnlineStatus();
		status.setUsername("hello");
		status.setHome(false);
		status.setIpAddress("1.2.3.4");
		
		RequestPoster.doPost("http://localhost:7070/onlinestatus", OnlineStatus.toJson(status));
	}

}
