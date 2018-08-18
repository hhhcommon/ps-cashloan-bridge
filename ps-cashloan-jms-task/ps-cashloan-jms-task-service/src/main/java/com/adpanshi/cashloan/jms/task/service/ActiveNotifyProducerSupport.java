package com.adpanshi.cashloan.jms.task.service;

import com.adpanshi.cashloan.jms.task.factory.ActiveMQProducer;

import java.util.Map;

/**
 * @author fish_coder
 * @Title: ActiveSmsProducerSupport
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/616:08
 */
public class ActiveNotifyProducerSupport extends ActiveMQProducer {
    /**
     * 发送短信请求
     * @param<String, Object>
     */
    public boolean sendSmsNotify(final Map<String, Object> scparams){
        return super.sendData(scparams);
    }
}
