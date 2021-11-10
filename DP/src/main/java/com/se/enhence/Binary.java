package com.se.enhence;

/**
 * 二进制
 * 二进制使用最高位表示符号位，用1表示负数，用0表示正数。<br/>
 * byte、short、int、long，分别占1、2、4、8个字节，即分别占8、16、32、64位<br/>
 * byte a = -1 <br/>
 * a的二进制是：11,111,111（补码表示法）<br/>
 * 补码 = 原码取反+1  10,000,001 取反=11,111,110 +1 = 11,111,111 符号位不变<br/>
 */
public class Binary {
    public void fun1() {
        // 正数的原反补一样
        // Integer.MAX_VALUE = (2^32) - 1
        // 0 1 1 1 1 ... 1 1 1
        // 0 1 1 1 1 ... 1 1 1
        // 1 1 1 1 1 ... 1 1 0 ==> 补码
        // 最高位为-1,所以是负数。负数补码-->原码
        // 取反+1 (符号位变嘛)
        //  1 0 0 0 ... 0 0 1
        //                + 1
        //  1 0 0 0 ... 0 1 0
        long a = Integer.MAX_VALUE * 2;


        System.out.println(a);
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
        binary.fun1();
    }
}
