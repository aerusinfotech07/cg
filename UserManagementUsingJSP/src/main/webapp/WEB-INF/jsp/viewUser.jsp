<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User - ${user.name}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>${user.name}</h1>
    <dl class="row">
        <dt class="col-sm-2">ID</dt>
        <dd class="col-sm-10">${user.id}</dd>
        <dt class="col-sm-2">Username</dt>
        <dd class="col-sm-10">${user.username}</dd>
        <dt class="col-sm-2">Email</dt>
        <dd class="col-sm-10">${user.email}</dd>
        <dt class="col-sm-2">Phone</dt>
        <dd class="col-sm-10">${user.phone}</dd>
        <dt class="col-sm-2">Website</dt>
        <dd class="col-sm-10">${user.website}</dd>
        <c:if test="${user.address != null}">
            <dt class="col-sm-2">Address</dt>
            <dd class="col-sm-10">
                ${user.address.street}, ${user.address.suite}, ${user.address.city} ${user.address.zipcode}
                <c:if test="${user.address.geo != null}"> (${user.address.geo.lat}, ${user.address.geo.lng})</c:if>
            </dd>
        </c:if>
        <c:if test="${user.company != null}">
            <dt class="col-sm-2">Company</dt>
            <dd class="col-sm-10">${user.company.name} - ${user.company.catchPhrase}</dd>
        </c:if>
    </dl>
    <a href="<c:url value='/users/${user.id}/edit'/>" class="btn btn-warning">Edit</a>
    <a href="<c:url value='/users'/>" class="btn btn-secondary">Back to List</a>
</div>
</body>
</html>
