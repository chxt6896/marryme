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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
<title>测测你未来的TA</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-1.6.1.js"></script>
<script type="text/javascript">
	
</script>
<script type="text/javascript" src="<%=path%>/js/index.js"></script>
</head>

<body onload="init()" bgcolor="#2c4762">
	<div id="main">
		<div style="color:#FFFFFF;font-family:"Microsoft YaHei","Arial","SimSun";" align="center"><h2>测试你未来的TA</h2></div>
		<div id="one">
			<div id="div" style="overflow: hidden; position: relative">
				<div id="Slider" style="position: absolute; top: 0px;">
					<img id="tt" src="<%=path%>/imgs/index/weixiaobao.png" /> 
					<img id="Img1" src="<%=path%>/imgs/index/fengjie.png" /> 
					<img id="Img2" src="<%=path%>/imgs/index/cangjingkong.png" /> 
					<img id="Img2" src="<%=path%>/imgs/index/erkang.png" />
				</div>
			</div>
		</div>
		<div id="two">
			<p id="p1"></p>
			<p id="p2"></p>
			<p id="p3"></p>
			<p id="p4"></p>
			<p id="p5"></p>
			<p id="p6"></p>
		</div>
		<div id="cleanfloat"></div>
		<div align="center" style="padding-top: 20px;">
			<form action="<%=path %>/index.action">
				<input type="image" src="<%=path%>/imgs/48.png" onclick="dosubmit()"/>
			</form>
			<!--  <a href="call.jsp?opt=1"><input type="image" src="<%=path%>/imgs/48.png" /></a>-->
		</div>
	</div>
</body>
</html>