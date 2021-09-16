package courseRegistration;

import java.util.Scanner;

//This is my "FrontEnd!"
public class CourseRegApp {
	private boolean mainMenu = true;
	private boolean searchMenu = true;
	private boolean registerMenu = true;
	private boolean withdrawMenu = true;
	private void run(CouRegController couRegController){
		//getChoice();
		
	  	while(mainMenu){
	  		displayChoices();
	  		searchMenu = true;
	  		registerMenu = true;
	  		withdrawMenu = true;
			switch(getChoice()) {
				default:   System.out.println("Please type again !"); break;
				case 'A' : 
					for (int i=0;i<couRegController.getCourseCat().getCourseList().size();i++) {
						System.out.println(couRegController.getCourseCat().getCourseList().get(i).getAllSections());
					}
					break;
				case 'B' : 					
					for (int i=0;i<couRegController.getCourseCat().getCourseList().size();i++) {
						System.out.println(couRegController.getCourseCat().getCourseList().get(i).getAllTakenCourses());
					}
					break;
				case 'C' : 
					while(searchMenu) {
						displaySearchOptions();
						switch(getChoice()) {
							default:   System.out.println("Please type again !"); break;
							case 'A' : 
								System.out.print("Please type course name: ");
								String temp3 = getString().toUpperCase();
								//System.out.print("Result: " + couRegController.getCourseCat().searchCat(temp3).size());
								if(couRegController.getCourseCat().searchCat(temp3).size()!=0) {
									for (int i=0; i<couRegController.getCourseCat().searchCat(temp3).size(); i++) {
										System.out.println(couRegController.getCourseCat().searchCat(temp3).get(i).getAllSections());
									}
								}else {
									System.err.println("Please try again !\n");
								}

								break;
							case 'B' : 
								
								String temp;
								System.out.print("Please type course name: ");
								temp = getString().toUpperCase();
								int temp1;
								System.out.print("Please type course number: ");
								temp1 = getInt();
								if(couRegController.getCourseCat().searchCat(temp,temp1)!=null) {
									System.out.println(couRegController.getCourseCat().searchCat(temp,temp1).getAllSections());
								}else {
									System.err.println("Please try again !\n");
								}
								break;
							case 'Q' : searchMenu = false; break;
						}
						break;
					}
					break;
				case 'D' : 
					while(registerMenu) {

						try {
							String studentName,courseName;
							int studentID, courseNumber,sectionNumber;
							boolean temp;
							System.out.println("Course Registration ");
							System.out.print("Please type your name: ");
							studentName = getString();
							System.out.print("Please type your student id: ");
							studentID = getInt();
							System.out.print("Please type the course name that you want to register: ");
							courseName  = getString();
							System.out.print("Please type the course number that you want to register: ");
							courseNumber = getInt();
							System.out.print("Please type the section number that you want to register: ");
							sectionNumber = getInt();
							//System.out.println("try " + couRegController.registerByStuName(studentName,courseName,courseNumber,sectionNumber));
							temp=couRegController.registerByStuName(studentName,courseName,courseNumber,sectionNumber);
							if(temp){
								while(temp) {
									System.out.println("(R)egister for next class");
									System.out.println("(Q)Quit");
									System.out.print("> ");
									switch(getChoice()) {
										default:   System.out.println("Please type again !"); break;
										case 'R' : 
											System.out.print("\nPlease type the course name that you want to register: ");
											courseName = getString();
											System.out.print("Please type the course number that you want to register: ");
											courseNumber = getInt();
											System.out.print("Please type the section number that you want to register: ");
											sectionNumber = getInt();
											couRegController.registerByStuName(studentName,courseName,courseNumber,sectionNumber);
											//condition3 = false;
											break;
										case 'Q' : 
											//System.out.println("temp: " + temp + " registerMenu: " + registerMenu);
											temp = false; registerMenu = false; 
											//System.out.println("temp: " + temp + " registerMenu: " + registerMenu);
											break;
									}
								}
							}else {
								System.out.println("ERROR:  Please try again!\n");
								registerMenu=false;
							}
							
							//System.out.println("try " + couRegController.registerByStuName(studentName,courseName,courseNumber,sectionNumber));
						}catch (Exception e) {
							
						    System.out.println("ERROR:  Please try again!\n");
						    registerMenu=false;
						}
					} 
					break;
				case 'E' : 
					while(withdrawMenu) {

						try {
							String studentName,courseName;
							int studentID, courseNumber,sectionNumber;
							boolean temp;
							System.out.println("Course Withdrawal ");
							System.out.print("Please type your name: ");
							studentName = getString();
							System.out.print("Please type your student id: ");
							studentID = getInt();
							System.out.print("Please type the course name that you want to withdraw: ");
							courseName  = getString();
							System.out.print("Please type the course number that you want to withdraw: ");
							courseNumber = getInt();
							System.out.print("Please type the section number that you want to withdraw: ");
							sectionNumber = getInt();
							//System.out.println("try " + couRegController.registerByStuName(studentName,courseName,courseNumber,sectionNumber));
							temp=couRegController.withdrawByStuName(studentName,courseName,courseNumber,sectionNumber);
							if(temp){
								while(temp) {
									System.out.println("(W)ithdraw for next class");
									System.out.println("(Q)Quit");
									System.out.print("> ");
									switch(getChoice()) {
										default:   System.out.println("Please type again !"); break;
										case 'W' : 
											System.out.println("\nPlease type the course name that you want to withdraw: ");
											courseName = getString();
											System.out.println("\nPlease type the course number that you want to withdraw: ");
											courseNumber = getInt();
											System.out.println("\nPlease type the section number that you want to withdraw: ");
											sectionNumber = getInt();
											couRegController.withdrawByStuName(studentName,courseName,courseNumber,sectionNumber);
											//condition3 = false;
											break;
										case 'Q' : 
											//System.out.println("temp: " + temp + " registerMenu: " + registerMenu);
											temp = false; withdrawMenu = false; 
											//System.out.println("temp: " + temp + " registerMenu: " + registerMenu);
											break;
									}
								}
							}else {
								System.out.println("ERROR:  Please try again!\n");
								withdrawMenu=false;
							}
							
							//System.out.println("try " + couRegController.registerByStuName(studentName,courseName,courseNumber,sectionNumber));
						}catch (Exception e) {
							
						    System.out.println("ERROR:  Please try again!\n");
						    withdrawMenu=false;
						}
					} 
					break;
	      		case 'Q' : mainMenu = false; break;
      		
    		}
	  	}
	  	
	}
	  






