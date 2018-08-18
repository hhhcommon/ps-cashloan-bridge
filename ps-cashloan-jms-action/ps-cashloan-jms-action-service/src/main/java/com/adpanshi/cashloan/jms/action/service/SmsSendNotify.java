package com.adpanshi.cashloan.jms.action.service;

import com.adpanshi.cashloan.jms.action.constant.SmsConstants;
import com.adpanshi.cashloan.jms.action.utils.DateUtil;
import com.adpanshi.cashloan.jms.action.utils.HttpsUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tool.util.HttpUtil;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fish_coder
 * @Title: SmsChuanglanNotify
 * @ProjectName fenqidai-dubbo
 * @Description: TODO 发送短信
 * @date 2018/8/610:55
 */
@Service
public class SmsSendNotify {


    protected static final Logger logger = LoggerFactory.getLogger(SmsSendNotify.class);
    //sms.properties配置
    @Autowired
    private SmsConstants smsConstants;

    public String sendMsg(Map<String, Object> messageMap){

        //选择发送短信渠道
        String smsPlatform= messageMap.get(SmsConstants.SMS_REQUEST_KEYS.SMS_PLATFORM).toString();
        //短信抬头
        String title = smsConstants.getTitle();
        //发送对象
        String numbers = smsConstants.getAreaCode()+messageMap.get(SmsConstants.SMS_REQUEST_KEYS.MOBILE);
        //发送信息
        String message = messageMap.get(SmsConstants.SMS_REQUEST_KEYS.MESSAGE).toString();
        message = message.replace(SmsConstants.SMS_REQUEST_KEYS.REPLACE_TITLE,title);
        //短信api返回结果
        String result= null;
        //business smsSave api 参数
        Map<String, String> requestParams=new HashMap<>();
        requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.PHONE,messageMap.get(SmsConstants.SMS_REQUEST_KEYS.MOBILE).toString());
        requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.ORDERNO,messageMap.get(SmsConstants.SMS_RESPONSE_KEYS.ORDERNO)==null?"":messageMap.get(SmsConstants.SMS_RESPONSE_KEYS.ORDERNO).toString());
        requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.CONTENT,message);
        requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.VCODE,messageMap.get(SmsConstants.SMS_RESPONSE_KEYS.VCODE)==null?"":messageMap.get(SmsConstants.SMS_RESPONSE_KEYS.VCODE).toString());
        requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.SMS_PLATFORM,smsPlatform);
        requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.SMS_TYPE,messageMap.get(SmsConstants.SMS_RESPONSE_KEYS.SMS_TYPE).toString());
        if(SmsConstants.SMS_PLATFORM.CHUANG_LAN.equals(smsPlatform)){
            //创蓝平台
            JSONObject map=new JSONObject();
            map.put(SmsConstants.SMS_REQUEST_KEYS.SMS_ACCOUNT,smsConstants.getChuanglanAccount());
            map.put(SmsConstants.SMS_REQUEST_KEYS.SMS_PASSWORD, smsConstants.getChuanglanPassword());
            map.put(SmsConstants.SMS_REQUEST_KEYS.SMS_MSG, message);
            map.put(SmsConstants.SMS_REQUEST_KEYS.MOBILE, numbers);
            String params=map.toString();
            logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"创蓝平台请求参数为:" + params);
            try {
                result= HttpsUtil.postStrClient(smsConstants.getChuanglanUrl(),params);
//                logger.info("创蓝平台返回参数为:" + result);
                JSONObject jsonObject =  JSON.parseObject(result);
                requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.CODE,jsonObject.get(SmsConstants.SMS_RESPONSE_KEYS.CODE)==null?"":jsonObject.get(SmsConstants.SMS_RESPONSE_KEYS.CODE).toString());
                requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.MSGID,jsonObject.get(SmsConstants.SMS_RESPONSE_KEYS.MSGID)==null?"":jsonObject.get(SmsConstants.SMS_RESPONSE_KEYS.MSGID).toString());
                requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.ERROR,jsonObject.get(SmsConstants.SMS_RESPONSE_KEYS.ERROR)==null?"":jsonObject.get(SmsConstants.SMS_RESPONSE_KEYS.ERROR).toString());
                result = jsonObject.toJSONString();
            } catch (Exception e) {
                // TODO: handle exception
                logger.error("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"创蓝发送短信异常：" + e);
            }
        }else if(SmsConstants.SMS_PLATFORM.TIAN_YI_HONG.equals(smsPlatform)){
            //天一泓平台
            String url = smsConstants.getTianyihongUrl()+"/sendsms?account="+smsConstants.getTianyihongAccount()+"&password="+smsConstants.getTianyihongPassword()+"&numbers="+numbers+"&content="+ URLEncoder.encode(message);
            logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"天一泓请求参数为:" + url);
            try {
                result= HttpsUtil.getClient(url).replaceAll("\\[\\[","\"").replaceAll("]]","\"");
                logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"天一泓平台返回参数为:" + result);
                JSONObject json = JSONObject.parseObject(result);
                if(json.get(SmsConstants.SMS_RESPONSE_KEYS.STATUS)!=null&&json.getInteger(SmsConstants.SMS_RESPONSE_KEYS.STATUS)==0){
                    String array = (String) json.get(SmsConstants.SMS_RESPONSE_KEYS.ARRAY);
                    String msgid =array.split(",")[1];
                    json.put(SmsConstants.SMS_RESPONSE_KEYS.MSGID,msgid);
                }
                requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.CODE,json.get(SmsConstants.SMS_RESPONSE_KEYS.STATUS)==null?"":json.get(SmsConstants.SMS_RESPONSE_KEYS.STATUS).toString());
                requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.MSGID,json.get(SmsConstants.SMS_RESPONSE_KEYS.MSGID)==null?"":json.get(SmsConstants.SMS_RESPONSE_KEYS.MSGID).toString());
                requestParams.put(SmsConstants.SMS_RESPONSE_KEYS.ERROR,json.get(SmsConstants.SMS_RESPONSE_KEYS.ERROR)==null?"":json.get(SmsConstants.SMS_RESPONSE_KEYS.ERROR).toString());
                result = json.toJSONString();
                logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"天一泓发送短信返回:"+result);
            } catch (Exception e) {
                // TODO: handle exception
                logger.error("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"天一泓发送短信异常：" + e);
            }
        }
        String busResult = HttpUtil.postClient(smsConstants.getBusinessSmsSaveUrl(),requestParams);
        logger.info("时间:"+ DateUtil.dateToString(new Date(),DateUtil.DATEFORMAT_STR_001)+"business服务短信发送结果接收:"+busResult);
        return result;
    }
}
