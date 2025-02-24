<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
  <h4>
  <% session = request.getSession(); %>
  Hi <%= session.getAttribute("cname") %>, welcome to our bank's loan application portal <br>
  Your Email: <%= session.getAttribute("email") %> <br>
  Your Account Number: <%= session.getAttribute("accno") %>
  </h4>
  <a href="Home.html">Go Back to Home</a>
  </div>
</body>
</html>