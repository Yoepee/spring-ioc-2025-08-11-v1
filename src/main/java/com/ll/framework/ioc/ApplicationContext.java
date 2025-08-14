package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    public ApplicationContext() {

    }

    @SuppressWarnings("unchecked")
    public <T> T genBean(String beanName) {
        if ("testPostService".equalsIgnoreCase(beanName)) {
            return (T) TestPostService.getInstance();
        }

        if ("testPostRepository".equalsIgnoreCase(beanName)) {
            return (T) TestPostRepository.getInstance();
        }

        if ("testFacadePostService".equalsIgnoreCase(beanName)) {
            return (T) new TestFacadePostService(
                    TestPostService.getInstance(),
                    TestPostRepository.getInstance()
            );
        }

        return null;
    }
}
