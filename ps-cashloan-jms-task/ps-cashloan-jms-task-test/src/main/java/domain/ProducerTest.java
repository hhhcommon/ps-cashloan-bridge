package domain;



import com.adpanshi.cashloan.jms.task.bo.JmsResponseBo;
import com.adpanshi.cashloan.jms.task.domain.JmsActiveTaskDomain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fish_coder
 * @Title: ProducerTest
 * @ProjectName fenqidai-dubbo
 * @Description: TODO
 * @date 2018/8/210:37
 */
public class ProducerTest {

    /**
     * 发调度任务
     */
    private JmsActiveTaskDomain remote = RemoteFactory.getRemote(JmsActiveTaskDomain.class, "1.0.0");
//    @org.testng.annotations.Test
    public  void  test(){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("returnApiID","5");
        JmsResponseBo jmsResponseBo=remote.addDispathTask(map);
        System.out.println(jmsResponseBo.getRet_code());
        System.out.println(jmsResponseBo.getRet_msg());
    }

    /**
     * 发短信任务
     */
    @org.testng.annotations.Test
    public  void  test2(){
//        for(int i=0;i<15;i++){
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("title","注册通知!");
            map.put("message","[Oloan]Your loan has been overdue by 3 days.Please make the repayment as soon as possible so as not to damage your personal interests.");
            map.put("mobile","8618268834862");
            map.put("vcode","6446");
            map.put("orderNo",null);
            map.put("type","findReg");
            JmsResponseBo jmsResponseBo=remote.addSmsNotify(map);
            System.out.println(jmsResponseBo.getRet_code());
            System.out.println(jmsResponseBo.getRet_msg());
        }
//    }
}
