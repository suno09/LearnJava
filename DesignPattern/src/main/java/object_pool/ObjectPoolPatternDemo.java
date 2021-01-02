package object_pool;

import java.sql.Connection;

public class ObjectPoolPatternDemo {
    public static void main(String[] args) {
        // Create the ConnectionPool:
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "org.mariadb.jdbc.Driver",
                "jdbc:mariadb://localhost:3306/vento",
                "root",
                "2015");

        // Get a connection:
        Connection con = pool.getObject();
        // Return the connection:
        pool.releaseObject(con);
    }
}
