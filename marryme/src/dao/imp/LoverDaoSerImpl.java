package dao.imp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import vo.Lovers;
import weibo4j.User;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.examples.WebOAuth;
import weibo4j.http.AccessToken;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import constance.LoverEnum;
import dao.dao.LoverDao;

public class LoverDaoSerImpl implements LoverDao{
	
	@Override
	public int getUserId(AccessToken access){
		User user = null;
		try {
			user = getWeibo(true, access).verifyCredentials();			
			//System.out.println(user.toString());
			//System.out.println(user.getName()+":"+user.getScreenName());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return user.getId();
	}
	
	@Override
	public String getUserName(AccessToken access){
		User user = null;
		try {
			user = getWeibo(true, access).verifyCredentials();			
			//System.out.println(user.toString());
			//System.out.println(user.getName()+":"+user.getScreenName());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return user.getName();
	}
	
	@Override
	public int getUserIdByScreenName(AccessToken access, String screenName) throws UnsupportedEncodingException{
		User user = null;
		try {
			String s=java.net.URLEncoder.encode(screenName, "utf-8");
			user = getWeibo(true, access).showUser(s);	
//			System.out.println(user.toString());
//			System.out.println("userid------------->" + user.getId());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return user.getId();
	}

	@Override
	public Weibo getWeibo(boolean isOauth, AccessToken access) {
		Weibo weibo = new Weibo();
		if(isOauth) {//oauth验证方式 args[0]:访问的token；args[1]:访问的密匙
			weibo.setToken(access.getToken(), access.getTokenSecret());
		}else {//用户登录方式
    		weibo.setUserId(access.getToken());//用户名/ID
    		weibo.setPassword(access.getTokenSecret());//密码
		}
		return weibo;
	}
	
	@Override
	public Lovers getOtherLover(AccessToken access, String otherName, String otherNum) throws UnsupportedEncodingException {
		Lovers lover = new Lovers();
		lover.setOtherName(otherName);
		lover.setOtherNum(otherNum);
		int id = getUserIdByScreenName(access, lover.getOtherName());		
		String gender = getGender(id, lover.getOtherNum());
		lover.setGender(gender);
		String loverId = getLoverId(gender, lover.getOtherNum(), id);
		lover.setLoversId(loverId);
		String pid = getPidByLid(loverId);
		lover.setPid(pid);
		for (LoverEnum loverEnum:LoverEnum.values()){
			if(loverEnum.getLid().equals(loverId)){
				lover.setLoversName(loverEnum.getName());
			}
		}
		lover.print();
		return lover;
	}
	
	@Override
	public Lovers getSelfLover(AccessToken access, String selfNum) throws UnsupportedEncodingException {
		Lovers lover = new Lovers();
		String name = getUserName(access);
		int id = getUserId(access);
		lover.setSelfNum(selfNum);
		lover.setSelfName(name);
		String gender = getGender(id, selfNum.toString());
		lover.setGender(gender);
		String loverId = getLoverId(gender, selfNum, id);
		lover.setLoversId(loverId);
		String pid = getPidByLid(loverId);
		lover.setPid(pid);
		for (LoverEnum loverEnum:LoverEnum.values()){
			if(loverEnum.getLid().equals(loverId)){
				lover.setLoversName(loverEnum.getName());
			}
		}
		lover.print();
		return lover;
	}
	
	@Override
	public String getGender(int id, String telNum) {
		int num = Integer.parseInt(telNum);
		if(id/(10000-num)%2==1) {
			return "male";
		}
		else {
		return "female";
		}
	}
	
	@Override
	public String getLoverId(String gender, String telNum, int id) {
		String loverId = null;
		long ta;
		int l = Integer.parseInt(telNum.substring(0, 1));
		int o = Integer.parseInt(telNum.substring(1, 2));
		int v = Integer.parseInt(telNum.substring(2, 3));
		int e = Integer.parseInt(telNum.substring(3, 4));
		if(gender == "female") {
			ta = (id - (l*L + o*O + v*V + e*E))%15;
			loverId = "male_" + ta;
		}
		else {
			ta = (id - (l*L + o*O + v*V + e*E))%15;
			loverId = "female_" + ta;
		}
		System.out.println("loverId--->"+loverId);
		return loverId;
	}

	@Override
	public boolean mixPicture(AccessToken access, String taPath, String name, String gender, String telNum, String content)throws UnsupportedEncodingException {
//		String backPath = "http://do.jhost.cn/marrymewmf/imgs/41.jpg";
		String backPath = "http://localhost:8080/marryme/imgs/41.jpg";
		try {
			HttpClient client = new HttpClient(); 
			GetMethod get = new GetMethod(backPath);
		    client.executeMethod(get);
		  //创建一个ByteArrayInputStream对象从源图片获取数据流     
		    ByteArrayInputStream sFile = new ByteArrayInputStream(get.getResponseBody()); 
			//创建一个Image对象并以源图片数据流填充  
			Image src = javax.imageio.ImageIO.read(sFile);
			int width = src.getWidth(null); //得到源图宽    
			int height = src.getHeight(null); //得到源图长   
			if (width>70 && height>30){
				//创建一个BufferedImage来作为图像操作容器      
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				//创建一个绘图环境来进行绘制图象   
				Graphics g = image.getGraphics();
				//将原图像数据流载入这个BufferedImage      
				g.drawImage(src,0,0,width,height,null);
				//设定文本字体       
				g.setFont(new Font("微软雅黑",Font.BOLD,20));
				//设定文本颜色        
				g.setColor(Color.black);
				//向BufferedImage写入文本字符   
				g.drawString(name,190,85);
				g.drawString(gender,265,132);
				g.drawString(telNum,215,178);
				
				get = new GetMethod(taPath);
			    client.executeMethod(get);
			    sFile = new ByteArrayInputStream(get.getResponseBody()); 
				src = javax.imageio.ImageIO.read(sFile);
				width = src.getWidth(null); //得到源图宽    
				height = src.getHeight(null); //得到源图长  
				g.drawImage(src, 365, 25, width, height, null); // 靠左上绘制，x和y都是10
				
				//使更改生效   
				g.dispose();
				//创建byte数组输出流    
				ByteArrayOutputStream os = new ByteArrayOutputStream(); 
				//创建JPEG编码对象    
				JPEGImageEncoder encodera = JPEGCodec.createJPEGEncoder(os);
				//对这个BufferedImage (image)进行JPEG编码
				encodera.encode(image);
				//获得合成图片的byte数组内容
				byte[] data = os.toByteArray();
				//调用uploadStatus2方法发送
				if(WebOAuth.uploadStatus2(access, content, data)){
					os.close(); //关闭输出文件流
					return true;
				} else{
					os.close(); //关闭输出文件流
					return false;
				}	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (ImageFormatException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String getPidByLid(String lid) {
		String Pid = null;
		for (LoverEnum loverEnum:LoverEnum.values()){
			if(loverEnum.getLid().equals(lid)){
				Pid = loverEnum.getPid();
			}
		}
		return Pid;
	}

	@Override
	public String getGenderCNbYGenderEN(String gender) {
		if(gender.equals("male")){
			return "男";
		}else{
			return "女";
		}
	}

	
}
