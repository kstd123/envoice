package yonyou.einvoice.backmangesystem.parameterManagement.entity;

public class ParameterEntity {
    /*
     * 参数实体类
     * 
     */
    


    private int id;                //参数ID
    
    private String code;           //参数码
    
    private String name;           //参数名字
    
    private String corpid;         //公司ID
    
    private String corpname;        //公司名称

    private int orgid;             //组织id
    
    private char layer;            //层次
    
    private String value;          //数值
    
    private String valueclass;     //
    


    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getCorpid() {
      return corpid;
    }

    public void setCorpid(String corpid) {
      this.corpid = corpid;
    }

    public int getOrgid() {
      return orgid;
    }

    public void setOrgid(int orgid) {
      this.orgid = orgid;
    }

    public char getLayer() {
      return layer;
    }

    public void setLayer(char layer) {
      this.layer = layer;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public String getValueclass() {
      return valueclass;
    }

    public void setValueclass(String valueclass) {
      this.valueclass = valueclass;
    }


    public ParameterEntity() {
      super();
      // TODO Auto-generated constructor stub
    }
    
    public String getCorpname() {
      return corpname;
    }

    public void setCorpname(String corpname) {
      this.corpname = corpname;
    }

    @Override
    public String toString() {
      return "ParameterEntity [id=" + id + ", code=" + code + ", name=" + name + ", corpid=" + corpid
          + ", corpname=" + corpname + ", orgid=" + orgid + ", layer=" + layer + ", value=" + value
          + ", valueclass=" + valueclass + "]";
    }

}
