<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page
	import="weibo4j.examples.Search,java.util.List,weibo4j.Suggestions,weibo4j.*,weibo4j.http.*"%>
<%
	StringBuffer content = new StringBuffer("");
	AccessToken accessToken = (AccessToken) session
			.getAttribute("accessToken");
	String name = request.getParameter("name");
	List<Suggestions> l = null;
	l = Search.getJson(accessToken, name);
	for (Suggestions s : l) {
		content.append(s.getNickname() + ":");
	}
	System.out.println(content);
	out.println(content);
%>