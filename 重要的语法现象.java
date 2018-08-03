*****
* 1 *
*****
public static void main(String[] args) {

        // command-line arguments
        int n = Integer.parseInt(args[0]);

        // for backward compatibility with Intro to Programming in Java version of RandomSeq
        if (args.length == 1) {
            // generate and print n numbers between 0.0 and 1.0
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform();
                StdOut.println(x);
            }
        }

        else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);

            // generate and print n numbers between lo and hi
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform(lo, hi);
                StdOut.printf("%.2f\n", x);
            }
        }

        else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
	
*****
* 2 * Date类的两种构造函数：
*****	
	 public Date(int month, int day, int year) {
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
        this.month = month;
        this.day   = day;
        this.year  = year;
    }

    /**
     * Initializes new date specified as a string in form MM/DD/YYYY.
     * @param date the string representation of this date
     * @throws IllegalArgumentException if this date is invalid
     */
    public Date(String date) {
        String[] fields = date.split("/");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid date");
        }
        month = Integer.parseInt(fields[0]);
        day   = Integer.parseInt(fields[1]);
        year  = Integer.parseInt(fields[2]);
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
    }
	
	
*****
* 3 * Object类，equals()方法的重载
*****	
	@Override
    public boolean equals(Object other) 
	{
        if (other == this) return true;       //该对象的引用与参数对象相同，则返回True
        if (other == null) return false;      // 参数为空，则返回false
        if (other.getClass() != this.getClass()) return false;    // 两个对象的类不相同，则返回False
        Date that = (Date) other;      // 将参数对象从Object类转化为Date
        return (this.month == that.month) && (this.day == that.day) && (this.year == that.year);   //逐个判断变量值，不同则返回False
    }
	
	

*****
* 4 *  标准输入
*****
	public static void main(String[] args) { 
        int count = 0;       // number input values
        double sum = 0.0;    // sum of input values

        // read data and compute statistics
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            count++;
        }
		 // compute the average
        double average = sum / count;

        // print results
        StdOut.println("Average is " + average);
    }

		
*****
* 5 *  In库的使用（文件或者URL输入）
*****

public static int[] readInts(String name)
{
	In in = new In(name);

	Queue<Integer> q = new Queue<Integer>();

	while(!in.isEmpty())
		q.enqueue(in.readInt());

	int N = q.size();
	int[] a = new int[N];

	for(i=0;i<N;i++)
		a[i] = q.dequeue();

	return a;
}

*****
* 6 *  标准输入/输出（StdIn，StdOut）
*****
public class Average
{
	public static void main(String[] args)
	{
		double sum = 0;
		int cnt = 0;
		while(!StdIn.isEmpty())
		{
			sum += StdIn.readDouble();
			cnt++;
		}
		double aver = sum/cnt;
		StdOut.print("Average is %.2f\n",aver);
		
	}
}

*****
* 7 *  怎么使得一个类可迭代
*****
（1） 在类的声明中添加 implements Iterable<Item>,对应接口为（java.lang.Iterable）
（2） 添加方法 iterator():用于返回一个iterator（迭代器）
      public Iterator<Item> iterator()
	  {
		  return new ReverseArrayIterator();
	  }
（3） 自己新建一个ReverseArrayIterator类(Nested Class)
	  public class ReverseArrayIterator implements Iterator<Item>
	  {
		  public void remove(){};
		  public Item next(){};
		  public boolean hasNext(){};		  
	  }

	  
*****
* 8 *  声明一个Stack类型的数组
*****
Stack<String>[] a = (Stack<String>[])new Stack[N]


*****
* 9 *  在创建自己的数据类型时，如何实现Comparable接口
*****

public class Date implements Comparable<Date>
{
	private final int day;
	private final int month;
	private final int year;

	public Date(int d, int m, int y)
	{
		day = d;
		month = m;
		year = y;
	}  

	public int day() {return day;}
	public int month() {return month;}
	public int year() {return year;}

	public int compareTo(Date that)
	{
		if(this.year > that.year) return +1;
		if(this.year < that.year) return -1;
		if(this.month > that.month)  return +1;
		if(this.month < that.month)  return -1;
		if(this.day > that.day)  return +1;
		if(this.day < that.day)   return -1;

		return 0;
	}

