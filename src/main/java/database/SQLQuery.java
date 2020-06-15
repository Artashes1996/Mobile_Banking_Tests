package database;

public class SQLQuery {

    public String queryForAddItem(String itemName) {
        String query = "INSERT INTO db_Table_name\n" +
                "VALUES('ITEM_NAME','param1', 'param2')";
        return query.replace("ITEM_NAME", itemName);
    }

    public String queryForUpdateItem(String itemName) {
        String query = "UPDATE db_Table_name\n" +
                "set 'name' = ITEM_NAME\n" +
                "WHERE Id = 25";
        return query.replace("ITEM_NAME", itemName);
    }

    public String queryForDeleteItem(String itemName) {
        String query = "DELETE FROM db_Table_name\n" +
                "WHERE name = ITEM_NAME";
        return query.replace("ITEM_NAME", itemName);
    }



}
