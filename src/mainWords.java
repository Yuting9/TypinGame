import javax.swing.UIManager;


public class mainWords implements GlobalVar{
	
	public static void main(String[] args) {
		words.populate();
		frame.add(new MainMenu());
	}
}
