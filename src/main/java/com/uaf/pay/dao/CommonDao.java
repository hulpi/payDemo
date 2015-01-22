package com.uaf.pay.dao;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;


public interface CommonDao {
	
	public SqlSessionTemplate getSqlSessionTemplate();
    public String getConfigInfo(String keyInfo);

	public Map<String, String> getAllConfigInfo();
	
	public Map<String, String> getAipgBankMapping();

}
