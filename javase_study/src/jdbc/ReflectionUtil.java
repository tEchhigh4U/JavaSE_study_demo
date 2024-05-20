package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ReflectionUtil {
    public static <T> T setPropertiesFromResultSet(ResultSet resultSet, Class<T> clazz) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T instance = clazz.getDeclaredConstructor().newInstance();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            Object columnValue = resultSet.getObject(columnName);

            String methodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
//            System.out.println("methodName = " + methodName);

            try {
                Method method = clazz.getMethod(methodName, columnValue.getClass());
                method.invoke(instance, columnValue);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                System.out.println("No setter for column " + columnName + " found in " + clazz.getSimpleName());
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
}
