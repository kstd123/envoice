package yonyou.einvoice.backmangesystem.companyManagement.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Company implements Serializable {
	private String corpid;
	private String corpcode;
	private String corpname;
	private String contact;
	private String corpaddress;
	private String corpphone;
	private String corpemail;
	private String businesslicense;
	private String orgcode;
	private String taxid;
	private String createtime;
	private Integer corptype;
	private String datasource;
	private String ts;
	private String btrail;
	private byte[] file;
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	public String getCorpcode() {
		return corpcode;
	}
	public void setCorpcode(String corpcode) {
		this.corpcode = corpcode;
	}
	public String getCorpname() {
		return corpname;
	}
	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCorpaddress() {
		return corpaddress;
	}
	public void setCorpaddress(String corpaddress) {
		this.corpaddress = corpaddress;
	}
	public String getCorpphone() {
		return corpphone;
	}
	public void setCorpphone(String corpphone) {
		this.corpphone = corpphone;
	}
	public String getCorpemail() {
		return corpemail;
	}
	public void setCorpemail(String corpemail) {
		this.corpemail = corpemail;
	}
	public String getBusinesslicense() {
		return businesslicense;
	}
	public void setBusinesslicense(String businesslicense) {
		this.businesslicense = businesslicense;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getTaxid() {
		return taxid;
	}
	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getCorptype() {
		return corptype;
	}
	public void setCorptype(Integer corptype) {
		this.corptype = corptype;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getBtrail() {
		return btrail;
	}
	public void setBtrail(String btrail) {
		this.btrail = btrail;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
}
