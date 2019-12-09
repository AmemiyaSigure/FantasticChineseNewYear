package cx.rain.mc.plugin.common.fantasticChineseNewYear.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MySql implements IDatabase {
    private BasicDataSource dataSource = null;

    public MySql(String host, int port, String user, String password, String databaseName, boolean useSsl) {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + databaseName +
                "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=" + useSsl;

        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(20);
        dataSource.setMinIdle(5);
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void dispose() {
        if (!dataSource.isClosed()) {
            try {
                dataSource.close();
            } catch (SQLException ignored) {

            }
        }
    }
}
