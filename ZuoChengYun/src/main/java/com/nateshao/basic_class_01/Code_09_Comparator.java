package com.nateshao.basic_class_01;

import java.util.*;

/**
 * 比较器
 */
public class Code_09_Comparator {

	public static class Student {
		public String name;
		public int id;
		public int age;

		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}

	/**
	 * id 升序
	 */
	public static class IdAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.id - o2.id;
		}

	}

	/**
	 * id 降序
	 */
	public static class IdDescendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.id - o1.id;
		}

	}

	/**
	 * 年龄升序
	 */
	public static class AgeAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
//			if (o1.id<o2.id){
//				return -1;
//			}else if (o1.id>o2.id){
//				return 1;
//			}else {
//				return 0;
//			}
		}

	}

	/**
	 * 年龄降序
	 */
	public static class AgeDescendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.age - o1.age;
		}

	}

	public static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
		}
		System.out.println("===========================");
	}

	public static void main(String[] args) {
		Student student1 = new Student("A", 1, 23);
		Student student2 = new Student("B", 2, 21);
		Student student3 = new Student("C", 3, 22);

		Student[] students = new Student[] { student3, student2, student1 };
		printStudents(students);// CBA

		Arrays.sort(students, new IdAscendingComparator());
		printStudents(students);// ID: 123

		Arrays.sort(students, new IdDescendingComparator());
		printStudents(students);

		Arrays.sort(students, new AgeAscendingComparator());
		printStudents(students);

		Arrays.sort(students, new AgeDescendingComparator());
		printStudents(students);


		/**
		 * 优先级队列。--堆
		 */
		PriorityQueue<Student> head = new PriorityQueue<>(new IdAscendingComparator());
		head.add(student1);
		head.add(student2);
		head.add(student3);
		System.out.println("---------------- PriorityQueue ---------------");
		while (!head.isEmpty()){
			Student student = head.poll();
			System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
		}

		System.out.println("---------------- PriorityQueue ---------------");
		TreeSet<Student> treeSet = new TreeSet<>(new IdAscendingComparator());
		treeSet.add(student1);
		treeSet.add(student2);
		treeSet.add(student3);
		while (!treeSet.isEmpty()){
			for (Student student : treeSet) {
				System.out.println(student);
			}
		}
	}

}
