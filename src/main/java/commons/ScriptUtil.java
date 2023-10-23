package commons;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class ScriptUtil {

    public static void alertError(HttpServletResponse resp, Exception e) throws IOException {

        resp.setContentType("text/html; charsest=UTF-8");
        PrintWriter out = resp.getWriter(); // getWriter()-> 예외가 발생하기 때문에 -> throws IOException
        out.printf("<script>alert('%s');</script>", e.getMessage());
        e.printStackTrace();
    }

    public static void go(HttpServletResponse resp, String url, String target) throws IOException {
        // String target-> iframe 창의 위치

        target = Objects.requireNonNullElse(target, "self");
        resp.setContentType("text/html; charsest=UTF-8");
        PrintWriter out = resp.getWriter();
        out.printf("<script>%s.location.replace('%s');</script>", target, url);
                                        // replace는 history가 기록되지 않음
    }

    public static void go(HttpServletResponse resp, String url) throws IOException{
        go(resp, url, null);
    }



}
