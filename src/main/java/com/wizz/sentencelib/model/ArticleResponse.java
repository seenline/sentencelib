package com.wizz.sentencelib.model;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author seenline
 * @data 2021/8/3 15:43
 * @description
 */
@Data
public class ArticleResponse {
    private String responseCode;
    private String message;
    private LinkedList<Object> data= new LinkedList<>();

}
