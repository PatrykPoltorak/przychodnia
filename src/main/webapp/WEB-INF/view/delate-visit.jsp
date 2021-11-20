<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
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
                    <a class="nav-link" href="/patient">Dodaj wizytę<span class="sr-only">(current)</span></a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="/patient">Odwołaj wizytę<span class="sr-only">(current)</span></a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="/patient">Pacjent<span class="sr-only">(current)</span></a>
                </li> 
                <li class="nav-item active">
                    <a class="nav-link" href="/">Plan Lekarza<span class="sr-only">(current)</span></a>
                </li>
                             
            </ul>
        </div>
    </nav>
</header>
<section>
	<div class = "main">
	<form:form method="post" modelAttribute="visit">
		<table class="table table-striped table-sm">
      		<thead>
		    	<tr>
		    		<th>Id Wizyty</th>		    		
		        	<th>Imię Pacjenta</th>
			        <th>Nazwisko Pacjenta</th>
			        <th>Imię Lekarza</th>
			        <th>Nazwisko Lekarza</th>
			        <th>Data Wizyty</th>
		        
		    	</tr>
		    </thead>
		      <tbody >		      
		      <tr>		  
		      		<td>${visit.id}</td>    	         		      	
	        		<td>${visit.patient.name}</td>   
		      	    <td>${visit.patient.surname}</td>  
		      	    <td>${visit.users.name}</td>    
		      	    <td>${visit.users.surname}</td> 
		      	    <td>${visit.visit_date}</td>	         		       
		       </tr> 		     
	      </tbody>
	  </table>
	  <form:button type="submit" >Usuń Wizytę</form:button>
	  </form:form>
	 </div>
 </section>
</body>
</html>