package com.yg.springboot_websocket.base;


import org.springframework.web.socket.WebSocketSession;

import java.util.*;


public class BaseConstant {


    /**
     * 分隔符
     */
    public static final String SPLIT = "(dobell)";

    /**
     * 最大支持1-9个集群的机器部署
     */
    public static final int MACHINE_ID = 1;

    /**
     * 获取系统
     */
    public final static String OS = System.getProperty("os.name");

    /**
     * 拦截器过滤规则
     */
    public static Set<String> METHOD_URL_SET = new HashSet<>();


    /**
     * 根菜单节点
     */
    public static final Long TYPE_ROOT = 0L;

    /**
     * 菜单类型，1：菜单  2：按钮操作 3: 功能操作
     */

    public static final Long TYPE_MENU = 1L;

    /**
     * 菜单类型，1：菜单  2：按钮操作 3: 功能操作
     */
    public static final Long TYPE_BUTTON = 2L;

    public static final Long TYPE_FEATURES = 3L;

    /**
     * 是否验证session
     */
    public static boolean IS_PASS = false;

    /**
     * 正常
     */
    public static final Long ENABLE = 1L;

    /**
     * 失效
     */
    public static final Long DISABLE = 0L;

    /**
     * 数据标示  0: 本地，1：迁移
     */
    public static final Long DATA_FLAG = 0L;


    public static class Ehcache {
        /**
         * 角色所属菜单
         */
        public static String MENU_ROLE_CACHE = "MENU_ROLE_CACHE";

        /**
         * 团队菜单
         */
        public static String MENU_INFO_CACHE = "MENU_INFO_CACHE";

        /**
         * 默认名称
         */
        public static String BASE_CACHE = "BASE_CACHE";

        /**
         * linux 存储路径
         */
        public static final String EH_CACHE_LINUX = "/home/ehcache/dobell-research/";

        /**
         * windows存储路径
         */
        public static final String EH_CACHE_WIN = "E:/ehcache/dobell-research/";
    }


    public class Sql {
        /**
         * 慢查询
         */
        public static final int TIME = 300;
    }

    public class Redis {
        /**
         * redis数据库用户信息Key模板
         */
        public static final String REDIS_USER = "TOKEN" + SPLIT;

        public static final String USER_TOKEN = "USER:";

    }

    public static class Sms {
        /**
         * 短信类型
         */
        public static final List<String> availMsgType = Arrays.asList("login", "register",
                "forget", "bind");
        /**
         * 超时时间
         */
        public static final int SMS_LIVE_TIME = 1800;
        /**
         * 短信间隔时间
         */
        public static final int SMS_INTERVAL_TIME = 59;
        /**
         * 验证码模板
         */
        public static final String SMS_TEMPLATE_CODE = "SMS_146802310";
        /**
         * 默认签名(前缀)
         */
        public static final String SMS_SIGN_NAME = "口袋小安";
    }


    public class Url {
        /**
         * 钉钉异常推送地址
         */
        public final static String EXCEPTION_DING = "https://oapi.dingtalk.com/robot/send?access_token=6a2010c2cfbd91530d9c8414d548517b0334cec9570d296953dde053dc773eb9";

        /**
         * 手机号码绑定页面
         */
        public final static String PHONE_BIND = "http://192.168.2.160:8080/validatePhoneNum";

        /**
         * 团队选择页面
         */
        public final static String TEAM_PAGE = "http://192.168.2.160:8080/selectTeam";

        /**
         * 微信登录接口
         */
        public final static String WECHAT_LOGIN = "http://researchstar.dobell.me/dobell-research/wc/weChat/login";
    }


    public class User {
        /**
         * token超时时间3分钟
         */
        public static final long TOKEN_EXPIRE_TIME = 60 * 3 * 1000;

        /**
         * 登录过期30分钟
         */
        public static final long EXPIRE_TIME = 60 * 20;

        /**
         * 用户令牌 Key
         */
        public static final String TOKEN_USER = "user:";
        /**
         * 用户令牌 Redis中存活时间
         */
        public static final long REDIS_TOKEN_EXPIRE_TIME = 60 * 3;

        /**
         * 用户信息Key
         */
        public static final String SESSION_USER = "loginUser";

        /**
         * 用户token key
         */
        public static final String SESSION_TOKEN = "result";

        /**
         * 用户code
         */
        public static final String SESSION_USER_CODE = "loginUserCode";

        /**
         * 用户Team
         */
        public static final String SESSION_USER_TEAM = "loginUserCode";

        /**
         * 用户版本
         */
        public static final String SESSION_USER_VERSION = "loginUserVersion";

        /**
         * 用户类型
         */
        public static final String SESSION_USER_TYPE = "loginUserType";

        /**
         * 用户归属
         */
        public static final String SESSION_USER_GROUP = "loginUserGroup";

        public static final String SESSION_USER_TOKEN = "loginUserToken";

        /**
         * 用户唯一不同版本唯一分割符
         */
        public static final String LOGIN_USER_THE_ONE = "$$";

        /**
         * 启用
         */
        public static final long NORMAl = 1;

        /**
         * 审核
         */
        public static final long REVIEW = 2;

        /**
         * 禁用
         */
        public static final long BANNED = 3;
    }


    public static class RoleType {
        /**
         * 超级管理员
         */
        public static final long SUPER_ADMIN = 5;
        /**
         * 管理员
         */
        public static final long ADMIN = 6;
        /**
         * 普通用户
         */
        public static final long USER = 7;

        /**
         * 菜单列表Key
         */
        public static final String MENU_ARRAY = "menuList";

        /**
         * 按钮列表Key
         */
        public static final String BUTTON_ARRAY = "buttonList";

        /**
         * 功能列表Key
         */
        public static final String FEATURES_ARRAY = "featuresList";


        /**
         * demo 用户编号
         */
        public static final String DEMO_CODE = "demo";

        /**
         * demo 默认权限列表
         */
        public static final Map DEMO_ROLE = new HashMap(2) {{
            put(9L, 5L);
        }};

    }

    public static class Socket {
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

    public class Id {

        /**
         * 用户id前缀
         */
        public static final String DOBELL = "dobell";

        /**
         * 团队code前缀
         */
        public static final String TEAM = "team";

        /**
         * mongo表Id前缀
         */
        public static final String MONGO = "document";

    }

    public class thirdPartyType {

        /**
         * 微信
         */
        public static final long WE_CHAT = 1L;

        /**
         * 邮件
         */
        public static final long MAIL = 2L;


    }

    public class HttpHead {

        /**
         * 是否登录标示
         */
        public static final String TOKEN = "token";


        /**
         * 团队编号
         */
        public static final String TEAM = "team";

        /**
         * 组别
         */
        public static final String GROUP = "group";

        /**
         * 版本
         */
        public static final String VERSION = "version";

        /**
         * 类型
         */
        public static final String TYPE = "type";


    }

    public static class Work {
        /**
         * 横向课题
         */
        public static final Long LEVEL_TYPE = 2L;

        /**
         * 纵向课题
         */
        public static final Long VERTICAL_TYPE = 1L;

    }
}
