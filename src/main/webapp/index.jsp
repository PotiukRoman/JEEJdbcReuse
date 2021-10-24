<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Contacts Handling</title>
</head>
<body>
<h1><%= "Click the appropriate link" %>
</h1>
<br/>
<a href="contacts">Get All Contacts</a>
<br/>
<a href="contacts/259">Get Contacts By Id</a>
<br/>
<a href="deletecontactbyid?id=258">Delete Contact By Id</a>
<br/>
<a href="updateanycontactfieldbyid?id=258&firstName=Nik&lastName=Port&phone=234">Put Contact</a>
<br/>
<a href="postcontact?firstName=Nik&lastName=Port&phone=777">Post Contact</a>
<br/>
<a href="postbulkcontact">Post Bulk Contact</a>
</body>
</html>