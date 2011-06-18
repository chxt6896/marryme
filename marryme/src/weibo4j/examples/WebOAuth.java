package weibo4j.examples;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import weibo4j.Status;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;
import weibo4j.http.ImageItem;
import weibo4j.http.RequestToken;

public class WebOAuth {

	public static RequestToken request(String backUrl) {
		try {
			System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
			System.setProperty("weibo4j.oauth.consumerSecret",Weibo.CONSUMER_SECRET);
			
			Weibo weibo = new Weibo();
			RequestToken requestToken = weibo.getOAuthRequestToken(backUrl);

			System.out.println("Got request token.");
			System.out.println("Request token: " + requestToken.getToken());
			System.out.println("Request token secret: "
					+ requestToken.getTokenSecret());
			return requestToken;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static AccessToken requstAccessToken(RequestToken requestToken,
			String verifier) {
		try {
			System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
			System.setProperty("weibo4j.oauth.consumerSecret",
					Weibo.CONSUMER_SECRET);

			Weibo weibo = new Weibo();
			AccessToken accessToken = weibo.getOAuthAccessToken(requestToken
					.getToken(), requestToken.getTokenSecret(), verifier);

			System.out.println("Got access token.");
			System.out.println("access token: " + accessToken.getToken());
			System.out.println("access token secret: "
					+ accessToken.getTokenSecret());
			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void update(AccessToken access, String content) {
		try {
			Weibo weibo = new Weibo();
			weibo.setToken(access.getToken(), access.getTokenSecret());
            Status status = weibo.updateStatus(content);
			System.out.println("Successfully updated the status to ["
			                + status.getText() + "].");
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发微博，文字+图片
	 * @param access
	 * @param content：文字内容
	 * @param path：图片路径
	 */
	public static boolean uploadStatus(AccessToken access, String content, String path) {
		try {
			Weibo weibo = new Weibo();
			weibo.setToken(access.getToken(), access.getTokenSecret());
			
			HttpClient client = new HttpClient(); 
			//GetMethod get = new GetMethod("http://localhost:8080/vegetable/imgs/vegetable/007_2.jpg"); 
			GetMethod get = new GetMethod(path);
		    client.executeMethod(get);  
		    ImageItem imageItem= new ImageItem("pic", get.getResponseBody());
		    
			String msg = URLEncoder.encode(content, "UTF-8");
			Status status = weibo.uploadStatus(msg, imageItem);
			System.out.println("Successfully upload the status to ["
					+ status.getText() + "].");
			if(status.getText() == null){
				return false;
			}
		} catch (Exception ioe) {
			System.out.println("Failed to read the system input.");
		}
		return true;
	}
	
	/**
	 * 发微博，文字+图片
	 * @param access
	 * @param content：文字内容
	 * @param path：图片路径
	 */
	public static boolean uploadStatus2(AccessToken access, String content, byte[] data) {
		try {
			Weibo weibo = new Weibo();
			weibo.setToken(access.getToken(), access.getTokenSecret());
		    ImageItem imageItem= new ImageItem("pic", data);
		    
			String msg = URLEncoder.encode(content, "UTF-8");
			Status status = weibo.uploadStatus(msg, imageItem);
			System.out.println("Successfully upload the status to ["
					+ status.getText() + "].");
			if(status.getText() == null){
				return false;
			}
		} catch (Exception ioe) {
			System.out.println("Failed to read the system input.");
		}
		return true;
	}
	
	public static byte[] readFileImage(String filename) throws IOException {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				new FileInputStream(filename));
		int len = bufferedInputStream.available();
		byte[] bytes = new byte[len];
		int r = bufferedInputStream.read(bytes);
		if (len != r) {
			bytes = null;
			throw new IOException("读取文件不正确");
		}
		bufferedInputStream.close();
		return bytes;
	}
}
