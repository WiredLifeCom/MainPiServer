public class Test {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		// builder.append("\"data\": {");
		builder.append("\"user\":{");
		builder.append("\"username\":\"bejbejpomp\",");
		builder.append("\"zones\":[");
		builder.append("{");
		builder.append("\"arrival\":\"2015-04-25T11:42:11.000+02:00\",");
		builder.append("\"departure\":\"2015-04-25T11:58:32.000+02:00\",");
		builder.append("\"latitude\":55.61592,");
		builder.append("\"longitude\":12.987113");
		builder.append("}");
		builder.append("],");
		builder.append("\"inventory\":{");
		builder.append("\"resources\":[");
		builder.append("\"Dirt\",");
		builder.append("\"Dirt\",");
		builder.append("\"Stone\"");
		builder.append("],");
		builder.append("\"items\":[");
		builder.append("\"DiamondPickaxe\",");
		builder.append("\"WoodenAxe\"");
		builder.append("]");
		builder.append("}");
		builder.append("},");
		builder.append("\"unload\":\"2015-04-26T13:04:54.000+02:00\"");
		// builder.append("}");
		builder.append("}");

		RequestPoster.doPost("http://localhost:7070/unload", builder.toString());
	}

}
