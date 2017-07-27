package views;

import static org.junit.Assert.*;
import org.junit.*;


import java.util.*;

import javax.swing.text.AbstractDocument.Content;
import play.mvc.*;
import play.test.*;
import models.*;

public class viewTest {

	private int bango;
	private String subject_name;
	private String id;
	private String message;

	@Before
	public void setup(){
		subject_name = "物理";
		id = "subject001";
		message = "科目IDと科目名を入力してください。";
		Subject subject = new Subject(subject_name,id);
		// TODO ここではebeanが使用できる？
		subject.save();

	}

	//subjectListViewの表示テスト
	@Test
	public void subjectListViewTest(){
		List<Subject> subjectList = Subject.getFind().all();
		Subject subject = subjectList.get(0);
		String htmlString = contentAsString(subjectListView.render(subjectList));
		assertThat(htmlString).contains(subject.subject_name);
		assertThat(htmlString).contains(subject.id);
	}

	//subjectCreateの表示テスト
	@Test
	public void subjectCreateTest(){
		String htmlString = contentAsString(subjectCreate.render(message,null));
		assertThat(htmlString).contains(message);
	}

	//subjectUpdateの表示テスト
	@Test
	public void subjectUpdateTest(){
		String htmlString = contentAsString(subjectUpdate.render(bango,id,subject_name,message,null));
		List<Subject> subjectList = Subject.getFind().all();
		Subject subject = subjectList.get(0);
		assertThat(htmlString).contains(subject.subject_name);
		assertThat(htmlString).contains(subject.id);
	}

	//subjectDeleteの表示テスト
	@Test
	public void subjectDeleteTest(){
		String htmlString = contentAsString(subjectDelete.render(message,null));
		List<Subject> subjectList = Subject.getFind().all();
		Subject subject = subjectList.get(0);
		assertThat(htmlString).contains(subject.subject_name);
	}


}
