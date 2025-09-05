package com.studentInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static List<Student> studentList;
	public static void main(String[] args) {
		System.out.println("******************* Student Management System ******************* ");
		
		studentList=new ArrayList<Student>();
		Student s1;
		s1=new Student("Tom", 22, "S-2");
		s1.enrollCourses("AI/ML");
		s1.enrollCourses("Java");
		
		
		Student s2=new Student("Kim",23,"S-17");
		s2.enrollCourses("DSA");
		
		
		Student s3=new Student("Jimmy",23,"S-27");
		s3.enrollCourses("DSA");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		Student result=findStudentById("S-17");
		System.out.println(result);
		sortByName();
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

	public static Student findStudentById(String studentId)
	{
		Student result=null;
		try
		{
			 result=studentList
					.stream()
					.filter(x->x.getStudentId().equalsIgnoreCase(studentId))
					.findFirst()
					.orElseThrow(()-> new RuntimeException("No Data Found !!!..."));
		}
		catch(RuntimeException e)
		{
			System.err.println("Student with ID "+studentId+" Not found!!...");
		}
		
		return result;
	}
}
