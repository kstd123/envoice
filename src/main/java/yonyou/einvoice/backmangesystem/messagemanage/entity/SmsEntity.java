package yonyou.einvoice.backmangesystem.messagemanage.entity;

import org.springframework.stereotype.Component;

/**
 * Created by xinggq on 17-3-31.
 * 短信实体类
 */
@Component
public class SmsEntity {

    private String id;
    private String fpqqlsh;//发表请求流水号，必填
    private String address;//接受地址，必填
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
