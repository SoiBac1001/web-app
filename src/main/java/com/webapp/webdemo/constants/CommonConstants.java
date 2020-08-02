package com.webapp.webdemo.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonConstants {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class HeaderConstants{
        public static final String APP_TOKEN = "App-Token";
        public static final String BEARER_TOKEN = "Bearer ";
    }
}
