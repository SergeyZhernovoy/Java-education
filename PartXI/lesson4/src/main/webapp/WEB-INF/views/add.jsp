<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                <p>Add a car in the store</p>
            </div>
        </div>
    </section>

    <a href="<c:url value="/logout" />" class="btn btndanger btn-mini pull-right">logout</a>


    <section class="container">
        <form:form modelAttribute="orderDTO" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/add" enctype="multipart/form-data">
            <fieldset>
                <legend>Add new order and car</legend>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="nameCar">Car name</label>
                    <div class="col-lg-10">
                        <form:input id="nameCar" path="nameCar" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="price">Car price</label>
                    <div class="col-lg-10">
                        <form:input id="price" path="price" type="number" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="mile">Car mile</label>
                    <div class="col-lg-10">
                        <form:input id="mile" path="mile" type="number" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="date">Car release</label>
                    <div class="col-lg-10">
                        <form:input id="date" path="release" type="date" class="form:input-large"/>
                    </div>
                </div>

                <div class="container">
                     <div class="form-group">
                         <label for="body">Car body:</label>
                         <form:select path="bodyId" id="body" cssClass="form-control">
                             <form:options items="${body}" itemLabel="name" itemValue="id"></form:options>
                         </form:select>
                     </div>
                </div>

                <div class="container">
                    <div class="form-group">
                        <label for="model">Car model:</label>
                        <form:select path="modelId" id="model" cssClass="form-control">
                            <form:options items="${model}" itemLabel="name" itemValue="id"></form:options>
                        </form:select>
                    </div>
                </div>


                <div class="container">
                    <div class="form-group">
                        <label for="engine">Car engine:</label>
                        <form:select path="engineId" id="engine" cssClass="form-control">
                            <form:options items="${engine}" itemLabel="name" itemValue="id"></form:options>
                        </form:select>
                    </div>
                </div>

                <div class="container">
                    <div class="form-group">
                        <label for="trans">Car transmission:</label>
                        <form:select path="transsmId" id="trans" cssClass="form-control">
                            <form:options items="${transsm}" itemLabel="name" itemValue="id"></form:options>
                        </form:select>
                    </div>
                </div>

                <div class="container">
                    <div class="form-group">
                        <label for="drive">Car drive type:</label>
                        <form:select path="drivetypeId" id="drive" cssClass="form-control">
                            <form:options items="${drivetype}" itemLabel="name" itemValue="id"></form:options>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="carImage">car image</label>
                    <div class="col-lg-10">
                        <form:input id="carImage" path="multipartFile" type="file" class="form:input-large" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </section>
   </body>
</html>