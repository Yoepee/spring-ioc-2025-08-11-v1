package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private final Map<String, Object> beans = new HashMap<>();

    public ApplicationContext() {
    }

    @SuppressWarnings("unchecked")
    public <T> T genBean(String beanName) {
        if (beans.containsKey(beanName)) {
            return (T) beans.get(beanName);
        }

        Object bean = switch (beanName) {
            case "testPostRepository" ->
                    new TestPostRepository();
            case "testPostService" ->
                    new TestPostService(genBean("testPostRepository"));
            case "testFacadePostService" ->
                    new TestFacadePostService(
                        genBean("testPostService"),
                        genBean("testPostRepository"));
            default -> null;
        };

        beans.put(beanName, bean);
        return (T) bean;
    }
}
