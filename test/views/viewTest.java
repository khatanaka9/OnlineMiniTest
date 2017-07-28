package views;

import static org.junit.Assert.*;
import org.junit.*;


import java.util.*;

import javax.swing.text.AbstractDocument.Content;
import play.mvc.*;
import play.test.*;
import models.*;

/**
 * 科目表示テストクラス
 * @author Ken Hatanaka
 *
 */

public class viewTest {

	// 連番 bango
	private int bango;
	// 科目名 subject_name
	private String subject_name;
	// 科目ID id
	private String id;
	// 表示メッセージ message
	private String message;

	@Before
	public void setup(){
		//科目ID、科目名、表示メッセージを設定
		subject_name = "物理";
		id = "subject001";
		message = "科目IDと科目名を入力してください。";
		Subject subject = new Subject(subject_name,id);
		// TODO ここではEbeanが使用できる？
		subject.save();
	}

	/**
	 * 一覧表示画面が正常な値を表示しているかテストする
	 * @return なし
	 */
	@Test
	public void subjectListViewTest(){
		//全件検索
		List<Subject> subjectList = Subject.getFind().all();
		Subject subject = subjectList.get(0);
		//一覧表示画面表示し、出力される文字列を返す
		String htmlString = contentAsString(subjectListView.render(subjectList));
		//出力された文字列に"物理"が含まれていることを確認
		assertThat(htmlString).contains(subject.subject_name);
		//出力された文字列に"subject001"が含まれていることを確認
		assertThat(htmlString).contains(subject.id);
	}

	/**
	 * 科目作成画面が正常な値を表示しているかテストする
	 * @return なし
	 */
	@Test
	public void subjectCreateTest(){
		//科目作成画面を表示し、出力される文字列を返す
		String htmlString = contentAsString(subjectCreate.render(message,null));
		//出力された文字列に"科目IDと科目名を入力してください。"が含まれていることを確認
		assertThat(htmlString).contains(message);
	}

	/**
	 * 科目更新画面が正常な値を表示しているかテストする
	 * @return なし
	 */
	@Test
	public void subjectUpdateTest(){
		//科目更新画面を表示し、出力される文字列を返す
		String htmlString = contentAsString(subjectUpdate.render(bango,id,subject_name,message,null));
		//出力された文字列に"物理"が含まれていることを確認
		assertThat(htmlString).contains(subject.subject_name);
		//出力された文字列に"subject001"が含まれていることを確認
		assertThat(htmlString).contains(subject.id);
	}

	/**
	 * 科目削除画面が正常な値を表示しているかテストする
	 * @return なし
	 */
	@Test
	public void subjectDeleteTest(){
		//科目削除画面を表示し、出力される文字列を返す
		String htmlString = contentAsString(subjectDelete.render(message,null));
		//出力された文字列に"物理"が含まれていることを確認
		assertThat(htmlString).contains(subject.subject_name);
	}
}
