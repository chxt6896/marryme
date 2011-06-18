package action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import vo.Lovers;
import weibo4j.http.AccessToken;

import com.opensymphony.xwork2.ActionSupport;

import dao.factory.LoverDaoFactory;

public class LoverAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Lovers lover = null;

	public Lovers getLover() {
		return lover;
	}

	public void setLover(Lovers lover) {
		this.lover = lover;
	}
	
	public String index(){
		return SUCCESS;
	}
	
	public String main() {
		Map<String, Object> sessionMap = ServletActionContext.getContext().getSession();
		AccessToken accessToken = (AccessToken) ServletActionContext.getRequest().getSession().getAttribute("accessToken");
		String selfNum = lover.getSelfNum();
		if ("".equals(selfNum)) {
			Lovers lovers = null;
			try {
				lovers = LoverDaoFactory.getLoverDao().getOtherLover(accessToken, lover.getOtherName(), lover.getOtherNum());
				
			} catch(Exception e) {
				e.printStackTrace();
			}	
			sessionMap.put("lover", lovers);
			return "other";
		} else {		
			Lovers lovers = null;
			try {
				lovers = LoverDaoFactory.getLoverDao().getSelfLover(accessToken, selfNum);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sessionMap.put("lover", lovers);
			return "self";
		}
	}
	
}
