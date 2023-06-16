package com.kolotilkin.website.base;

import com.kolotilkin.infrastructure.base.TestBase;
import com.kolotilkin.website.WordpressSite;

public class WordpressTestBase extends TestBase {

    protected WordpressSite site;

    @Override
    protected void beforeTest() {
        site = new WordpressSite(webDriver);
    }
}
