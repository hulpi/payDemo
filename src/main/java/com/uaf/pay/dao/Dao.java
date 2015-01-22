package com.uaf.pay.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.uaf.pay.model.ConfigInfo;

public class Dao {

	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public String getConfigInfo(String keyInfo) {
		List<ConfigInfo> list = sqlSessionTemplate.selectList(
				"com.uaf.pay.model.mapper.ConfigInfoMapper.getValueByKeyInfo",keyInfo);
		if (list != null && list.size() > 0) {
			return list.get(0).getInfoValue();
		}

		return "";
	}

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
}
