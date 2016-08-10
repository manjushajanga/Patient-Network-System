import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.jdbc.ScriptRunner;

import com.mysql.jdbc.Statement;

import net.miginfocom.swing.MigLayout;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConnectDB extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel contentPane;
	static String loggedName;
	JLabel l1, l2, l3, l4, l5, l6, l7,l8,l9,sl1,sl2,sl3;
    JTextField tf1, tf2, tf3,stf1;
    JTextField fn,ln,agef,emailf;
    JTextField search;
    JButton btn1, btn2,sbtn1, sbtn2;
    JPasswordField p1, p2,sp1;
    JRadioButton rd1,rd2,g1,g2;
    JDatePickerImpl datepicker;
    UtilDateModel model;
    JPanel contentpane1,contentpane2,contentpane3;
    JComboBox combobox1;
    static JTable table;
   static GridBagConstraints left ;
   static GridBagConstraints right ;
   static GridBagConstraints top;
    public void layoutSet(JPanel panel)
    {
    	GridBagLayout layout=new GridBagLayout();
		panel.setLayout(layout);
		left= new GridBagConstraints();
		
        left.anchor = GridBagConstraints.EAST;
        top= new GridBagConstraints();
        top.anchor = GridBagConstraints.NORTH;
        top.weightx = 2.0;
       
        top.fill = GridBagConstraints.CENTER;
        top.gridwidth = GridBagConstraints.REMAINDER;
        right = new GridBagConstraints();
        right.weightx = 1.0;
        top.weighty=0.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectDB frame = new ConnectDB();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 /**
	 * Create the frame.
	 */
	public ConnectDB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 280);
		 setTitle("Patients Network");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPatientsNetwork = new JLabel("Patients Network");
		lblPatientsNetwork.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
					
					setResizable(false);
					
					contentpane2=new JPanel();
					contentpane2.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentpane2);
					layoutSet(contentpane2);
					setTitle("Patients Login");
					
					  sl1 = new JLabel("Patients Login Form");
					    sl1.setForeground(Color.BLUE);
				        sl1.setFont(new Font("Serif", Font.BOLD, 20));
				        sl2 = new JLabel("      E-Mail ID:          ");
				        sl3 = new JLabel("      Password:           ");
				        stf1 = new JTextField();
					    sp1 = new JPasswordField();
					    
						
						 sbtn1 = new JButton("Login");
						    sbtn1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try {
										
										  loggedName = stf1.getText();
										 char[] np1=sp1.getPassword();
										 String npw1=String.copyValueOf(np1);
										 Class.forName("com.mysql.jdbc.Driver");
										Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
										Statement stmt = null;
									    String query ="select email,password from patients where email= '"+loggedName+"' and password='"+npw1+"'"; 
									    stmt = (Statement) con.createStatement();
								        ResultSet rs = stmt.executeQuery(query);
       							        if (rs.next()) {
							        	
								        	menubar();
								        	display_patient();

								        }
								        else
								        {
								        	JOptionPane.showMessageDialog(null,"Invalid Username or Password ")	;
								        	stf1.setText("");
							                sp1.setText("");
								        }
										 
									}
									catch(Exception e2)
									{
										JOptionPane.showMessageDialog(null,e2.getMessage())	;
									}
									
									
									}
						    });
						    
						    
						      sbtn2 = new JButton("Cancel");
						        sbtn2.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										contentpane2.setVisible(false);
										setContentPane(contentPane);
										contentPane.setVisible(true);
										 setTitle("Patients Network");
										
											
										}
							    });
				        
					    contentpane2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
					    contentpane2.add(sl1,top);
					    contentpane2.add(sl2, left); contentpane2.add(stf1, right);
					    contentpane2.add(sl3, left); contentpane2.add(sp1, right);
					    contentpane2.add(sbtn1, left); contentpane2.add(sbtn2, left);
					    
					    setVisible(true);
				    
			
					    
								
								}
					
					catch(Exception e2)
					{
						JOptionPane.showMessageDialog(null,e2.getMessage())	;
					}
					
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					setResizable(false);
					
					contentpane1=new JPanel();
					contentpane1.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentpane1);
					layoutSet(contentpane1);
					setTitle("Registration Form for Patients");
					
				    btn1 = new JButton("Submit");
				    btn1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								
								 String s1 = tf1.getText();
								 if(s1.matches( "[a-zA-Z][a-zA-Z]*" ))
								 {
								 String s2=tf2.getText();
								 if(s2.matches( "[a-zA-Z][a-zA-Z]*" ))
								 {
								 String s3=tf3.getText();
								 if(s3.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
								 {
								 char[] np1=p1.getPassword();
								 if(np1.length>=4)
								 {
								 char[] np2=p2.getPassword();
								 if(Arrays.equals(np1,np2))
								 {
								 String npw1=null;
								 npw1=String.copyValueOf(np1);
								 char[] gender=new char[1];
								 if(rd1.isSelected()) gender[0]='m'; else gender[0]='f';
								Date selectedDate = (Date) datepicker.getModel().getValue();
								Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
								cal.setTime(selectedDate);
								String day=Integer.toString(cal.get(Calendar.DATE));
								String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
								if(day.length()<2) day="0"+day;
								if(month.length()<2) month="0"+month;
								String date=year+month+day;
								int date1=Integer.parseInt(date);
								if(cal.before(cur_date) && date1>=19000101)
								{
									
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
								 PreparedStatement ps = con.prepareStatement("insert into patients(`fname`,`lname`,`gender`,`dob`,`email`,`password`) values(?,?,?,?,?,?)");
				                    ps.setString(1, s1);
				                    ps.setString(2, s2);
				                    ps.setString(3, String.copyValueOf(gender));
				                    ps.setString(4, date);
				                    ps.setString(5, s3);
				                    ps.setString(6, npw1);
				                    ps.executeUpdate();
				                   
				                   
				                   tf1.setText("");
				                   tf2.setText("");
				                   tf3.setText("");
				                   p1.setText("");
				                   p2.setText("");
				                   rd1.setSelected(true);
				                   JOptionPane.showMessageDialog(null, "Patient enrolled successfully!");
				                   contentpane1.setVisible(false);
									setContentPane(contentPane);
									contentPane.setVisible(true);
									 setTitle("Patients Network");
								}
								else JOptionPane.showMessageDialog(null,"Invalid Date Of Birth");
								 }
								 else {JOptionPane.showMessageDialog(null,"Password Doesn't Match"); p2.setText("");}
								 }
								 else {JOptionPane.showMessageDialog(null,"Password Should have Atleast 4 Characters"); p1.setText("");p2.setText("");}
								 }
								 else {JOptionPane.showMessageDialog(null,"Email Id Is not Valid"); tf3.setText("");}
								 }
								 
								 else {JOptionPane.showMessageDialog(null,"Last Name Is not Valid"); tf2.setText("");}
								 }
								 else {JOptionPane.showMessageDialog(null,"First Name Is not Valid"); tf1.setText("");}
								 
							}
							catch (NullPointerException e3){
								JOptionPane.showMessageDialog(null,"Invalid Date Of Birth")	;
							}
							catch(Exception e2)
							{
								JOptionPane.showMessageDialog(null,e2.getMessage())	;
							}
							
							
							}
				    });
			        btn2 = new JButton("Cancel");
			        btn2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							contentpane1.setVisible(false);
							setContentPane(contentPane);
							contentPane.setVisible(true);
							 setTitle("Patients Network");
							
								
							}
				    });
			      
				   			    
				    l1 = new JLabel("Patients Registration Form");
				    l1.setForeground(Color.BLUE);
			        l1.setFont(new Font("Serif", Font.BOLD, 20));
			        l2 = new JLabel("First Name:");
			        l3 = new JLabel("Last Name:");
			        l4 = new JLabel("Email-ID:");
			        l5 = new JLabel("Create Passowrd:");
			        l6 = new JLabel("Confirm Password:");
			        l7 = new JLabel("Gender:");
			        l8 = new JLabel("Date Of Birth"); 
			        l9 = new JLabel("  "); 			        			        
				    tf1 = new JTextField();
				    tf2 = new JTextField();
				    tf3 = new JTextField();
				    p1 = new JPasswordField();
			        p2 = new JPasswordField();
			        rd1 = new JRadioButton("male");
			        rd2 = new JRadioButton("Female");
			        ButtonGroup bG = new ButtonGroup();
			        bG.add(rd1);
			        bG.add(rd2);
			        			       
			         model=new UtilDateModel();
				    JDatePanelImpl datepanel=new JDatePanelImpl(model);
				    datepicker=new JDatePickerImpl(datepanel);
				    
				    
				    contentpane1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				    contentpane1.add(l1,right);
				    contentpane1.add(l2, left); contentpane1.add(tf1, right);
				    contentpane1.add(l3, left); contentpane1.add(tf2, right);
				    contentpane1.add(l4, left); contentpane1.add(tf3, right);
				    contentpane1.add(l5, left); contentpane1.add(p1, right);
				    contentpane1.add(l6, left); contentpane1.add(p2, right);
				    contentpane1.add(l8, left); contentpane1.add(datepicker, right);
				    contentpane1.add(l7, left); contentpane1.add(rd1, right);
				    contentpane1.add(l9, left);contentpane1.add(rd2, right);
				    contentpane1.add(btn1, left);contentpane1.add(btn2, left);
				    model.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
				    model.setSelected(true);
				    rd1.setSelected(true);
				   // pack();
				    setVisible(true);
				    
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnIntializedb = new JButton("IntializeDB");
		btnIntializedb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","sampledb","pass1234");
					ScriptRunner runner = new ScriptRunner(con);
					InputStream input = getClass().getResourceAsStream("/project1.txt");
					runner.runScript(new InputStreamReader(input));
					JOptionPane.showMessageDialog(null,"Data is Initialized Successfully");
					con.close();
				}
				catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Data is not Initialized..Please Contact Admin");
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(97)
					.addComponent(lblPatientsNetwork)
					.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnIntializedb, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRegister, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSignIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						//.addComponent(btnPat_Manage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblPatientsNetwork)
					.addGap(18)
					.addComponent(btnIntializedb)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegister)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSignIn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					//.addComponent(btnPat_Manage)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//********* Patients Management***************
