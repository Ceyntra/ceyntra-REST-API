package com.ceyntra.ceyntraRestAPI.service;

import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {
    private String rapidApiKey = "957f428eeamsh9f11a969b3b93eep10b262jsndaac87a7b734";

    public String getRapidApiKey() {
        return rapidApiKey;
    }
}
