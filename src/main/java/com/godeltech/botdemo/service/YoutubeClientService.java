package com.godeltech.botdemo.service;

import com.godeltech.botdemo.dto.YoutubeVideoDto;

import java.util.List;

public interface YoutubeClientService {
    List<YoutubeVideoDto> findAllVideos();
}
