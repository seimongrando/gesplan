package br.com.gesplan.infrastructure.logger;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Component
public class LogFilter extends CommonsRequestLoggingFilter {

    public LogFilter() {
        setIncludeQueryString(true);
        setIncludePayload(true);
        setIncludeHeaders(true);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        setMaxPayloadLength(request.getContentLength());
        
        super.doFilterInternal(request, response, filterChain);

    }
    
    @Override
    protected boolean shouldNotFilter(final HttpServletRequest request) throws ServletException {
        return request.getRequestURI().contains("actuator");
    }
    
    @Override
    public void setMaxPayloadLength(int maxPayloadLength) {
        if (maxPayloadLength <= 0) {
            return;
        }
        super.setMaxPayloadLength(maxPayloadLength);
    }

}
