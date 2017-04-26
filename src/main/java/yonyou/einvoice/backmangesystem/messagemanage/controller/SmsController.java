package yonyou.einvoice.backmangesystem.messagemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yonyou.einvoice.backmangesystem.messagemanage.service.SmsService;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;

/**
 * Created by xinggq on 17-4-1.
 *
 * 短信管理
 */

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    SmsService smsService;

    /**
     * 分页查询（包含条件查询）
     * @param conditionUtil
     * @return
     */
    @RequestMapping("/select/all")
    public String selectList(ConditionUtil conditionUtil){
        return smsService.selectList(conditionUtil);
    }

    /**
     *  重发功能
     *
     * @param fpqqlshs 多个流水号以逗号拼接成字符串
     * @return
     */
    @RequestMapping("/resend")
    public String reSend(String fpqqlshs){

        return smsService.resend(fpqqlshs);
    }
}
