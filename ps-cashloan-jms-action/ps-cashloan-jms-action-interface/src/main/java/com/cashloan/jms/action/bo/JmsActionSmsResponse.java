package com.cashloan.jms.action.bo;

/**
 * @author fish_coder
 * @Title: JmsActionSmsResponse
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/611:44
 */
public class JmsActionSmsResponse implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private int ret_code;

    private String ret_msg;


    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }
}