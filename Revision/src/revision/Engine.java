package revision;

public class Engine {
	public static void main(String[] args) {
		Student[] students = new Student[5];
		
		/*
		 * [st2, st1]
		*/
		//sort students by age
		Student temp = students[0];
		for(int i = 0; i < students.length; i++) {
			for(int j = i; j < students.length; j++) {
				if(students[i].age < temp.age) {
					temp = students[i];
				}
			}
			
		}
	}
}
