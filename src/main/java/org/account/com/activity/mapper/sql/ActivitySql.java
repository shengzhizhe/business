package org.account.com.activity.mapper.sql;

import org.account.com.busdata.mapper.sql.AccountSql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;

public class ActivitySql {
    private static Logger logger = LoggerFactory.getLogger(AccountSql.class);

    public String select_page_type(String names,String businesnames) {
        StringJoiner sql = new StringJoiner("");
        sql.add("select * from activity_table a ");
        if (names != null && !names.isEmpty()) {
            sql.add("where 1=1 and a.names=#{names}");
        }
        if (businesnames != null && !businesnames.isEmpty()) {
            sql.add(" LEFT JOIN businessaccount_table b ON b.uuid = a.businessaccount AND b.businesnames = #{businesnames} WHERE 1 = 1");
        }
        if((names == null || names.isEmpty()&&(businesnames == null && businesnames.isEmpty())))
        {
            sql.add("where 1=1");
        }
        logger.info("[sql]---[" + sql.toString() + "]");
        return sql.toString();
    }
}
