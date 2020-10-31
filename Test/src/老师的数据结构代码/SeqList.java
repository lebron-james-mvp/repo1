    package 老师的数据结构代码;



    public class SeqList<T> extends Object
    {
        protected Object[] element;                            //对象数组，保护成员
        protected int n;
        private static final int MIN_CAPACITY=16;

        public SeqList(int length)                             //构造容量为length的空表
        {
            if(length<MIN_CAPACITY)
                length=MIN_CAPACITY;
            this.element = new Object[length];                 //申请数组的存储空间，元素为null。
            this.n = 0;
        }
        public SeqList()                                       //创建默认容量的空表，构造方法重载
        {
            this(64);                                          //调用本类已声明的指定参数列表的构造方法
        }


        public SeqList(T[] values)                            //构造顺序表，由values数组提供元素，忽略其中空对象
        {
            this(values.length*2);                             //创建2倍values数组容量的空表
            for (int i=0; i<values.length; i++)                //复制非空的数组元素。O(n)
                if (values[i]!=null)
                    this.element[this.n++] = values[i];        //对象引用赋值
        }


        public boolean isEmpty()                               //判断顺序表是否空，若空返回true，O(1)
        {
            return this.n==0;
        }

        public int size()                                      //返回顺序表元素个数，O(1)
        {
            return this.n;
        }

        public T get(int i)                                    //返回第i个元素，0≤i<n。若i越界，返回null。O(1)
        {
            if (i>=0 && i<this.n)
                return (T)this.element[i];                     //返回数组元素引用的对象，传递对象引用
            return null;
        }

        public void set(int i, T x)
        {
            if (x==null)
                throw new NullPointerException("x==null");     //抛出空对象异常
            if (i>=0 && i<this.n)
                this.element[i] = x;
            else throw new java.lang.IndexOutOfBoundsException(i+"");//抛出序号越界异常
        }

        public String toString()
        {
            String str=this.getClass().getName()+"(";          //返回类名
            if (this.n>0)
                str += this.element[0].toString();             //执行T类的toString()方法，运行时多态
            for (int i=1; i<this.n; i++)
                str += ", "+this.element[i].toString();        //执行T类的toString()方法，运行时多态
            return str+") ";                                   //空表返回()
        }

        public String toPreviousString()
        {
            return "";
        }


        public int insert(int i, T x)
        {
            if (x==null)
                throw new NullPointerException("x==null");     //抛出空对象异常
            if (i<0)       i=0;                                //插入位置i容错，插入在最前
            if (i>this.n)  i=this.n;                           //插入在最后
            Object[] source = this.element;                    //数组变量引用赋值，source也引用element数组
            if (this.n==element.length)                        //若数组满，则扩充顺序表的数组容量
            {
                this.element = new Object[source.length*2];    //重新申请一个容量更大的数组
                for (int j=0; j<i; j++)                        //复制当前数组前i-1个元素
                    this.element[j] = source[j];
            }
            for (int j=this.n-1; j>=i; j--)                    //从i开始至表尾的元素向后移动，次序从后向前
                this.element[j+1] = source[j];
            this.element[i] = x;
            this.n++;
            return i;                                          //返回x序号
        }

        public int insert(T x)                                 //顺序表尾插入x元素，返回x序号。成员方法重载
        {
            return this.insert(this.n, x);                     //插入操作中，this.n加1
        }


        public T remove(int i)          //删除第i个元素，0≤i<n，返回被删除元素。若i越界，返回null。//？？若i越界，抛出序号越界异常
        {
            if (this.n>0 && i>=0 && i<this.n)
            {
                T old = (T)this.element[i];                    //old中存储被删除元素
                for (int j=i; j<this.n-1; j++)
                    this.element[j] = this.element[j+1];       //元素前移一个位置
                this.element[this.n-1]=null;                   //设置数组元素对象为空，释放原引用实例
                this.n--;
                return old;                                    //返回old局部变量引用的对象，传递对象引用
            }
            return null;
        }

        public void clear()                                    //删除线性表所有元素
        {
            this.n=0;                                          //设置长度为0，未释放数组空间
        }

        public int search(T key)
        {
            for (int i=0; i<this.n; i++)
            {
                if (key.equals(this.element[i]))               //执行T类的equals(Object)方法，运行时多态
                    return i;
            }
            return -1;                                         //空表或未找到时
        }//不能用逐元循环，无法返回i


        public T remove(T key)                                 //删除首个与key相等元素，返回被删除元素；查找不成功返回null
        {
            return this.remove(this.search(key));              //先查找，再调用remove(i)。若查找不成功，返回-1，则不删除
        }



        public static void main(String[] args)
        {
            String[] ring= {"Allan","Bieber","Carter","Daniel","Even",};
            int insertP,number=6,start=0,distance=4;
            String[] arr= {"1","2","3","4","5","6"};
            SeqList<String> list = new SeqList<String>(arr);
            System.out.println(list.toString());               //输出顺序表的描述字符串，O(n)

            int i = start;                                     //计数起始位置
            while (list.size()>1)                              //多于一个元素时循环，计数O(1)
            {
                i = (i+distance-1) % list.size();              //按循环方式对顺序表进行遍历
                System.out.print("删除"+list.remove(i).toString()+"，");  //删除i位置对象，O(n)
                System.out.println(list.toString());
            }
            System.out.println("被赦免者编号是"+list.get(0).toString());//get(0)获得元素，O(1)
            insertP=Integer.valueOf(list.get(0))-1;
            list.clear();
            list=new SeqList<String>(ring);
            list.insert(insertP, "Frank");

            i = start;                                     //计数起始位置
            while (list.size()>1)                              //多于一个元素时循环，计数O(1)
            {
                i = (i+distance-1) % list.size();              //按循环方式对顺序表进行遍历
                System.out.print("杀死"+list.remove(i).toString()+"，");  //删除i位置对象，O(n)
                System.out.println(list.toString());
            }
            System.out.println("被赦免者是"+list.get(0).toString());//get(0)获得元素，O(1)

        }
    }

