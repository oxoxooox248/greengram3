package com.green.greengram3.feed.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "피드 리스트")
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private String createdAt;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
    private List<String> pics;
    private int isFav;
    private List<FeedCommentSelVo> comments;
    private int isMoreComment;
}
