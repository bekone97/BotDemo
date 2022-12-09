package com.godeltech.botdemo.service.impl;

import com.godeltech.botdemo.dto.YoutubeVideoDto;
import com.godeltech.botdemo.service.YoutubeClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeClientServiceHardcoded implements YoutubeClientService {
    private final List<YoutubeVideoDto> videos;

    public YoutubeClientServiceHardcoded() {
        videos=new ArrayList<>();
        videos.add(YoutubeVideoDto.builder()
                        .id("jfKfPfyJRdk")
                        .tittle("lofi hip hop radio - beats to relax/study to")
                        .thumbUrl("https://i.ytimg.com/vi/jfKfPfyJRdk/hq720_live.jpg?sqp=CPjop5wG-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBZTk0H_Va_Q9gP-PSx7IYMY_3mwg")
                .build());
        videos.add(YoutubeVideoDto.builder()
                        .id("kJ7VtJ09De0")
                        .tittle("ДОНЧИЧА ВОЗЯТ ВСЕ КОМУ НЕ ЛЕНЬ / НОВИЧКИ ДЕТРОЙТА В ПОРЯДКЕ! / ТЕЙТУМ ПРЕТЕНДУЕТ НА MVP")
                        .thumbUrl("https://i.ytimg.com/vi/kJ7VtJ09De0/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBTukmMTzbLVr0iLJpn27QXXu9yhw")
                .build());
        videos.add(YoutubeVideoDto.builder()
                        .id("0GUfKn6p79Q")
                        .tittle("Billie Eilish, Carla Morrison, Cigarettes After Sex, Zubi, Emma Peters, OMER BALIK, YA NINA, Edmofo")
                        .thumbUrl("https://i.ytimg.com/vi/0GUfKn6p79Q/hq720_live.jpg?sqp=CNT0p5wG-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCq2bV6JaOq-1U-nAkH_10suek3Bw")
                .build());
    }

    @Override
    public List<YoutubeVideoDto> findAllVideos() {
        return videos;
    }
}
