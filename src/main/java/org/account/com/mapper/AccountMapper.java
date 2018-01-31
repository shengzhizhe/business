package org.account.com.mapper;

import com.github.pagehelper.Page;
import org.account.com.mapper.sql.AccountSql;
import org.account.com.model.BusinessAccountModel;
import org.apache.ibatis.annotations.*;


/**
 * //@name 人员资料
 */
public interface AccountMapper {

    String tableName = " businessAccount_table ";

    /**
     * 新增账户
     *
     * @param model BusinessAccountModel
     * @return int
     */
    @Insert({
            "insert into " + tableName + " (uuid,account,licenseImg,legalperson,legalpersonIdNumber,legalpersonPhone" +
                    ",legalpersonTelephone,servicePhone,shopAddress,scopeOperation,industryLicense,businessType) " +
                    "values (#{model.uuid},#{model.account},#{model.licenseImg},#{model.legalperson}," +
                    "#{model.legalpersonIdNumber},#{model.legalpersonPhone},#{model.legalpersonTelephone},#{model.servicePhone}" +
                    ",#{model.shopAddress},#{model.scopeOperation},#{model.industryLicense},#{model.businessType})"
    })
    int add(@Param("model") BusinessAccountModel model);

    /**
     * 根据id获取实体
     *
     * @param id String
     * @return BusinessAccountModel
     */
    @Select({
            "select * from " + tableName + " where uuid = #{id}"
    })
    BusinessAccountModel getById(@Param("id") String id);

    /**
     * 根据账户获取实体
     *
     * @param account String
     * @return BusinessAccountModel
     */
    @Select({
            "select * from " + tableName + " where account=#{account}"
    })
    BusinessAccountModel getByAccount(@Param("account") String account);

    /**
     * 获取所有的指定类型的账户
     *
     * @param type    String
     * @param account String
     * @return Page<BusinessAccountModel>
     */
    @SelectProvider(type = AccountSql.class, method = "select_page_type")
    Page<BusinessAccountModel> findAllPage(String type, String account);

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
}
