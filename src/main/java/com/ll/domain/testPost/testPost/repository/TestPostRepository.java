package com.ll.domain.testPost.testPost.repository;

public class TestPostRepository {

    private TestPostRepository() { }

    private static class InstanceHolder {
        private static final TestPostRepository INSTANCE = new TestPostRepository();
    }

    public static TestPostRepository getInstance() {
        return InstanceHolder.INSTANCE;
    }
}