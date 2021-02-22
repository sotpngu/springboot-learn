package com.example.learn.service.impl;

import com.example.learn.enumeration.SexEnum;
import com.example.learn.pojo.User;
import com.example.learn.service.JdbcTmplUserService;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    // 获取映射关系
    private RowMapper<User> getUserMapper() {
        // 使用Lambda表达式创建用户关系
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    // 获取对象
    @Override
    public User getUser(Long id) {
        // 执行sql
        String sql = "select id, user_name, sex, note from t_user where id = ?";
        // 参数
        Object[] params = new Object[] {id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    // 查询用户列表
    @Override
    public List<User> findUsers(String userName, String note) {
        // 执行的SQL
        String sql = " select id, user_name, sex, note from t_user " + "where user_name like concat('%', ?, '%') "
                + "or note like concat('%', ?, '%')";
        // 参数
        Object[] params = new Object[] {userName, note};
        // 使用匿名类实现
        List<User> userList = jdbcTemplate.query(sql, params, getUserMapper());
        return userList;
    }

    // 插入数据库
    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user (user_name, sex, note) values (?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
    }

    // 更新数据库
    @Override
    public int updateUser(User user) {
        // 执行sql
        String sql = "update t_user set user_name = ?, sex = ?, note = ? " + "where id = ?";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getId());
    }


    // 删除数据
    public int deleteUser(Long id) {
        // 执行sql
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql, id);
    }







    public User getUser2(long id) {
        // 通过Lamdda表达式使用StatementCallback
        User result = jdbcTemplate.execute((Statement statement) -> {
            String sql1 = "select count(*) total from t_user where id=" + id;
            ResultSet rs1 = statement.executeQuery(sql1);
            while (rs1.next()) {
                int total = rs1.getInt("total");
                System.out.println(total);
            }
            // 执行sql
            String sql2 = "select id, user_name, sex, note from t_user " + "where id=" + id;
            ResultSet rs2 = statement.executeQuery(sql2);
            User user = null;
            while (rs2.next()) {
                int rowNum = rs2.getRow();
                user = getUserMapper().mapRow(rs2, rowNum);
            }
            return user;
        });
        return result;
    }

    public User getUser3(Long id) {
        // 通过Lambda表达式使用ConnectionCallback接口
        return jdbcTemplate.execute((Connection connection) ->{
            String sql1 = "select count(*) as total from t_user " +"where id=?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setLong(1, id);
            ResultSet rs1 = preparedStatement1.executeQuery();
            while (rs1.next()) {
                System.out.println(rs1.getInt("total"));
            }
            String sql2 = "select id, user_name, sex, note from t_user " + "where id=?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setLong(1, id);
            ResultSet rs2 = preparedStatement2.executeQuery();
            User user = null;
            while (rs2.next()) {
                int rowNum = rs2.getRow();
                user = getUserMapper().mapRow(rs2,  rowNum);
            }
            return user;
        });
    }

}
