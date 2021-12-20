import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class QueueVisualRepresentation extends JFrame
{
    QVRQueue q1;
    Canvas c1;
    JPanel jp1;
    JButton jb1,jb2;
    JTextField jtf1;
    JLabel jtf2;
    QueueVisualRepresentation()
    {
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setName("DEMO");
        this.setLayout(null);
        this.setBackground(new Color(50,60,70));
        
        jtf2=new JLabel("FRONT");
        jtf2.setBackground(Color.white);
        jtf2.setForeground(Color.white);
        jtf2.setFont(new Font("Ariel",Font.BOLD,20));
        jtf2.setBounds(67, 0, 100, 30);
        this.add(jtf2);
        
        jp1=new JPanel();
        jp1.setSize(200, 600);
        jp1.setLocation(0, 0);
        jp1.setBackground(new Color(70,80,90));
        jp1.setLayout(new FlowLayout());
        q1=new QVRQueue();
        c1=new Canvas()
        {
            public void paint(Graphics g)
            {}
        };
        c1.setBackground(null);
        c1.setSize(200,400);
        jp1.add(c1);
        jtf1=new JTextField("    ...     ");
        jtf1.setSize(new Dimension(100,20));
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
        jb2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                q1.remove();
                Graphics g=c1.getGraphics();
                drawQueue(g);
            }
        });
        jp1.add(jb2);
        
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
