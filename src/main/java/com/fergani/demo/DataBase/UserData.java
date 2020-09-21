package com.fergani.demo.DataBase;

import com.fergani.demo.Models.User;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.BooleanControl;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UserData {
static class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(
                resultSet.getInt("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname")
        );
        return user ; }
}


    @Autowired
    JdbcTemplate jdbcTemplate ;

    public int insert (User user)
    {
        return jdbcTemplate.update("insert into user (id,firstName,lastName )"+" values (?,?,?)",

                new Object[]{user.getId(),user.getFirstName(),user.getLastname()}
                );

    }

    public List<User> GetAllUser(){
        return jdbcTemplate.query
                ("select* from user", new UserRowMapper());
    }

    public int delete (int id )
    {
     return jdbcTemplate.update("delete from  user where id=? ",new Object []{id});

    }
    public int UpdataUser (User user )
    {
     return jdbcTemplate.update("update user set firstName = ? , lastName= ? where id =?",
             new Object []{user.getFirstName(),user.getLastname(),user.getId()});
    }
    /** call All users from string permission*/
    public List <User> CallUsers(){
        return jdbcTemplate.query("CALL `GetAllUsers`();",new UserRowMapper());
 }

/** use jdbc stored procedure call*/

    public String CallUser(int id ){

        SimpleJdbcCall  call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("GetUserById");

        Map<String,Object> objectMap= call.execute(new MapSqlParameterSource("id",id));

        return objectMap.entrySet().toArray()[0].toString() ;
    }




}
