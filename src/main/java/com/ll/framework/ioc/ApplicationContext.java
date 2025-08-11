package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private static TestPostService testPostService;
    private static TestPostRepository testPostRepository;
    private static TestFacadePostService testFacadePostService;

    public ApplicationContext() {}

    public <T> T genBean(String beanName) {
        // beanName에 따라 해당 빈을 반환
        switch (beanName) {
            case "testPostService":
                if (testPostService == null) {
                    testPostService = new TestPostService(
                            genBean("testPostRepository")
                    );
                }
                return (T) testPostService;

            case "testPostRepository":
                if (testPostRepository == null) {
                    testPostRepository = new TestPostRepository();
                }
                return (T) testPostRepository;

            case "testFacadePostService":
                if (testFacadePostService == null) {
                    testFacadePostService = new TestFacadePostService(
                            genBean("testPostService"),
                            genBean("testPostRepository")
                    );
                }
                return (T) testFacadePostService;
            default:
                return null;
        }
    }
}
