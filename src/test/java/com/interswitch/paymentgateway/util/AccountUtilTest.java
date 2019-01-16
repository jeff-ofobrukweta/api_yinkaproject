package com.interswitch.paymentgateway.util;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AccountUtilTest {
    @Test
    public void  TestGenerateAccountNo(){
    assertThat(AccountUtil.generateAccountNo(10)).hasSize(10);
    }
}
