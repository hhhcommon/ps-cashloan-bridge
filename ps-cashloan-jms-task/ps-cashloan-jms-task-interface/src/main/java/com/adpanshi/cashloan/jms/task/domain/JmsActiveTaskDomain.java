package com.adpanshi.cashloan.jms.task.domain;

import com.adpanshi.cashloan.jms.task.bo.JmsResponseBo;

import java.util.Map;

/**
 * @author fish_coder
 * @Title: JmsActiveTaskDomain
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/39:52
 */
public interface JmsActiveTaskDomain {
    /**
     * 接收短信通知jms生产接口
     * 参数 Map<String, Object>
     */
    JmsResponseBo addSmsNotify(Map<String, Object> map);

    /**
     * 接收站内通知jms生产接口
     * 参数 Map<String, Object>
     */
    JmsResponseBo addznNotify(Map<String, Object> map);
    /**
     * 接收调度中心任务
     * 参数 Map<String, Object>
     */
    JmsResponseBo addDispathTask(Map<String, Object> map);
}
