<%@ page contentType="text/html;charset=utf-8" import="com.fuhope.ssm.po.User" %>
<% 
	String uname = request.getParameter("uname").trim();
	String password = request.getParameter("pwd").trim();
	
	if ("fdd".equals(uname) && "123".equals(password)){
		
		User user = User.configUser(uname,password);
		session.setAttribute("user", user);
/* 		pageContext.forward("loginOK.jsp");
 */
%>
		<jsp:forward page="loginOK.jsp"></jsp:forward>
<%
		return;
		
	}else{
		request.setAttribute("errorLogin", "用户名或密码错误");
/* 		pageContext.forward("login.jsp");
 */
 %>
		<jsp:forward page="login.jsp"></jsp:forward>
<%
		return;
	}
%>