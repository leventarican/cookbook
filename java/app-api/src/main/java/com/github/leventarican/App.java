package com.github.leventarican;

import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import org.dalesbred.Database;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.RunScript;

public class App {

    public static void main(String[] args) throws Exception {

        var dbName = "appDB";

        var datasource = JdbcConnectionPool.create("jdbc:h2:mem:" + dbName, "app", "password");
        var database = Database.forDataSource(datasource);

        datasource.setLoginTimeout(-1);
        Connection conn = datasource.getConnection();
        var databaseProductName = conn.getMetaData().getDatabaseProductName();
        System.out.println("databaseProductName: " + databaseProductName);
        conn.close();

//        createTables(database);
//        datasource = JdbcConnectionPool.create("jdbc:h2:mem:" + dbName, "app_api_user", "password");
//        database = Database.forDataSource(datasource);
    }

    private static void createTables(Database database) throws Exception {
        var path = Paths.get(App.class.getResource("/schema.sql").toURI());
        database.update(Files.readString(path));
    }
}
