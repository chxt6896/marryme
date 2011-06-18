<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="vo.Lovers"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Lovers lover = (Lovers) session.getAttribute("lover");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/ta.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/single.css" />
<title>测测你未来的TA</title>
<script type="text/javascript" src="<%=path %>/js/single.js"></script>
</head>

<s:set name="lover" value="#session.lover" />
<body onload="checkword()">
	<div class="align-center">
		<div class="head1"></div>
		<div class="head2"></div>
		<div class="bgsingle">
			<div class="title2" align="center">你下辈子的“Ta”!</div>
			<div class="bg2">
				<form action="<%=path%>/loverupdate.action" method="post" id="form">
					<div id="main">
						<div id="retxt">
							<%
								if ("0".equals(request.getParameter("opt"))) {
									%>
									<input type="hidden" name="lover.loversId" value="${lover.selfNum}" />
									<%
								} else if ("1".equals(request.getParameter("opt"))) {
									%>
									<input type="hidden" name="lover.loversId" value="${lover.otherNum}" />
									<%
								}
							%>
							<%
								if (null == lover.getSelfNum()) {
									if ("female".equals(lover.getGender())) {
										%>
										<div class="taname">${lover.otherName}</div>
										<div class="tasex">女</div>
										<div class="tanum">${lover.otherNum}</div>
										<textarea name="content" id="textarea" onkeyup="checkword()">@${lover.otherName} #你下辈子的TA# 竟然是个mm,在一场事故中偶遇${lover.loversName}, ${lover.loversName}的温柔体贴深深地打动了@${lover.otherName},两人最终走到了一起~~~#你下辈子的TA#是谁？想知道吗？想知道吗？快来测试吧 http://t.cn/aoxuuc</textarea>
										<%
									} else if ("male".equals(lover.getGender())) {
										%>
										<div class="taname">${lover.otherName}</div>
										<div class="tasex">男</div>
										<div class="tanum">${lover.otherNum}</div>
										<textarea name="content" id="textarea" onkeyup="checkword()">@${lover.otherName} #你下辈子的TA#竟然是男的!!!@${lover.otherName} 找对象可真不容易啊!!!!@${lover.otherName} 下辈子的TA竟然是${lover.loversName}^^^#你下辈子的TA#是谁？想知道吗？想知道吗？快来测试吧 http://t.cn/aoxuuc</textarea>
										<%
									}
								} else if (null == lover.getOtherName()) {
									if ("female".equals(lover.getGender())) {
										%>
										<div class="taname">${lover.selfName}</div>
										<div class="tasex">女</div>
										<div class="tanum">${lover.selfNum}</div>
										<textarea name="content" id="textarea" onkeyup="checkword()">我下辈子竟然是个女的,青春靓丽,浓妆淡抹总相宜~~~#我下辈子的TA#竟然是${lover.loversName}!!!#你下辈子的TA#是谁？想知道吗？想知道吗？快来测试吧 http://t.cn/aoxuuc</textarea>
										<%
									} else if ("male".equals(lover.getGender())) {
										%>
										<div class="taname">${lover.selfName}</div>
										<div class="tasex">男</div>
										<div class="tanum">${lover.selfNum}</div>
										<textarea name="content" id="textarea" onkeyup="checkword()">我下辈子竟然是个男的,我已不再闷骚,为了寻找另一半我不辞辛苦^^^#我下辈子的TA#竟然是${lover.loversName}!!!#你下辈子的TA#是谁？想知道吗？想知道吗？快来测试吧 http://t.cn/aoxuuc</textarea>
										<%
									}
								}
							%>
							<div class="fabu">
								<span id="remain1">你还可输入</span><span id="word">140</span><span id="remain2">字</span>
								<!--  <font color="#000000" size="2">你还可以输入<span></span>个字</font>-->
								<%
									if("0".equals(request.getParameter("opt")) || "1".equals(request.getParameter("opt"))){
										%>
										<img src="<%=path%>/imgs/share_button_m.gif" class="share" align="right" onclick="dosubmit()"/>
									<%} else if("2".equals(request.getParameter("opt"))){
										%>
										<img src="<%=path%>/imgs/share_button_suc.gif" align="right" />
									<%} else if("3".equals(request.getParameter("opt"))){ %>
										<img src="<%=path%>/imgs/share_button_failbt.gif" align="right" />	
									<%} %>
							</div>
						</div>
						<div id="people">
							<img src="<%=path %>/imgs/lovers/${lover.pid}.png" />
							<input type="hidden" name="lover.pid" value="${lover.pid}" />
							<input type="hidden" name="lover.selfName" value="${lover.selfName}" />
							<input type="hidden" name="lover.otherName" value="${lover.otherName}" />
						</div>
					</div>
					<div id="cleanfloat"></div>
				</form>
			</div>
		</div>
	</div>
	<%
		if ("2".equals(request.getParameter("opt"))) {
		%>
	<div id="light2" class="white_content" >
      	<div class="close"><a href="javascript:void(0)" onclick="hide('light2')"> 关闭</a></div>
      	<div class="con">
      	<table width="720px">
      	<tr>
      	<td width="360px" align="center"><a href="http://t.cn/aoxuuc">继续使用此应用进行测试</a></td>
      	
      	<td width="360px" align="center"><a href="http://weibo.com">返回自己的微博</a></td>
        </tr>
      	</table>
      	<div height="30px">应用作者：</div>
     	<script type="text/javascript">
    		document.write('<iframe width="680" height="175" frameborder="0" scrolling="no" src=" http://service.t.sina.com.cn/widget/relationship/bulkfollow.php?uids=1085690913,1923058361,1735921497,1444149483,1857949900,1837304707&wide=2&color=C2D9F2,FFFFFF,0082CB,666666&showtitle=0&showinfo=0&sense=0&verified=0&count=6&refer=' + encodeURIComponent(location.href) + '&dpc=1"></iframe>');
        </script>
     	</div>
     	 
	</div>
	<div id="fade" class="black_overlay"></div>
	<%
			}
			%>
</body>
