package yonyou.einvoice.backmangesystem.companyManagement.util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;


public abstract class AbstactAction {

	public static final Logger logger = LoggerFactory.getLogger(AbstactAction.class);
	/**
	 * 注解资源文件(messages.properties)的信息
	 */
	@Resource
	private MessageSource messageSource;
	
	/**
	 * 获取资源文件的信息
	 * @param msgKey
	 * @param args
	 * @return
	 */
	public String getMessageValue(String msgKey, Object... args){
		return this.messageSource.getMessage(msgKey, args, Locale.getDefault());
	}
	
	/**
	 * 保存前端所需要的数据
	 * @param mav
	 * @param allRecorders
	 * @param column
	 * @param keyWord
	 * @param urlKey
	 * @param spu
	 */
	public void handleSplit(ModelAndView mav,Object allRecorders,String column,String keyWord,String urlKey,SplitPageUtil spu){
		
		mav.addObject("allRecorders",allRecorders);
		mav.addObject("column",column);
		mav.addObject("keyWorld",keyWord);
		mav.addObject("url",this.getMessageValue(urlKey));
		mav.addObject("currentPage", spu.getCurrentPage());
		mav.addObject("lineSize",spu.getLineSize());
	}
	
	/***
	 * 进行上传证书 pic
	 * @param pic
	 * @return
	 */
	public boolean UploadFileOperation(MultipartFile pic,String fileName,HttpServletRequest request){
		if(!pic.isEmpty()){
			String filePath = request.getServletContext().getRealPath("/upload/file/") + fileName;
			try {
				return UploadFile.UploadFileResource(pic.getInputStream(), new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 创建一个文件名称
	 * @param pic
	 * @return
	 */
	public String createFileName(MultipartFile pic){
		if(pic.isEmpty()){
			return "nophoto.gif";
		}else{
			return UploadFile.createFileName(pic.getContentType());
		}
	}
	
	/**
	 * 进行文件的显示
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public void showResponse(HttpServletResponse response,byte [] data) throws IOException{
		response.setCharacterEncoding("UTF-8");  
	    OutputStream outputSream = response.getOutputStream();  
	    InputStream in = new ByteArrayInputStream(data);  
	    int len = 0;  
	    byte[] buf = new byte[1024];  
	    while ((len = in.read(buf, 0, 1024)) != -1) {  
	        outputSream.write(buf, 0, len);  
	    }  
	    outputSream.close();
	}
	
	/**
	 * 
	 * @param pic
	 */
	public byte[] getByteFile(MultipartFile pic){
		byte [] bytes =null;
		try {
			 bytes = new byte [pic.getBytes().length];
			 InputStream input = pic.getInputStream();
			 input.read(bytes);
			 input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}
	
	/**
	 * 接受批量授权的id 按"|"进行拆分
	 * @param request
	 * @return all
	 */
	public List<String> getBatchIds(HttpServletRequest request){
		List<String> all = new ArrayList<String>();
		String ids = request.getParameter("ids");
		if(StringUtil.isNotEmpty(ids)){
			String result [] = StringUtil.splitString(ids, "|");
			if(ArrayUtil.isNotEmpty(result)){
				for(int x=0 ; x < result.length ; x++){
					all.add(result[x]);
				}
			}
		}
		return all;
	}
	
	/**
	 * 输出json数据格式
	 * @param response
	 * @param obj
	 * @return 
	 */
    public void  printJson(HttpServletResponse response,JSONObject obj){
		response.setCharacterEncoding("UTF-8");
		try{
			response.getWriter().println(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * 处理日期转换
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
}
