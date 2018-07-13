import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

public class MainMenu extends JPanel implements GlobalVar, ActionListener{
	
	JButton[] btnArray = new JButton[4];
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public MainMenu() {
		System.out.println("Setting up MainMenu");
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Main Menu");
		pnlNorth.add(lblTitle);
		
		JPanel pnlSouth = new JPanel();
		add(pnlSouth, BorderLayout.SOUTH);
		
		btnArray[0] = new JButton("Input Words");
		btnArray[1] = new JButton("Practice");
		btnArray[2] = new JButton("Challenges");
		btnArray[3] = new JButton("Save and Exit");
		
		btnArray[0].addActionListener(this);
		btnArray[1].addActionListener(this);
		btnArray[2].addActionListener(this);
		btnArray[3].addActionListener(this);
		
		pnlSouth.add(btnArray[0]);
		pnlSouth.add(btnArray[1]);
		pnlSouth.add(btnArray[2]);
		pnlSouth.add(btnArray[3]);
		
		frame.setSize(500,100);
		this.setLocation(dim.width/2-200, dim.height/2-100);
		
		this.revalidate();
		this.repaint();
		
		System.out.println("MainMenu Active");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnArray[0]) {
			frame.clear();
			frame.state = "input";
			frame.getContentPane().add(new Input());
			frame.validate();
			frame.repaint();
		}
		if(e.getSource() == btnArray[3]) {
			frame.clear();
			words.close();
			frame.close();
		}
        this.revalidate();
        this.repaint();
	}
}
