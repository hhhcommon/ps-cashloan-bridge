package com.cashloan.jms.action.domain;

import java.util.Map;

/**
 * @author fish_coder
 * @Title: SmsNotifyDomain
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/611:46
 */
public interface SmsNotifyDomain {
    /**
     * 发送短信
     * @param messageMap
     * @return
     */
    String sendSms(Map<String, Object> messageMap);
}
