package models;

import models.*;
import org.junit.*;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import java.util.*;
import play.*;
import play.test.*;

public class SubjectTest  {

	private String subject_name;
	private String id;
	Subject subject = new Subject();

	@Before
	public void setup(){

		subject_name = "物理";
		id = "subject001";
//		subject.setId(id);
//		subject.setSubjectName(subject_name);
//		subject.save();
//
		Subject subject = new Subject(subject_name,id);
	}


	@Test
	public void equalsSubjectNametest(){
		subject_name = "物理";
		id = "subject001";
		Subject subject = new Subject(subject_name,id);
		assertTrue(subject.getSubjectName().equals(subject_name));
		assertTrue(subject.getId().equals(id));
	}

	@Test
	public void notEqualsSubjectName(){
		String subject_name2 = "物理2";
		String id2 = "subject002";
		Subject subject2 = new Subject(subject_name2,id2);
		assertFalse(subject2.getSubjectName().equals(subject_name));
		assertFalse(subject2.getId().equals(id));
	}

}
