package com.exercise.RLMarket.config;

import com.exercise.RLMarket.mappers.ItemDTOConverter;
import com.exercise.RLMarket.mappers.UserDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private ItemDTOConverter itemDTOConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userDTOConverter);
        registry.addConverter(itemDTOConverter);
    }
}
