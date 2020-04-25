import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/hello.world")
public class AbcFilter implements Filter {

    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String abcValue = "";
        if (servletRequest.getParameter("abc") != null)
            abcValue = servletRequest.getParameter("abc");


        servletResponse.setContentType("text/html");
        servletResponse.getWriter().write(abcValue);
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().write(abcValue);

    }

}