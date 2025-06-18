import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int x = Integer.parseInt(req.getParameter("x"));
            req.setAttribute("x", x);
        } catch (NumberFormatException e) {
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
            return;
        }

        try {
            float y = Float.parseFloat(req.getParameter("y"));
            req.setAttribute("y", y);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
            return;
        }

        try {
            int r = Integer.parseInt(req.getParameter("r"));
            req.setAttribute("r", r);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
            return;
        }

        getServletContext().getRequestDispatcher("/check").forward(req, resp);
    }
}