public static JPanel contentpanep_d;
public static JFrame p_delete;

	
	public void menubar()
	{
		JMenuBar menuBar;
		JMenu menu,symptom,condition,treatment,patient,logout;
		JMenuItem menuItem;
		//Create the menu bar.
		menuBar = new JMenuBar();
		patient=new JMenu("My Profile");
	
		menuItem = new JMenuItem("Deactivate Account");
		menuItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	try{
	            		JDialog.setDefaultLookAndFeelDecorated(true);
	            	    int response = JOptionPane.showConfirmDialog(null, "You will loose all your Data.Do you want to proceed?", "Confirm",
	            	    		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            		//JOptionPane.showMessageDialog(null, loggedName);
	            		Class.forName("com.mysql.jdbc.Driver");
	            		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
	            		PreparedStatement  ps;//=con.prepareStatement("select pid,fname,lname,gender,YEAR(CURDATE())-YEAR(dob) as age,email from patients where pid Not IN "
	            			//	+ "(select pid from pat_symptoms) and pid Not IN (select pid from pat_conditions) and pid not in (select pid from pat_treatment) and email='"+loggedName+"'");
	//            		 ResultSet rs = ps.executeQuery();
	            		 //boolean rs1=rs.next();
//	            		 if(!rs1)
//	            		 { JOptionPane.showMessageDialog(null, "Can't Deactivate Patient with Symptoms or Conditions or Treatments");
//	            		 
//	            		 }
//	            		 else if(rs1)
//	            		 {
	            		if (response == JOptionPane.NO_OPTION ) { JOptionPane.showMessageDialog(null,"Good Decision :)");return;}
	            		else if(response == JOptionPane.YES_OPTION)
	            		{
	            			 ps=con.prepareStatement("delete from patients where email='"+loggedName+"'");
	            			  int rt = ps.executeUpdate();
	            			  if(rt>0)
	            			  {
	            			 setJMenuBar(null);
	             			getContentPane().setVisible(false);
	     					setContentPane(contentPane);
	     					contentPane.setVisible(true);
	     					 setTitle("Patients Network");}
	            		 }
	            }
	            		
//	            	}
	            	catch(Exception ep)
	            	{
	            		JOptionPane.showMessageDialog(null, ep.getMessage());
	            	}
	            }

	        });
		patient.add(menuItem);

		menuItem = new JMenuItem("Edit Details");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{
            		
            		patient_update();
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
            	
		patient.add(menuItem);
		menuItem = new JMenuItem("My Details");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		display_patient();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
            	
		patient.add(menuItem);
		
		menuItem = new JMenuItem("Send Message");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		send_message();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
            	
		patient.add(menuItem);
		
		symptom=new JMenu("Symptoms");
		symptom.addMenuListener(new MenuListener(){
			public void menuCanceled(MenuEvent arg0) {}
			public void menuDeselected(MenuEvent arg0) {}
			public void menuSelected(MenuEvent arg0) {

				patient_symptoms();								// TODO Auto-generated method stub
				
			}
			
		});
		condition=new JMenu("Conditions");
		condition.addMenuListener(new MenuListener(){
			public void menuCanceled(MenuEvent arg0) {}
			public void menuDeselected(MenuEvent arg0) {}
			public void menuSelected(MenuEvent arg0) {

				display_conditions();								// TODO Auto-generated method stub
				
			}
			
		});
		treatment=new JMenu("Treatments");
		treatment.addMenuListener(new MenuListener(){
			public void menuCanceled(MenuEvent arg0) {}
			public void menuDeselected(MenuEvent arg0) {}
			public void menuSelected(MenuEvent arg0) {

				display_treatments();								// TODO Auto-generated method stub
				
			}
			
		});
		logout=new JMenu("Logout");
		logout.addMenuListener(new MenuListener(){
	            public void menuCanceled(MenuEvent e) {}
				public void menuDeselected(MenuEvent e) {}
				public void menuSelected(MenuEvent e) {
				
					setJMenuBar(null);
        			getContentPane().setVisible(false);
        			setBounds(100, 100, 440, 280);
					setContentPane(contentPane);
					contentPane.setVisible(true);
					 setTitle("Patients Network");
					// TODO Auto-generated method stub
					
				}
		});
		//Build the first menu.
		menu = new JMenu("Search");
		menu.setMnemonic(KeyEvent.VK_A);
	
		menuBar.add(patient);
		menuBar.add(symptom);
		menuBar.add(condition);
		menuBar.add(treatment);
		menuBar.add(menu);
		menuBar.add(logout);
		//a group of JMenuItems
		menuItem = new JMenuItem("Patient Search",
		                         KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		patient_search();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
	
		menu.add(menuItem);

		menu.addSeparator();
		menuItem = new JMenuItem("Cough And Fatigue");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		cough_fatigue();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Past Diabetes");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		past_diabetes();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Most Messages");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		most_messagestoX();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Under PT_No MSG");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		pt_nomsg();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Second Oldest");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		second_oldest();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Female_MSG2DB");
		menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try{

            		female_msg2db();
            		//JOptionPane.showMessageDialog(null,"Hello World");
            	   }
            	catch(Exception ep1)
            	{
            		JOptionPane.showMessageDialog(null, ep1.getMessage());
            	}
            }
		});
		menu.add(menuItem);
