package cx.rain.mc.plugin.fantasticChineseNewYear.common.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabase {
    BasicDataSource getDataSource();
    Connection getConnection() throws SQLException;
    void dispose();
}
