package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.ExecutionException;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/18
 **/
@Controller
@Slf4j
@RequestMapping("/test")
public class CacheController {
    @Autowired
    GuavaCache cache;

    @RequestMapping(value = "/method1", method = RequestMethod.GET)
    public void getValueMethod1() throws ExecutionException {
        cache.getData(1);
        cache.getData(2);
        cache.getData(3);
        cache.prinfInfo();
    }

    @RequestMapping(value = "method2", method = RequestMethod.GET)
    public void getValueMethod2() throws ExecutionException {
        cache.getData(4);
        cache.getData(5);
        cache.prinfInfo();
    }

    @RequestMapping(value = "method3", method = RequestMethod.GET)
    public void getValueMethod3() throws ExecutionException {
        cache.getData(1);
        cache.getData(2);
        cache.getData(3);
        cache.getData(4);
        cache.getData(5);
        cache.prinfInfo();
    }


}