//		submenu1 = new JMenu("Patients");
//		submenu1.setMnemonic(KeyEvent.VK_S);
//
//		menuItem = new JMenuItem("Search by Id");
//		menuItem.setAccelerator(KeyStroke.getKeyStroke(
//		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
//		submenu1.add(menuItem);
//
//		menuItem = new JMenuItem("Another item");
//		submenu1.add(menuItem);
//		menu.add(submenu1);
		this.setJMenuBar(menuBar);
	    
		
	}	
	
	JPanel contentpanep_pd;
	public void display_patient()
	{
		
		try
		{
		setResizable(false);
		
		contentpanep_pd=new JPanel();
		contentpanep_pd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpanep_pd);
		layoutSet(contentpanep_pd);
//		setTitle("Registration Form for Patients");
		JLabel l12,l13,l14,l15,l16,l17;
		
			l1 = new JLabel("MY PROFILE ");
		    l1.setForeground(Color.BLUE);
	        l1.setFont(new Font("Serif", Font.BOLD, 20));
	        l2 = new JLabel("Patient ID   :               ");l12=new JLabel("id");
	        l3 = new JLabel("First Name   :               ");l13=new JLabel("First Name");
	        l4 = new JLabel("Last Name   :                ");l14=new JLabel("Last Name");
	        l5 = new JLabel("Email-ID   :                 ");l15=new JLabel("email");
	        l6 = new JLabel("AGE    :                     ");l16=new JLabel("age");
	        l7 = new JLabel("Gender   :                   ");l17=new JLabel("gender");
	        
	        Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
    		PreparedStatement  ps=con.prepareStatement("select pid,fname,lname,gender,YEAR(CURDATE())-YEAR(dob) as age,email from patients where email='"+loggedName+"'");
    		 ResultSet rs = ps.executeQuery();
    		 if(rs.next())
    		 {
    			 l12.setText(Integer.toString(rs.getInt("pid")));l15.setText(rs.getString("email"));
    			 l13.setText(rs.getString("fname"));l16.setText(Integer.toString(rs.getInt("age")));
    			 l14.setText(rs.getString("lname"));l17.setText(rs.getString("gender"));
    			 
    		 }
    		 else
    		 { 
    			 JOptionPane.showMessageDialog(null,"Unable to find the Details");
    		 
    		 }
		    contentpanep_pd.add(l1,right);
		    contentpanep_pd.add(l2, left); contentpanep_pd.add(l12, right);
		    contentpanep_pd.add(l3, left); contentpanep_pd.add(l13, right);
		    contentpanep_pd.add(l4, left); contentpanep_pd.add(l14, right);
		    contentpanep_pd.add(l5, left); contentpanep_pd.add(l15, right);
		    contentpanep_pd.add(l6, left); contentpanep_pd.add(l16, right);
		    contentpanep_pd.add(l7, left); contentpanep_pd.add(l17, right);
		   
		    setVisible(true);
		}
		catch(Exception ep3)
		{
			JOptionPane.showMessageDialog(null,ep3.getMessage());
		}

        
	}
	JPanel contentpane_pu;
	static String email_N;
	public void patient_update()
	{
		try
		{
			setResizable(false);
			
			contentpane_pu=new JPanel();
			contentpane_pu.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentpane_pu);
			layoutSet(contentpane_pu);
			l1 = new JLabel("Update Patient Details");
		    l1.setForeground(Color.BLUE);
	        l1.setFont(new Font("Serif", Font.BOLD, 20));
	        l2 = new JLabel("First Name:");
	        l3 = new JLabel("Last Name:");
	        l4 = new JLabel("Email-ID:");
	        l5 = new JLabel("Patient Id:");
	        l7 = new JLabel("Gender:");
	        l8 = new JLabel("Date Of Birth:"); 
	        l9 = new JLabel("  "); 			        			        
		    tf1 = new JTextField();
		    tf2 = new JTextField();
		    tf3 = new JTextField();
		    JTextField tf4= new JTextField();
	        rd1 = new JRadioButton("male");
	        rd2 = new JRadioButton("Female");
	        ButtonGroup bG = new ButtonGroup();
	        bG.add(rd1);
	        bG.add(rd2);
	        	        			       
	         model=new UtilDateModel();
       	    JDatePanelImpl datepanel=new JDatePanelImpl(model);
		    datepicker=new JDatePickerImpl(datepanel);
		    
			
	        Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
    		PreparedStatement  ps=con.prepareStatement("select pid,fname,lname,gender,dob,email from patients where email='"+loggedName+"'");
    		 ResultSet rs = ps.executeQuery();
    		 if(rs.next())
    		 {
    			 String gender=rs.getString("gender");
    			 tf1.setText(rs.getString("fname"));
    			 tf2.setText(rs.getString("lname"));
    			 email_N=rs.getString("email");
    			 tf3.setText(email_N);
    			 tf4.setText(Integer.toString(rs.getInt("pid")));
    			 if(gender.equals("m")) rd1.setSelected(true);
    			 else rd2.setSelected(true);
    			 String dateob=rs.getString("dob");
    			 model.setDate(Integer.parseInt(dateob.substring(0,4)), Integer.parseInt(dateob.substring(5,7))-1, Integer.parseInt(dateob.substring(8,10)));
    		 }
    		 else
    		 {
    			
        			 JOptionPane.showMessageDialog(null,"Unable to find the Details");
        		 
        	 }
		    btn1 = new JButton("Update");
		    btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int f=0;
						char[] gender=new char[1];
						String N_fname,N_lname,N_email;
						N_fname=tf1.getText();
						if(N_fname.matches( "[a-zA-Z][a-zA-Z]*" ))
						{
							N_lname=tf2.getText();
							if(N_lname.matches( "[a-zA-Z][a-zA-Z]*" ))
							{
								N_email=tf3.getText();
								if(!email_N.equals(N_email)) f=1;
								if(N_email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
								{
								if(rd1.isSelected()) gender[0]='m'; else gender[0]='f';
								Date selectedDate = (Date) datepicker.getModel().getValue();
								Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
								cal.setTime(selectedDate);
								String day=Integer.toString(cal.get(Calendar.DATE));
								String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
								if(day.length()<2) day="0"+day;
								if(month.length()<2) month="0"+month;
								String date=year+month+day;
								int date1=Integer.parseInt(date);
								if(cal.before(cur_date) && date1>=19000101)
								{
									Class.forName("com.mysql.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
									String query="update  patients set fname='"+N_fname+"' , lname='"+N_lname+"', gender='"+String.copyValueOf(gender)+"', dob='"+date+"', email='"+N_email+"' where email='"+loggedName+"'";
									//System.out.println(query);
									PreparedStatement ps = con.prepareStatement(query);
									 int rs=ps.executeUpdate();
									 if(rs>0)
									 { JOptionPane.showMessageDialog(null,"The given Details are Updated");
									 	if(f==1)
									 	{
									 		loggedName=N_email;
											setJMenuBar(null);
						        			getContentPane().setVisible(false);
						        			setBounds(100, 100, 440, 280);
											setContentPane(contentpane2);
											contentpane2.setVisible(true);
											 setTitle("Patients Login Form");
									 	}
									 	else display_patient();
									 
									 }
								}
								else
									JOptionPane.showMessageDialog(null,"Not Valid Date of Birth");
							}
							else
								JOptionPane.showMessageDialog(null,"Not Valid Email-Id");
							}
							else
								JOptionPane.showMessageDialog(null,"Not Valid Last Name");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Not Valid First Name");
						}
						
						
						
						
					}
					catch(Exception pu1)
					{
						JOptionPane.showMessageDialog(null,pu1.getMessage());
					}
					 
					
				}
		    });
		    
		   
		    contentpane_pu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    contentpane_pu.add(l1,right);
		    contentpane_pu.add(l5, left); contentpane_pu.add(tf4, right);tf4.setEditable(false);
		    contentpane_pu.add(l2, left); contentpane_pu.add(tf1, right);
		    contentpane_pu.add(l3, left); contentpane_pu.add(tf2, right);
		    contentpane_pu.add(l4, left); contentpane_pu.add(tf3, right);//tf3.setEditable(false);
		    contentpane_pu.add(l8, left); contentpane_pu.add(datepicker, right);
		    contentpane_pu.add(l7, left); contentpane_pu.add(rd1, right);
		    contentpane_pu.add(l9, left);contentpane_pu.add(rd2, right);
		    contentpane_pu.add(btn1, right);
		    model.setSelected(true);
		    setVisible(true);
		}
		catch(Exception pu)
		{
			JOptionPane.showMessageDialog(null,pu.getMessage());
		}
	}
	
	JPanel contentpane_dt;
	JPanel contentpane_pt;
	JFrame treat_add;
	JButton btn_pat_insert;
	JButton btn_pat_cancel;
	UtilDateModel model1;
	static String U_atime,U_tdesc,U_tname; 
	static int flag=0,U_tid,row;
	
	
	
	public void display_treatments()
	{
		
		this.setBounds(100, 100, 440, 280);
		contentpane_dt = new JPanel();
		contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setContentPane(contentpane_dt);
		 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
		this.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		JPanel btnpanel=new JPanel(new BorderLayout());JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		int tid;
		String tname,tdesc,atime;
		String[] columnNames = {"Treatment Id","Treatment Name", "Description",  "Appear Date"};
       this.getContentPane().setLayout(new BorderLayout());
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JButton btn_pat_del=new JButton("Delete");
        btn_pat_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
									
					      int[] colIndex =table.getSelectedRows();
					      for(int p=0;p<colIndex.length;p++)
					      {	
					       int tid=Integer.parseInt(table.getModel().getValueAt(colIndex[p], 0).toString());
					       String time_a=table.getModel().getValueAt(colIndex[p], 3).toString();
					      	Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
							 PreparedStatement ps = con.prepareStatement("update pat_treatment set dtime=NOW(),update_time=NOW() where tid="+tid+" and atime='"+time_a+"' and pid=(select pid from "
							 		+ " patients where email='"+loggedName+"')");
			                  ps.executeUpdate();
					      }
					      while(table.getSelectedRow()>=0)
					    	  ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
					      if(colIndex.length<=0) JOptionPane.showMessageDialog(null, "Please Select Treatments List to Delete");
					  
				}
				catch(Exception e14)
				{
					JOptionPane.showMessageDialog(null,e14.getMessage());
					
				}
			}
        });
        JButton btn_pat_upd=new JButton("Edit");
        btn_pat_upd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					row=-1;flag=0;
					row=table.getSelectedRow();
					if(row>=0)
					{
						
						U_tid=Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						U_tname=table.getModel().getValueAt(row, 1).toString();
						U_tdesc=table.getModel().getValueAt(row, 2).toString();
						U_atime=table.getModel().getValueAt(row, 3).toString().substring(0, 10);
						
						//JOptionPane.showMessageDialog(null,U_atime+"hi");
					treat_add=new JFrame();
					treat_add.setBounds(100, 100, 440, 280);
					treat_add.setVisible(true);
					treat_add.setResizable(false);
					treat_add.setTitle("Update the Treatment");
					contentpane_pt = new JPanel();
					contentpane_pt.setBorder(new EmptyBorder(5, 5, 5, 5));
					treat_add.setContentPane(contentpane_pt);
					btn_pat_cancel=new JButton("Cancel");
					btn_pat_cancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								treat_add.dispose();
							}
							catch(Exception pt5)
							{
								JOptionPane.showMessageDialog(null, pt5.getMessage());
							}}});
					
					
					btn_pat_insert=new JButton("Update");
					btn_pat_insert.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								String tname_cmp,dob_c,mon,tdesc_n;
								int pid,tid;
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
								PreparedStatement ps=con.prepareStatement("select pid,dob from patients where email='"+loggedName+"'");
								ResultSet rs=ps.executeQuery();
								rs.next();pid=rs.getInt("pid");dob_c=rs.getString("dob");
								mon=String.valueOf(Integer.parseInt(dob_c.substring(5,7))-1);
								if(mon.length()<2) mon="0"+mon;
								dob_c=dob_c.substring(0,4)+mon+dob_c.substring(8,10);
								//JOptionPane.showMessageDialog(null, datepicker.getModel().getValue());
								Date selectedDate = (Date) datepicker.getModel().getValue();
								Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
								cal.setTime(selectedDate);
								String day=Integer.toString(cal.get(Calendar.DATE));
								String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
								if(day.length()<2) day="0"+day;
								if(month.length()<2) month="0"+month;
								String date=year+month+day;
								int date1=Integer.parseInt(date);
								if(cal.before(cur_date) && date1>=Integer.parseInt(dob_c))
								{
								
								if(flag==1)
								{
									tname_cmp=tf1.getText();
									String tdesc=tf2.getText();
									if(tname_cmp==null || tname_cmp.isEmpty()|| tdesc==null || tdesc.isEmpty() )
									{
										JOptionPane.showMessageDialog(null, "Not Valid Details");
										return;
									}
									//combobox1=new JComboBox();
									 ps=con.prepareStatement("insert into treatment(tname,tdescription) values('"+tname_cmp+"','"+tdesc+"')");
									ps.executeUpdate();
									tf1.setText("");
									tf2.setText("");
								}
								else tname_cmp=(String) combobox1.getSelectedItem();
								
								ps=con.prepareStatement("select tid,tdescription from treatment where tname='"+tname_cmp+"'");
								rs=ps.executeQuery();
								if(rs.next())
								{
									tid=rs.getInt("tid");tdesc_n=rs.getString("tdescription");

									ps=con.prepareStatement("select * from pat_treatment where tid="+tid+" and pid="+pid+" and (dtime is null or atime='"+date+"')");
									rs=ps.executeQuery();
									int k=-1;
									if(!rs.next())
									{
								ps=con.prepareStatement("Update pat_treatment  set tid="+tid+",pid="+pid+",atime='"+date+"',update_time=NOW() where tid="+U_tid+" and pid="+pid+" and atime='"
										+U_atime+"'");
								 k=ps.executeUpdate();
									
									if(k>0)
									{
										((DefaultTableModel)table.getModel()).removeRow(row);
										ps=con.prepareStatement("select atime from pat_treatment where tid="+tid+" and pid="+pid+" and dtime is null");
										rs=ps.executeQuery();rs.next();String add_time=rs.getString("atime");
										model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
										//model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,datepicker.getModel().getValue()});
										JOptionPane.showMessageDialog(null,"The treatment is Updated");
										model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
										combobox1.setSelectedIndex(0);
										treat_add.dispose();
									}
									
								}
									else if(U_tname.equals(tname_cmp) && !U_atime.equals(year+"-"+month+"-"+day))
									{
										PreparedStatement ps1=con.prepareStatement("Update pat_treatment  set tid="+tid+",pid="+pid+",atime='"+date+"',update_time=NOW() "
												+ " where tid="+U_tid+" and pid="+pid+" and atime='"+U_atime+"'");
										k=ps1.executeUpdate();
										
										if(k>0)
										{
											((DefaultTableModel)table.getModel()).removeRow(row);
											ps1=con.prepareStatement("select atime from pat_treatment where tid="+tid+" and pid="+pid+" and dtime is null");
											ResultSet rs1=ps1.executeQuery();rs1.next();String add_time=rs1.getString("atime");
											model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
											//model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,datepicker.getModel().getValue()});
											JOptionPane.showMessageDialog(null,"The treatment is Updated");
											model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
											combobox1.setSelectedIndex(0);
											treat_add.dispose();
										}
										
									}
								
									else JOptionPane.showMessageDialog(null,"You are already taking this treatment (or) You were under this treatment at same time");
								}
								
								
								}
								else JOptionPane.showMessageDialog(null,"The treatment date should be between date of birth and Current date");
								
							}
							catch(Exception ut1)
							{
								JOptionPane.showMessageDialog(null, ut1.getMessage());
							}
						}
					});
					
					combobox1=new JComboBox();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
					PreparedStatement  ps=con.prepareStatement("select tname from treatment");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						combobox1.addItem(rs.getString("tname"));
					}
					combobox1.addItem("Other Treatment");
					
					combobox1.addActionListener(new ActionListener(){
		        		public void actionPerformed(ActionEvent e) {
		        			try{
		        			if(combobox1.getSelectedItem().equals("Other Treatment"))
		        			{
		        				flag=1;
		        				contentpane_pt.removeAll();
		        				
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l4, left); contentpane_pt.add(tf1, right);
		    				    contentpane_pt.add(l5, left); contentpane_pt.add(tf2, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        				
		        			}
		        			else
		        			{
		        				flag=0;
		        				contentpane_pt.removeAll();
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        			}
		        			
		        			}
		        			catch(Exception pt7)
		        			{
		        				JOptionPane.showMessageDialog(null, pt7.getMessage());
		        			}
		        		}
					});
					l4=new JLabel("Enter Treatment Name:");
					l5=new JLabel("Treatment Description:");
					tf1=new JTextField();tf2=new JTextField();
					layoutSet(contentpane_pt);
					l1 = new JLabel("Update Patient Treatment Details");
				    l1.setForeground(Color.BLUE);
			        l1.setFont(new Font("Serif", Font.BOLD, 20));
			        l2 = new JLabel("Treatment Name:");
			        l3 = new JLabel("Appear Time:"); 	
			        model1=new UtilDateModel();
				    JDatePanelImpl datepanel=new JDatePanelImpl(model1);
				    datepicker=new JDatePickerImpl(datepanel);
				    combobox1.setSelectedItem(U_tname);
				    contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				    contentpane_pt.add(l1,right);
				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
				    model1.setSelected(true);
				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
					
				}
				else
					
					JOptionPane.showMessageDialog(null, "Please select the Treatment to update");
				}
				catch(Exception pt1)
				{
					JOptionPane.showMessageDialog(null, pt1.getMessage());
				}
			}
        });
        JButton btn_pat_ad=new JButton("Add");
        btn_pat_ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					treat_add=new JFrame();
					treat_add.setBounds(100, 100, 440, 280);
					treat_add.setVisible(true);
					treat_add.setResizable(false);
					treat_add.setTitle("Add New Treatment");
					contentpane_pt = new JPanel();
					contentpane_pt.setBorder(new EmptyBorder(5, 5, 5, 5));
					treat_add.setContentPane(contentpane_pt);
					btn_pat_cancel=new JButton("Cancel");
					btn_pat_cancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								treat_add.dispose();
							}
							catch(Exception pt5)
							{
								JOptionPane.showMessageDialog(null, pt5.getMessage());
							}}});
					
					
					btn_pat_insert=new JButton("Insert");
					btn_pat_insert.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								String tname_cmp,tdesc_n,dob_c,mon;
								int pid,tid;
								PreparedStatement  ps;
								if(!combobox1.getSelectedItem().equals("-----Select Treatment-----"))
								{
									Class.forName("com.mysql.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
									ps=con.prepareStatement("select pid,dob from patients where email='"+loggedName+"'");
									ResultSet rs=ps.executeQuery();
									rs.next();pid=rs.getInt("pid");dob_c=rs.getString("dob");
									mon=String.valueOf(Integer.parseInt(dob_c.substring(5,7))-1);
									if(mon.length()<2) mon="0"+mon;
									dob_c=dob_c.substring(0,4)+mon+dob_c.substring(8,10);
									//JOptionPane.showMessageDialog(null, datepicker.getModel().getValue());
									Date selectedDate = (Date) datepicker.getModel().getValue();
									Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
									cal.setTime(selectedDate);
									String day=Integer.toString(cal.get(Calendar.DATE));
									String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
									if(day.length()<2) day="0"+day;
									if(month.length()<2) month="0"+month;
									String date=year+month+day;
									int date1=Integer.parseInt(date);
									if(cal.before(cur_date) && date1>=Integer.parseInt(dob_c))
									{
									if(flag==1)
									{
										tname_cmp=tf1.getText();
										String tdesc=tf2.getText();
										if(tname_cmp==null || tname_cmp.isEmpty()|| tdesc==null || tdesc.isEmpty() )
										{
											JOptionPane.showMessageDialog(null, "Not Valid Details");
											return;
										}
										ps=con.prepareStatement("insert into treatment(tname,tdescription) values('"+tname_cmp+"','"+tdesc+"')");
										ps.executeUpdate();
										tf1.setText("");
										tf2.setText("");
									}
									else tname_cmp=(String) combobox1.getSelectedItem();

									ps=con.prepareStatement("select tid,tdescription from treatment where tname='"+tname_cmp+"'");
									rs=ps.executeQuery();
									if(rs.next())
									{
										tid=rs.getInt("tid");tdesc_n=rs.getString("tdescription");

										ps=con.prepareStatement("select * from pat_treatment where tid="+tid+" and pid="+pid+" and (dtime is null or atime='"+date+"')");
										rs=ps.executeQuery();
										if(!rs.next())
										{
									ps=con.prepareStatement("insert into pat_treatment(tid,pid,atime,insert_time) values("+tid+","+pid+",'"+date+"',NOW())");
									int k=ps.executeUpdate();
									if(k>0)
									{
										ps=con.prepareStatement("select atime from pat_treatment where tid="+tid+" and pid="+pid+" and dtime is null");
										rs=ps.executeQuery();rs.next();String add_time=rs.getString("atime");
										model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
										//model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,datepicker.getModel().getValue()});
										model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
										combobox1.setSelectedIndex(0);
										JOptionPane.showMessageDialog(null,"The treatment is Added");
										treat_add.dispose();
									}
									}
										else JOptionPane.showMessageDialog(null,"You are already taking this treatment (or) You were under this treatment at same time");
									}
									
								}
								else JOptionPane.showMessageDialog(null,"The treatment date should be between date of birth and Current date");
								}
								else
									JOptionPane.showMessageDialog(null,"Please Select Proper Treatment Name");
									
							}
							catch(Exception pt2)
							{
								JOptionPane.showMessageDialog(null, pt2.getMessage());
							}}});
					combobox1=new JComboBox();
					combobox1.addItem("-----Select Treatment-----");
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
					PreparedStatement  ps=con.prepareStatement("select tname from treatment");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						combobox1.addItem(rs.getString("tname"));
					}
					combobox1.addItem("Other Treatment");
					
					combobox1.addActionListener(new ActionListener(){
		        		public void actionPerformed(ActionEvent e) {
		        			try{
		        			if(combobox1.getSelectedItem().equals("Other Treatment"))
		        			{
		        				flag=1;
		        				contentpane_pt.removeAll();
		        				
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l4, left); contentpane_pt.add(tf1, right);
		    				    contentpane_pt.add(l5, left); contentpane_pt.add(tf2, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        				
		        			}
		        			else
		        			{
		        				flag=0;
		        				contentpane_pt.removeAll();
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        			}
		        			
		        			}
		        			catch(Exception pt7)
		        			{
		        				JOptionPane.showMessageDialog(null, pt7.getMessage());
		        			}
		        		}
					});
					l4=new JLabel("Enter Treatment Name:");
					l5=new JLabel("Treatment Description:");
					tf1=new JTextField();tf2=new JTextField();
					layoutSet(contentpane_pt);
					l1 = new JLabel("Insert Patient Treatment Details");
				    l1.setForeground(Color.BLUE);
			        l1.setFont(new Font("Serif", Font.BOLD, 20));
			        l2 = new JLabel("Treatment Name:");
			        l3 = new JLabel("Appear Time:"); 	
			        model1=new UtilDateModel();
				    JDatePanelImpl datepanel=new JDatePanelImpl(model1);
				    datepicker=new JDatePickerImpl(datepanel);
				    combobox1.setSelectedIndex(0);
				    contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				    contentpane_pt.add(l1,right);
				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
				    model1.setSelected(true);
				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
					
				}
				catch(Exception pt3)
				{
					JOptionPane.showMessageDialog(null, pt3.getMessage());
				}
			}
        });
        bottombtnPnl.add(btn_pat_upd); bottombtnPnl.add(btn_pat_ad);
        bottombtnPnl.add(btn_pat_del); btnpanel.add(bottombtnPnl, BorderLayout.CENTER);

