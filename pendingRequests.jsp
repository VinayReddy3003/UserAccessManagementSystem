<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Access Requests</h2>
    <form action="ApprovalServlet" method="post">
        <table>
            <thead>
                <tr>
                    <th>Employee Name</th>
                    <th>Software</th>
                    <th>Access Type</th>
                    <th>Reason</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Rows dynamically populated -->
            </tbody>
        </table>
        <button type="submit">Submit Decisions</button>
    </form>
</body>
</html>