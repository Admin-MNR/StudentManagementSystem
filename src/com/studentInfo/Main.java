package com.studentInfo;

public class Main {

	public static void main(String[] args) {
		System.out.println("******************* Student Management System ******************* ");
		
		Student s1;
		s1=new Student("Tom", 22, "S-2");
		s1.enrollCourses("AI/ML");
		s1.enrollCourses("Java");
		s1.printStudentInfo();
		
		Student s2=new Student("Kim",23,"S-17");
		s2.enrollCourses("DSA");
		s2.printStudentInfo();
		
		Student s3=new Student("Jimmy",23,"S-27");
		s3.enrollCourses("DSA");
		s3.printStudentInfo();
		

	}

}
