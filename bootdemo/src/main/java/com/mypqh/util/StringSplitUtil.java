package com.mypqh.util;

import com.mypqh.common.Constant;

public class StringSplitUtil {
    private static int NUM1 = 1;

    //长字符串内容拆分
    public static StringBuffer splitStr(String content) {
        int cout = 0;
        StringBuffer buffer = new StringBuffer();
        String[] temp = content.split(",");
        for (int i = 0; i < temp.length; i++) {
            buffer.append(temp[i]);
            buffer.append(",");
            cout++;
            if (cout == Constant.EIGHT * NUM1) {//每八个换行
                buffer.append("\r\n");
                NUM1++;
            }
        }

        return buffer;
    }

    public static StringBuffer splitStr(String content, int bit) {
        int cout = 0;
        StringBuffer buffer = new StringBuffer();
        String[] temp = content.split(",");
        for (int i = 0; i < temp.length; i++) {
            buffer.append(temp[i]);
            buffer.append(",");
            cout++;
            if (cout == bit * NUM1) {//每bit个换行
                buffer.append("\r\n");
                NUM1++;
            }
        }

        return buffer;
    }

}
