package controllers;

import java.util.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PRIVATE_MEMBER;

import play.*;
import play.mvc.*;
import play.mvc.Http.Context;
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
     * 科目を作成するアクション
     * */
    public Result create(){
    	return ok(subjectCreate.render());
    }

    public Result createExec(){
    	SubjectName subjectName = new SubjectName();
    	Subject subject = new Subject();
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();

    	System.out.println(subjectRequestForm.get().getSubjectName());
    	System.out.println(subjectName);

    	String a =subjectRequestForm.get().getSubjectName();
    	System.out.println(a);
    	subjectName.setSubjectName(a);
    	subjectName.save();
    	System.out.println(subjectName);
    	subject.setSubjectName(subjectName);
    	subject.save();


		final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }


    /**
     * 科目を更新するアクション
     * */
    public Result update(){
    	return ok(subjectUpdate.render());
    }
    public Result updateExec(){
    	SubjectName subjectName = new SubjectName();
    	Subject subject = new Subject();
    	Form<SubjectRequestForm> subjectRequestForm = Form.form(SubjectRequestForm.class).bindFromRequest();

    	subjectName.setSubjectName(subjectRequestForm.get().getSubjectName());
    	subjectName.save();
    	subject.setSubjectName(subjectName);
    	subject.save();

    	final List<Subject> subjectList = Subject.getFind().all();
    	return ok(subjectListView.render(subjectList));
    }

    /**
     * 科目を削除するアクション
     * */
    public Result delete(){
    	return ok(subjectDelete.render());
    }

}