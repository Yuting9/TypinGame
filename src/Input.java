
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

public class Input extends JPanel implements GlobalVar, ActionListener, KeyListener{

	JPanel pnlDef = new JPanel();
	JPanel pnlSyn = new JPanel();
	JPanel pnlWrd = new JPanel();
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel pnlBtn;
	private JButton btnSubmit;
	private JButton btnExit;
	private JTextArea textWord;
	private JTextArea textDef;
	private JTextArea textSyn;
	private String word;
	private String[][] defandsyn;
	
	public Input() {
		System.out.println("Setting up Input");
		this.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(this);
		frame.state = "input";
		
		add(pnlWrd, BorderLayout.NORTH);
		
		JLabel lblWord = new JLabel("Word");
		lblWord.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlWrd.add(lblWord);
		
		textWord = new JTextArea();
		textWord.setColumns(10);
		textWord.setWrapStyleWord(true);
		pnlWrd.add(textWord);
		
		add(pnlDef, BorderLayout.CENTER);
		pnlDef.setLayout(new BoxLayout(pnlDef, BoxLayout.Y_AXIS));
		
		JLabel lblDefinition = new JLabel("Definition");
		lblDefinition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDef.add(lblDefinition);
		
		textDef = new JTextArea();
		textDef.setWrapStyleWord(true);
		textDef.setLineWrap(true);
		pnlDef.add(textDef);
		
		add(pnlSyn, BorderLayout.EAST);
		pnlSyn.setLayout(new BoxLayout(pnlSyn, BoxLayout.Y_AXIS));
		
		JLabel lblSyn = new JLabel("Synonyms");
		lblSyn.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSyn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlSyn.add(lblSyn);
		
		textSyn = new JTextArea();
		textSyn.setBackground(Color.LIGHT_GRAY);
		textSyn.setLineWrap(true);
		textSyn.setWrapStyleWord(true);
		pnlSyn.add(textSyn);
		
		pnlBtn = new JPanel();
		add(pnlBtn, BorderLayout.SOUTH);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		pnlBtn.add(btnSubmit);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		pnlBtn.add(btnExit);
		
		frame.setSize(400,400);
		frame.setLocation(dim.width/2-200, dim.height/2-200);
		
		this.revalidate();
		this.repaint();
		
		System.out.println("Input Active");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnSubmit) {
			word = textWord.getText();
			defandsyn = new String[2][1];
			defandsyn[0][0] = textDef.getText();
			defandsyn[1] = textSyn.getText().split("\n");
			words.add(word, defandsyn);
			
			frame.clear();
			frame.state = "main";
			frame.getContentPane().add(new MainMenu());
			frame.validate();
			frame.repaint();
		}
		if(e.getSource() == btnExit) {
			frame.clear();
			frame.state = "main";
			frame.getContentPane().add(new MainMenu());
			frame.validate();
			frame.repaint();
		}
		
		
        this.revalidate();
        this.repaint();
	}
	
	
	
}
