package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final Map<String, Object> beans = new HashMap<>();

    public ApplicationContext() {
        // 생성자: 여전히 빈 로직
    }

    public <T> T genBean(String beanName) {

        if (beans.containsKey(beanName)) {
            return (T) beans.get(beanName);
        }

        Object bean = null;
        if (beanName.equals("testPostRepository")) {
            bean = new TestPostRepository();
        } else if (beanName.equals("testPostService")) {
            TestPostRepository repo = genBean("testPostRepository");
            bean = new TestPostService(repo);
        }

        if (bean != null) {
            beans.put(beanName, bean);
        }

        return (T) bean;
    }
}