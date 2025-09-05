package com.studentInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> studentList;
	private static Scanner scanner;
	public static void main(String[] args) {
		System.out.println("******************* Student Management System ******************* ");
		
		studentList=new ArrayList<Student>();
		
		while(true)
		{
			System.out.println("***************WELCOME***********************");
			System.out.println("Select an Option");
			System.out.println("1.Register a Student");
			System.out.println("2.Find Student with student-ID");
			System.out.println("3.List All Student Information");
			System.out.println("4.List Student Info In Sorted Order");
			System.out.println("5.Exit");
			
			scanner=new Scanner(System.in);
			int option=scanner.nextInt();
			
			switch(option)
			{
				case 1:enrollStudent(scanner);
						break;
				case 2:findStudentById(scanner);
						break;
				case 3:printAllStudentInfo();
						break;
				case 4:sortByName();
						break;
				case 5:exit();
						break;
				default:
					System.out.println("Invalid Option Selected!... Select Option From 1 to 5.");
			}
		}
		
	}
	
	private static void exit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	private static void printAllStudentInfo() {
		// TODO Auto-generated method stub
		if(studentList.size()>0)
		{
			System.out.println("------------------All Students Info-----------------------");
			for(Student student:studentList)
				student.printStudentInfo();
		}
		else
			System.out.println("No Data Available!....");
	}

	private static void findStudentById(Scanner scanner2) {
		// TODO Auto-generated method stub
		Student studentfound=null;
		System.out.println("Enter the Student ID");
		String studentId=scanner2.next();
		try
		{
			 studentfound=studentList
					.stream()
					.filter(x->x.getStudentId().equalsIgnoreCase(studentId))
					.findFirst()
					.orElseThrow(()-> new RuntimeException("No Data Found !!!..."));
		}
		catch(RuntimeException e)
		{
			System.err.println("Student with ID "+studentId+" Not found!!...");
		}
		studentfound.printStudentInfo();
		
	}

	private static void enrollStudent(Scanner scanner2) {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Name");
		String studentName=scanner2.next();
		
		System.out.println("Enter Student Age");
		int age=scanner2.nextInt();
		
		System.out.println("Enter Student Id");
		String studentId=scanner2.next();
		
		Student newStudent=new Student(studentName,age,studentId);
		studentList.add(newStudent);
		
		while(true)
		{
			System.out.println("Enter the course name to be enrolled...Type Done to exit");
			String courseName=scanner2.next();
			if(courseName.equalsIgnoreCase("done"))
				break;
			newStudent.enrollCourses(courseName);
		}
		
		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student>studentNameComparator=new Comparator<Student>()
		{
			@Override
			public int compare(Student o1,Student o2)
			{
				return o1.getName().compareTo(o2.getName());
			}
			
		};
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
		
	}


}
