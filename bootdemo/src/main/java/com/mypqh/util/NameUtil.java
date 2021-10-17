package com.mypqh.util;

import com.mypqh.common.Constant;

import java.util.*;

public class NameUtil {
    private static String nameFileSuffix = "/file/name.txt";
    private static String fullFileSuffix = "/file/generate.txt";
    private static String generateNameSuffix = "/file/fullname.txt";
    private static String surnameFileSuffix = "/file/surname.txt";
    private static String novelistSuffix = "/file/novelist.txt";
    private static String copySuffix = "/file/copy.txt";
    private static int NUM1 = 1;

    //获取姓
    private static List<String> getSurname() {
        return FileUtil.getFileString(surnameFileSuffix);
    }

    //随即获取姓
    private static List getSurnameRandom(int bit) {
        List list = getSurname();
        List surlist = new ArrayList();
        if (list.isEmpty()) {
            surlist.add("there's no surname!");
        }
        Object[] surnameArr = list.toArray();
        Random r = new Random();
        for (int i = Constant.ZERO; i < bit; i++) {
            int num = r.nextInt(surnameArr.length);
            if (!surnameArr[num].equals("")) {
                surlist.add(surnameArr[num]);
            }
        }
//        System.out.println(surlist.toString());
        return surlist;
    }

    //生成名字
    public static StringBuffer generateName() {

        Object[] firstName = getSurnameRandom(Constant.EIGHT).toArray();
//        System.out.println(Arrays.toString(firstName));
        List<String> nameList = FileUtil.getFileString(nameFileSuffix);
        StringBuffer nameAll = new StringBuffer();
        if (nameList.isEmpty()) {
            nameAll.append("there's no  name!");
            return nameAll;
        }
        Object[] name = nameList.toArray();

        for (int i = Constant.ZERO; i < firstName.length; i++) {
            for (int j = Constant.ZERO; j < name.length; j++) {
                if (nameAll == null) {
                    nameAll.append(",");
                }
                nameAll.append(firstName[i].toString() + name[j]);
                nameAll.append(",");
            }
        }
        return nameAll;
    }

    //利用输入生成姓名
    public static StringBuffer generateName(String firstName) {
        List<String> nameList = FileUtil.getFileString(nameFileSuffix);
        StringBuffer nameAll = new StringBuffer();
        if (nameList.isEmpty()) {
            nameAll.append("there's no name!");
            System.out.println("nameList is empty");
            return nameAll;
        }
        Object[] name = nameList.toArray();

        for (Object s : name) {
            if (nameAll == null) {
                nameAll.append(",");
            }
            nameAll.append(firstName + s);
            nameAll.append(",");
        }
        FileUtil.writeStrToFile(generateNameSuffix, nameAll.toString());
        return nameAll;
    }

    //生成的姓名处理后存进map中
    public static Map getNameMap(String[] nameArr, int N) {
        Map<String, Object> map = new HashMap<>();

        if (nameArr.length == Constant.ZERO) {
            map.put("list", "get Name failed");
            return map;
        }
        List<String> list;
        int cut;
        if (nameArr.length > N) {
            cut = nameArr.length / N;
        } else {
            cut = nameArr.length;
        }


        for (int i = Constant.ONE; i <= N; i++) {
            int temp = i;
            if (i * cut <= nameArr.length) {
                list = Arrays.asList(Arrays.copyOfRange(nameArr, (i - Constant.ONE) * cut, i * cut));

                map.put("list" + temp + "", list);
            }
        }

        return map;
    }

    //随机获取全名
    public static StringBuffer getRandomFullName(int bit) {
        List<String> nameList = FileUtil.getFileString(fullFileSuffix);
        StringBuffer sb = new StringBuffer();
        if (nameList.isEmpty()) {
            sb.append("there's no full name!");
            return sb;
        }
        Object[] nameArr = nameList.toArray();
        int cout = 0;
        Random r = new Random();
        for (int i = Constant.ZERO; i < bit; i++) {
            int num = r.nextInt(nameArr.length);
            if (nameArr[num].equals("")) {
                sb.append("<br/>");
            } else {
                sb.append("<");
                sb.append(nameArr[num]);
                sb.append(">");
                cout++;
                if (cout == Constant.EIGHT * NUM1) {//每八个添加一个字符用于前端平均分
                    sb.append("t");
                    NUM1++;
                }
            }
        }
        return sb;
    }

    //生成账号名
    public static String generateCountName(String name) {
        String num = String.valueOf(Constant.ONE);
        name = name.substring(Constant.ZERO, Constant.ONE) + "px" + num;
        return name;
    }

    //生成密码1
    public static String getPass() {
        String password;
        StringBuffer psw = new StringBuffer();
        String enB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String enS = "abcdefghijklmnopqrstuvwxyz";
        String num = "1234567890";
        String oth = "#*@";
        char[] enBchar = enB.toCharArray();
        char[] enSchar = enS.toCharArray();
        char[] numchar = num.toCharArray();
        char[] othchar = oth.toCharArray();
        String enBR = RandomUtil.getRandomStr(enBchar, Constant.THREE);
        String enSR = RandomUtil.getRandomStr(enSchar, Constant.THREE);
        String numR = RandomUtil.getRandomStr(numchar, Constant.TWO);
        String othR = RandomUtil.getRandomStr(othchar, Constant.ONE);
        if (psw == null) {
            psw.append("0");
        }
        psw.append(enBR);
        psw.append(enSR);
        psw.append(numR);
        psw.append(othR);
        password = psw.toString();
        return password;
    }

    //生成密码2
    public static StringBuffer getPassword() {

        StringBuffer psw = new StringBuffer();
        String en = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String num = "1234567890";
        String fu = "#*@";
        char[] enchar = en.toCharArray();
        char[] numchar = num.toCharArray();
        char[] fuchar = fu.toCharArray();
        for (int i = Constant.ZERO; i < Constant.THREE; i++) {
            int a = RandomUtil.getRandom(Constant.TEN);
            int b = RandomUtil.getRandom(Constant.THREE);
            psw.append(enchar[a]);
            psw.append(numchar[b]);
        }
        int c = RandomUtil.getRandom(Constant.ONE);
        psw.append(fuchar[c]);

        return psw;
    }

    public static String generateArticle() {
//    public static void generateArticle() {
        String content = FileUtil.getArticle(novelistSuffix);
//        FileUtil.writeStrToFile(copySuffix,content);
        return content;
    }
}