try
{
 Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
PreparedStatement  ps=con.prepareStatement("select t.tid,t.tname,t.tdescription,pt.atime from sampledb.treatment t,"
		+ "sampledb.pat_treatment pt where pt.dtime is null and pt.pid in (select pid from sampledb.patients "
		+ "where email='"+loggedName+"') and pt.tid=t.tid");
 ResultSet rs = ps.executeQuery();
 boolean rs1=rs.next();
 while(rs1)
 {
	 tid=rs.getInt("tid");
	 tname=rs.getString("tname");
	tdesc=rs.getString("tdescription") ;
	atime=rs.getString("atime") ;
    model.addRow(new Object[]{new Integer(tid),tname,tdesc,atime});
     rs1=rs.next();
 } this.getContentPane().add(scroll);
 this.getContentPane().add(btnpanel, BorderLayout.SOUTH);
 this.setVisible(true);
 this.setSize(600, 300);
 

	}

	catch(SQLException e13)
	{
		JOptionPane.showMessageDialog(null, e13.getMessage());
	}
	catch(ClassNotFoundException e13)
	{
	JOptionPane.showMessageDialog(null, e13.getMessage());
	}

		
	}
	
	public void patient_search()
	{

    	String[] list={"    ----Select----","Search By Id","Search By Other Details"};
    	combobox1=new JComboBox(list);
    	combobox1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    		
    			if(combobox1.getSelectedIndex()==2)
        		{
    												        				        				
    				l1 = new JLabel("Patients Search Form");
 				    l1.setForeground(Color.BLUE);
 			        l1.setFont(new Font("Serif", Font.BOLD, 20));
 			        
 			        fn=new JTextField();ln=new JTextField();emailf=new JTextField();
 			        agef=new JTextField();
 			        g1=new JRadioButton("Male");
 			        g2=new JRadioButton("Female");
 			       ButtonGroup bG1 = new ButtonGroup();
			        bG1.add(g1);
			        bG1.add(g2);
 			        JButton search1=new JButton("Search");
 			        
 			       search1.addActionListener(new ActionListener(){
		        		public void actionPerformed(ActionEvent e) {
		        			try
		        			{
		        			String query="select pid,fname,lname,gender,YEAR(CURDATE())-YEAR(dob) as age,email from patients where";
		        			int count=0;
		        		String fname,lname,gender,email;
		           		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email"};
	        		int age2=-1;
		           		
		        		String age3=agef.getText();
		        		String fname1=fn.getText();
		        		String lname1=ln.getText();
		        		String email1=emailf.getText();
		        		int i=-1;
		        		if(g1.isSelected()) 
		        			i=0;
		        		else if(g2.isSelected()) 
		        			i=1;
		        		if(fname1 != null && !fname1.isEmpty()) {query=query+" fname='"+fname1+"'";count++;}
		        			if(lname1 != null && !lname1.isEmpty())
		        			{ if(count!=0){query=query+" and lname='"+lname1+"'";}
		        			else query=query+" lname='"+lname1+"'";
		        			count++;
		        			}
		        			if(email1 != null && !email1.isEmpty())
		        			{ if(count!=0){query=query+" and email='"+email1+"'";}
		        			else query=query+" email='"+email1+"'";
		        			count++;
		        			}
		        			if(age3 != null && !age3.isEmpty())
		        			{ age2=Integer.parseInt(agef.getText());
		        				if(count!=0){query=query+" and YEAR(CURDATE())-YEAR(dob)="+age2;}
		        			else query=query+" YEAR(CURDATE())-YEAR(dob)="+age2;
		        			count++;
		        			}
		        			if(i==0)
		        			{
		        				if(count!=0){query=query+" and gender='m'";}
			        			else query=query+" gender='m'";
			        			count++;
		        			}
		        			if(i==1)
		        			{
		        				if(count!=0){query=query+" and gender='f'";}
			        			else query=query+" gender='f'";
			        			count++;
		        			}
		        			query=query+";";
		        		       JFrame frame1 = new JFrame("Patients Search Result");
		        		        frame1.getContentPane().setLayout(new BorderLayout());
		        		        DefaultTableModel model = new DefaultTableModel();
		        		        model.setColumnIdentifiers(columnNames);
		        		        table = new JTable();
		        		        table.setModel(model);
		        		        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		        		        table.setFillsViewportHeight(true);
		        		        JScrollPane scroll = new JScrollPane(table);
		        		        scroll.setHorizontalScrollBarPolicy(
		        		                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        		        scroll.setVerticalScrollBarPolicy(
		        		                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		        				int pid,age;
		        		 Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
						PreparedStatement  ps=con.prepareStatement(query);
						 ResultSet rs = ps.executeQuery();
						 int j=0;
						 while(rs.next())
						 {
							 pid=rs.getInt("pid");
								fname=rs.getString("fname") ;
								lname=rs.getString("lname") ;
								gender=rs.getString("gender") ;
								email=rs.getString("email") ;
								age=rs.getInt("age");
								//Integer ag=new Integer(age);
				                model.addRow(new Object[]{new Integer(pid),fname, lname, gender, new Integer(age),email});
							     frame1.getContentPane().add(scroll);
							        frame1.setVisible(true);
							        frame1.setSize(600, 300); j++;
						 }
						 if(j==0) JOptionPane.showMessageDialog(null, "No Records Has Found");
		        			
		        			}
		        			catch(Exception e10)
		        			{
		        				JOptionPane.showMessageDialog(null, "Please Enter Details To Search");
		        			}
		        		}
 			       });
 			        
 			      layoutSet(contentpane3);
        		contentpane3.removeAll();
 			       contentpane3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        			contentpane3.add(combobox1,right);
        			contentpane3.add(new JLabel(""),right);
 				    contentpane3.add(l1,top);
				    contentpane3.add(new JLabel("First Name :"), left);
				 contentpane3.add(fn,right);
				 contentpane3.add(new JLabel("Last Name :"), left);
				contentpane3.add(ln,right);
				contentpane3.add(new JLabel("Email Id :"), left);
				contentpane3.add(emailf,right);
				contentpane3.add(new JLabel("Age : "), left); 
				contentpane3.add(agef,right);
				contentpane3.add(new JLabel("Gender :"), left);
				contentpane3.add(g1,right);
				contentpane3.add(new JLabel("    "), left);
				contentpane3.add(g2,right);
			contentpane3.add(search1, left);
				    contentpane3.revalidate();
        		}
    			
    		if(combobox1.getSelectedIndex()==1)
    		{
    			search=new JTextField();
    			JButton submit=new JButton("Search");
    			submit.addActionListener(new ActionListener(){
	        		public void actionPerformed(ActionEvent e) {
	        			try
	        			{
	        				
	        				
	        				String fname,lname,gender,email;
	        				int age,pid;
	        		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email"};
	        		int id=-1;
	        		if(search.getText().matches( "[0-9][0-9]*" ))
					 {
	        		id=Integer.parseInt(search.getText());
	        		
	        	
	        		       JFrame frame1 = new JFrame("Patients Search Result");
	        		        frame1.getContentPane().setLayout(new BorderLayout());
	        		        DefaultTableModel model = new DefaultTableModel();
	        		        model.setColumnIdentifiers(columnNames);
	        		        table = new JTable();
	        		        table.setModel(model);
	        		        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        		        table.setFillsViewportHeight(true);
	        		        JScrollPane scroll = new JScrollPane(table);
	        		        scroll.setHorizontalScrollBarPolicy(
	        		                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        		        scroll.setVerticalScrollBarPolicy(
	        		                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        	
	        				
	        		 Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
					PreparedStatement  ps=con.prepareStatement("select pid,fname,lname,gender,YEAR(CURDATE())-YEAR(dob) as age,email from patients where pid="+id);
					 ResultSet rs = ps.executeQuery();
					 if(rs.next())
					 {
						 pid=rs.getInt("pid");
						fname=rs.getString("fname") ;
						lname=rs.getString("lname") ;
						gender=rs.getString("gender") ;
						email=rs.getString("email") ;
						age=rs.getInt("age");
		                model.addRow(new Object[]{new Integer(pid),fname, lname, gender, new Integer(age),email});
					     frame1.getContentPane().add(scroll);
					        frame1.setVisible(true);
					        frame1.setSize(600, 300);
					 }
					 else JOptionPane.showMessageDialog(null,"No Records Found")	;
					 
	        			}
	        		else JOptionPane.showMessageDialog(null,"Invalid Patient ID");
	        			}
	        			catch(Exception e4)
	        			{
	        				JOptionPane.showMessageDialog(null,e4.getMessage())	;
	        			}
	        		}
	        		});
    			layoutSet(contentpane3);
    			contentpane3.removeAll();
    			contentpane3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    			contentpane3.add(combobox1,right);
    			contentpane3.add(new JLabel(""),right);
    			contentpane3.add(new JLabel("Patient Id: "),left);
    			contentpane3.add(search,right);
    			contentpane3.add(submit, left);
    			contentpane3.revalidate();
    		}
    			
    		}						        		
    			});
    	combobox1.setSelectedIndex(0);
    	contentpane3=new JPanel();
		contentpane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setVisible(false);
		setContentPane(contentpane3);
		contentpane3.setVisible(true);
		 setTitle("Patients Search");layoutSet(contentpane3);
		 contentpane3.add(combobox1,top);

    
	}
	
	
	
	public void display_conditions()
	{

		
		this.setBounds(100, 100, 440, 280);
		contentpane_dt = new JPanel();
		contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setContentPane(contentpane_dt);
		 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
		this.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		JPanel btnpanel=new JPanel(new BorderLayout());JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		int tid;
		String tname,tdesc,atime;
		String[] columnNames = {"Condition Id","Condition Name", "Description",  "Appear Date"};
       this.getContentPane().setLayout(new BorderLayout());
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JButton btn_pat_del=new JButton("Delete");
        btn_pat_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
									
					      int[] colIndex =table.getSelectedRows();
					      for(int p=0;p<colIndex.length;p++)
					      {	
					       int tid=Integer.parseInt(table.getModel().getValueAt(colIndex[p], 0).toString());
					       String time_a=table.getModel().getValueAt(colIndex[p], 3).toString();
					      	Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
							 PreparedStatement ps = con.prepareStatement("update pat_conditions set dtime=NOW(),update_time=NOW() where cid="+tid+" and atime='"+time_a+"' and pid=(select pid from "
							 		+ " patients where email='"+loggedName+"')");
			                  ps.executeUpdate();
					      }
					      while(table.getSelectedRow()>=0)
					    	  ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
					      if(colIndex.length<=0) JOptionPane.showMessageDialog(null, "Please Select Conditions List to Delete");
					  
				}
				catch(Exception e14)
				{
					JOptionPane.showMessageDialog(null,e14.getMessage());
					
				}
			}
        });
        JButton btn_pat_upd=new JButton("Edit");
        btn_pat_upd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					row=-1;flag=0;
					row=table.getSelectedRow();
					if(row>=0)
					{
						
						U_tid=Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
						U_tname=table.getModel().getValueAt(row, 1).toString();
						U_tdesc=table.getModel().getValueAt(row, 2).toString();
						U_atime=table.getModel().getValueAt(row, 3).toString().substring(0, 10);
						
						//JOptionPane.showMessageDialog(null,U_atime+"hi");
					treat_add=new JFrame();
					treat_add.setBounds(100, 100, 440, 280);
					treat_add.setVisible(true);
					treat_add.setResizable(false);
					treat_add.setTitle("Update the Condition");
					contentpane_pt = new JPanel();
					contentpane_pt.setBorder(new EmptyBorder(5, 5, 5, 5));
					treat_add.setContentPane(contentpane_pt);
					btn_pat_cancel=new JButton("Cancel");
					btn_pat_cancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								treat_add.dispose();
							}
							catch(Exception pt5)
							{
								JOptionPane.showMessageDialog(null, pt5.getMessage());
							}}});
					
					
					btn_pat_insert=new JButton("Update");
					btn_pat_insert.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								String tname_cmp,dob_c,mon,tdesc_n;
								int pid,tid;
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
								PreparedStatement ps=con.prepareStatement("select pid,dob from patients where email='"+loggedName+"'");
								ResultSet rs=ps.executeQuery();
								rs.next();pid=rs.getInt("pid");dob_c=rs.getString("dob");
								mon=String.valueOf(Integer.parseInt(dob_c.substring(5,7))-1);
								if(mon.length()<2) mon="0"+mon;
								dob_c=dob_c.substring(0,4)+mon+dob_c.substring(8,10);
								//JOptionPane.showMessageDialog(null, datepicker.getModel().getValue());
								Date selectedDate = (Date) datepicker.getModel().getValue();
								Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
								cal.setTime(selectedDate);
								String day=Integer.toString(cal.get(Calendar.DATE));
								String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
								if(day.length()<2) day="0"+day;
								if(month.length()<2) month="0"+month;
								String date=year+month+day;
								int date1=Integer.parseInt(date);
								if(cal.before(cur_date) && date1>=Integer.parseInt(dob_c))
								{
								
								if(flag==1)
								{
									tname_cmp=tf1.getText();
									String tdesc=tf2.getText();
									//combobox1=new JComboBox();
									if(tname_cmp==null || tname_cmp.isEmpty()|| tdesc==null || tdesc.isEmpty() )
									{
										JOptionPane.showMessageDialog(null, "Not Valid Details");
										return;
									}
									 ps=con.prepareStatement("insert into conditions(cname,cdescription) values('"+tname_cmp+"','"+tdesc+"')");
									ps.executeUpdate();
									tf1.setText("");
									tf2.setText("");
								}
								else tname_cmp=(String) combobox1.getSelectedItem();
								
								ps=con.prepareStatement("select cid,cdescription from conditions where cname='"+tname_cmp+"'");
								rs=ps.executeQuery();
								int k=-1;
								if(rs.next())
								{
									tid=rs.getInt("cid");tdesc_n=rs.getString("cdescription");

									ps=con.prepareStatement("select * from pat_conditions where cid="+tid+" and pid="+pid+" and (dtime is null or atime='"+date+"')");
									rs=ps.executeQuery();
									if(!rs.next())
									{
								ps=con.prepareStatement("Update pat_conditions  set cid="+tid+",pid="+pid+",atime='"+date+"',update_time=NOW()"
										+ "  where cid="+U_tid+" and pid="+pid+" and atime='"
										+U_atime+"'");
								 k=ps.executeUpdate();
								if(k>0)
								{
									((DefaultTableModel)table.getModel()).removeRow(row);

									ps=con.prepareStatement("select atime from pat_conditions where cid="+tid+" and pid="+pid+" and dtime is null and atime='"+date+"'");
									rs=ps.executeQuery();rs.next();String add_time=rs.getString("atime");
									model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
									JOptionPane.showMessageDialog(null,"The Condition is Updated");
									model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
									combobox1.setSelectedIndex(0);
									treat_add.dispose();
									
								}
								}
									else if(U_tname.equals(tname_cmp) && !U_atime.equals(year+"-"+month+"-"+day))
									{
										PreparedStatement ps1=con.prepareStatement("Update pat_conditions  set cid="+tid+",pid="+pid+",atime='"+date+"',update_time=NOW() "
												+ " where cid="+U_tid+" and pid="+pid+" and atime='"
												+U_atime+"'");
										k=ps1.executeUpdate();
										
										if(k>0)
										{
											((DefaultTableModel)table.getModel()).removeRow(row);
											ps1=con.prepareStatement("select atime from pat_conditions where cid="+tid+" and pid="+pid+" and dtime is null");
											ResultSet rs1=ps1.executeQuery();rs1.next();String add_time=rs1.getString("atime");
											model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
											JOptionPane.showMessageDialog(null,"The Condition is Updated");
											model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
											combobox1.setSelectedIndex(0);
											treat_add.dispose();
										}
										
									}
									else JOptionPane.showMessageDialog(null,"You are already taking this condition (or) You were under this condition at same time");
								}
								
								
								}
								else JOptionPane.showMessageDialog(null,"The condition date should be between date of birth and Current date");
								
							}
							catch(Exception ut1)
							{
								JOptionPane.showMessageDialog(null, ut1.getMessage());
							}
						}
					});
					
					combobox1=new JComboBox();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
					PreparedStatement  ps=con.prepareStatement("select cname from conditions");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						combobox1.addItem(rs.getString("cname"));
					}
					combobox1.addItem("Other Condition");
					
					combobox1.addActionListener(new ActionListener(){
		        		public void actionPerformed(ActionEvent e) {
		        			try{
		        			if(combobox1.getSelectedItem().equals("Other Condition"))
		        			{
		        				flag=1;
		        				contentpane_pt.removeAll();
		        				
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l4, left); contentpane_pt.add(tf1, right);
		    				    contentpane_pt.add(l5, left); contentpane_pt.add(tf2, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        				
		        			}
		        			else
		        			{
		        				flag=0;
		        				contentpane_pt.removeAll();
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        			}
		        			
		        			}
		        			catch(Exception pt7)
		        			{
		        				JOptionPane.showMessageDialog(null, pt7.getMessage());
		        			}
		        		}
					});
					l4=new JLabel("Enter Condition Name:");
					l5=new JLabel("Condition Description:");
					tf1=new JTextField();tf2=new JTextField();
					layoutSet(contentpane_pt);
					l1 = new JLabel("Update Patient Conditions");
				    l1.setForeground(Color.BLUE);
			        l1.setFont(new Font("Serif", Font.BOLD, 20));
			        l2 = new JLabel("Condition Name:");
			        l3 = new JLabel("Appear Time:"); 	
			        model1=new UtilDateModel();
				    JDatePanelImpl datepanel=new JDatePanelImpl(model1);
				    datepicker=new JDatePickerImpl(datepanel);
				    combobox1.setSelectedItem(U_tname);
				    contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				    contentpane_pt.add(l1,right);
				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
				    model1.setSelected(true);
				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
					
				}
				else
					
					JOptionPane.showMessageDialog(null, "Please select the Condition to update");
				}
				catch(Exception pt1)
				{
					JOptionPane.showMessageDialog(null, pt1.getMessage());
				}
			}
        });
        JButton btn_pat_ad=new JButton("Add");
        btn_pat_ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					treat_add=new JFrame();
					treat_add.setBounds(100, 100, 440, 280);
					treat_add.setVisible(true);
					treat_add.setResizable(false);
					treat_add.setTitle("Add New Condition");
					contentpane_pt = new JPanel();
					contentpane_pt.setBorder(new EmptyBorder(5, 5, 5, 5));
					treat_add.setContentPane(contentpane_pt);
					btn_pat_cancel=new JButton("Cancel");
					btn_pat_cancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								treat_add.dispose();
							}
							catch(Exception pt5)
							{
								JOptionPane.showMessageDialog(null, pt5.getMessage());
							}}});
					
					
					btn_pat_insert=new JButton("Insert");
					btn_pat_insert.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								String tname_cmp,tdesc_n,dob_c,mon;
								int pid,tid;
								PreparedStatement  ps;
								if(!combobox1.getSelectedItem().equals("-----Select Condition-----"))
								{
									Class.forName("com.mysql.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
									ps=con.prepareStatement("select pid,dob from patients where email='"+loggedName+"'");
									ResultSet rs=ps.executeQuery();
									rs.next();pid=rs.getInt("pid");dob_c=rs.getString("dob");
									mon=String.valueOf(Integer.parseInt(dob_c.substring(5,7))-1);
									if(mon.length()<2) mon="0"+mon;
									dob_c=dob_c.substring(0,4)+mon+dob_c.substring(8,10);
									//JOptionPane.showMessageDialog(null, datepicker.getModel().getValue());
									Date selectedDate = (Date) datepicker.getModel().getValue();
									Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
									cal.setTime(selectedDate);
									String day=Integer.toString(cal.get(Calendar.DATE));
									String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
									if(day.length()<2) day="0"+day;
									if(month.length()<2) month="0"+month;
									String date=year+month+day;
									int date1=Integer.parseInt(date);
									if(cal.before(cur_date) && date1>=Integer.parseInt(dob_c))
									{
									if(flag==1)
									{
										tname_cmp=tf1.getText();
										String tdesc=tf2.getText();
										if(tname_cmp==null || tname_cmp.isEmpty()|| tdesc==null || tdesc.isEmpty() )
										{
											JOptionPane.showMessageDialog(null, "Not Valid Details");
											return;
										}
										ps=con.prepareStatement("insert into conditions(cname,cdescription) values('"+tname_cmp+"','"+tdesc+"')");
										ps.executeUpdate();
										tf1.setText("");
										tf2.setText("");
									}
									else tname_cmp=(String) combobox1.getSelectedItem();

									ps=con.prepareStatement("select cid,cdescription from conditions where cname='"+tname_cmp+"'");
									rs=ps.executeQuery();
									if(rs.next())
									{
										tid=rs.getInt("cid");tdesc_n=rs.getString("cdescription");

										ps=con.prepareStatement("select * from pat_conditions where cid="+tid+" and pid="+pid+" and (dtime is null or atime='"+date+"')");
										rs=ps.executeQuery();
										if(!rs.next())
										{
									ps=con.prepareStatement("insert into pat_conditions(cid,pid,atime,insert_time) values("+tid+","+pid+",'"+date+"',NOW())");
									int k=ps.executeUpdate();
									if(k>0)
									{
										ps=con.prepareStatement("select atime from pat_conditions where cid="+tid+" and pid="+pid+" and dtime is null");
										rs=ps.executeQuery();rs.next();String add_time=rs.getString("atime");
										model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
										model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
										combobox1.setSelectedIndex(0);
										JOptionPane.showMessageDialog(null,"The condition is Added");
										treat_add.dispose();
									}
									}
										else JOptionPane.showMessageDialog(null,"You are already taking this condition (or) You were under this condition at same time");
									}
									
								}
								else JOptionPane.showMessageDialog(null,"The condition date should be between date of birth and Current date");
								}
								else
									JOptionPane.showMessageDialog(null,"Please Select Proper Condition Name");
									
							}
							catch(Exception pt2)
							{
								JOptionPane.showMessageDialog(null, pt2.getMessage());
							}}});
					combobox1=new JComboBox();
					combobox1.addItem("-----Select Condition-----");
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
					PreparedStatement  ps=con.prepareStatement("select cname from conditions");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						combobox1.addItem(rs.getString("cname"));
					}
					combobox1.addItem("Other Condition");
					
					combobox1.addActionListener(new ActionListener(){
		        		public void actionPerformed(ActionEvent e) {
		        			try{
		        			if(combobox1.getSelectedItem().equals("Other Condition"))
		        			{
		        				flag=1;
		        				contentpane_pt.removeAll();
		        				
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l4, left); contentpane_pt.add(tf1, right);
		    				    contentpane_pt.add(l5, left); contentpane_pt.add(tf2, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        				
		        			}
		        			else
		        			{
		        				flag=0;
		        				contentpane_pt.removeAll();
		        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    				    contentpane_pt.add(l1,right);
		    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
		    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
		    				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
		    				    model1.setSelected(true);
		    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
		    				    contentpane_pt.revalidate();
		        			}
		        			
		        			}
		        			catch(Exception pt7)
		        			{
		        				JOptionPane.showMessageDialog(null, pt7.getMessage());
		        			}
		        		}
					});
					l4=new JLabel("Enter Condition Name:");
					l5=new JLabel("Condition Description:");
					tf1=new JTextField();tf2=new JTextField();
					layoutSet(contentpane_pt);
					l1 = new JLabel("Insert Patient Condition Details");
				    l1.setForeground(Color.BLUE);
			        l1.setFont(new Font("Serif", Font.BOLD, 20));
			        l2 = new JLabel("Condition Name:");
			        l3 = new JLabel("Appear Time:"); 	
			        model1=new UtilDateModel();
				    JDatePanelImpl datepanel=new JDatePanelImpl(model1);
				    datepicker=new JDatePickerImpl(datepanel);
				    combobox1.setSelectedIndex(0);
				    contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				    contentpane_pt.add(l1,right);
				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
				    model1.setSelected(true);
				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
					
				}
				catch(Exception pt3)
				{
					JOptionPane.showMessageDialog(null, pt3.getMessage());
				}
			}
        });
        bottombtnPnl.add(btn_pat_upd); bottombtnPnl.add(btn_pat_ad);
        bottombtnPnl.add(btn_pat_del); btnpanel.add(bottombtnPnl, BorderLayout.CENTER);

