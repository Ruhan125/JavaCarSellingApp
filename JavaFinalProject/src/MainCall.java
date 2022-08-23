

import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.util.regex.*;

import com.mysql.jdbc.ResultSetMetaData;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;



 


public class MainCall {

	public static void main(String[] args)
	{
		
		
		MainCall logobj = new MainCall();
		logobj.login();
		
				
	}
	
	
	
	
	public void login()
	{
        JFrame loginFrame = new JFrame("Login");
		
        loginFrame.setSize(815,625);
        loginFrame.setDefaultCloseOperation(3);
        loginFrame.setLayout(null);
        loginFrame.setLocationRelativeTo(null);
	    JLabel backgroundLbl = new JLabel();
	    
	    loginFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\finalogin.png")));
	    //frame.setLayout(new FlowLayout()); 
	    loginFrame.add(backgroundLbl);
	    loginFrame.setSize(815,625);
	    
	    JLabel unameLbl = new JLabel("Username :");
	    unameLbl.setBounds(420, 180, 120, 50);
	    unameLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    unameLbl.setForeground(Color.WHITE);
	    loginFrame.add( unameLbl);
	    
	    
	    JTextField unameTf= new JTextField();
	    unameTf.setBounds(530,185,170,40);
	    unameTf.setFont(new Font("Arial", Font.BOLD, 20));
	    
		loginFrame.add(unameTf);
	    
	    JLabel passLbl = new JLabel("Password :");
	    passLbl.setBounds(420, 250, 120, 50);
	    passLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    passLbl.setForeground(Color.WHITE);
	    loginFrame.add(passLbl);
	    
	    JPasswordField passField = new JPasswordField();
	    passField.setBounds(530,255,170,40);
	    passField.setFont(new Font("Arial", Font.BOLD, 20));
		loginFrame.add(passField);
	    
	    Icon icon = new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\loginbtn.png");
	    JButton loginBtn = new JButton(icon);
	    loginBtn.setBounds(530,340,100,40);
	    loginBtn.setFont(new Font("Arial", Font.BOLD, 20));
		loginFrame.add(loginBtn);
	    
		loginBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      {
	    
	    	  
	    	 try {
	    		 
	    		  Class.forName("com.mysql.jdbc.Driver");
	    		  Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user","root","");
	    		  Statement stmt = c.createStatement();
	    		  String sql = "Select * from user_info where Username = '"+unameTf.getText()+"'and Password = '"+ passField.getText()+"'";
	    		  String userid = unameTf.getText();
	    		  MainCall userinfoobj = new MainCall();
				 // userinfoobj.userinfofinder(userid);
	    		  //System.out.println(userid);
	    		  ResultSet rs = stmt.executeQuery(sql);
	    		  
	    		  if(rs.next())
	    		  {
	    			   loginFrame.dispose();
	    			   MainCall homeobj = new MainCall();
	    			   homeobj.home();
	    			  
	    		  }
	    		  else 
	 	    	 {
	 	    		 JOptionPane.showMessageDialog(null,"Wrong Username or Password","Error", JOptionPane.ERROR_MESSAGE);
	 	    		unameTf.setText(null);
	 	    		passField.setText(null);
	 	    		unameTf.requestFocusInWindow();
	 	    		 
	 	    	 }
	    		  
	    	 }
	    	 
	    	 catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    		 
	    		 
	    	 }
	    	 
	    	 
	    	    	 
	      }
 
 
 
		});
	    
	    JButton adminBtn = new JButton("Admin");
	    adminBtn.setBounds(420,450,80,40);
	    adminBtn.setFont(new Font("Arial", Font.BOLD, 15));
		loginFrame.add(adminBtn);
	    
		adminBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	   loginFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.adminLogin();
	    	  
	    	  
	      }
	      
		} );  
	    
	    
	    JLabel newacclbl = new JLabel("Don't have an account? Signup below:");
	    newacclbl.setBounds(420, 480, 280, 50);
	    newacclbl.setFont(new Font("Arial", Font.BOLD, 14));
	    newacclbl.setForeground(Color.WHITE);
	    loginFrame.add(newacclbl);
	    
	    
	    Icon icon1 = new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\snp.png");
	    
	    JButton signupBtn = new JButton(icon1);
	    signupBtn.setBounds(420,515,100,40);
	    signupBtn.setFont(new Font("Arial", Font.BOLD, 15));
		loginFrame.add( signupBtn);
	    
		 signupBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  loginFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.register();
	    	  
	    	  
	      }
	      
		} );  
	    
	    
	    loginFrame.setVisible(true);
		
	
	}
	
	public void adminLogin()
	{
        JFrame loginFrame = new JFrame("Login as Admin");
		
        loginFrame.setSize(355,290);
        loginFrame.setDefaultCloseOperation(3);
        loginFrame.setLayout(null);
        loginFrame.setLocationRelativeTo(null);
	    JLabel l1 = new JLabel();
	    
	    loginFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\adminpage.jpg")));
	    //frame.setLayout(new FlowLayout()); 
	    loginFrame.add(l1);
	    loginFrame.setSize(355,290);
	    
	    
	    JLabel headLbl = new JLabel("Login As Admin");
	    headLbl.setBounds(100, 20, 250, 50);
	    headLbl.setFont(new Font("Arial", Font.BOLD, 22));
	    headLbl.setForeground(Color.WHITE);
	    loginFrame.add( headLbl);
	    
	    
	    
	    JLabel l2 = new JLabel("Username:");
	    l2.setBounds(20, 80, 150, 50);
	    l2.setFont(new Font("Arial", Font.BOLD, 20));
	    l2.setForeground(Color.WHITE);
	    loginFrame.add(l2);
	    
	    
	    JTextField jtf= new JTextField();
	    jtf.setBounds(150,85,160,40);
		jtf.setFont(new Font("Arial", Font.BOLD, 20));
		
		loginFrame.add(jtf);
	    
	    JLabel l3 = new JLabel("Password:");
	    l3.setBounds(20, 130, 150, 50);
	    l3.setFont(new Font("Arial", Font.BOLD, 20));
	    l3.setForeground(Color.WHITE);
	    loginFrame.add(l3);
	    
	    JPasswordField jpf = new JPasswordField();
	    jpf.setBounds(150,135,160,40);
		jpf.setFont(new Font("Arial", Font.BOLD, 20));
		loginFrame.add(jpf);
	    
	    Icon icon = new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\loginbtn.png");
	    JButton jbt = new JButton(icon);
	    jbt.setBounds(20,185,90,30);
		jbt.setFont(new Font("Arial", Font.BOLD, 20));
		loginFrame.add(jbt);
	    
	    jbt.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      {
	    	 String uname= jtf.getText();
	         String pass= jpf.getText();
	         
	        
            
            
              if((uname.equals("admin") && pass.equals("Admin12345")))
	    	  {
	    		  loginFrame.dispose();
	    		  
	    		  MainCall obj = new MainCall();
	    		  obj.admin();
	    		  
	    		  
	    	  
	    	  }
	         
	        // System.out.println(uname + pass);
	    	  
	    	  
	    	  else
	    	  {
	    		     JOptionPane.showMessageDialog(null,"Wrong Username or Password","Error", JOptionPane.ERROR_MESSAGE);
	 	    		 jtf.setText(null);
	 	    		 jpf.setText(null);
	 	    		 jtf.requestFocusInWindow();
	    	  }
	    	  
	    	
	    	 
	    	 
	    	 
	    	    	 
	      }
 
 
 
		});
	    
	    
	   
	    
	    
	    loginFrame.setVisible(true);
		
	
	}
	
	public void home()
	{
        JFrame homeFrame = new JFrame("Home");
		
        homeFrame.setSize(800,600);
        homeFrame.setDefaultCloseOperation(3);
        homeFrame.setLayout(null);
        homeFrame.setLocationRelativeTo(null);
	    
        JLabel backgroundImgLbl = new JLabel();
	    
        homeFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\homepage.png")));
	    //frame.setLayout(new FlowLayout()); 
        homeFrame.add(backgroundImgLbl);
        homeFrame.setSize(815,625);
	    
	    JButton sellBtn = new JButton("Sell a car");
	    sellBtn.setBounds(550,200,150,40);
	    sellBtn.setFont(new Font("Arial", Font.BOLD, 25));
		homeFrame.add(sellBtn);
	    
		sellBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  homeFrame.dispose();
			   MainCall sellobj = new MainCall();
			   sellobj.sellform();
	    	  
	    	  
	      }
	      
		} );  
	    
	    
	    JButton buyBtn = new JButton("Buy a car");
	    buyBtn.setBounds(550,270,150,40);
	    buyBtn.setFont(new Font("Arial", Font.BOLD, 25));
		homeFrame.add(buyBtn);
	    
		buyBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	 
	    	  homeFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.buypage();
	    	  
	    	  
	      }
	      
		} );  
	    
		
		
		JLabel firstCarLbl = new JLabel("Buying your first car? click below:");
		firstCarLbl.setBounds(20, 450, 350, 50);
		firstCarLbl.setFont(new Font("Arial", Font.BOLD, 16));
		 firstCarLbl.setForeground(Color.white);
		homeFrame.add(firstCarLbl);
	    
	    JButton firstcarBtn = new JButton("Click");
	    firstcarBtn.setBounds(20,490,100,30);
	    firstcarBtn.setFont(new Font("Arial", Font.BOLD, 18));
	   
		homeFrame.add(firstcarBtn);
		
		 firstcarBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	   homeFrame.dispose();
			   MainCall tipsobj = new MainCall();
			   tipsobj.tips();
			   
			   
	    	  
	    	  
	      }
	      
		} );  
	    
	    Icon icon = new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\user.png");
	    
	    JButton userBtn = new JButton(icon);
	    userBtn.setBounds(750,10,40,40);
	    userBtn.setFont(new Font("Arial", Font.BOLD, 25));
		homeFrame.add(userBtn);
		userBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  /* homeFrame.dispose();
	    	   MainCall obj = new MainCall();
	    	   obj.user();*/
		   	  
	      }
	      
		} );  
	
	    
		homeFrame.setVisible(true);
		
		
		
		
	}
	
	public void register()
	{
        JFrame regFrame = new JFrame("SignUp");
		
        regFrame.setSize(800,600);
        regFrame.setLayout(null);
        regFrame.setDefaultCloseOperation(3);
	  
        regFrame.setLocationRelativeTo(null);
	    
        JLabel l5 = new JLabel();
	    
        regFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\signuppp.png")));
	    //frame.setLayout(new FlowLayout()); 
        regFrame.add(l5);
        regFrame.setSize(815,625);
	    
	    /*JLabel welcomeLbl = new JLabel("Welcome");
	    welcomeLbl .setBounds(100, 50, 200, 300);
	    welcomeLbl .setFont(new Font("Arial", Font.BOLD, 40));
	    welcomeLbl .setForeground(Color.white);
	    regFrame.add(welcomeLbl );*/
	    
	    
	    
	    /*JLabel signupLbl = new JLabel("SignUp");
	    signupLbl.setBounds(550, 25, 150, 70);
	    signupLbl.setFont(new Font("Arial", Font.BOLD, 30));
	    signupLbl.setForeground(Color.black);
	    regFrame.add(signupLbl);*/
	    
	    
	    JLabel fnamelbl = new JLabel("First Name: ");
	    fnamelbl.setBounds(415, 120, 150, 70);
	    fnamelbl.setFont(new Font("Arial", Font.BOLD, 18));
	    fnamelbl.setForeground(Color.black);
	    regFrame.add(fnamelbl);
	    
	    JTextField fnameTf= new JTextField();
	    fnameTf.setBounds(530,135,219,40);
	    fnameTf.setFont(new Font("Arial", Font.BOLD, 15));
		regFrame.add(fnameTf);
	    
	    
	    JLabel lnameLbl = new JLabel("LastName: ");
	    lnameLbl .setBounds(415, 195, 150, 70);
	    lnameLbl .setFont(new Font("Arial", Font.BOLD, 18));
	    lnameLbl .setForeground(Color.black);
	    regFrame.add(lnameLbl );
	    
	    JTextField lnameTf= new JTextField();
	    lnameTf.setBounds(530,210,219,40);
	    lnameTf.setFont(new Font("Arial", Font.BOLD, 15));
		regFrame.add(lnameTf);
	    
	   
	    
	    JLabel unameLbl = new JLabel("Username: ");
	    unameLbl.setBounds(415, 265, 150, 70);
	    unameLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    unameLbl.setForeground(Color.black);
	    regFrame.add(unameLbl);
	    
	    JTextField unameTf= new JTextField();
	    unameTf.setBounds(530,280,219,40);
	    unameTf.setFont(new Font("Arial", Font.BOLD, 15));
		regFrame.add(unameTf);
	    
	   
	   
	    
	    JLabel passLbl = new JLabel("Password:");
	    passLbl.setBounds(415, 330, 150, 70);
	    passLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    passLbl.setForeground(Color.black);
	    regFrame.add(passLbl);
	    
	    JPasswordField passfield = new JPasswordField();
	    passfield.setBounds(530,345,219,40);
	    passfield.setFont(new Font("Arial", Font.BOLD, 15));
		regFrame.add(passfield);
	    
	    JLabel emailLbl = new JLabel("Email :");
	    emailLbl.setBounds(415, 390, 150, 70);
	    emailLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    emailLbl.setForeground(Color.black);
	    regFrame.add(emailLbl);
	    
	    JTextField emailTf= new JTextField();
	    emailTf.setBounds(530,405,219,40);
	    emailTf.setFont(new Font("Arial", Font.BOLD, 15));
		regFrame.add(emailTf);
	    
	    
	    
	    
	   
	    Icon icon = new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\reg.png");
	    
	    JButton regBtn = new JButton(icon);
	    regBtn.setBounds(570,500,90,30);
	    regBtn.setFont(new Font("Arial", Font.BOLD, 15));
		regFrame.add(regBtn);
	    
		regBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      {
	    	  String uemail = emailTf.getText();
	    	  String upass = passfield.getText();
	    	  String fname = fnameTf.getText();
	    	  String lname = lnameTf.getText();
	    	  String uname = unameTf.getText();
	    	  
	    	 
              String emailRegex = "[a-z0-9.]+@[a-z]+[.[a-z]]+$";
              String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
              //String addressRegex = "[A-Za-z0-9'\\.\\-\\s\\,\\/]+$";

              // condition
              if(fname.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter First name");
            	  
              }
              
              else if(lname.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter Last name");
            	  
              }
              
              else if(uname.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter User name");
            	  
              }
              

              else if (!Pattern.matches(emailRegex, uemail)) {
                  JOptionPane.showMessageDialog(null, "In-valid E-mail");
              }


              else if (!Pattern.matches(passRegex, upass)) {
                  JOptionPane.showMessageDialog(null, "Your password is not secure. Please set a strong password \r\n"
                          + "with 8 digits using uppercase, lowercase and special character");
              }


              else {
            	  
            	  try
    	    	  {
    	    		  Class.forName("com.mysql.jdbc.Driver");
                      Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user", "root", "");

                      String query = " INSERT INTO `user_info`(`FName`, `LName`, `username`, `password`, `email`) VALUES (?,?,?,?,?)";
                      PreparedStatement ps = c1.prepareStatement(query);
                    //  FileInputStream uimage = new FileInputStream(imagePath);

                      ps.setString(1, fnameTf.getText());
                      ps.setString(2, lnameTf.getText());
                      ps.setString(3, unameTf.getText());
                      ps.setString(4, passfield.getText());
                      
                      ps.setString(5, emailTf.getText());
                      

                      int i = ps.executeUpdate();
                      ps.close();
                      c1.close();
                      JOptionPane.showMessageDialog(null, "Registration Complete Successfully");
                      
                      regFrame.dispose();
    	    		
    	    		  new MainCall().login();
    	    		 
    	    		 
    	    		 
    	    		 
     		  	    		  
    	    	  }
    	    	  
    	    	  catch(Exception ex1)
    	    	  {
    	    		  ex1.printStackTrace();
    	    		  
    	    		  
    	    	  }
    	    	  
            	  
            	  
              }
	    	  
	    	  
	      }
	      
		} );  
	    
	     
	    
	    regFrame.setVisible(true);
		
		
		
		
	}
	
	
	private String imagePath;
    private int flag = 0;
    
	public void sellform()
	{
		
		
        JFrame sellformFrame = new JFrame("Sell form");
		
        sellformFrame.setSize(800,600);
        sellformFrame.setLayout(null);
        sellformFrame.setDefaultCloseOperation(3);
	  
        sellformFrame.setLocationRelativeTo(null);
	    
        JLabel l5 = new JLabel();
	    
        sellformFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\sellform.png")));
	    //frame.setLayout(new FlowLayout()); 
        sellformFrame.add(l5);
        sellformFrame.setSize(815,625);
	    
	   	    
	    
	    JLabel headinglbl = new JLabel("Put Your Ad Here");
	    headinglbl.setBounds(290, 25, 300, 70);
	    headinglbl.setFont(new Font("Arial", Font.BOLD, 30));
	    headinglbl.setForeground(Color.white);
	    sellformFrame.add(headinglbl);
	    
	    
	    JLabel modelLbl = new JLabel("Car Model: ");
	    modelLbl.setBounds(30, 100, 150, 70);
	    modelLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    modelLbl.setForeground(Color.white);
	    sellformFrame.add(modelLbl);
	    
	    JTextField modelTf= new JTextField();
	    modelTf.setBounds(150,115,219,40);
	    modelTf.setFont(new Font("Arial", Font.BOLD, 15));
		sellformFrame.add( modelTf);
	    
	    
	    JLabel detailsLbl = new JLabel("Car Details: ");
	    detailsLbl.setBounds(30, 165, 150, 70);
	    detailsLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    detailsLbl.setForeground(Color.white);
	    sellformFrame.add( detailsLbl);
	    
	    JTextField detailsTf= new JTextField();
	    detailsTf.setBounds(150,180,219,40);
	    detailsTf.setFont(new Font("Arial", Font.BOLD, 15));
		sellformFrame.add(detailsTf);
	    
	   
	    
	    JLabel papersLbl = new JLabel("Papers: ");
	    papersLbl.setBounds(30, 230, 150, 70);
	    papersLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    papersLbl.setForeground(Color.white);
	    sellformFrame.add(papersLbl);
	    
	    JTextField papersTf= new JTextField();
	    papersTf.setBounds(150,245,219,40);
	    papersTf.setFont(new Font("Arial", Font.BOLD, 15));
		sellformFrame.add(papersTf);
	    
	   
	   
	    
	    JLabel priceLbl = new JLabel("Price:");
	    priceLbl.setBounds(30, 295, 150, 70);
	    priceLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    priceLbl.setForeground(Color.white);
	    sellformFrame.add(priceLbl);
	    
	    JTextField priceTf = new JTextField();
	    priceTf.setBounds(150,310,219,40);
	    priceTf.setFont(new Font("Arial", Font.BOLD, 15));
		sellformFrame.add(priceTf);
	    
	    JLabel phoneLbl = new JLabel("Phone :");
	    phoneLbl.setBounds(30, 360, 150, 70);
	    phoneLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    phoneLbl.setForeground(Color.white);
	    sellformFrame.add(phoneLbl);
	    
	    JTextField phoneField= new JTextField();
	    phoneField.setBounds(150,375,219,40);
	    phoneField.setFont(new Font("Arial", Font.BOLD, 15));
		sellformFrame.add(phoneField);
	    
	    JLabel locLbl = new JLabel("Location :");
	    locLbl.setBounds(30, 425, 150, 70);
	    locLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    locLbl.setForeground(Color.white);
	    sellformFrame.add(locLbl);
	    
	    JTextField locTf= new JTextField();
	    locTf.setBounds(150,440,219,40);
	    locTf.setFont(new Font("Arial", Font.BOLD, 15));
		sellformFrame.add(locTf);
	    
	    JLabel picLbl = new JLabel("Picture:");
	    picLbl.setBounds(580, 90, 150, 70);
	    picLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    picLbl.setForeground(Color.white);
	    sellformFrame.add(picLbl);
	    
	    JLabel addImageLabel = new JLabel();
        addImageLabel.setBounds(500, 140, 250, 250);
        addImageLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        sellformFrame.add(addImageLabel);
	    
       
        
        JButton addImageBtn = new JButton("Choose File");
        addImageBtn.setBounds(580, 410, 110, 30);
        addImageBtn.setFont(new Font("Arial", Font.BOLD, 15)); 
        addImageBtn.setBorder(null);
        sellformFrame.add(addImageBtn);
        
        
        
        JButton home = new JButton("Home");
        home.setBounds(700, 10, 80, 30);
        home.setFont(new Font("Arial", Font.BOLD, 25)); 
        home.setBorder(null);
        sellformFrame.add(home);
        
        home.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  sellformFrame.dispose();
			   MainCall sellobj = new MainCall();
			   sellobj.home();
	    	  
	    	  
	      }
	      
		} );  
        
        
        
        addImageBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == addImageBtn) {
                    try {
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setAcceptAllFileFilterUsed(false);
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "jpeg");
                        fileChooser.addChoosableFileFilter(filter);

                        int result = fileChooser.showDialog(null, "Open");
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File file = fileChooser.getSelectedFile();
                            imagePath = file.getAbsolutePath();
                           ImageIcon chooseImage = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(250, 250,
                                    Image.SCALE_SMOOTH));
                            addImageLabel.setIcon(chooseImage);
                            flag = 1;

                        } else if (result == JFileChooser.CANCEL_OPTION) {
                            JOptionPane.showMessageDialog(null, "No file selected");
                        }
                    } catch (Exception e2) {
                        System.err.println("image error: " + e2);
                    }
                }
            }
        });
	    
	    
	   
         Icon icon = new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\reg.png");
	    
	    JButton regBtn = new JButton(icon);
	    regBtn.setBounds(350,500,90,30);
	    regBtn.setFont(new Font("Arial", Font.BOLD, 15));
	    regBtn.setBorder(null);
		sellformFrame.add(regBtn);
	    
		regBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      {
	    	  
	    	  String mobileRegex = "(\\+88)?01[3-9]\\d{8}";
	    	  String mobilenum = phoneField.getText();
	    	  String model = modelTf.getText();
	    	  String details = detailsTf.getText();
	    	  String papers = papersTf.getText();
	    	  String price = priceTf.getText();
	    	  String location = locTf.getText();
	    	  
	    	  if(model.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter car model");
            	  
              }
	    	  else if(details.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter car details");
            	  
              }
	    	  else if(papers.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter car papers");
            	  
              }
	    	  
	    	  else if(price.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter car price");
            	  
              }
	    	  else if(location.equals(""))
              {
            	  JOptionPane.showMessageDialog(null, "Please enter location");
            	  
              }
	    	  
	    	  else if (!Pattern.matches(mobileRegex, mobilenum)) {
                  JOptionPane.showMessageDialog(null, "In-valid Phone Number");
              }
	    	  
	    	  else
	    	  {
	    		  try
		    	  {
		    		  Class.forName("com.mysql.jdbc.Driver");
		    		  Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user","root","");
		    		  String query =" INSERT INTO `ad_info`(`Carmodel`, `cardetails`, `papers`, `price`, `phone`,`Location`, `pic`) VALUES (?,?,?,?,?,?,?)";
		    		  
		    		  PreparedStatement ps = c1.prepareStatement(query);
		    		  FileInputStream uimage = new FileInputStream(imagePath);
		    		 
		    		  ps.setString(1,modelTf.getText() );
		    		  
		    		  ps.setString(2,detailsTf.getText() );
		    		  
		    		  ps.setString(3,  papersTf.getText() );
		    		 
		    		  ps.setString(4,priceTf.getText() );
		    		 
		    		  ps.setString(5,phoneField.getText() );
		    		  
		    		  ps.setString(6,locTf.getText() );
		    		
		    		  ps.setBinaryStream(7, uimage, uimage.available());
		    		  int i = ps.executeUpdate();
		    		 
		    		 ps.close();
		    		 c1.close();
		    		 sellformFrame.dispose();
		    		 JOptionPane.showMessageDialog(null,"Registration Succesful ");
		    		 new MainCall().sellform();
		    		 
		    		 
		    		 
		    		 
	 		  	    		  
		    	  }
		    	  
		    	  catch(Exception ex1)
		    	  {
		    		  ex1.printStackTrace();
		    		  
		    		  
		    	  }
	    		  
	    	  }
	    	  
	    	 
	    	  
	      }
	      
		} );  
	    
	    
	     
	    
	    sellformFrame.setVisible(true);
		
	}
	
	//JButton jbt3;
	 String car;
	 private JTextField jtf5;
	
	
	public void buypage()
	{
		JFrame buypageFrame = new JFrame("Buy page");
		buypageFrame.setSize(815,625);
		//frame4.setLayout(new FlowLayout());
		buypageFrame.setLayout(null);
		buypageFrame.setDefaultCloseOperation(3);
		  
		buypageFrame.setLocationRelativeTo(null);
		
          JLabel l5 = new JLabel();
	    
        buypageFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\buypage.png")));
	    //frame.setLayout(new FlowLayout()); 
        buypageFrame.add(l5);
        buypageFrame.setSize(815,645);
	    
		//buypageFrame.getContentPane().setBackground(Color.decode("#87CEEB"));
	    
		JLabel titleLbl = new JLabel("Look for a car and click for more:");
		titleLbl.setBounds(10, 40, 355, 70);
		titleLbl.setFont(new Font("Arial", Font.BOLD, 20));
		titleLbl.setForeground(Color.BLACK);
	    buypageFrame.add(titleLbl);
	    
	    JLabel headLbl = new JLabel("CarKeynon");
	    headLbl.setBounds(10, 5, 350, 50);
	    headLbl.setFont(new Font("Arial", Font.BOLD, 30));
	    headLbl.setForeground(Color.BLACK);
	    buypageFrame.add(headLbl);
	    
	    JLabel adLbl = new JLabel("Just Buy and Drive");
	    adLbl.setBounds(580, 555, 350, 50);
	    adLbl.setFont(new Font("Arial", Font.BOLD, 20));
	    adLbl.setForeground(Color.white);
	    buypageFrame.add(adLbl);
	
	
	  
		DefaultTableModel dtm = new DefaultTableModel();
		JTable tbl = new JTable(dtm);
		 tbl.setPreferredScrollableViewportSize(new Dimension(495,350));
	     tbl.setFillsViewportHeight(true);
	     tbl.setBackground(Color.decode("#87CEEB"));
	     JScrollPane sp = new JScrollPane(tbl,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	     sp.setBounds(10,110,610,350);
	   
	     buypageFrame.add(sp);
	     
	        dtm.addColumn("Car Model");
		    dtm.addColumn("Price");
		    dtm.addColumn("Location");
		    
		   
		  
		    try
		  	  {
		  		  Class.forName("com.mysql.jdbc.Driver");
		  		  Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user","root","");
		  		  
		  		  Statement st = c1.createStatement();
		  		  String query = "Select Carmodel,Price,location from ad_info";
		  		
		  		  ResultSet rs = st.executeQuery(query);
		  		  while(rs.next())
		           {
		             String Carmodel = rs.getString("Carmodel");
		             String price = rs.getString("price");
		             String location = rs.getString("location");
		             
		             
		             
		            
		             dtm.addRow(new Object[]{Carmodel,price,location});
		             tbl.setModel(dtm);
		          }
		  		  
		  		 
			  	    		  
		  	  }
		  	  
		  	  catch(Exception ex1)
		  	  {
		  		  ex1.printStackTrace();
		  		  
		  		  
		  	  }
		    
		    
		    tbl.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){

                    if(e.getButton()==MouseEvent.BUTTON1) {
                    	
                    	 //System.out.println("okkkkk");
                    	 int row = tbl.rowAtPoint(e.getPoint());
                    	String value = String.valueOf(tbl.getModel().getValueAt(row, 0));
                    	//System.out.println(value);

            		    try
            		  	  {
            		  		  Class.forName("com.mysql.jdbc.Driver");
            		  		  Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user","root","");
            		  		  
            		  		  Statement st = c1.createStatement();
            		  		  String query = "Select * from ad_info where Carmodel = '"+value+"'";
            		  		
            		  		  ResultSet rs = st.executeQuery(query);
            		  		  //while(rs.next())
            		  		  rs.next();
            		           {
            		             String Carmodel = rs.getString("Carmodel");
            		             String details= rs.getString("cardetails");
            		             String paper = rs.getString("papers");
            		             String price = rs.getString("price");
            		             String phone = rs.getString("phone");
            		             String location = rs.getString("Location");
            		             byte[] pic =  rs.getBytes("pic");
            		             ImageIcon getimg = new ImageIcon(pic);
            		            
            			    	 MainCall homeobj = new MainCall();
            					 homeobj.cardetails(Carmodel,details,paper,price,phone,location,getimg);
            					 buypageFrame.dispose();
            		             
            		             
            		             
            		             
            		             
            		             
            		             
            		            
            		             
            		          }
            		  		  
            		  		 
            			  	    		  
            		  	  }
            		  	  
            		  	  catch(Exception ex1)
            		  	  {
            		  		  ex1.printStackTrace();
            		  		  
            		  		  
            		  	  }
                    	
                    	
                    	
                    	
                    	
                        
                    }
                }
            });
	     
	     
	     
	    
	    
	   
	    
	    
	    
	    JButton homeBtn = new JButton("Home");
	    homeBtn.setBounds(700,10,90,30);
		homeBtn.setFont(new Font("Arial", Font.BOLD, 15));
		buypageFrame.add(homeBtn);
	    
	    homeBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	   buypageFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.home();
			   
			   
	    	  
	    	  
	      }
	      
		} );  
	    
	    
	     
	    
		
       
	  
	    
	   
		
	    buypageFrame.setVisible(true);
		
	}
	
	
	
	
	public void user()
	{
		JFrame userFrame = new JFrame("User Info");
		userFrame.setSize(800,600);
		userFrame.setLayout(null);
		userFrame.setDefaultCloseOperation(3);
	  
		userFrame.setLocationRelativeTo(null);
	    
        JLabel backgroundImgLbl = new JLabel();
	    
        userFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\userbackground.png")));
	    //frame.setLayout(new FlowLayout()); 
        
        
        
        userFrame.add(backgroundImgLbl);
        userFrame.setSize(815,625);
        
        JLabel insLbl = new JLabel("Put your Password below:");
        insLbl.setBounds(20, 10, 250, 30);
        insLbl.setFont(new Font("Arial", Font.BOLD, 20));
        insLbl.setForeground(Color.white);
	    userFrame.add(insLbl);
        
	    /*JLabel lb11 = new JLabel("Password:");
	    lb11.setBounds(380, 320, 150, 70);
	    lb11.setFont(new Font("Arial", Font.BOLD, 20));
	    lb11.setForeground(Color.white);
	    userFrame.add(lb11);*/
	    
	    JPasswordField jpf1 = new JPasswordField();
	    jpf1.setBounds(20,40,219,40);
		jpf1.setFont(new Font("Arial", Font.BOLD, 15));
		userFrame.add(jpf1);
		
		JButton srcBtn = new JButton("Search");
		srcBtn.setBounds(240,45,90,30);
		srcBtn.setFont(new Font("Arial", Font.BOLD, 15));
		userFrame.add(srcBtn);
	    
        
		srcBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	   String pass = jpf1.getText();
	    	   System.out.println(pass);
	    	  try
		  	  {
		  		  Class.forName("com.mysql.jdbc.Driver");
		  		  Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user","root","");
		  		  
		  		  Statement st = c1.createStatement();
		  		  String query = "Select * from user_info where username = '"+pass+"'";
		  		
		  		  ResultSet rs = st.executeQuery(query);
		  		  //while(rs.next())
		  		  rs.next();
		           {
		             String Username = rs.getString("username");
		             System.out.println(Username);
		             String Fname= rs.getString("FName");
		             System.out.println(Fname);
		             String Lname = rs.getString("LName");
		             String Email = rs.getString("email");
		             String Password = rs.getString("password");
		             
		            JLabel heading = new JLabel(Username);
		     	    heading.setBounds(190, 20, 450, 70);
		     	    heading.setFont(new Font("Arial", Font.BOLD, 25));
		     	    heading.setForeground(Color.BLACK);
		     	    userFrame.add(heading);
		      	
		             
		             
		             JLabel nameLbl = new JLabel("First Name: ");
		     	    nameLbl.setBounds(30, 90, 150, 70);
		     	    nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		     	    nameLbl.setForeground(Color.white);
		     	    userFrame.add(nameLbl);
		     	    
		     	    JTextField fnameTf= new JTextField(Fname);
		     	    fnameTf.setBounds(150,105,219,40);
		     	    fnameTf.setEditable(false);
		     		fnameTf.setFont(new Font("Arial", Font.BOLD, 15));
		     		userFrame.add(fnameTf);
		     	    
		     	   
		     	    
		     	    
		     	    
		     	    
		     	    JLabel detailsLbl = new JLabel("Last Name: ");
		     	    detailsLbl.setBounds(30, 175, 150, 40);
		     	    detailsLbl.setFont(new Font("Arial", Font.BOLD, 20));
		     	    detailsLbl.setForeground(Color.white);
		     	    userFrame.add( detailsLbl);
		     	    
		     	    JTextField lnametf= new JTextField(Lname);
		     	    lnametf.setBounds(150,180,219,180);
		     	    lnametf.setEditable(false);
		     	    lnametf.setFont(new Font("Arial", Font.BOLD, 15));
		     		
		     	   
		     	    userFrame.add(lnametf);
		     	    
		     	   
		     	    
		     	    JLabel emailLbl = new JLabel("Email: ");
		     	    emailLbl.setBounds(30, 345, 150, 70);
		     	    emailLbl.setFont(new Font("Arial", Font.BOLD, 20));
		     	    emailLbl.setForeground(Color.white);
		     	    userFrame.add(emailLbl);
		     	    
		     	    JTextField emailTf= new JTextField(Email);
		     	    emailTf.setBounds(150,360,219,40);
		     	    emailTf.setEditable(false);
		     	    emailTf.setFont(new Font("Arial", Font.BOLD, 15));
		     	    emailTf.add(emailTf);
		     	    
		     	    
		     	    
		     	   
		     	    
		     	    JLabel passwordLbl = new JLabel("Password:");
		     	    passwordLbl.setBounds(30, 410, 150, 70);
		     	    passwordLbl.setFont(new Font("Arial", Font.BOLD, 20));
		     	    passwordLbl.setForeground(Color.white);
		     	    userFrame.add(passwordLbl);
		     	    
		     	    JTextField passwordTf = new JTextField(Password);
		     	    passwordTf .setBounds(150,425,219,40);
		     	    passwordTf .setEditable(false);
		     	    passwordTf .setFont(new Font("Arial", Font.BOLD, 15));
		     	    userFrame.add(passwordTf );
		     	    
		     	    
		      
		       
		             
		            
		             
		          }
		  		  
		  		 
			  	    		  
		  	  }
		  	  
		  	  catch(Exception ex1)
		  	  {
		  		  ex1.printStackTrace();
		  		  
		  		  
		  	  }
	    	  
	    	  
	      }
	      
		} );  
        
      
	   
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(670, 485, 80, 30);
        backBtn.setFont(new Font("Arial", Font.BOLD, 25)); 
        backBtn.setBorder(null);
        userFrame.add(backBtn);
        
        backBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  userFrame.dispose();
			   MainCall backobj = new MainCall();
			   backobj.home();
	    	  
	    	  
	      }
	      
		} );  

       
        
        
        userFrame.setVisible(true);
				
				
	}
	
	public void tips()
	{
		JFrame tipsFrame = new JFrame("User Info");
		tipsFrame.setSize(370,430);
		tipsFrame.setLayout(null);
		tipsFrame.setDefaultCloseOperation(3);
	  
		tipsFrame.setLocationRelativeTo(null);
		
        JLabel tipsImage = new JLabel();
	    
        tipsFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\tips.png")));
	    
        tipsFrame.add(tipsImage);
        tipsFrame.setSize(400,480);
	    
        JButton homeBtn = new JButton("Home");
	    homeBtn.setBounds(292,14,78,30);
		homeBtn.setFont(new Font("Arial", Font.BOLD, 15));
		tipsFrame.add(homeBtn);
	    
	    homeBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	   tipsFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.home();
			   
			   
	    	  
	    	  
	      }
	      
		} );  
        
        
		tipsFrame.setVisible(true);
		
	}
	
	
	public void cardetails(String carmodel, String details, String papers,String price , String phone ,String loc , ImageIcon img )
	{
		   JFrame detailsFrame = new JFrame("CarDetails");
		   detailsFrame.setSize(815,625);
		   detailsFrame.setLayout(null);
		   detailsFrame.setDefaultCloseOperation(3);
	  
		   detailsFrame.setLocationRelativeTo(null);
	       
	       JLabel l5 = new JLabel();
	    
	       detailsFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\lambo.png")));
	        //frame.setLayout(new FlowLayout()); 
	       detailsFrame.add(l5);
	       detailsFrame.setSize(815,625);
	        
	        
	        JLabel heading = new JLabel("Know more about your desired car");
		    heading.setBounds(190, 20, 450, 70);
		    heading.setFont(new Font("Arial", Font.BOLD, 25));
		    heading.setForeground(Color.BLACK);
		    detailsFrame.add(heading);
	       
	        
	        
	        
	        JLabel nameLbl = new JLabel("Car Model: ");
		    nameLbl.setBounds(30, 90, 150, 70);
		    nameLbl.setFont(new Font("Arial", Font.BOLD, 20));
		    nameLbl.setForeground(Color.white);
		    detailsFrame.add(nameLbl);
		    
		    JTextField nameTf= new JTextField(carmodel);
		    nameTf.setBounds(150,105,219,40);
		    nameTf.setEditable(false);
			nameTf.setFont(new Font("Arial", Font.BOLD, 15));
			detailsFrame.add(nameTf);
		    
		   
		    
		    
		    
		    
		    JLabel detailsLbl = new JLabel("Car Details: ");
		    detailsLbl.setBounds(30, 175, 150, 40);
		    detailsLbl.setFont(new Font("Arial", Font.BOLD, 20));
		    detailsLbl.setForeground(Color.white);
		    detailsFrame.add( detailsLbl);
		    
		    JTextField detailsTf= new JTextField(details);
		    detailsTf.setBounds(150,180,219,180);
		    detailsTf.setEditable(false);
		    detailsTf.setFont(new Font("Arial", Font.BOLD, 15));
			JScrollPane sp = new JScrollPane(detailsTf,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		    sp.setBounds(150,175,219,150);
		   
		   
		    detailsFrame.add(sp);
		    
		   
		    
		    JLabel papersLbl = new JLabel("Papers: ");
		    papersLbl.setBounds(30, 345, 150, 70);
		    papersLbl.setFont(new Font("Arial", Font.BOLD, 20));
		    papersLbl.setForeground(Color.white);
		    detailsFrame.add(papersLbl);
		    
		    JTextField papersTf= new JTextField(papers);
		    papersTf.setBounds(150,360,219,40);
		    papersTf.setEditable(false);
		    papersTf.setFont(new Font("Arial", Font.BOLD, 15));
		    detailsFrame.add(papersTf);
		    
		    
		    
		   
		    
		    JLabel priceLbl = new JLabel("Price:");
		    priceLbl.setBounds(30, 410, 150, 70);
		    priceLbl.setFont(new Font("Arial", Font.BOLD, 20));
		    priceLbl.setForeground(Color.white);
		    detailsFrame.add(priceLbl);
		    
		    JTextField priceTf = new JTextField(price);
		    priceTf.setBounds(150,425,219,40);
		    priceTf.setEditable(false);
		    priceTf.setFont(new Font("Arial", Font.BOLD, 15));
		    detailsFrame.add(priceTf);
		    
		    JLabel phoneLbl = new JLabel("Phone :");
		    phoneLbl.setBounds(30, 470, 150, 70);
		    phoneLbl.setFont(new Font("Arial", Font.BOLD, 20));
		    phoneLbl.setForeground(Color.white);
		    detailsFrame.add(phoneLbl);
		    
		    JTextField phoneTf= new JTextField(phone);
		    phoneTf.setBounds(150,485,219,40);
		    phoneTf.setEditable(false);
		    phoneTf.setFont(new Font("Arial", Font.BOLD, 15));
		    detailsFrame.add(phoneTf);
		    
		    JLabel locLbl = new JLabel("Location: ");
		    locLbl.setBounds(500, 400, 150, 70);
		    locLbl.setFont(new Font("Arial", Font.BOLD, 20));
		    locLbl.setForeground(Color.white);
		    detailsFrame.add(locLbl);
		    
		    JTextField locTf= new JTextField(loc);
		    locTf.setBounds(600,415,150,40);
		    locTf.setEditable(false);
		    locTf.setFont(new Font("Arial", Font.BOLD, 15));
		    detailsFrame.add(locTf);
		    
		    JLabel addImageLbl = new JLabel();
	        addImageLbl.setBounds(500, 100, 250, 250);
	        addImageLbl.setBorder(BorderFactory.createLineBorder(new Color(35, 36, 40)));

	       // ImageIcon getimg = new ImageIcon();
	        Image im = img.getImage();
	        Image MyImg = im.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
	        ImageIcon setimg = new ImageIcon(MyImg);
	        addImageLbl.setIcon(setimg);
	        
	        JButton backBtn = new JButton("Back");
	        backBtn.setBounds(670, 485, 80, 30);
	        backBtn.setFont(new Font("Arial", Font.BOLD, 25)); 
	        backBtn.setBorder(null);
	        detailsFrame.add(backBtn);
	        
	        backBtn.addActionListener(new ActionListener()
			{
		      public void actionPerformed(ActionEvent e)
		      { 
		    	  detailsFrame.dispose();
				   MainCall backobj = new MainCall();
				   backobj.buypage();
		    	  
		    	  
		      }
		      
			} );  

	        detailsFrame.add(addImageLbl);
		   
		    
		   
	        detailsFrame.setVisible(true);
	       
		
		
	}
	
	public void adminview()
	{
		
		JFrame adminFrame = new JFrame("Admin view");
		adminFrame.setSize(815,625);
		//frame4.setLayout(new FlowLayout());
		adminFrame.setLayout(null);
		adminFrame.setDefaultCloseOperation(3);
		  
		adminFrame.setLocationRelativeTo(null);
		
		JLabel l5 = new JLabel();
	    
	       adminFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\tablebg.png")));
	        //frame.setLayout(new FlowLayout()); 
	       adminFrame.add(l5);
	       adminFrame.setSize(815,625);
	        
		
	    
		JLabel titleLbl = new JLabel("All user information table:");
		titleLbl.setBounds(230, 20, 350, 70);
		titleLbl.setFont(new Font("Arial", Font.BOLD, 25));
		titleLbl.setForeground(Color.white);
		adminFrame.add(titleLbl);
	
	  
		DefaultTableModel dtm = new DefaultTableModel();
		JTable usertbl = new JTable(dtm);
		 usertbl.setPreferredScrollableViewportSize(new Dimension(495,350));
	     usertbl.setFillsViewportHeight(true);
	     usertbl.setBackground(Color.GRAY);
	     JScrollPane sp = new JScrollPane(usertbl,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	     sp.setBounds(43,90,713,460);
	   
	     adminFrame.add(sp);
	        
	        dtm.addColumn("Username");
	        dtm.addColumn("First_Name");
		    dtm.addColumn("Last_Name");
		    dtm.addColumn("Password");
		    dtm.addColumn("Email");
		    
		   
		  
		    try
		  	  {
		  		  Class.forName("com.mysql.jdbc.Driver");
		  		  Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user","root","");
		  		  
		  		  Statement st = c1.createStatement();
		  		  String query = "Select * from user_info";
		  		
		  		  ResultSet rs = st.executeQuery(query);
		  		  while(rs.next())
		           {
		             String username = rs.getString("username");
		             String fname = rs.getString("Fname");
		             String lname = rs.getString("Lname");
		             String  pass = rs.getString("password");
		             String email = rs.getString("email");
		             
		             
		             
		            
		             dtm.addRow(new Object[]{username,fname,lname,pass,email});
		             usertbl.setModel(dtm);
		          }
		  		  
		  		 
			  	    		  
		  	  }
		  	  
		  	  catch(Exception ex1)
		  	  {
		  		  ex1.printStackTrace();
		  		  
		  		  
		  	  }

	    
	    JButton homeBtn = new JButton("Home");
	    homeBtn.setBounds(700,10,90,30);
		homeBtn.setFont(new Font("Arial", Font.BOLD, 15));
		adminFrame.add(homeBtn);
	    
	    homeBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	   adminFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.home();
			   
			   
	    	  
	    	  
	      }
	      
		} ); 
	   
		
	    adminFrame.setVisible(true);
		
	}
	
	
	public void admin()
	{
		JFrame adminFrame = new JFrame("Admin");
		adminFrame.setSize(355,290);
		adminFrame.setLayout(null);
		adminFrame.setDefaultCloseOperation(3);
	  
		adminFrame.setLocationRelativeTo(null);
		
        JLabel tipsImage = new JLabel();
	    
        adminFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Ruhan\\Pictures\\Saved Pictures\\adminpage.jpg")));
	    
        adminFrame.add(tipsImage);
        adminFrame.setSize(355,290);
        
        
	    
        JButton homeBtn = new JButton("Home");
	    homeBtn.setBounds(90,70,150,30);
		homeBtn.setFont(new Font("Arial", Font.BOLD, 25));
		adminFrame.add(homeBtn);
	    
	    homeBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  adminFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.home();
			   
			   
	    	  
	    	  
	      }
	      
		} );  
	    
	    JButton viewBtn = new JButton("Admin View");
	    viewBtn.setBounds(90,130,150,30);
	    viewBtn.setFont(new Font("Arial", Font.BOLD, 20));
	    adminFrame.add(viewBtn);
	    
	    viewBtn.addActionListener(new ActionListener()
		{
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  adminFrame.dispose();
			   MainCall homeobj = new MainCall();
			   homeobj.adminview();
			   
			   
	    	  
	    	  
	      }
	      
		} );  
	    
	    
	    
	    
        
        
	    adminFrame.setVisible(true);
		
	}
	
	
	
	
	
}
