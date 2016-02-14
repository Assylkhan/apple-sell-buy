package com.milman.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SecurityFilter implements Filter {
    /**
     * set of urls to which not allowed access for unsigned users
     */
    private Set<String> deniedUrls = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        deniedUrls.add("/profilePage");
        deniedUrls.add("/fillItem");
        deniedUrls.add("/postItem");
        deniedUrls.add("/userItems");
        deniedUrls.add("/userItem");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        doFilter(((HttpServletRequest) req), ((HttpServletResponse) resp), chain);
    }

    private void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String requestUri = req.getRequestURI();
        /**
         * redirect users if not authorized, otherwise if authorized user will not have access login and register
         * pages
         */
         if (session.getAttribute("user") != null) {
            if (requestUri.startsWith("/register") ||
                    requestUri.startsWith("/login")) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }
        } else for (String deniedUrl : deniedUrls) {
            if (requestUri.startsWith(deniedUrl)) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
