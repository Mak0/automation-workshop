package com.kolotilkin.website.suites;

import com.kolotilkin.website.tests.LoginTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        LoginTests.class
})

@RunWith(Suite.class)
public class RegressionSuite {
}
