import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.mock;

public class ErrorFilterTest {

    @Test(expected = IOException.class)
    public void shouldThrowsIOException() throws IOException, ServletException {

        ErrorFilter abcFilter = new ErrorFilter();

        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        abcFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);
    }
}
