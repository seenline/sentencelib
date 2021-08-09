package com.wizz.sentencelib.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tbl_sentence")
public class Sentence {
    private Integer id;
    @TableField(value = "sid")
    private Integer sid;
    private Integer heat;
    private String sentence;
    private String picture;
    private String tag1;
    private String tag2;
    private String tag3;
    private String tag4;
    private Date time;
}
