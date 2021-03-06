package yonyou.einvoice.backmangesystem.messagemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yonyou.einvoice.backmangesystem.messagemanage.service.WechatService;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;

/**
 * Created by xinggq on 17-4-5.
 *
 * 微信管理
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    WechatService wechatService;

    /**
     * 分页查询微信记录（包含条件查询）
     * @param conditionUtil
     * @return
     */
    @RequestMapping("/select/all")
    public String selectAll(ConditionUtil conditionUtil){
        return wechatService.selecList(conditionUtil);
    }

    /**
     *  重发功能
     *
     * @param fpqqlshs 多个流水号以逗号拼接成字符串
     * @return
     */
    @RequestMapping("/resend")
    public String reSend(String fpqqlshs){

        return wechatService.resend(fpqqlshs);
    }
}
