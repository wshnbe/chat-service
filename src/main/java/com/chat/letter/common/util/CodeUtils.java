package com.chat.letter.common.util;

import java.util.UUID;

/**
 * 编号生成功能
 */
public class CodeUtils {

    public static String getOrderIdByUUId(int userId) {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        return userId + String.valueOf(hashCodeV);
    }
}
