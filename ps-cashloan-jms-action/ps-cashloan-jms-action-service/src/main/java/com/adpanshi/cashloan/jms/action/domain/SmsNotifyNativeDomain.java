package com.adpanshi.cashloan.jms.action.domain;

import com.adpanshi.cashloan.jms.action.service.SmsSendNotify;
import com.cashloan.jms.action.domain.SmsNotifyDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author fish_coder
 * @Title: SmsNotifyNativeDomain
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/611:10
 */
@Service("smsNotifyDomain")
public class SmsNotifyNativeDomain implements SmsNotifyDomain{
    @Resource
    private SmsSendNotify smsSendNotify;

    @Override
    public String sendSms(Map<String, Object> messageMap){
        return smsSendNotify.sendMsg(messageMap);
    }

}
