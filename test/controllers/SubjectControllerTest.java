package controllers;

import static controllers.SubjectController.*;
import static org.junit.Assert.*;

import java.nio.charset.Charset;
import org.junit.*;
import com.sun.org.apache.xerces.internal.util.Status;
import jdk.nashorn.internal.ir.RuntimeNode.Request;


import java.util.*;
import javax.xml.transform.Result;
import play.*;
import models.*;

public class SubjectControllerTest {

	@Before
	public void setup(){
	}

	@Test
	public void subjectListTest(){
		Result result = Helper.routes(controllers.SubjectController.subjectList());
		assertThat(result, equalTo(OK));

	}

	public void createTest(){
	}

	public void createExecTest(){

	}
}
