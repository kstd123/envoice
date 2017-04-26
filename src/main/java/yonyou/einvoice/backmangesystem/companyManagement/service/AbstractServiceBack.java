package yonyou.einvoice.backmangesystem.companyManagement.service;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceBack {

	/**
	 * 进行模糊查询之前的准备操做
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	protected Map<String, Object> handleParams(String column, String keyWord, int currentPage, int lineSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("".equals(column) || column == null || "null".equalsIgnoreCase(column)) {
		} else {
			map.put("column", column) ;
		}
		if ("".equals(keyWord) || "null".equalsIgnoreCase(keyWord) || keyWord == null) {
		} else { 
			map.put("keyWord", "%" + keyWord + "%") ;
		}
		if ((currentPage - 1) * lineSize < 0) {
			map.put("start", 0) ;
		} else {
			map.put("start", (currentPage - 1) * lineSize) ;
		}
		map.put("lineSize", lineSize > 0 ? lineSize : 5) ;
		return map;
	}
}
