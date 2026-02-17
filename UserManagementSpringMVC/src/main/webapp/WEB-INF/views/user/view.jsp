<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>User Details</h2>
    <p class="mb-3">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-primary btn-sm">Users</a>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-outline-primary btn-sm">Employees</a>
    </p>
    <div class="mb-3">
        <a href="${pageContext.request.contextPath}/users" class="btn btn-secondary">Back to List</a>
        <a href="${pageContext.request.contextPath}/users/edit/${user.id}" class="btn btn-warning">Edit</a>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="card mb-3">
                <div class="card-header"><h5>Personal Information</h5></div>
                <div class="card-body">
                    <p><strong>ID:</strong> ${user.id}</p>
                    <p><strong>Name:</strong> ${user.name}</p>
                    <p><strong>Username:</strong> ${user.username}</p>
                    <p><strong>Email:</strong> ${user.email}</p>
                    <p><strong>Phone:</strong> ${user.phone != null ? user.phone : '-'}</p>
                    <p><strong>Website:</strong> ${user.website != null && !user.website.isEmpty() ? user.website : '-'}</p>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-3">
                <div class="card-header"><h5>Address</h5></div>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${user.address != null}">
                            <p><strong>Street:</strong> ${user.address.street}</p>
                            <p><strong>Suite:</strong> ${user.address.suite != null ? user.address.suite : '-'}</p>
                            <p><strong>City:</strong> ${user.address.city}</p>
                            <p><strong>Zipcode:</strong> ${user.address.zipcode}</p>
                            <c:if test="${user.address.geo != null}">
                                <p><strong>Latitude:</strong> ${user.address.geo.lat != null ? user.address.geo.lat : '-'}</p>
                                <p><strong>Longitude:</strong> ${user.address.geo.lng != null ? user.address.geo.lng : '-'}</p>
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

    <div class="card">
        <div class="card-header"><h5>Company</h5></div>
        <div class="card-body">
            <c:choose>
                <c:when test="${user.company != null}">
                    <p><strong>Company Name:</strong> ${user.company.name}</p>
                    <p><strong>Catch Phrase:</strong> ${user.company.catchPhrase != null ? user.company.catchPhrase : '-'}</p>
                    <p><strong>Business:</strong> ${user.company.bs != null ? user.company.bs : '-'}</p>
                </c:when>
                <c:otherwise>
                    <p class="text-muted">No company</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
