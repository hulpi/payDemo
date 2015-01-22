package com.uaf.pay.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uaf.pay.constants.ConfigKeyConstants;
import com.uaf.pay.dto.UiTransactionDTO;
import com.uaf.pay.status.TransactionStatus;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UiTransactionDTO dto = new UiTransactionDTO();

		ApplicationContext app = new ClassPathXmlApplicationContext("Beans.xml");
		Dao dao = app.getBean(Dao.class);

		// prepare the query DTO.
		dto.setStatus(TransactionStatus.WAIT_CONFIRM);
		 
		System.out.println("sss---" + dao.getConfigInfo(ConfigKeyConstants.AIPG_XMLMSG_TRANS_BODY_BUSSINESS_CODE));
		 
	}

}
