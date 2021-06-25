package com.example.worker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;

@FeignClient(name = "elastic-client", url = "http://localhost:8081")
public interface FeignL{
    @RequestMapping(method = RequestMethod.GET, value = "/persons/findbyname")
    List<LinkedHashMap> findbyname(@RequestParam("name") String name);
}
