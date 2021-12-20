public class QVRQueue//custom linkedlist implementation using head and tail pointers
{
    class Node
    {
        int num;
        Node next;
        public Node(int num)
        {
            this.num=num;
            this.next=null;
        }
    }
    static int total;
    int size;
    Node head,tail;
    public QVRQueue()
    {
        size=0;
        total=0;
        head=null;
        tail=null;
    }
    public void add(int num)
    {
        Node n=new Node(num);
        ++size;
        ++total;
        if(head==null)
        {
            head=n;
            tail=n;
            return;
        }
        tail.next=n;
        tail=n;
    }
    public void remove()
    {
        if(size==0)
        {
            return;
        }
        if(size>1)
        {
            head=head.next;
            --size;
                 
        }
        else
        {
            head=null;
            --size;
        }
        
    }
    public int[] iterate()
    {
        Node temp=head;
        if(temp==null)
        {
            return new int[] {};
        }
        int[] n=new int[size];
        int i=0;
        while(temp!=null)
        {
            n[i]=temp.num;
            temp=temp.next;
            ++i;
        }
        return n;
    }
    public int max()
    {
        int max=Integer.MIN_VALUE;
        Node temp=head;
        if(temp==null)
        {
            return 0;
        }
        int i=0;
        while(temp!=null)
        {
            if(temp.num>max)
            {
                max=temp.num;
            }
            temp=temp.next;
            ++i;
        }
        return max;
    }
    public int min()
    {
        int max=Integer.MAX_VALUE;
        Node temp=head;
        if(temp==null)
        {
            return 0;
        }
        int i=0;
        while(temp!=null)
        {
            if(temp.num<max)
            {
                max=temp.num;
            }
            temp=temp.next;
            ++i;
        }
        return max;
    }
}
