package weibo4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

public class Suggestions extends WeiboResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String uid;
	private String nickname;
	private String remark;

	public String getUid() {
		return uid;
	}

	public String getNickname() {
		return nickname;
	}

	public String getRemark() {
		return remark;
	}

	public Suggestions(JSONObject json) throws JSONException {
		uid = json.getString("uid");
		nickname = json.getString("nickname");
		remark = json.getString("remark");
	}

	static List<Suggestions> constructS(Response res) throws WeiboException {
		try {
            JSONArray list = res.asJSONArray();
            int size = list.length();
            List<Suggestions> sts  = new ArrayList<Suggestions>(size);
            for (int i = 0; i < size; i++) {
                sts.add(new Suggestions(list.getJSONObject(i)));
            }
            return sts;
        } catch (JSONException jsone) {
            throw new WeiboException(jsone);
        } catch (WeiboException te) {
            throw te;
        }
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suggestions other = (Suggestions) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

}
