<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>

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
		<form:form method="post" modelAttribute="users">
			<table >
	      		<thead>
			    	<tr>
			        	<th>Login</th>
				        <th>Hasło</th>
				        <th>Imię</th>
				        <th>Nazwisko</th>
				        <th>Rola</th>
			    	</tr>
			    </thead>
			    	<tbody >		      
			        	<tr >
			        		<td> <form:input path = "username" type = "text"></form:input></td>		
				            <td> <form:input path = "password" type = "text"></form:input></td>		
				            <td> <form:input path = "name" type = "text"></form:input></td>
				            <td> <form:input path = "surname" type = "text"></form:input></td>
					        <td>   
					            <form:select  path = "roles">			            	
					            	<c:forEach items = "${role}" var = "rol" >
										<option value = "${rol.id}">${rol.name}</option>
									</c:forEach>
								</form:select>
							</td>
							<td><button type="submit" value ="Dodaj urzytkownika"></button></td>
			        	</tr>	     
		      	</tbody>
		  	</table>
			<button type="submit" value ="Dodaj urzytkownika"></button>
	  </form:form>
	 </div>
 </section>
</body>

</html>
