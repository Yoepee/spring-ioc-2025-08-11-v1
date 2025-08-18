package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;

public class ApplicationContext {
    private static HashMap<String, Object> beanMap = new HashMap<>();

    public ApplicationContext() {
    }

    public <T> T genBean(String beanName) {
        if (beanMap.containsKey(beanName)) {
            return (T) beanMap.get(beanName);
        }

        Object bean = switch (beanName) {
            case "testPostRepository" -> new TestPostRepository();
            case "testPostService" -> new TestPostService(genBean("testPostRepository"));
            case "testFacadePostService" ->
                    new TestFacadePostService(genBean("testPostService"), genBean("testPostRepository"));
            default -> null;
        };

        if (bean == null) return null;

        beanMap.put(beanName, bean);
        return (T) bean;
    }
}
