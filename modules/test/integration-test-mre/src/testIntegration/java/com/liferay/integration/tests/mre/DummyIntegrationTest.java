package com.liferay.integration.tests.mre;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DummyIntegrationTest {

    @ClassRule
    @Rule
    public static final TestRule injectTestRule = new LiferayIntegrationTestRule();

    @Test
    public void aaDummyFirstTest() {

    }

}
