package yonyou.einvoice.backmangesystem.messagemanage.util;

/**
 * Created by xinggq on 17-4-24.
 *
 * 重发类型枚举类
 */
public enum ResendTypeEnum {

    URL("restful","01"),WEBSERVICE("webservice","03"),
    EMAIL("email","05"),SMS("SMS","07"),WECHAT("wechat","09");

    private String type;
    private String typeNum;



    ResendTypeEnum(String type, String typeNum){
        this.type = type;
        this.typeNum = typeNum;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(String typeNum) {
        this.typeNum = typeNum;
    }


}
