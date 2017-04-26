package yonyou.einvoice.backmangesystem.parameterManagement.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import net.sf.json.JSONObject;
import yonyou.einvoice.backmangesystem.SimpleClientHttpFactoryConfig;
import yonyou.einvoice.backmangesystem.parameterManagement.dao.IParameterDao;
import yonyou.einvoice.backmangesystem.parameterManagement.entity.ParameterEntity;
import yonyou.einvoice.backmangesystem.parameterManagement.service.IParameterService;
import yonyou.einvoice.backmangesystem.parameterManagement.util.ConditionUtil;
import yonyou.einvoice.backmangesystem.parameterManagement.util.HttpUtil;
import yonyou.einvoice.backmangesystem.parameterManagement.util.RespMsg;
import yonyou.einvoice.backmangesystem.util.ResponseTypeEnum;

@Service
public class ParameterServiceImpl implements IParameterService{
  
  private static final Logger logger = LoggerFactory.getLogger(ParameterServiceImpl.class);
  @Autowired
  private IParameterDao dao;
  @Autowired
  private RespMsg response;
  @Autowired
  private SimpleClientHttpFactoryConfig config;
  
  @Value("${rest.template.address}")        //ip地址
  private String restAddress;

  @Value("${rest.template.port}")          //端口号
  private String restPort;
  
  /*
   * 参数的多条查询
   * 
   */
  /*
  public String SelectAll(ConditionUtil util) {    
  try{
     int total = dao.selectNum();                                   //查询所有记录条数
     List<ParameterEntity> list = dao.SelectByCondition(util);
     HashMap<String, Object> map = new HashMap<String, Object>();
     map.put("list", list);
     map.put("rows", total);
     response.responseSuccess(map);                                 //把map更换成一个格式
     return JSONObject.fromObject(response).toString();
     }catch(Exception e){
       logger.error(e.getMessage(),e);
       //操作失败
       response.responseFail();
       return JSONObject.fromObject(response).toString();
     }
  }
 */

  /*
   * 查询记录的条数
   * 
   */
  
  public int selectNum() {
    return dao.selectNum();
  }


   /*
    * 条件查询
    * 
    */
  public String SelectByCondition(ConditionUtil util) {
    try{
    List<ParameterEntity> list = dao.SelectByCondition(util);
    int total = dao.selectNum();                                                            //把总记录条数存入对象中
    HashMap<String,Object> map = new HashMap<String, Object>();
    map.put("list", list);
    map.put("rows", total);
    response.setCode(ResponseTypeEnum.SUCCESS.getStatusNum());
    response.setMsg(ResponseTypeEnum.SUCCESS.getStatus());
    response.setData(map);
    //response.responseSuccess(map);
    return JSONObject.fromObject(response).toString();
    }catch(Exception e){
      logger.error(e.getMessage(),e);                       //操作失败
      response.setCode(ResponseTypeEnum.UNKNOWN_ERROR.getStatusNum());
      response.setMsg(ResponseTypeEnum.UNKNOWN_ERROR.getStatus());
      //response.responseFail();
      return JSONObject.fromObject(response).toString();
    }
  }

  /*
   *添加参数 
   */

  public String addParameter(ParameterEntity entity) {
    try{
      /*
      HashMap map = new HashMap();
      map.put("code", "1");
      map.put("name", "1");
      map.put("corpid", "1");
      map.put("layer", "1");
      map.put("value", "1");
      */
      
      JSONObject jsonobject = JSONObject.fromObject(entity);
      String result = HttpUtil.post("http://192.168.52.101:80/invoiceclient-web/privateApi/operation/sysparam/add", jsonobject.toString());
//      RestTemplate restTemplate = config.customRestTemplate();    //新建发送请求的对象
//      HttpHeaders headers = new HttpHeaders();                    //新建请求头对象
//      String signName = JwtInnerUtils.sign(null);
//      MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//       headers.setContentType(MediaType.APPLICATION_JSON);                               //设置请求头
//      headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//      headers.add("sign", signName);
//      JSONObject jsonObj = JSONObject.fromObject(entity);
//     System.out.println(jsonObj);
//      System.out.println(jsonObj.toString());
//      HttpEntity<ParameterEntity> formEntity = new HttpEntity<>(entity, headers);          //新建请求体对象
//      Map result = restTemplate.postForObject("http://192.168.52.101:80/invoiceclient-web"
//          + "/privateApi/operation/sysparam/add", formEntity, Map.class);
      //发送请求
      response.setCode(ResponseTypeEnum.SUCCESS.getStatusNum());   //设置成功时状态码
      response.setMsg(ResponseTypeEnum.SUCCESS.getStatus());
      response.setData(result);
      //response.responseSuccess(result);
      return JSONObject.fromObject(response).toString();
      }catch(Exception e){
        logger.error(e.getMessage(),e);
        //response.responseFail();
        response.setCode(ResponseTypeEnum.UNKNOWN_ERROR.getStatusNum());    //设置失败时状态码
        response.setMsg(ResponseTypeEnum.UNKNOWN_ERROR.getStatus());
        return JSONObject.fromObject(response).toString();
      }

  }

  /*
   * 修改参数
   * 
   */
  public String updateParameter(ParameterEntity entity) {
    try{
      JSONObject jsonobject = JSONObject.fromObject(entity);
      String result = HttpUtil.post("http://192.168.52.101:80/invoiceclient-web/privateApi/operation/sysparam/update", jsonobject.toString());
      /*
      RestTemplate restTemplate = config.customRestTemplate();      //新建发送请求对象
      HttpHeaders headers = new HttpHeaders();                      //新建请求头对象
      String signName = JwtInnerUtils.sign(null);
//      MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//      headers.setContentType(type);                                 //设置请求头
//      headers.add("Accept", MediaType.APPLICATION_JSON.toString());
      headers.add("sign", signName);
      JSONObject jsonObj = JSONObject.fromObject(entity);
      HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);      //新建请求体对象
      String result = restTemplate.postForObject("http://"+restAddress+":"+restPort+"/inoviceclient-web/privateApi/operation/sysparam/update", formEntity, String.class);
        //发送请求
     */
      response.setCode(ResponseTypeEnum.SUCCESS.getStatusNum());        //设置成功时的状态码
      response.setMsg(ResponseTypeEnum.SUCCESS.getStatus());
      response.setData(result);
      //response.responseSuccess(result);
      return JSONObject.fromObject(response).toString();
      }catch(Exception e){
        logger.error(e.getMessage(),e);
        response.setCode(ResponseTypeEnum.UNKNOWN_ERROR.getStatusNum());       //设置失败时状态码
        response.setMsg(ResponseTypeEnum.UNKNOWN_ERROR.getStatus());
        //response.responseFail();
        return JSONObject.fromObject(response).toString();
      }
  }

  /**
   * 删除参数
   */
  /*
  public String delete(ParameterEntity entity) {
    try{
      dao.delete(entity);
      response.responseSuccess("delete success");
      return JSONObject.fromObject(response).toString();
      }catch(Exception e){
        logger.error(e.getMessage(),e);
        response.responseFail();
        return JSONObject.fromObject(response).toString();
      }
  }
  */  
     
}
