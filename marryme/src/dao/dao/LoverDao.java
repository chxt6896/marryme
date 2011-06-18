package dao.dao;

import java.io.UnsupportedEncodingException;

import vo.Lovers;
import weibo4j.Weibo;
import weibo4j.http.AccessToken;

public interface LoverDao {
	
	public final int L = 1;
	public final int O = 3;
	public final int V = 1;
	public final int E = 4;

	/**
	 * 获取微博用户Id
	 * @param access
	 * @return
	 */
	public int getUserId(AccessToken access);

	/**
	 * 获取微博用户名
	 * @param access
	 * @return
	 */
	public String getUserName(AccessToken access);

	/**
	 * 通过微博用户名得到微博用户Id
	 * @param access
	 * @param screenName 微博用户名
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public int getUserIdByScreenName(AccessToken access, String screenName)
			throws UnsupportedEncodingException;

	/**
	 * 获取微博对象
	 * @param isOauth
	 * @param access
	 * @return
	 */
	public Weibo getWeibo(boolean isOauth, AccessToken access);

	/**
	 * 获得@别人未来的Ta的对象
	 * @param lover
	 * @return
	 */
	public Lovers getOtherLover(AccessToken access, String otherName, String otherNum)throws UnsupportedEncodingException;
	
	/**
	 * 获得自己未来的Ta的对象
	 * @param access
	 * @param telNum 手机尾号
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Lovers getSelfLover(AccessToken access, String selfNum)throws UnsupportedEncodingException;

	/**
	 * 通过微博用户Id和手机尾号计算得出用户下辈子性别
	 * @param id 微博用户Id
	 * @param telNum 手机尾号
	 * @return
	 */
	public String getGender(int id, String telNum);

	/**
	 * 通过未来的性别和手机尾号计算出未来的Ta的Id
	 * @param gender 未来的性别
	 * @param telNum 手机尾号
	 * @return
	 */
	public String getLoverId(String gender, String telNum, int id);
	
	/**
	 * 合成图片和文字并发送
	 * @param taPath Ta的图片		
	 * @param content 文字信息
	 */
	public boolean mixPicture(AccessToken access, String taPath, String name, String gender, String telNum, String content)throws UnsupportedEncodingException;
	
	/**
	 * 根据图片的Lid获得图片名Pid
	 * @param lid LoverId
	 * @return
	 */
	public String getPidByLid(String lid);
	
	/**
	 * 通过英文性别获得中文性别
	 * @param gender 英文性别
	 * @return
	 */
	public String getGenderCNbYGenderEN(String gender);
}
