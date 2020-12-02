package socket;

import java.util.Scanner;

public class test {

    /**
     * @zhj
     */
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入：");
        String s1 = scanner .next();
        char cs[] = s1.toCharArray();
        String str2="";
        for(int i=0;i<s1.length();i++)
        {

            if(Character.isUpperCase(cs[i]))
            {
                System.out.println("第"+(i+1)+"个字符是大写字母");
            }else if(Character.isLowerCase(cs[i]))
            {
                System.out.println("第"+(i+1)+"个字符是小写字母");
            }else if(Character.isDigit(cs[i]))
            {
                System.out.println("第"+(i+1)+"个字符是数字");
            }else if(19968 <= cs[i] &&cs[i] <40623)
            {
                System.out.println("第"+(i+1)+"个字符是中文");
            }

        }



    }
}