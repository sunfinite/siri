   public class ConvertToTelugu
   {
      char chr[];
      char finalChr[];
      boolean flag1 = true;
		boolean flag2 = true;// incomplete letter flag
   
      String Digits[];
      String IndependentVowel[];
      String DependentVowel[];
      String Consonants[];
   
      char kDigits[];
      char kIndependentVowel[];
      char kDependentVowel[];
      char kConsonants[];
		
		char incompleteChar;
   
	
		public ConvertToTelugu()
		{
			initialize();
		}
      public ConvertToTelugu(char chr1[], int len)
      {
         int i = 0;
         chr = new char[len];
         finalChr = new char[2 * len];
      
         initialize();
      
         for(char x : chr1)
         {
            chr[i] = x;
            i++;
         }
      }
   
      public void initialize()
      {
			
			incompleteChar = '\u0C4D';
			
         Digits = new String[10];
         Digits[0] = "0"; // 0
         Digits[1] = "1"; // 1
         Digits[2] = "2"; // 2
         Digits[3] = "3"; // 3
         Digits[4] = "4"; // 4
         Digits[5] = "5"; // 5
         Digits[6] = "6"; // 6
         Digits[7] = "7"; // 7
         Digits[8] = "8"; // 8
         Digits[9] = "9"; // 9
      		
      
      
         IndependentVowel = new String[14];
         IndependentVowel[0] = "a"; // A
         IndependentVowel[1] = "aa"; // AA
         IndependentVowel[2] = "i"; // I
         IndependentVowel[3] = "ii"; // II
         IndependentVowel[4] = "u"; // U
         IndependentVowel[5] = "uu"; // UU
         IndependentVowel[6] = "r"; // vocabulary R
         IndependentVowel[7] = "l"; // vocabulary L
         IndependentVowel[8] = "e"; // E
         IndependentVowel[9] = "ee"; // EE
         IndependentVowel[10] = "ai"; // AI
         IndependentVowel[11] = "o"; // O
         IndependentVowel[12] = "oo"; // 00
         IndependentVowel[13] = "au"; // AU
      
      
      
         DependentVowel = new String[16];
         DependentVowel[0] = "a"; // A
         DependentVowel[1] = "aa"; // AA
         DependentVowel[2] = "i"; // I
         DependentVowel[3] = "ii"; // II
         DependentVowel[4] = "u"; // U
         DependentVowel[5] = "uu"; // UU
         DependentVowel[6] = "r"; // vocabulary R
         DependentVowel[7] = "rr"; // vocabulary RR
         DependentVowel[8] = "e"; // E
         DependentVowel[9] = "ee"; // EE
         DependentVowel[10] = "ai"; // AI
         DependentVowel[11] = "o"; // O
         DependentVowel[12] = "oo"; // 00
         DependentVowel[13] = "au"; // AU
			DependentVowel[14] = "am"; // AM
			//DependentVowel[15] = "an"; // AM
			DependentVowel[15] = "aha"; // AHA
      
      
         Consonants = new String[35];
         Consonants[0] = "k"; // KA
         Consonants[1] = "kh"; // KHA
         Consonants[2] = "g"; // GA
         Consonants[3] = "gh"; // GHA
         Consonants[4] = "ng"; // NGA
         Consonants[5] = "c"; // CA
         Consonants[6] = "ch"; // CHA
         Consonants[7] = "j"; // JA
         Consonants[8] = "jh"; // JHA
         Consonants[9] = "ny"; // NYA
         Consonants[10] = "ttt"; // TTA
         Consonants[11] = "tth"; // TTHA
         Consonants[12] = "dd"; // DDA
         Consonants[13] = "ddh"; // DDHA
         Consonants[14] = "nnn"; // NNNA
         Consonants[15] = "t"; // TA
         Consonants[16] = "th"; // THA
         Consonants[17] = "d"; // DA
         Consonants[18] = "dh"; // DHA
         Consonants[19] = "n"; // NA
         Consonants[20] = "p"; // PA
         Consonants[21] = "ph"; // PHA
         Consonants[22] = "b"; // BA
         Consonants[23] = "bh"; // BHA
         Consonants[24] = "m"; // MA
         Consonants[25] = "y"; // YA
         Consonants[26] = "r"; // RA
         Consonants[27] = "rr"; // RRA
         Consonants[28] = "l"; // LA
         Consonants[29] = "ll"; // LLA
         Consonants[30] = "v"; // VA
         Consonants[31] = "sh"; // SHA
         Consonants[32] = "ss"; // SSA
         Consonants[33] = "s"; // SA
         Consonants[34] = "h"; // HA
      		
      
         kDigits = new char[10];
         kDigits[0] = '\u0C66'; // 0
         kDigits[1] = '\u0C67'; // 1
         kDigits[2] = '\u0C68'; // 2
         kDigits[3] = '\u0C69'; // 3
         kDigits[4] = '\u0C6A'; // 4
         kDigits[5] = '\u0C6B'; // 5
         kDigits[6] = '\u0C6C'; // 6
         kDigits[7] = '\u0C6D'; // 7
         kDigits[8] = '\u0C6E'; // 8
         kDigits[9] = '\u0C6F'; // 9
      
      		
      
         kIndependentVowel = new char[14];
         kIndependentVowel[0] = '\u0C05'; // A
         kIndependentVowel[1] = '\u0C06'; // AA
         kIndependentVowel[2] = '\u0C07'; // I
         kIndependentVowel[3] = '\u0C08'; // II
         kIndependentVowel[4] = '\u0C09'; // U
         kIndependentVowel[5] = '\u0C0A'; // UU
         kIndependentVowel[6] = '\u0C0B'; // vocabulary R
         kIndependentVowel[7] = '\u0C0C'; // vocabulary L
         kIndependentVowel[8] = '\u0C0E'; // E
         kIndependentVowel[9] = '\u0C0F'; // EE
         kIndependentVowel[10] ='\u0C10'; // AI
         kIndependentVowel[11] ='\u0C12'; // O
         kIndependentVowel[12] ='\u0C13'; // 00
         kIndependentVowel[13] ='\u0C14'; // AU
      
      
         kDependentVowel = new char[16];
         //kDependentVowel[0] =
         kDependentVowel[1] = '\u0C3E'; // AA
         kDependentVowel[2] = '\u0C3F'; // I
         kDependentVowel[3] = '\u0C40'; // II
         kDependentVowel[4] = '\u0C41'; // U
         kDependentVowel[5] = '\u0C42'; // UU
         kDependentVowel[6] = '\u0C43'; // vocabulary R
         kDependentVowel[7] = '\u0C44'; // vocabulary RR
         kDependentVowel[8] = '\u0C46'; // E
         kDependentVowel[9] = '\u0C47'; // EE
         kDependentVowel[10] = '\u0C48'; // AI
         kDependentVowel[11] = '\u0C4A'; // O
         kDependentVowel[12] = '\u0C4B'; // 00
         kDependentVowel[13] = '\u0C4C'; // AU
			kDependentVowel[14] = '\u0C02'; // AM
			//kDependentVowel[15] = '\u0C02'; // AN
			kDependentVowel[15] = '\u0C03'; // AHA         
      	
         kConsonants = new char[35];
         kConsonants[0] = '\u0C15'; // KA
         kConsonants[1] = '\u0C16'; // KHA
         kConsonants[2] = '\u0C17'; // GA
         kConsonants[3] = '\u0C18'; // GHA
         kConsonants[4] = '\u0C19'; // NGA
         kConsonants[5] = '\u0C1A'; // CA
         kConsonants[6] = '\u0C1B'; // CHA
         kConsonants[7] = '\u0C1C'; // JA
         kConsonants[8] = '\u0C1D'; // JHA
         kConsonants[9] = '\u0C1E'; // NYA
         kConsonants[10] = '\u0C1F'; // TTA
         kConsonants[11] = '\u0C20'; // TTHA
         kConsonants[12] = '\u0C21'; // DDA
         kConsonants[13] = '\u0C22'; // DDHA
         kConsonants[14] = '\u0C23'; // NNA
         kConsonants[15] = '\u0C24'; // TA
         kConsonants[16] = '\u0C25'; // THA
         kConsonants[17] = '\u0C26'; // DA
         kConsonants[18] = '\u0C27'; // DHA
         kConsonants[19] = '\u0C28'; // NA
         kConsonants[20] = '\u0C2A'; // PA
         kConsonants[21] = '\u0C2B'; // PHA
         kConsonants[22] = '\u0C2C'; // BA
         kConsonants[23] = '\u0C2D'; // BHA
         kConsonants[24] = '\u0C2E'; // MA
         kConsonants[25] = '\u0C2F'; // YA
         kConsonants[26] = '\u0C30'; // RA
         kConsonants[27] = '\u0C31'; // RRA
         kConsonants[28] = '\u0C32'; // LA
         kConsonants[29] = '\u0C33'; // LLA
         kConsonants[30] = '\u0C35'; // VA
         kConsonants[31] = '\u0C36'; // SHA
         kConsonants[32] = '\u0C37'; // SSA
         kConsonants[33] = '\u0C38'; // SA
         kConsonants[34] = '\u0C39'; // HA
      }
   
   
      public String process()
      {
         int i = 0; // index of chr
         int j = 0; // index of finalChr
         flag1 = true;
      
         String str;
      	
         while(flag1)
         {
            flag2 = true;
         outer:
            {
               if(i >= chr.length)
               {
                  flag1 = false;
                  break;
               }
            
            inner1:// case1 : three char..
               {
                  try
                  {
                     System.out.println("Trying for 3 chars : " + chr[i] + chr[i+1] + chr[i+2]);
                     str = "" + chr[i] + chr[i+1] + chr[i+2];
                     for(int k = 0; k < Digits.length; k++)
                     {
                        if(str.equals(Digits[k]))
                        {
                           finalChr[j] = kDigits[k];
                           i = i + 3;
                           j++;
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }
                     for(int k = 0; k < Consonants.length; k++)
                     {
                        if(str.equals(Consonants[k]))
                        {
                           finalChr[j] = kConsonants[k];
                           j++;
                        	inner11://Combine inner111, inner112 and inner113..
                           {
                           	inner111://try for three char match of DependentVowels..
                              {
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 3] + chr[i + 4] + chr[i+5];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i = i + 3;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }                                 	
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner111, inner11 : " + e);
                                       break inner111;
                                    }
                              }//inner111
                           	inner112://try for two char match of DependentVowels..
                              {
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 3] + chr[i + 4];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i = i + 2;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner112, inner11 : " + e);
                                       break inner112;
                                    }
                              }//inner112
                           	inner113://try for two char match of DependentVowels..
                              {	
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 3];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(tempStr1.equals("" + 'a'))
                                       {
                                          i++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                       else if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i++;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }// end for                                	
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner113, inner11 : " + e);
                                       break inner113;
                                    }
                              }//inner113
                           }//inner11
                           i = i + 3;
                           if(flag2)
                           {
                              finalChr[j] = incompleteChar;
										System.out.println("Incomplete Character added..");
                              j++;
                           }
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }//end for
                     for(int k = 0; k < IndependentVowel.length; k++)
                     {
                        if(str.equals(IndependentVowel[k]))
                        {
                           finalChr[j] = kIndependentVowel[k];
                           i = i + 3;
                           j++;
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }//end for
                  }//end try
                      catch(ArrayIndexOutOfBoundsException e)
                     {
                        System.out.println("from inner1 : " + e);
                     //flag1 = false;
                        break inner1;
                     }
               }	//inner 1
            
            inner2:
               {	
               // case2 : two char..
                  try
                  {
                     System.out.println("Trying for 2 chars : " + chr[i] + chr[i+1]);
                     str = "" + chr[i] + chr[i+1];
                     for(int k = 0; k < Digits.length; k++)
                     {
                        if(str.equals(Digits[k]))
                        {
                           finalChr[j] = kDigits[k];
                           i = i + 2;
                           j++;
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }
                     for(int k = 0; k < Consonants.length; k++)
                     {
                        if(str.equals(Consonants[k]))
                        {
                           finalChr[j] = kConsonants[k];
                           j++;
                        	inner11://Combine inner111, inner112 and inner113..
                           {
                           	inner111://try for three char match of DependentVowels..
                              {
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 2] + chr[i + 3] + chr[i + 4];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i = i + 3;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }                                 	
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner111, inner11 : " + e);
                                       break inner111;
                                    }
                              }//inner111
                           	inner112://try for two char match of DependentVowels..
                              {
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 2] + chr[i + 3];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i = i + 2;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }                                 	
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner112, inner11 : " + e);
                                       break inner112;
                                    }
                              }//inner112
                           	inner113://try for one char match of DependentVowels..
                              {	
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 2];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(tempStr1.equals("" + 'a'))
                                       {
                                          i++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                       else if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i++;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }// end for                                 	
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner113, inner11 : " + e);
                                       break inner113;
                                    }
                              }//inner112
                           }//inner11
                           i = i + 2;
                           if(flag2)
                           {
                              finalChr[j] = incompleteChar;
										System.out.println("Incomplete Character added..");
                              j++;
                           }
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }//end for
                     for(int k = 0; k < IndependentVowel.length; k++)
                     {
                        if(str.equals(IndependentVowel[k]))
                        {
                           finalChr[j] = kIndependentVowel[k];
                           i = i +2;
                           j++;
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }//end for
                  
                  }//end try
                  
                      catch(ArrayIndexOutOfBoundsException e)
                     {
                        System.out.println("from inner2 : " + e);
                     //flag1 = false;
                        break inner2;
                     }
               }  // inner2
            
            inner3:
               {
               
               // case3 : one char..
                  try
                  {
                     System.out.println("Trying for 1 chars : " + chr[i]);
                     str = "" + chr[i];
                     for(int k = 0; k < Digits.length; k++)
                     {
                        if(str.equals(Digits[k]))
                        {
                           finalChr[j] = kDigits[k];
                           i++;
                           j++;
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }
                     for(int k = 0; k < Consonants.length; k++)
                     {
                        if(str.equals(Consonants[k]))
                        {
                           finalChr[j] = kConsonants[k];
                           j++;
                        	inner11://Combine inner111 and inner112..
                           {
                           	inner111://try for three char match of DependentVowels..
                              {
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 1] + chr[i + 2] + chr[i + 3];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i = i + 3;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner111, inner11 : " + e);
                                       break inner111;
                                    }
                              }//inner111
                           	inner112://try for two char match of DependentVowels..
                              {
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 1] + chr[i + 2];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i = i + 2;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    }
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner112, inner11 : " + e);
                                       break inner112;
                                    }
                              }//inner112
                           	inner113://try for two char match of DependentVowels..
                              {	
                                 try
                                 {
                                    String tempStr1 = "" + chr[i + 1];
                                    for(int l = 0; l < DependentVowel.length; l++)
                                    {
                                       if(tempStr1.equals("" + 'a'))
                                       {
                                          i++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                       else if(DependentVowel[l].equals(tempStr1))
                                       {
                                          finalChr[j] = kDependentVowel[l];
                                          i++;
                                          j++;
                                          flag2 = false;
                                          break inner11;
                                       }
                                    } // end for                                 	
                                 }
                                     catch(ArrayIndexOutOfBoundsException e)
                                    {
                                       System.out.println("from inner113, inner11 : " + e);
                                       break inner113;
                                    }
                              }//inner112
                           }//inner11
                           i = i + 1;
                           if(flag2)
                           {
                              finalChr[j] = incompleteChar;
										System.out.println("Incomplete Character added..");
                              j++;
                           }
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }//end for
                     for(int k = 0; k < IndependentVowel.length; k++)
                     {
                        if(str.equals(IndependentVowel[k]))
                        {
                           finalChr[j] = kIndependentVowel[k];
                           i++;
                           j++;
                           System.out.println("character mapping successful i = " + i + "    j = " + j);
                           break outer;
                        }
                     }//end for
                  }//end try
                  
                      catch(ArrayIndexOutOfBoundsException e)
                     {
                        System.out.println("from inner3 : " + e);
                        //flag1 = false;
                        break inner3;
                     }
               }	//inner 4
            }	//outer
         }
         return ((new String(finalChr)).trim());
      }
		
		public String teluguToEnglish(String telugu)
		{
			System.out.println("Inside teluguToEnglish()..");
			System.out.println("telugu String is ===>" + telugu + "===");
			char eng[] = new char[2 * telugu.length()];
			int m;	// to iterate inside kannada string
			int n;	// to iterate inside eng char array
			char temp;
			
			if(telugu.equals(""))
				return "";
			
			for(int k = 0; k < 2 * telugu.length(); k++)
				eng[k] = '\0';
			
			m = 0;
			n = 0;
			
			while(m <= telugu.length() - 1)
			{
			inner1:
			{
				temp = telugu.charAt(m);
				for(int i = 0; i < kConsonants.length; i++)
				{
					
					if(temp == ' ')
					{
						eng[n] = ' ';
						m++;
						n++;
						break inner1;
					}
					else if(kConsonants[i] == temp)
					{
						Consonants[i].getChars(0, Consonants[i].length(), eng, n);
						n += Consonants[i].length();
						m++;
						
						try{
						
						temp = telugu.charAt(m);
						
						// once a consonant is found.. then try finding a match for dependent vowel..
						for(int j = 0; j < kDependentVowel.length; j++)
						{
							if(incompleteChar == temp)
								break;
							else if(kDependentVowel[j] == temp)
							{
								DependentVowel[j].getChars(0, DependentVowel[j].length(), eng, n);
								n += DependentVowel[j].length();
								m++;
								break inner1;
							}
						}	// end for..
						}	// end try..
						catch(Exception e)
						{
							System.out.println(e);
						}
						
						// check for incomplete char or a
						if(incompleteChar == temp)
						{
							m++;
						}
						else
						{
							eng[n] = 'a';
							n++;
						}
						break inner1;
					}
				}	// end for..
				for(int i = 0; i < kIndependentVowel.length; i++)
				{
					if(incompleteChar == temp)
						break inner1;
					else if(kIndependentVowel[i] == temp)
					{
						IndependentVowel[i].getChars(0, IndependentVowel[i].length(), eng, n);
						n += IndependentVowel[i].length();
						m++;
						break inner1;
					}
				}	// end for..
			}	//end inner1
			System.out.println("eng ==>" + new String(eng) +"===m : " + m + "  n : " + n);
			}	// end while..
			
			char temp1[] = new char[n];
			int p;
			
			for(p = 0; p < n; p++)
				temp1[p] = eng[p];
			System.out.println("Final converted english string is==>" + new String(temp1) + "===");
			return ((new String(temp1)));
		}
   }