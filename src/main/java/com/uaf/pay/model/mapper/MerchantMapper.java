package com.uaf.pay.model.mapper;

import com.uaf.pay.model.Merchant;

public interface MerchantMapper {
    int insert(Merchant record);

    int insertSelective(Merchant record);
}