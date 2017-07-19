package controllers;

import javax.inject.Singleton;

import play.*;
import play.mvc.*;
import play.mvc.Http.Context;
import play.mvc.Http.Cookie;
import models.*;

import views.html.*;
import play.mvc.Http.MultipartFormData;
import util.CustomHttpClient;
import play.data.Form;

import java.io.IOException;
//import static play.data.Form.*;
import java.util.*;
import form.*;
import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
* ログインAPIクラス
* @author Satoshi Adachi
*
*/
@Singleton
public class LoginController extends Controller {

	// ログインAPI URL
	private String _loginApitUrl;

	// content-type
	private String _contentType;

	//リクエスト パラメーター
	private String _formParam = null;

	/**
	 * ログインページへ遷移するアクション
	 * @param なし
	 * @return HTTPレスポンス(RESTに準拠)
	 */
    public Result login() {
//    	Form<LoginRequestForm> loginRequestForm = Form.form(LoginRequestForm.class).bindFromRequest();
//        return ok(login.render("IDとパスワードを入力してください。", loginRequestForm));
        return ok(login.render("IDとパスワードを入力してください。", null));
    }

	/**
	 * 認証成功の場合、ログインページへ遷移するアクション
	 * @param なし
	 * @return HTTPレスポンス(RESTに準拠)
	 */
    public Result doLogin() {
    	//フォームの内容を取得する。
    	Form<LoginRequestForm> loginRequestForm = Form.form(LoginRequestForm.class).bindFromRequest();
//		System.out.println(loginRequestForm.get().getUserId());
//		System.out.println(loginRequestForm.get().getPassword());

    	// TODO バリデーション
    	if (loginRequestForm.hasErrors()) {
			System.out.println("バリデーションエラー");
			return badRequest(login.render("ログインに失敗しました。IDとパスワードを再度入力してください。", loginRequestForm));
    	}

		// リクエストパラメータを生成
		StringBuilder formParamBuilder = new StringBuilder("userId=");
    	formParamBuilder.append(loginRequestForm.get().getUserId());
    	formParamBuilder.append("&password=");
    	formParamBuilder.append(loginRequestForm.get().getPassword());

//		System.out.println("formParam=" + formParamBuilder.toString());

    	this._formParam = formParamBuilder.toString();

    	// ログインAPIにアクセス
    	String jsonRes = null;

		this._loginApitUrl = Play.application()
				.configuration()
				.getString("application.login.url");

		System.out.println("url=" + this._loginApitUrl);

		this._contentType = Play.application()
		     .configuration()
		     .getString("application.login.content-type");

		System.out.println("content-type=" + this._contentType);

    	try {
        	jsonRes = CustomHttpClient.callPost(this._loginApitUrl, this._contentType, this._formParam);
		} catch (Exception e) {
//			System.out.println("ログインに失敗しました。");
			return forbidden(login.render("ログインに失敗しました。IDとパスワードを再度入力してください。", loginRequestForm));
		}

    	// レスポンスを解析して、トークンを取得する
    	String token = null;
    	try {
        	ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(jsonRes);
			token = root.get("token").asText();

			//TODO 取得してトークンをクッキーに保存する

//			System.out.println("token=" + token);

    	} catch (JsonProcessingException e) {
			e.printStackTrace();
			return forbidden(login.render("ログインに失敗しました。IDとパスワードを再度入力してください。", loginRequestForm));
		} catch (IOException e) {
			e.printStackTrace();
			return forbidden(login.render("ログインに失敗しました。IDとパスワードを再度入力してください。", loginRequestForm));
		}

    	return ok(kenshu_main.render(token)).withCookies(Cookie.builder("token", token).build());
    }

}
