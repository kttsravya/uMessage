<%@ include file="./include.jsp"%>
<html>
<head>
<title>New Profile Information</title>
	 <style>
		.error {
		    font-size: 0.8em;
			color: #ff0000;
		}
	</style> 
 
</head>
<body>

<h2>Hello Users</h2>
<h4> Fill in the form to create new profile</h4>

 <h1>Profile Data Form</h1> 

  <form:form action="./processNewProfileForm" method="POST" commandName="profile">
  <table>
   
  <tr>
  	<td><fmt:message key="id" /></td>
        <td><form:input path="id" />
            <form:errors path="id" cssClass="error"/>
        </td>
    </tr>
    
  <tr>
  	<td><fmt:message key="ProfileName" /></td>
        <td><form:input path="profileName" />
            <form:errors path="profileName" cssClass="error"/>
        </td>
    </tr>
    
    
  	
  
  	<tr>
  	<td><fmt:message key="Lastname" /></td>
        <td><form:input path="lastName" />
            <form:errors path="lastName" cssClass="error"/>
        </td>
    </tr>
    <tr>
  	<td><fmt:message key="firstname" /></td>
        <td><form:input path="firstName" />
            <form:errors path="firstName" cssClass="error"/>
        </td>
    </tr>
   
    <tr>
    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
    </tr>
    </table>
  </form:form>
 
</body>


</html>

