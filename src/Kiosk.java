import javax.swing.*;
import java.awt.*;

public class Kiosk extends JFrame{
    private JPanel BasePanel;
    private JPanel NorthPanel;
    private JPanel SouthPanel;
    private JPanel RightPanel;
    private JPanel LeftPanel;
    private JTable Cart;
    private JButton OrderCancel;
    private JButton OrderComplete;
    private JButton PayCard;
    private JPanel deriPanel;
    private JPanel shrimpPanel;
    private JPanel bulgogiPanel;
    private JPanel cokePanel;
    private JPanel icecreamPanel;
    private JComboBox bulgogiAmount;
    private JButton bulgogiCart;
    private JPanel bulgogiImage;
    private JComboBox shrimpAmount;
    private JButton shrimpCart;
    private JComboBox deriAmount;
    private JButton deriCart;
    private JComboBox cokeAmount;
    private JButton cokeCart;
    private JLabel Title;
    private JComboBox icecreamAmount;
    private JButton icecreamCart;
    private JPanel deriImage;
    private JLabel deriLabel;
    private JLabel deriPrice;
    private JLabel bulgogiLabel;
    private JLabel bulgogiPrice;
    private JLabel shrimpLabel;
    private JLabel shrimpPrice;
    private JPanel shrimpImage;
    private JPanel cokeImage;
    private JLabel cokeLabel;
    private JLabel cokePrice;
    private JLabel icecreamLabel;
    private JPanel icecreamImage;
    private JLabel icecreamPrice;
    private JComboBox spriteAmount;
    private JButton spriteCart;
    private JPanel spritePanel;
    private JLabel spriteLabel;
    private JPanel spriteImage;
    private JLabel spritePrice;
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 13);
    Font font2 = new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 25);
    int count; int total=0; int col=0; int row=0; String contents = "";
    public Kiosk() {
        setContentPane(BasePanel);
        setTitle("hamburger kiosk");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUIComponents() {

        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        new Kiosk();
    }
}