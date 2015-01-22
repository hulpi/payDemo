
package com.uaf.pay.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import org.apache.log4j.Logger;

import com.uaf.pay.constants.TranxCon;

 
 
public class FileUtil {
	
	private static Logger log = Logger.getLogger(FileUtil.class);

	public static void creatIfNotExsit(String filepath){
	   File file=new File(filepath);
		if(file.isAbsolute()&&!file.exists()){
			file.mkdirs();
		}
	}

	public static boolean  isExsit(String filepath){
		File file=new File(filepath);
		if(file.exists())
			return true;
		return false;
	}
	
	
	public static boolean saveToFile(String content,String filePath,String encoding){
		InputStream bis =null;
		OutputStream os = null;
		try{
			if(encoding==null||"".equals(encoding)){
				 bis = new ByteArrayInputStream(content.getBytes("GBK"));
			}else{
				 bis = new ByteArrayInputStream(content.getBytes(encoding));
			}
			os = new FileOutputStream(filePath);
			IOUtils.copy(bis, os);
			bis.close();
			os.close();
			if(log.isInfoEnabled()) {
			    log.info("保存文件:"+filePath);
			}
			
			return true;
			
		}catch(IOException e){
			log.error("保存文件失败:"+filePath);
			log.error("Error for: " + e.getMessage());
			if(log.isDebugEnabled()) {
				StackTraceElement[] stackElement = e.getStackTrace();
				if(stackElement != null) {
					for(StackTraceElement element : stackElement) {
						log.debug("Error at: " + element.getClassName() + ": " + element.getLineNumber());
					}
				}
				
			}
			
		} finally {
			IOUtils.closeQuietly(bis);
			IOUtils.closeQuietly(os);
		}
		
		return false;
	}
	
	public static String getClassLoadPath() {
		URL url = FileUtil.class.getClassLoader().getResource(TranxCon.CONFIG_PREFIX);
		String path = url != null? url.getPath(): "";
		if(log.isDebugEnabled()) {
			log.debug("path  = " + path);
		}
		
		return path;
	}
}

	 


