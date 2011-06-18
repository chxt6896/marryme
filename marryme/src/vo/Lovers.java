package vo;

public class Lovers {
	
	private int id; 			//微博Id
	private String pid;			//图片Id
	private String loversId;	//Ta的Id LoverId Lid
	private String loversName; 	//Ta的名字
	private String otherName; 	//@的名字
	private String otherNum;	//@的手机尾号
	private String selfNum;		//自己的手机尾号
	private String selfName;	//自己的名字
	private String gender;		//未来的性别

	public String getLoversId() {
		return loversId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setLoversId(String loversId) {
		this.loversId = loversId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoversName() {
		return loversName;
	}

	public void setLoversName(String loversName) {
		this.loversName = loversName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getOtherNum() {
		return otherNum;
	}

	public void setOtherNum(String otherNum) {
		this.otherNum = otherNum;
	}

	public String getSelfNum() {
		return selfNum;
	}

	public void setSelfNum(String selfNum) {
		this.selfNum = selfNum;
	}

	public String getSelfName() {
		return selfName;
	}

	public void setSelfName(String selfName) {
		this.selfName = selfName;
	}

	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Lovers [id=" + id + ", loversId=" + loversId + ", loversName="
				+ loversName + ", otherName=" + otherName + ", otherNum="
				+ otherNum + ", selfNum=" + selfNum + ", selfName=" + selfName
				+ ", gender=" + gender + "]";
	}
}
