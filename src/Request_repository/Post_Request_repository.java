package Request_repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_method.getdata;

public class Post_Request_repository {

	public static String baseuri() {
		String baseuri = "https://reqres.in/";
		return baseuri;
	}

	public static String resource() {
		String resource = "api/users";
		return resource;
	}

	public static String post_request_tc1() throws IOException {
		ArrayList<String> data = getdata.getdataexcle("Post_data", "tc1");
//		System.out.println(data);
		String name = data.get(1);
		String job = data.get(2);
		String requestbody = "{\r\n" + "    \"name\": \"" + name + "\",\r\n" + "    \"job\": \"" + job + "\"\r\n" + "}";
		return requestbody;
	}
}
