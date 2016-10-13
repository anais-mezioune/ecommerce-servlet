<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp">
    <jsp:param name="title" value="Créer un compte"></jsp:param>
</jsp:include>

<%
    if(request.getAttribute("error") != null) {
        out.print(request.getAttribute("error"));
    }
%>

<form action="/account/create" method="post" class="account-create">
    <p><label for="email">Email : </label><input type="email" id="email" name="email" <%= request.getAttribute("email") %>></p>
    <p><label for="password">Mot de Passe : </label><input type="password" id="password" name="password"></p>
    <p><label for="lastName">Nom : </label><input type="text" id="lastName" name="lastName"></p>
    <p><label for="firstName">Prénom : </label><input type="text" id="firstName" name="firstName"></p>
    <p></p><input type="submit" value="Créer"></p>
</form>

<jsp:include page="/footer.jsp"></jsp:include>
