package com.godeltech.botdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class YoutubeVideoDto {
    private String id;
    private String tittle;
    private String thumbUrl;
}
