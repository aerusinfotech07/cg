<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Employee Details</h2>
    <p class="mb-3">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-outline-primary btn-sm">Users</a>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-primary btn-sm">Employees</a>
    </p>
    <div class="mb-3">
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-secondary">Back to List</a>
        <a href="${pageContext.request.contextPath}/employees/edit/${employee.id}" class="btn btn-warning">Edit</a>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="card mb-3">
                <div class="card-header"><h5>Personal & Job Information</h5></div>
                <div class="card-body">
                    <p><strong>ID:</strong> ${employee.id}</p>
                    <p><strong>Name:</strong> ${employee.name}</p>
                    <p><strong>Employee Code:</strong> ${employee.employeeCode}</p>
                    <p><strong>Email:</strong> ${employee.email}</p>
                    <p><strong>Phone:</strong> ${employee.phone != null ? employee.phone : '-'}</p>
                    <p><strong>Designation:</strong> ${employee.designation != null ? employee.designation : '-'}</p>
                    <p><strong>Department:</strong> ${employee.department != null ? employee.department : '-'}</p>
                    <p><strong>Join Date:</strong> <fmt:formatDate value="${employee.joinDate}" pattern="yyyy-MM-dd"/></p>
                    <p><strong>Salary:</strong> ${employee.salary != null ? employee.salary : '-'}</p>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-3">
                <div class="card-header"><h5>Address</h5></div>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${employee.address != null}">
                            <p><strong>Street:</strong> ${employee.address.street}</p>
                            <p><strong>Suite:</strong> ${employee.address.suite != null ? employee.address.suite : '-'}</p>
                            <p><strong>City:</strong> ${employee.address.city}</p>
                            <p><strong>Zipcode:</strong> ${employee.address.zipcode}</p>
                            <c:if test="${employee.address.geo != null}">
                                <p><strong>Latitude:</strong> ${employee.address.geo.lat != null ? employee.address.geo.lat : '-'}</p>
                                <p><strong>Longitude:</strong> ${employee.address.geo.lng != null ? employee.address.geo.lng : '-'}</p>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <p class="text-muted">No address</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
