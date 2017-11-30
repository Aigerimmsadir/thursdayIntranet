package d;

import java.io.Serializable;
import java.util.ArrayList;

public class Transcript implements Serializable, Cloneable,Comparable {
	 ArrayList<Mark> semesters= new ArrayList<Mark>();
	  Double overallgpa;

	public ArrayList<Mark> getSemesters() {
	    return this.semesters;
	}
	public double getOverallgpa() {
	    return this.overallgpa;
	}
	public void addMark(Mark mark) {
		semesters.add(mark);
	}
	@Override
	public int compareTo(Object arg0) {
		Transcript tt = (Transcript) arg0;
		return overallgpa.compareTo(tt.getOverallgpa());
	}
}

