package com.adpanshi.cashloan.jms.task.factory;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Map;

/**
 * @author fish_coder
 * @Title: ActiveMQProducer
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/39:37
 */
public abstract class ActiveMQProducer {

    protected JmsTemplate jmsTemplate;

    /**
     * 发送消息
     * @param dataMap
     * @return
     */
    public boolean sendData(final Map<String, Object> dataMap) {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                MapMessage mm = session.createMapMessage();
                for (String key : dataMap.keySet()) {
                    mm.setObjectProperty(key, dataMap.get(key));
                }
                return mm;
            }
        });
        return true;
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
