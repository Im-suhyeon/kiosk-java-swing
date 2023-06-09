import order.Cart;
import order.Controller;
import order.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kiosk extends JFrame{
    private JPanel BasePanel;
    private JPanel NorthPanel;
    private JPanel SouthPanel;
    private JPanel RightPanel;
    private JPanel LeftPanel;
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
    private JComboBox shrimpAmount;
    private JButton shrimpCart;
    private JComboBox deriAmount;
    private JButton deriCart;
    private JComboBox cokeAmount;
    private JButton cokeCart;
    private JLabel Title;
    private JComboBox icecreamAmount;
    private JButton icecreamCart;
    private JPanel deriImagePanel;
    private JLabel deriLabel;
    private JLabel deriPrice;
    private JLabel bulgogiLabel;
    private JLabel bulgogiPrice;
    private JLabel shrimpLabel;
    private JLabel shrimpPrice;
    private JPanel shrimpImagePanel;
    private JPanel cokeImagePanel;
    private JLabel cokeLabel;
    private JLabel cokePrice;
    private JLabel icecreamLabel;
    private JPanel icecreamImagePanel;
    private JLabel icecreamPrice;
    private JComboBox spriteAmount;
    private JButton spriteCart;
    private JPanel spritePanel;
    private JLabel spriteLabel;
    private JPanel spriteImagePanel;
    private JLabel spritePrice;
    private JTable CartTable;
    private JScrollPane CartScrollPane;
    private JPanel bulgogiImagePanel;

    private JLabel bulgogiImageLabel;
    private JLabel deriImageLabel;
    private JLabel shrimpImageLabel;
    private JLabel cokeImageLabel;
    private JLabel icecreamImageLabel;
    private JLabel spriteImageLabel;
    private JButton 현금결제Button;


    int count; int total=0; int col=0; int row=0; String contents = "";


    DefaultTableModel model;
    //장바구니 테이블 ui
    private void createTable(){
        String[] [] data = new String[0][0];
        String[] title = {"메뉴명", "단가", "수량", "합계", "총 금액"};
        model = new DefaultTableModel(data, title);

        CartTable.setModel(model);
    }




    public Kiosk() {

        setContentPane(BasePanel);
        setTitle("hamburger kiosk");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setVisible(true);

        createTable();

        // 참고 : https://eating-coding.tistory.com/5
        ImageIcon bulgogiicon = new ImageIcon("img/bulgogi.jpg");
        Image bulgogiimg = bulgogiicon.getImage();
        Image bulgogichangeImg = bulgogiimg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon bulgogichangeIcon = new ImageIcon(bulgogichangeImg);
        bulgogiImageLabel = new JLabel(bulgogiicon);
        bulgogiImagePanel.add(bulgogiImageLabel);
        //bulgogiImagePanel.setSize(100,100);
        bulgogiImagePanel.setVisible(true);


        ImageIcon shrimpicon = new ImageIcon("img/shrimp.jpg");
        Image shrimpimg = shrimpicon.getImage();
        Image shrimpchangeImg = shrimpimg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon shrimpchangeIcon = new ImageIcon(shrimpchangeImg);
        shrimpImageLabel = new JLabel(shrimpicon);
        shrimpImagePanel.add(shrimpImageLabel);
        //shrimpImagePanel.setSize(100,100);
        shrimpImagePanel.setVisible(true);


        ImageIcon deriicon = new ImageIcon("img/deri.jpg");
        Image deriimg = deriicon.getImage();
        Image derichangeImg = deriimg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon derichangeIcon = new ImageIcon(derichangeImg);
        deriImageLabel = new JLabel(deriicon);
        deriImagePanel.add(deriImageLabel);
        //deriImagePanel.setSize(100,100);
        deriImagePanel.setVisible(true);


        ImageIcon cokeicon = new ImageIcon("img/coke.jpg");
        Image cokeimg = cokeicon.getImage();
        Image cokechangeImg = cokeimg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon cokechangeIcon = new ImageIcon(cokechangeImg);
        cokeImageLabel = new JLabel(cokeicon);
        cokeImagePanel.add(cokeImageLabel);
        //cokeImagePanel.setSize(100,100);
        cokeImagePanel.setVisible(true);


        ImageIcon spriteicon = new ImageIcon("img/sprite.jpg");
        Image spriteimg = spriteicon.getImage();
        Image spritechangeImg = spriteimg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon spritechangeIcon = new ImageIcon(spritechangeImg);
        spriteImageLabel = new JLabel(spriteicon);
        spriteImagePanel.add(spriteImageLabel);
        //spriteImagePanel.setSize(100,100);
        spriteImagePanel.setVisible(true);


        ImageIcon icecreamicon = new ImageIcon("img/icecream.jpg");
        Image icecreamimg = icecreamicon.getImage();
        Image icecreamchangeImg = icecreamimg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon icecreamchangeIcon = new ImageIcon(icecreamchangeImg);
        icecreamImageLabel = new JLabel(icecreamicon);
        icecreamImagePanel.add(icecreamImageLabel);
        //icecreamImagePanel.setSize(100,100);
        icecreamImagePanel.setVisible(true);

//-------여기서부터 로직 구현--------
        order.Cart cart = new Cart();
        Controller controller = new Controller();
        Customer customer = new Customer();

        //장바구니 목록에 추가될 항목들 저장할 객체. inputStr에 담아 저장
        TextArea txt = new TextArea();
        String inputStr[] = new String[5];



        //불고기버거 선택 수량 저장
        bulgogiAmount.addActionListener(new ActionListener() {
            @Override
            //선택한 수량을 count 변수에 저장
            public void actionPerformed(ActionEvent e) {
                count = Integer.valueOf(bulgogiAmount.getSelectedItem().toString());
            }
        });
        //불고기버거 장바구니에 담기 버튼 눌렀을 때
        bulgogiCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //장바구니에 담긴 불고기 버거의 수량 cartAmountList에 반영
                cart.setCartAmountList(0, count);
                //사용자에게 보이는 장바구니 목록의 행 개수
                total += count;


                inputStr[0] = cart.getM()[0].getName();
                inputStr[1] = String.valueOf(cart.getM()[0].getPrice()) + "원";
                inputStr[2] = ""+count;
                inputStr[3] = (cart.getM()[0].getPrice()) * count + "원";
                inputStr[4] = String.valueOf(cart.getPriceAmount()) + "원";

                model.addRow(inputStr);
            }
        });

        //새우버거
        shrimpAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = Integer.valueOf(shrimpAmount.getSelectedItem().toString());
            }
        });
        shrimpCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.setCartAmountList(1, count);
                total += count;



                inputStr[0] = cart.getM()[1].getName();
                inputStr[1] = String.valueOf(cart.getM()[1].getPrice()) + "원";
                inputStr[2] = ""+count;
                inputStr[3] = (cart.getM()[1].getPrice()) * count + "원";
                inputStr[4] = String.valueOf(cart.getPriceAmount()) + "원";

                model.addRow(inputStr);
            }
        });

        //데리버거
        deriAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = Integer.valueOf(deriAmount.getSelectedItem().toString());
            }
        });

        deriCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.setCartAmountList(2, count);
                total += count;

                inputStr[0] = cart.getM()[2].getName();
                inputStr[1] = String.valueOf(cart.getM()[2].getPrice()) + "원";
                inputStr[2] = ""+count;
                inputStr[3] = (cart.getM()[2].getPrice()) * count + "원";
                inputStr[4] = String.valueOf(cart.getPriceAmount()) + "원";

                model.addRow(inputStr);
            }
        });


        //콜라
        cokeAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = Integer.valueOf(cokeAmount.getSelectedItem().toString());
            }
        });
        cokeCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.setCartAmountList(3, count);
                total += count;

                inputStr[0] = cart.getM()[3].getName();
                inputStr[1] = String.valueOf(cart.getM()[3].getPrice()) + "원";
                inputStr[2] = ""+count;
                inputStr[3] = (cart.getM()[3].getPrice()) * count + "원";
                inputStr[4] = String.valueOf(cart.getPriceAmount()) + "원";

                model.addRow(inputStr);
            }
        });


        //스프라이트
        spriteAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = Integer.valueOf(spriteAmount.getSelectedItem().toString());
            }
        });
        spriteCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.setCartAmountList(4, count);
                total += count;

                inputStr[0] = cart.getM()[4].getName();
                inputStr[1] = String.valueOf(cart.getM()[4].getPrice()) + "원";
                inputStr[2] = ""+count;
                inputStr[3] = (cart.getM()[4].getPrice()) * count + "원";
                inputStr[4] = String.valueOf(cart.getPriceAmount()) + "원";

                model.addRow(inputStr);
            }
        });


        //아이스크림
        icecreamAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = Integer.valueOf(icecreamAmount.getSelectedItem().toString());
            }
        });
        icecreamCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.setCartAmountList(5, count);
                total += count;

                inputStr[0] = cart.getM()[5].getName();
                inputStr[1] = String.valueOf(cart.getM()[5].getPrice()) + "원";
                inputStr[2] = ""+count;
                inputStr[3] = (cart.getM()[5].getPrice()) * count + "원";
                inputStr[4] = String.valueOf(cart.getPriceAmount()) + "원";

                model.addRow(inputStr);
            }
        });



        //장바구니 초기화
        OrderCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.resetCart();

                //사용자에게 보이는 장바구니 목록 초기화
                model.setNumRows(0);
                total = 0;
                txt.setText("");
            }
        });


        //장바구니 담기 완료 버튼 누를 시
        OrderComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getRowCount() == 0) { //장바구니에 담긴 내용이 없을 때
                    JOptionPane.showMessageDialog(BasePanel, "장바구니에 담긴 내용이 없습니다.", "error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    cart.cartComplete(); // cart가 가지는 order 객체의 필드인 orderCompleteState의 값을 true로 변경
                    // controller의 멤버 필드 bill의 값으로 결제 금액을 할당.
                    controller.setBill(cart.getPriceAmount());
                }

            }

        });
