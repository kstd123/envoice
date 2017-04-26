package yonyou.einvoice.backmangesystem.companyManagement.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import yonyou.einvoice.backmangesystem.companyManagement.vo.Company;

@Mapper
public interface ICompanyDAO {

	/**
	 * 公司开通之前检查是否已经存在公司名称，如果存在不能开通
	 * @return
	 */
	public Company findBycorpname(String corpname);
	
	/**
	 * 公司开通
	 * @param true
	 * @return
	 */
	public boolean doCreate(Company vo);
	
	/**
	 * 进行数据的模糊查询
	 * @param params
	 * @return
	 */
	public List<Company> findAllSplit(Map<String,Object> params);
	
	/**
	 * 进行数据的统计操作
	 * @param params
	 * @return
	 */
	public Integer getAllCount(Map<String,Object> params);
	
	/**
	 * 根据公司corpid找到公司的证书
	 * @param corpid
	 * @return
	 */
	public Company findById(String corpid);
	
	/**
	 * 上传文件
	 * @param param
	 * @return
	 */
	public boolean uploadFile(Map<String,Object> param);
	
	/**
	 * 开通企业权限
	 * @param vo
	 * @return
	 */
	public boolean doUpdateByCorpid(Company vo);
	
	/**
	 * 取得未开通的所有公司公司
	 * @param params
	 * @return
	 */
	public List<Company> findAllSplitNoOpen(Map<String,Object> params);
	
	/**
	 * 取得未开通的所有公司的记录数
	 * @param params
	 * @return
	 */
	public Integer getAllCountNoOpen(Map<String,Object> params);
	
	/**
	 * 批量授权
	 * @param ids
	 * @return
	 */
	public boolean doUpdateBatch(Map<String,Object> params);
	
}
