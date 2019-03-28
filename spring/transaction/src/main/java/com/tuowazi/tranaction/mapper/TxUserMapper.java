package com.tuowazi.tranaction.mapper;

import com.tuowazi.tranaction.domain.po.TxUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zwxbest on 2018/8/11.
 */
@Repository
@Mapper
public interface TxUserMapper {
   int insert(TxUser user);
   int delete();
   List<TxUser> select();
}