// -- 결제 프로세스 --

        //카드 결제 버튼 누를 시
        PayCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //장바구니 담기 완료 버튼 안 눌렀을 경우
                if(!cart.getOrder().getOrderCompleteState()) {
                    JOptionPane.showMessageDialog(BasePanel, "장바구니 담기를 완료해주세요.", "error",JOptionPane.ERROR_MESSAGE);
                }
                //장바구니 담기 완료 버튼 눌렀을 경우. 카드 결제 프로세스
                else {
                    JOptionPane.showMessageDialog(BasePanel, "결제가 완료되었습니다.", "message", JOptionPane.INFORMATION_MESSAGE);
                    //카드 결제이므로 isPayCard에 true 할당.
                    controller.setIsPayCard(true);

                    //장바구니 초기화
                    cart.resetCart();
                    //cart 객체가 가지는 order 객체를 주문완료(결제 완료)상태로 함.
                    cart.getOrder().setOrderCompleteState(false);

                    //사용자에게 보이는 장바구니 목록 초기화
                    model.setNumRows(0);
                    total = 0;
                    txt.setText("");
                }
            }
        });

        현금결제Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //장바구니 담기 완료 버튼 안 눌렀을 경우
                if(!cart.getOrder().getOrderCompleteState()) {
                    JOptionPane.showMessageDialog(BasePanel, "장바구니 담기를 완료해주세요.", "error",JOptionPane.ERROR_MESSAGE);
                }

                //장바구니 담기 완료 버튼 눌렀을 경우. 현금 결제 프로세스 진행
                else {
                    int inputAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "넣을 현금의 값을 입력하세요."));
                    //현금 결제이므로 isPayCard에 false 할당.
                    controller.setIsPayCard(false);
                    //customer 객체가 가지는 cashInput 변수에 inputAmount 값 할당.
                    customer.setCashInput(inputAmount);

                    int change = 0;

                    //사용자가 입력한 계산 금액(넣은 현금의 값)이 결제 금액보다 적을 경우
                    while ((change = controller.changeVal(customer.getCashInput())) == -1) {
                        //inputAmount(넣을 현금의 값) 다시 입력받도록 함
                        inputAmount = Integer.parseInt(JOptionPane.showInputDialog(null,"입력한 금액이 결제 금액보다 적습니다. 넣을 현금의 값을 입력하세요."));
                        //customer 객체가 가지는 cashInput 변수에 inputAmount 값 할당.
                        customer.setCashInput(inputAmount);
                    }

                    change = controller.changeVal(customer.getCashInput());

                    //결제금액과 사용자가 입력한 금액 같은 경우(거스름돈이 0원인 경우)
                    if (change == 0) {
                        JOptionPane.showMessageDialog(BasePanel, "결제가 완료되었습니다.", "message", JOptionPane.INFORMATION_MESSAGE);

                        //장바구니 초기화
                        cart.resetCart();
                        //cart 객체가 가지는 order 객체를 주문완료(결제 완료)상태로 함.
                        cart.getOrder().setOrderCompleteState(false);

                        //사용자에게 보이는 장바구니 목록 초기화
                        model.setNumRows(0);
                        total = 0;
                        txt.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(BasePanel, "결제가 완료되었습니다. 거스름돈 " + change + "원이 반환됩니다.", "message", JOptionPane.INFORMATION_MESSAGE);

                        //장바구니 초기화
                        cart.resetCart();
                        //cart 객체가 가지는 order 객체를 주문완료(결제 완료)상태로 함.
                        cart.getOrder().setOrderCompleteState(false);

                        //사용자에게 보이는 장바구니 목록 초기화
                        model.setNumRows(0);
                        total = 0;
                        txt.setText("");
                    }

                }
            }
        });




    }

    private void createUIComponents() {

        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        new Kiosk();

    }
}

