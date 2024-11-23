import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApprovalServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/user_management";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] approvedIds = request.getParameterValues("approved");
        String[] rejectedIds = request.getParameterValues("rejected");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            if (approvedIds != null) {
                for (String id : approvedIds) {
                    String sql = "UPDATE requests SET status = 'Approved' WHERE id = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(id));
                    statement.executeUpdate();
                }
            }
            if (rejectedIds != null) {
                for (String id : rejectedIds) {
                    String sql = "UPDATE requests SET status = 'Rejected' WHERE id = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, Integer.parseInt(id));
                    statement.executeUpdate();
                }
            }
            response.sendRedirect("pendingRequests.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}