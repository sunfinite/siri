// Demonstrate CharArrayReader.
   import java.io.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import javax.swing.text.*;
   import javax.swing.event.*;

/*
<applet code="SearchEngine" width=4000 height=1450>
</applet>
*/
   public class SearchEngine extends JApplet implements CaretListener, ActionListener, ListSelectionListener
   
   {
      Container c;
		//VSH
		boolean vowFlag = false,space = false;
   	
      JComboBox combobox1;
      JTextField  textBox1;
      JTextField  textBox2;
      JTextField  textBox3;
      JButton button1;// search
      JButton button2;// clear
   	
      DefaultListModel listModel1;
      JScrollPane listScrollPane1;
      JList list1;
      DefaultListModel listModel2;
      JScrollPane listScrollPane2;
      JList list2;
      DefaultListModel listModel3;
      JScrollPane listScrollPane3;
      JList list3;
   	
   
      String language;
      String allLanguages[];
   	
      String RecommendedStr[][];
   
   
      Font kanFont, telFont, malFont, f1;
   	
      String prevInput;
   
      public void init()
      {
         try
         {
            SwingUtilities.invokeAndWait(
                  new Runnable(){
                     public void run()
                     {
                        makeGUI();
                     }
                  }
               );
         }
            catch(Exception ex)
            {
               System.out.println("GUI Building exception...");
            }
      
      }
   	
   	
      public void caretUpdate(CaretEvent e)
      {
         System.out.println("Inside caretUpdate()..");
      	
      	
         if(language.equals("Kannada"))
         {
            String strKan = textBox1.getText();
         	
            if(textBox1.getText().equals(""))
               return;
         	
            char tempEng[];
            tempEng = new char[1];
         	
            tempEng[0] = strKan.charAt(strKan.length() - 1);
         	
            if((tempEng[0] < '\u0CF0' && tempEng[0] > '\u0C81') || (new String(tempEng).equals(" ")))
               return;
         	
            try{
               strKan = strKan.substring(0, strKan.length() - 1);
            }
               catch(Exception ex)
               {
                  strKan = "";
               }
         	
            System.out.println("strKan==>" + strKan + "===strEng==>" + new String(tempEng) + "===");
         	
            ConvertToKannada obj1 = new ConvertToKannada();
         	
            String strEng = obj1.kannadaToEnglish(strKan);
         	
            System.out.println("strEng==>" + strEng + "===" + new String(tempEng) + "===");
            strEng = strEng + new String(tempEng);
            String strKan1 = temporaryConvertToKannada(strEng);
            System.out.println("Final Converted Kannada String is==>" + strKan1 + "===");
            final String tempo = strKan1;
            SwingUtilities.invokeLater(
                  new Runnable()
                  {
                     public void run()
                     {
                        textBox1.setText(tempo);
                        processRecommendationKannada();
                     }
                  });
         }
         else if(language.equals("Telugu"))
         {
            String strTel = textBox2.getText();
         	
            if(textBox2.getText().equals(""))
               return;
         	
            char tempEng[];
            tempEng = new char[1];
         	
            tempEng[0] = strTel.charAt(strTel.length() - 1);
         	
            if((tempEng[0] < '\u0C70' && tempEng[0] > '\u0C00') || (new String(tempEng).equals(" ")))
               return;
         	
            try{
               strTel = strTel.substring(0, strTel.length() - 1);
            }
               catch(Exception ex)
               {
                  strTel = "";
               }
         	
            System.out.println("strTel==>" + strTel + "===strEng==>" + new String(tempEng) + "===");
         	
            ConvertToTelugu obj1 = new ConvertToTelugu();
         	
            String strEng = obj1.teluguToEnglish(strTel);
         	
            System.out.println("strEng==>" + strEng + "===" + new String(tempEng) + "===");
            strEng = strEng + new String(tempEng);
            String strTel1 = temporaryConvertToTelugu(strEng);
            System.out.println("Final Converted Telugu String is==>" + strTel1 + "===");
            final String tempo = strTel1;
            SwingUtilities.invokeLater(
                  new Runnable()
                  {
                     public void run()
                     {
                        textBox2.setText(tempo);
                        processRecommendationTelugu();
                     }
                  });
         	//textBox2.setText(strKan);
         }
         else if(language.equals("Malayalam"))
         {
            String strMal = textBox3.getText();
         	
            if(textBox3.getText().equals(""))
               return;
         	
            char tempEng[];
            tempEng = new char[1];
         	
            tempEng[0] = strMal.charAt(strMal.length() - 1);
         	
            if((tempEng[0] < '\u0D4E' && tempEng[0] > '\u0D01') || (new String(tempEng).equals(" ")))
               return;
         	
            try{
               strMal = strMal.substring(0, strMal.length() - 1);
            }
               catch(Exception ex)
               {
                  strMal = "";
               }
         	
            System.out.println("strMal==>" + strMal + "===strEng==>" + new String(tempEng) + "===");
         	
            ConvertToMalayalam obj1 = new ConvertToMalayalam();
         	
            String strEng = obj1.malayalamToEnglish(strMal);
         	
            System.out.println("strEng==>" + strEng + "===" + new String(tempEng) + "===");
            strEng = strEng + new String(tempEng);
            String strMal1 = temporaryConvertToMalayalam(strEng);
            System.out.println("Final Converted Malayalam String is==>" + strMal1 + "===");
            final String tempo = strMal1;
            SwingUtilities.invokeLater(
                  new Runnable()
                  {
                     public void run()
                     {
                        textBox3.setText(tempo);
                        processRecommendationMalayalam();
                     }
                  });
         }
         System.out.println("==========================");
      }
   	
   	
   	
      private void makeGUI()
      {
      
         prevInput = "";
      	
         System.out.println("inside makeGUI...");
      
         c = getContentPane();
         c.setLayout( new GridLayout( 200, 20 ) );
         c.setLayout(null);
      
         GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
      
      /*
      String fonts[] = env.getAvailableFontFamilyNames();
      
      for(String X : fonts)
      	System.out.println(X);
      */
      
      
      //Kannada..
      //Font kanFont = new Font("KN-TTUma Normal", Font.PLAIN, 20);
      //Font kanFont = new Font("BRH Kannada", Font.PLAIN, 20);		
         kanFont = new Font("Mallige", Font.BOLD, 20);
      
      //Malayalam..
         malFont = new Font("Kartika", Font.BOLD, 20);
      
      //Telugu..
         telFont = new Font("Gautami", Font.BOLD, 20);
      
      
         Font f1 = new Font("SansSerif", Font.BOLD, 20);
      
      //TextField..
         textBox1 = new JTextField();
         textBox1.setBounds(15, 20, 800, 30);
         textBox1.setFont(kanFont);
         textBox1.setBackground(Color.white);
         textBox1.setForeground(Color.black);
      
      //TextField..
         textBox2 = new JTextField();
         textBox2.setBounds(15, 20, 800, 30);
         textBox2.setFont(telFont);
         textBox2.setBackground(Color.white);
         textBox2.setForeground(Color.red);
      	
      //TextField..
         textBox3 = new JTextField();
         textBox3.setBounds(15, 20, 800, 30);
         textBox3.setFont(malFont);
         textBox3.setBackground(Color.white);
         textBox3.setForeground(Color.red);
      
         allLanguages = new String[3];
         allLanguages[0] = "Kannada";
         allLanguages[1] = "Telugu";
         allLanguages[2] = "Malayalam";
      
      //Choice..
         combobox1 = new JComboBox(allLanguages);
         combobox1.setBounds(845, 105, 100, 30);
      	
      
      //Button..
         button1 = new JButton("search");
         button1.setBounds(845, 15, 100, 30);
      
      //Button..
         button2 = new JButton("clear");
         button2.setBounds(845, 60, 100, 30);		
      
      //AbstractDocument..
         AbstractDocument doc;
      
         //StyledDocument styledDoc = textBox2.getStyledDocument();
         //doc = (AbstractDocument)styledDoc;
      
         //doc.addDocumentListener(this);
      	
      	
      	
      	// list box 1..
         listModel1 = new DefaultListModel();
         list1 = new JList(listModel1);
         list1.setBackground(Color.white);
         list1.setForeground(Color.blue);
      	
         list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list1.setSelectedIndex(0);
         list1.setBounds(15, 60, 800, 75);
         list1.addListSelectionListener(this);
         list1.setVisibleRowCount(5);
         listScrollPane1 = new JScrollPane(list1);
         listScrollPane1.setBounds(15, 59, 800, 75);
         list1.setFont(kanFont);
      	
      	// list box 2..
         listModel2 = new DefaultListModel();
         list2 = new JList(listModel2);
         list2.setBackground(Color.white);
         list2.setForeground(Color.blue);
      	
         list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list2.setSelectedIndex(0);
         list2.setBounds(15, 60, 800, 75);
         list2.addListSelectionListener(this);
         list2.setVisibleRowCount(5);
         listScrollPane2 = new JScrollPane(list2);
         listScrollPane2.setBounds(15, 59, 800, 75);
         list2.setFont(telFont);
         
      	
      	
      	// list box 3..
         listModel3 = new DefaultListModel();
         list3 = new JList(listModel3);
         list3.setBackground(Color.white);
         list3.setForeground(Color.blue);
      	
         list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list3.setSelectedIndex(0);
         list3.setBounds(15, 60, 800, 75);
         list3.addListSelectionListener(this);
         list3.setVisibleRowCount(5);
         listScrollPane3 = new JScrollPane(list3);
         listScrollPane3.setBounds(15, 59, 800, 75);
         list3.setFont(malFont);
      	
      	
      	
      //add controls..
         c.add(textBox1);
         c.add(textBox2);
         c.add(textBox3);
         c.add(button1);
         c.add(button2);
         c.add(combobox1);
      	//c.add(list);
         c.add(listScrollPane1);
         c.add(listScrollPane2);
         c.add(listScrollPane3);
         
      
         combobox1.addActionListener(this);
         button1.addActionListener(this);
         button2.addActionListener(this);
      	
         textBox1.addCaretListener(this);
         textBox2.addCaretListener(this);
         textBox3.addCaretListener(this);
      
         //textBox2.setEditable(false);
      
         setSize(1000, 160);
         language = "Kannada";
      	
         textBox1.setVisible(true);		// kannada
         textBox2.setVisible(false);	// telugu
         textBox3.setVisible(false);	// Malayalam
         
         listScrollPane1.setVisible(true);
         listScrollPane2.setVisible(false);
         listScrollPane3.setVisible(false);
			
			if(language.equals("Kannada"))
				setKannadaVK();
   
	      System.out.println("GUI Build Successful...");
      
      }
         
      public void actionPerformed(ActionEvent ae)
      {
         String str_ae = ae.getActionCommand();
         System.out.println("Event Occured : " + str_ae);
         if(str_ae.equals("search"))
         {
         }
         else if(str_ae.equals("clear"))
         {
            textBox1.setText("");
            textBox2.setText("");
            textBox3.setText("");
            listModel1.clear();
            listModel2.clear();
            listModel3.clear();
         }
         else
         {
            language = (String) combobox1.getSelectedItem();
            System.out.println("Language Changed to " + language);
            textBox2.setText("");
         	
         	/*MutableAttributeSet attr = new SimpleAttributeSet();
         	StyleConstants.setFontFamily(attr,language);
         	setAttributeSet(attr);*/
         	
            if(language.equals("Kannada"))
            {
               //textBox1.setText("");
               textBox2.setText("");
               textBox3.setText("");
               textBox1.setVisible(true);	// kannada
               textBox2.setVisible(false);	// telugu
               textBox3.setVisible(false);	// Malayalam
               listScrollPane1.setVisible(true);
               listScrollPane2.setVisible(false);
               listScrollPane3.setVisible(false);
						
								
					//VSH
						
						String str = str_ae;
						
						System.out.println(vowFlag);	
							
			         if(str.equals("\u0C85\u0CB3\u0CBF\u0CB8\u0CC1"))
			         {
			            textBox1.setText("");
			            vowFlag = false;
			         }
						else if(str.equals("\u0C82") || str.equals("\u0C83"))
						{
							if(vowFlag == true || space == true)
								textBox1.setText(textBox1.getText() + str);
							vowFlag = false;
						}
						
						else if(((str.compareTo("\u0C85") >= 0) && (str.compareTo("\u0C94") <= 0)))		//For numbers
						{
							textBox1.setText(textBox1.getText() + str);
							vowFlag = false;
						}	
						else if(((str.compareTo("\u0CE6") >= 0) && (str.compareTo("\u0CEF") <= 0)))		//For numbers
						{
							textBox1.setText(textBox1.getText() + str);
							vowFlag = false;
							space = true;
						}	
			         else if((vowFlag == false) && (!((str.compareTo("\u0CBE") >= 0) && (str.compareTo("\u0CDE") <= 0))))	
			         {
			            if(!str.equals("\u0C96\u0CBE\u0CB2\u0CBF"))
			     			{
							   textBox1.setText(textBox1.getText() + str);
								vowFlag = true;
							}	
			            else 
							{
							 	if(space == true)
							   {
								 	textBox1.setText(textBox1.getText() + " ");
									space = false;
								}	
								 vowFlag = false;
							}	 
			         }	
						else if((vowFlag == true))
						{
							if(!str.equals("\u0C96\u0CBE\u0CB2\u0CBF"))
							   textBox1.setText(textBox1.getText() + str);
			            else 
							{
							    textBox1.setText(textBox1.getText() + " ");
								 vowFlag = false;
							}	 
							if(((str.compareTo("\u0CBE") >= 0) && (str.compareTo("\u0CDE") <= 0)))		 
							{
								vowFlag = false;		 
								space = true;
							}	
						}
					//VSH
            	
            }
            else if(language.equals("Telugu"))
            {
               textBox1.setText("");
               textBox2.setText("");
               textBox3.setText("");
               textBox1.setVisible(false);	// kannada
               textBox2.setVisible(true);	// telugu
               textBox3.setVisible(false);	// Malayalam
               listScrollPane1.setVisible(false);
               listScrollPane2.setVisible(true);
               listScrollPane3.setVisible(false);
            }
            else if(language.equals("Malayalam"))
            {
               textBox1.setText("");
               textBox2.setText("");
               textBox3.setText("");
               textBox1.setVisible(false);	// kannada
               textBox2.setVisible(false);	// telugu
               textBox3.setVisible(true);	// Malayalam
               listScrollPane1.setVisible(false);
               listScrollPane2.setVisible(false);
               listScrollPane3.setVisible(true);
            }
            else
               System.out.println("Unknown Language..");
         }
         repaint();
      }
		
		public void setKannadaVK()
		{
			Font f = new Font("Mallige", Font.BOLD, 20);
			Container jfrm;
			jfrm = getContentPane();
         jfrm.setLayout( new GridLayout( 200, 20 ) );
         jfrm.setLayout(null);
         //jfrm.setFont(f);
         //jfrm.setLayout(null);
         //jfrm.setSize(1250,500);
         //jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         //txt = new JTextField(70);
         //txt.setBounds(100,40,960,40);
         //jfrm.add(txt);
         //txt.setText("");		
         //txt.setFont(f);
         int x = 100,y = 150,x1 = 60,y1 = 40,i=0;
               
         JButton btna = new JButton("\u0C85");
         btna.setBounds(x+x1*i++,y,x1,y1);
         btna.setFont(f);
         btna.addActionListener(this);
         JButton btnaa = new JButton("\u0C86");
         btnaa.setBounds(x+x1*i++,y,x1,y1);
         btnaa.setFont(f);
         btnaa.addActionListener(this);
         JButton btni = new JButton("\u0C87");
         btni.setBounds(x+x1*i++,y,x1,y1);
         btni.setFont(f);
         btni.addActionListener(this);
         JButton btnii = new JButton("\u0C88");
         btnii.setBounds(x+x1*i++,y,x1,y1);
         btnii.setFont(f);
         btnii.addActionListener(this);
         JButton btnu = new JButton("\u0C89");
         btnu.setBounds(x+x1*i++,y,x1,y1);
         btnu.addActionListener(this);
         btnu.setFont(f);
         JButton btnuu = new JButton("\u0C8A");
         btnuu.setBounds(x+x1*i++,y,x1,y1);
         btnuu.addActionListener(this);
         btnuu.setFont(f);
         JButton btnr = new JButton("\u0C8B");
         btnr.setBounds(x+x1*i++,y,x1,y1);
         btnr.setFont(f);
         btnr.addActionListener(this);
         JButton btnrr = new JButton("\u0CE0");
         btnrr.setBounds(x+x1*i++,y,x1,y1);
         btnrr.setFont(f);
         btnrr.addActionListener(this);
         JButton btne = new JButton("\u0C8E");
         btne.setBounds(x+x1*i++,y,x1,y1);
         btne.addActionListener(this);
         btne.setFont(f);
         JButton btnee = new JButton("\u0C8F");
         btnee.setBounds(x+x1*i++,y,x1,y1);
         btnee.setFont(f);
         btnee.addActionListener(this);
         JButton btnai = new JButton("\u0C90");
         btnai.setBounds(x+x1*i++,y,x1,y1);
         btnai.setFont(f);
         btnai.addActionListener(this);
         JButton btno = new JButton("\u0C92");
         btno.setBounds(x+x1*i++,y,x1,y1);
         btno.setFont(f);
         btno.addActionListener(this);
         JButton btnoo = new JButton("\u0C93");
         btnoo.setBounds(x+x1*i++,y,x1,y1);
         btnoo.setFont(f);
         btnoo.addActionListener(this);
         JButton btnou = new JButton("\u0C94");
         btnou.setBounds(x+x1*i++,y,x1,y1);
         btnou.setFont(f);
         btnou.addActionListener(this);
         JButton btnam = new JButton("\u0C85\u0C82");
         btnam.setBounds((x+x1*i++),y,x1+5,y1);
         btnam.setFont(f);
         btnam.addActionListener(this);
         JButton btnaha = new JButton("\u0C85\u0C83");
         btnaha.setBounds(x+x1*i++,y,x1,y1);
         btnaha.setFont(f);
         btnaha.addActionListener(this);
      
         x = 400;
         y += 50;
         i=0;
      
         JButton btnka = new JButton("\u0C95");
         btnka.setBounds(x+x1*i++,y,x1,y1);
         btnka.setFont(f);
         btnka.addActionListener(this);
         JButton btnkha = new JButton("\u0C96");
         btnkha.setBounds(x+x1*i++,y,x1,y1);
         btnkha.setFont(f);
         btnkha.addActionListener(this);
         JButton btnga = new JButton("\u0C97");
         btnga.setBounds(x+x1*i++,y,x1,y1);
         btnga.setFont(f);
         btnga.addActionListener(this);
         JButton btngha = new JButton("\u0C98");
         btngha.setBounds(x+x1*i++,y,x1,y1);
         btngha.setFont(f);
         btngha.addActionListener(this);
         JButton btnnga = new JButton("\u0C99");
         btnnga.setBounds(x+x1*i++,y,x1,y1);
         btnnga.setFont(f);
         btnnga.addActionListener(this);
      
         x = 400;
         y += 50;
         i=0;
      
         JButton btnca = new JButton("\u0C9A");
         btnca.setBounds(x+x1*i++,y,x1,y1);
         btnca.setFont(f);
         btnca.addActionListener(this);
         JButton btncha = new JButton("\u0C9B");
         btncha.setBounds(x+x1*i++,y,x1,y1);
         btncha.setFont(f);
         btncha.addActionListener(this);
         JButton btnja = new JButton("\u0C9C");
         btnja.setBounds(x+x1*i++,y,x1,y1);
         btnja.setFont(f);
         btnja.addActionListener(this);
         JButton btnjha = new JButton("\u0C9D");
         btnjha.setBounds(x+x1*i++,y,x1,y1);
         btnjha.setFont(f);
         btnjha.addActionListener(this);
         JButton btnnya = new JButton("\u0C9E");
         btnnya.setBounds(x+x1*i++,y,x1,y1);
         btnnya.setFont(f);
         btnnya.addActionListener(this);
      
         x = 400;
         y += 50;
         i=0;
      
         JButton btntta = new JButton("\u0C9F");
         btntta.setBounds(x+x1*i++,y,x1,y1);
         btntta.setFont(f);
         btntta.addActionListener(this);
         JButton btnttha = new JButton("\u0CA0");
         btnttha.setBounds(x+x1*i++,y,x1,y1);
         btnttha.setFont(f);
         btnttha.addActionListener(this);
         JButton btndda = new JButton("\u0CA1");
         btndda.setBounds(x+x1*i++,y,x1,y1);
         btndda.setFont(f);
         btndda.addActionListener(this);
         JButton btnddha = new JButton("\u0CA2");
         btnddha.setBounds(x+x1*i++,y,x1,y1);
         btnddha.setFont(f);
         btnddha.addActionListener(this);
         JButton btnnna = new JButton("\u0CA3");
         btnnna.setBounds(x+x1*i++,y,x1,y1);
         btnnna.setFont(f);
         btnnna.addActionListener(this);
      
         x = 400;
         y += 50;
         i=0;
      
         JButton btnta = new JButton("\u0CA4");
         btnta.setBounds(x+x1*i++,y,x1,y1);
         btnta.setFont(f);
         btnta.addActionListener(this);
         JButton btntha = new JButton("\u0CA5");
         btntha.setBounds(x+x1*i++,y,x1,y1);
         btntha.setFont(f);
         btntha.addActionListener(this);
         JButton btnda = new JButton("\u0CA6");
         btnda.setBounds(x+x1*i++,y,x1,y1);
         btnda.setFont(f);
         btnda.addActionListener(this);
         JButton btndha = new JButton("\u0CA7");
         btndha.setBounds(x+x1*i++,y,x1,y1);
         btndha.setFont(f);
         btndha.addActionListener(this);
         JButton btnna = new JButton("\u0CA8");
         btnna.setBounds(x+x1*i++,y,x1,y1);
         btnna.setFont(f);
         btnna.addActionListener(this);
      
         x = 400;
         y += 50;
         i=0;
      
         JButton btnpa = new JButton("\u0CAA");
         btnpa.setBounds(x+x1*i++,y,x1,y1);
         btnpa.setFont(f);
         btnpa.addActionListener(this);
         JButton btnpha = new JButton("\u0CAB");
         btnpha.setBounds(x+x1*i++,y,x1,y1);
         btnpha.setFont(f);
         btnpha.addActionListener(this);
         JButton btnba = new JButton("\u0CAC");
         btnba.setBounds(x+x1*i++,y,x1,y1);
         btnba.setFont(f);
         btnba.addActionListener(this);
         JButton btnbha = new JButton("\u0CAD");
         btnbha.setBounds(x+x1*i++,y,x1,y1);
         btnbha.setFont(f);
         btnbha.addActionListener(this);
         JButton btnma = new JButton("\u0CAE");
         btnma.setBounds(x+x1*i++,y,x1,y1);
         btnma.setFont(f);
         btnma.addActionListener(this);
      
         x = 200;
         y += 50;
         i=0;
      
         JButton btnya = new JButton("\u0CAF");
         btnya.setBounds(x+x1*i++,y,x1,y1);
         btnya.setFont(f);
         btnya.addActionListener(this);
         JButton btnra = new JButton("\u0CB0");
         btnra.setBounds(x+x1*i++,y,x1,y1);
         btnra.setFont(f);
         btnra.addActionListener(this);
         JButton btnla = new JButton("\u0CB2");
         btnla.setBounds(x+x1*i++,y,x1,y1);
         btnla.setFont(f);
         btnla.addActionListener(this);
         JButton btnva = new JButton("\u0CB5");
         btnva.setBounds(x+x1*i++,y,x1,y1);
         btnva.setFont(f);
         btnva.addActionListener(this);
         JButton btnsha = new JButton("\u0CB6");
         btnsha.setBounds(x+x1*i++,y,x1,y1);
         btnsha.setFont(f);
         btnsha.addActionListener(this);
         JButton btnssa = new JButton("\u0CB7");
         btnssa.setBounds(x+x1*i++,y,x1,y1);
         btnssa.setFont(f);
         btnssa.addActionListener(this);
         JButton btnsa = new JButton("\u0CB8");
         btnsa.setBounds(x+x1*i++,y,x1,y1);
         btnsa.setFont(f);
         btnsa.addActionListener(this);
         JButton btnha = new JButton("\u0CB9");
         btnha.setBounds(x+x1*i++,y,x1,y1);
         btnha.setFont(f);
         btnha.addActionListener(this);
         JButton btnlla = new JButton("\u0CB3");
         btnlla.setBounds(x+x1*i++,y,x1,y1);
         btnlla.setFont(f);
         btnlla.addActionListener(this);
         JButton btnksha = new JButton("\u0C95\u0CCD\u0CB7");
         btnksha.setBounds(x+x1*i++,y,x1,y1);
         btnksha.setFont(f);
         btnksha.addActionListener(this);
         JButton btntra = new JButton("\u0CA4\u0CCD\u0CB0");
         btntra.setBounds(x+x1*i++,y,x1,y1);
         btntra.setFont(f);
         btntra.addActionListener(this);
         JButton btnjna = new JButton("\u0C9C\u0CCD\u0C9E");
         btnjna.setBounds(x+x1*i++,y,x1,y1);
         btnjna.setFont(f);
         btnjna.addActionListener(this);
      
         x = 750;
         y = 225;
         i=0;
      
         JButton btnhal = new JButton("\u0CCD");
         btnhal.setBounds(x+x1*i++,y,x1,y1);
         btnhal.setFont(f);
         btnhal.addActionListener(this);
         JButton btnvaa = new JButton("\u0CBE");
         btnvaa.setBounds(x+x1*i++,y,x1,y1);
         btnvaa.setFont(f);
         btnvaa.addActionListener(this);	
         JButton btnvi = new JButton("\u0CBF");
         btnvi.setBounds(x+x1*i++,y,x1,y1);
         btnvi.setFont(f);
         btnvi.addActionListener(this);
         JButton btnvii = new JButton("\u0CC0");
         btnvii.setBounds(x+x1*i++,y,x1,y1);
         btnvii.setFont(f);
         btnvii.addActionListener(this);
      
         x = 750;
         y += 50;
         i=0;
      
         JButton btnvu = new JButton("\u0CC1");
         btnvu.setBounds(x+x1*i++,y,x1,y1);
         btnvu.setFont(f);
         btnvu.addActionListener(this);
         JButton btnvuu = new JButton("\u0CC2");
         btnvuu.setBounds(x+x1*i++,y,x1,y1);
         btnvuu.setFont(f);
         btnvuu.addActionListener(this);
         JButton btnvr = new JButton("\u0CC3");
         btnvr.setBounds(x+x1*i++,y,x1,y1);
         btnvr.setFont(f);
         btnvr.addActionListener(this);
         JButton btnvrr = new JButton("\u0CC4");
         btnvrr.setBounds(x+x1*i++,y,x1,y1);
         btnvrr.setFont(f);
         btnvrr.addActionListener(this);
      
         x = 750;
         y += 50;
         i=0;
      
         JButton btnve = new JButton("\u0CC6");
         btnve.setBounds(x+x1*i++,y,x1,y1);
         btnve.setFont(f);
         btnve.addActionListener(this);
         JButton btnvee = new JButton("\u0CC7");
         btnvee.setBounds(x+x1*i++,y,x1,y1);
         btnvee.setFont(f);
         btnvee.addActionListener(this);
         JButton btnvai = new JButton("\u0CC8");
         btnvai.setBounds(x+x1*i++,y,x1,y1);
         btnvai.setFont(f);
         btnvai.addActionListener(this);
         JButton btnvo = new JButton("\u0CCA");
         btnvo.setBounds(x+x1*i++,y,x1,y1);
         btnvo.setFont(f);
         btnvo.addActionListener(this);
      
         x = 750;
         y += 50;
         i=0;
      
         JButton btnvoo = new JButton("\u0CCB");
         btnvoo.setBounds(x+x1*i++,y,x1,y1);
         btnvoo.setFont(f);
         btnvoo.addActionListener(this);
         JButton btnvou = new JButton("\u0CCC");
         btnvou.setBounds(x+x1*i++,y,x1,y1);
         btnvou.setFont(f);
         btnvou.addActionListener(this);
         JButton btnvam = new JButton("\u0C82");
         btnvam.setBounds(x+x1*i++,y,x1,y1);
         btnvam.setFont(f);
         btnvam.addActionListener(this);
         JButton btnvaha = new JButton("\u0C83");
         btnvaha.setBounds(x+x1*i++,y,x1,y1);
         btnvaha.setFont(f);
         btnvaha.addActionListener(this);
      
         x = 160;
         y = 225;
         i=0;
      
         JButton btn1 = new JButton("\u0CE7");
         btn1.setBounds(x+x1*i++,y,x1,y1);
         btn1.setFont(f);
         btn1.addActionListener(this);
         JButton btn2 = new JButton("\u0CE8");
         btn2.setBounds(x+x1*i++,y,x1,y1);
         btn2.setFont(f);
         btn2.addActionListener(this);
         JButton btn3 = new JButton("\u0CE9");
         btn3.setBounds(x+x1*i++,y,x1,y1);
         btn3.setFont(f);
         btn3.addActionListener(this);
      
         x = 160;
         y += 50;
         i=0;
      
         JButton btn4 = new JButton("\u0CEA");
         btn4.setBounds(x+x1*i++,y,x1,y1);
         btn4.setFont(f);
         btn4.addActionListener(this);
         JButton btn5 = new JButton("\u0CEB");
         btn5.setBounds(x+x1*i++,y,x1,y1);
         btn5.setFont(f);
         btn5.addActionListener(this);
         JButton btn6 = new JButton("\u0CEC");
         btn6.setBounds(x+x1*i++,y,x1,y1);
         btn6.setFont(f);
         btn6.addActionListener(this);
      
         x = 160;
         y += 50;
         i=0;
      
         JButton btn7 = new JButton("\u0CED");
         btn7.setBounds(x+x1*i++,y,x1,y1);
         btn7.setFont(f);
         btn7.addActionListener(this);
         JButton btn8 = new JButton("\u0CEE");
         btn8.setBounds(x+x1*i++,y,x1,y1);
         btn8.setFont(f);
         btn8.addActionListener(this);
         JButton btn9 = new JButton("\u0CEF");
         btn9.setBounds(x+x1*i++,y,x1,y1);
         btn9.setFont(f);
         btn9.addActionListener(this);
      
         x = 220;
         y += 50;
      		
         JButton btn0 = new JButton("\u0CE6");
         btn0.setBounds(x,y,x1,y1);
         btn0.setFont(f);
         btn0.addActionListener(this);
      
         x = 1000;
         y = 200;
      		
         JButton btnBlank = new JButton("\u0C96\u0CBE\u0CB2\u0CBF");
         btnBlank.setBounds(x,y,90,y1);
         btnBlank.setFont(f);
         btnBlank.addActionListener(this);
      
         x = 1000;
         y = 250;
      
         JButton btnClear = new JButton("\u0C85\u0CB3\u0CBF\u0CB8\u0CC1");
         btnClear.setBounds(x,y,90,40);
         btnClear.setFont(f);
         btnClear.addActionListener(this);
      /*JButton btnBack = new JButton("\u0008");
      btnBack.setFont(f);
      btnBack.addActionListener(this);
      */
      	
         jfrm.add(btna);
         jfrm.add(btnaa);
         jfrm.add(btni);
         jfrm.add(btnii);
         jfrm.add(btnu);
         jfrm.add(btnuu);
         jfrm.add(btnr);
         jfrm.add(btnrr);
         jfrm.add(btne);
         jfrm.add(btnee);
         jfrm.add(btnai);
         jfrm.add(btno);
         jfrm.add(btnoo);
         jfrm.add(btnou);
         jfrm.add(btnam);
         jfrm.add(btnaha);
         jfrm.add(btnka);
         jfrm.add(btnkha);
         jfrm.add(btnga);
         jfrm.add(btngha);
         jfrm.add(btnnga);
         jfrm.add(btnca);
         jfrm.add(btncha);
         jfrm.add(btnja);
         jfrm.add(btnjha);
         jfrm.add(btnnya);
         jfrm.add(btntta);
         jfrm.add(btnttha);
         jfrm.add(btndda);
         jfrm.add(btnddha);
         jfrm.add(btnnna);
         jfrm.add(btnta);
         jfrm.add(btntha);
         jfrm.add(btnda);
         jfrm.add(btndha);
         jfrm.add(btnna);
         jfrm.add(btnha);
         jfrm.add(btnpa);
         jfrm.add(btnpha);
         jfrm.add(btnba);
         jfrm.add(btnbha);
         jfrm.add(btnma);
         jfrm.add(btnya);
         jfrm.add(btnra);
         jfrm.add(btnla);
         jfrm.add(btnva);
         jfrm.add(btnsha);
         jfrm.add(btnssa);
         jfrm.add(btnsa);
         jfrm.add(btnha);
         jfrm.add(btnlla);
         jfrm.add(btnksha);
         jfrm.add(btntra);
         jfrm.add(btnjna);
      
         jfrm.add(btnhal);
         jfrm.add(btnvaa);
         jfrm.add(btnvi);
         jfrm.add(btnvii);
         jfrm.add(btnvu);
         jfrm.add(btnvuu);
         jfrm.add(btnvr);
         jfrm.add(btnvrr);
         jfrm.add(btnve);
         jfrm.add(btnvee);
         jfrm.add(btnvai);
         jfrm.add(btnvo);
         jfrm.add(btnvoo);
         jfrm.add(btnvou);
         jfrm.add(btnvam);
         jfrm.add(btnvaha);
      
         jfrm.add(btn0);
         jfrm.add(btn1);
         jfrm.add(btn2);
         jfrm.add(btn3);
         jfrm.add(btn4);
         jfrm.add(btn5);
         jfrm.add(btn6);
         jfrm.add(btn7);
         jfrm.add(btn8);
         jfrm.add(btn9);
         jfrm.add(btnBlank);
         jfrm.add(btnClear);
   
		}
      	
   	
   	// required by the JList component..
      public void valueChanged(ListSelectionEvent e)
      {
         System.out.println("inside valueChanged()");
         if (e.getValueIsAdjusting() == false)
         {
         
            if(language.equals("Kannada"))
            {
               if(list1.getSelectedIndex() <= -1)
               {
                  System.out.println("unknown or no item selected..");
                  return;
               }
            }
            else if(language.equals("Telugu"))
            {
               if(list2.getSelectedIndex() <= -1)
               {
                  System.out.println("unknown or no item selected..");
                  return;
               }
            }
            else if(language.equals("Telugu"))
            {
               if(list2.getSelectedIndex() <= -1)
               {
                  System.out.println("unknown or no item selected..");
                  return;
               }
            }
            
            SwingUtilities.invokeLater(
                  new Runnable()
                  {
                     public void run()
                     {
                        textBox1.setText("");
                        
                     }
                  });
            SwingUtilities.invokeLater(
                  new Runnable()
                  {
                     public void run()
                     {
                        if(language.equals("Kannada"))
                        {
                           textBox1.setText(RecommendedStr[1][list1.getSelectedIndex() + 1]);	
                           // "+1" Because 1st match is not added to the list, same as text box..
                           repaint();
                        }
                        else if(language.equals("Telugu"))
                        {
                           textBox2.setText(RecommendedStr[1][list2.getSelectedIndex() + 1]);	
                           // "+1" Because 1st match is not added to the list, same as text box..
                           repaint();
                        }
                        else if(language.equals("Malayalam"))
                        {
                           textBox3.setText(RecommendedStr[1][list3.getSelectedIndex() + 1]);	
                           // "+1" Because 1st match is not added to the list, same as text box..
                           repaint();
                        }
                     }
                  });
         }
      }
   	
      public void processRecommendationKannada()
      {
         System.out.println("Inside processRecommendationKannada()..");
         String str1 = textBox1.getText();	//get the kannada string..
         System.out.println("str1===>" + str1 + "<===");
         char chr1 = str1.charAt(str1.length() - 1);	// minus two because there will be a space at the end of the string.. 
      																// therefore ignore space and consider last but one char..
      	
         RecommendKannada recommendObj = new RecommendKannada();
      	
         char incompleteChar = '\u0CCD';
      	
         if(chr1 == incompleteChar)
            chr1 = str1.charAt(str1.length() - 2);
      	
         String str2[] = recommendObj.process("" + chr1);
         if(str2 == null)
         {
            System.out.println("str2 is null.. guess no match found..");
            return;
         }
      	
         ConvertToKannada obj1 = new ConvertToKannada();
      	
         String str3 = obj1.kannadaToEnglish(str1);	// get english text..
         String str4[];
         str4 = new String[str2.length];
         int m = 0;
      	
         RecommendedStr = new String[2][];
         RecommendedStr[0] = new String[str2.length];	// Recommended English string..
         RecommendedStr[1] = new String[str2.length];	// Recommended Other language string..
      	
         for(String str : str2)
         {
            System.out.println("chr1===>" + chr1 + "<===" + "str2===>" + str + "<===" + "length = " + str.length());
            
            if((chr1 <= '\u0C94' ) && (chr1 >= '\u0C85'))
            {
            	/*if(str3.charAt(str3.length() - 1) == 'a')
                  str4[m] = str3.substring(0, str3.length() - str2[0].length() - 1) + str + "a";	// here "- 1" BCOZ "a" will be ignored while converting to kannada text..
               else*/
               str4[m] = str3.substring(0, str3.length() - str2[0].length()) + str;
            }
            else
            {
               if(str3.charAt(str3.length() - 1) == 'a')
                  str4[m] = str3.substring(0, str3.length() - str2[0].length() - 1) + str + "a";	// here "- 1" BCOZ "a" will be ignored while converting to kannada text..
               else
                  str4[m] = str3.substring(0, str3.length() - str2[0].length()) + str;
            }
            RecommendedStr[0][m] = str4[m];
            RecommendedStr[1][m] = temporaryConvertToKannada(str4[m]);
            System.out.println("tempStr = " + str4[m]);
            m++;
         }
         
      	//DefaultListModel listModel1 = list.getModel();
         listModel1.clear();
         int i = 0;
         for(i = 1; i < RecommendedStr[1].length; i++)
         {
            String tempStr = RecommendedStr[1][i];
            listModel1.addElement(tempStr);
         }
      	
         repaint();
      }
   	
      public String temporaryConvertToKannada(String queryLine)
      {
         System.out.println("====================temporaryConvertToKannada()====================");
      	//String queryLine;
         String queryStr;
         String tempStr;
         String finalKannadaStr;
      	
         int oldIndex;
         int index;
      	
      	//queryLine = textBox1.getText();
      	
         System.out.println("new queryLine===>" + queryLine + "<===   length : " + queryLine.length());
      	
         if(queryLine.equals(""))	// clear both textBoxes if queryLine is empty..
         {
         	//textBox2.setText("");
            System.out.println("queryLine is empty..");
            return "";
         }
      	
         index = queryLine.indexOf(' ');
      	
         if(index < 0)
            index = queryLine.length();
         else if(index >= queryLine.length())
            index = queryLine.length() - 1;
      	
         System.out.println("index of space is : " + index);
      	
         queryStr = queryLine.substring(0, index);	// first query string
         System.out.println("queryStr ===>" + queryStr + "<===   length : " + queryStr.length());
      	
         finalKannadaStr = "";
      	//textBox2.setText("");	// clear textBox2 before writing new text into it..
      	
         try
         {
            while(queryLine.length() >= 0)
            {
            	//tempStr = textBox2.getText();	// get existing text..
               tempStr = finalKannadaStr;
            	
            	// convert to char array
               char queryChr[] = new char[queryStr.length()];
               queryStr.getChars(0, queryStr.length(), queryChr, 0);
               
               // Create new object and call process method..
               ConvertToKannada obj1 = new ConvertToKannada(queryChr, queryStr.length());
            	
            	
            	//textBox2.setText(tempStr + obj1.process());	//append newly converted text with existing text..
               if(tempStr.equals(""))
                  finalKannadaStr = tempStr + obj1.process();
               else
                  finalKannadaStr = tempStr + " " + obj1.process();						
            	
               queryLine = queryLine.substring(index + 1, queryLine.length()); // text after the space, till end of string
            	
               System.out.println("new queryLine===>" + queryLine + "<===   length : " + queryLine.length());
            	
               oldIndex = index; // position of old space
               index = queryLine.indexOf(' ');	//get new index position
            
               if(index < 0)
                  index = queryLine.length();
               else if(index >= queryLine.length())
                  index = queryLine.length() - 1;
            		
               System.out.println("oldIndex of space is : " + oldIndex);
               System.out.println("index of space is : " + index);
            
               queryStr = queryLine.substring(0, index);	// next query string
            	
               System.out.println("queryStr ===>" + queryStr + "<===   length : " + queryStr.length());
            } // end while
         } // end try
            catch(StringIndexOutOfBoundsException e)
            {
               System.out.println(e);
            }
      	
         return finalKannadaStr;
      }
      	
   	
      public void processRecommendationTelugu()
      {
         System.out.println("Inside processRecommendationTelugu()..");
         String str1 = textBox2.getText();	//get the telugu string..
         System.out.println("str1===>" + str1 + "<===");
         char chr1 = str1.charAt(str1.length() - 1);	// minus two because there will be a space at the end of the string.. 
      																// therefore ignore space and consider last but one char..
      	
         RecommendTelugu recommendObj = new RecommendTelugu();
      	
         char incompleteChar = '\u0C4D';
      	
         if(chr1 == incompleteChar)
            chr1 = str1.charAt(str1.length() - 2);
      	
         System.out.println("chr1===>" + chr1 + "<===");
      	
         String str2[] = recommendObj.process("" + chr1);
         if(str2 == null)
         {
            System.out.println("str2 is null.. guess no match found..");
            return;
         }
      	
         ConvertToTelugu obj1 = new ConvertToTelugu();
      	
         String str3 = obj1.teluguToEnglish(str1);	// get english text..
         String str4[];
         str4 = new String[str2.length];
         int m = 0;
      	
         RecommendedStr = new String[2][];
         RecommendedStr[0] = new String[str2.length];	// Recommended English string..
         RecommendedStr[1] = new String[str2.length];	// Recommended Other language string..
      	
         for(String str : str2)
         {
            System.out.println("chr1===>" + chr1 + "<===" + "str2===>" + str + "<===" + "length = " + str.length());
            
            if((chr1 <= '\u0C14' ) && (chr1 >= '\u0C05'))
            {
            	/*if(str3.charAt(str3.length() - 1) == 'a')
                  str4[m] = str3.substring(0, str3.length() - str2[0].length() - 1) + str + "a";	// here "- 1" BCOZ "a" will be ignored while converting to kannada text..
               else*/
               str4[m] = str3.substring(0, str3.length() - str2[0].length()) + str;
            }
            else
            {
               if(str3.charAt(str3.length() - 1) == 'a')
                  str4[m] = str3.substring(0, str3.length() - str2[0].length() - 1) + str + "a";	// here "- 1" BCOZ "a" will be ignored while converting to kannada text..
               else
                  str4[m] = str3.substring(0, str3.length() - str2[0].length()) + str;
            }
            RecommendedStr[0][m] = str4[m];
            RecommendedStr[1][m] = temporaryConvertToTelugu(str4[m]);
            System.out.println("tempStr = " + str4[m]);
            m++;
         }
         
      	//DefaultListModel listModel1 = list.getModel();
         listModel2.clear();
         int i = 0;
         for(i = 1; i < RecommendedStr[1].length; i++)
         {
            String tempStr = RecommendedStr[1][i];
            listModel2.addElement(tempStr);
         }
      	
         repaint();
      }
   	
      public String temporaryConvertToTelugu(String queryLine)
      {
         System.out.println("====================temporaryConvertToTelugu()====================");
      	//String queryLine;
         String queryStr;
         String tempStr;
         String finalTeluguStr;
      	
         int oldIndex;
         int index;
      	
      	//queryLine = textBox1.getText();
      	
         System.out.println("new queryLine===>" + queryLine + "<===   length : " + queryLine.length());
      	
         if(queryLine.equals(""))	// clear both textBoxes if queryLine is empty..
         {
         	//textBox2.setText("");
            System.out.println("queryLine is empty..");
            return "";
         }
      	
         index = queryLine.indexOf(' ');
      	
         if(index < 0)
            index = queryLine.length();
         else if(index >= queryLine.length())
            index = queryLine.length() - 1;
      	
         System.out.println("index of space is : " + index);
      	
         queryStr = queryLine.substring(0, index);	// first query string
         System.out.println("queryStr ===>" + queryStr + "<===   length : " + queryStr.length());
      	
         finalTeluguStr = "";
      	//textBox2.setText("");	// clear textBox2 before writing new text into it..
      	
         try
         {
            while(queryLine.length() >= 0)
            {
            	//tempStr = textBox2.getText();	// get existing text..
               tempStr = finalTeluguStr;
            	
            	// convert to char array
               char queryChr[] = new char[queryStr.length()];
               queryStr.getChars(0, queryStr.length(), queryChr, 0);
               
               // Create new object and call process method..
               ConvertToTelugu obj1 = new ConvertToTelugu(queryChr, queryStr.length());
            	
            	
            	//textBox2.setText(tempStr + obj1.process());	//append newly converted text with existing text..
               if(tempStr.equals(""))
                  finalTeluguStr = tempStr + obj1.process();
               else
                  finalTeluguStr = tempStr + " " + obj1.process();						
            	
               queryLine = queryLine.substring(index + 1, queryLine.length()); // text after the space, till end of string
            	
               System.out.println("new queryLine===>" + queryLine + "<===   length : " + queryLine.length());
            	
               oldIndex = index; // position of old space
               index = queryLine.indexOf(' ');	//get new index position
            
               if(index < 0)
                  index = queryLine.length();
               else if(index >= queryLine.length())
                  index = queryLine.length() - 1;
            		
               System.out.println("oldIndex of space is : " + oldIndex);
               System.out.println("index of space is : " + index);
            
               queryStr = queryLine.substring(0, index);	// next query string
            	
               System.out.println("queryStr ===>" + queryStr + "<===   length : " + queryStr.length());
            } // end while
         } // end try
            catch(StringIndexOutOfBoundsException e)
            {
               System.out.println(e);
            }
         return finalTeluguStr;
      }
   	   	
      public void processRecommendationMalayalam()
      {
         System.out.println("Inside processRecommendationMalayalam()..");
         String str1 = textBox3.getText();	//get the malayalam string..
         System.out.println("str1===>" + str1 + "<===");
         char chr1 = str1.charAt(str1.length() - 1);	// minus two because there will be a space at the end of the string.. 
      																// therefore ignore space and consider last but one char..
      	
         RecommendMalayalam recommendObj = new RecommendMalayalam();
      	
         char incompleteChar = '\u0D4D';
      	
         if(chr1 == incompleteChar)
            chr1 = str1.charAt(str1.length() - 2);
      	
         String str2[] = recommendObj.process("" + chr1);
         if(str2 == null)
         {
            System.out.println("str2 is null.. guess no match found..");
            return;
         }
         ConvertToMalayalam obj1 = new ConvertToMalayalam();
      	
         String str3 = obj1.malayalamToEnglish(str1);	// get english text..
         String str4[];
         str4 = new String[str2.length];
         int m = 0;
      	
         RecommendedStr = new String[2][];
         RecommendedStr[0] = new String[str2.length];	// Recommended English string..
         RecommendedStr[1] = new String[str2.length];	// Recommended Other language string..
      	
         for(String str : str2)
         {
            System.out.println("chr1===>" + chr1 + "<===" + "str2===>" + str + "<===" + "length = " + str.length());
            
            if((chr1 <= '\u0D14' ) && (chr1 >= '\u0D05'))
            {
            	/*if(str3.charAt(str3.length() - 1) == 'a')
                  str4[m] = str3.substring(0, str3.length() - str2[0].length() - 1) + str + "a";	// here "- 1" BCOZ "a" will be ignored while converting to kannada text..
               else*/
               str4[m] = str3.substring(0, str3.length() - str2[0].length()) + str;
            }
            else
            {
               if(str3.charAt(str3.length() - 1) == 'a')
                  str4[m] = str3.substring(0, str3.length() - str2[0].length() - 1) + str + "a";	// here "- 1" BCOZ "a" will be ignored while converting to kannada text..
               else
                  str4[m] = str3.substring(0, str3.length() - str2[0].length()) + str;
            }
            RecommendedStr[0][m] = str4[m];
            RecommendedStr[1][m] = temporaryConvertToMalayalam(str4[m]);
            System.out.println("tempStr = " + str4[m]);
            m++;
         }
         
      	//DefaultListModel listModel1 = list.getModel();
         listModel3.clear();
         int i = 0;
         for(i = 1; i < RecommendedStr[1].length; i++)
         {
            String tempStr = RecommendedStr[1][i];
            listModel3.addElement(tempStr);
         }
      	
         repaint();
      }
   	
      public String temporaryConvertToMalayalam(String queryLine)
      {
         System.out.println("====================temporaryConvertToMalayalam()====================");
      	//String queryLine;
         String queryStr;
         String tempStr;
         String finalMalayalamStr;
      	
         int oldIndex;
         int index;
      	
      	//queryLine = textBox1.getText();
      	
         System.out.println("new queryLine===>" + queryLine + "<===   length : " + queryLine.length());
      	
         if(queryLine.equals(""))	// clear both textBoxes if queryLine is empty..
         {
         	//textBox2.setText("");
            System.out.println("queryLine is empty..");
            return "";
         }
      	
         index = queryLine.indexOf(' ');
      	
         if(index < 0)
            index = queryLine.length();
         else if(index >= queryLine.length())
            index = queryLine.length() - 1;
      	
         System.out.println("index of space is : " + index);
      	
         queryStr = queryLine.substring(0, index);	// first query string
         System.out.println("queryStr ===>" + queryStr + "<===   length : " + queryStr.length());
      	
         finalMalayalamStr = "";
      	//textBox2.setText("");	// clear textBox2 before writing new text into it..
      	
         try
         {
            while(queryLine.length() >= 0)
            {
            	//tempStr = textBox2.getText();	// get existing text..
               tempStr = finalMalayalamStr;
            	
            	// convert to char array
               char queryChr[] = new char[queryStr.length()];
               queryStr.getChars(0, queryStr.length(), queryChr, 0);
               
               // Create new object and call process method..
               ConvertToMalayalam obj1 = new ConvertToMalayalam(queryChr, queryStr.length());
            	
            	
            	//textBox2.setText(tempStr + obj1.process());	//append newly converted text with existing text..
               if(tempStr.equals(""))
                  finalMalayalamStr = tempStr + obj1.process();
               else
                  finalMalayalamStr = tempStr + " " + obj1.process();						
            	
               queryLine = queryLine.substring(index + 1, queryLine.length()); // text after the space, till end of string
            	
               System.out.println("new queryLine===>" + queryLine + "<===   length : " + queryLine.length());
            	
               oldIndex = index; // position of old space
               index = queryLine.indexOf(' ');	//get new index position
            
               if(index < 0)
                  index = queryLine.length();
               else if(index >= queryLine.length())
                  index = queryLine.length() - 1;
            		
               System.out.println("oldIndex of space is : " + oldIndex);
               System.out.println("index of space is : " + index);
            
               queryStr = queryLine.substring(0, index);	// next query string
            	
               System.out.println("queryStr ===>" + queryStr + "<===   length : " + queryStr.length());
            } // end while
         } // end try
            catch(StringIndexOutOfBoundsException e)
            {
               System.out.println(e);
            }
         return finalMalayalamStr;
      }
   }
