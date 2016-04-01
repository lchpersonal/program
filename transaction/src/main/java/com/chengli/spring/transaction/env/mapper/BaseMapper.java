package com.chengli.spring.transaction.env.mapper;

        import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Param;
        import org.apache.ibatis.annotations.Update;

/**
 * Created by chengli on 2016/1/26.
 */
public interface BaseMapper {

    @Insert("insert into user(id,name) values(#{id},#{name})")
    boolean insert(@Param("id") int id, @Param("name") String name);

    @Update("update user set name = 'haha' where id =#{id}")
    boolean update(@Param("id") int id);
}
