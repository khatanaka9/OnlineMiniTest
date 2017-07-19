package controllers;

import javax.inject.Singleton;

import org.apache.commons.lang3.RandomStringUtils;

import play.*;
import play.mvc.*;
import play.mvc.Http.Context;
import models.*;
import views.html.*;
import play.mvc.Http.MultipartFormData;
import play.data.Form;
import play.libs.Json;

//import static play.data.Form.*;
import java.util.*;
import form.*;
import com.avaje.ebean.ExpressionList;


/**
* ログインAPIクラス
* @author Satoshi Adachi
*
*/
@Singleton
public class LoginApiController extends Controller {

	/**
	 * ログイン認証処理を行うアクション
	 * @param なし
	 * @return HTTPレスポンス(RESTに準拠)
	 */
	public Result doLogin() {
		LoginResponse loginResponse = new LoginResponse();


    	//フォームの内容を取得する。
    	Form<LoginRequestForm> loginRequestForm = Form.form(LoginRequestForm.class).bindFromRequest();
//		System.out.println(loginRequestForm.get().getUserId());
//		System.out.println(loginRequestForm.get().getPassword());

    	//リクエストの内容を取得する。
		String userId = loginRequestForm.get().getUserId();
		String password = loginRequestForm.get().getPassword();

		// TODO 検索する前にSQLインジェクション対策を入れてほしい

		// ユーザーテーブルを検索する
		ExpressionList<UserTable> datalist = UserTable.getFind().where().eq("login_id", userId)
    											.eq("login_pw", password);

		// IDとパスワードを照合して、検索がヒットしない場合、ログイン失敗としてforbiddenでレスポンスする
    	if (datalist.findList().size() == 0) {
//    		System.out.println("login failed");
            return forbidden("ログインに失敗しました。");
    	}

//    	System.out.println("login success!!!");

		// トークン生成
		String token = RandomStringUtils.randomAlphabetic(64);
//		System.out.println("token=" + token);
		loginResponse.setToken(token);

		// TODO トークンを格納

		// レスポンスをJSONで返却
		// 例 {token: MRhFHWoxSfLJYcaVILJrVDZApfsANkFvlNuXqXrKanVCBPEBrQJdwNAHrVQcONxl}
		return ok(Json.toJson(loginResponse));

	}

}
