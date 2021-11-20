<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    

    <title>Przychodnia </title>

    
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
	<form:form method="post" modelAttribute="visit">
		<table>
      		<thead >
		    	<tr>
	    		<th>Imię Pacjenta</th>
	    		<th>Nazwisko Pacjenta</th>
	    		<th>Lekarz Pacjenta</th>	        
	    		</tr>
    		</thead>
      		<tbody >
	      		
					<tr >
						<td> <form:input path = "patient.id" value = "${patients.id}"></form:input></td>				      	    
							<td>
								<form:select path ="users">
									<c:forEach items="${doctor}" var="doctors">
										<option  value = "${doctors.id}">${doctors.name} ${doctors.surname}</option>
									</c:forEach>						
								</form:select>	
							</td>						
			      	    <td><input type ="submit" value="Zapisz Wizytę"/></td>
					</tr> 				
			</tbody>
		</table>
	</form:form>
	</div>
</section>

</body>
</html>