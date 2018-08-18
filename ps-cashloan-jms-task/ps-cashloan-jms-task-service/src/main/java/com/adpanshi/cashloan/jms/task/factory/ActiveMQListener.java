package com.adpanshi.cashloan.jms.task.factory;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.naming.NamingException;

/**
 * @Title: JmsListener
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @author fish_coder
 * @date 2018/8/311:12
 */
public abstract class ActiveMQListener implements MessageListener {
//    protected final static JsonMapper jsonMapper = JsonMapper.builder();

    public ActiveMQListener() throws NamingException, JMSException {

    }
}
