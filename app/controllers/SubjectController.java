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
* @author Ken Hatanaka
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
    	return ok(subjectCreate.render());
    }

    /**
     * 科目を作成するアクション
     */
    public Result createExec(){
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	Subject subject = new Subject();
    	final List<Subject> subjectListId = Subject.getFind().all();

    	//科目IDを取得
    	//TODO IDの形をsubject000等に変更。
    	//TODO 何故かstreamが使用できない。
    	Subject max = null;
    	for(Subject sub:subjectListId){
    		if(max == null){
    			max = sub;
    		}
    		else if(max.getId() < sub.getId()){
    			max = sub;
    		}
    		subject.setId(sub.getId());
    	}
    	subject.setId(subject.getId()+1);
    	subject.setSubjectName(subjectName);
    	subject.save();

    	//TODO subjectListを呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目更新画面を表示するアクション
     */
    public Result update(){
    	Subject subject = new Subject();
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	String name=subjectRequestForm.get().getSubjectName();
    	return ok(subjectUpdate.render(name));
    }

    /**
     * 科目を更新するアクション
     */
    public Result updateExec(){
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	Subject subject = new Subject();
    	subject.setSubjectName(subjectName);
    	subject.update();

    	//TODO subjectListを呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目削除確認画面に遷移するアクション
     */
    public Result delete(){
    	return ok(subjectDelete.render());
    }

    /**
     * 科目を削除するアクション
     */
    public Result deleteExec(){
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();
    	String subjectName =subjectRequestForm.get().getSubjectName();
    	Subject subject = new Subject();
    	subject.setSubjectName(subjectName);
    	subject.delete();

    	//TODO subjectListを呼び出す形に変更したいがエラーとなる
    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

}