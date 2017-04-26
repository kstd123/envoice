package yonyou.einvoice.backmangesystem.util;

/**
 * Created by xinggq on 17-4-24.
 *
 * 平台返回信息枚举类
 */
public enum ResponseTypeEnum {

    SUCCESS("0000","操作成功"),NVALID_PARAMETERS("1001","数据不合法,传入参数"),
    PARAMETERS_NOT_EXIT("1002","数据不存在"),INVOICE_HAS_BEEN_REIMBURSED("3001","发票已经报销"),
    INVOICE_PARSE_ERROR("3002","发票解析出错"),INVOICE_VERIFICATION_IS_ILLEGAL("3003","发票查验不合法"),
    INCORRECT_INVOICE_STATUS("3004","发票状态不正确"),UNKNOWN_ERROR("9999","未知错误");


    private String status;
    private String statusNum;

    ResponseTypeEnum(String status,String statusNum){
        this.status = status;
        this.statusNum = statusNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(String statusNum) {
        this.statusNum = statusNum;
    }
}
