<!DOCTYPE HTML>
<html>
<head>
    <title>Edit Product Form</title>
    <style type="text/css"></style>
</head>
<body>
<h3>Edit Product</h3>

<p style="color: red;">${errorString}</p>

<%--<c:if test="${not empty product}">--%>
    <form method="POST" action="product_edit">
        <input type="hidden" name="id" value="${product.id}" />
        <table border="0">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${product.name}" /></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" value="${product.description}" /></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" value="${product.price}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Edit" />
                    <%--<a href="${pageContext.request.contextPath}/product_list">Cancel</a>--%>
                </td>
            </tr>
        </table>
    </form>
<%--</c:if>--%>
</body>
</html>