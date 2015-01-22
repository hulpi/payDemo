package com.uaf.pay.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.uaf.pay.dao.CommonDao;
import com.uaf.pay.model.BankMapping;
import com.uaf.pay.model.ConfigInfo;

public class CommonDaoImpl implements CommonDao {
	
	private static Logger log = Logger.getLogger(CommonDaoImpl.class);
	
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public String getConfigInfo(String keyInfo) {
		List<ConfigInfo> list = sqlSessionTemplate.selectList(
				"com.uaf.pay.model.mapper.ConfigInfoMapper.getValueByKeyInfo",keyInfo);
		if (list != null && list.size() > 0) {
			return list.get(0).getInfoValue();
		}

		return "";
	}

	@Override
	public Map<String, String> getAllConfigInfo() {
		Map<String, String> map = new HashMap<String, String>();
		List<ConfigInfo> list = sqlSessionTemplate.selectList(
				"com.uaf.pay.model.mapper.ConfigInfoMapper.selectAll");
		if (list != null && list.size() > 0) {
			for (ConfigInfo info : list) {
				map.put(info.getInfoKey(), info.getInfoValue());
			}

		}

		return map;
	}

	@Override
	public Map<String, String> getAipgBankMapping() {
		Map<String, String> map = new HashMap<String, String>();
		List<BankMapping> list = sqlSessionTemplate.selectList(
				"com.uaf.pay.model.mapper.BankMappingMapper.selectAipgBankMapping");
		if (list != null && list.size() > 0) {
			for (BankMapping info : list) {
				map.put(info.getOriginalBankCode(), info.getDestinedBankCode());
			}

		}
		return map;
	}
}
