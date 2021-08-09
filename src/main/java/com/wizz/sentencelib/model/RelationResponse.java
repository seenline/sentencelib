package com.wizz.sentencelib.model;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author seenline
 * @data 2021/8/9 11:53
 * @description
 */
@Data
public class RelationResponse {
    private String responseCode;
    private String message;
    private LinkedList<Object> data= new LinkedList<>();
}
