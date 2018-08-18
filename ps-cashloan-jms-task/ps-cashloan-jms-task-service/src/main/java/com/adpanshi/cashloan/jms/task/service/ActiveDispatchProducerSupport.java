package com.adpanshi.cashloan.jms.task.service;

import com.adpanshi.cashloan.jms.task.factory.ActiveMQProducer;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author fish_coder
 * @Title: ActiveProducerSupport
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/39:39
 */
public class ActiveDispatchProducerSupport extends ActiveMQProducer {


    /**
     * 发送调控请求
     * @param<String, Object>
     */
    public  boolean sendDispatch(final Map<String, Object> scparams){
        return super.sendData(scparams);
    }

}
