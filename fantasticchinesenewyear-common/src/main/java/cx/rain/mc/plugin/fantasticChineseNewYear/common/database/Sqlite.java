package cx.rain.mc.plugin.fantasticChineseNewYear.common.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Sqlite implements IDatabase{
    private BasicDataSource dataSource = null;

    public Sqlite(String path, String fileName) {
        String url = "jdbc:sqlite://" + path + "/" + fileName;

        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl(url);

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
