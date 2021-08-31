package com.wizz.sentencelib.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wizz.sentencelib.beans.Sentence;
import com.wizz.sentencelib.mapper.SentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author seenline
 * @date 2021/7/30 17:20
 * @description 用于复制文案图片和加入收藏、移除收藏的热度增加或减少
 */
@Service
public class HeatActService {
    @Autowired
    private SentenceMapper sentenceMapper;

    private Sentence sentence;
    public void add(Integer sid)
    {
        sentence=sentenceMapper.selectOne(new QueryWrapper<Sentence>().eq("sid",sid));
        sentence.setHeat(sentence.getHeat()+1);
        sentenceMapper.update(sentence,new QueryWrapper<Sentence>().eq("sid",sid));
    }
    public void reduce(Integer sid)
    {
        sentence=sentenceMapper.selectOne(new QueryWrapper<Sentence>().eq("sid",sid));
        sentence.setHeat(sentence.getHeat()-1);
        sentenceMapper.update(sentence,new QueryWrapper<Sentence>().eq("sid",sid));
    }
}
