import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements GlobalVar {
	
	public JPanel panel;
	public static String state;
	Container c;
	
	// Default Constructor
	public MainFrame() {
		setTitle("ALPHA BUILD - TESTING");
		state = "main";
		c = this.getContentPane();
		setSize(400,100);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		System.out.println("MainframeComplete");
	}
	
	public void close() {
		frame.dispose();
	}
	
	public void reset(){
        frame.setTitle("ALPHA BUILD - TESTING");
        c.removeAll();
        c.add(this.panel);
    }
    
    // 
    public void clear(){
        //System.out.println("Cleared frame");
        c.removeAll();
    }
    
    public void add(JPanel jpanel){
        //System.out.print(jpanel);
        //System.out.println("added to frame");
        
        //Container 
    	panel = jpanel;
        c.setLayout(new BorderLayout());
        c.add(panel,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
	
}
