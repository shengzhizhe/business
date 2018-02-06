package org.account.com.activity.mapper;

import com.github.pagehelper.Page;
import org.account.com.activity.mapper.sql.ActivitySql;
import org.account.com.activity.model.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface ActivityMapper {

    /**
     * 获取所有的指定类型的活动
     *
     * @param names    String
     * @param businesnames String
     * @return Page<Activity>
     */
    @SelectProvider(type = ActivitySql.class, method = "select_page_type")
    Page<Activity> findAllPage(String names, String businesnames);

    /**
     * 获取指定ID的活动
     *
     * @param uuid    String
     * @return Activity
     */
    @Select({"SELECT * FROM activity_table WHERE uuid = #{uuid}"})
    Activity getById(@Param("uuid") String uuid);

    /**
     * 获取指定名称的活动
     *
     * @param names String
     * @return Activity
     */
    @Select({"SELECT * FROM activity_table WHERE names = #{names}"})
    Activity getByName(@Param("names") String names);

    /**
     * 插入一条活动记录
     *
     * @param model Activity
     * @return int
     */
    @Select({"INSERT INTO activity_table VALUES (#{model.uuid},#{model.names},#{model.content},#{model.startTime}" +
            ",#{model.endTime},#{model.businessaccount},#{model.address},#{model.batch},#{model.type})"})
    int add(@Param("model") Activity model);

    /**
     * 根据id删除一条活动
     *
     * @param uuid String
     * @return int
     */
    @Delete({"DELETE FROM activity_table WHERE uuid = #{uuid}"})
    int del(@Param("uuid")String uuid);
}
