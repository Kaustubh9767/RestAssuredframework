package Common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Common_method_Utilities {
	public static void evidence_file_creator(String filename, String request, String response) throws IOException {
		File newTextFile = new File("D:\\restAssuredEvidance\\" + filename + ".txt");
		if (newTextFile.createNewFile()) {
			FileWriter dataWriter = new FileWriter(newTextFile);
			dataWriter.write("Requestbody is :" + request + "\n\n");
			dataWriter.write("Responsebody is :" + response);
			dataWriter.close();
			System.out.println("request and responsebody data saved in :" + newTextFile.getName());
		} else {
			System.out.println(newTextFile.getName() + "Already exist take a backup of it :");
		}

	}

}
