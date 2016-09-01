<%@ page contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<body>
		<h3><%=request.getAttribute("errorLogin")==null?"":request.getAttribute("errorLogin") %></h3>
			<form name=regFrm action="handleLogin.action" method=post>
				用户名:<input type=text name=uname /><br/>
				密码:<input type=password name=pwd /><br/>
				<input type=submit value=登陆 />
			</form>
		</body>
	</head>

</html>