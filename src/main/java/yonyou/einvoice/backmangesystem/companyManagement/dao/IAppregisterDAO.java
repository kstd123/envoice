package yonyou.einvoice.backmangesystem.companyManagement.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import yonyou.einvoice.backmangesystem.companyManagement.vo.Appregister;
@Mapper
public interface IAppregisterDAO {

	public List<Appregister> findAllSplit(Map<String,Object> params);
	
	public Integer getAllCount(Map<String,Object> params);
	
	public List<Appregister> findPublickeyById(String corpid);
	
	public boolean doUpdatePublicKeyBycorpid(Appregister vo);
	
	public Appregister findById(Integer id);
}
