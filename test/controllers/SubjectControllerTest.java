//package controllers;
//
//import static org.junit.Assert.*;
//
//import org.junit.*;
//
//import java.util.*;
//import play.mvc.*;
//import play.test.*;
//import models.*;
//
///**
// * 科目コントローラテストクラス
// * @author Ken Hatanaka
// *
// */
//
//public class SubjectControllerTest {
//
//	/**
//	 * 一覧表示処理にPOSTでアクセスし、正常に一覧表示画面が表示されることをテストする
//	 * @return なし
//	 */
//	@Test void subjectListTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//一覧表示処理にPOSTでアクセス
//				Result result = routeAndCall(fakeRequest(POST,"/subjectList"));
//				//POSTでアクセス出来ているか確認
//				assertTrue(result).isNotNull();
//				//一覧画面が正常に表示されているか確認
//				assertTrue(status(result)).isEqualTo(OK);
//			}
//		});
//	}
//
//	/**
//	 * 科目登録画面表示処理にPOSTでアクセスし、正常に科目登録画面が表示されることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void createTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//科目登録画面表示処理にPOSTでアクセス
//				Result result = routeAndCall(fakeRequest(POST,"/create"));
//				//POSTでアクセス出来ているか確認
//				assertTrue(result).isNotNull();
//				//科目登録画面が正常に表示されているか確認
//				assertTrue(status(result)).isEqualTo(OK);
//			}
//		});
//	}
//
//	/**
//	 * 科目登録処理にPOSTでアクセスし、登録処理を正常に実施し、一覧画面が表示されることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void createExecTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//科目名、科目IDを設定
//				Map<String, String> subjectName = new HashMap<>();
//				Map<String, String> id = new HashMap<>();
//				subjectName.put("subjectName","物理");
//				id.put("id","subject001");
//				//フォームから科目名、科目IDを渡し、科目登録処理にPOSTでアクセス
//				Result result =routeAndCall(fakeRequest(POST,"/createExec"),
//					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
//				//一覧表示画面が正常に表示されていることを確認
//				assertTrue(result.status(), equalTo(Helper.OK));
//			}
//		});
//	}
//
//	/**
//	 * 科目登録処理にPOSTでアクセスし、BadRequestが帰ってくることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void createExecErrorTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//フォームから値を渡さずに、科目登録処理にPOSTでアクセス
//				Result result =routeAndCall(fakeRequest(POST,"/createExec"));
//				//BadRequestが返ることを確認
//				assertTrue(result.status(), equalTo(Helper.BAD_REQUEST));
//			}
//		});
//	}
//
//	/**
//	 * 科目更新画面表示処理にPOSTでアクセスし、正常に科目更新画面が表示されることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void updateTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//科目名、科目IDを設定
//				Map<String, String> subjectName = new HashMap<>();
//				Map<String, String> id = new HashMap<>();
//				subjectName.put("subjectName","物理");
//				id.put("id","subject001");
//				//フォームから科目名、科目IDを渡し、科目更新画面表示処理にPOSTでアクセス
//				Result result =routeAndCall(fakeRequest(POST,"/update"),
//					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
//				//科目更新画面が正常に表示されていることを確認
//				assertTrue(result.status(), equalTo(Helper.OK));
//			}
//		});
//	}
//
//	/**
//	 * 科目更新処理にPOSTでアクセスし、更新処理を正常に実施し、一覧画面が表示されることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void updateExecTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//科目名、科目IDを設定
//				Map<String, String> subjectName = new HashMap<>();
//				Map<String, String> id = new HashMap<>();
//				subjectName.put("subjectName","化学");
//				id.put("id","subject002");
//				//フォームから科目名、科目IDを渡し、科目更新処理にPOSTでアクセス
//				Result result =routeAndCall(fakeRequest(POST,"/updateExec"),
//					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
//				//一覧表示画面が正常に表示されることを確認
//				assertTrue(result.status(), equalTo(Helper.OK));
//			}
//		});
//	}
//
//	/**
//	 * 科目更新処理にPOSTでアクセスし、BadRequestが帰ってくることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void updateExecErrorTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//フォームから値を渡さずに、科目更新処理にPOSTでアクセス
//				Result result =routeAndCall(fakeRequest(POST,"/updateExec"));
//				//BadRequestが返ることを確認
//				assertTrue(result.status(), equalTo(Helper.BAD_REQUEST));
//			}
//		});
//	}
//
//	/**
//	 * 科目削除画面表示処理にPOSTでアクセスし、正常に科目削除画面が表示されることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void deleteTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//科目名、科目IDを設定
//				Map<String, String> subjectName = new HashMap<>();
//				Map<String, String> id = new HashMap<>();
//				subjectName.put("subjectName","物理");
//				id.put("id","subject001");
//				//フォームから科目名、科目IDを渡し、科目削除画面表示処理にPOSTでアクセス
//				Result result =routeAndCall(fakeRequest(POST,"/delete"),
//					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
//				//科目削除画面が正常に表示されることを確認
//				assertTrue(result.status(), equalTo(Helper.OK));
//			}
//		});
//	}
//
//	/**
//	 * 科目削除処理にPOSTでアクセスし、削除処理を正常に実施し、一覧画面が表示されることをテストする
//	 * @return なし
//	 */
//	@Test
//	public void deleteExecTest(){
//		running(fakeApplication(),new Runnable() {
//			@Override
//			public void run() {
//				//科目名、科目IDを設定
//				Map<String, String> subjectName = new HashMap<>();
//				Map<String, String> id = new HashMap<>();
//				subjectName.put("subjectName","物理");
//				id.put("id","subject001");
//				//フォームから科目名、科目IDを渡し、科目削除処理にPOSTでアクセス
//				Result result =routeAndCall(fakeRequest(POST,"/deleteExec"),
//					fakeRequest(),withFormUrlEncodedBody(subjectName,id));
//				//一覧表示画面が正常に表示されることを確認
//				assertTrue(result.status(), equalTo(Helper.OK));
//			}
//		});
//	}
//}