try
{
 Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
PreparedStatement  ps=con.prepareStatement("select c.cid,c.cname,c.cdescription,pc.atime from sampledb.conditions c,"
		+ "sampledb.pat_conditions pc where pc.dtime is null and pc.pid in (select pid from sampledb.patients "
		+ "where email='"+loggedName+"') and pc.cid=c.cid");
 ResultSet rs = ps.executeQuery();
 boolean rs1=rs.next();
 while(rs1)
 {
	 tid=rs.getInt("cid");
	 tname=rs.getString("cname");
	tdesc=rs.getString("cdescription") ;
	atime=rs.getString("atime") ;
    model.addRow(new Object[]{new Integer(tid),tname,tdesc,atime});
     rs1=rs.next();
 } this.getContentPane().add(scroll);
 this.getContentPane().add(btnpanel, BorderLayout.SOUTH);
 this.setVisible(true);
 this.setSize(600, 300);
 

	}

	catch(SQLException e13)
	{
		JOptionPane.showMessageDialog(null, e13.getMessage());
	}
	catch(ClassNotFoundException e13)
	{
	JOptionPane.showMessageDialog(null, e13.getMessage());
	}

		
	
	}
	
	
public void patient_symptoms()
{


	
	this.setBounds(100, 100, 440, 280);
	contentpane_dt = new JPanel();
	contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
	 this.setContentPane(contentpane_dt);
	 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
	this.setVisible(true);
	/////////////////////////////////////////////////////////////////////////////////
	JPanel btnpanel=new JPanel(new BorderLayout());JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
	int tid;
	String tname,tdesc,atime;
	String[] columnNames = {"Symptom Id","Symptom Name", "Description",  "Appear Date"};
   this.getContentPane().setLayout(new BorderLayout());
    final DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columnNames);
    table = new JTable();
    table.setModel(model);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    table.setFillsViewportHeight(true);
    JScrollPane scroll = new JScrollPane(table);
    scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    JButton btn_pat_del=new JButton("Delete");
    btn_pat_del.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
								
				      int[] colIndex =table.getSelectedRows();
				      for(int p=0;p<colIndex.length;p++)
				      {	
				       int tid=Integer.parseInt(table.getModel().getValueAt(colIndex[p], 0).toString());
				       String time_a=table.getModel().getValueAt(colIndex[p], 3).toString();
				      	Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
						 PreparedStatement ps = con.prepareStatement("update pat_symptoms set dtime=NOW(),update_time=NOW() where sid="+tid+" and atime='"+time_a+"' and pid=(select pid from "
						 		+ " patients where email='"+loggedName+"')");
		                  ps.executeUpdate();
				      }
				      while(table.getSelectedRow()>=0)
				    	  ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
				      if(colIndex.length<=0) JOptionPane.showMessageDialog(null, "Please Select Symptoms List to Delete");
				  
			}
			catch(Exception e14)
			{
				JOptionPane.showMessageDialog(null,e14.getMessage());
				
			}
		}
    });
    JButton btn_pat_upd=new JButton("Edit");
    btn_pat_upd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				row=-1;flag=0;
				row=table.getSelectedRow();
				if(row>=0)
				{
					
					U_tid=Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
					U_tname=table.getModel().getValueAt(row, 1).toString();
					U_tdesc=table.getModel().getValueAt(row, 2).toString();
					U_atime=table.getModel().getValueAt(row, 3).toString().substring(0, 10);
					
					//JOptionPane.showMessageDialog(null,U_atime+"hi");
				treat_add=new JFrame();
				treat_add.setBounds(100, 100, 440, 280);
				treat_add.setVisible(true);
				treat_add.setResizable(false);
				treat_add.setTitle("Update the Symptom");
				contentpane_pt = new JPanel();
				contentpane_pt.setBorder(new EmptyBorder(5, 5, 5, 5));
				treat_add.setContentPane(contentpane_pt);
				btn_pat_cancel=new JButton("Cancel");
				btn_pat_cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							treat_add.dispose();
						}
						catch(Exception pt5)
						{
							JOptionPane.showMessageDialog(null, pt5.getMessage());
						}}});
				
				
				btn_pat_insert=new JButton("Update");
				btn_pat_insert.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String tname_cmp,dob_c,mon,tdesc_n;
							int pid,tid;
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
							PreparedStatement ps=con.prepareStatement("select pid,dob from patients where email='"+loggedName+"'");
							ResultSet rs=ps.executeQuery();
							rs.next();pid=rs.getInt("pid");dob_c=rs.getString("dob");
							mon=String.valueOf(Integer.parseInt(dob_c.substring(5,7))-1);
							if(mon.length()<2) mon="0"+mon;
							dob_c=dob_c.substring(0,4)+mon+dob_c.substring(8,10);
							//JOptionPane.showMessageDialog(null, datepicker.getModel().getValue());
							Date selectedDate = (Date) datepicker.getModel().getValue();
							Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
							cal.setTime(selectedDate);
							String day=Integer.toString(cal.get(Calendar.DATE));
							String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
							if(day.length()<2) day="0"+day;
							if(month.length()<2) month="0"+month;
							String date=year+month+day;
							int date1=Integer.parseInt(date);
							if(cal.before(cur_date) && date1>=Integer.parseInt(dob_c))
							{
							
							if(flag==1)
							{
								tname_cmp=tf1.getText();
								String tdesc=tf2.getText();
								//combobox1=new JComboBox();
								if(tname_cmp==null || tname_cmp.isEmpty()|| tdesc==null || tdesc.isEmpty() )
								{
									JOptionPane.showMessageDialog(null, "Not Valid Details");
									return;
								}
								 ps=con.prepareStatement("insert into symptoms(sname,sdescription) values('"+tname_cmp+"','"+tdesc+"')");
								ps.executeUpdate();
								tf1.setText("");
								tf2.setText("");
							}
							else tname_cmp=(String) combobox1.getSelectedItem();
							
							ps=con.prepareStatement("select sid,sdescription from symptoms where sname='"+tname_cmp+"'");
							rs=ps.executeQuery();
							int k=-1;
							if(rs.next())
							{
								tid=rs.getInt("sid");tdesc_n=rs.getString("sdescription");

								ps=con.prepareStatement("select * from pat_symptoms where sid="+tid+" and pid="+pid+" and (dtime is null or atime='"+date+"')");
								rs=ps.executeQuery();
								if(!rs.next())
								{
							ps=con.prepareStatement("Update pat_symptoms  set sid="+tid+",pid="+pid+",atime='"+date+"',update_time=NOW() where sid="+U_tid+" and pid="+pid+" and atime='"
									+U_atime+"'");
							 k=ps.executeUpdate();
							if(k>0)
							{
								((DefaultTableModel)table.getModel()).removeRow(row);

								ps=con.prepareStatement("select atime from pat_symptoms where sid="+tid+" and pid="+pid+" and dtime is null and atime='"+date+"'");
								rs=ps.executeQuery();rs.next();String add_time=rs.getString("atime");
								model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
								JOptionPane.showMessageDialog(null,"The symptom is Updated");
								model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
								combobox1.setSelectedIndex(0);
								treat_add.dispose();
							}
							}
								else if(U_tname.equals(tname_cmp) && !U_atime.equals(year+"-"+month+"-"+day))
								{
									PreparedStatement ps1=con.prepareStatement("Update pat_symptoms  set sid="+tid+",pid="+pid+",atime='"+date+"',update_time=NOW() where sid="+U_tid+" and pid="+pid+" and atime='"
											+U_atime+"'");
									k=ps1.executeUpdate();
									
									if(k>0)
									{
										((DefaultTableModel)table.getModel()).removeRow(row);
										ps1=con.prepareStatement("select atime from pat_symptoms where sid="+tid+" and pid="+pid+" and dtime is null");
										ResultSet rs1=ps1.executeQuery();rs1.next();String add_time=rs1.getString("atime");
										model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
										JOptionPane.showMessageDialog(null,"The Symptom is Updated");
										model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
										combobox1.setSelectedIndex(0);
										treat_add.dispose();
									}
									
								}
								else JOptionPane.showMessageDialog(null,"You are already under this Symptom (or) You were under this Symptom at same time");
							}
							
							
							}
							else JOptionPane.showMessageDialog(null,"The condition date should be between date of birth and Current date");
							
						}
						catch(Exception ut1)
						{
							JOptionPane.showMessageDialog(null, ut1.getMessage());
						}
					}
				});
				
				combobox1=new JComboBox();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
				PreparedStatement  ps=con.prepareStatement("select sname from symptoms");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					combobox1.addItem(rs.getString("sname"));
				}
				combobox1.addItem("Other Condition");
				
				combobox1.addActionListener(new ActionListener(){
	        		public void actionPerformed(ActionEvent e) {
	        			try{
	        			if(combobox1.getSelectedItem().equals("Other Condition"))
	        			{
	        				flag=1;
	        				contentpane_pt.removeAll();
	        				
	        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    				    contentpane_pt.add(l1,right);
	    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
	    				    contentpane_pt.add(l4, left); contentpane_pt.add(tf1, right);
	    				    contentpane_pt.add(l5, left); contentpane_pt.add(tf2, right);
	    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
	    				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
	    				    model1.setSelected(true);
	    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
	    				    contentpane_pt.revalidate();
	        				
	        			}
	        			else
	        			{
	        				flag=0;
	        				contentpane_pt.removeAll();
	        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    				    contentpane_pt.add(l1,right);
	    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
	    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
	    				    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
	    				    model1.setSelected(true);
	    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
	    				    contentpane_pt.revalidate();
	        			}
	        			
	        			}
	        			catch(Exception pt7)
	        			{
	        				JOptionPane.showMessageDialog(null, pt7.getMessage());
	        			}
	        		}
				});
				l4=new JLabel("Enter Symptom Name:");
				l5=new JLabel("Symptom Description:");
				tf1=new JTextField();tf2=new JTextField();
				layoutSet(contentpane_pt);
				l1 = new JLabel("Update Patient Symptoms");
			    l1.setForeground(Color.BLUE);
		        l1.setFont(new Font("Serif", Font.BOLD, 20));
		        l2 = new JLabel("Symptom Name:");
		        l3 = new JLabel("Appear Time:"); 	
		        model1=new UtilDateModel();
			    JDatePanelImpl datepanel=new JDatePanelImpl(model1);
			    datepicker=new JDatePickerImpl(datepanel);
			    combobox1.setSelectedItem(U_tname);
			    contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			    contentpane_pt.add(l1,right);
			    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
			    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
			    model1.setDate(Integer.parseInt(U_atime.substring(0, 4)), Integer.parseInt(U_atime.substring(5, 7))-1, Integer.parseInt(U_atime.substring(8, 10)));
			    model1.setSelected(true);
			    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
				
			}
			else
				
				JOptionPane.showMessageDialog(null, "Please select the Symptom to update");
			}
			catch(Exception pt1)
			{
				JOptionPane.showMessageDialog(null, pt1.getMessage());
			}
		}
    });
    JButton btn_pat_ad=new JButton("Add");
    btn_pat_ad.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				treat_add=new JFrame();
				treat_add.setBounds(100, 100, 440, 280);
				treat_add.setVisible(true);
				treat_add.setResizable(false);
				treat_add.setTitle("Add New Symptom");
				contentpane_pt = new JPanel();
				contentpane_pt.setBorder(new EmptyBorder(5, 5, 5, 5));
				treat_add.setContentPane(contentpane_pt);
				btn_pat_cancel=new JButton("Cancel");
				btn_pat_cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							treat_add.dispose();
						}
						catch(Exception pt5)
						{
							JOptionPane.showMessageDialog(null, pt5.getMessage());
						}}});
				
				
				btn_pat_insert=new JButton("Insert");
				btn_pat_insert.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String tname_cmp,tdesc_n,dob_c,mon;
							int pid,tid;
							PreparedStatement  ps;
							if(!combobox1.getSelectedItem().equals("-----Select Symptom-----"))
							{
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
								ps=con.prepareStatement("select pid,dob from patients where email='"+loggedName+"'");
								ResultSet rs=ps.executeQuery();
								rs.next();pid=rs.getInt("pid");dob_c=rs.getString("dob");
								mon=String.valueOf(Integer.parseInt(dob_c.substring(5,7))-1);
								if(mon.length()<2) mon="0"+mon;
								dob_c=dob_c.substring(0,4)+mon+dob_c.substring(8,10);
								//JOptionPane.showMessageDialog(null, datepicker.getModel().getValue());
								Date selectedDate = (Date) datepicker.getModel().getValue();
								Calendar cal = Calendar.getInstance() ;Calendar cur_date = Calendar.getInstance() ;
								cal.setTime(selectedDate);
								String day=Integer.toString(cal.get(Calendar.DATE));
								String month =Integer.toString( cal.get(Calendar.MONTH)+1); String year=Integer.toString(cal.get(Calendar.YEAR));
								if(day.length()<2) day="0"+day;
								if(month.length()<2) month="0"+month;
								String date=year+month+day;
								int date1=Integer.parseInt(date);
								if(cal.before(cur_date) && date1>=Integer.parseInt(dob_c))
								{
								if(flag==1)
								{
									tname_cmp=tf1.getText();
									String tdesc=tf2.getText();
									if(tname_cmp==null || tname_cmp.isEmpty()|| tdesc==null || tdesc.isEmpty() )
									{
										JOptionPane.showMessageDialog(null, "Not Valid Details");
										return;
									}
									ps=con.prepareStatement("insert into symptoms(sname,sdescription) values('"+tname_cmp+"','"+tdesc+"')");
									ps.executeUpdate();
									tf1.setText("");
									tf2.setText("");
								}
								else tname_cmp=(String) combobox1.getSelectedItem();

								ps=con.prepareStatement("select sid,sdescription from symptoms where sname='"+tname_cmp+"'");
								rs=ps.executeQuery();
								if(rs.next())
								{
									tid=rs.getInt("sid");tdesc_n=rs.getString("sdescription");

									ps=con.prepareStatement("select * from pat_symptoms where sid="+tid+" and pid="+pid+" and (dtime is null or atime='"+date+"')");
									rs=ps.executeQuery();
									if(!rs.next())
									{
								ps=con.prepareStatement("insert into pat_symptoms(sid,pid,atime,insert_time) values("+tid+","+pid+",'"+date+"',NOW())");
								int k=ps.executeUpdate();
								if(k>0)
								{
									ps=con.prepareStatement("select atime from pat_symptoms where sid="+tid+" and pid="+pid+" and dtime is null");
									rs=ps.executeQuery();rs.next();String add_time=rs.getString("atime");
									model.addRow(new Object[]{new Integer(tid),tname_cmp,tdesc_n,add_time});
									model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
									combobox1.setSelectedIndex(0);
									JOptionPane.showMessageDialog(null,"The Symptom is Added");treat_add.dispose();
								}
								}
									else JOptionPane.showMessageDialog(null,"You are already taking this Symptom (or) You were under this Symptom at same time");
								}
								
							}
							else JOptionPane.showMessageDialog(null,"The Symptom date should be between date of birth and Current date");
							}
							else
								JOptionPane.showMessageDialog(null,"Please Select Proper Symptom Name");
								
						}
						catch(Exception pt2)
						{
							JOptionPane.showMessageDialog(null, pt2.getMessage());
						}}});
				combobox1=new JComboBox();
				combobox1.addItem("-----Select Symptom-----");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
				PreparedStatement  ps=con.prepareStatement("select sname from symptoms");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					combobox1.addItem(rs.getString("sname"));
				}
				combobox1.addItem("Other Symptom");
				
				combobox1.addActionListener(new ActionListener(){
	        		public void actionPerformed(ActionEvent e) {
	        			try{
	        			if(combobox1.getSelectedItem().equals("Other Symptom"))
	        			{
	        				flag=1;
	        				contentpane_pt.removeAll();
	        				
	        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    				    contentpane_pt.add(l1,right);
	    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
	    				    contentpane_pt.add(l4, left); contentpane_pt.add(tf1, right);
	    				    contentpane_pt.add(l5, left); contentpane_pt.add(tf2, right);
	    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
	    				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
	    				    model1.setSelected(true);
	    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
	    				    contentpane_pt.revalidate();
	        				
	        			}
	        			else
	        			{
	        				flag=0;
	        				contentpane_pt.removeAll();
	        				contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    				    contentpane_pt.add(l1,right);
	    				    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
	    				    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
	    				    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
	    				    model1.setSelected(true);
	    				    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
	    				    contentpane_pt.revalidate();
	        			}
	        			
	        			}
	        			catch(Exception pt7)
	        			{
	        				JOptionPane.showMessageDialog(null, pt7.getMessage());
	        			}
	        		}
				});
				l4=new JLabel("Enter Symptom Name:");
				l5=new JLabel("Symptom Description:");
				tf1=new JTextField();tf2=new JTextField();
				layoutSet(contentpane_pt);
				l1 = new JLabel("Insert Patient Symptom Details");
			    l1.setForeground(Color.BLUE);
		        l1.setFont(new Font("Serif", Font.BOLD, 20));
		        l2 = new JLabel("Symptom Name:");
		        l3 = new JLabel("Appear Time:"); 	
		        model1=new UtilDateModel();
			    JDatePanelImpl datepanel=new JDatePanelImpl(model1);
			    datepicker=new JDatePickerImpl(datepanel);
			    combobox1.setSelectedIndex(0);
			    contentpane_pt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			    contentpane_pt.add(l1,right);
			    contentpane_pt.add(l2, left); contentpane_pt.add(combobox1, right);
			    contentpane_pt.add(l3, left); contentpane_pt.add(datepicker, right);
			    model1.setDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue()-1, LocalDate.now().getDayOfMonth());
			    model1.setSelected(true);
			    contentpane_pt.add(btn_pat_insert, left);contentpane_pt.add(btn_pat_cancel, left);
				
			}
			catch(Exception pt3)
			{
				JOptionPane.showMessageDialog(null, pt3.getMessage());
			}
		}
    });
    bottombtnPnl.add(btn_pat_upd); bottombtnPnl.add(btn_pat_ad);
    bottombtnPnl.add(btn_pat_del); btnpanel.add(bottombtnPnl, BorderLayout.CENTER);

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
PreparedStatement  ps=con.prepareStatement("select s.sid,s.sname,s.sdescription,ps.atime from sampledb.symptoms s,"
	+ "sampledb.pat_symptoms ps where ps.dtime is null and ps.pid in (select pid from sampledb.patients "
	+ "where email='"+loggedName+"') and ps.sid=s.sid");
