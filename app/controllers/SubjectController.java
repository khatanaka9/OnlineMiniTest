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


/**
* 科目クラス
*
*/
@Singleton
public class SubjectController extends Controller {


	/**
	 * 科目一覧を表示するアクション
	 */
    public Result subjectList() {
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目作成画面を表示するアクション
     */
    public Result create(){
    	return ok(subjectCreate.render("科目IDと科目名を入力してください。", null));
    }

    /**
     * 科目を作成するアクション
     */
    public Result createExec(){
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();

    	// バリデーション
    	if (subjectRequestForm.hasErrors()) {
			System.out.println("バリデーションエラー");
			return badRequest(subjectCreate.render("科目登録に失敗しました。科目IDと科目名を入力してください。", subjectRequestForm));
    	}

    	Subject subject = new Subject();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	String subjectId =subjectRequestForm.get().getId();
    	subject.setId(subjectId);
    	subject.setSubjectName(subjectName);
    	subject.save();

    	//TODO subjectList()を呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目更新画面を表示するアクション
     */
    public Result update(){
    	Subject subject = new Subject();
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	String id = subjectRequestForm.get().getId();
    	String name = subjectRequestForm.get().getSubjectName();
    	return ok(subjectUpdate.render(id,name,"科目IDと科目名を入力してください。",null));
    }

    /**
     * 科目を更新するアクション
     */
    public Result updateExec(){

    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	Subject subject = new Subject();

    	//TODO 項目未入力時に値が取得できない
//    	String id =subjectRequestForm.get().getId();
//    	String name =subjectRequestForm.get().getSubjectName();

    	String id =null;
    	String name =null;
    	// バリデーション
    	if (subjectRequestForm.hasErrors()) {
			System.out.println("バリデーションエラー");
			return badRequest(subjectUpdate.render(id,name,"科目編集に失敗しました。科目IDと科目名を入力してください。", subjectRequestForm));
    	}


    	String subjectId =subjectRequestForm.get().getId();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	subject.setId(subjectId);
    	subject.setSubjectName(subjectName);
    	subject.update();

    	//TODO subjectList()を呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目削除確認画面に遷移するアクション
     */
    public Result delete(){

    	Subject subject = new Subject();
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	String id = subjectRequestForm.get().getId();
    	String name = subjectRequestForm.get().getSubjectName();
    	return ok(subjectDelete.render(id,name,null));
    }

    /**
     * 科目を削除するアクション
     */
    public Result deleteExec(){
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	Subject subject = new Subject();
    	String subjectId =subjectRequestForm.get().getId();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	subject.setId(subjectId);
    	subject.setSubjectName(subjectName);
    	subject.delete();

    	//TODO subjectList()を呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

}