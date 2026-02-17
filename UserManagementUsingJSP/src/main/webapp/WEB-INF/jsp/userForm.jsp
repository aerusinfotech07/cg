<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management - ${user.id == null ? 'New User' : 'Edit User'}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>${user.id == null ? 'Add New User' : 'Edit User'}</h1>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <c:set var="formAction" value="/users"/>
    <c:if test="${user.id != null}"><c:set var="formAction" value="/users/${user.id}"/></c:if>
    <form:form modelAttribute="user" method="post" action="${formAction}">
        <form:hidden path="id"/>
        <div class="form-group">
            <label>Name</label>
            <form:input path="name" class="form-control" required="required"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label>Username</label>
            <form:input path="username" class="form-control" required="required"/>
            <form:errors path="username" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label>Email</label>
            <form:input path="email" type="email" class="form-control" required="required"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label>Phone</label>
            <form:input path="phone" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Website</label>
            <form:input path="website" class="form-control"/>
        </div>
        <h5 class="mt-3">Address</h5>
        <div class="form-group">
            <label>Street</label>
            <form:input path="address.street" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Suite</label>
            <form:input path="address.suite" class="form-control"/>
        </div>
        <div class="form-group">
            <label>City</label>
            <form:input path="address.city" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Zipcode</label>
            <form:input path="address.zipcode" class="form-control"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Lat</label>
                <form:input path="address.geo.lat" class="form-control"/>
            </div>
            <div class="form-group col-md-6">
                <label>Lng</label>
                <form:input path="address.geo.lng" class="form-control"/>
            </div>
        </div>
        <h5 class="mt-3">Company</h5>
        <div class="form-group">
            <label>Company Name</label>
            <form:input path="company.name" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Catch Phrase</label>
            <form:input path="company.catchPhrase" class="form-control"/>
        </div>
        <div class="form-group">
            <label>BS</label>
            <form:input path="company.bs" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <a href="<c:url value='/users'/>" class="btn btn-secondary">Cancel</a>
    </form:form>
</div>
</body>
</html>
