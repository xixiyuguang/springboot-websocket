package com.yg.springboot_websocket.base;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


/**
 * @author: dobell
 * @link: http://www.dobell.me/
 * @description:
 */
public class SocketHelper {


    /***
     * @author: dobell
     * @link: http://www.dobell.me/
     * @date: 2018/11/9 14:28
     * @param: 移除socket会话
     * @description:
     * @return:
     */
    public static void removeSession(WebSocketSession socketSession) throws IOException {
        String typeTheOneKey = SessionHelper.getTypeTheOneKey(socketSession);
        if (socketSession.isOpen()) {
            socketSession.close();
        }
        BaseConstant.Socket.USER_SOCKET_ONLINE_MAP.remove(typeTheOneKey);
    }


    public static void sendMessage(String from, String txt, String... tos) {
        for (String to : tos) {

        }
    }

    public static void sendMessage(String from, String txt, String to) {
        Map<String, WebSocketSession> userSocketAllMap = BaseConstant.Socket.USER_SOCKET_ONLINE_MAP;
        if (userSocketAllMap.containsKey(to)) {
            WebSocketSession webSocketSession = userSocketAllMap.get(to);
            sendMessage(from, txt, webSocketSession);
        } else {

        }
    }


    /***
     * @author: dobell
     * @link: http://www.dobell.me/
     * @date: 2018/11/9 14:27
     * @param: 一对一发送
     * @description:
     * @return:
     */
    public static void sendMessage(String from, String txt, WebSocketSession socketSession) {
        try {
            TextMessage message = new TextMessage(from + ":" + txt);
            socketSession.sendMessage(message);

            //将消息记录存放 mongo库中
//            MongoSocketMessageEntity mongoSocketMessageEntity = new MongoSocketMessageEntity();
//            mongoSocketMessageEntity.setFrom(from);
//            mongoSocketMessageEntity.setTo(SessionHelper.getUserCode(socketSession));
//            mongoSocketMessageEntity.setToEvent(SessionHelper.getSocketEevent(socketSession));
//            mongoSocketMessageEntity.setMessage(txt);
//            mongoSocketMessageEntity.setTime(DataUtil.getDate());
//
//            MongoSocketMessageEntityTemplate template = BeanHelper.getBean(MongoSocketMessageEntityTemplate.class);
//            template.asyncSave(mongoSocketMessageEntity);

        } catch (Exception e) {

        }
    }

    /***
     * @author: dobell
     * @link: http://www.dobell.me/
     * @date: 2018/11/9 14:27
     * @param: 在线用户群发
     * @description:
     * @return:
     */
    public static void sendMessage(final TextMessage message) throws IOException {
        Iterator<Map.Entry<String, WebSocketSession>> it = BaseConstant.Socket.USER_SOCKET_ONLINE_MAP.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry<String, WebSocketSession> entry = it.next();
            if (entry.getValue().isOpen()) {
                try {
                    if (entry.getValue().isOpen()) {
                        entry.getValue().sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
