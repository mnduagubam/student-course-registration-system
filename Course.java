package student_course_scheduling_system;

public class Course {
	private String courseName; //every course has a name
	private int sectionNum;    //every course has section number
	private int numOfCredits;  //every course has credits
	private Course link;      //link to the next course

	public Course() {   //every course by default 
		this.courseName = "";
		this.sectionNum = 0;
		this.numOfCredits = 0;
		this.link = null;
	}

	public Course(String name, int sectionNum, int credits) { //initiaze with actual values
		this.courseName = name;
		this.sectionNum = sectionNum;
		this.numOfCredits = credits;
		this.link = null;
	}

	public Course(Course a) { //in case another person takes the same course
		this.courseName = a.courseName;
		this.sectionNum = a.sectionNum;
		this.numOfCredits = a.numOfCredits;
		this.link = a.link;
	}

	public void setCourseName(String courseName) { //sets name
		this.courseName = courseName;
	}

	public void setSectionNumber(int sectionNum) {//sets section num
		this.sectionNum = sectionNum;
	}

	public void setNumberOfCredits(int numOfCredits) { //sets credits
		this.numOfCredits = numOfCredits;
	}

	public void setLink(Course link) { //sets the next Course
		this.link = link;
	}

	public String getCourseName() { //gets name
		return courseName; 
	}

	public int getSectionNumber() {//gets the section num
		return sectionNum;
	}

	public int getNumberOfCredits() {//gets the credits
		return numOfCredits;
	}

	public Course getLink() {  //gets the next Course
		return link;
	}

	public String toString() { //string representation of a course
		return "["+courseName+" | "+sectionNum+" | "+numOfCredits+"]--->"+link;
	}

}
