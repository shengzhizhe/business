package org.account.com.voucher.service;

import org.account.com.util.resultJson.ResponseResult;

public interface VoucherService {
    ResponseResult getByClaim(String claim);
    ResponseResult getByBusaccount(String busaccount);
    ResponseResult getByCode(String code);
    ResponseResult updateById(String id);
}
