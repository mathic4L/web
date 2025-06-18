import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AreaCheckServlet extends HttpServlet {
    float x;
    float y;
    int r;
    ArrayList<String[]> strings;

    private void initFields() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        r = Integer.parseInt(req.getParameter("r"));
        x = Float.parseFloat(req.getParameter("x"));
        y = Float.parseFloat(req.getParameter("y"));
        String check = check();
//        FileWriter r = new FileWriter("C:\\Users\\sople\\IdeaProjects\\weblab2real\\src\\main\\resources\\log.txt");
//        r.write("req received");
//        r.flush();

        if (getServletContext().getAttribute("data") == null) {
            strings = new ArrayList<>();
            getServletContext().setAttribute("data", new ArrayList<>());
        } else {
            strings = (ArrayList<String[]>) getServletContext().getAttribute("data");
        }
        strings.add(new String[]{String.valueOf(x), String.valueOf(y), String.valueOf(r), check});
        getServletContext().setAttribute("data", strings);

        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head></head>");
        pw.println("<body>");
        pw.println("<table>");
        pw.println("<tr>" +
                "<th>X</th>" +
                "<th>Y</th>" +
                "<th>Z</th>" +
                "<th>Results</th>" +
                "</tr>");
        strings.forEach((x) -> pw.println(
                "<tr>" +
                        "<td>" + x[0] + "</td>" +
                        "<td>" + x[1] + "</td>" +
                        "<td>" + x[2] + "</td>" +
                        "<td>" + x[3] + "</td>" +
                        "</tr>"));
        pw.println("<a href=\"./\">go back</a>\n");
        pw.println("</body>");
        pw.println("</html>");
    }

    public String check() {
        if (x > 0 && y > 0) {
            return "no";
        } else if (x > 0 && y <= 0) {
            return (x * x + y * y) <= r * r ? "yes" : "no";
        } else if (x <= 0 && y > 0) {
            return ((y <= r / 2) && (x >= -r)) ? "yes" : "no";
        } else {
            return ((x >= -r) && (y >= -x - r)) ? "yes" : "no";
        }
    }
}


