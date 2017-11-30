package d;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;


public class Student extends User {
	private int yearOfStudy ;
	private Double gpa;
	private Specialization specialization;
	private Transcript transcript;
	public HashMap<Course,Mark> Courses;
	public HashMap<Course,Teacher> teachers;
	 int numOfCredits;
	public boolean grant;
	public Student(String n, String s,double gpa,Specialization specialization,boolean grant,int year) {
		super(n,s);
		this.grant = grant;
		login = Character.toLowerCase(name.toCharArray()[0])+"_"+surname.toLowerCase();
		Courses = new HashMap<Course,Mark>();
		teachers = new HashMap<Course,Teacher>();
		yearOfStudy = year;
	}	
	public Student(String n, String s,Specialization specialization,boolean grant) {
		super(n,s);
		this.grant = grant;
		Courses = new HashMap<Course,Mark>();
		teachers = new HashMap<Course,Teacher>();
		login = Character.toLowerCase(name.toCharArray()[0])+"_"+surname.toLowerCase();
	}
 /*  public static getStudents(Course c) {
	   Vector<Student> studs = new Vector<Student>();
	   for(Student s : Admin.allStudents)
		   if(s.Courses.keySet().contains(c))
				   studs.add(s);
	   
   }*/
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public Transcript getTranscript() {
		return transcript;
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public int getNumOfCredits() {
		return numOfCredits;
	}
	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits =numOfCredits;
	}

	public void viewMarks() {
		System.out.println("Marks of the student "+super.toString());
		for (Entry<Course, Mark> entry : Courses.entrySet()) {
			System.out.println(entry.getKey()+ ":"+entry.getValue());
		}
			
	}
	
	public void addCourse(Course c) {
		if( c.getFaculty().specializations.contains(this.specialization)) {
			Courses.put(c, new Mark());
		}
	}
	@Override
	public boolean equals(Object obj) {
		
		Student other = (Student) obj;
		if(super.equals(obj)) {
			if(gpa==other.getGpa() && specialization.equals(other.getSpecialization())
					&& Courses.equals(other.Courses)) 	return true;
		}
		return false;
	}


	public void viewLibrary() {
		
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student)o;
		return gpa.compareTo(s.getGpa());
	}

	public void viewCourses() {
		System.out.println("Student "+super.toString()+"has "+Courses.size()+" courses");
		for (Entry<Course, Mark> entry : Courses.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
}