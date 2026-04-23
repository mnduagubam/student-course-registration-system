package student_course_scheduling_system;

public class Students implements StudentsADT{

	static class Student{ //Every student has:
		private int id; //id of student
		private Course headlink; //link to courses

		public Student() { //a student can start with none
			this.id = 000;
			this.headlink = null;
		}

		public Student(int id) { //a student can start with only id 
			this.id = id;
			this.headlink = null;
		}

		public void setID(int id) { // a student can later change their id
			this.id = id;
		}

		public void setCourses(Course courses) { //a student can set their courses
			headlink = courses;
		}

		public int getID() { //a student can retrieve their id
			return id;
		}

		public Course getCourses() {// a student can retrieve their courses
			return headlink;
		}

		public void addCourse(Course course1) { // a student can add a course to original
			if(headlink == null) {
				headlink = course1;
				return;
			}

			Course current = headlink;

			while(current.getLink() != null) {
				current = current.getLink();
			}

			current.setLink(course1);
		}

		public void dropCourse(Course course1) { // a student can drop a course

			//remove course by pointing to the next one	
			if(headlink == null) {
				System.out.println("Can't drop course. No courses yet");
				return;
			}

			//check if the first course is the right match
			if(headlink.getCourseName().equals(course1.getCourseName())) {
				headlink = headlink.getLink();
				return;
			}

			Course current = headlink.getLink();
			Course follow = headlink;

			while(current != null) {

				if(current.getCourseName().equals(course1.getCourseName())) {
					follow.setLink(current.getLink());
					current.setLink(null);
					return;
				}

				follow = current; //follow becomes the old current
				current = current.getLink(); //to the next course
			}
		}

		public String toString() {
			return this.id +" --> "+headlink;
		}
	}

	private int maxNumberOfStudents; //capacity of students (for all the students I make)
	private Student [] students;        //holds the entire student body
	private int numberOfStudents = 0;

	public Students() {   //the entire student body can be empty and 
		maxNumberOfStudents = 10;
		students = new Student[maxNumberOfStudents];
	}

	public Students(int maxNumOfStudents) {
		maxNumberOfStudents = maxNumOfStudents;
		students = new Student[maxNumberOfStudents];
	}

	public Students(Students a) {
		this.students = new Student[a.students.length];
		this.maxNumberOfStudents = a.maxNumberOfStudents;
		this.numberOfStudents = a.numberOfStudents;

		for(int i=0; i<numberOfStudents;i++) {
			this.students[i] = a.students[i];
		}
	}

	public void setMaxNumberOfStudents(int maxNumOfStudents) {
		maxNumberOfStudents = maxNumOfStudents;
	}

	public void addStudent(Student newStudent) {

		//if num of students is less than the maximum, add student
		if(numberOfStudents >= maxNumberOfStudents) {
			System.out.print("Capacity is full");
			return;
		}
		students[numberOfStudents] = newStudent;
		numberOfStudents++;
	}

	public void addCourse(int ID, Course course1) {
		boolean found = false;    //to check if the student exists and had id
		boolean foundEqual = false; //to check if you find another course equal to it
		//find the student
		int i;
		for(i=0; i<numberOfStudents;i++) {

			if(students[i] !=null && students[i].getID() == ID) {
				Course current = students[i].getCourses();

				//check if that course already exists
				while(current != null) {
					if(course1.getCourseName().equalsIgnoreCase(current.getCourseName()) && course1.getSectionNumber() == current.getSectionNumber()) {		 
						foundEqual = true;
						System.out.println("That course already exists");
						break;
					}else {
						foundEqual = false;
					}
					current = current.getLink();
				}

				if(foundEqual == false) {
					students[i].addCourse(course1);
					System.out.println(course1.getCourseName()+ " added");
				}
				found = true;
				break; 

			}

		}
		if(!found) {//that means, you never went into the loop in the first place
			System.out.println("Student with ID "+ID+" not found");
		}
	}

	public void dropCourse(int ID, Course course1) {
		boolean found = false; //for checking if the student exists and id
		boolean foundEqual = false; 
		
		//find the student
		int i;
		for(i=0; i<numberOfStudents;i++) {
			Course current = students[i].getCourses();

			if(students[i] !=null && students[i].getID() == ID) {
				while(current != null) {
					if(course1.getCourseName().equalsIgnoreCase(current.getCourseName()) && course1.getSectionNumber() == current.getSectionNumber()) {		 
						foundEqual = true;
						students[i].dropCourse(course1);
						System.out.println(course1.getCourseName()+ " dropped");
						break;
					}else {
						foundEqual = false;
					}
					current = current.getLink();
				}

				if(foundEqual == false) {
					System.out.println("That course does not exist!");
				}
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Student with ID "+ID+" not found");
		}
	}

	public String toString() {
		String stringStudents ="";
		for(Student student: students) {
			if(student != null) {
				stringStudents += student+"\n";
			}
		}
		return stringStudents;
	}


}
