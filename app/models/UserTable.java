package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;

import com.avaje.ebean.annotation.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * ユーザーテーブルエンティティクラス
 *
 */
@Entity
@Table(name = "user_table")
public class UserTable extends Model {

	/**
	 * find
	 */
	private static Find<Long, UserTable> find = new Find<Long, UserTable>() {
	};

	/**
	 * ID
	 */
	@Id
	@Column(name = "ID")
	private int id;

	/**
	 * IDを取得する
	 * @param なし
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * トークンを設定する
	 * @param token　トークン
	 * @return なし
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ユーザーID
	 */
	@Column(name = "login_id")
	private String loginId;

	/**
	 * ログインIDを取得する
	 * @param なし
	 * @return loginId　ログインID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * ログインIDを設定する
	 * @param loginId　ログインID
	 * @return なし
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * パスワード
	 */
	@Column(name = "login_pw")
	private String loginPw;

	/**
	 * パスワードを取得する
	 * @param なし
	 * @return loginPw　loginPw
	 */
	public String getLoginPw() {
		return loginPw;
	}

	/**
	 * パスワードを設定する
	 * @param loginPw　パスワード
	 * @return なし
	 */
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	/**
	 * トークン
	 */
	@Column(name = "token")
	private String token;

	/**
	 * トークンを取得する
	 * @param なし
	 * @return token　トークン
	 */
	public String getToken() {
		return token;
	}

	/**
	 * トークンを設定する
	 * @param token　トークン
	 * @return なし
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 登録日時
	 */
	@CreatedTimestamp
	@Column(name = "insert_date")
	private Timestamp insertDate;

	/**
	 * 登録日時を取得する
	 * @param なし
	 * @return insertDate　登録日時
	 */
	public Timestamp getInsertDate() {
		return insertDate;
	}

	/**
	 * 登録日時を設定する
	 * @param insertDate　登録日時
	 * @return なし
	 */
	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * 更新日時
	 */
	@UpdatedTimestamp
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**
	 * 更新日時を取得する
	 * @param なし
	 * @return updateDate　更新日時
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新日時を設定する
	 * @param updateDate　更新日時
	 * @return なし
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * find取得
	 *
	 * @return find
	 */
	public static Find<Long, UserTable> getFind() {
		return find;
	}


	/**
	 * find設定
	 *
	 * @param find
	 *
	 */
	public static void setFind(Find<Long, UserTable> find) {
		UserTable.find = find;
	}

}