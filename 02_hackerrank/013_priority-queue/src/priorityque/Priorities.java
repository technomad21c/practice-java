package priorityque;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Priorities {
	public List <Student> getStudents(List<String> events) {
		PriorityQueue<Student> pq = new PriorityQueue(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));		
		
		String name;
		int id;
		double cgpa;
		
		for (String e : events) {
			String[] tokens = e.split("\\s+");
			String cmd = tokens[0];
			switch(cmd) {
				case "ENTER":
					name = tokens[1];
					cgpa = Double.parseDouble(tokens[2]);
					id = Integer.parseInt(tokens[3]);						
					pq.add(new Student(id, name, cgpa));
					System.out.println("new student added: " + name + ", " + cgpa + ", " + id);
					break;
				case "SERVED":
					pq.poll();
					break;
				default:
					break;
			}
		}
		
		return new ArrayList<Student>(pq);
	}
}
