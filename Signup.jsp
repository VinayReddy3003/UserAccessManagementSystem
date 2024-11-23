<!DOCTYPE html>
<html>
<head>
    <title>Sign-Up</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="SignUpServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="hidden" name="role" value="Employee">
        
        <button type="submit">Register</button>
    </form>
</body>
</html>