package com.example.learn.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        TestDto testDto = new TestDto("123", "34");
        String sql = assembleSqlFromObj(testDto);
        System.out.println(sql);
    }

    public static String assembleSqlFromObj(Object object) {
        Table table = object.getClass().getAnnotation(Table.class);
        String tableName = table.value();
        StringBuffer sbSql = new StringBuffer();
        sbSql.append("select * from " + tableName + " where 1=1 ");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields) {
            String fieldName = f.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Column column = f.getAnnotation(Column.class);
                if (column != null) {
                    Method method = object.getClass().getMethod(methodName);
                    String value = (String) method.invoke(object);
                    if (value != null && !value.equals("")) {
                        if(!isNum(column.value()) && !isNum(value)) {
                            if (value.contains(",")) {
                                sbSql.append("and " + column.value() + " in (" + value + ") ");
                            } else {
                                sbSql.append("and " + column.value() + " like '%" + value + "%' ");
                            }
                        } else {
                            sbSql.append("and " + column.value() + "=" + value + " ");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sbSql.toString();
    }

    public static boolean isNum(String target) {
        boolean isNum = false;
        if (target.toLowerCase().contains("id")) {
            isNum = true;
        }
        if (target.matches("\\d+")) {
            isNum = true;
        }
        return isNum;
    }

}
