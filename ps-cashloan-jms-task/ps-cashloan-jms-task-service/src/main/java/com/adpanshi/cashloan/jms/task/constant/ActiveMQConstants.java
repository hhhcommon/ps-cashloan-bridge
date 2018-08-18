package com.adpanshi.cashloan.jms.task.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fish_coder
 * @Title: ActiveMQConstants
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/311:26
 */
public class ActiveMQConstants {

    public interface ACTIVEMQ_NOTIFY_ACTION {
        public static final String SMS = "sms"; //短信
        public static final String MAIL = "mail"; //站内信
        public static final String EMAIL = "email"; //邮件

    }

    public static final Map<String, Object> ActivemqNotifyActionNameMap = new HashMap<String, Object>() {
        private static final long serialVersionUID = -35060321938891798L;

        {
            put("sms", "短信");
            put("mail", "站内信");
            put("email", "邮件");
        }
    };

    public interface ACTIVEMQ_DISPATCH_ACTION {
        public static final String DISPATCH_1 = "dispatch_1"; //调度中心任务1

    }


}
