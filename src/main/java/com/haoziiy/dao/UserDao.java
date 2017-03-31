package com.haoziiy.dao;

import com.haoziiy.model.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by sherry on 2017/3/31.
 */
@Mapper
public interface UserDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = " name, password, salt, head_url ";
    String SELECT_FIELDS = " id, name, password, salt, head_url ";

    @Insert({"insert into ", TABLE_NAME , "(" + INSERT_FIELDS
            + ") values(#{name},#{password},#{salt},#{headUrl})" })
    int addUser(User user);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    User selectById(int id);

    @Update({"update ", TABLE_NAME, " set password=#{password} where id=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ", SELECT_FIELDS, "where id=#{id}"})
    void deleteById(int id);
}