	public String toString()
	{
		return month+"/"+day+"/"+year;
	}
}

*****
*10 *  i++ 和 ++i的区别
*****
 在编程中i++和++i最终是一样的，不过在循环体中，i++是先取出i，再加1，＋＋i先加后取
 
******
* 11 *  使用优先队列找出对象中最大的M个
******

public class TopM
{
	public static void main(String[] args)
	{
		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
		while(StdIn.hasNext())
		{
			pq.insert(new Trasaction(StdIn.readline()));
			if(pq.size() > M)
				pq.delMin()
		}
		Stack<Transaction> stack = new Stack<Trasaction>();
		while(!pq.isEmpty())
			stack.push(pq.delMin());
		for(Transaction T:stack)
			StdOut.println(t);
		
	}
}


 
******
* 12 *  使用Comparator接口实现按照多种类型数据排序；
****** 

第一步：sort方法的定义：
public static void sort(Object[] a, Comparator c)
{
	int N = a.length;
	for(int i=1;i<N;i++)
	{//将a[i]插入到a[i-1]，a[i-2]...中
		for(int j = i;j>0 && less(c,a[j],a[j-1]);j--)
			exch(a,j,j-1);
	}
}

private static boolean less(Comparator c, Object v, Object w)
{
	return c.compare(v,w)<0;
}

private static void exch(Object[] a, int i, int j)
{
	Object temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}

第二步：抽象数据类型的定义（以Trasaction为例）
java.util.Comparator;
public class Trasaction
{
	private final String who;
	private final Date when;
	private final double amount;
	
	public static class WhoOrder implements Comparator<Transaction>
	{
		public int compare(Transaction v, Transaction w)
		{
			return v.who.compareTo(w.who);
		}
		
	}
	
	public static class WhenOrder implements Comparator<Transaction>
	{
		public int compare(Transaction v, Transaction w)
		{
			return v.when.compareTo(w.when);
		}
		
	}
	
	public static class HowMuchOrder implements Comparator<Transaction>
	{
		public int compare(Transaction v, Transaction w)
		{
			return v.amount.compareTo(w.amount);
		}
		
	}
}

第三步：调用
 Insertion.sort(a, new Transaction.WhoOrder());
 Insertion.sort(a, new Transaction.WhenOrder());
 Insertion.sort(a, new Transaction.HowMuchOrder());
 
 
******
* 13 *  使用Comparator接口实现优先队列；
****** 
（1）导入：java.util.comparator;
（2）为MaxPQ类添加一个实例变量以及一个构造函数；
     Comparator<Key> comparator;
	 
	 public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
（3）修改less函数，检查comparator属性是否为null；
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

	
******
* 13 *  在类的构造方法内部，也可以使用this关键字引用其它的构造方法
****** 	

	public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    
    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }  
	
	
******
* 14 *  自定义hashCode（）方法
****** 	

public class Trasaction
{
	...
	public int hasCode()
	{
		int hash = 17;
		hash = 31*hash + who.hashCode();
		hash = 31*hash + when.hashCode();
		hash = 31*hash + ((Double)amount).hashCode();
		return hash;
	}
	
}

******
* 15 *  白名单过滤
****** 	

public class WhiteFilter
{
	public static void main(String[] agrs)
	{
		HashSet<String> set = new HashSet<String>();
		In in = new In(args[0]);
		while(!in.isEmpty())
			set.add(in.readString());
		
		while(!StdIn.isEmpty())
		{
			String word = StdIn.readString();
			if(set.contains(word))
			{
				StdOut.println(word+" ");
			}			
		}		
	}
}

标准输入、输出：StdOut,StdIn
基于文件的输入、输出：In，Out


******
* 16 *  邻接表数组的声明过程
****** 

声明数组： int[] a = new int[10];
声明Bag： Bag<Integer> bag = new Bag<Integer>();
声明邻接表数组： Bag<Integer>[] adj = (Bag<Integer>[])new Bag[10];
并对其进行初始，为每个元素新建一个Bag： 
   for(int i=0;i<10;i++)
   {
	   adj[i] = new Bag<Integer>();
   }
   
   
* 将int转化为Stirng： Integer.toString(i) or String.valueOf(i).
	























