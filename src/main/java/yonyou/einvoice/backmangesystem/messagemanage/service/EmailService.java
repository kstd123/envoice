package yonyou.einvoice.backmangesystem.messagemanage.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import yonyou.einvoice.backmangesystem.messagemanage.dao.EmailDao;
import yonyou.einvoice.backmangesystem.messagemanage.entity.EmailEntity;
import yonyou.einvoice.backmangesystem.messagemanage.util.ConditionUtil;
import yonyou.einvoice.backmangesystem.messagemanage.util.ResendTypeEnum;
import yonyou.einvoice.backmangesystem.util.Response;
import yonyou.einvoice.backmangesystem.util.ResponseTypeEnum;

import java.util.List;

/**
 * Created by xinggq on 17-3-31.
 */
@Service
public class EmailService {

    @Autowired
    EmailDao emailDao;
    @Autowired
    Response response;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 分页查询(包含条件查询)
     * @param conditionUtil
     * @return
     */
    public String selectList(ConditionUtil conditionUtil){

        try {
            List<EmailEntity> emailList  = emailDao.selectList(conditionUtil);
            int rowAll = emailDao.selectNum(conditionUtil);
            JSONObject object = new JSONObject();
            object.put("list",emailList);
            object.put("rowAll",rowAll);
            //操作成功
            response.setCode(ResponseTypeEnum.SUCCESS.getStatusNum());
            response.setMsg(ResponseTypeEnum.SUCCESS.getStatus());
            response.setDate(object);
            //返回json
            return JSONObject.fromObject(response).toString();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            //操作失败
            response.setCode(ResponseTypeEnum.UNKNOWN_ERROR.getStatusNum());
            response.setMsg(ResponseTypeEnum.UNKNOWN_ERROR.getStatus());
            return JSONObject.fromObject(response).toString();
        }
    }



    @Autowired
    RestTemplate restTemplate;

    @Value("${rest.template.address}")
    private String restAddress;

    @Value("${rest.template.port}")
    private String restPort;

    /**
     * 批量重发
     * @param fpqqlshs 多个id以逗号拼接为字符串
     * @return
     */
    public String resend(String fpqqlshs){

        if(fpqqlshs==null){
            return  null;
        }

        String[] fpqqlshArray = fpqqlshs.split(",");
        JSONArray jsonArray =JSONArray.fromObject(fpqqlshArray);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fpqqlsh",jsonArray);
        jsonObject.put("type",ResendTypeEnum.EMAIL.getTypeNum());
        System.out.println(jsonObject.toString());

        //调用平台接口
        //restTemplate.postForLocation(restAddress+":"+restPort+"/inoviceclient‐web/privateApi/operation/invoiceApply/callback",);

        return null;
    }

}
