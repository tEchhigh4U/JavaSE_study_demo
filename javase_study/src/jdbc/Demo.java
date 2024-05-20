package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 創建數據庫連結
// 處理新增的數據並打印出來
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 連結數據庫
        connectDb();

        // Demo1
//        printDataFromDB();

        // Demo2
        saveDataInObjectFromDB();
    }

    public static Connection connectDb() throws ClassNotFoundException, SQLException {
        // 數據連結開始
        String user = "root";
        String password = "6231William852!";
        String url = "jdbc:mysql://localhost:3306/test_java_se?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        // 加載驅動類
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        // 數據庫連結結束
        return connection;
    }

    // 實際開發中，好的習慣時關閉數據庫的連結，節省資源
    public static void closeDb(ResultSet rs, Statement statement, Connection connection) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void saveDataInObjectFromDB() throws ClassNotFoundException, SQLException {
        Connection connection = connectDb();

        // 現在可以繼續準備sql命令；
        String sql = "select * from students";
        sql = "select * from students where name = ?";
        // 預處理sql命令，比如添加參數之類的；
        PreparedStatement ps = connection.prepareStatement(sql);
        // 處理參數
        ps.setString(1, "Peter");
        // 執行查詢sql
        ResultSet rs = ps.executeQuery();

        // 建立list
        List<Student> list = new ArrayList<>();


        // 繼續處理數據
        while (rs.next()) {
            Student student = new Student();

            // 從數據庫讀取相關數據
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

//            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);

            student.setId(id);
            student.setName(name);
            student.setAge(age);
            list.add(student);
        }

        System.out.println(list);
        System.out.println("-- End -- ");

        closeDb(rs, ps, connection);
    }


    // Demo1
    public static void printDataFromDB() throws ClassNotFoundException, SQLException {
        Connection connection = connectDb();

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
        closeDb(rs, ps, connection);
    }
}
