import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SoftwareServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/user_management";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String[] accessLevels = request.getParameterValues("accessLevels");
        StringBuilder accessLevelsString = new StringBuilder();

        if (accessLevels != null) {
            for (String level : accessLevels) {
                accessLevelsString.append(level).append(",");
            }
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, accessLevelsString.toString());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.getWriter().println("Software created successfully!");
                response.sendRedirect("createSoftware.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}