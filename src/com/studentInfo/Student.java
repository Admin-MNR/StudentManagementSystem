package com.studentInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;
	

	public Student(String name, int age, String studentId) {
		super();
		if(validateAge(age) && validateName(name) && validateId(studentId))
		{
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			this.courses=new ArrayList<String>();
		}
	}
	
	private boolean validateId(String studentId2) {
		String studentIdRegex="S-\\d+$";
		Pattern studentIdPattern=Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher=studentIdPattern.matcher(studentId2);
		if(studentIdMatcher.matches())
		{
			return true;
		}
		else
		{
			System.err.println("Invalid Id....Use the format Ex: S-123");
			return false;
		}
		
	}

	public void enrollCourses(String course)
	{
		if(validateCourseName(course))
		{
			if(!courses.contains(course))
			{
				courses.add(course);
				
			}
			else
				System.err.println("Student Already enrolled in the courese:"+course);
			//System.out.println("Student is enrolled"+ course +"Successfully !!");
		}
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void printStudentInfo()
	{
		System.out.println("--------------Student Information-----------------");
		System.out.println("Student Name :"+ name);
		System.out.println("Student Age :"+ age);
		System.out.println("Student id :"+ studentId);
		System.out.println("Enrolled In :"+ courses);
	}
	
	public boolean validateAge(int age)
	{
		if(age>=18 && age <=28)
		{
			return true;
		}
		else
		{
			System.err.println("Student Age must needs to be in between 18 and 28 !!");
			return false;
		}
	}
	
	public boolean validateName(String name)
	{
		//^ -->means start of string with a-z or A-Z and \\s means allows white spaces
		//+ -->means n number of combinations with alphabets
		//$ -->means end with alphabet
		String nameRegex="^[a-zA-Z\\s]+$";
		Pattern namePattern=Pattern.compile(nameRegex);
		Matcher nameMatcher=namePattern.matcher(name);
		if(nameMatcher.matches())
			return true;
		else
		{
			System.err.println("Enter the valid Name !! Please Enter Alphabets only...");
			return false;
		}
		
	}
	
	public boolean validateCourseName(String course)
	{
		if(course.equalsIgnoreCase("java")||course.equalsIgnoreCase("DSA")||course.equalsIgnoreCase("DevOps")||course.equalsIgnoreCase("AI/ML"))
		{
			return true;
		}
		else
		{
			System.err.println("Please Enter Available Courses From list...[Java,DSA,DevOps,AI/ML]");
			return false;
		}
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	public static void main(String[] args) {
		
		

	}

}
