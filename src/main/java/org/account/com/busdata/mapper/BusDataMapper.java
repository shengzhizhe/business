package org.account.com.busdata.mapper;

import com.github.pagehelper.Page;
import org.account.com.busdata.mapper.sql.AccountSql;
import org.account.com.busdata.model.BusDataModel;
import org.apache.ibatis.annotations.*;

public interface BusDataMapper {

    String tableName = " businessAccount_table ";

    /**
     * 新增账户
     *
     * @param model BusDataModel
     * @return int
     */
    @Insert({
            "insert into " + tableName + " (uuid,account,licenseImg,legalperson,legalpersonIdNumber,legalpersonPhone" +
                    ",legalpersonTelephone,servicePhone,shopAddress,scopeOperation,industryLicense,businessType) " +
                    "values (#{model.uuid},#{model.account},#{model.licenseImg},#{model.legalperson}}," +
                    "#{model.legalpersonIdNumber},#{model.legalpersonPhone},#{model.legalpersonTelephone},#{model.servicePhone}" +
                    ",#{model.shopAddress},#{model.scopeOperation},#{model.industryLicense},#{model.businessType})"
    })
    int add(@Param("model") BusDataModel model);

    /**
     * 根据id获取实体
     *
     * @param id String
     * @return BusDataModel
     */
    @Select({
            "select * from " + tableName + " where uuid = #{id}"
    })
    BusDataModel getById(@Param("id") String id);

    /**
     * 根据账户获取实体
     *
     * @param account String
     * @return BusDataModel
     */
    @Select({
            "select * from " + tableName + " where account=#{account}"
    })
    BusDataModel getByAccount(@Param("account") String account);

    /**
     * 获取所有的指定类型的账户
     *
     * @param type    String
     * @param account String
     * @return Page<BusDataModel>
     */
    @SelectProvider(type = AccountSql.class, method = "select_page_type")
    Page<BusDataModel> findAllPage(String type, String account);

    /**
     * 根据id删除实体
     *
     * @param id String
     * @return int
     */
    @Delete({
            "delete from businessAccount_table where uuid = #{id}"
    })
    int del(@Param("id") String id);

    /**
     * 根据id修改商家资料
     *
     * @param model
     * @return
     */
    @Update({"UPDATE businessaccount_table b" +
            "SET b.account = #{model.account}," +
            " b.businesnames = #{model.businesnames}," +
            " b.businessType = #{model.businessType}," +
            " b.industryLicense = #{model.industryLicense}," +
            " b.legalperson = #{model.legalperson}," +
            " b.legalpersonIdNumber = #{model.legalpersonIdNumber}," +
            " b.legalpersonPhone = #{model.legalpersonPhone}," +
            " b.legalpersonTelephone = #{model.legalpersonTelephone}," +
            " b.licenseImg = #{model.licenseImg}," +
            " b.scopeOperation = #{model.scopeOperation}," +
            " b.servicePhone = #{model.servicePhone}," +
            " b.shopAddress = #{model.shopAddress}" +
            " WHERE" +
            " b.uuid = #{model.uuid}"})
    int update (@Param("model") BusDataModel model);
}
