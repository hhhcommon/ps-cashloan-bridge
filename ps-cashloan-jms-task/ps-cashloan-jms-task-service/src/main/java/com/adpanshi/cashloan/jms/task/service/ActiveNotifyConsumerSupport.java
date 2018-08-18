package com.adpanshi.cashloan.jms.task.service;

import com.adpanshi.cashloan.jms.action.utils.DateUtil;
import com.adpanshi.cashloan.jms.task.constant.ActiveMQConstants;
import com.adpanshi.cashloan.jms.task.factory.ActiveMQListener;
import com.cashloan.jms.action.domain.SmsNotifyDomain;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fish_coder
 * @Title: ActiveConsumerSupport
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/311:16
 */
public class ActiveNotifyConsumerSupport extends ActiveMQListener {
    private static Logger logger = Logger.getLogger(ActiveNotifyConsumerSupport.class);
    public ActiveNotifyConsumerSupport() throws NamingException, JMSException {
        super();
    }
    @Resource
    private SmsNotifyDomain smsNotifyDomain;

    @Override
    public void onMessage(Message message) {
        logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"监听到通知消息");
        if (message instanceof MapMessage) {
            MapMessage mm = (MapMessage) message;
            String actionStr = null;
            try {
                actionStr = mm.getStringProperty("action");
                if(actionStr.equals(ActiveMQConstants.ACTIVEMQ_NOTIFY_ACTION.SMS)){
                    //短信api
                    Enumeration ee=mm.getPropertyNames();
                    Map<String,Object> map=new HashMap<>();
                    while (ee.hasMoreElements()){
                        String element=ee.nextElement().toString();
                        map.put(element,mm.getStringProperty(element));
                    }
                    //调用平台发送短信
                    String sendResult=smsNotifyDomain.sendSms(map);
                    logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"短信消费结果" + sendResult );
                }else if(actionStr.equals(ActiveMQConstants.ACTIVEMQ_NOTIFY_ACTION.MAIL)){
                    //站内信api
                }else if(actionStr.equals(ActiveMQConstants.ACTIVEMQ_NOTIFY_ACTION.EMAIL)){
                    //邮件发送api
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
