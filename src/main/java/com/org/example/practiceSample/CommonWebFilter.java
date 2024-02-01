package com.org.example.practiceSample;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CommonWebFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain fc) throws IOException, ServletException {
        addCommonAttributes(req);
        fc.doFilter(req, rsp);
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void destroy() {
    }



    public static void addCommonAttributes(ServletRequest req) {
        HttpServletRequest request = (HttpServletRequest)req;
        String context = request.getContextPath();
        request.setAttribute("CONTEXT", context);
        // TODO 공통 적용할 Attribute 를 마음껏 넣으세요
    }

}
