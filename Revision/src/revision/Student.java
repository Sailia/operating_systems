package revision;

public class Student {
	public int id;
	public int age;
	public float gpa;
	
	Student() {
		id = 0;
		age = 0;
		gpa = 0;
	}
	
	Student(int idx, int agex, float gpax) {
		id = idx;
		age = agex;
		gpa = gpax;
	}
	
	public String printInfo() {
		return "The id is: " + this.id + ", the age is: " + this.age + ", and their gpa is:  " + this.gpa;
	}
	
}
