package com.kolotilkin.website.base;

public abstract class AuthenticatedWordpressTestBase extends WordpressTestBase {

    @Override
    protected void beforeTest() {
        super.beforeTest();

        System.out.println("Authenticating admin");
    }
}
