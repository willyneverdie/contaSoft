<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%=request.getAttribute("clients")%> <!-- Mostrar atributo  -->
<%=request.getAttribute("list")%> <!-- Mostrar Lista  -->
<%=request.getAttribute("client")%> <!-- Mostrar Lista  -->


<html>
<head>

<script type="text/javascript">

var json=<%=request.getAttribute("client")%>;
//alert(json[0].rut);

</script>

</head>
<body>

<table>
    <c:forEach items="${persons}" var="client">
        <tr>
            <td>${person.name}</td>
            <td>${person.rut}</td>
        </tr>
    </c:forEach>
</table>

<div class="row">
		
			<div class="col-lg-1">
				lorem ipmsu		
			</div>
			<div class="col-lg-1">
				lorem ipmsu		
			</div>
			<div class="col-lg-1">
				lorem ipmsu		
			</div>
			<div class="col-lg-1">
				lorem ipmsu		
			</div>
			<div class="col-lg-1">
				lorem ipmsu		
			</div>
			<div class="col-lg-1">
				lorem ipmsu		
			</div>
		
		</div>

</body>

</html>