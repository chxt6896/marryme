package weibo4j.examples;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import weibo4j.Suggestions;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;

public class Search {
	public static void main(String[] args) {
	    Weibo weibo = new Weibo("username","password");
	    try {
	        List<Suggestions>l =weibo.sts("haha");
	        for(Suggestions s:l){
	            System.out.println(s.getNickname());
	        }
	    
	    } catch (WeiboException e) {
	        e.printStackTrace();
	    }
	}
	public static List<Suggestions> getJson(AccessToken accessToken, String name) throws UnsupportedEncodingException{
		List<Suggestions> l = null;
	    try {
	    	Weibo weibo = new Weibo();
			weibo.setToken(accessToken.getToken(), accessToken.getTokenSecret());
			//现将从前台jsp传来的ISO-8859-1格式参数转成UTF-8格式，在用URLEncoder转成UTF-8的
			String q = new String(name.getBytes("ISO-8859-1"), "UTF-8");
	    	q = URLEncoder.encode(q, "UTF-8");
	        l = weibo.sts(q);
	        System.out.println("ssq");
	        for(Suggestions s:l){
	            System.out.println(s.getNickname());
	        }
	    } catch (WeiboException e) {
	        e.printStackTrace();
	    }
	    return l;
	}
}
