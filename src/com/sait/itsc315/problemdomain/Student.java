package com.sait.itsc315.problemdomain;

/**
 * Represents a student.
 * @author Nick Hamnett
 * @version January 7, 2021
 */
public final class Student {
	private final int id;
	private final String name;
	private final double gpa;
	
	/**
	 * Constructor for a student.
	 * @param id Student's ID
	 * @param name Name of student.
	 * @param gpa Student's GPA.
	 */
	public Student(int id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	
	/**
	 * Gets student's ID
	 * @return ID
	 */
	public int getId() {
		return this.id;
	}	
	
	/**
	 * Gets student's name
	 * @return Name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets student's GPA
	 * @return GPA
	 */
	public double getGpa() {
		return this.gpa;
	}		
	
	public String toString() {
		return String.format("%d - %s - %.2f", this.id, this.name, this.gpa);
	}
}
