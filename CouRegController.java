package courseRegistration;

import java.util.ArrayList;

public class CouRegController {
	
	private static ArrayList <Student> stuList ;//= new ArrayList <Student>();
	private static ArrayList <Course> courseList;// = new ArrayList <Course> ();
	//private static ArrayList <Offering> offList  ;
	private static CourseCat cat = new CourseCat(); 
	
	public CouRegController() {
		stuList = new ArrayList <Student>();
		courseList = new ArrayList <Course> ();
		
		stuList=addStudents();
		courseList=addCourses();
		
		//offList=addCourseCat();
	}
	public Boolean registerByStuName (String studentName, String courseName, int courseNumber, int sectionNumber ) {
		Student foundStudent = null;
		Boolean b = true;
		//search for courses that their name matches courseName and add to the 
		//foundCourses array
		//my code
		for (Student s: stuList) {
			/*System.out.println("Student: " + s);
			System.out.println(s.getStudentName());
			System.out.println(studentName);
			System.out.println(s.getStudentName().equals(studentName));*/
			if (s.getStudentName().equals(studentName)) {
				foundStudent= s;
				if(s.getRegList().size()<6) {
					s.registerForCourse(cat, courseName, courseNumber, sectionNumber);
				}else {
					System.err.println("The student takes over 6 coruses!");
				}
				
				b=true;
				break;
			}
			else {
				b=false;
				//System.err.println("The student does not exist!");
			}
		}
		return b;		
		
	}
	public Boolean withdrawByStuName (String studentName, String courseName, int courseNumber, int sectionNumber ) {
		Student foundStudent = null;
		Boolean b = true;

		for (Student s: stuList) {
			/*System.out.println("Student: " + s);
			System.out.println(s.getStudentName());
			System.out.println(studentName);
			System.out.println(s.getStudentName().equals(studentName));*/
			if (s.getStudentName().equals(studentName)) {
				foundStudent= s;
				s.withdrawForCourse(cat, courseName, courseNumber, sectionNumber);
				b=true;
				break;
			}
			else {
				b=false;
				//System.err.println("The student does not exist!");
			}
		}
		return b;		
		
	}
	/*
	public Student searchStuByName (String studentName) {
		Student foundStudent = null;
		//search for courses that their name matches courseName and add to the 
		//foundCourses array
		//my code
		for (Student s: stuList) {
			System.out.println("Student: " + s);
			System.out.println(s.getStudentName());
			System.out.println(studentName);
			System.out.println(s.getStudentName().equals(studentName));
			if (s.getStudentName().equals(studentName)) {
				foundStudent= s;
				break;
			}
			else {
				System.err.println("The student does not exist!");
			}
		}		
		return foundStudent;
	}
	*/
	private static ArrayList <Student> addStudents() {
		ArrayList <Student> imaginaryDB = new ArrayList <Student> ();
		imaginaryDB.add(new Student ("Sara", 1));
		imaginaryDB.add(new Student ("Joe", 2));
		imaginaryDB.add(new Student ("Allen", 3));
		imaginaryDB.add(new Student ("Aaron", 4));
		imaginaryDB.add(new Student ("Sam", 5));
		imaginaryDB.add(new Student ("Tom", 6));
		imaginaryDB.add(new Student ("Martin", 7));
		imaginaryDB.add(new Student ("Mike", 8));
		imaginaryDB.add(new Student ("Andy", 9));
		return imaginaryDB;
	}

	private static ArrayList<Course> addCourses() {

		ArrayList <Course> imaginaryDB = new ArrayList <Course> ();
		imaginaryDB.add(new Course ("ENGG", 233));
		//System.out.println("CAT123:" + imaginaryDB.get(0));
		//System.out.println(imaginaryDB.get(0));
		//cat = addCourseCat(imaginaryDB.get(0));
		imaginaryDB.add(new Course ("ENSF", 607));
		//cat = addCourseCat(imaginaryDB.get(1));
		imaginaryDB.add(new Course ("PHYS", 259));
		
		cat = addCourseCat(imaginaryDB);
		//cat = addCourseCat(imaginaryDB.get(2));

		return imaginaryDB;
	}
	private static CourseCat addCourseCat(ArrayList<Course> imaginaryDB) {
		//ArrayList <Offering> imaginaryDB = new ArrayList <Offering> ();
		for (Course mycourse: imaginaryDB) {
			if (mycourse != null) {
				cat.createOffering(mycourse, 1, 200);
				cat.createOffering(mycourse, 2, 150);
				cat.createOffering(mycourse, 3, 100);
			}
		}
		
		cat.setCourseList(imaginaryDB);
		//System.out.println("CAT C:" + cat.getCourseList());
		return cat;
	}
	public ArrayList <Student> getStuList() {
		return stuList;
	}
	public ArrayList <Course> getCourseList() {
		return courseList;
	}
	public CourseCat getCourseCat() {
		return cat;
	}
	public static void main(String[] args) {
		/*
		CourseCat cat = new CourseCat ();  //This loads the courses from our "DB"
		Student st1 = new Student ("Sara", 1);
		Student st2 = new Student ("Joe", 2);
		
		Course myCourse = cat.searchCat("ENGG", 233);
		if (myCourse != null) {
			cat.createOffering(myCourse, 1, 200);
			cat.createOffering(myCourse, 2, 150);
		}
	    
		st1.registerForCourse(cat, "ENGG", 233, 1);
		
		System.out.println(myCourse.getOfferingList().get(0).getTheCourse());
	*/
	}
	
}
