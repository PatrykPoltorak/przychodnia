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
		        	<th>Imię</th>
			        <th>Nazwisko</th>
			        <th>Miasto</th>
			        <th>Ulica</th>
			        <th>Nr domu</th>
			        <th>Pesel</th>
		    	</tr>
		    </thead>
		      <tbody >
		      <c:forEach items="${patients}" var="patient">
		         <tr>
		         	<td>${patient.id}</td>	
		            <td>${patient.name}</td>		
		            <td>${patient.surname}</td>		
		            <td>${patient.city}</td>
		            <td>${patient.street}</td>
		            <td>${patient.streetNumber}</td>
		            <td>${patient.pesel}</td>
		            <td><input type = "button" value ="Dodaj Wizytę" onclick="window.location='/patient/add-visit/${patient.id}';"/></td>
		            <td><input type = "button" value ="Edytuj Dane Pacjenta" onclick="window.location='/patient/edit/${patient.id}';"/></td>
		         	<td><input type = "button" value ="Usuń Pacjenta"  onclick="window.location='/patient/delatePatient/${patient.id}';" /></td>
		         </tr>
		     </c:forEach>
	      </tbody>
	  </table>
	 </div>
 </section>
</body>

</html>
