package com.sait.itsc315.problemdomain;

import java.io.IOException;
import java.lang.reflect.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Connor
 */
public class StudentsTest {
    private Student student;
    private Students students;
    
    public StudentsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        this.student = new Student(123456, "Joe Blow", 3.9);
	this.students = new Students();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCannotInherit() {          
        int studentsModifiers = this.students.getClass().getModifiers();           
        assertTrue( "Students is not final",Modifier.isFinal(studentsModifiers));
        int studentModifiers = this.student.getClass().getModifiers();
        assertTrue( "Student is not final", Modifier.isFinal(studentModifiers));
    }
    /**
     * Tests all fields are final.
     */
    @Test
    public void testFieldsFinal() {
            assertTrue(this.student.getClass().getDeclaredFields().length > 0);
            assertTrue(this.students.getClass().getDeclaredFields().length > 0);

            for (Field field : this.student.getClass().getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    assertTrue( "Field '" + field.getName() + "' is not final.", Modifier.isFinal(modifiers));
            }

            for (Field field : this.students.getClass().getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    assertTrue("Field '" + field.getName() + "' is not final.", Modifier.isFinal(modifiers));
            }
    }

    /**
     * Tests all fields are initialized.
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @Test
    public void testFieldsInitialized() throws IllegalArgumentException, IllegalAccessException {
            for (Field field : this.student.getClass().getDeclaredFields()) {
                    field.setAccessible(true);

                    Object value = field.get(this.student);
                    assertNotNull(value);
            }

            for (Field field : this.students.getClass().getDeclaredFields()) {
                    field.setAccessible(true);

                    Object value = field.get(this.students);
                    assertNotNull(value);
            }
    }

    /**
     * Tests there is no mutator methods.
     */
    @Test
    public void testNoMutatorMethods() {
            assertTrue(this.student.getClass().getMethods().length > 0);
            assertTrue(this.students.getClass().getMethods().length > 0);

            for (Method method : this.student.getClass().getDeclaredMethods()) {
                    int modifiers = method.getModifiers();
                    if (Modifier.isPublic(modifiers)) {
                            assertFalse("Method '" + method.getName() + "' is mutable.", method.getName().toLowerCase().startsWith("set"));
                            assertTrue("Method '" + method.getName() + "' is mutable.", method.getParameterCount() == 0);
                    }
            }

            for (Method method : this.students.getClass().getDeclaredMethods()) {
                    int modifiers = method.getModifiers();
                    if (Modifier.isPublic(modifiers)) {
                            assertFalse("Method '" + method.getName() + "' is mutable.", method.getName().toLowerCase().startsWith("set"));
                            assertTrue( "Method '" + method.getName() + "' is mutable.", method.getParameterCount() == 0);
                    }
            }
    }

    /**
     * Tests a copy of students is returned.
     */
    @Test
    public void testStudentsCopied() {
            ArrayList<Student> studentsA = this.students.getStudents();
            ArrayList<Student> studentsB = this.students.getStudents();            
                        
            studentsA.add(this.student);
                     
            assertTrue(studentsA != studentsB);
            assertTrue(studentsA.size() != studentsB.size());
    }
}
