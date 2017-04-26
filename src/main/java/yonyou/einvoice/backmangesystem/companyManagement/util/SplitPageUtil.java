package yonyou.einvoice.backmangesystem.companyManagement.util;

import javax.servlet.http.HttpServletRequest;

public class SplitPageUtil {

	private String column;
	private String keyWord;
	private Integer currentPage;
	private Integer lineSize =5;
	
	public SplitPageUtil(HttpServletRequest request,String column){
		this.setColumn(column);
		this.setCp(request.getParameter("cp"));
		this.setLs(request.getParameter("ls"));
		this.setCol(request.getParameter("col"));
		this.setKw(request.getParameter("kw"));
	}

	
	public void setCp(String cp){
		try{
		   this.currentPage = Integer.parseInt(cp);
		}catch(Exception e){
			this.currentPage = 1;
		}
	}
	
	public void setLs(String ls){
		try{
		    this.lineSize = Integer.parseInt(ls);
		}catch(Exception e){
		}
	}
	
	public void setCol(String col){
		if(!(col == null || "".equals(col) || "null".equals(col))){
			this.column =col;
		}
	}
	
	public void setKw(String kw){
		if("".equals(kw)){
			this.keyWord=null;
		}else if("null".equals(kw)){
			this.keyWord=null;
		}else{
			this.keyWord=kw;
		}
	}
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getLineSize() {
		return lineSize;
	}

	public void setLineSize(Integer lineSize) {
		this.lineSize = lineSize;
	}

	@Override
	public String toString() {
		return "SplitPageUtil [column=" + column + ", keyWord=" + keyWord + ", currentPage=" + currentPage
				+ ", lineSize=" + lineSize + ", getColumn()=" + getColumn() + ", getKeyWord()=" + getKeyWord()
				+ ", getCurrentPage()=" + getCurrentPage() + ", getLineSize()=" + getLineSize() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
