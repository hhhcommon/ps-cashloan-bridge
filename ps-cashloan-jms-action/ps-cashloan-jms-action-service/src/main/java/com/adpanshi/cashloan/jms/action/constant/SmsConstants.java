package com.adpanshi.cashloan.jms.action.constant;

/**
 * @author fish_coder
 * @Title: SmsConstants
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/79:55
 */
public class SmsConstants {

    //平台类型
    public interface SMS_PLATFORM {
        public static final String CHUANG_LAN = "chuanglan"; //创蓝
        public static final String TIAN_YI_HONG = "tianyihong"; //天一泓
    }
    //map keys
    public interface SMS_REQUEST_KEYS {
        public static final String SMS_ACCOUNT = "account"; //帐号
        public static final String SMS_PASSWORD = "password"; //密码
        public static final String SMS_MSG = "msg"; //信息
        public static final String SMS_PLATFORM = "smsPlatform"; //平台
        public static final String MOBILE = "mobile"; //联系号码
        public static final String MESSAGE = "message"; //发送信息
        public static final String REPLACE_TITLE = "{$product}"; //要替换的占位符
    }
    //map keys
    public interface SMS_RESPONSE_KEYS {
        public static final String SMS_PLATFORM = "smsPlatform"; //平台
        public static final String SMS_TYPE = "smsType"; //sms类型
        public static final String ORDERNO = "orderNo"; //订单号
        public static final String VCODE = "vcode"; //验证码
        public static final String PHONE = "phone"; //联系号码
        public static final String CONTENT = "content"; //发送信息
        public static final String CODE = "code"; //短信接口返回code
        public static final String MSGID = "msgid"; //短信接口返回msgid
        public static final String ERROR = "error"; //短信接口返回error说明
        public static final String STATUS = "status"; //创蓝短信接口返回status
        public static final String ARRAY = "array"; //天一泓短信接口返回Array


    }

    private String chuanglanUrl;

    private String chuanglanAccount;

    private String chuanglanPassword;

    private String areaCode;

    private String title;

    private String smsQuartzInterval;

    private String tianyihongUrl;

    private String tianyihongAccount;

    private String tianyihongPassword;

    private String businessSmsSaveUrl;

    public String getChuanglanUrl() {
        return chuanglanUrl;
    }

    public void setChuanglanUrl(String chuanglanUrl) {
        this.chuanglanUrl = chuanglanUrl;
    }

    public String getChuanglanAccount() {
        return chuanglanAccount;
    }

    public void setChuanglanAccount(String chuanglanAccount) {
        this.chuanglanAccount = chuanglanAccount;
    }

    public String getChuanglanPassword() {
        return chuanglanPassword;
    }

    public void setChuanglanPassword(String chuanglanPassword) {
        this.chuanglanPassword = chuanglanPassword;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmsQuartzInterval() {
        return smsQuartzInterval;
    }

    public void setSmsQuartzInterval(String smsQuartzInterval) {
        this.smsQuartzInterval = smsQuartzInterval;
    }

    public String getTianyihongUrl() {
        return tianyihongUrl;
    }

    public void setTianyihongUrl(String tianyihongUrl) {
        this.tianyihongUrl = tianyihongUrl;
    }

    public String getTianyihongAccount() {
        return tianyihongAccount;
    }

    public void setTianyihongAccount(String tianyihongAccount) {
        this.tianyihongAccount = tianyihongAccount;
    }

    public String getTianyihongPassword() {
        return tianyihongPassword;
    }

    public void setTianyihongPassword(String tianyihongPassword) {
        this.tianyihongPassword = tianyihongPassword;
    }


    public String getBusinessSmsSaveUrl() {
        return businessSmsSaveUrl;
    }

    public void setBusinessSmsSaveUrl(String businessSmsSaveUrl) {
        this.businessSmsSaveUrl = businessSmsSaveUrl;
    }
}
