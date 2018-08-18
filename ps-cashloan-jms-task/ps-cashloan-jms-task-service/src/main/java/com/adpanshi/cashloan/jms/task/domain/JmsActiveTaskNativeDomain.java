package com.adpanshi.cashloan.jms.task.domain;


import com.adpanshi.cashloan.jms.task.bo.JmsResponseBo;
import com.adpanshi.cashloan.jms.task.constant.ActiveMQConstants;
import com.adpanshi.cashloan.jms.task.service.ActiveDispatchProducerSupport;
import com.adpanshi.cashloan.jms.task.service.ActiveNotifyProducerSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author fish_coder
 * @Title: JmsActiveTaskNativeDomain
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/39:51
 */
@Service("jmsActiveTaskDomain")
public class JmsActiveTaskNativeDomain implements JmsActiveTaskDomain{
    @Resource
    private ActiveNotifyProducerSupport activeNotifyProducerSupport;
    @Resource
    private ActiveDispatchProducerSupport activeDispatchProducerSupport;

    @Override
    public JmsResponseBo addSmsNotify(Map<String, Object> map) {
        JmsResponseBo jmsResponseBo=new JmsResponseBo();
        map.put("action", ActiveMQConstants.ACTIVEMQ_NOTIFY_ACTION.SMS);
        boolean result = activeNotifyProducerSupport.sendSmsNotify(map);
        if(result){
            jmsResponseBo.setRet_code(100);
            jmsResponseBo.setRet_msg("接收成功");
        }else{
            jmsResponseBo.setRet_code(500);
            jmsResponseBo.setRet_msg("接收失败");
        }
        return jmsResponseBo;
    }

    @Override
    public JmsResponseBo addznNotify(Map<String, Object> map) {
        return null;
    }

    @Override
    public JmsResponseBo addDispathTask(Map<String, Object> map) {
        JmsResponseBo jmsResponseBo=new JmsResponseBo();
        map.put("action", ActiveMQConstants.ACTIVEMQ_DISPATCH_ACTION.DISPATCH_1);
        boolean result = activeDispatchProducerSupport.sendDispatch(map);
        if(result){
            jmsResponseBo.setRet_code(100);
            jmsResponseBo.setRet_msg("接收成功");
        }else{
            jmsResponseBo.setRet_code(500);
            jmsResponseBo.setRet_msg("接收失败");
        }
        return jmsResponseBo;
    }
}
