package com.spring.zuulgateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulGatewayConfig extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";  //pre, post, error
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest httpServletRequest=  RequestContext.getCurrentContext().getRequest();
        System.out.println(">>>>>>>>>>>>Request From "+ httpServletRequest.getRequestURI());
        return null;
    }
}
