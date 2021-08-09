package com.wizz.sentencelib.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wizz.sentencelib.beans.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}
