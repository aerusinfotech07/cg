<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>${user.id != null ? 'Edit' : 'Create'} User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>${user.id != null ? 'Edit' : 'Create'} User</h2>
    <p class="mb-3">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-primary btn-sm">Users</a>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-outline-primary btn-sm">Employees</a>
    </p>
    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/users/save" method="post" cssClass="needs-validation">
        <form:hidden path="id"/>
        <c:if test="${user.address != null && user.address.id != null}">
            <form:hidden path="address.id"/>
            <c:if test="${user.address.geo != null && user.address.geo.id != null}">
                <form:hidden path="address.geo.id"/>
            </c:if>
        </c:if>
        <c:if test="${user.company != null && user.company.id != null}">
            <form:hidden path="company.id"/>
        </c:if>

        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="name" class="form-label">Name *</form:label>
                <form:input path="name" class="form-control" required="required"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="username" class="form-label">Username *</form:label>
                <form:input path="username" class="form-control" required="required"/>
                <form:errors path="username" cssClass="text-danger"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="email" class="form-label">Email *</form:label>
                <form:input path="email" type="email" class="form-control" required="required"/>
                <form:errors path="email" cssClass="text-danger"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="phone" class="form-label">Phone</form:label>
                <form:input path="phone" class="form-control"/>
            </div>
        </div>

        <div class="mb-3">
            <form:label path="website" class="form-label">Website</form:label>
            <form:input path="website" class="form-control"/>
        </div>

        <h5 class="mt-4">Address</h5>
        <hr/>
        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="address.street" class="form-label">Street *</form:label>
                <form:input path="address.street" class="form-control" required="required"/>
                <form:errors path="address.street" cssClass="text-danger"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="address.suite" class="form-label">Suite</form:label>
                <form:input path="address.suite" class="form-control"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="address.city" class="form-label">City *</form:label>
                <form:input path="address.city" class="form-control" required="required"/>
                <form:errors path="address.city" cssClass="text-danger"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="address.zipcode" class="form-label">Zipcode *</form:label>
                <form:input path="address.zipcode" class="form-control" required="required"/>
                <form:errors path="address.zipcode" cssClass="text-danger"/>
            </div>
        </div>

        <h6>Geographic Coordinates</h6>
        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="address.geo.lat" class="form-label">Latitude</form:label>
                <form:input path="address.geo.lat" class="form-control"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="address.geo.lng" class="form-label">Longitude</form:label>
                <form:input path="address.geo.lng" class="form-control"/>
            </div>
        </div>

        <h5 class="mt-4">Company</h5>
        <hr/>
        <div class="mb-3">
            <form:label path="company.name" class="form-label">Company Name *</form:label>
            <form:input path="company.name" class="form-control" required="required"/>
            <form:errors path="company.name" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="company.catchPhrase" class="form-label">Catch Phrase</form:label>
            <form:input path="company.catchPhrase" class="form-control"/>
        </div>
        <div class="mb-3">
            <form:label path="company.bs" class="form-label">Business</form:label>
            <form:input path="company.bs" class="form-control"/>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="${pageContext.request.contextPath}/users" class="btn btn-secondary">Cancel</a>
    </form:form>
</div>
</body>
</html>
