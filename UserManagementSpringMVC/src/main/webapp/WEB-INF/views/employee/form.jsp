<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>${employee.id != null ? 'Edit' : 'Create'} Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>${employee.id != null ? 'Edit' : 'Create'} Employee</h2>
    <p class="mb-3">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-outline-primary btn-sm">Users</a>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-primary btn-sm">Employees</a>
    </p>
    <form:form modelAttribute="employee" action="${pageContext.request.contextPath}/employees/save" method="post" cssClass="needs-validation">
        <form:hidden path="id"/>
        <c:if test="${employee.address != null && employee.address.id != null}">
            <form:hidden path="address.id"/>
            <c:if test="${employee.address.geo != null && employee.address.geo.id != null}">
                <form:hidden path="address.geo.id"/>
            </c:if>
        </c:if>

        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="name" class="form-label">Name *</form:label>
                <form:input path="name" class="form-control" required="required"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="employeeCode" class="form-label">Employee Code *</form:label>
                <form:input path="employeeCode" class="form-control" required="required"/>
                <form:errors path="employeeCode" cssClass="text-danger"/>
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

        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="designation" class="form-label">Designation</form:label>
                <form:input path="designation" class="form-control"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="department" class="form-label">Department</form:label>
                <form:input path="department" class="form-control"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <form:label path="joinDate" class="form-label">Join Date</form:label>
                <form:input path="joinDate" type="date" class="form-control"/>
            </div>
            <div class="col-md-6 mb-3">
                <form:label path="salary" class="form-label">Salary</form:label>
                <form:input path="salary" type="number" step="0.01" class="form-control"/>
            </div>
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

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-secondary">Cancel</a>
    </form:form>
</div>
</body>
</html>
