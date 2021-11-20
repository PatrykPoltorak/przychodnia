<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
		        	<th>Imię Pacjenta</th>
			        <th>Nazwisko Pacjenta</th>		    
			        <th>Data</th>
		         	<th>Status</th>	
		         	<th>Wizyty Pacjenta</th>
		    	</tr>
		    </thead>
		      <tbody >		    
		         <tr>
		         	<td>${visit.id}</td>	
		            <td>${visit.patient.name}</td>		
		            <td>${visit.patient.surname}</td>		
		            <td>${visit.visit_date}</td>
					<td>${visit.Status}</td>
					<td><input type = "button" value ="Wizyty Pacjenta" onclick="window.location='/visit/visitForPatient/${visit.patient.id}';"/></td>
		         </tr>
	      </tbody>
	  </table>
	 </div>
 </section>
</body>

</html>
