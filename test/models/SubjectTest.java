package models;

import models.*;
import org.junit.*;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import java.util.*;
import play.*;
import play.test.*;

/**
 * 科目エンティティテストクラス
 * @author Ken Hatanaka
 *
 */

public class SubjectTest  {

	// 科目名 subject_name
	private String subject_name;
	// 科目ID id
	private String id;
	Subject subject = new Subject();

	@Before
	public void setup(){

		//科目名、科目IDに初期値を設定
		subject_name = "物理";
		id = "subject001";
// 		TODO ebeanが使用できない
//		subject.setId(id);
//		subject.setSubjectName(subject_name);
//		subject.save();
		Subject subject = new Subject(subject_name,id);
	}

	/**
	 * 科目名、科目IDが登録した内容と一致することをテストする
	 */
	@Test
	public void equalsSubjectNameTest(){

		//登録されている科目名、科目IDが、指定した値と一致する事を確認
		assertTrue(subject.getSubjectName().equals("物理"));
		assertTrue(subject.getId().equals("subject001"));
	}

	/**
	 * 科目名、科目IDが登録した内容と一致しないことをテストする
	 */
	@Test
	public void notEqualsSubjectNameTest(){
		//科目名、科目IDを新規に登録する
		String subject_name2 = "物理2";
		String id2 = "subject002";
		Subject subject2 = new Subject(subject_name2,id2);
		//登録されている科目名、科目IDが、指定した値と一致しないことを確認
		assertFalse(subject2.getSubjectName().equals("物理"));
		assertFalse(subject2.getId().equals("subject001"));
	}

}
