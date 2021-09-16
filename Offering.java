package courseRegistration;

import java.util.ArrayList;

public class Offering {
	
	private int sectionNum;
	private int sectionCap;
	private Course theCourse;
	
	private ArrayList <Registration> studentList;  //student list
	
	public Offering (int sectionNum, int sectionCap) {
		setSectionNum(sectionNum);
		setSectionCap(sectionCap);
		studentList = new ArrayList <Registration> ();
	}

	public void addRegistration (Registration reg) {
		//We need to add logic to ensure the requirement for the 
		//minimum number of students in a section is met.
		studentList.add(reg);
	}
	public void removeRegistration (Registration reg) {
		//We need to add logic to ensure the requirement for the 
		//minimum number of students in a section is met.
		//System.out.println("TEST: " + studentList.get(0).getTheStudent());
		//System.out.println("TEST: " + studentList);
		//System.out.println("TEST: " + studentList.size());

		/*if(studentList.get(0).getTheStudent()==reg.getTheStudent()) {
			studentList.remove(studentList.get(0));
		}*/
		
		for(int i = 0; i<studentList.size(); i++) {
			if(studentList.get(i).getTheStudent() == reg.getTheStudent()) {
				//System.out.println("True");
				studentList.remove(studentList.get(i));
			}
		}
		//studentList.remove(reg);
		//System.out.println("TEST2: " + studentList.get(0).getTheStudent());
		
	}
	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public int getSectionCap() {
		return sectionCap;
	}

	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}

	public Course getTheCourse() {
		return theCourse;
	}

	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}

	public ArrayList <Registration> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList <Registration> studentList) {
		this.studentList = studentList;
	}
	public String getCourseStatus() {
		if(getStudentList().size()>8) {
			return "Run";
		}else {
			return "Not enough Student";
		}
	}
	@Override
	public String toString () {
		String st = "";
		st += "Section Number: " + sectionNum + ", Section cap: " + sectionCap + "\n";
		st += "Students in this section are:\n";
			for (Registration r : studentList) {
				///I need to get this from student list
				st += r.getTheStudent() + ", Grade: " + r.getGrade();
				
				st += "\n";
			}
			st += "registered: " + getStudentList().size()+1 + "\n\n";
		//st += "------------------------------------------------------------------------\n";
		return st;
	}
	public String toString (boolean b) {
		String s = "";
		if (b == false)
		{
			String st = "";
			st += "Section Number: " + sectionNum + ", Section cap: " + sectionCap + "\n";
			//st += "------------------------------------------------------------------------\n";
			s = st;
		}else {
			String st = "";
			st += "Section Number: " + sectionNum + ", Section cap: " + sectionCap + "\n";
			st += "Students in this section are:\n";
			for (Registration r : studentList) {
				///I need to get this from student list
				st += r.getTheStudent() + ", Grade: " + r.getGrade() + "\n";
				//st += "registered: " + getStudentList().size()+1;

			}

			st += "Number of student registered: " + getStudentList().size()+ "\n";
			st += "Class status: " + getCourseStatus() + "\n";
			st += "\n";
			s = st;
		}
		return s;
	}
	

}
