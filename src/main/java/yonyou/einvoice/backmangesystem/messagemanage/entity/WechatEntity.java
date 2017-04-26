package yonyou.einvoice.backmangesystem.messagemanage.entity;

import org.springframework.stereotype.Component;

/**
 * Created by xinggq on 17-3-31.
 *
 * 微信实体类
 */
@Component
public class WechatEntity {

    private String id;
    private String fpqqlsh;//发票请求流水号，必填
    private String wxorderid;//微信订单号
    private String wxappid;//微信
    private String wxopenid;//小程序推送用户id
    private String wxformid;//小程序表单id
    private String result;//结果

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFpqqlsh() {
        return fpqqlsh;
    }

    public void setFpqqlsh(String fpqqlsh) {
        this.fpqqlsh = fpqqlsh;
    }

    public String getWxorderid() {
        return wxorderid;
    }

    public void setWxorderid(String wxorderid) {
        this.wxorderid = wxorderid;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    public String getWxformid() {
        return wxformid;
    }

    public void setWxformid(String wxformid) {
        this.wxformid = wxformid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
