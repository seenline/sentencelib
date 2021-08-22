package com.wizz.sentencelib.SelectResult;

import lombok.Data;

/**
 * @author seenline
 * @data 2021/8/6 20:19
 * @description
 */
@Data
public class ArticleWithUserResult {
    private Integer sid;
    private String sentence;
    private String picture;
    private String tag1;
    private String tag2;
    private String tag3;
    private String tag4;
    private String dateTime;
}