ResultSet rs = ps.executeQuery();
boolean rs1=rs.next();
while(rs1)
{
 tid=rs.getInt("sid");
 tname=rs.getString("sname");
tdesc=rs.getString("sdescription") ;
atime=rs.getString("atime") ;
model.addRow(new Object[]{new Integer(tid),tname,tdesc,atime});
 rs1=rs.next();
} this.getContentPane().add(scroll);
this.getContentPane().add(btnpanel, BorderLayout.SOUTH);
this.setVisible(true);
this.setSize(600, 300);


}

catch(SQLException e13)
{
	JOptionPane.showMessageDialog(null, e13.getMessage());
}
catch(ClassNotFoundException e13)
{
JOptionPane.showMessageDialog(null, e13.getMessage());
}

}
	
	


public void cough_fatigue()
{
	try
	{
		this.setBounds(100, 100, 440, 280);
		contentpane_dt = new JPanel();
		contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setContentPane(contentpane_dt);
		 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
		this.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		String fname,lname,gender,email;
   		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email"};
   		int age2=-1,pid;
	   this.getContentPane().setLayout(new BorderLayout());
	    final DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columnNames);
	    table = new JTable();
	    table.setModel(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setFillsViewportHeight(true);
	    JScrollPane scroll = new JScrollPane(table);
	    scroll.setHorizontalScrollBarPolicy(
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setVerticalScrollBarPolicy(
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   		
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
   		PreparedStatement  ps=con.prepareStatement("select p1.pid, p1.fname, p1.lname,p1.email,p1.gender,YEAR(CURDATE())-YEAR(p1.dob) as age from sampledb.patients p1 "
   				+ "where p1.pid in (select sp1.pid from sampledb.pat_symptoms sp1,sampledb.pat_symptoms sp2 where sp1.pid=sp2.pid and sp1.sid="
   				+ "(select sid from sampledb.symptoms where sname='cough') and sp2.sid=(select sid from sampledb.symptoms where sname='fatigue') "
   				+ "and sp1.dtime is null and sp2.dtime is null)");
   		ResultSet rs = ps.executeQuery();
   		while(rs.next())
   		{
   		 pid=rs.getInt("pid");
   		 fname=rs.getString("fname");lname=rs.getString("lname");
   		gender=rs.getString("gender") ;
   		email=rs.getString("email") ;age2=rs.getInt("age");
   		model.addRow(new Object[]{new Integer(pid),fname,lname,gender,new Integer(age2),email});
   		} 
   		this.getContentPane().add(scroll);
   		this.setVisible(true);
   		this.setSize(600, 300);
   		
	}
	catch(Exception cf)
	{
		JOptionPane.showMessageDialog(null, cf.getMessage());
	}
}


public void past_diabetes()
{
	try
	{
		this.setBounds(100, 100, 440, 280);
		contentpane_dt = new JPanel();
		contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setContentPane(contentpane_dt);
		 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
		this.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		String fname,lname,gender,email;
   		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email"};
   		int age2=-1,pid;
	   this.getContentPane().setLayout(new BorderLayout());
	    final DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columnNames);
	    table = new JTable();
	    table.setModel(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setFillsViewportHeight(true);
	    JScrollPane scroll = new JScrollPane(table);
	    scroll.setHorizontalScrollBarPolicy(
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setVerticalScrollBarPolicy(
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   		
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
   		PreparedStatement  ps=con.prepareStatement("select pid, fname,lname,email,gender,YEAR(CURDATE())-YEAR(dob) as age"
   				+ " from sampledb.patients where pid in (select pid from sampledb.pat_conditions "
   				+ "where cid in (select cid from sampledb.conditions where cname='diabetes' ) and dtime is not null and "
   				+ "pid not in (select pid from sampledb.pat_conditions where cid in "
   				+ "(select cid from sampledb.conditions where cname='diabetes' ) and dtime is null))");
   		ResultSet rs = ps.executeQuery();
   		while(rs.next())
   		{
   		 pid=rs.getInt("pid");
   		 fname=rs.getString("fname");lname=rs.getString("lname");
   		gender=rs.getString("gender") ;
   		email=rs.getString("email") ;age2=rs.getInt("age");
   		model.addRow(new Object[]{new Integer(pid),fname,lname,gender,new Integer(age2),email});
   		} 
   		this.getContentPane().add(scroll);
   		this.setVisible(true);
   		this.setSize(600, 300);
   		
	}
	catch(Exception cf)
	{
		JOptionPane.showMessageDialog(null, cf.getMessage());
	}
}

public void female_msg2db()
{

	try
	{
		this.setBounds(100, 100, 440, 280);
		contentpane_dt = new JPanel();
		contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setContentPane(contentpane_dt);
		 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
		this.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		String fname,lname,gender,email;
   		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email"};
   		int age2=-1,pid;
	   this.getContentPane().setLayout(new BorderLayout());
	    final DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columnNames);
	    table = new JTable();
	    table.setModel(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setFillsViewportHeight(true);
	    JScrollPane scroll = new JScrollPane(table);
	    scroll.setHorizontalScrollBarPolicy(
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setVerticalScrollBarPolicy(
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   		
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
   		PreparedStatement  ps=con.prepareStatement("select pid, fname,lname,email,gender,YEAR(CURDATE())-YEAR(dob) as age "
   				+ " from sampledb.patients where gender='f' and pid in(select senderid from sampledb.message "
   				+ "where recvid in (select pid from sampledb.pat_conditions "
   				+ "where cid in (select cid from sampledb.conditions "
   				+ "where cname='diabetes') and dtime is null))");
   		ResultSet rs = ps.executeQuery();
   		while(rs.next())
   		{
   		 pid=rs.getInt("pid");
   		 fname=rs.getString("fname");lname=rs.getString("lname");
   		gender=rs.getString("gender") ;
   		email=rs.getString("email") ;age2=rs.getInt("age");
   		model.addRow(new Object[]{new Integer(pid),fname,lname,gender,new Integer(age2),email});
   		} 
   		this.getContentPane().add(scroll);
   		this.setVisible(true);
   		this.setSize(600, 300);
   		
	}
	catch(Exception cf)
	{
		JOptionPane.showMessageDialog(null, cf.getMessage());
	}

}
public void second_oldest()
{


	try
	{
		this.setBounds(100, 100, 440, 280);
		contentpane_dt = new JPanel();
		contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setContentPane(contentpane_dt);
		 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
		this.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		String fname,lname,gender,email;
   		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email"};
   		int age2=-1,pid;
	   this.getContentPane().setLayout(new BorderLayout());
	    final DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columnNames);
	    table = new JTable();
	    table.setModel(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setFillsViewportHeight(true);
	    JScrollPane scroll = new JScrollPane(table);
	    scroll.setHorizontalScrollBarPolicy(
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setVerticalScrollBarPolicy(
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   		
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
   		PreparedStatement  ps=con.prepareStatement("select pid,fname,lname,gender,YEAR(CURDATE())-YEAR(dob) as age,email from sampledb.patients "
   				+ "where YEAR(CURDATE())-YEAR(dob)=(select Max(YEAR(CURDATE())-YEAR(dob)) from sampledb.patients "
   				+ "where YEAR(CURDATE())-YEAR(dob)<(select max(YEAR(CURDATE())-YEAR(dob)) from sampledb.patients ))");
   		ResultSet rs = ps.executeQuery();
   		while(rs.next())
   		{
   		 pid=rs.getInt("pid");
   		 fname=rs.getString("fname");lname=rs.getString("lname");
   		gender=rs.getString("gender") ;
   		email=rs.getString("email") ;age2=rs.getInt("age");
   		model.addRow(new Object[]{new Integer(pid),fname,lname,gender,new Integer(age2),email});
   		} 
   		this.getContentPane().add(scroll);
   		this.setVisible(true);
   		this.setSize(600, 300);
   		
	}
	catch(Exception cf)
	{
		JOptionPane.showMessageDialog(null, cf.getMessage());
	}


}

public void pt_nomsg()
{



	try
	{
		this.setBounds(100, 100, 440, 280);
		contentpane_dt = new JPanel();
		contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setContentPane(contentpane_dt);
		 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
		this.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		String fname,lname,gender,email;
   		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email"};
   		int age2=-1,pid;
	   this.getContentPane().setLayout(new BorderLayout());
	    final DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columnNames);
	    table = new JTable();
	    table.setModel(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setFillsViewportHeight(true);
	    JScrollPane scroll = new JScrollPane(table);
	    scroll.setHorizontalScrollBarPolicy(
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setVerticalScrollBarPolicy(
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   		
   		Class.forName("com.mysql.jdbc.Driver");
   		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
   		PreparedStatement  ps=con.prepareStatement("select pid,fname,lname,gender,YEAR(CURDATE())-YEAR(dob) as age,email from sampledb.patients "
   				+ "where pid in (select pid from sampledb.pat_treatment "
   				+ "where tid in (select tid from sampledb.treatment where tname='physical therapy') and dtime is null) "
   				+ "and pid not in (select senderid from sampledb.message)");
   		ResultSet rs = ps.executeQuery();
   		while(rs.next())
   		{
   		 pid=rs.getInt("pid");
   		 fname=rs.getString("fname");lname=rs.getString("lname");
   		gender=rs.getString("gender") ;
   		email=rs.getString("email") ;age2=rs.getInt("age");
   		model.addRow(new Object[]{new Integer(pid),fname,lname,gender,new Integer(age2),email});
   		} 
   		this.getContentPane().add(scroll);
   		this.setVisible(true);
   		this.setSize(600, 300);
   		
	}
	catch(Exception cf)
	{
		JOptionPane.showMessageDialog(null, cf.getMessage());
	}

}
public void most_messagestoX()
{
	try
	{

		
		setResizable(false);
		
		contentpane3=new JPanel();
		contentpane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane3);
		layoutSet(contentpane3);
		
		  sl1 = new JLabel("Most Number of Messages To:");
		    sl1.setForeground(Color.BLUE);
	        sl1.setFont(new Font("Serif", Font.BOLD, 20));
	        sl2 = new JLabel("   Select E-Mail ID:          ");
//	        sl3 = new JLabel("      Password:           ");
//	        stf1 = new JTextField();
//		    sp1 = new JPasswordField();
		    combobox1=new JComboBox();
		    Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
			 PreparedStatement  ps=con.prepareStatement("select email from patients");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				combobox1.addItem(rs.getString("email"));
			}
			 sbtn1 = new JButton("Search");
			    sbtn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
							
							setBounds(100, 100, 440, 280);
							contentpane_dt = new JPanel();
							contentpane_dt.setBorder(new EmptyBorder(5, 5, 5, 5));
							 setContentPane(contentpane_dt);
							 contentpane_dt.setLayout(new MigLayout("", "[283px]", "[23px][23px][23px][23px][]"));
							setVisible(true);
							/////////////////////////////////////////////////////////////////////////////////
							String fname,lname,gender,email;
					   		String[] columnNames = {"Patient ID", "First Name", "Last Name", "Gender","Age","Email","Message Count"};
					   		int age2=-1,pid;
						   getContentPane().setLayout(new BorderLayout());
						    final DefaultTableModel model = new DefaultTableModel();
						    model.setColumnIdentifiers(columnNames);
						    table = new JTable();
						    table.setModel(model);
						    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						    table.setFillsViewportHeight(true);
						    JScrollPane scroll = new JScrollPane(table);
						    scroll.setHorizontalScrollBarPolicy(
						            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						    scroll.setVerticalScrollBarPolicy(
						            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
							
							ResultSet rs1;
							int pid1,count;
							 email=(String) combobox1.getSelectedItem();
							 Class.forName("com.mysql.jdbc.Driver");
							 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
							 PreparedStatement  ps=con.prepareStatement("select senderid,count(senderid) as countmsg from sampledb.message where recvid in "
							 		+ "(select pid from sampledb.patients where email='"+email+"') group by senderid "
							 		+ "having count(senderid)=(SELECT COUNT(senderid) FROM   sampledb.message "
							 		+ "where recvid in (select pid from sampledb.patients where"
							 		+ " email='"+email+"') GROUP  BY senderid ORDER  BY COUNT(senderid) DESC LIMIT  1);");
							ResultSet rs = ps.executeQuery();
							while(rs.next())
							{
								count=rs.getInt("countmsg");
								pid=rs.getInt("senderid");
								ps=con.prepareStatement("select pid,fname,lname,gender,YEAR(CURDATE())-YEAR(dob) as age,email from sampledb.patients where pid="+pid);
								rs1=ps.executeQuery();
								if(rs1.next())
								{
									 pid1=rs1.getInt("pid");
							   		 fname=rs1.getString("fname");lname=rs1.getString("lname");
							   		gender=rs1.getString("gender") ;
							   		email=rs1.getString("email") ;age2=rs1.getInt("age");
							   		model.addRow(new Object[]{new Integer(pid1),fname,lname,gender,new Integer(age2),email,new Integer(count)});
							   		getContentPane().add(scroll);
							   		setVisible(true);
							   		setSize(600, 300);
								}
							}
						}
						catch(Exception e2)
						{
							JOptionPane.showMessageDialog(null,e2.getMessage())	;
						}
						
						
						}
			    });
			    	        
		    contentpane3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    contentpane3.add(sl1,top);
		    contentpane3.add(sl2, left); contentpane3.add(combobox1, right);
		   // contentpane2.add(sl3, left); contentpane2.add(sp1, right);
		    contentpane3.add(sbtn1, left);
		    
		    setVisible(true);
	    
	}
	catch(Exception cf)
	{
		JOptionPane.showMessageDialog(null, cf.getMessage());
	}
	
}
JTextArea ta;
public void send_message()
{
	try
	{
		setResizable(false);
		
		contentpane3=new JPanel();
		contentpane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane3);
		layoutSet(contentpane3);
		//setTitle("Patients Login");
			l1=new JLabel("      Content:           ");
			ta=new JTextArea(5,20);
			javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK);
			ta.setBorder(BorderFactory.createCompoundBorder(border, 
			            BorderFactory.createEmptyBorder(15, 15, 15, 15)));
		  sl1 = new JLabel("Send Message");
		    sl1.setForeground(Color.BLUE);
	        sl1.setFont(new Font("Serif", Font.BOLD, 20));
	        sl2 = new JLabel("      Receiver ID:          ");
	        sl3 = new JLabel("      Subject:           ");
	        stf1 = new JTextField();
		    combobox1=new JComboBox();
		    Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
			 PreparedStatement  ps=con.prepareStatement("select email from patients");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				combobox1.addItem(rs.getString("email"));
			}
			
			 sbtn1 = new JButton("Send");
			    sbtn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String subjct,email,content;
							int pid,rid;
							email=combobox1.getSelectedItem().toString();
							subjct=stf1.getText();
							if(subjct!=null && !subjct.isEmpty())
							{
							content=ta.getText();
							if(content!=null && !content.isEmpty())
							{
								 Class.forName("com.mysql.jdbc.Driver");
								 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","sampledb","pass1234");
								 PreparedStatement  ps=con.prepareStatement("select pid from patients where email='"+loggedName+"'");
								 ResultSet rs= ps.executeQuery();
								 if(rs.next())
								 {
								 pid=rs.getInt("pid");
								 ps=con.prepareStatement("select pid from patients where email='"+email+"'");
								 rs= ps.executeQuery();rs.next();rid=rs.getInt("pid");
								 if(pid!=rid)
								 {
								 ps=con.prepareStatement("insert into message (senderid,recvid,stime,subject,content) values("+pid+","+rid+",NOW(),'"+subjct+"','"+content+"')");
								// JOptionPane.showMessageDialog(null,"insert into message (senderid,recvid,stime,subject,content) values("+pid+","+rid+",NOW(),'"+subjct+"','"+content+"')");
								if(ps.executeUpdate()>0)
								{
									 JOptionPane.showMessageDialog(null,"Message sent");
									 stf1.setText("");ta.setText("");
								}
								 
								 }
								 else JOptionPane.showMessageDialog(null,"You Can't send message to yourself");
								 }
							}
							else JOptionPane.showMessageDialog(null,"Please Enter proper Content");
							}
							else JOptionPane.showMessageDialog(null,"Please Enter proper Subject");
							
						}
						catch(Exception e2)
						{
							JOptionPane.showMessageDialog(null,e2.getMessage())	;
						}
						
						
						}
			    });
			    
	        
		    contentpane3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		    contentpane3.add(sl1,top);
		    contentpane3.add(sl2, left); contentpane3.add(combobox1, right);
		    contentpane3.add(sl3, left); contentpane3.add(stf1, right);
		    contentpane3.add(l1, left); contentpane3.add(ta, right);
		    contentpane3.add(sbtn1, left); 
		    
		    setVisible(true);
		
	}

	catch(Exception cf)
	{
		JOptionPane.showMessageDialog(null, cf.getMessage());
	}
}
	
}
 
