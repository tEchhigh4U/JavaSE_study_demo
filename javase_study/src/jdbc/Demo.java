package jdbc;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 數據連結開始
        String user = "root";
        String password = "6231William852!";
        String url = "jdbc:mysql://localhost:3306/test_java_se?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        // 加載驅動類
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        // 數據庫連結結束

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet tables = databaseMetaData.getTables(null, null, "students", null);
        if (!tables.next()) {
            // 表格不存在時，立即創造
            Statement stmt = connection.createStatement();
            String createTableSQL = "CREATE TABLE students (id INT PRIMARY KEY, name VARCHAR(20), age INT)";
            stmt.executeUpdate(createTableSQL);
        }

        // 現在可以繼續準備sql命令；
        String sql = "select * from students";
        // 預處理sql命令，比如添加參數之類的；
        PreparedStatement ps = connection.prepareStatement(sql);
        // 執行查詢2sql
        ResultSet rs = ps.executeQuery();

        // 繼續處理數據
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        System.out.println("End");
    }
}
