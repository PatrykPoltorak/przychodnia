<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li class="nav-item active">
                    <a class="nav-link" href="/patient/add-patient">Dodaj Nowego Pacjenta<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/patient">Pacjent<span class="sr-only">(current)</span></a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="/user/add-user">Dodaj Pracownika<span class="sr-only">(current)</span></a>
                </li> 
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
		    		<th>Status</th>
		        	<th>Data</th>
		        	<th>Imię Lekarza</th>
		        	<th>Nazwisko Lekarza</th>
		    	</tr>
		    </thead>
		      <tbody >
		      <c:forEach items="${visit}" var="visits">
		         <tr>
		         	<td>${visits.id}</td>
	         		<td>${visits.status}</td>
		            <td>${visits.visit_date}</td>	
		            <td>${visits.users.name}</td>
		            <td>${visits.users.surname}</td>	
		         </tr>
		     </c:forEach>
	      </tbody>
	  </table>
	 </div>
 </section>
</body>

</html>
