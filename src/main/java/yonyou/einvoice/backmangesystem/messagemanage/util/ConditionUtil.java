package yonyou.einvoice.backmangesystem.messagemanage.util;

import org.springframework.stereotype.Component;
import yonyou.einvoice.backmangesystem.util.PageUtil;

/**
 * Created by xinggq on 17-3-31.
 *
 *  查询的条件类
 *  包含email，短信，url，webservice和微信的所有条件查询的字段
 */
@Component
public class ConditionUtil extends PageUtil {

    private String conditionFpqqlsh;//查询流水号
    private String conditionAddress;//查询地址
    private String conditionResult;//查询结果 页面返回0代表数据库中记录不为null

    //webservice和url回调中的字段
    private String conditionUrl;//url

    //微信中的字段，
    private String conditionWxorderid;//微信订单号
    private String conditionWxappid;//微信
    private String conditionWxopenid;//小程序推送用户id
    private String conditionWxformid;//小程序表单id


    public String getConditionWxorderid() {
        return conditionWxorderid;
    }

    public void setConditionWxorderid(String conditionWxorderid) {
        this.conditionWxorderid = conditionWxorderid;
    }

    public String getConditionWxappid() {
        return conditionWxappid;
    }

    public void setConditionWxappid(String conditionWxappid) {
        this.conditionWxappid = conditionWxappid;
    }

    public String getConditionWxopenid() {
        return conditionWxopenid;
    }

    public void setConditionWxopenid(String conditionWxopenid) {
        this.conditionWxopenid = conditionWxopenid;
    }

    public String getConditionWxformid() {
        return conditionWxformid;
    }

    public void setConditionWxformid(String conditionWxformid) {
        this.conditionWxformid = conditionWxformid;
    }

    public String getConditionFpqqlsh() {
        return conditionFpqqlsh;
    }

    public void setConditionFpqqlsh(String conditionFpqqlsh) {
        this.conditionFpqqlsh = conditionFpqqlsh;
    }

    public String getConditionAddress() {
        return conditionAddress;
    }

    public void setConditionAddress(String conditionAddress) {
        this.conditionAddress = conditionAddress;
    }

    public String getConditionResult() {
        return conditionResult;
    }

    public void setConditionResult(String conditionResult) {
        this.conditionResult = conditionResult;
    }

    public String getConditionUrl() {
        return conditionUrl;
    }

    public void setConditionUrl(String conditionUrl) {
        this.conditionUrl = conditionUrl;
    }
}