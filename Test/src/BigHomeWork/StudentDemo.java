package BigHomeWork;

import java.io.*;
import java.util.*;

public class StudentDemo {
    //文件存放路径
    private String path = "E:\\Java\\Java光碟内容\\Code\\Try\\12\\Test\\src\\BigHomeWork\\a.txt";
    //判断是否退出系统
    private static boolean pd=true;

//    public static void main(String[] args) throws IOException {
//        while (pd) {
//            StudentDemo studentDemo = new StudentDemo();
//            //功能提示信息
//            studentDemo.Tips();
//            //功能选择
//            studentDemo.function(studentDemo);
//            //循环间隔
//            System.out.println("");
//        }
//    }

    //功能提示
    public void Tips() {
        System.out.println("欢迎使用学生信息成绩管理系统");
        System.out.println("1.查询学生信息");
        System.out.println("2.显示学生信息");
        System.out.println("3.添加学生信息");
        System.out.println("4.修改学生信息");
        System.out.println("5.删除学生信息");
        System.out.println("6.退出");
        System.out.println("请选择功能");
    }

    //功能选择
//    public void function(StudentDemo studentDemo) throws IOException {
//        switch (studentDemo.scannerInt()) {
//            //查询单个学生信息
//            case 1:
//                studentDemo.findstudent(studentDemo.path);
//                break;
//            //显示所有信息
//            case 2:
//                studentDemo.showstudent(studentDemo.path);
//                break;
//            //添加学生信息
//            case 3:
//                studentDemo.addStudent(studentDemo.path);
//                break;
//            //更新学生信息
//            case 4:
//                studentDemo.updatestudent(studentDemo.path);
//                break;
//            //删除学生信息
//            case 5:
//                studentDemo.deletestudent(studentDemo.path);
//                break;
//            //退出
//            case 6:
//                pd=false;
//                break;
//            //输入无效
//            default: {
//                System.out.println("请重新输入");
//                //再次输入
//                function(studentDemo);
//                break;
//            }
//
//        }
//    }

    //输入功能
    public int scannerInt() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        return x;
    }

    //输入学生信息
    public String scannerString() {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.next().toString();
        return x;
    }


    /*
    读数据  利用ArrayList动态数组

     */

    //显示所有学生信息
//    void showstudent(String path) throws IOException {
//        //读数据到集合中
//        ArrayList<Student> studentArrList = new ArrayList<Student>();
//        //0是判断
//        readData("0", path, studentArrList);
//        if (studentArrList.size() == 0) {
//            System.out.println("无可查询信息");
//            return;
//        }
//        print(studentArrList);
//    }

    //输出信息
//    static void print(ArrayList<Student> studentArrList) {
//        System.out.println("学号  姓名  性别  年龄  语文  数学  英语");
//        for (int i = 0; i < studentArrList.size(); i++) {
//            Student student = studentArrList.get(i);
//            System.out.println(student.getId() + "     " + student.getName() + "    " + student.getSex() + "    " + student.getAge()
//                    + "     " + student.getChineseScores() + "     " + student.getMathScores() + "     " + student.getEnglishScores());
//        }
//    }

    //查询学生信息
//    private void findstudent(String path) throws IOException {
//        System.out.println("请输入需要查找的信息(学号/姓名/年龄/某一课的成绩)");
//        //获取需要查找的信息
//        String student = scannerString();
//        ArrayList<Student> studentArrList = new ArrayList<Student>();
//        //传入非0数据
//        readData(student, path, studentArrList);
//        if (studentArrList.size() == 0) {
//            System.out.println("查无此人");
//            return;
//        }
//        print(studentArrList);
//    }

    //保存对象信息
    public static Student student(String[] str) {
        Student student = new Student();
        student.setId(str[0]);
        student.setPassword(str[1]);
        student.setName(str[2]);
        student.setAge(str[3]);
        student.setSex(str[4]);
        return student;
    }

    //将文件读入集合
    public   void readData(String onlystudnet, String path, ArrayList<Student> studentArrayList) throws IOException {
        //利用处理流提高性能
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //获取本行数据,文本文件用空格分隔数据,将数据保存在数组当中
            String[] str = line.split(" ");
            //此处使用onlystudent,是为了匹配查找学生时所输入的信息(见findstudent()方法)
            //使用默认的"0"只是为了减少代码的重复性
            if (onlystudnet.equals("0"))
                studentArrayList.add(student(str));
                //匹配学生数据
//            else if (onlystudnet.equals(str[0]) || onlystudnet.equals(str[1])
//                    || onlystudnet.equals(str[2]) || onlystudnet.equals(str[3])
//                    || onlystudnet.equals(str[4]) || onlystudnet.equals(str[5])
//                    || onlystudnet.equals(str[6]))
//                studentArrayList.add(student(str));
        }
        //记得关闭流
        bufferedReader.close();
    }

    //将集合写入文件
