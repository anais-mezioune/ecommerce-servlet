<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Authentification"></jsp:param>
</jsp:include>

<%
    if(request.getAttribute("error") != null) {
        out.print(request.getAttribute("error"));
    }
%>

<form action="/login" method="post" class="login">
    <p><label for="email">Email : </label><input type="email" id="email" name="email"></p>
    <p><label for="password">Mot de Passe : </label><input type="password" id="password" name="password"></p>
    <p></p><input type="submit" value="Go!"></p>
    <a href="/account/create.jsp">Créer un compte</a>
</form>

<jsp:include page="footer.jsp"></jsp:include>
