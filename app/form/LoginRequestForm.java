package form;

import javax.persistence.*;
import java.util.*;
//import play.data.validation.Constraints.*;
//import play.data.validation.Constraints;

import com.avaje.ebean.annotation.*;
import play.api.data.validation.*;
import play.data.validation.Constraints.*;
import play.data.validation.ValidationError;


/**
* ログイン画面のフォーム情報を格納するクラス
* @author Satoshi Adachi
*
*/
public class LoginRequestForm {


	// ユーザーID
//	@Required アノテーションよるバリデーション 何故か動かなかった...
//	@Email
	public String userId;

	// パスワードD
	private String password;

	/**
	 * ユーザーIDを取得する
	 * @param なし
	 * @return userId　ユーザーID
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * ユーザーIDを設定する
	 * @param userId　ユーザーID
	 * @return なし
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * パスワードを取得する
	 * @param なし
	 * @return password　パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定する
	 * @param password　パスワード
	 * @return なし
	 */
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * 入力データの妥当性チェック
     * @return エラー情報
     */
    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();

//        System.out.println("userId=" + this.userId);
//        System.out.println("password=" + this.password);

        if (this.userId == null || this.userId.equals("")) {
        	errors.add(new ValidationError("userId", "ユーザーIDは必須です."));
        }
        if (this.password == null || this.password.equals("")) {
        	errors.add(new ValidationError("password", "パスワードは必須です."));
        }
        return errors.isEmpty() ? null : errors;
    }

}