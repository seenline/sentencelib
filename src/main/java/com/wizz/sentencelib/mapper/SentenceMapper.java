package com.wizz.sentencelib.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wizz.sentencelib.SelectResult.ArticleOutUserResult;
import com.wizz.sentencelib.SelectResult.CollectionRelationResult2;
import com.wizz.sentencelib.beans.Sentence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SentenceMapper extends BaseMapper<Sentence> {
    IPage<ArticleOutUserResult> findPageListByHeat(IPage<Sentence>page, @Param(Constants.WRAPPER) QueryWrapper<Sentence>queryWrapper,
                                             @Param("tag1") String tag1,
                                             @Param("tag2") String tag2,
                                             @Param("tag3") String tag3,
                                             @Param("tag4") String tag4);
    List<CollectionRelationResult2> selectFriendsCollection(String uid);
}
