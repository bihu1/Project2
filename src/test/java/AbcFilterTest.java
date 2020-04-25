import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class AbcFilterTest extends Mockito {

    @Before
    public void before()
    {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        filterChain = mock(FilterChain.class);

        sw = new StringWriter();
        pw = new PrintWriter(sw);

        abcFilter = new AbcFilter();
    }

    @Test
    public void testFullName() throws IOException, ServletException {


        when(request.getParameter("abc")).thenReturn("test");
        when(response.getWriter()).thenReturn(pw);

        abcFilter.doFilter(request, response, filterChain);
        String result = sw.getBuffer().toString().trim();

        assertEquals(result,"testtest");
        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void testFullName2() throws IOException, ServletException {

        when(response.getWriter()).thenReturn(pw);

        abcFilter.doFilter(request, response, filterChain);
        String result = sw.getBuffer().toString().trim();

        assertEquals(result,"");
        verify(filterChain).doFilter(request, response);
    }

    @Test
    public void testFullName3() throws IOException, ServletException {

        when(request.getParameter("abc2")).thenReturn("test");
        when(request.getParameter("z")).thenReturn("test");
        when(response.getWriter()).thenReturn(pw);

        abcFilter.doFilter(request, response, filterChain);
        String result = sw.getBuffer().toString().trim();

        assertEquals(result,"");
        verify(filterChain).doFilter(request, response);
    }

    private HttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain filterChain;
    private StringWriter sw;
    private PrintWriter pw;
    private AbcFilter abcFilter;
}
