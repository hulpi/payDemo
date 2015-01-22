package com.uaf.pay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

/**
 * HTTP工具类
 * @author sz04134
 *
 */
public class HttpUtil {
	private static Logger log = Logger.getLogger(HttpUtil.class);
	public static String httpSend(String url, Map<String, String> params) {  		
        URL u = null;  
        HttpURLConnection con = null;  
        // 构建请求参数  
        StringBuffer sb = new StringBuffer();  
        
        if (params != null) {  
            for (Entry<String, String> e : params.entrySet()) {  
                sb.append(e.getKey());  
                sb.append("=");  
                sb.append(e.getValue());  
                sb.append("&");  
            }  
            sb=new StringBuffer(sb.substring(0, sb.length() - 1));  
        }  
        
        System.out.println("send_url:" + url);  
        System.out.println("send_data:" + sb.toString());  
        // 尝试发送请求  
        try {  
            u = new URL(url);  
            con = (HttpURLConnection) u.openConnection();  
            //// POST 只能为大写，严格限制，post会不识别  
            con.setRequestMethod("POST");  
            con.setDoOutput(true);  
            con.setDoInput(true);  
            con.setUseCaches(false);  
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");  
            osw.write(sb.toString());  
            osw.flush();  
            osw.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (con != null) {  
                con.disconnect();  
            }  
        }  
  
        // 读取返回内容  
        StringBuffer buffer = new StringBuffer();  
        try {  
            //一定要有返回值，否则无法把请求发送给server端。  
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));  
            String temp;  
            while ((temp = br.readLine()) != null) {  
                buffer.append(temp);  
                buffer.append("\n");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return buffer.toString();  
    }  
	public static void main(String[] args) {
		String urlbase="http://bianmin-test.chinapay.com/cpeduinterface/OrderGet.do";
		Map<String, String> params=new HashMap<String,String>();
		params.put("MerId", "808080290000001");
		params.put("BusiId", "00010001");
		params.put("OrdId", "0000000010096806");
		params.put("OrdAmt", "1234");
		params.put("CuryId", "156");
		params.put("Version", "20100401");
		params.put("BgRetUrl", "");
		params.put("PageRetUrl", "");
		params.put("GateId", "");
		params.put("Param1", "");
		params.put("Param2", "");
		params.put("Param3", "");
		params.put("Param4", "");
		params.put("Param5", "");
		params.put("Param6", "");
		params.put("Param7", "");
		params.put("Param8", "");
		params.put("Param9", "");
		params.put("Param10", "");
		params.put("OrdDesc", "");
		params.put("ShareType", "");
		params.put("ShareData", "");
		params.put("Priv1", "");
		params.put("CustomIp", "");
		params.put("ChkValue", "");
		System.out.println(httpSend(urlbase, params));
		
		
		
	}
}

