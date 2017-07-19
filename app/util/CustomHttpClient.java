package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomHttpClient {

//    private static Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("xxxxxxxx.co.jp", 80xx));
//    private static String proxySwitch = "1";

      // 動作確認用
//    public static void main(String args[]){
//
//    	System.out.println("CustomHttpClient Test start!!!");
//
//    	String strPostUrl = "http://localhost:9999/api/doLogin";
//    	String strContentType = "application/x-www-form-urlencoded;";
//    	String formParam = "userId=adachi@inazou.jp&password=pass";
//    	String jsonRes = null;
//		try {
//			jsonRes = callPost(strPostUrl, strContentType, formParam);
//		} catch (Exception e1) {
//			// TODO 自動生成された catch ブロック
//			e1.printStackTrace();
//		}
//
//    	ObjectMapper mapper = new ObjectMapper();
//
//    	try {
//			JsonNode root = mapper.readTree(jsonRes);
//			String token = root.get("token").asText();
//
//			System.out.println("token=" + token);
//
//
//    	} catch (JsonProcessingException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//    	System.out.println("CustomHttpClient Test end!!!");
//
//
//    }

    /**
     * GETでリクエストするメソッド
     * @param strGetUrl URL
     * @return レスポンス(文字列)
     * @throws DisplayException 表示に問題があった場合に起こり得る例外
     */
    public static String callGet(String strGetUrl) {

        HttpURLConnection con = null;
        StringBuffer result = new StringBuffer();

        try {

            URL url = new URL(strGetUrl);

            con = (HttpURLConnection) url.openConnection();
//            if(proxySwitch.equals("1")){
//                con = (HttpURLConnection) url.openConnection(proxy);
//            }else{
//                con = (HttpURLConnection) url.openConnection();
//            }

            con.setRequestMethod("GET");
            con.connect();

            // HTTPレスポンスコード
            final int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                // 通信に成功した
                // テキストを取得する
                final InputStream in = con.getInputStream();
                String encoding = con.getContentEncoding();
                if(null == encoding){
                    encoding = "UTF-8";
                }
                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);
                String line = null;
                // 1行ずつテキストを読み込む
                while((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                bufReader.close();
                inReader.close();
                in.close();
            }else{
                System.out.println(status);
            }

        }catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (con != null) {
                // コネクションを切断
                con.disconnect();
            }
        }
        System.out.println("result=" + result.toString());

        return result.toString();


    }

    /**
     * POSTでリクエストするメソッド
     * @param strGetUrl URL
     * @param strContentType コンテンツタイプ
     * @param formParam 送信するパラメータ
     * @return レスポンス(文字列)
     * @throws DisplayException 表示に問題があった場合に起こり得る例外
     */
    public static String callPost(String strPostUrl, String strContentType, String formParam) throws Exception {

        HttpURLConnection con = null;
        StringBuffer result = new StringBuffer();

        try {

            URL url = new URL(strPostUrl);
            con = (HttpURLConnection) url.openConnection();

//            if(proxySwitch.equals("1")){
//                con = (HttpURLConnection) url.openConnection(proxy);
//            }else{
//                con = (HttpURLConnection) url.openConnection();
//            }

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", strContentType);
            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(formParam);
            out.close();
            con.connect();

            // HTTPレスポンスコード
            final int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                // 通信に成功した
                // テキストを取得する
                final InputStream in = con.getInputStream();
                String encoding = con.getContentEncoding();
                if(null == encoding){
                    encoding = "UTF-8";
                }
                final InputStreamReader inReader = new InputStreamReader(in, encoding);
                final BufferedReader bufReader = new BufferedReader(inReader);
                String line = null;
                // 1行ずつテキストを読み込む
                while((line = bufReader.readLine()) != null) {
                    result.append(line);
                }
                bufReader.close();
                inReader.close();
                in.close();
            }else{
//                System.out.println(status);
                throw new Exception("ログインに失敗しました。");
            }

        }catch (Exception error) {
        	error.printStackTrace();
            throw error;
        } finally {
            if (con != null) {
                // コネクションを切断
                con.disconnect();
            }
        }

//        System.out.println("result=" + result.toString());

        return result.toString();


    }

}