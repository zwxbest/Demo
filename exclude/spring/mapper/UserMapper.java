package com.tuowazi.demo.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zwxbest on 2018/8/11.
 */
@Repository
@Mapper
public interface UserMapper {

    int insert(String userName);

    int deleteAll();

    List<String> selectAll();
}
