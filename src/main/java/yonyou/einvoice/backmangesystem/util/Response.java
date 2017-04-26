package yonyou.einvoice.backmangesystem.util;

import org.springframework.stereotype.Component;

/**
 * Created by xinggq on 17-4-10.
 *
 * 输出信息
 */

@Component
public class Response {

    private String code;
    private String msg;
    private Object date;

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

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

}
