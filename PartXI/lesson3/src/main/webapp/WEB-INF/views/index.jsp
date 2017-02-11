<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/car.png" type="image/png">
        <title>Car store</title>
    </head>
    <body>

        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Car store</h1>
                    <p>All the available cars in our store</p>
                </div>
            </div>
        </section>

         <section>
            <div class="container">
                <p>  <a href="<spring:url value= "/add" /> " class="btn btn-primary btn-block">
                     <span class="glyphicon glyphicon-plus-sign glyphicon"/></span> Add order</a>
                </p>
            </div>
        </section>

        <section class="container">
            <div class="row"><c:forEach items="${orders}" var="order">
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                    <div class="thumbnail">

                        <div class='car-photo'>
                            <c:choose>
                                <c:when test="${empty order.photo}">
                                    <img class='img-rounded' src="<c:url value="/resources/images/default.jpg"></c:url>" alt="image" style = "width:100%"/>
                                </c:when>
                                <c:otherwise>
                                    <img class='img-rounded' src="<c:url value="/resources/images/${order.image}"></c:url>" alt="image" style = "width:100%"/>
                                </c:otherwise>
                            </c:choose>
                        </div>




                        <div class="caption">
                            <h3><strong>Car :</strong> <span class="label label-warning">${order.car.name}</span></h3>
                            <p><strong>price :</strong>$${order.price}</p>
                            <p><strong>mile :</strong>${order.milesage}</p>
                            <p>
                                <c:choose>
                                    <c:when  test="${not order.sold}"><span class="label label-success">sale</span></c:when>
                                    <c:when  test="${order.sold}"><span class="label label-danger">sold</span></c:when>
                                </c:choose>
                            </p>
                            <p>
                                <a href="<spring:url value= "/car?id=${order.car.id}" /> " class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Details</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
        </section>

    </body>
</html>
