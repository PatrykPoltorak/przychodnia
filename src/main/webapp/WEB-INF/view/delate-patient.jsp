<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Przychodnia </title>

    <link href="/style.css" rel="stylesheet">
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
	<form:form method="post" modelAttribute="patient">
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
		      		<tr>
			         	<td>${patient.id}</td>	
			            <td>${patient.name}</td>		
			            <td>${patient.surname}</td>		
			            <td>${patient.city}</td>
			            <td>${patient.street}</td>
			            <td>${patient.streetNumber}</td>
			            <td>${patient.pesel}</td>
		            </tr>		            
	      	</tbody>
		  </table>
		  <form:button type="submit" >Usuń Pacjenta</form:button>
	  </form:form>
	 </div>
 </section>

</body>
</html>