package hello.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Reads the unique request ID and transfers it to the MDC.
 * If there is no id in the request, an id is automatically generated as a fallback.
 */
@Component
public class MdcFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(MdcFilter.class);

    private final static String REQUEST_ID_HEADER = "X-Request-Id";

    private final static String ELASTICSEARCH_MDC_FIIELD = "request_id";

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestId = httpServletRequest.getHeader(REQUEST_ID_HEADER);

        if(StringUtils.isEmpty(requestId)) {
            requestId = UUID.randomUUID().toString();
            log.info("No request-id (header X-Request-Id) available. Use UUID fallback instead: {}", requestId);
            requestId = UUID.randomUUID().toString();
        }

        MDC.put(ELASTICSEARCH_MDC_FIIELD, requestId);

        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
