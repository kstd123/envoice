package yonyou.einvoice.backmangesystem.companyManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yonyou.einvoice.backmangesystem.companyManagement.dao.ICompanyDAO;
import yonyou.einvoice.backmangesystem.companyManagement.service.AbstractServiceBack;
import yonyou.einvoice.backmangesystem.companyManagement.vo.Company;
import yonyou.einvoice.backmangesystem.companyManagement.service.ICompanyBackService;

@Service
public class CompanyBackServiceImpl extends AbstractServiceBack implements ICompanyBackService {

	@Resource
	private ICompanyDAO companyDAO;
	
	public boolean insert(Company vo) {
		// TODO Auto-generated method stub
		Company company = this.companyDAO.findBycorpname(vo.getCorpname());
		if(company.getCorpname()!=null){
			return this.companyDAO.doCreate(vo);
		}
		return false;
	}

	public Company findBycorpname(String corpname) {
		// TODO Auto-generated method stub
		return this.companyDAO.findBycorpname(corpname);
	}

	public Map<String, Object> list(String column, String keyWord, Integer currentPage, Integer lineSize) {
		// TODO Auto-generated method stub
		Map<String,Object> param = super.handleParams(column, keyWord, currentPage, lineSize);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("allCompanys", this.companyDAO.findAllSplit(param));
		result.put("companyCount", this.companyDAO.getAllCount(param));
		return result;
	}

	public List<String> findAllByOpenPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> findAllNotOpenPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> findAllUploadData() {
		// TODO Auto-generated method stub
		return null;
	}

	public Company get(String corpid) {
		// TODO Auto-generated method stub
		return this.companyDAO.findById(corpid);
	}

	public boolean upload(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return this.companyDAO.uploadFile(param);
	}

	public boolean updateByCorpid(Company vo) {
		// TODO Auto-generated method stub
		return this.companyDAO.doUpdateByCorpid(vo);
	}

	public Map<String, Object> listNoOpen(String column, String keyWord, Integer currentPage, Integer lineSize) {
		// TODO Auto-generated method stub
		Map<String,Object> param = super.handleParams(column, keyWord, currentPage, lineSize);
		Map<String,Object> result = new HashMap<String,Object>();
		//param.put("btrail", "Y");
		result.put("allCompanys", this.companyDAO.findAllSplitNoOpen(param));
		result.put("companyCount", this.companyDAO.getAllCountNoOpen(param));
		return result;
	}

	public boolean UpdateBatch(List<String> ids) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", ids);
		map.put("btrail", "N");
		return this.companyDAO.doUpdateBatch(map);
	}

}
