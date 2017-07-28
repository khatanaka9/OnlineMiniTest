package controllers;

import java.util.*;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.*;
import play.mvc.*;
import models.*;


import views.html.*;
import play.mvc.Http.MultipartFormData;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import form.*;
import com.avaje.ebean.ExpressionList;

/**
* 科目コントローラクラス
* @author Ken Hatanaka
*/
@Singleton
public class SubjectController extends Controller {

	/**
	 * 科目一覧を表示するアクション
	 * @param なし
	 * @return HTTPレスポンス(RESTに準拠)
	 */
    public Result subjectList() {
    	//全件検索
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目作成画面を表示するアクション
     * @param なし
     * @return HTTPレスポンス(RESTに準拠)
     */
    public Result create(){
    	return ok(subjectCreate.render("科目IDと科目名を入力してください。", null));
    }

    /**
     * 科目を作成するアクション
     * @param なし
     * @return HTTPレスポンス(RESTに準拠)
     */
    public Result createExec(){
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();

    	// バリデーション
    	// フォームが未入力に場合
    	if (subjectRequestForm.hasErrors()) {
			System.out.println("バリデーションエラー");
			return badRequest(subjectCreate.render("科目登録に失敗しました。科目IDと科目名を入力してください。", subjectRequestForm));
    	}
    	Subject subject = new Subject();

    	//フォームの内容を取得する
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	String subjectId =subjectRequestForm.get().getId();

    	//取得した値を登録する
    	subject.setId(subjectId);
    	subject.setSubjectName(subjectName);
    	subject.save();

    	//TODO subjectList()を呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目更新画面を表示するアクション
     * @param なし
     * @return HTTPレスポンス(RESTに準拠)
     */
    public Result update(){

    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	Subject subject = new Subject();
    	//フォームの内容を取得する
    	int bango = subjectRequestForm.get().getBango();
    	String id = subjectRequestForm.get().getId();
    	String name = subjectRequestForm.get().getSubjectName();

    	return ok(subjectUpdate.render(bango,id,name,"科目IDと科目名を入力してください。",null));
    }

    /**
     * 科目を更新するアクション
     * @param なし
     * @return HTTPレスポンス(RESTに準拠)
     */
    public Result updateExec(){

    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	Subject subject = new Subject();
    	// バリデーション
    	// フォームが未入力の場合
    	if (subjectRequestForm.hasErrors()) {
			System.out.println("バリデーションエラー");
			//フォームから選択した科目を取得する
			int bango = subjectRequestForm.get().getBango();

			//選択した科目を検索する
			ExpressionList<Subject> datalist = Subject.getFind().where().eq("bango", bango);
			List<Subject> data = datalist.findList();
			//選択した科目IDと科目名を取得する
			String id =data.get(0).getId();
			String name =data.get(0).getSubjectName();
			return badRequest(subjectUpdate.render(bango,id,name,"科目編集に失敗しました。科目IDと科目名を入力してください。", subjectRequestForm));
    	}
    	//フォームの内容を取得する
    	String subjectId =subjectRequestForm.get().getId();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	//取得した値を登録する
    	subject.setId(subjectId);
    	subject.setSubjectName(subjectName);
    	subject.update();

    	//TODO subjectList()を呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目削除確認画面に遷移するアクション
     * @param なし
     * @return HTTPレスポンス(RESTに準拠)
     */
    public Result delete(){
    	Subject subject = new Subject();
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	//フォームから選択した科目を取得
    	String id = subjectRequestForm.get().getId();
    	String name = subjectRequestForm.get().getSubjectName();
    	return ok(subjectDelete.render(id,name,null));
    }

    /**
     * 科目を削除するアクション
     * @param なし
     * @return HTTPレスポンス(RESTに準拠)
     */
    public Result deleteExec(){
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	Subject subject = new Subject();
    	//フォームから選択した科目を取得する
    	String subjectId =subjectRequestForm.get().getId();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	//選択した科目を削除する
    	subject.setId(subjectId);
    	subject.setSubjectName(subjectName);
    	subject.delete();

    	//TODO subjectList()を呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

}