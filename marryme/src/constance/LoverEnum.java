package constance;

public enum LoverEnum {
	阿甘("agan", "male_0", "阿甘"),
	八戒("bajie", "male_1", "八戒"),
	阿狸("ali", "male_2", "阿狸"),
	变形金刚("bianxing", "male_3", "变形金刚"),
	Chuck("chuck", "male_4", "Chuck"),
	尔康("erkang", "male_5", "尔康"),
	葫芦娃("huluwa", "male_6", "葫芦娃"),
	机器猫("jiqimao", "male_7", "机器猫"),
	KFC("kfc", "male_8", "KFC"),
	奥巴马("obama", "male_9", "奥巴马"),
	忍者神龟("renzheshengui", "male_10", "忍者神龟"),
	蜘蛛侠("spiderman", "male_11", "蜘蛛侠"),
	韦小宝("weixiaobao", "male_12", "韦小宝"),
	小新("xiaoxin", "male_13", "小新"),
	曾小贤("zengxiaoxian", "male_14", "曾小贤"),
	
	白娘子("bainiangzi", "female_0", "白娘子"),
	白雪公主("baixuegongzhu", "female_1", "白雪公主"),
	苍井空("cangjingkong", "female_2", "苍井空"),
	春哥("chunge", "female_3", "春哥"),
	Elena("elena", "female_4", "Elena"),
	凤姐("fengjie", "female_5", "凤姐"),
	芙蓉姐姐("furong", "female_6", "芙蓉姐姐"),
	GaGa("gaga", "female_7", "GaGa"),
	花心子("huaxinzi", "female_8", "花心子"),
	胡一菲("huyifei", "female_9", "胡一菲"),
	晴川("qingchuan", "female_10", "晴川"),
	QQ("qq", "female_11", "QQ"),
	Serena("serena", "female_12", "Serena"),
	小泽("xiaoze", "female_13", "小泽"),
	紫薇("ziwei", "female_14", "紫薇"),
	;
				
	private final String pid;			//图片Id
	private final String lid;			//LoverId
	private final String name;			//中文名
	
	private LoverEnum(String pid, String lid, String name) {
		this.pid = pid;
		this.lid = lid;
		this.name = name;
	}
	
	public String getPid() {
		return pid;
	}
	public String getLid() {
		return lid;
	}
	public String getName() {
		return name;
	}
}
