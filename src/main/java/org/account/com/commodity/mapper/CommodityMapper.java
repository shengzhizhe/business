package org.account.com.commodity.mapper;

import com.github.pagehelper.Page;
import org.account.com.commodity.model.CommodityModel;
import org.apache.ibatis.annotations.*;

public interface CommodityMapper {
    @Select({"select * from commodity_table where busid = #{busid}"})
    Page<CommodityModel> findByBusId(@Param("busid") String busid);

    @Select({"select * from commodity_table where uuid = #{uuid}"})
    CommodityModel getByUuid(@Param("uuid") String uuid);

    @Insert({"insert into commodity_table values (#{model.uuid},#{model.cname},#{model,jg},#{model.dw},#{model.ge}," +
            "#{model.zt},#{model.pp},#{model.xq},#{model.xl},#{model.busid},#{model.sl})"})
    int add(@Param("model") CommodityModel model);

    @Delete({"delete from commodity_table where uuid = #{uuid}"})
    int del(@Param("uuid")String uuid);

    @Update({"update commodity_table set cname = #{model.cname},jg = #{model,jg},dw = #{model.dw},ge = #{model.ge},zt = " +
            "#{model.zt},pp = #{model.pp},xq = #{model.xq},xl = #{model.xl},sl = #{model.sl} where uuid = #{model.uuid}"})
    int Update(@Param("model")CommodityModel model);
}
