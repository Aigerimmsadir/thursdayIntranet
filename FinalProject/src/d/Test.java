package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//Admin Mode
static void addStudent() throws IOException {
	while(true) {
			System.out.println("Enter new student's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();
	
			System.out.println("Select student's faculty:");
			for(int i =0;i<Admin.allFaculties.size();i++) {
				System.out.println((i+1)+") "+ Admin.allFaculties.get(i).toString());
			}
			Faculty f  = Admin.allFaculties.get(Integer.parseInt(br.readLine())-1); 
			System.out.println("Select student's specialization:");
			for(int j =0;j<f.specializations.size();j++) {
				System.out.println((j+1)+") "+ f.specializations.get(j).toString());
			}
			Specialization s = f.specializations.get(Integer.parseInt(br.readLine())-1);
			System.out.println("Does student have grant?\n1 - yes\n2 - no");
			System.out.println("Is this new student?\n1 - yes\n2 - no");
			int answer =Integer.parseInt(br.readLine());
			boolean grant;
			if(answer==1) grant = true;
			else grant = false;
			int opt= Integer.parseInt(br.readLine());
			Student student;
			if(opt ==2) {
				System.out.println("Please enter student's total gpa:");
				double gpa = Double.parseDouble(br.readLine());
				System.out.println("Please enter student's year of study");
				int year =Integer.parseInt(br.readLine());
				student = new Student(name,surname,gpa,s,grant,year);
			}
			else {
				student = new Student(name,surname,s,grant);
				}
			if(!Admin.allStudents.contains(student)) {
			Admin.allStudents.add(student);		
			System.out.println("Student "+student.getSurname()+ " was succesfully added to the datebase.");
			}
			else System.out.println("This student is already added");
			System.out.println("Tap 1 to add another student\nTap 2 to do another operarion");
			int operation =Integer.parseInt(br.readLine());
			if(operation==2) break;
	}
}
static void addTeacher() throws IOException {
	while(true) {
			System.out.println("Enter new teacher's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();
			System.out.println("Enter teacher's salary:");
			int salary = Integer.parseInt(br.readLine());
			System.out.println("Enter teacher's rank:");
			for(int i = 0;i<Rank.values().length;i++) {
				System.out.println((i+1)+") "+Rank.values()[i]);
			}
			 Rank rank = Rank.values()[Integer.parseInt(br.readLine())-1];
			System.out.println("Enter teacher's education degree:");
			for(int i = 0;i<EducationDegree.values().length;i++) {
				System.out.println((i+1)+") "+EducationDegree.values()[i]);
			}
			EducationDegree degree= EducationDegree.values()[Integer.parseInt(br.readLine())-1];
			Teacher teacher = new Teacher(name,surname,salary,rank,degree);	 
			if(!Admin.allTeachers.contains(teacher))
			{
				Admin.allTeachers.add(teacher);			 
			
			System.out.println("Teacher "+teacher.getName()+" "+teacher.getSurname()
			+ " was succesfully added to the datebase.");
			}
			else  System.out.println("This teacher is already added");
			System.out.println("Tap 1 to add another teacher\nTap 2 to do another operarion");
			int operation =Integer.parseInt(br.readLine());
			if(operation==2) break;
	}
}
static void addManager() throws IOException {
	while(true) {
			System.out.println("Enter new managers's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();
			System.out.println("Enter manager's salary:");
			int salary = Integer.parseInt(br.readLine());
			System.out.println("Enter manager's office:");
			for(int i = 0;i<ManagerTypes.values().length;i++) {
				System.out.println((i+1)+") "+ManagerTypes.values()[i]);
			}
			ManagerTypes type = ManagerTypes.values()[Integer.parseInt(br.readLine())-1];
			Manager manager = new Manager(name,surname,salary,type);
			if(!Admin.allManagers.contains(manager)) {
			Admin.allManagers.add(manager);
			System.out.println("Manager "+manager.getName()+" "+manager.getSurname()
			+ " was succesfully added to the datebase.");
			}
			else System.out.println("This teacher is already added");
			System.out.println("Tap 1 to add another manager\nTap 2 to do another operarion");
			int operation =Integer.parseInt(br.readLine());
			if(operation==2) break;
	}
}
static void addExecutor() throws IOException {
	while(true) {
			System.out.println("Enter new executor's full name(first name and last name):");
			String name = br.readLine();
			String surname = br.readLine();
			System.out.println("Enter executor's salary:");
			int salary = Integer.parseInt(br.readLine());
			Executor executor = new Executor(name,surname,salary);
			
			if(!Admin.allExecutors.contains(executor)) {
				Admin.allExecutors.add(executor);
			System.out.println("Manager "+executor.getName()+" "+executor.getSurname()
			+ " was succesfully added to the datebase.");}
			else System.out.println("This executor is already added");
			System.out.println("Tap 1 to add another executor\nTap 2 to do another operarion");
			int operation =Integer.parseInt(br.readLine());
			if(operation==2) break;
	}
}
static void addCourse() throws IOException {
	while(true) {
		System.out.println("Enter new course's name:");
		String name =  br.readLine();
		System.out.println("Select faculty from the list below");
		for(int i=0;i<Admin.allFaculties.size();i++){
			System.out.println((i+1)+Admin.allFaculties.get(i).getName());
		}
		Faculty f = Admin.allFaculties.get(Integer.parseInt(br.readLine())-1);
		System.out.println("Enter number of credits of this course:");
		int credits =Integer.parseInt(br.readLine()); 
		Course course = new Course(name,f,credits);
		System.out.println("Select teachers of this course:");
		for(int i=0;i<Admin.allTeachers.size();i++){
			System.out.println((i+1)+Admin.allTeachers.get(i).getName()+" "+
					Admin.allTeachers.get(i).getSurname());
		}
		int inp = Integer.parseInt(br.readLine());
		System.out.println("Select teacher or tap 0 to end input");
		while(inp!=0) {
			course.teachers.add(Admin.allTeachers.get(inp-1));
			System.out.println("Select teacher or tap 0 to end input");
			inp=Integer.parseInt(br.readLine());
		}
		if(!Admin.allCourses.contains(course)) {
			Admin.allCourses.add(course);
			System.out.println("Course "+name+" was succesfully added.");
		}
		else  System.out.println("This course is already added");
		System.out.println("Tap 1 to add another course\nTap 2 to do another operarion");
		int operation =Integer.parseInt(br.readLine());
		if(operation==2) break;	
		
	}
}
static void addTextbook() throws IOException {
	while(true) {
		System.out.println("Enter new textbook's name and it's format:");
		String name =  br.readLine();
		String format  =  br.readLine();
		System.out.println("Enter new textbook's ISBN");
		String ISBN =  br.readLine();
		System.out.println("Enter new textbook's author");
		String author  =  br.readLine();
		Textbook textbook = new Textbook(name,format,ISBN,author);
		if(!Admin.allTextbooks.contains(textbook)) {
			Admin.allTextbooks.add(textbook);
			System.out.println("Textbook "+name+" was succesfully added.");
		}
		else  System.out.println("This textbook is already added");
		System.out.println("Tap 1 to add another course\nTap 2 to do another operarion");
		int operation =Integer.parseInt(br.readLine());
		if(operation==2) break;	
	}
}
//Student mode
static void ViewCoursesAndFiles(Student s) throws NumberFormatException, IOException {
	System.out.println("Below is a list of courses of student "+s.toString());
	int i=0;
	HashMap<Integer, Course> indexes =  new HashMap<Integer, Course> ();
	for (Entry<Course, Teacher> entry : s.teachers.entrySet())
	{
		i++;
	    System.out.println(i+"Course: "+entry.getKey() + " - Teacher: " + entry.getValue());
	    indexes.put( i,entry.getKey());
	}
	System.out.println("Tap any index to view course files or 0 to exit");
	int opt = Integer.parseInt(br.readLine());
	while(opt!=0) {
		System.out.println(indexes.get(i));
		System.out.println("Teachers of selected course:");
		for(Teacher t: indexes.get(i).teachers) {
			System.out.println(t.getName()+" "+t.getSurname());
		}
	}
}
static void RegisterForCourse(Student s) throws NumberFormatException, IOException {
	Vector<Course> registered =new Vector<Course>();
	System.out.println("Below is a list of available courses:");
	int i = 1;
	for(Course c: Admin.allCourses) {
		System.out.println(i+ c.toString());
	}
	int k=0;
	while(true) {

		int j = Integer.parseInt(br.readLine());
		if(s.numOfCredits+ Admin.allCourses.get(j-1).getCredits()<=21) {
		registered.add( Admin.allCourses.get(j-1));
		s.numOfCredits=s.numOfCredits+ Admin.allCourses.get(j-1).getCredits();
		k++;
		}
		else break;
	}
	System.out.println("Student "+s.surname+" registered on "+ k+" courses");
	//закинуть в мэп курсов новый вектор курсов
}
public static void main(String[] args) throws ClassNotFoundException, IOException {


//	Admin.allStudents.add(s);
//	Admin.allTeachers.add(t);
//	Admin.serializeUser();
	
Admin.initializeObjects();
Admin.allUsers.clear();
Admin.serializeUser();
	//Faculty f =new Faculty("FIT");
//	f.specializations.add( new Specialization("AC"));
	//Admin.allFaculties.add(f);
//	addStudent();
//	addTeacher();
//	Admin.serializeUser();

	for(User u:Admin.allUsers) {
		System.out.println(u.name +" " + u.surname);
	}
	
//	addCourse();
//	RegisterForCourse(Admin.allStudents.get(0));
//	ViewCoursesAndFiles(Admin.allStudents.get(0));
//	Admin.serializeUser();
//	Admin.serializeCourses();
//	Admin.serializeFaculties();
//	

}
}
