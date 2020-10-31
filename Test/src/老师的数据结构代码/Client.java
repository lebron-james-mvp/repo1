package 老师的数据结构代码;



public class Client {
    public static void main(String[] args)
    {
        String[] ring= {"Allan","Bieber","Carter","Daniel","Even"};
        int insertP,number=6,start=0,distance=4;
        String[] arr= {"1","2","3","4","5","6"};
        SinglyList<String> list = new SinglyList<String>(arr);
        System.out.println(list.toString());               //输出顺序表的描述字符串，O(n)？

        int i = start;                                     //计数起始位置
        while (list.size()>1)                              //多于一个元素时循环，计数O(1)？
        {
            i = (i+distance-1) % list.size();              //按循环方式对顺序表进行遍历
            System.out.print("删除"+list.remove(i).toString()+"，");  //删除i位置对象，O(n)？
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是"+list.get(0).toString());//get(0)获得元素，O(1)？
        insertP=Integer.valueOf(list.get(0))-1;
        list.clear();
        list=new SinglyList<String>(ring);
        list.insert(insertP, "Frank");

        i = start;                                     //计数起始位置
        while (list.size()>1)                              //多于一个元素时循环，计数O(1)？
        {
            i = (i+distance-1) % list.size();              //按循环方式对顺序表进行遍历
            System.out.print("杀死"+list.remove(i).toString()+"，");  //删除i位置对象，O(n)？
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是"+list.get(0).toString());//get(0)获得元素，O(1)？

    }

}
