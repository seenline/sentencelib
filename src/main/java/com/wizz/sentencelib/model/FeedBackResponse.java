package com.wizz.sentencelib.model;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author seenline
 * @data 2021/8/17 16:54
 * @description 反馈信息的返回类（和获取文案的返回类相同）
 */
@Data
public class FeedBackResponse {
    private String responseCode;
    private String message;
    private LinkedList<Object> data= new LinkedList<>();
}
