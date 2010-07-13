<%@page import="net.emailwebclient.view.SessionBean"%>
<%@page import="net.emailwebclient.view.utils.JSFUtil"%>

<html>
<head>

</head>
<body>
<%
	SessionBean sessionBean = (SessionBean) session.getAttribute(SessionBean.class.getSimpleName());
	if (sessionBean != null) {
		sessionBean.logout(request);
	}
	int lastSlashInContext = request.getContextPath().lastIndexOf("/");
	response.sendRedirect(request.getContextPath().substring(lastSlashInContext));
%>
</body>
</html>