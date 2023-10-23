package commons;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ScriptUtil {

    public static void alertError(HttpServletResponse resp, Exception e) throws IOException {

        resp.setContentType("text/html; charsest=UTF-8");
        PrintWriter out = resp.getWriter(); // getWriter()-> 예외가 발생하기 때문에 -> throws IOException
        out.printf("<script>alert('%s');</script>", e.getMessage());
        e.printStackTrace();
    }



}
