package com.springboot.mybatis.h2.example.User;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMyBatisRepository {
	@Select("select * from User")
	public List<User> findAll();

	@Select("SELECT * FROM User WHERE id = #{id}")
	public User findById(long id);

	@Delete("DELETE FROM User WHERE id = #{id}")
	public int deleteById(long id);

	@Insert("INSERT INTO User(id, name, score) VALUES (#{id}, #{name}, #{score})")
	public int insert(User user);

	@Update("Update User set name=#{name}, score=#{score} where id=#{id}")
	public int update(User user);

}
