package com.kolotilkin.website.base;

import com.kolotilkin.infrastructure.base.TestBase;
import com.kolotilkin.website.WordpressSite;

public abstract class WordpressTestBase extends TestBase {

    protected WordpressSite site;

    @Override
    protected void beforeTest() {
        System.out.println("Opening website");
        site = new WordpressSite(webDriver);
        site.open();
    }
}
