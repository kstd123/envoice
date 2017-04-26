package yonyou.einvoice.backmangesystem.companyManagement.service;

import java.util.List;
import java.util.Map;

import yonyou.einvoice.backmangesystem.companyManagement.vo.Appregister;

public interface IAppregisterBackService {

	public Map<String,Object> list(String column,String keyWord,int currentPage,int lineSize);
	
	
	public  List<Appregister> findPublickeyById(String corpid);
	
	public boolean UpdatePublicKeyBycorpid(Appregister vo);
	
	public Appregister get (Integer id);
}
