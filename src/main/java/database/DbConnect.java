package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

    private SQLQuery sqlQuery = new SQLQuery();
    private Connection connection;
    private Statement statement;

    private DbConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.connection = DriverManager.getConnection("jdbc:sqlserver://IP_Address\\MSSQLSERVER_YEAR;databaseName=db_name", "sa", "Sql.123456");
    }

    public void addItem(String item, String itemName) {
        try {
            statement = connection.createStatement();
            switch (item) {
                case "Item_1":
                   statement.execute(sqlQuery.queryForAddItem(itemName));
                    break;
                case "Item_2":
//                    statement.execute(sqlQuery.queryForAddItem_2(itemName));
                    break;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                this.connection.createStatement().close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void updateItem(String item, String itemName) {
        try {
            statement = connection.createStatement();
            switch (item) {
                case "Item_1":
                    statement.execute(sqlQuery.queryForUpdateItem(itemName));
                    break;
                case "Item_2":
//                    statement.execute(sqlQuery.queryForUpdateItem_1(itemName));
                    break;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                this.connection.createStatement().close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }


}
