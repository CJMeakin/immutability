package com.sait.itsc315.application;

import java.io.*;

import com.sait.itsc315.problemdomain.*;

/**
 * Application Driver
 * @author Nick Hamnett
 * @version January 7, 2021
 */
public class AppDriver {

	/**
	 * Entry point for program.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Students students = new Students();
		
		System.out.println("Students:");
		for (Student student : students.getStudents()) {
			System.out.println(student);
		}
	}

}
