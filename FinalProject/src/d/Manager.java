package d;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;


public class Manager extends Employee implements Orders { 

	public Manager(String name, String surname, Integer salary, ManagerTypes type) {
		super(name, surname, salary);
		this.type = type;
	}
	private ManagerTypes type;
	ArrayList<AcademicReport> writtenReports;
	public ArrayList<AcademicReport> getWrittenReports() {
	    return null;
	}
	public void writeReport() {
		
	}
	public boolean checkSyllabus(Teacher t) {
		if(type == ManagerTypes.OR)
		if(t.syllabus!=null) return true;
		return false;
	}
	
	public boolean checkMarkTime(Student s) throws ParseException {
		boolean inTime=true;
		if(type == ManagerTypes.OR) {
		
				HashMap<Course,Teacher> map =s.teachers;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				 Date d1;
						for (Entry<Course, Teacher> entry : map.entrySet())
						{
						    if(Login.semester.equals("Fall") ) {
						    	d1 = sdf.parse("2017-12-20");
						    	Mark temp = s.Courses.get(entry.getKey());
						    	if(d1.compareTo(temp.getTimeOfPutting())<0) {
						    		inTime=false;
						    		System.out.println("Teacher "+entry.getValue().toString()+
						    		" didn't put mark in time for course "+ entry.getKey().getName());
						    	}
						    }
						    else{
						    	d1 = sdf.parse("2018-06-01");
						    	Mark temp = s.Courses.get(entry.getKey());
						    	if(d1.compareTo(temp.getTimeOfPutting())<0) {
						    		inTime=false;
						    		System.out.println("Teacher "+entry.getValue().toString()+
						    		" didn't put mark in time for course "+ entry.getKey().getName());
						    	}
						    }
						}
			}
	    return inTime;
	}
	public void writeDepartmentNews(String news) {
		Announcement an = new Announcement(news,this);
		Admin.allAnnouncements.add(an);
	}
	
	@Override
	public int compareTo(Object o) {
		Manager m = (Manager )o;
		return salary.compareTo(m.getSalary());
	}
	@Override
	public void sendOrder(Order o) {
		Executor.orders.add(o);
		
	}
}

