package BigHomeWork;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Login {

    private static String path = "E:\\Java\\Java光碟内容\\Code\\Try\\12\\Test\\src\\BigHomeWork\\a.txt";


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String id = sc.next();
        System.out.println("请输入密码");
        String ps = sc.next();
        CheckLogin(id,ps);

    }
  public static void CheckLogin(String id, String password) throws IOException {
      boolean flag=false;
        ArrayList<Student> studentArrList = new ArrayList<Student>();
        new StudentDemo().readData("0", path, studentArrList);
        for (int i = 0; i < studentArrList.size(); i++) {
            if (studentArrList.get(i).getId().equals(id)&&studentArrList.get(i).getPassword().equals(password)) {
              flag=true;
              break;
            } else {
              flag=false;
            }

        }
       if(flag){
           System.out.println("登录成功");
       }
       else {
           System.out.println("登录失败");
       }

    }
}
