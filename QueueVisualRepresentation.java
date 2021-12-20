import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
public class QueueVisualRepresentation extends JFrame
{
    QVRQueue q1;
    Canvas c1;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2;
    JTextField jtf1;
    JLabel jtf2,jl1,jl2,jl3,jl4,jl5;
    QueueVisualRepresentation()
    {
        this.setSize(800,600);//to initialize the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setName("DEMO");
        this.setLayout(null);
        this.setBackground(new Color(50,60,70));
        
        jtf2=new JLabel("FRONT");//to initialize the first queue area
        jtf2.setBackground(Color.white);
        jtf2.setForeground(Color.white);
        jtf2.setFont(new Font("Ariel",Font.BOLD,20));
        jtf2.setBounds(67, 0, 100, 30);
        this.add(jtf2);
        
        jp1=new JPanel();
        jp1.setSize(200, 600);
        jp1.setLocation(0, 0);
        jp1.setBackground(new Color(70,80,90));
        jp1.setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
        jp1.setBorder(BorderFactory.createLineBorder(Color.black));
        q1=new QVRQueue();
        c1=new Canvas()
        {
            public void paint(Graphics g)
            {}
        };
        c1.setBackground(null);
        c1.setSize(200,400);
        jp1.add(c1);
        jtf1=new JTextField("...");
        jtf1.setPreferredSize(new Dimension(100,20));
        jtf1.setBackground(Color.white);
        jp1.add(jtf1);
        jb1=new JButton("ADD");
        jb1.setBackground(new Color(80,90,100));
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                int num;
                try
                {
                    num = Integer.parseInt(jtf1.getText().trim());
                    q1.add(num);
                    jl2.setText("SIZE: "+q1.size);
                    jl3.setText("MAX: "+q1.max());
                    jl4.setText("MIN: "+q1.min());
                    jl5.setText("TOTAL: "+q1.total);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Enter a number.","Number warning",JOptionPane.WARNING_MESSAGE);
                }
                if(q1.size>0)
                {
                    Graphics g=c1.getGraphics();
                    drawQueue(g);
                }
            }
        });
        jp1.add(jb1);
        
        jb2=new JButton("REMOVE");
        jb2.setBackground(new Color(80,90,100));
        jb2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                q1.remove();
                Graphics g=c1.getGraphics();
                drawQueue(g);
                jl2.setText("SIZE: "+q1.size);
                jl3.setText("MAX: "+q1.max());
                jl4.setText("MIN: "+q1.min());
                jl5.setText("TOTAL: "+q1.total);
            }
        });
        jp1.add(jb2);
        
        jp2=new JPanel();//this is for the banner
        jp2.setSize(600, 100);
        jp2.setLocation(200, 0);
        jp2.setBackground(new Color(100,110,120));
        jp2.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));
        jp2.setBorder(BorderFactory.createLineBorder(Color.black));
        jl1=new JLabel("QUEUE VISUAL REPRESENTATION");
        jl1.setForeground(Color.red);
        jl1.setFont(new Font("Ariel",Font.ITALIC,30));
        jp2.add(jl1);
        
        jp3=new JPanel();
        jp3.setSize(200, 500);
        jp3.setLocation(200, 100);
        jp3.setBackground(new Color(110,120,130));
        jp3.setBorder(BorderFactory.createLineBorder(Color.black));
        jp3.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
        jl2=new JLabel("SIZE: "+q1.size);
        jl2.setForeground(Color.red);
        jl2.setFont(new Font("Ariel",Font.BOLD,20));
        jp3.add(jl2);
        jl3=new JLabel("MAX: NULL");
        jl3.setForeground(Color.red);
        jl3.setFont(new Font("Ariel",Font.BOLD,20));
        jp3.add(jl3);
        jl4=new JLabel("MIN: NULL");
        jl4.setForeground(Color.red);
        jl4.setFont(new Font("Ariel",Font.BOLD,20));
        jp3.add(jl4);
        jl5=new JLabel("TOTAL: "+q1.total);
        jl5.setForeground(Color.red);
        jl5.setFont(new Font("Ariel",Font.BOLD,20));
        jp3.add(jl5);
        
        this.add(jp3);
        this.add(jp2);
        this.add(jp1);
        this.setVisible(true);
    }
    public void drawQueue(Graphics g)
    {
        g.setColor(null);
        g.clearRect(0, 0, 200, 600);
        int ar[]=q1.iterate();
        int i=40;
        if(ar.length>0)
        {
            outer:
            for(int j:ar )
            {
                if(i>380)
                {
                    break outer;
                }
                g.setColor(Color.red);
                g.fillOval( 90,i, 20, 20);
                g.drawString(Integer.toString(j), 110,i+15);
                i+=22;
                
            }
        }
        if(q1.size>16)
        {
            g.drawString("+"+Integer.toString(q1.size-16), 160,400);
        }
    }   
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                QueueVisualRepresentation q=new QueueVisualRepresentation();
            }
        });
    }
    
}
