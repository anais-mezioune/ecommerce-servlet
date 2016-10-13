<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp">
    <jsp:param name="title" value="Accueil"></jsp:param>
</jsp:include>

<h2>Bienvenue <%= session.getAttribute("email") %> sur le site ecommerce</h2>

<a href="/logout">Se déconnecter</a>

<jsp:include page="/footer.jsp"></jsp:include>
