package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.avaje.ebean.annotation.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.*;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;


/**
 * 科目エンティティクラス
 *
 */
@Entity(name = "Subject")
public class Subject extends Model {


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

	/**
	 * 連番
	 */
	@Column(name = "bango")
	private int bango;

	/**
	 * 連番を取得する
	 * @param なし
	 * @return bango
	 * */
	public int getBango(){
		return bango;
	}

	/**
	 * 連番を設定する
	 * @param Bango 連番
	 */
	public void setBango(int bango) {
		this.bango = bango;
	}

		/**
		 * find
		 */
		private static Find<Long, Subject> find = new Find<Long, Subject>() {
		};
	 /**
		 * find取得
		 */
		public static Find<Long, Subject> getFind() {
			return find;
		}


		/**
		 * find設定
		 */
		public static void setFind(Find<Long, Subject> find) {
			Subject.find = find;
		}
}