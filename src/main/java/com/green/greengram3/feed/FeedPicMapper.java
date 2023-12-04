package com.green.greengram3.feed;

import com.green.greengram3.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicMapper {
    int insFeedPics(FeedInsDto dto);
    List<String> selFeedPics(int ifeed);
    int delFeedPicAll(FeedDelDto dto);
}
