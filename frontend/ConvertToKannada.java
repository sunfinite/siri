    public class ConvertToKannada
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
		
		public ConvertToKannada()
		{
			initialize();
		}
		
       public ConvertToKannada(char chr1[], int len)
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
      
         incompleteChar = '\u0CCD';
      	
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
         kDigits[0] = '\u0CE6'; // 0
         kDigits[1] = '\u0CE7'; // 1
         kDigits[2] = '\u0CE8'; // 2
         kDigits[3] = '\u0CE9'; // 3
         kDigits[4] = '\u0CEA'; // 4
         kDigits[5] = '\u0CEB'; // 5
         kDigits[6] = '\u0CEC'; // 6
         kDigits[7] = '\u0CED'; // 7
         kDigits[8] = '\u0CEE'; // 8
         kDigits[9] = '\u0CEF'; // 9
      
      		
      
         kIndependentVowel = new char[14];
         kIndependentVowel[0] = '\u0C85'; // A
         kIndependentVowel[1] = '\u0C86'; // AA
         kIndependentVowel[2] = '\u0C87'; // I
         kIndependentVowel[3] = '\u0C88'; // II
         kIndependentVowel[4] = '\u0C89'; // U
         kIndependentVowel[5] = '\u0C8A'; // UU
         kIndependentVowel[6] = '\u0C8B'; // vocabulary R
			//kIndependentVowel[6] = '\u0CB0'; // vocabulary R
         kIndependentVowel[7] = '\u0C8C'; // vocabulary L
         kIndependentVowel[8] = '\u0C8E'; // E
         kIndependentVowel[9] = '\u0C8F'; // EE
         kIndependentVowel[10] ='\u0C90'; // AI
         kIndependentVowel[11] ='\u0C92'; // O
         kIndependentVowel[12] ='\u0C93'; // 00
         kIndependentVowel[13] ='\u0C94'; // AU
      
      
         kDependentVowel = new char[16];
         //kDependentVowel[0] =
         kDependentVowel[1] = '\u0CBE'; // AA
         kDependentVowel[2] = '\u0CBF'; // I
         kDependentVowel[3] = '\u0CC0'; // II
         kDependentVowel[4] = '\u0CC1'; // U
         kDependentVowel[5] = '\u0CC2'; // UU
         kDependentVowel[6] = '\u0CC3'; // vocabulary R
			//kDependentVowel[6] = '\u0CB0'; // vocabulary R
         kDependentVowel[7] = '\u0CC4'; // vocabulary RR
         kDependentVowel[8] = '\u0CC6'; // E
         kDependentVowel[9] = '\u0CC7'; // EE
         kDependentVowel[10] = '\u0CC8'; // AI
         kDependentVowel[11] = '\u0CCA'; // O
         kDependentVowel[12] = '\u0CCB'; // 00
         kDependentVowel[13] = '\u0CCC'; // AU
         kDependentVowel[14] = '\u0C82'; // AM
         //kDependentVowel[15] = '\u0C82'; // AN
         kDependentVowel[15] = '\u0C83'; // AHA         
      	
         kConsonants = new char[35];
         kConsonants[0] = '\u0C95'; // KA
         kConsonants[1] = '\u0C96'; // KHA
         kConsonants[2] = '\u0C97'; // GA
         kConsonants[3] = '\u0C98'; // GHA
         kConsonants[4] = '\u0C99'; // NGA
         kConsonants[5] = '\u0C9A'; // CA
         kConsonants[6] = '\u0C9B'; // CHA
         kConsonants[7] = '\u0C9C'; // JA
         kConsonants[8] = '\u0C9D'; // JHA
         kConsonants[9] = '\u0C9E'; // NYA
         kConsonants[10] = '\u0C9F'; // TTA
         kConsonants[11] = '\u0CA0'; // TTHA
         kConsonants[12] = '\u0CA1'; // DDA
         kConsonants[13] = '\u0CA2'; // DDHA
         kConsonants[14] = '\u0CA3'; // NNA
         kConsonants[15] = '\u0CA4'; // TA
         kConsonants[16] = '\u0CA5'; // THA
         kConsonants[17] = '\u0CA6'; // DA
         kConsonants[18] = '\u0CA7'; // DHA
         kConsonants[19] = '\u0CA8'; // NA
         kConsonants[20] = '\u0CAA'; // PA
         kConsonants[21] = '\u0CAB'; // PHA
         kConsonants[22] = '\u0CAC'; // BA
         kConsonants[23] = '\u0CAD'; // BHA
         kConsonants[24] = '\u0CAE'; // MA
         kConsonants[25] = '\u0CAF'; // YA
         kConsonants[26] = '\u0CB0'; // RA
         kConsonants[27] = '\u0CB1'; // RRA
         kConsonants[28] = '\u0CB2'; // LA
         kConsonants[29] = '\u0CB3'; // LLA
         kConsonants[30] = '\u0CB5'; // VA
         kConsonants[31] = '\u0CB6'; // SHA
         kConsonants[32] = '\u0CB7'; // SSA
         kConsonants[33] = '\u0CB8'; // SA
         kConsonants[34] = '\u0CB9'; // HA
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
		
		public String kannadaToEnglish(String kannada)
		{
			System.out.println("Inside kannadaToEnglish()..");
			System.out.println("kannada String is ===>" + kannada + "===");
			char eng[] = new char[2 * kannada.length()];
			int m;	// to iterate inside kannada string
			int n;	// to iterate inside eng char array
			char temp;
			
			if(kannada.equals(""))
				return "";
			
			for(int k = 0; k < 2 * kannada.length(); k++)
				eng[k] = '\0';
			
			m = 0;
			n = 0;
			
			while(m <= kannada.length() - 1)
			{
			inner1:
			{
				temp = kannada.charAt(m);
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
						
						temp = kannada.charAt(m);
						
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