package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
* ログイン処理実施後のレスポンスクラス
* @author Satoshi Adachi
*
*/
public class LoginResponse {

	// トークン
	public String token;

	/**
	 * コンストラクタ
	 * @param なし
	 */
	public LoginResponse(){}

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

}