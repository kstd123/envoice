package yonyou.einvoice.backmangesystem.companyManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yonyou.einvoice.backmangesystem.companyManagement.dao.IAppregisterDAO;
import yonyou.einvoice.backmangesystem.companyManagement.service.AbstractServiceBack;
import yonyou.einvoice.backmangesystem.companyManagement.service.IAppregisterBackService;
import yonyou.einvoice.backmangesystem.companyManagement.vo.Appregister;
@Service
public class AppregisterBackServiceImpl extends AbstractServiceBack implements IAppregisterBackService {

	@Resource
	private IAppregisterDAO appregisterDAO;
	
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) {
		// TODO Auto-generated method stub
		Map<String,Object> params = super.handleParams(column, keyWord, currentPage, lineSize);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("allAppregisters", this.appregisterDAO.findAllSplit(params));
		result.put("appregisterCount", this.appregisterDAO.getAllCount(params));
		return result;
	}

	public List<Appregister> findPublickeyById(String corpid) {
		// TODO Auto-generated method stub
		return this.appregisterDAO.findPublickeyById(corpid);
	}

	public boolean UpdatePublicKeyBycorpid(Appregister vo) {
		// TODO Auto-generated method stub
		return this.appregisterDAO.doUpdatePublicKeyBycorpid(vo);
	}

	public Appregister get(Integer id) {
		// TODO Auto-generated method stub
		return this.appregisterDAO.findById(id);
	}

}
