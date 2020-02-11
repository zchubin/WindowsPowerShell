/* filename:App3_3.java */
import java.io.*;
public class App3_3{
    public static void main(String[] args) throws IOException{
        BufferedReader buff; /* 声明buff为BuffereadReader类的变量，该类在java.io类中 */
        String str;

        buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入字符串: ");
        str = buff.readLine(); /* 用readLine()方法读入字符串存入str中，且需处理IOExcpetion异常 */
        System.out.println("您输入的字符串是:"+str);
    }
}
