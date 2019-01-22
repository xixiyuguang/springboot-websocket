package com.yg.springboot_websocket.base;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dobell
 * @link: http://www.dobell.me/
 * @description:
 */
public class SessionHelper {

    public static String getUserCode(WebSocketSession webSocketSession) {
        return String.valueOf(webSocketSession.getAttributes().get(BaseConstant.User.SESSION_USER_CODE));
    }

    public static String getTypeTheOneKey(WebSocketSession webSocketSession) {
        String protocol = String.valueOf(webSocketSession.getAttributes().get(BaseConstant.Socket.SOCKET_Protocol));
        return protocol;
    }

    public static Map getSocketEevent(WebSocketSession webSocketSession) {
        String userCode = String.valueOf(webSocketSession.getAttributes().get(BaseConstant.User.SESSION_USER_CODE));
        String userTeam = String.valueOf(webSocketSession.getAttributes().get(BaseConstant.User.SESSION_USER_TEAM));
        String userGroup = String.valueOf(webSocketSession.getAttributes().get(BaseConstant.User.SESSION_USER_GROUP));
        String userVersion = String.valueOf(webSocketSession.getAttributes().get(BaseConstant.User.SESSION_USER_VERSION));
        String userType = String.valueOf(webSocketSession.getAttributes().get(BaseConstant.User.SESSION_USER_TYPE));
        Map event = new HashMap();
        event.put("userCode", userCode);
        event.put("userTeam", userTeam);
        event.put("userGroup", userGroup);
        event.put("userVersion", userVersion);
        event.put("userType", userType);
        return event;
    }
}
