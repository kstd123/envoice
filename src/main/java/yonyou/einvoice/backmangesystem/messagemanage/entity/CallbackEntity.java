package yonyou.einvoice.backmangesystem.messagemanage.entity;

import org.springframework.stereotype.Component;

/**
 * Created by xinggq on 17-3-31.
 *
 * 回调实体类，因为url回调和webservice回调包含一样的字段，
 * 所以暂时先用同一个实体类
 * 
 */
@Component
public class CallbackEntity {

    private String id;
    private String fpqqlsh;//发票请求流水号，必填
    private String url;//回调url，必填
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
