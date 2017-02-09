<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/car.png" type="image/png">
    <title>Car store</title>
</head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Car information</h1>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${car.id}.jpg"></c:url>" alt="image" style = "width:100%"/>
                </div>
                <div class="col-md-5">
                    <h3><strong>Car : </strong><span class="label label-warning">${car.name}</span></h3>
                    <p><strong>Brand : </strong>${model.name}</p>
                    <p><strong>Body : </strong>${body.name}</p>
                    <p><strong>Engine : </strong>${engine.name}</p>
                    <p><strong>Drivetype : </strong>${drive.name}</p>
                    <p><strong>Transmission : </strong>${transsm.name} </p>

                    <p><a href="#" class="btn btn-success btn-large"> <span class="glyphicon-shopping-cart glyphicon"></span> Order Now</a></p>
                    <a href="<spring:url value="/" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span> back
                    </a>
                </div>
            </div>
        </section>

    </body>
</html>