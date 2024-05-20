package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static jdbc.Demo.closeDb;
import static jdbc.Demo.connectDb;

public class ReadDataByReflect {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connectDb();
            connection = connectDb();
            String sql = "select * from students where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Peter");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = ReflectionUtil.setPropertiesFromResultSet(resultSet, Student.class);
                System.out.println("ID: " + student.getId() + ", name: " + student.getName() + ", age: " + student.getAge());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeDb(resultSet, preparedStatement, connection);
        }
    }
}
