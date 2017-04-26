package yonyou.einvoice.backmangesystem.parameterManagement.generator;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SqlGenerator {
  
  private static final Logger logger = LoggerFactory.getLogger(SqlGenerator.class);
    /**
     * 条件查询的动态sql生成方法
     * @param map 参数列表组成的map集合
     * @return sql语句
     */
  public String SelectByCondition(HashMap<String,Object> map){
      StringBuilder sb= new StringBuilder("select param.*,corp.corpname from report_piaoeda_client.sysparam param,report_einvoice_auth.einvoice_corp corp where param.corpid=corp.corpid");
      if(map.get("corpname")!=null && map.get("corpname")!=""){
        sb.append(" and corpname=#{corpname} limit #{pageNumStart},#{pageNum}");
      }else{
        sb.append(" limit #{pageNumStart},#{pageNum}");
      }
    return sb.toString();
  }
}
