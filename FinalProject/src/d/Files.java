package d;

import java.io.Serializable;

public class Files implements Serializable, Cloneable {

	public String title;
	public String format;
	
	//file
	public Files(String t, String f) {
		title =t;
		format = f;
	}
	public boolean equals(Object o) {
		Files f = (Files)o;
		if(title.equals(f.title)) return true;
		return false;
	}
	public String toString() {
		return title+format;
	}
}