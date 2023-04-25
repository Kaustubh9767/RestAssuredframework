package Request_repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_method.getdata;

public class patch_request_repository {
	public static String baseuri() {
		String baseuri = "https://reqres.in/";
		return baseuri;
	}

	public static String resource() {
		String resource = "api/users/2";
		return resource;
	}

	public static String patch_request_tc1() throws IOException {
		ArrayList<String> data = getdata.getdataexcle("Patch_data", "tc1");
		String name = data.get(1);
		String job = data.get(2);
		String requestbody = "{\r\n" + "    \"name\": \"" + name + "\",\r\n" + "    \"job\": \"" + job + "\"\r\n" + "}";
		return requestbody;
	}

}
