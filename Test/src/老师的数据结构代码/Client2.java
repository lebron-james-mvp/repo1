package 老师的数据结构代码;



public class Client2 {
    public static void main(String[] args)
    {
        String[] ring= {"Allan","Bieber","Carter","Daniel","Even"};
        int distance=4;
        String lastName;
        Node<String> removeP = null,p;

        SinglyList<String> list = new SinglyList<String>(ring);
        list.insert2(list.head.next, "Frank");
        list.n++;
        System.out.println("测试顺序"+list.toString());
        p=list.head.next;

        int count;
        while(list.n>0)
        {
            for(count=0;count<distance;count++)
            {
                if(p.next==null)
                    p=list.head.next;
                else
                    p=p.next;
                if(count==distance-2)
                    removeP=p;
            }
            System.out.print("杀死"+list.remove2(removeP).toString()+"，");
            System.out.println(list.toString());
            list.n--;
        }
        lastName=removeP.data;

        list.clear();
        list = new SinglyList<String>(ring);
        list.insert2(list.search(lastName).next,"Frank");
        list.n++;
        System.out.println("最终顺序"+list.toString());
    }
}
