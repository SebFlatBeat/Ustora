<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 28/02/2020
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mon Espace Perso</title>
</head>
<body>
<div class="row col-lg-5 col-lg-offset-2">
    <h5 class="text-center">Prêt en cours</h5>
    <table class="table table-sm">
        <thead>
        <tr class="bg-primary">
            <th class="text-center" scope="col"> Nom du topo</th>
            <th class="text-center" scope="col">Nom de l'emprunteur</th>
            <th class="text-center" scope="col">Date d'emprunt</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="lend" items="${reservations}">
            <tr>
                <c:if test="${lend.accepted}">
                    <td class="text-center" scope="row">${lend.bookReservation}</td>
                    <td class="text-center" scope="row">${lend.borrower}</td>
                    <td class="text-center" scope="row"><fmt:formatDate value="${lend.borrowing}"></fmt:formatDate></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
