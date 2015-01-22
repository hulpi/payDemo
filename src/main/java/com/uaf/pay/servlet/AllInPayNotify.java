package com.uaf.pay.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.uaf.pay.service.AIPTranxService;
import com.uaf.pay.util.SpringContextTool;

public class AllInPayNotify extends HttpServlet {
	
	private static final long serialVersionUID = 20141028L;
	
	private static Logger log = Logger.getLogger(AllInPayNotify.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		byte[] bytes = new byte[1024 * 1024];
		InputStream is = req.getInputStream();
		// GBK转码
		int nRead = 1;
		int nTotalRead = 0;
		while (nRead > 0) {
			nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
			if (nRead > 0)
				nTotalRead = nTotalRead + nRead;
		}
		String retXml = new String(bytes, 0, nTotalRead, "GBK");
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>通联推送的字符：" + retXml);
		String notify_sn = null;
		String startNode = "<NOTIFY_SN>";
		String endNode = "</NOTIFY_SN>";
		if (retXml.indexOf(startNode) != -1) {
			int begin = retXml.indexOf(startNode) + startNode.length();
			int end = retXml.indexOf(endNode);
			if (begin >= 0) {
				notify_sn = retXml.substring(begin, end);
			}
		}
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>通联返回处理完成的流水号：" + notify_sn);
		try {
			if (notify_sn != null && notify_sn.length() > 0) {
				getAipTranxService().queryTrade(notify_sn);
			}
		} catch (Exception e) {
			log.info(">>>>>>>>>>>>>>>>>>>>>>>>接收通联推送数据发生异常："+e.getMessage());
		}
	}
	
	private AIPTranxService aipTranxService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	public AIPTranxService getAipTranxService() {
		if(aipTranxService==null){
			aipTranxService =  (AIPTranxService)SpringContextTool.getApplicationContext().getBean("aipTranxService");
		}
		return aipTranxService;
	}
	



}
