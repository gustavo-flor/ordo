package com.github.gustavoflor.ordo.web.filter;

import com.github.gustavoflor.ordo.context.ThreadContext;
import com.github.gustavoflor.ordo.web.HttpHeader;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest httpRequest) {
            ThreadContext.setUserId(httpRequest.getHeader(HttpHeader.USER_ID.getHeaderName()));
        }
        filterChain.doFilter(request, response);
    }
}
