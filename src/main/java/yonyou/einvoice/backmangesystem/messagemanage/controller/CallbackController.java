package yonyou.einvoice.backmangesystem.messagemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yonyou.einvoice.backmangesystem.messagemanage.service.UrlService;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;
import yonyou.einvoice.backmangesystem.messagemanage.service.WebserviceService;

/**
 * Created by xinggq on 17-4-1.
 *
 * url和webservice回调管理
 */
@RestController
@RequestMapping("/callback")
public class CallbackController {

    @Autowired
    UrlService urlService;

    @Autowired
    WebserviceService webservice;


    /**
     *  分页查询（包含条件查询）
     * @param type
     * @param conditionUtil
     * @return
     */
    @RequestMapping("/select/all/{type}")
    public String selectAll(@PathVariable("type") String type, ConditionUtil conditionUtil){
        if("url".equals(type)){
            return urlService.selectList(conditionUtil);
        }else if("webservice".equals(type)){
            return webservice.selectList(conditionUtil);
        }else{
            return null;
        }
    }

    /**
     * 重发功能
     * @param type  回调类型，url还是webservice
     * @param fpqqlshs  多个流水号以逗号拼接成字符串
     * @return
     */
    @RequestMapping("/resend/{type}")
    public String reSend(@PathVariable("type") String type, String fpqqlshs){

        if("url".equals(type)){
            return urlService.resend(fpqqlshs);
        }else if("webservice".equals(type)){
            return webservice.resend(fpqqlshs);
        }else{
            return null;
        }
    }
}
