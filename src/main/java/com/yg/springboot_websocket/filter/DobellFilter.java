package com.yg.springboot_websocket.filter;


import com.yg.springboot_websocket.base.BaseConstant;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dobell
 * @link: http://www.dobell.me/
 * @description:
 */
@Component
public class DobellFilter implements Filter {


    private static final String protocol = "Sec-WebSocket-Protocol";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // option请求直接返回正常状态
        //让客户端获取相关参数
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "Authorization");
        if (servletRequest instanceof HttpServletRequest) {
            System.out.println("=======================================================");
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " request in ["
                    + ((HttpServletRequest) servletRequest).getRequestURI() + "]");
        }
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
        }
        //web-socket 请求
        String webSocketProtocol = getWebSocketProtocol(httpServletRequest);
        if (!isEmpty(webSocketProtocol)) {
            BaseConstant.Socket.STRING_THREAD_LOCAL.set(webSocketProtocol);
            httpServletResponse.setHeader(getProtocol(), webSocketProtocol);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    public static String getWebSocketProtocol(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(protocol);
    }

    public static boolean isEmpty(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String getProtocol() {
        return protocol;
    }
}
