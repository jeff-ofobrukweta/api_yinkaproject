package com.interswitch.paymentgateway.util;

import java.util.Random;

public class AccountUtil {
    public static   String generateAccountNo(int numDigits){
        int i = 0;
        String accountNo="";
        Random random = new Random();
        while(i <numDigits){
            int num = random.nextInt(10);
            accountNo += String.valueOf(num);
            i++;
        }
        return  accountNo;
    }

    public static void main(String[] args) {
        AccountUtil.generateAccountNo(10);

    }
}
