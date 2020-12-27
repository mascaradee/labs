<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <c:out value="${10 / 2 }"></c:out>
<%--     <c:out value="${[1,3,5,2].stream().sorted().toList().toString() }"></c:out> --%>
    <!--  [1, 2, 3, 5] -->
    <br/>
</body>
</html>