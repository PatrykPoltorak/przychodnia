<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <nav >
        <a  href="/home">Przychodnia</a>
        <div >
            <ul >
            	<sec:authorize access="hasAnyRole('ADMIN','RECEPTION')">
	                <li class="nav-item active">
	                    <a class="nav-link" href="/patient/add">Dodaj Nowego Pacjenta<span class="sr-only">(current)</span></a>
	                </li>
	                </sec:authorize>
                <li class="nav-item">
                    <a class="nav-link" href="/patient">Pacjent<span class="sr-only">(current)</span></a>
                </li> 
                <sec:authorize access="hasAnyRole('ADMIN')">
	                <li class="nav-item">
	                    <a class="nav-link" href="/user/add-user">Dodaj Pracownika<span class="sr-only">(current)</span></a>
	                </li> 
                </sec:authorize>
                <li class="nav-item active">
                    <a class="nav-link" href="/user/doctors">Plan Lekarza<span class="sr-only">(current)</span></a>
                </li>                
            </ul>
        </div>
    </nav>
</header>
<section>
	<div class = "main">
		<table class="table table-striped table-sm">
      		<thead>
		    	<tr>
		    		<th>ID</th>
		        	<th>Imię</th>
			        <th>Nazwisko</th>

		    	</tr>
		    </thead>
		      <tbody >
		      <c:forEach items="${users}" var="doctors">
		         <tr>
		         	<td>${doctors.id}</td>	
		            <td>${doctors.name}</td>		
		            <td>${doctors.surname}</td>		
		         </tr>
		     </c:forEach>
	      </tbody>
	  </table>
	 </div>
 </section>
</body>

</html>
