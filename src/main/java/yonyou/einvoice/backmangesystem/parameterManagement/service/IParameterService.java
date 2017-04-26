package yonyou.einvoice.backmangesystem.parameterManagement.service;

import javax.servlet.http.HttpServletResponse;

import yonyou.einvoice.backmangesystem.parameterManagement.entity.ParameterEntity;
import yonyou.einvoice.backmangesystem.parameterManagement.util.ConditionUtil;

public interface IParameterService {
      /**
       * 分页查询所有记录
       * @param page前端传来的参数
       * @return page对象的json串
       */
     // public String SelectAll(ConditionUtil util);
      
      /**
       * 查询所有记录总数
       * @return
       */
      public int selectNum();
      
      
      /**
       * 添加参数
       * @param     util前端传来的数据
       * @return    添加参数是否成功的状态码
       */
      public String addParameter(ParameterEntity entity);
      
      /**
       * 修改参数
       * @param  util前端传来的数据
       * @return 修改是否成功的状态码
       */
      public String updateParameter(ParameterEntity entity);
      
      /**
       * 
       * 条件查询
       * @param util前端传来的对象
       * @return 对象的json串
       */
      public String SelectByCondition(ConditionUtil util);
      /**
       * 删除参数
       * @param util前端传来的对象
       * @return 对象的json串
       */
     // public String delete(ParameterEntity entity);
}
