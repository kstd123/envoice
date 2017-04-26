package yonyou.einvoice.backmangesystem.parameterManagement.util;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 *
 * 输出信息
 */

@Component
public class RespMsg {

    private String code;
    private String msg;
    private Object data;
    
    

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getMsg() {
      return msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

    public Object getData() {
      return data;
    }

    public void setData(Object data) {
      this.data = data;
    }

    /**
     * 返回操作成功
     * @param obj
     */
    public void responseSuccess(Object obj){
        setCode("0000");
        setMsg("操作成功");
        setData(obj);
    }

    public void responseFail(){
        setCode("9999");
        setMsg("操作失败");
    }
}