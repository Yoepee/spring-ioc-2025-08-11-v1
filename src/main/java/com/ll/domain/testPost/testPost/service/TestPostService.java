package com.ll.domain.testPost.testPost.service;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import lombok.RequiredArgsConstructor;

public class TestPostService {
    private final TestPostRepository testPostRepository;

    private TestPostService(TestPostRepository testPostRepository) {
        this.testPostRepository = testPostRepository;
    }

    private static class InstanceHolder {
        private static final TestPostService INSTANCE = new TestPostService(TestPostRepository.getInstance());
    }

    public static TestPostService getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
