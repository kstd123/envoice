package yonyou.einvoice.backmangesystem.companyManagement.service;

import java.util.List;
import java.util.Map;

import yonyou.einvoice.backmangesystem.companyManagement.vo.Company;

public interface ICompanyBackService {

	/**
	 * 开通之前是否已定存在公司名称
	 * @param corpname
	 * @return
	 */
	public Company findBycorpname(String corpname);
	
	/**
	 * 开通公司
	 * @param vo
	 * @return
	 */
	public boolean insert(Company vo);
	
	/**
	 * 进行模糊分页查询
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public Map<String,Object> list(String column,String keyWord,Integer currentPage,Integer lineSize);
	
	/**
	 * 取得所有已开通的公司的权限
	 * @return
	 */
	public List<String> findAllByOpenPermission();
	
	/**
	 * 取得所有未开通的公司的权限
	 * @return
	 */
	public List<String> findAllNotOpenPermission();
	
	/**
	 * 取得所有公司上传的证书信息
	 * @return
	 */
	public List<String> findAllUploadData();
	
	/**
	 * 根据公司corpid找到公司的上传证书
	 * @param corpid
	 * @return
	 */
	public Company get(String corpid);
	
	/**
	 * 实现文件的上传
	 * @param param
	 * @return
	 */
	public boolean upload(Map<String,Object> param);
	
	/**
	 * 根据企业Corpid开通企业权限
	 * @param vo
	 * @return
	 */
	public boolean updateByCorpid(Company vo);
	
	/**
	 * 取得未开通的所有公司
	 * @param params
	 * @return
	 */
	public Map<String, Object> listNoOpen(String column, String keyWord, Integer currentPage, Integer lineSize);
	
	/**
	 * 批量授权
	 * @param ids
	 * @return
	 */
	public boolean UpdateBatch(List<String> ids);
}
