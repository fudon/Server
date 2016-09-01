<%@ page contentType="text/html;charset=utf-8" import="com.fuhope.ssm.po.User" %>
<html>
	<head>
		<body>
			<h1>欢迎登陆!,<%=((User)session.getAttribute("user")).getName() %></h1>
			<a href=exit.action >退出</a>
		</body>
	</head>

</html>