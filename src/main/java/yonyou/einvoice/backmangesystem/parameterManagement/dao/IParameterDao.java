package yonyou.einvoice.backmangesystem.parameterManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yonyou.einvoice.backmangesystem.parameterManagement.entity.ParameterEntity;
import yonyou.einvoice.backmangesystem.parameterManagement.util.ConditionUtil;


@Mapper
public interface IParameterDao {
       
      /**
       * 
       * @param page 前端传来的对象
       * @return 查询结果的list集合
       */
  /*
     @Select("select param.*,corp.corpname from report_piaoeda_client.sysparam param join report_einvoice_auth.einvoice_corp  corp on param.corpid=corp.corpid limit #{pageNumStart},#{pageNum}")
     public List<ParameterEntity> selectAll(ConditionUtil util);
     */
     /**
      * 查询总共记录条数
      * @return 
      */
     
     @Select("select count(*) from report_piaoeda_client.sysparam")
     public int selectNum();
     
     /**
      * 条件分页查询
      * @param map 参数列表组成的map集合
      * @return 查询结果的list集合
      */
     //@SelectProvider(method="SelectByCondition",type=SqlGenerator.class)
     public List<ParameterEntity> SelectByCondition(ConditionUtil util);
     
    /**
     * 添加参数
     * @param para 参数实体
     * 
     */
    // public void save(ParameterEntity para);
     
     /**
      * 修改参数
      * @param para 参数实体
      * @return 参数实体
      */
   //  public ParameterEntity update(ParameterEntity para);
     /**
      * 删除参数
      * @param para 参数实体
      */
     //public void delete(ParameterEntity para);
}
