package com.godeltech.botdemo.resolver;

import com.godeltech.botdemo.dto.YoutubeVideoDto;
import com.godeltech.botdemo.service.YoutubeClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InlineQueryResolver {

    private final YoutubeClientService youtubeClientService;

    public BotApiMethod handleQuery(InlineQuery inlineQuery) {
        List<InlineQueryResult> inlineQueryResultList = new ArrayList<>();
        List<YoutubeVideoDto> allVideos = youtubeClientService.findAllVideos();
        allVideos.forEach(youtubeVideoDto -> inlineQueryResultList.add(
                InlineQueryResultArticle.builder()
                        .id("Youtube:" + youtubeVideoDto.getId())
                        .title(youtubeVideoDto.getTittle())
                        .url("https://www.youtube.com/watch?v=" + youtubeVideoDto.getId())
                        .thumbUrl(youtubeVideoDto.getThumbUrl())
                        .thumbWidth(300)
                        .thumbHeight(300)
                        .inputMessageContent(InputTextMessageContent.builder()
                                .messageText("https://www.youtube.com/watch?v=" + youtubeVideoDto.getId())
                                .build())
                        .build()));
        ;
        return AnswerInlineQuery.builder()
                .cacheTime(10)
                .inlineQueryId(inlineQuery.getId())
                .results(inlineQueryResultList)
                .build();
    }
}
