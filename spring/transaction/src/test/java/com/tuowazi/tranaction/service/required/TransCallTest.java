package com.tuowazi.tranaction.service.required;

import com.tuowazi.tranaction.mapper.UserMapper;
import com.tuowazi.tranaction.service.BaseTransTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author zhangweixiao - 19-3-28
 */
@ActiveProfiles(value = "required")
public class TransCallTest extends BaseTransTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Override
    public void nonTransTest() {
        super.nonTransTest();
        assertEqual(userMapper.selectAll().size(), 2);
    }

    @Test
    @Override
    public void requiredTransTest() {
        super.requiredTransTest();
        assertEqual(userMapper.selectAll().size(), 2);

    }

    @Test
    @Override
    public void requiredNewTransTest() {
        super.requiredNewTransTest();
        assertEqual(userMapper.selectAll().size(), 2);
    }

    @Test
    @Override
    public void nestedTransTest() {
        super.nestedTransTest();
        assertEqual(userMapper.selectAll().size(), 2);
    }

    @Test
    @Override
    public void supportsTransTest() {

        super.supportsTransTest();
        assertEqual(userMapper.selectAll().size(), 2);
    }

    @Test
    @Override
    public void notSupportedTransTest() {

        super.notSupportedTransTest();
        assertEqual(userMapper.selectAll().size(), 2);
    }

    @Test
    @Override
    public void neverTransTest() {

        super.neverTransTest();
        assertEqual(userMapper.selectAll().size(), 2);
    }

    @Test
    @Override
    public void manadatoryTransTest() {
        super.manadatoryTransTest();
        assertEqual(userMapper.selectAll().size(), 2);
    }


}
