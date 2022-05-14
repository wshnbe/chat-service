package com.chat.letter.common.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名称生成工具，防止文件名称重复
 */
public class FileNameUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");

    /**
     * 文件名称生成器：userId+时分秒毫秒+下标
     * @param userId
     * @param index
     * @return
     */
    public static String getFileName(int userId,int index){
        return userId+"-"+index+sdf.format(new Date());
    }

    /**
     * 保存文件路径
     * @param userId
     * @param uploadPath
     * @return
     */
    public static String getFilePath(int userId,String uploadPath){
        return uploadPath+userId+"/";
    }

    /**
     * apk版本号
     * apk示例：xxx_1.2.3
     * 获取：1.2.3 并转换成 123
     * @param apkName
     * @return
     */
    public static Integer getVersionCode(String apkName){
        if(!StringUtils.isEmpty(apkName)){
            String tmp[] = apkName.split("_");
            String version = tmp[1].replace(".","").replace("apk","");
            return Integer.parseInt(version);
        }
        return null;
    }

    /**
     * 字符串转换：1.2.3
     * 获取：1.2.3 并转换成 123
     * @param version
     * @return
     */
    public static Integer getLastVersionCode(String version){
        if(!StringUtils.isEmpty(version)){
            version = version.replace(".","");
            return Integer.parseInt(version);
        }
        return null;
    }
}
