package com.forezp.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
public class MyFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext cur = RequestContext.getCurrentContext();
        HttpServletRequest request = cur.getRequest();
        log.info(String.format("%s>>>%s",request.getMethod(),request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(token == null){
            log.warn("token is empty");
            cur.setSendZuulResponse(false);
            cur.setResponseStatusCode(401);
            try {
                cur.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
            }
            return null;
        }
        log.info("ok");
        return null;

    }
}
