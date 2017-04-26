package yonyou.einvoice.backmangesystem.parameterManagement.controller;

import javax.servlet.http.HttpServletResponse;

import yonyou.einvoice.backmangesystem.parameterManagement.entity.ParameterEntity;
import yonyou.einvoice.backmangesystem.parameterManagement.util.ConditionUtil;

public interface IParameterControlller {

    /**
     * 查询所有参数，分页查询
     * @param page 前端传来的对象
     * @return page对象的json串
     */
    //public String SelectAll(ConditionUtil util);
    
  
    
    /**
     * 条件查询，分页查询
     * @param corpname 公司名称
     * @param page  前端传来的对象
     * @return  page对象的json串
     */
    public String SelectByCondition(ConditionUtil util);
    
    /**
     * 修改参数
     * @param util 前端传来的数据
     * @return 是否修改成功的状态码
     */
    
    public String update(ParameterEntity entity);
    
    /**
     * 添加参数
     * @param  util前端传来的数据
     * @return  是否添加成功的状态码
     */
    public String add(ParameterEntity entity);
    /**
     * 删除参数
     * @param util前端传来的数据
     * @return 返回json串
     */
   // public String delete(ParameterEntity entity);
}
