package yonyou.einvoice.backmangesystem.messagemanage.entity;

import org.springframework.stereotype.Component;

/**
 * Created by xinggq on 17-3-31.
 *
 * 邮箱实体类
 */
@Component
public class EmailEntity {

    private String id;
    private String fpqqlsh;//发票请求流水号，和开票请求对应，必填
    private String address;//接受地址，多个地址使用，分隔，必填
    private String result;//结果
    private String title;//
    private String content;//


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

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
