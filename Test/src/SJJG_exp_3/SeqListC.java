package SJJG_exp_3;



class Node1<T>{
    public T data;
    public Node<T>next;
    public Node1(T data,Node<T>next) {
        this.data=data;
        this.next =next;
    }
    public Node1() {
        this(null,null);
    }
    public String toString() {
        return this.data.toString();
    }
}
public class SeqListC<T> {

    public Node<T>head;

    public SeqListC() {
        this.head=new Node<T>();
    }

    public SeqListC(T[] values) {
        this();
        Node<T> temp =this.head ;
        for(int i=0;i<values.length ;i++) {
            if(values[i]!=null) {
                temp.next=new Node<T>(values[i],null);
                temp = temp.next;
            }
        }
    }
    public SeqListC(SeqListC<T> list) {
        this();
        Node<T> p = list.head.next;
        Node<T>[] B = new Node[(list).size()];
        for(int i = 0; i < list.size(); i++) {
            B[i] = new Node<T>();
            B[i].data = p.data;
            p = p.next;
        }
        Node<T> front = this.head;
        for(int j = 0; j < list.size(); j++) {
            front.next = B[j];
            front = front.next;
        }

    }

    public int size()
    {
        int i=0;
        for (Node<T> p=this.head.next;  p!=null;  p=p.next)
            i++;
        return i;
    }


    public T get(int i)
    {
        Node<T> p =this.head.next;

        for(int j=0;p!=null&&j<i;j++)
            p=p.next;
        return   (i>=0 && p!=null)?p.data:null;
    }



    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");
        Node<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;
        else throw new IndexOutOfBoundsException(i+"");
    }


    public String toString()
    {
        String str="";
        for (Node<T> p=this.head.next;  p!=null;  p=p.next)
        {   str+=p.data.toString();
            if (p.next!=null)
                str += ",";
        }
        return str;
    }

    public static void main(String[] args) {
        String[] values = { "Allan", "Bieber", "Carter", "Daniel", "Even" };
        SeqListC<String> lista = new SeqListC<String>(values);
        SeqListC<String> listb = new SeqListC<String>(lista);
        System.out.println("线性表进行浅拷贝之前：");

        System.out.println("SeqListA = " + lista.toString());
        System.out.println("SeqListC = " + listb.toString());
        lista.set(3, "David");

        System.out.println("顺序表进行浅拷贝后的变化：");
        System.out.println("SeqListA = " + lista.toString());
        System.out.println("SeqListB= " + listb.toString());
    }

}