package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedFavDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavMapper {
    int insFav(FeedFavDto dto);
    int delFav(FeedFavDto dto);
    int delFavByIfeed(FeedDelDto dto);
}
