package com.wizz.sentencelib.controller;

import com.wizz.sentencelib.model.CommonResponse;
import com.wizz.sentencelib.service.HeatActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seenline
 * @data 2021/7/30 16:44
 * @description 用于用户每次复制文案和图片都会增加句子的热度，加入收藏的热度添加方式写在LikeController中
 */
@RestController
public class CopyAddHeatController {
    @Autowired
    private HeatActService heatAct;

    @RequestMapping("/copy")
    public CommonResponse copyAddHeat(@RequestParam(value = "sid",required = true) Integer sid)
    {
        heatAct.add(sid);
        return CommonResponse.SUCCESS;
    }

}
