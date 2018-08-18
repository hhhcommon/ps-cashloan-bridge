package com.adpanshi.cashloan.jms.task.service;

import com.adpanshi.cashloan.dispatch.run.domain.DispatchRunDomain;
import com.adpanshi.cashloan.jms.action.utils.DateUtil;
import com.adpanshi.cashloan.jms.task.constant.ActiveMQConstants;
import com.adpanshi.cashloan.jms.task.factory.ActiveMQListener;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.naming.NamingException;
import java.util.Date;

/**
 * @author fish_coder
 * @Title: ActiveDispatchConsumerSupport
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/314:36
 */
public class ActiveDispatchConsumerSupport extends ActiveMQListener {
    private static Logger logger = Logger.getLogger(ActiveNotifyConsumerSupport.class);
    @Resource
    private DispatchRunDomain dispatchRunDomain;

    public ActiveDispatchConsumerSupport() throws NamingException, JMSException {
        super();
    }
    @Override
    public void onMessage(Message message) {
        logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"监听到调度中心消息");
        if (message instanceof MapMessage) {
            MapMessage mm = (MapMessage) message;
            String actionStr = null;
            try {
                actionStr = mm.getStringProperty("action");
                if(actionStr.equals(ActiveMQConstants.ACTIVEMQ_DISPATCH_ACTION.DISPATCH_1)){
                    //调度中心消费
                    logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"调度中心消费,参数taskId:"+mm.getStringProperty("taskId"));
                    dispatchRunDomain.runByTaskId(mm.getIntProperty("taskId"));
                }
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
