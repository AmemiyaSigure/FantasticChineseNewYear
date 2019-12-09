package cx.rain.mc.plugin.common.fantasticChineseNewYear.database;

import cx.rain.mc.plugin.common.fantasticChineseNewYear.util.enumerate.DatabaseType;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private DatabaseType type = null;
    private IDatabase db = null;

    public Database(DatabaseType dbType, String host, int port, String user, String password,
                    String databaseName, boolean useSsl,
                    String path, String fileName) {
        type = dbType;
        switch (dbType) {
            case MySql:
                db = new MySql(host, port, user, password, databaseName, useSsl);
                break;
            case Sqlite:
                db = new Sqlite(path, fileName);
                break;
        }
    }

    public DatabaseType getType() {
        return type;
    }

    public Connection getConnection() throws SQLException {
        return db.getConnection();
    }
}
