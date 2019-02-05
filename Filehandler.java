// Methods for handling files

package all_classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filehandler {
	
	ArrayList<String> readFileToArray(String path) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		ArrayList<String> lines = new ArrayList<String>();
		String line;
		while((line = reader.readLine()) != null) {
			if(line.length() > 1) lines.add(line);
		}
		reader.close();
		return lines;
	}
	
	void writeListToFile(String path, ArrayList<String> list) throws IOException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		for(String s : list) {
			writer.write(s);
			writer.newLine();
		}
		writer.close();
	}
	
	void writeToFile(String path, String txt) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		writer.write(txt);
		writer.close();
	}

}
