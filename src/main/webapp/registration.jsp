<%@ page import="static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name" %>
<%@ page import="static groovy.xml.Entity.nbsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Purchase list</title>
</head>
<body>
<% if (request.getParameter("register")!=null){%>
<h1> Registration &nbsp;&nbsp;<a title="Login" href="/login">Login</a></h1>
<% } else {%>
<h1><a title="Registraion" href="/register">Registration</a> &nbsp;&nbsp; Login</h1>
<% } %>

<% if (request.getAttribute("warningMessage")!=null) { %>
<p> <%=request.getAttribute("warningMessage")%> </p>
<% } %>

<form id="idAutorisation" name="Autorisation" method="post">
  <% if (request.getParameter("register")!=null){%>
    <p>Name &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<input maxlength="35" name="liName" size="35" type="text" /></p>
  <% } %>
  <p>Username &nbsp;<input maxlength="35" name="liUserName" size="35" type="text" /></p>
  <% if (request.getParameter("register")!=null) {%>
    <p>Email &nbsp; &nbsp; &nbsp; &nbsp;<input maxlength="35" name="liEmail" size="35" type="email" /></p>
  <% } %>
  <p>Password &nbsp;<input maxlength="35" name="liPassword" size="35" type="password" /></p>

  <p><input name="btRegister" type="submit" value="Register" /></p>
</form>

<h1>&nbsp;</h1>
</body>
</html>