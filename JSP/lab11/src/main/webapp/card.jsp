<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Product Page</title>

</head>
<body>

<h3>Product List</h3>
<c:set var="total" value="0"></c:set>
    <div class="item">
    <c:forEach var="product" items="${products }">
        <c:set var="total" value="${total + product.price  }"></c:set>
        <tr>
            <td>${product.product_id }</td>
            <td>${product.product_name }</td>
            <td><img
                    src=""
                    width="120"></td>
            <td>${product.price }</td>
            <td>${product.price  }</td>
        </tr>
    </c:forEach>

    </div>

</body>
</html>