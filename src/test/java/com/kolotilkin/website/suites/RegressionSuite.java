package com.kolotilkin.website.suites;

import com.kolotilkin.website.tests.AdminDashboardTests;
import com.kolotilkin.website.tests.LoginTests;
import com.kolotilkin.website.tests.PagesTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        PagesTests.class,
        LoginTests.class,
        AdminDashboardTests.class
})

@RunWith(Suite.class)
public class RegressionSuite {
}
