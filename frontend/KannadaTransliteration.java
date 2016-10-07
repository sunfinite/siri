  //Kannada Keyboard
  
   import java.awt.event.*;
   import java.awt.*;
   import javax.swing.*;
	
	/*
<applet code="KannadaTransliteration" width="1000" height="145" alt="Applet Not Loaded"></applet>
*/

    public class KannadaTransliteration extends JApplet implements ActionListener,KeyListener
   {
   	boolean vowFlag = false,space = false;
	   JTextField txt;
      Font f = new Font("Tunga", Font.BOLD, 20);
		
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

   
       public void  makeGUI()
      {
         //JFrame jfrm = new JFrame("\u0C95\u0CC0\u0CB2\u0CBF\u0CAE\u0CA3\u0CC6");
			Container jfrm;
			jfrm = getContentPane();
         jfrm.setLayout( new GridLayout( 200, 20 ) );
         jfrm.setLayout(null);
         jfrm.setBackground(new Color(144, 238, 144));
         //jfrm.setFont(f);
         //jfrm.setLayout(null);
         //jfrm.setSize(1250,500);
         //jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         txt = new JTextField(70);
         txt.setBounds(100,40,960,40);
         jfrm.add(txt);
         txt.setText("");		
         txt.setFont(f);
         int x = 100,y = 100,x1 = 60,y1 = 40,i=0;
               
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
         y = 175;
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
         y = 175;
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
      //jfrm.add(btnBack);
      				
         jfrm.setVisible(true);
      }
		
		public void keyTyped(KeyEvent e)
		{
		}
		public void keyPressed(KeyEvent e)
		{
		}
		public void keyReleased(KeyEvent e)
		{
		}
   
       public void actionPerformed(ActionEvent ae)
      {
			String str = ae.getActionCommand();
			
			System.out.println(vowFlag);	
				
         if(str.equals("\u0C85\u0CB3\u0CBF\u0CB8\u0CC1"))
         {
            txt.setText("");
            vowFlag = false;
         }
			else if(str.equals("\u0C82") || str.equals("\u0C83"))
			{
				if(vowFlag == true || space == true)
					txt.setText(txt.getText() + str);
				vowFlag = false;
			}
			
			else if(((str.compareTo("\u0C85") >= 0) && (str.compareTo("\u0C94") <= 0)))		//For numbers
			{
				txt.setText(txt.getText() + str);
				vowFlag = false;
			}	
			else if(((str.compareTo("\u0CE6") >= 0) && (str.compareTo("\u0CEF") <= 0)))		//For numbers
			{
				txt.setText(txt.getText() + str);
				vowFlag = false;
				space = true;
			}	
         else if((vowFlag == false) && (!((str.compareTo("\u0CBE") >= 0) && (str.compareTo("\u0CDE") <= 0))))	
         {
            if(!str.equals("\u0C96\u0CBE\u0CB2\u0CBF"))
     			{
				   txt.setText(txt.getText() + str);
					vowFlag = true;
				}	
            else 
				{
				 	if(space == true)
				   {
					 	txt.setText(txt.getText() + " ");
						space = false;
					}	
					 vowFlag = false;
				}	 
         }	
			else if((vowFlag == true))
			{
				if(!str.equals("\u0C96\u0CBE\u0CB2\u0CBF"))
				   txt.setText(txt.getText() + str);
            else 
				{
				    txt.setText(txt.getText() + " ");
					 vowFlag = false;
				}	 
				if(((str.compareTo("\u0CBE") >= 0) && (str.compareTo("\u0CDE") <= 0)))		 
				{
					vowFlag = false;		 
					space = true;
				}	
			}
		}
   
  /*     public static void main(String args[])
      {
         SwingUtilities.invokeLater(
                new Runnable()
               {
                   public void run()
                  {
                     new KannadaTransliteration();
                  }
               });
      
      }*/
   }