package com.sait.itsc315.problemdomain;

import java.io.*;
import java.util.*;

/**
 * Represents a list of students.
 * @author Nick Hamnett
 * @version January 7, 2021
 */
public final class Students {
	private static final String TEXT_FILE = "res/students.csv";
	
	private final ArrayList<Student> students;
	
	public Students() throws IOException {
		this.students = new ArrayList<>();
		
		this.loadFromTextFile();
	}
	
	/**
	 * Loads students from text file.
	 * @throws IOException
	 */
	private void loadFromTextFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE));
		
		String line = br.readLine();
		
		while (line != null) {
			String[] parts = line.split(",");
			
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			double gpa = Double.parseDouble(parts[2]);
			
			Student student = new Student(id, name, gpa);
			this.students.add(student);
			
			line = br.readLine();
		}
	}
	
	/**
	 * Gets the students.
	 * @return List of students.
	 */
	public ArrayList<Student> getStudents() {         
            return (ArrayList)this.students.clone();
	}
}
