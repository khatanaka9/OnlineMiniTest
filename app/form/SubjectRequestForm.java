package form;

import javax.persistence.*;
import java.util.*;

import com.avaje.ebean.annotation.*;
import play.api.data.validation.*;
import play.data.validation.Constraints.*;
import play.data.validation.ValidationError;


/**
 * 科目登録、更新、削除画面のフォーム情報を格納するクラス
 * @author Ken Hatanaka
 *
 */
public class SubjectRequestForm {

	//科目名
//	@Required アノテーションでのバリデーション 動かなかった
	public String subject_name;
	//連番 bango
	public int bango;
	//id
//	@Required アノテーションでのバリデーション 動かなかった
	public String id;

	/**
	 * idを取得する
	 * @param なし
	 * @return id 科目ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * idを設定する
	 * @param id 科目ID
	 * @return なし
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * 科目名を取得する
	 * @param なし
	 * @return subject_name 科目名
	 */
	public String getSubjectName(){
		return this.subject_name;
	}

	/**
	 * 科目名を設定する
	 * @param subject_name 科目名
	 * @return なし
	 */
	public void setSubjectName(String subjectName){
		this.subject_name = subjectName;
	}

	/**
	 * 連番を取得する
	 * @param なし
	 * @return bango 連番
	 */
	public int getBango(){
		return bango;
	}

	/**
	 * 連番を設定する
	 * @param なし
	 * @return banago 連番
	 */
	public void setBango(int bango){
		this.bango = bango;
	}

	/**
	 *入力データの妥当性チェック
	 *@return エラー情報
	 */
	public List<ValidationError> validate(){
		List<ValidationError> errors = new ArrayList<ValidationError>();
		if (this.subject_name == null || this.subject_name.equals("")){
			errors.add(new ValidationError("subject_name","科目名は必須です。"));
		}
		if (this.id == null || this.id.equals("")){
			errors.add(new ValidationError("id","科目IDは必須です。"));
		}
		return errors.isEmpty() ? null : errors;
	}
}
