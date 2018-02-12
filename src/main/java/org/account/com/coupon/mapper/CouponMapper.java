package org.account.com.coupon.mapper;

import org.account.com.coupon.model.Coupon;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CouponMapper {

    @Insert({"INSERT INTO coupon_table c VALUES (#{c.uuid},#{c.type},#{c.activity},#{c.address}," +
            "#{c.batch},#{c.businessaccount},#{c.`condition`},#{c.content},#{c.endTime},#{c.number},#{c.startTime},#{c.flag})"})
    int add(@Param("c") Coupon c);

    @Delete({"DELETE FROM coupon_table WHERE uuid = #{id}"})
    int del(@Param("id") String id);

    @Select({"SELECT * FROM coupon_table WHERE uuid = #{id}"})
    Coupon getById(@Param("id") String id);

    @Select({"SELECT * FROM coupon_table"})
    List<Coupon> findAll();

    @Select({"SELECT * FROM coupon_table WHERE #{t} < endTime "})
    List<Coupon> findAllByTime(@Param("t") String t);

    @Select({"SELECT * FROM coupon_table WHERE businessaccount = #{b}"})
    Coupon getByBussinessAccount(@Param("b")String businessaccount);

}
