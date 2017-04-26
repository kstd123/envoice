package yonyou.einvoice.backmangesystem.companyManagement.vo;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Appregister implements Serializable {
	private Integer id;
	private String appid;
	private String corpid;
	private byte[] publickey;
	private String signkey;
	private Integer signtype;
	private String invaliddate;
	private Integer maxnum;
	private String verifyclass;
	private Date createtime;
	private Date ts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	public byte[] getPublickey() {
		return publickey;
	}
	public void setPublickey(byte[] publickey) {
		this.publickey = publickey;
	}
	public String getSignkey() {
		return signkey;
	}
	public void setSignkey(String signkey) {
		this.signkey = signkey;
	}
	public Integer getSigntype() {
		return signtype;
	}
	public void setSigntype(Integer signtype) {
		this.signtype = signtype;
	}
	public String getInvaliddate() {
		return invaliddate;
	}
	public void setInvaliddate(String invaliddate) {
		this.invaliddate = invaliddate;
	}
	public Integer getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}
	public String getVerifyclass() {
		return verifyclass;
	}
	public void setVerifyclass(String verifyclass) {
		this.verifyclass = verifyclass;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	
}
