package com.tcshop.security;

import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

/**
 * Created by liuyi on 2017/5/14.
 */
public class TcShopLogoutFilter extends LogoutFilter {

    @Override
    protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
        if (isAjaxRequest((HttpServletRequest) request)) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("{\"success\":true,\"message\":\"logout\"}");
            out.flush();
            out.close();
        } else {
            super.issueRedirect(request, response, redirectUrl);
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }
}
