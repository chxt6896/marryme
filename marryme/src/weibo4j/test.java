package weibo4j;

import java.io.UnsupportedEncodingException;

public class test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
    	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
		try {
			String screen_name="张胤laji92454";
			String s=java.net.URLEncoder.encode(screen_name, "utf-8");
			User user = getWeibo(false,args).showUser(s);
			
			System.out.println(user.toString());
			System.out.println("userid------------->" + user.getId());
			if(getGender(user.getId(), Integer.parseInt("0534")))
				System.out.println("male");
			else
				System.out.println("female");
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
	
	private static Weibo getWeibo(boolean isOauth,String[] args) {
		Weibo weibo = new Weibo();
		if(isOauth) {//oauth验证方式 args[0]:访问的token；args[1]:访问的密匙
			weibo.setToken(args[0], args[1]);
		}else {//用户登录方式
    		weibo.setUserId("custsingle@163.com");//用户名/ID
    		weibo.setPassword("custsingle");//密码
		}
		return weibo;
	}
	
	private static boolean getGender(int id, int num) {
		System.out.println("id------------>" + id);
		System.out.println("num----------->" + num);
		if(id/(10000-num)%2==1)
			return true;
		else
			return false;
	}
}
