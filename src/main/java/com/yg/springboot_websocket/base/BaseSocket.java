package com.yg.springboot_websocket.base;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuguang
 * @date 2019-01-20 11:22
 * @Description:
 */
public class BaseSocket {


    /**
     * 异步存储
     */
    public static ThreadLocal<String> STRING_THREAD_LOCAL = new ThreadLocal();

    /**
     * socket秘钥分隔符
     */
    public static final String PROTOCOL = "dobell\\.research";

    /**
     * socket请求携带的参数
     */
    public static final String SOCKET_Protocol = "socketProtocol";


    /**
     * 在线用户
     */
    public static final Map<String, WebSocketSession> USER_SOCKET_ONLINE_MAP = new HashMap();

    /**
     * 关闭连接的用户
     */
    public static final Map<String, WebSocketSession> userSocketCloseMap = new HashMap();
}
