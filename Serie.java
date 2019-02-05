// Class for serie info

package all_classes;

public class Serie implements Comparable<Serie> {
	String name;
	int season;
	String state;
	String renDate;
	
	public Serie(String na, int se, String st, String re) {
		name = na; season = se; state = st; renDate = re;
	}

	public String getName() {
		return name;
	}

	public int getSeason() {
		return season;
	}

	public String getState() {
		return state;
	}

	public String getRenDate() {
		return renDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setRenDate(String renDate) {
		this.renDate = renDate;
	}
	
	public String toString() {
		return this.getName() + ";" + this.getSeason() + ";" + this.getState() + ";" + this.getRenDate();
	}

	@Override
	public int compareTo(Serie s) {
		return name.compareTo(s.getName());
	}
}
