<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/ta.css" />
<title>测测你未来的TA</title>
<script type="text/javascript" src="<%=path%>/js/searchIndex.js"></script>
<script type="text/javascript" src="<%=path%>/js/main.js"></script>
</head>

<body>
	<form action="<%=path %>/main.action" method="post" id="form">
		<div class="align-center">
			<div class="head1"></div>
			<div class="head2"></div>
			<div class="bg" align="center">
				<div align="center" class="title">
					想看看下辈子的“Ta”吗？<br />赶快测试一下吧！
				</div>
				<div align="center">
					<div class="tab">
						<div id="bg" class="xixi1">
							<div id="font1" class="tab1" onclick="setTab03Syn(1);document.getElementById('bg').className='xixi1'">测自己</div>
							<div id="font2" class="tab2" onclick="setTab03Syn(2);document.getElementById('bg').className='xixi2'">测朋友</div>
						</div>
						<div id="TabCon1">
							<div class="ziji">
								<img src="<%=path%>/imgs/phone.png" />请输入你的<font color="#0000FF"><b>手机号码</b> </font>后四位:
							</div>
							<div class="zijitxt">
								<div class="zijihouji"><input type="text" name="lover.selfNum" id="selfnum" onfocus="cancelx()" onblur="checknum(this)" maxlength="4"/></div>
								<div id="sefcel" style="display: none" class="x"><img src="<%=path%>/imgs/x.png"/></div>
							</div>
						</div>

					</div>
					<div id="TabCon2" style="display: none">
						<div class="pengyou">
							<img src="<%=path%>/imgs/user.png" />请输入你朋友的<font color="#0000FF"><b>微博昵称</b> </font>：
						</div>
						<div>
							<input type="text" id="test" onkeyup="validate()"  autocomplete="off" name="lover.otherName"/>
						</div>
						<div   style="z-index: 2000; position: absolute;">
							<div id="any1" class="more" onclick="clocer('any1');">
								<ul style="list-style-type: none; padding-left: 1px;" id="flist">
								</ul>
							</div>
						</div>
						<div class="pengyou">
							<img src="<%=path%>/imgs/phone.png" />请输入你朋友的<font color="#0000FF"><b>手机号码</b> </font>后四位:
						</div>
						<div>
							<div class="zijihouji"><input type="text" name="lover.otherNum" id="othernum" onfocus="cancelx()" onblur="checknum(this)" maxlength="4" /></div>
							<div id="othcel" style="display: none" class="x"><img src="<%=path%>/imgs/x.png"/></div>
						</div>

					</div>
				</div>
				<div align="center" class="tijiao">
					<img src="<%=path%>/imgs/tijiao.png" onclick="dosubmit()" />
				</div>
			</div>
		</div>
	</form>
	<div id="cover" onclick="clocerall()" class="white_overlay"></div>
</body>
</html>