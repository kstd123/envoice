package yonyou.einvoice.backmangesystem.messagemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;
import yonyou.einvoice.backmangesystem.messagemanage.service.EmailService;

/**
 * Created by xinggq on 17-3-31.
 *
 * email管理
 *
 */
@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    EmailService emailService;

    /**
     * 分页查询(包含条件查询)
     * @param conditionUtil
     * @return
     */
    @RequestMapping("/select/all")
    public String selectList(ConditionUtil conditionUtil){

        return emailService.selectList(conditionUtil);
    }


    /**
     *  重发功能
     *
     * @param fpqqlshs  多个流水号以逗号拼接成字符串
     * @return
     */
    @RequestMapping("/resend")
    public String reSend(String fpqqlshs){

        return emailService.resend(fpqqlshs);
    }


}
