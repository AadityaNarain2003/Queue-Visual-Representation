public class Queue 
{
    private int[] A;
    private int size,front,rear;
    private static int CAPACITY =16;
    public static int MINCAPACITY=1<<15;
    
    public Queue()
    {
        A=new int[CAPACITY];
        size=0;
        front=0;
        rear=0;
    }
    public void enQueue(int data) throws NullPointerException, IllegalStateException
    {
        if(size==CAPACITY)
        {
            expand();
        }
        size++;
        A[rear]=data;
        //if(size-1!=CAPACITY-1)
            rear=((rear)%CAPACITY)+1;
    }
    public int deQueue() throws IllegalStateException
    {
        if(size==0)
        {
            throw new IllegalStateException("Queue is Empty. UnderFlow");
        }
        else
        {
           size--;
           int data=A[(front%CAPACITY)];
           A[front]=Integer.MIN_VALUE;
           front=(front+1)%CAPACITY;
           return data;
        }
    }
    public boolean isEmpty()
    {
        return (size==0);
    }
    public boolean isFull()
    {
        return (size==CAPACITY);
    }
    public int size()
    {
        return size;
    }
    private void expand()
    {
        int length=size();
        int[] newQueue=new int[length<<1];
        for(int i=front;i<=rear;i++)
        {
            newQueue[i-front]=A[i%CAPACITY];
        }
        A=newQueue;
        front=0;
        rear=size-1;
        CAPACITY*=2;
    }
    private void shrink()
    {
        int length=size;
        if(length<=MINCAPACITY || length<<2>=length)
        {
            return;
        }
        if(length<MINCAPACITY ) length=MINCAPACITY;
        int[] newQueue=new int[length];
        System.arraycopy(A,0,newQueue,0,length+1);
        A=newQueue;
    }
    public String toString()
    {
        String result="|";
        for(int i=0;i<size;i++)
        {
            result+=Integer.toString(A[(front+i)%CAPACITY]);
            if(i<size-1)
            {
                result+=",";
            }
        }
        result+="|";
        return result;
    }
    public static void main(String args[]) throws java.lang.Exception
    {
        Queue q=new Queue();
        q.enQueue(1);
        System.out.println(q.toString());
        
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(6);
        q.enQueue(7);
        q.enQueue(8);
        System.out.println(q.toString());
        q.enQueue(9);
        q.enQueue(10);
        System.out.println(q.toString());
        q.enQueue(11);
        System.out.println(q.toString());
        q.enQueue(12);
        System.out.println(q.toString());
        q.enQueue(13);
        System.out.println(q.toString());
        q.enQueue(14);
        System.out.println(q.toString());
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        System.out.println(q.toString());
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        System.out.println(q.toString());
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        System.out.println(q.toString());
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        q.enQueue(15);
        System.out.println(q.toString());
        q.enQueue(16);
        
        System.out.println(q.toString());
        q.enQueue(17);
        System.out.println(q.toString());
        q.enQueue(18);
        System.out.println(q.toString());
        
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        System.out.println(q.toString());
        q.deQueue();
        System.out.println(q.toString());
    }
}
