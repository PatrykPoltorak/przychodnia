<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<form:form method="post" modelAttribute="patient">
			<table class="table table-striped table-sm">
	      		<thead>
			    	<tr>
			        	<th>Imię</th>
				        <th>Nazwisko</th>
				        <th>Miasto</th>
				        <th>Ulica</th>
				        <th>Nr domu</th>
				        <th>Pesel</th>
			    	</tr>
			    </thead>
			      <tbody >		      
			         <tr >	
			             <td> <form:input path = "name" type = "text"></form:input></td>		
			             <td> <form:input path = "surname" type = "text"></form:input></td>		
			             <td> <form:input path = "city" type = "text"></form:input></td>
			             <td> <form:input path = "street" type = "text"></form:input></td>
			             <td> <form:input path = "streetNumber" type = "text"></form:input></td>
			             <td> <form:input path = "pesel" type = "text"></form:input></td>
			         </tr>	     
		      </tbody>
		  </table>
		  <button type="submit" >Dodaj pacjenta</button>
	  </form:form>
	 </div>
 </section>
</body>

</html>
