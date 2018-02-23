package org.account.com.voucher.mapper;

import org.account.com.util.resultJson.ResponseResult;
import org.account.com.voucher.model.Voucher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VoucherMapper {
    @Select({"SELECT * FROM voucher_table WHERE claim = #{c}"})
    List<Voucher> getByClaim(@Param("c") String claim);
    @Select({"SELECT * FROM voucher_table WHERE busaccount = #{b}"})
    List<Voucher> getByBusaccount(@Param("b") String busaccount);
    @Select({"SELECT * FROM voucher_table WHERE code = #{c}"})
    Voucher getByCode(@Param("c") String code);
    @Update({"UPDATE voucher_table SET type = 2 WHERE uuid = #{id}"})
    int updateById(@Param("id") String id);
}
