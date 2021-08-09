package com.wizz.sentencelib.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wizz.sentencelib.SelectResult.CollectionRelationResult1;
import com.wizz.sentencelib.beans.CollectionRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionRelationMapper extends BaseMapper<CollectionRelation> {
    List<CollectionRelationResult1> selectRelation(String uid);
}
