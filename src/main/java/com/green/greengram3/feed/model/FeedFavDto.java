package com.green.greengram3.feed.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="좋아요 데이터")
public class FeedFavDto {
    private int iuser;
    private int ifeed;
}
