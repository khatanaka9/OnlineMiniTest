package form;

import javax.persistence.*;
import java.util.*;
//import play.data.validation.Constraints.*;
//import play.data.validation.Constraints;

import com.avaje.ebean.annotation.*;
import play.api.data.validation.*;
import play.data.validation.Constraints.*;
import play.data.validation.ValidationError;

public class SubjectRequestForm {

	//科目名
	public String subject_name;
	//連番
	public int bango;

	/**
	 * 科目名を取得する
	 */

	public String getSubjectName(){
		return this.subject_name;
	}

	/**
	 * 科目名を設定する
	 */
	public void setSubjectName(String subjectName){
		this.subject_name = subjectName;
	}

	/**
	 * 連番を取得する
	 */
	public int getBango(){
		return bango;
	}

	/**
	 * 連番を設定する
	 */
	public void setBango(int bango){
		this.bango = bango;
	}


}
