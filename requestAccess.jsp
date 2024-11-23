<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Software Access</h2>
    <form action="RequestServlet" method="post">
        <label for="software">Software:</label>
        <select id="software" name="softwareId">
            <!-- Options dynamically populated -->
        </select><br><br>
        
        <label for="accessType">Access Type:</label>
        <select id="accessType" name="accessType">
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br><br>
        
        <label for="reason">Reason:</label>
        <textarea id="reason" name="reason" rows="4" cols="50"></textarea><br><br>
        
        <button type="submit">Request Access</button>
    </form>
</body>
</html>