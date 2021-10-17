package com.mypqh.util;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    //从文件中逐行读取内容
    private static synchronized List<String> getFileContent(String fileSuffix) {
        List<String> list = new ArrayList<>();
        URL url = FileUtil.class.getResource(fileSuffix);
        try {

            FileReader reader = new FileReader(url.getPath());
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            //            System.out.println(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //内容拆取字符串
    public static List<String> getFileString(String fileSuffix) {
        List<String> list = getFileContent(fileSuffix);
        List<String> strList = new ArrayList<String>();

        // 解析到每行list再插入strList
        for (String nameTemp : list) {
            if (nameTemp.contains("，")) {
                String[] name = nameTemp.split("，");
                strList.addAll(Arrays.asList(name));
            } else {
                for (int i = 0; i < nameTemp.length(); i++) {
                    String name = String.valueOf(nameTemp.charAt(i));
                    strList.add(name);
                }
            }
        }
        return strList;
    }

    public static String getArticle(String fileSuffix) {
        List<String> list = getFileContent(fileSuffix);
        StringBuffer buffer = new StringBuffer();

        // 解析到每行list再插入strList
        for (String content : list) {
            if (content.contains("正文")) {
                buffer.append("<h3>");
                buffer.append(content);
                buffer.append("</h3>");
            } else {
                buffer.append("<p>");
                buffer.append(content);
                buffer.append("</p>");
            }
        }
        return buffer.toString();
    }

    public static synchronized void writeStrToFile(String fileSuffix, String content) {
        FileWriter writer = null;
        URL url = null;
        File file;
        String filePath = FileUtil.class.getClassLoader().getResource("").getPath();
        filePath = filePath + fileSuffix;
//        System.out.println(filePath);
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            url = FileUtil.class.getResource(fileSuffix);
            writer = new FileWriter(url.getPath(), true);
            StringBuffer contentForm = StringSplitUtil.splitStr(content);
            writer.write(contentForm.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

