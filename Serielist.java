// For handling the complete list of series.

package all_classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Serielist extends Filehandler{
	
	String PATH = "d:/renewed.txt";
	ArrayList<Serie> listOfseries = new ArrayList<Serie>();
	
	public Serielist() throws IOException {
		updateList();
	}
	
	
	void updateList() throws IOException {
		try {
			listOfseries.clear();
			ArrayList<String> tmp = readFileToArray(PATH);
			for(String s : tmp) {
				String[] tmparray;
				tmparray = s.split(";");
				this.listOfseries.add(new Serie(tmparray[0], Integer.parseInt(tmparray[1]), tmparray[2], tmparray[3]));
				}
			}
		catch (Exception e) {
			// Leave empty list
		}
		Collections.sort(listOfseries);
	}
	
	void serielistToFile() throws IOException {
		if(listOfseries.size() > 0) {
			ArrayList<String> tmp = new ArrayList<String>();
			for(Serie s : listOfseries) {
				tmp.add(s.toString());
			}
			Collections.sort(listOfseries);
			writeListToFile(PATH, tmp);;
			}
	}
	
	void addSerieToList(String name, int season, String state, String rendate ) throws IOException {
		Serie removable = null;
		for(Serie s : listOfseries) {
			if(s.name.equals(name)) {
				removable = s;
				break;
			}
		}
		if(removable != null) {
			listOfseries.remove(removable);
		}
		listOfseries.add(new Serie(name, season, state, rendate));
		serielistToFile();
	}
	
}
