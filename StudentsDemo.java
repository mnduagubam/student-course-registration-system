package student_course_scheduling_system;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsDemo {
	public static void main(String[]args) {

		//initialize the entire student body, each student, and classes
		StudentsADT students = new Students(3);

		Students.Student student1 = new Students.Student(1111);
		Students.Student student2 = new Students.Student(1234);
		Students.Student student3 = new Students.Student(2357);

		students.addStudent(student1);
		students.addStudent(student2);
		students.addStudent(student3);

		student1.setID(1271536);
		student2.setID(1271237);
		student3.setID(1271399);

		student1.addCourse(new Course("Physics", 105,4));
		student1.addCourse(new Course(new Course("Linear Algebra",201,5)));
		student1.addCourse( new Course("History",112,4));


		student2.addCourse(new Course("Physics", 105,4));
		student2.addCourse(new Course("English Comp", 253, 3));
		student2.addCourse(new Course("Chemistry",101, 4));

		student3.addCourse(new Course("Data Structures", 265, 4));
		student3.addCourse(new Course("Comp Arch",123,3));
		student3.addCourse(new Course("Biology", 224,2));		

		
		//Test the program
		System.out.println("What action would you like to implement? ");
		System.out.println("1: Show all Students");
		System.out.println("2: Add a Course");
		System.out.println("3: Drop a Course");
		System.out.println("9: Quit");

		Scanner input = new Scanner(System.in);


		String answer ="";

		while(true) {
			System.out.print("\nAnswer: ");
			answer = input.nextLine();

			if(answer.equals("1")|| answer.equalsIgnoreCase("Show all Students")) {
				System.out.println("\nList of students\n"+students);

			}else if(answer.equals("2")|| answer.equalsIgnoreCase("Add a Course")) {

				try {
					System.out.print("Enter id: ");
					int id = input.nextInt();

					input.nextLine(); //buffer clear

					System.out.print("Enter coursename: ");
					String courseName = input.nextLine();


					System.out.print("Enter course section: ");
					int sec = input.nextInt();

					System.out.print("Enter number of credits: ");
					int credits = input.nextInt();

					students.addCourse(id, new Course(courseName,sec, credits));
					input.nextLine(); //buffer clear

				}catch(InputMismatchException e) {
					System.out.println("Wrong input");
					input.nextLine();
				}


			}else if(answer.equals("3") || answer.equalsIgnoreCase("Drop a Course")) {
				try {
					System.out.print("Enter id: ");
					int id = input.nextInt();

					input.nextLine(); //buffer clear

					System.out.print("Enter course name: ");
					String courseName = input.nextLine();

					System.out.print("Enter course section: ");
					int sec = input.nextInt();

					System.out.print("Enter number of credits: ");
					int credits = input.nextInt();

					students.dropCourse(id, new Course(courseName,sec, credits));
					input.nextLine();//buffer clear

				}
				catch(InputMismatchException e) {
					System.out.println("Wrong input");
					input.nextLine();
				}

			}else if(answer.equals("9") || answer.equalsIgnoreCase("Quit")) {
				System.out.println("Program ended...");
				break;
			}else {
				System.out.println("Invalid input");
			}
		}
		input.close();
	}
}

