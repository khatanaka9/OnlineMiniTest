package controllers;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.*;
import play.mvc.*;
import play.test.*;
import models.*;

public class SubjectControllerTest {

	//subjectList()で正常終了
	@Test
	public void subjectListTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Result result = routeAndCall(fakeRequest(POST,"/subjectList"));
				assertThat(result).isNotNull();
				assertThat(status(result)).isEqualTo(OK);
			}
		});
	}

	//create()で正常終了
	@Test
	public void createTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Result result = routeAndCall(fakeRequest(POST,"/create"));
				assertThat(result).isNotNull();
				assertThat(status(result)).isEqualTo(OK);
			}
		});
	}

	//createExec()で正常終了
	@Test
	public void createExecTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Map<String, String> subjectName = new HashMap<>();
				Map<String, String> id = new HashMap<>();
				subjectName.put("subjectName","物理");
				id.put("id","subject001");
				Result result =routeAndCall(fakeRequest(POST,"/createExec"),
					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
				assertThat(result.status(), equalTo(Helper.OK));
			}
		});
	}

	//createExec()でバリデーションエラー
	@Test
	public void createExecErrorTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Result result =routeAndCall(fakeRequest(POST,"/createExec"));
				assertThat(result.status(), equalTo(Helper.BAD_REQUEST));
			}
		});
	}

	//update()で正常終了
	@Test
	public void updateTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Map<String, String> subjectName = new HashMap<>();
				Map<String, String> id = new HashMap<>();
				subjectName.put("subjectName","物理");
				id.put("id","subject001");
				Result result =routeAndCall(fakeRequest(POST,"/update"),
					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
				assertThat(result.status(), equalTo(Helper.OK));
			}
		});
	}

	//updateExec()で正常終了
	@Test
	public void updateExecTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Map<String, String> subjectName = new HashMap<>();
				Map<String, String> id = new HashMap<>();
				subjectName.put("subjectName","化学");
				id.put("id","subject002");
				Result result =routeAndCall(fakeRequest(POST,"/updateExec"),
					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
				assertThat(result.status(), equalTo(Helper.OK));
			}
		});
	}

	//updateExec()でバリデーションエラー
	@Test
	public void updateExecErrorTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Result result =routeAndCall(fakeRequest(POST,"/updateExec"));
				assertThat(result.status(), equalTo(Helper.BAD_REQUEST));
			}
		});
	}

	//delete()で正常終了
	@Test
	public void deleteTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Map<String, String> subjectName = new HashMap<>();
				Map<String, String> id = new HashMap<>();
				subjectName.put("subjectName","物理");
				id.put("id","subject001");
				Result result =routeAndCall(fakeRequest(POST,"/delete"),
					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
				assertThat(result.status(), equalTo(Helper.OK));
			}
		});
	}

	//deleteExec()で正常終了
	@Test
	public void deleteExecTest(){
		running(fakeApplication(),new Runnable() {
			@Override
			public void run() {
				Map<String, String> subjectName = new HashMap<>();
				Map<String, String> id = new HashMap<>();
				subjectName.put("subjectName","物理");
				id.put("id","subject001");
				Result result =routeAndCall(fakeRequest(POST,"/deleteExec"),
					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
				assertThat(result.status(), equalTo(Helper.OK));
			}
		});
	}
}
