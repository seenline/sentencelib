package com.wizz.sentencelib.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wizz.sentencelib.SelectResult.ArticleWithUserResult;
import com.wizz.sentencelib.SelectResult.CollectionResult;
import com.wizz.sentencelib.beans.Collection;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectionMapper extends BaseMapper<Collection> {
    IPage<CollectionResult>findAllCollection(IPage<Collection>page, String uid);
    IPage<ArticleWithUserResult>findTest(IPage<Collection>page,String uid);
}
