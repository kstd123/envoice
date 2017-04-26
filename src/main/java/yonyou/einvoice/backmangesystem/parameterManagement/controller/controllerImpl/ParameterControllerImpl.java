package yonyou.einvoice.backmangesystem.parameterManagement.controller.controllerImpl;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.print.resources.serviceui;
import yonyou.einvoice.backmangesystem.parameterManagement.controller.IParameterControlller;
import yonyou.einvoice.backmangesystem.parameterManagement.entity.ParameterEntity;
import yonyou.einvoice.backmangesystem.parameterManagement.service.IParameterService;
import yonyou.einvoice.backmangesystem.parameterManagement.util.ConditionUtil;


@RestController
@RequestMapping("/parameter")
public class ParameterControllerImpl implements IParameterControlller{
    
  private static final Logger logger = LoggerFactory.getLogger(ParameterControllerImpl.class);
  @Autowired
  private IParameterService service;
  
 
  /**
   * 查询所有记录
   */
  /*
  @RequestMapping("/selectAll")
  public String SelectAll(ConditionUtil util) {
    return service.SelectAll(util);
  }
 */

  
  /**
   * 条件查询
   */
  
  @RequestMapping("/selectByCondition")
  public String SelectByCondition(ConditionUtil util) {
    return service.SelectByCondition(util);
  }

  @RequestMapping("/update")
  public String update(ParameterEntity entity) {
    return service.updateParameter(entity);
  }

  @RequestMapping("/add")
  public String add(ParameterEntity entity) {
    return service.addParameter(entity);
  }
  /*
  @RequestMapping("/delete")
  public String delete(ParameterEntity entity) {
    return service.delete(entity);
  }
*/

  
}
