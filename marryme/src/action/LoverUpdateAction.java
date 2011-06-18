package action;

import java.io.UnsupportedEncodingException;
import org.apache.struts2.ServletActionContext;
import vo.Lovers;
import weibo4j.http.AccessToken;
import com.opensymphony.xwork2.ActionSupport;
import dao.factory.LoverDaoFactory;

public class LoverUpdateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Lovers lover = null;

	public Lovers getLover() {
		return lover;
	}

	public void setLover(Lovers lover) {
		this.lover = lover;
	}

	public String execute() {
		//通过session获得AccessToken
		AccessToken accessToken = (AccessToken) ServletActionContext.getRequest().getSession().getAttribute("accessToken");
		//通过session获得lover对象
		Lovers lovers = (Lovers)ServletActionContext.getRequest().getSession().getAttribute("lover");
		// 拼接图片路径
//		String taPath = "http://do.jhost.cn/marrymewmf/imgs/lovers/" + lover.getPid()+".png";
		String taPath = "http://localhost:8080/marryme/imgs/lovers/"+lover.getPid()+".png";
		//System.out.println(taPath);
		String selfName = lover.getSelfName();
		//获得微博用户名
		String name = null;
		//获得微博用户性别
		String gender = null;
		//获得微博用户手机尾数
		String telNum = null;
		if ("".equals(selfName)) {
			name = lovers.getOtherName();
			gender = LoverDaoFactory.getLoverDao().getGenderCNbYGenderEN(lovers.getGender());
			telNum = lovers.getOtherNum();
		} else{
			name = lovers.getSelfName();
			gender = LoverDaoFactory.getLoverDao().getGenderCNbYGenderEN(lovers.getGender());
			telNum = lovers.getSelfNum();
		}
		// 获得发布文字内容
		String content = ServletActionContext.getRequest().getParameter("content");
		//System.out.println("name:"+name+"gender:"+gender+"telNum:"+telNum+"content:"+content);
		// 调用WebOAuth的静态函数uploadStatus2发布微博
		System.out.println("-->"+accessToken);
		System.out.println("-->"+taPath);
		System.out.println("-->"+name);
		System.out.println("-->"+gender);
		System.out.println("-->"+telNum);
		System.out.println("-->"+content);
		try {
			if (LoverDaoFactory.getLoverDao().mixPicture(accessToken, taPath, name, gender, telNum, content)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