	private void displayChoices() {
		/* NOTE:  Use character NOT number choices for cmd line input
		 *        They are more intuitive causing significantly less
		 *        cognitive friction. */
		System.out.println("Course Registration System");
		System.out.println("(A)View all courses in catalogue, (B)View all courses taken by student");
		System.out.println("(C)Search catalogue courses, (D)Add course to student courses, (E)Remove course from student courses");
		System.out.println("(Q)uit");
		System.out.print("> ");
	}
	private void displaySearchOptions() {
		System.out.println("Search from Course Catalogue");
		System.out.println("(A)Search by course name, (B)Search by course name and course number");
		System.out.println("(Q)uit");
		System.out.print("> ");
		
	}
	private void displayRegisterOptions() {
		System.out.println("Search from Course Catalogue");
		System.out.println("(A)Search by course name, (B)Search by course name and course number");
		System.out.println("(Q)uit");
		System.out.print("> ");
		
	}
	private char getChoice() {
		String input = "Empty";
		Scanner in = new Scanner(System.in);
		try {
			// grab everthing up to the 'enter' and convert to uppercase
			input = in.next().toUpperCase();
			//System.out.println("ur input " + input);
		} catch (Exception e) {
			System.out.println("ERROR:  key read problem");
		}
		// no matter how many characters are typed return the first
		return input.charAt(0);
	}
	private String getString() {
		String input = "Empty";
		Scanner in = new Scanner(System.in);
		try {
			// grab everthing up to the 'enter' and convert to uppercase
			input = in.next(); //.toUpperCase();
			//System.out.println("ur input " + input);
		} catch (Exception e) {
			System.out.println("ERROR:  key read problem");
		}
		// no matter how many characters are typed return the first
		return input;
	}
	private int getInt() {
		
		int input = 0;
		
		Scanner in = new Scanner(System.in);
		input = in.nextInt();
		//System.out.println("INT: " + input);
		// no matter how many characters are typed return the first
		return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Course myCourse = new Course("ENSF","607");
		//System.out.println("myCourse: " + myCourse);
		CouRegController couRegController = new CouRegController();
		CourseRegApp cmd= new CourseRegApp();
		cmd.run(couRegController);
	}
	
	/*
	public static void main (String [] args) {
		
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
		
		//System.out.println(myCourse.getOfferingList().get(0).getStudentList().get(0).getTheStudent().getStudentName());
	}
	 */
}
