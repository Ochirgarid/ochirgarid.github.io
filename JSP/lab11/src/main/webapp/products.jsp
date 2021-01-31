<%--
  Created by IntelliJ IDEA.
  User: xp
  Date: 1/30/2021
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Products</title>

    <script type="text/javascript" src="static/product.js"></script>
    <link href="static/styles.css" rel="stylesheet">
</head>
<body>
<div class="container">
<div class="header">
    <h3>Product List</h3>
</div>
<div class="content">
<c:set var="total" value="0"></c:set>
    <c:forEach var="product" items="${products }">
        <div class="product">
        <c:set var="total" value="${total + product.price  }"></c:set>

            <p > ${product.product_id }</p>
            ${product.product_name }
            <p>$${product.price } USD</p>
            <button name="add" value="${product.product_id}">Add</button>
        </div>
    </c:forEach>
</div>
    <div class="footer">
        2021 @MIU
    </div>
</div>
</body>
</html>