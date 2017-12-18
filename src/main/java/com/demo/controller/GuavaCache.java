package com.demo.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
public class GuavaCache {
    private final static int MAX_SIZE = 10;//缓存大小
    private final static int EXPIRE_TIME = 100;//失效时间
    private static Map<Integer, String> database = Maps.newHashMap();
    private LoadingCache<Integer, String> cache;

    @PostConstruct
    public void init(){
        log.info("init...");
        String student1 = new String("student1");
        String student2 = new String("student2");
        String student3 = new String("student3");
        String student4 = new String("student4");
        String student5 = new String("student5");

        database.put(1,student1);
        database.put(2,student2);
        database.put(3,student3);
        database.put(4,student4);
        database.put(5,student5);

        cache = CacheBuilder.newBuilder().maximumSize(MAX_SIZE).expireAfterWrite(EXPIRE_TIME, TimeUnit.SECONDS).build(new CacheLoader<Integer, String>() {
            @Override
            public String load(Integer id) throws Exception {
                return getFromDatabase(id);
            }
        });
    }

    private String getFromDatabase(Integer id) {
        return database.get(id);
    }

    public void getData(int id) throws ExecutionException {
        cache.get(id);
    }

    public void prinfInfo(){
        log.info("the stats of this cache:[{}]",cache.stats().toString());
    }
}
