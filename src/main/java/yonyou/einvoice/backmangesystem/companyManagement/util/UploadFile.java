package yonyou.einvoice.backmangesystem.companyManagement.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadFile {

	public static final Logger logger = LoggerFactory.getLogger(UploadFile.class);
	
	public static boolean UploadFileResource(InputStream inputStream,File file){
		boolean flag = false ;
		OutputStream output =null;
		if(file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		try {
			output = new FileOutputStream(file);
			byte [] data = new byte[1024];
			int temp = 0;
			while((temp=inputStream.read(data))!=-1){
				output.write(data, 0, temp);
			}
			flag = true;
		} catch (Exception e) {
			logger.info("文件上传失败，请重新上传",e);
		}finally{
			try {
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static String createFileName(String name){
		String fileName = UUID.randomUUID().toString() + "." + name;
		return fileName;
		
	}
}
