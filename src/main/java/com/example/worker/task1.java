package com.example.worker;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@EnableFeignClients
@Component
@ExternalTaskSubscription(topicName = "test-topic-name1")
public class task1 implements ExternalTaskHandler {
    public static String position;
    public static String name;
    @Autowired
    FeignL feignLong;
    @Override
    public void execute(ExternalTask task, ExternalTaskService service){

        name = (String) task.getVariable("name");
        List<LinkedHashMap> res = feignLong.findbyname(name);
        position = (String) res.get(0).get("position");
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("position", position);
        service.complete(task, variables);

    }
}