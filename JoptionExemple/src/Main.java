import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		String rr= JOptionPane.showInputDialog( null, "ddd" , new ComboBoxExample() );
		
		
		

	}
	

public static String getMessegjOP(String s) {
	return JOptionPane.showInputDialog(null ,s,"DataBase",JOptionPane.QUESTION_MESSAGE);
//	f,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE

}

public static void showMesseg(String s) {
	JOptionPane.showMessageDialog(null, s);
	
	
}
}