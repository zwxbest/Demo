package com.tuowazi.tranaction.service;

import com.tuowazi.tranaction.TxApplication;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangweixiao - 19-3-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TxApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Ignore
public class BaseTest {

    protected <T> void assertEqual(T actual, T operand) {
        Assert.assertThat(actual, IsEqual.equalTo(operand));
    }
}
