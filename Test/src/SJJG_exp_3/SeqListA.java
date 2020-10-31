package SJJG_exp_3;

public  class  SeqListA{
    public static void main(String[] args) {


    String[] values = { "Allan", "Bieber", "Carter", "Daniel", "Even" };
    SY3_1<String> lista = new SY3_1<String>(values);
    SY3_1<String> listb = new SY3_1<String>(lista);
        System.out.println("顺序表进行浅拷贝之前：");

        System.out.println("SeqListA的值是： " + lista.toString());
        System.out.println("SeqListB的值是：" + listb.toString());
        lista.set(3, "David");

        System.out.println("顺序表进行浅拷贝后的变化：");
        System.out.println("SeqListA = " + lista.toString());
        System.out.println("SeqListB= " + listb.toString());


        System.out.println("---------------------------------------------");
        String[] values1  = { "Allan", "Bieber", "Carter", "Daniel", "Even" };
        SY3_2<String> lista1 = new SY3_2<String>(values1);
        SY3_2<String> listb1 = new SY3_2<String>(lista1);
        System.out.println("顺序表进行深拷贝之前：");

        System.out.println("SeqListA = " + lista1.toString());
        System.out.println("SeqListC = " + listb1.toString());
        lista1.set(3, "David");

        System.out.println("顺序表进行深拷贝后的变化：");
        System.out.println("SeqListA = " + lista1.toString());
        System.out.println("SeqListB= " + listb1.toString());
        }
}

class SY3_1<T> {

    private int n;
    private Object[] element;

    public SY3_1(int element) {
        this.element = new Object[element];
        this.n = 0;
    }

    public SY3_1(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.element[i] = values[i];
        }
        this.n = element.length;
    }

    public SY3_1(SY3_1<T> list) {
        this.n = list.n;
        this.element =list.element;
    }



    public T get(int i) {
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }


    public void set(int i, T x) {
        if (x == null) {
            throw new NullPointerException("x不存在");
        }
        if (i >= 0 && i < this.n) {
            this.element[i] = x;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public String toString() {
        String str = "";
        if (this.n > 0) {
            str = this.element[0].toString();
            for (int i = 1; i < this.n; i++) {
                str += "," + this.element[i].toString();
            }
        }
        return str;
    }


}

class SY3_2<T> {

    private int n;
    private Object[] element;


    public SY3_2(int element) {
        this.element = new Object[element];
        this.n = 0;
    }

    public SY3_2(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.element[i] = values[i];
        }
        this.n = element.length;
    }

    public SY3_2(SY3_2<T> list) {
        this.n = list.n;
        this.element = new Object[list.element.length];
        for (int i = 0; i < list.n; i++) {
            this.element[i] = list.element[i];
        }
    }


    public T get(int i) {
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }


    public void set(int i, T x) {
        if (x == null) {
            throw new NullPointerException("x==null");
        }
        if (i >= 0 && i < this.n) {
            this.element[i] = x;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }



    public String toString() {
        String str = "";
        if (this.n > 0) {
            str = this.element[0].toString();
            for (int i = 1; i < this.n; i++) {
                str += "," + this.element[i].toString();
            }
        }
        return str;
    }


}


