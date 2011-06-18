<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="weibo4j.http.*"%>
<%@ page language="java" import="weibo4j.*"%>
<jsp:useBean id="weboauth" scope="session" class="weibo4j.examples.WebOAuth" />
<%
	String verifier=request.getParameter("oauth_verifier");
	
	if(verifier!=null){
		System.out.println("oauth:"+verifier);
		RequestToken resToken=(RequestToken) session.getAttribute("resToken");
		if(resToken!=null){
			AccessToken accessToken=(AccessToken)session.getAttribute("accessToken");
			if(accessToken == null){
				accessToken=weboauth.requstAccessToken(resToken,verifier);
				request.getSession().setAttribute("accessToken", accessToken);
			}
			//if("1".equals(request.getParameter("info"))){
				if(accessToken!=null){
					pageContext.getServletContext().getRequestDispatcher("/page/main.jsp").forward(request, response);
				}else{
					pageContext.getServletContext().getRequestDispatcher("/page/main.jsp").forward(request, response);
				}
			//}
		}else{
			out.println("request token session error");
		}
	}
	else{
		out.println("verifier String error");
	}

%>   
