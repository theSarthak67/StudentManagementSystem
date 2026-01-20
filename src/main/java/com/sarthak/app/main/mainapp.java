package com.sarthak.app.main;

import com.sarthak.app.dao.*;
import com.sarthak.app.model.Student;

import java.util.List;
import java.util.Scanner;

public class mainapp {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoImpl();
        try (Scanner sc = new Scanner(System.in)) {
			while (true) {
			    System.out.println("\n--- Student Management System ---");
			    System.out.println("1. Add Student");
			    System.out.println("2. View All Students");
			    System.out.println("3. Search Student by ID");
			    System.out.println("4. Update Student");
			    System.out.println("5. Delete Student");
			    System.out.println("6. Exit");

			    System.out.print("Choose option: ");
			    int choice = sc.nextInt();
			    
			    switch (choice) {
			    case 1:
			    	System.out.print("ID: ");
			    	int id = sc.nextInt();
			    	sc.nextLine();
			        System.out.print("Name: ");
			        String name = sc.nextLine();
			        System.out.print("Age: ");
			        int age = sc.nextInt();
			        sc.nextLine();
			        System.out.print("Email: ");
			        String email = sc.nextLine();
			        System.out.print("Course: ");
			        String course = sc.nextLine();

			        dao.addStudent(new Student(id, name, age, email, course));
			        break;

			    case 2:
			        List<Student> students = dao.getAllStudents();
			        for (Student s : students) {
			            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getCourse());
			        }
			        break;

			    case 3:
			        System.out.print("Enter ID: ");
			        Student s = dao.getStudentById(sc.nextInt());
			        if (s != null)
			            System.out.println(s.getName() + " | " + s.getEmail());
			        else
			            System.out.println("Student not found");
			        break;

			    case 4:
			        System.out.print("ID: ");
			        int d = sc.nextInt();
			        sc.nextLine();
			        System.out.print("New Name: ");
			        String n = sc.nextLine();
			        System.out.print("New Age: ");
			        int a = sc.nextInt();
			        sc.nextLine();
			        System.out.print("New Email: ");
			        String e = sc.nextLine();
			        System.out.print("New Course: ");
			        String c = sc.nextLine();

			        Student stu = new Student(d, n, a, e, c);
			        stu.setId(d);
			        dao.updateStudent(stu);
			        break;

			    case 5:
			        System.out.print("ID to delete: ");
			        dao.deleteStudent(sc.nextInt());
			        break;

			    case 6:
			        System.out.println("Exiting...");
			        System.out.println("Exited ");
			        System.exit(0);
			}
   }
		}
	}

}
