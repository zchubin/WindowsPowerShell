// filename:App3_4.java
import java.io.*;
public class App3_4{
    public static void main(String[] args) throws IOException{
        float num;
        String str;
        BufferedReader buff;
        buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个实数:");
        str = buff.readLine();
        num = Float.parseFloat(str);
        System.out.println("你输入的是:"+num);
    }
}
