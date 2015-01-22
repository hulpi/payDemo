package com.uaf.pay.util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public class SMBremoteFileUtil {
	
	private static Logger log = Logger.getLogger(SMBremoteFileUtil.class);
	
	/** 
	 * 
     * 从本地上传文件到共享目录 
     * @param remoteUrl 共享文件目录  smb://dimain;username:password@192.168.0.77/test
     * @param localFilePath 本地文件绝对路径 
     *  
     */  
    public static void smbPut(String remoteUrl, String localFilePath){  
        InputStream in = null;  
        OutputStream out = null;  
        try  
        {  
            File localFile = new File(localFilePath);  
  
            String fileName = localFile.getName();  
            
            SmbFile remoteFilePath = new SmbFile(remoteUrl);
            if(!remoteFilePath.exists()){
            	 remoteFilePath.mkdirs();
            }

            SmbFile remoteFile = new SmbFile(remoteUrl + "/" + fileName);  

            in = new BufferedInputStream(new FileInputStream(localFile));  
            out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));  
            byte[] buffer = new byte[1024];  
            int len = -1;
            while ((len = in.read(buffer)) != -1)
            {
              out.write(buffer, 0, len);
              buffer = new byte[1024];
            }
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();
            log.error("复制放款文件到财务windows服务器失败",e);
            //throw e;
        }  
        finally  
        {  
            try  
            {  
                out.close();  
                in.close();  
            }  
            catch (IOException e)  
            {  
            	e.printStackTrace();
            	 log.error("复制放款文件到windows财务服务器失败",e);
                //throw e;
            }  
        }  
    } 


    /** 
	 * 
     * 从本地直接写文件到共享目录 
     * @param remoteUrl 共享文件目录  smb://dimain;username:password@192.168.0.77/test
     * @param fileName
     * @param content
     * @param encoding
     *  
     */  
    public static void smbWriteContent(String remoteUrl, String fileName, String content, String encoding) {  
        InputStream in = null;  
        OutputStream out = null;  
        try  
        {  
            
            SmbFile remoteFilePath = new SmbFile(remoteUrl);
            if(!remoteFilePath.exists()){
            	 remoteFilePath.mkdirs();
            }

            SmbFile remoteFile = new SmbFile(remoteUrl + "/" + fileName);  

            if(encoding == null || "".equals(encoding)){
        		encoding = "GBK";
			}
        	
        	in = new ByteArrayInputStream(content.getBytes(encoding));
            out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));  
        	 
			byte[] buffer = new byte[1024];  
            int len = -1;
            while ((len = in.read(buffer)) != -1)
            {
              out.write(buffer, 0, len);
              buffer = new byte[1024];
            }
			 
   
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();
            log.error("写文件内容到财务windows服务器失败",e);
            //throw e;
        }  
        finally  
        {  
            try  
            {  
                out.close();  
                in.close();  
            }  
            catch (IOException e)  
            {  
            	e.printStackTrace();
            	log.error("写文件内容到财务windows服务器失败",e);
                //throw e;
            }  
        }  
    } 
    
    
}
