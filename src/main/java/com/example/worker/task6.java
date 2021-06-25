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
@ExternalTaskSubscription(topicName = "test-topic-name6")
public class task6 implements ExternalTaskHandler {
    @Autowired
    FeignL feignLong;
//    @Autowired
//      Feign feign;
    @Override
    public void execute(ExternalTask task, ExternalTaskService service){
//        feignLong.hoursincrease(task1.name, 10000);
        List<LinkedHashMap> res = feignLong.findbyname(task1.name);
        int salary = (int) res.get(0).get("salary");
        double newsalary = (double) salary * 0.90;
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("taxsalary", newsalary);
        service.complete(task, variables);



        service.complete(task);
    }
}
