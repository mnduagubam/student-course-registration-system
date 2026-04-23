package student_course_scheduling_system;

public interface StudentsADT {
	void addStudent(Students.Student a);
	void addCourse(int a, Course b);
	void dropCourse(int a, Course b);
}