//    public void writeData(String path, ArrayList<Student> studentArrayList) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
//        for (int i = 0; i < studentArrayList.size(); i++) {
//            //获取对象
//            Student student = studentArrayList.get(i);
//            //使用StringBuilder提高效率
//            StringBuilder stringBuilder = new StringBuilder();
//            //获取并保存数据
//            stringBuilder.append(student.getId()).append(" ").append(student.getName()).append(" ")
//                    .append(student.getSex()).append(" ").append(student.getAge()).append(" ").append(student.getChineseScores())
//                    .append(" ").append(student.getMathScores()).append(" ").append(student.getEnglishScores());
//            //写入
//            bufferedWriter.write(stringBuilder.toString());
//            //换行
//            bufferedWriter.newLine();
//            //强制刷新
//            bufferedWriter.flush();
//        }
//    }

//    //增添学生信息
//    public void addStudent(String path) throws IOException {
//        ArrayList<Student> studentArrayList = new ArrayList<Student>();
//        readData("0", path, studentArrayList);
//        boolean flag = false;
//        String id;
//        while (true) {
//            System.out.println("请输入需要添加的学号");
//            id = scannerString();
//            //判断用户是否已经存在
//            for (int i = 0; i < studentArrayList.size(); i++) {
//                Student s = studentArrayList.get(i);
//                if (s.getId().equals(id)) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                System.out.println("用户已存在,请重新操作");
//            } else
//                break;
//        }
//        System.out.println("请输入需要添加的学生姓名");
//        String name = scannerString();
//        System.out.println("请输入需要添加的学生性别");
//        String sex = scannerString();
//        System.out.println("请输入需要添加的学生年龄");
//        int age = scannerInt();
//        System.out.println("请输入需要添加的学生语文成绩");
//        int chineseScore = scannerInt();
//        System.out.println("请输入需要添加的学生数学成绩");
//        int mathScore = scannerInt();
//        System.out.println("请输入需要添加的学生英语成绩");
//        int englishScore = scannerInt();
//        Student student = new Student();
//        student.setId(id);
//        student.setName(name);
//        student.setSex(sex);
//        student.setAge(age);
//        student.setChineseScores(chineseScore);
//        student.setMathScores(mathScore);
//        student.setEnglishScores(englishScore);
//        studentArrayList.add(student);
//        writeData(path, studentArrayList);
//        System.out.println("添加成功");
//    }

    //删除学生信息
//    private void deletestudent(String path) throws IOException {
//        ArrayList<Student> studentArrayList = new ArrayList<Student>();
//        readData("0", path, studentArrayList);
//        System.out.println("请输入要删除的学生信息(学号/姓名)");
//        String id_name = scannerString();
//        Boolean flag = false;
//        int x = 0;
//        for (int i = 0; i < studentArrayList.size(); i++) {
//            if (id_name.equals(studentArrayList.get(i).getId()) || id_name.equals(studentArrayList.get(i).getName())) {
//                flag = true;
//                x = i;
//                break;
//            }
//        }
//        if (flag) {
//            studentArrayList.remove(x);
//            //千万别忘记在写入覆盖
//            writeData(path, studentArrayList);
//            System.out.println("删除完毕");
//        } else
//            System.out.println("查无此人,请重新输入");
//    }
//
//    //修改学生信息
//    private void updatestudent(String path) throws IOException {
//        System.out.println("请输入需要修改的学生学号");
//        String s = scannerString();
//        ArrayList<Student> studentArrayList = new ArrayList<Student>();
//        readData("0", path, studentArrayList);
//        for (int i = 0; i < studentArrayList.size(); i++) {
//            System.out.println(studentArrayList.get(i).getId());
//            if (s.equals(studentArrayList.get(i).getId())) {
//                System.out.println("请输入需要修改后的学生姓名");
//                String name = scannerString();
//                System.out.println("请输入需要修改后的学生性别");
//                String sex = scannerString();
//                System.out.println("请输入需要修改后的学生年龄");
//                int age = scannerInt();
//                System.out.println("请输入需要添加的学生语文成绩");
//                int chineseScore = scannerInt();
//                System.out.println("请输入需要添加的学生数学成绩");
//                int mathScore = scannerInt();
//                System.out.println("请输入需要添加的学生英语成绩");
//                int englishScore = scannerInt();
//                studentArrayList.get(i).setId(s);
//                studentArrayList.get(i).setName(name);
//                studentArrayList.get(i).setSex(sex);
//                studentArrayList.get(i).setAge(age);
//                studentArrayList.get(i).setChineseScores(chineseScore);
//                studentArrayList.get(i).setMathScores(mathScore);
//                studentArrayList.get(i).setEnglishScores(englishScore);
//            }
//            else if(studentArrayList.size()==i) {
//                System.out.println("查无此人");
//                return;
//            }
//        }
//        writeData(path, studentArrayList);
//        System.out.println("修改完成");
//    }
}
