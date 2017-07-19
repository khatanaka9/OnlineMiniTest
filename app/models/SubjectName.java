package models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;

import com.avaje.ebean.annotation.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.*;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 科目名エンティティクラス
 *
 */
@Entity(name = "Subject_name")
public class SubjectName extends Model{

	/**
	 * ID
	 */
	@Id
	@Column(name = "ID")
	private int id;

	/**
	 * IDを取得する
	 */
	public int getId() {
		return id;
	}

	/**
	 * IDを設定する
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * 科目名
	 */
	@Column(name = "subject_name")
	private String subjectName;

	/**
	 * 科目名を取得する
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * 科目名を設定する
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


}
