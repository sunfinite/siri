   public class RecommendKannada
   {
      String chr[];
      String finalChr[];
      boolean flag1 = true;
      boolean flag2 = true;// incomplete letter flag
   
      String Digits[];
      String IndependentVowel[][];
      String DependentVowel[][];
      String Consonants[][];
   
      String kDigits[];
      String kIndependentVowel[];
      String kDependentVowel[];
      String kConsonants[];
   
      String incompleteChar;
      
   	
   	RecommendKannada()
   	{
   		initialize();
   	}
   	
   
      public void initialize()
      {
      
         incompleteChar = "\u0CCD";
      
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
      	
      
      
         IndependentVowel = new String[14][];
      	
         IndependentVowel[0] = new String[2];
         IndependentVowel[0][0] = "a"; // A
         IndependentVowel[0][1] = "aa"; // AA
      				
         IndependentVowel[1] = new String[2];
         IndependentVowel[1][0] = "aa"; // AA
         IndependentVowel[1][1] = "a"; // A
      	
         IndependentVowel[2] = new String[3];
         IndependentVowel[2][0] = "i"; // I
			IndependentVowel[2][1] = "ii"; // II
         IndependentVowel[2][2] = "e"; // E
      	
         IndependentVowel[3] = new String[3];
         IndependentVowel[3][0] = "ii"; // II
			IndependentVowel[3][1] = "i"; // I
			IndependentVowel[3][2] = "e"; // E
      	
         IndependentVowel[4] = new String[2];
         IndependentVowel[4][0] = "u"; // U
			IndependentVowel[4][1] = "uu"; // UU
      	
         IndependentVowel[5] = new String[2];
         IndependentVowel[5][0] = "uu"; // UU
			IndependentVowel[5][1] = "u"; // U
      	
         IndependentVowel[6] = new String[1];
         IndependentVowel[6][0] = "r"; // vocabulary R
      
         IndependentVowel[7] = new String[1];
         IndependentVowel[7][0] = "l"; // vocabulary L
      	
         IndependentVowel[8] = new String[2];
         IndependentVowel[8][0] = "e"; // E
			IndependentVowel[8][1] = "ee"; // EE
      
         IndependentVowel[9] = new String[2];
         IndependentVowel[9][0] = "ee"; // EE
			IndependentVowel[9][1] = "e"; // E
      	
         IndependentVowel[10] = new String[1]; 
         IndependentVowel[10][0] = "ai"; // AI
      
         IndependentVowel[11] = new String[2];
         IndependentVowel[11][0] = "o"; // O
			IndependentVowel[11][1] = "oo"; // 00
      
         IndependentVowel[12] = new String[2];
         IndependentVowel[12][0] = "oo"; // 00
			IndependentVowel[12][1] = "o"; // 0
      	
         IndependentVowel[13] = new String[1];
         IndependentVowel[13][0] = "au"; // AU
      
      
      
         DependentVowel = new String[16][];
			
			DependentVowel[0] = new String[2];
         DependentVowel[0][0] = "a"; // A
			DependentVowel[0][0] = "aa"; // AA
			
			DependentVowel[1] = new String[2];
         DependentVowel[1][0] = "aa"; // AA
			DependentVowel[1][1] = "a"; // A
			
			DependentVowel[2] = new String[4];
         DependentVowel[2][0] = "i"; // I
			DependentVowel[2][1] = "ii"; // II
			DependentVowel[2][2] = "e"; // E
			DependentVowel[2][3] = "ee"; // EE
			
			DependentVowel[3] = new String[4];
         DependentVowel[3][0] = "ii"; // II
			DependentVowel[3][1] = "i"; // I
			DependentVowel[3][2] = "e"; // E
			DependentVowel[3][3] = "ee"; // EE
			
			DependentVowel[4] = new String[2];
         DependentVowel[4][0] = "u"; // U
			DependentVowel[4][1] = "uu"; // UU
			
			DependentVowel[5] = new String[2];
         DependentVowel[5][0] = "uu"; // UU
			DependentVowel[5][1] = "u"; // U
			
			DependentVowel[6] = new String[2];
         DependentVowel[6][0] = "r"; // vocabulary R
			DependentVowel[6][1] = "rr"; // vocabulary RR
			
			DependentVowel[7] = new String[2];
         DependentVowel[7][0] = "rr"; // vocabulary RR
			DependentVowel[7][1] = "r"; // vocabulary R
			
			DependentVowel[8] = new String[4];
         DependentVowel[8][0] = "e"; // E
			DependentVowel[8][1] = "ee"; // EE
			DependentVowel[8][2] = "i"; // I
			DependentVowel[8][3] = "ii"; // II
			
			DependentVowel[9] = new String[4];
         DependentVowel[9][0] = "ee"; // EE
			DependentVowel[9][1] = "e"; // E
			DependentVowel[9][2] = "i"; // I
			DependentVowel[9][3] = "ii"; // II
			
			DependentVowel[10] = new String[1];
         DependentVowel[10][0] = "ai"; // AI
			
			DependentVowel[11] = new String[2];
         DependentVowel[11][0] = "o"; // O
			DependentVowel[11][1] = "oo"; // 00
			
			DependentVowel[12] = new String[2];
         DependentVowel[12][0] = "oo"; // 00
			DependentVowel[12][1] = "o"; // O
			
			DependentVowel[13] = new String[1];
         DependentVowel[13][0] = "au"; // AU
			
			DependentVowel[14] = new String[1];
         DependentVowel[14][0] = "am"; // AM
			
			DependentVowel[15] = new String[1];
      //DependentVowel[15] = "an"; // AM
         DependentVowel[15][0] = "aha"; // AHA
      
      
         Consonants = new String[35][];
			
			Consonants[0] = new String[4];
         Consonants[0][0] = "k"; // KA
         Consonants[0][1] = "kh"; // KHA
         Consonants[0][2] = "g"; // GA
         Consonants[0][3] = "gh"; // GHA
			
			Consonants[1] = new String[4];
         Consonants[1][0] = "kh"; // KHA
			Consonants[1][1] = "k"; // KA
         Consonants[1][2] = "g"; // GA
         Consonants[1][3] = "gh"; // GHA
			
			Consonants[2] = new String[4];
			Consonants[2][0] = "g"; // GA
         Consonants[2][1] = "k"; // KA
         Consonants[2][2] = "kh"; // KHA
         Consonants[2][3] = "gh"; // GHA
			
			Consonants[3] = new String[4];
         Consonants[3][0] = "gh"; // GHA
         Consonants[3][1] = "k"; // KA
         Consonants[3][2] = "kh"; // KHA
         Consonants[3][3] = "g"; // GA

			Consonants[4] = new String[2];
         Consonants[4][0] = "ng"; // NGA
			Consonants[4][1] = "ny"; // NYA
			
			//===================================

			Consonants[5] = new String[4];
         Consonants[5][0] = "c"; // CA
         Consonants[5][1] = "ch"; // CHA
         Consonants[5][2] = "j"; // JA
         Consonants[5][3] = "jh"; // JHA
			
			Consonants[6] = new String[4];
         Consonants[6][0] = "ch"; // CHA
         Consonants[6][1] = "c"; // CA
         Consonants[6][2] = "j"; // JA
         Consonants[6][3] = "jh"; // JHA
			
			Consonants[7] = new String[4];
         Consonants[7][0] = "j"; // JA
         Consonants[7][1] = "c"; // CA
         Consonants[7][2] = "ch"; // CHA
         Consonants[7][3] = "jh"; // JHA
			
			Consonants[8] = new String[4];
			Consonants[8][0] = "jh"; // JHA
         Consonants[8][1] = "c"; // CA
         Consonants[8][2] = "ch"; // CHA
         Consonants[8][3] = "j"; // JA
			
			Consonants[9] = new String[2];
         Consonants[9][0] = "ny"; // NYA
			Consonants[9][1] = "ng"; // NGA
			
			//===================================
			
			Consonants[10] = new String[8];
         Consonants[10][0] = "ttt"; // TTTA
         Consonants[10][1] = "tth"; // TTHA
         Consonants[10][2] = "dd"; // DDA
         Consonants[10][3] = "ddh"; // DDHA
			Consonants[10][4] = "t"; // TA
         Consonants[10][5] = "th"; // THA
         Consonants[10][6] = "d"; // DA
         Consonants[10][7] = "dh"; // DHA
			
			Consonants[11] = new String[8];
			Consonants[11][0] = "tth"; // TTHA
         Consonants[11][1] = "ttt"; // TTA      
         Consonants[11][2] = "dd"; // DDA
         Consonants[11][3] = "ddh"; // DDHA
         Consonants[11][4] = "t"; // TA
         Consonants[11][5] = "th"; // THA
         Consonants[11][6] = "d"; // DA
         Consonants[11][7] = "dh"; // DHA
			
			Consonants[12] = new String[8];
			Consonants[12][0] = "dd"; // DDA
         Consonants[12][1] = "ttt"; // TTA
         Consonants[12][2] = "tth"; // TTHA
         Consonants[12][3] = "ddh"; // DDHA
         Consonants[12][4] = "t"; // TA
         Consonants[12][5] = "th"; // THA
         Consonants[12][6] = "d"; // DA
         Consonants[12][7] = "dh"; // DHA
			
			Consonants[13] = new String[8];
			Consonants[13][0] = "ddh"; // DDHA
         Consonants[13][1] = "ttt"; // TTA
         Consonants[13][2] = "tth"; // TTHA
         Consonants[13][3] = "dd"; // DDA
         Consonants[13][4] = "t"; // TA
         Consonants[13][5] = "th"; // THA
         Consonants[13][6] = "d"; // DA
         Consonants[13][7] = "dh"; // DHA
			
			Consonants[14] = new String[2];
         Consonants[14][0] = "nnn"; // NNNA
			Consonants[14][1] = "n"; // NA
			
			//===================================
			
			Consonants[15] = new String[8];
         Consonants[15][0] = "t"; // TA
         Consonants[15][1] = "th"; // THA
         Consonants[15][2] = "d"; // DA
         Consonants[15][3] = "dh"; // DHA
			Consonants[15][4] = "ttt"; // TTA
         Consonants[15][5] = "tth"; // TTHA
         Consonants[15][6] = "dd"; // DDA
         Consonants[15][7] = "ddh"; // DDHA
			
			Consonants[16] = new String[8];
			Consonants[16][0] = "th"; // THA
         Consonants[16][1] = "t"; // TA
         Consonants[16][2] = "d"; // DA
         Consonants[16][3] = "dh"; // DHA
			Consonants[16][4] = "ttt"; // TTTA
         Consonants[16][5] = "tth"; // TTHA
         Consonants[16][6] = "dd"; // DDA
         Consonants[16][7] = "ddh"; // DDHA
			
			Consonants[17] = new String[8];
         Consonants[17][0] = "d"; // DA
         Consonants[17][1] = "t"; // TA
         Consonants[17][2] = "th"; // THA
         Consonants[17][3] = "dh"; // DHA
			Consonants[17][4] = "ttt"; // TTTA
         Consonants[17][5] = "tth"; // TTHA
         Consonants[17][6] = "dd"; // DDA
         Consonants[17][7] = "ddh"; // DDHA
			
			Consonants[18] = new String[8];
         Consonants[18][0] = "dh"; // DHA
         Consonants[18][1] = "t"; // TA
         Consonants[18][2] = "th"; // THA
         Consonants[18][3] = "d"; // DA
			Consonants[18][4] = "ttt"; // TTTA
         Consonants[18][5] = "tth"; // TTHA
         Consonants[18][6] = "dd"; // DDA
         Consonants[18][7] = "ddh"; // DDHA
			
			Consonants[19] = new String[2];
         Consonants[19][0] = "n"; // NA
			Consonants[19][1] = "nn"; // NNA
			
			//======================================
			
			Consonants[20] = new String[4];
         Consonants[20][0] = "p"; // PA
         Consonants[20][1] = "ph"; // PHA
         Consonants[20][2] = "b"; // BA
         Consonants[20][3] = "bh"; // BHA
			
			
			Consonants[21] = new String[4];
			Consonants[21][0] = "ph"; // PHA
			Consonants[21][1] = "p"; // PA
         Consonants[21][2] = "b"; // BA
         Consonants[21][3] = "bh"; // BHA
			
			
			Consonants[22] = new String[4];
			Consonants[22][0] = "b"; // BA
         Consonants[22][1] = "p"; // PA
         Consonants[22][2] = "ph"; // PHA
         Consonants[22][3] = "bh"; // BHA
			
			
			Consonants[23] = new String[4];
			Consonants[23][0] = "bh"; // BHA
         Consonants[23][1] = "p"; // PA
         Consonants[23][2] = "ph"; // PHA
         Consonants[23][3] = "b"; // BA
			
			
			Consonants[24] = new String[1];
         Consonants[24][0] = "m"; // MA
			
			//========================================
			
			Consonants[25] = new String[2];
         Consonants[25][0] = "y"; // YA
			Consonants[25][1] = "a"; // A
			
			
			Consonants[26] = new String[2];
         Consonants[26][0] = "r"; // RA
			Consonants[26][1] = "rr"; // RRA
			
			Consonants[27] = new String[2];
         Consonants[27][0] = "rr"; // RRA
			Consonants[27][1] = "r"; // RA
			
			Consonants[28] = new String[2];
         Consonants[28][0] = "l"; // LA
			Consonants[28][1] = "ll"; // LLA
			
			Consonants[29] = new String[2];
         Consonants[29][0] = "ll"; // LLA
			Consonants[29][1] = "l"; // LA
			
			Consonants[30] = new String[1];
         Consonants[30][0] = "v"; // VA
			
			Consonants[31] = new String[3];
         Consonants[31][0] = "sh"; // SHA
			Consonants[31][1] = "ss"; // SSA
			Consonants[31][2] = "s"; // SA
   
			Consonants[32] = new String[3];
	      Consonants[32][0] = "ss"; // SSA
			Consonants[32][1] = "sh"; // SHA
			Consonants[32][2] = "s"; // SA
			
			Consonants[33] = new String[3];
         Consonants[33][0] = "s"; // SA
			Consonants[33][1] = "sh"; // SHA
			Consonants[33][2] = "ss"; // SSA
			
			Consonants[34] = new String[2];
         Consonants[34][0] = "h"; // HA
			Consonants[34][1] = "a"; // A
      	
      
         kDigits = new String[10];
         kDigits[0] = "\u0CE6"; // 0
         kDigits[1] = "\u0CE7"; // 1
         kDigits[2] = "\u0CE8"; // 2
         kDigits[3] = "\u0CE9"; // 3
         kDigits[4] = "\u0CEA"; // 4
         kDigits[5] = "\u0CEB"; // 5
         kDigits[6] = "\u0CEC"; // 6
         kDigits[7] = "\u0CED"; // 7
         kDigits[8] = "\u0CEE"; // 8
         kDigits[9] = "\u0CEF"; // 9
      
      	
      
         kIndependentVowel = new String[14];
      	
         kIndependentVowel[0] = "\u0C85"; // A
         kIndependentVowel[1] = "\u0C86"; // AA
         kIndependentVowel[2] = "\u0C87"; // I
         kIndependentVowel[3] = "\u0C88"; // II
         kIndependentVowel[4] = "\u0C89"; // U
         kIndependentVowel[5] = "\u0C8A"; // UU
         kIndependentVowel[6] = "\u0C8B"; // vocabulary R
         kIndependentVowel[7] = "\u0C8C"; // vocabulary L
         kIndependentVowel[8] = "\u0C8E"; // E
         kIndependentVowel[9] = "\u0C8F"; // EE
         kIndependentVowel[10] ="\u0C90"; // AI
         kIndependentVowel[11] ="\u0C92"; // O
         kIndependentVowel[12] ="\u0C93"; // 00
         kIndependentVowel[13] ="\u0C94"; // AU
      
      
         kDependentVowel = new String[16];
      	kDependentVowel[0] = "\u0C91"; //should not be used.. but due to some problems tried it.. working fine for now..
         kDependentVowel[1] = "\u0CBE"; // AA
         kDependentVowel[2] = "\u0CBF"; // I
         kDependentVowel[3] = "\u0CC0"; // II
         kDependentVowel[4] = "\u0CC1"; // U
         kDependentVowel[5] = "\u0CC2"; // UU
         kDependentVowel[6] = "\u0CC3"; // vocabulary R
         kDependentVowel[7] = "\u0CC4"; // vocabulary RR
         kDependentVowel[8] = "\u0CC6"; // E
         kDependentVowel[9] = "\u0CC7"; // EE
         kDependentVowel[10] = "\u0CC8"; // AI
         kDependentVowel[11] = "\u0CCA"; // O
         kDependentVowel[12] = "\u0CCB"; // 00
         kDependentVowel[13] = "\u0CCC"; // AU
         kDependentVowel[14] = "\u0C82"; // AM
      //kDependentVowel[15] = "\u0C82"; // AN
         kDependentVowel[15] = "\u0C83"; // AHA         
      
         kConsonants = new String[35];
         kConsonants[0] = "\u0C95"; // KA
         kConsonants[1] = "\u0C96"; // KHA
         kConsonants[2] = "\u0C97"; // GA
         kConsonants[3] = "\u0C98"; // GHA
         kConsonants[4] = "\u0C99"; // NGA
         kConsonants[5] = "\u0C9A"; // CA
         kConsonants[6] = "\u0C9B"; // CHA
         kConsonants[7] = "\u0C9C"; // JA
         kConsonants[8] = "\u0C9D"; // JHA
         kConsonants[9] = "\u0C9E"; // NYA
         kConsonants[10] = "\u0C9F"; // TTA
         kConsonants[11] = "\u0CA0"; // TTHA
         kConsonants[12] = "\u0CA1"; // DDA
         kConsonants[13] = "\u0CA2"; // DDHA
         kConsonants[14] = "\u0CA3"; // NNA
         kConsonants[15] = "\u0CA4"; // TA
         kConsonants[16] = "\u0CA5"; // THA
         kConsonants[17] = "\u0CA6"; // DA
         kConsonants[18] = "\u0CA7"; // DHA
         kConsonants[19] = "\u0CA8"; // NA
         kConsonants[20] = "\u0CAA"; // PA
         kConsonants[21] = "\u0CAB"; // PHA
         kConsonants[22] = "\u0CAC"; // BA
         kConsonants[23] = "\u0CAD"; // BHA
         kConsonants[24] = "\u0CAE"; // MA
         kConsonants[25] = "\u0CAF"; // YA
         kConsonants[26] = "\u0CB0"; // RA
         kConsonants[27] = "\u0CB1"; // RRA
         kConsonants[28] = "\u0CB2"; // LA
         kConsonants[29] = "\u0CB3"; // LLA
         kConsonants[30] = "\u0CB5"; // VA
         kConsonants[31] = "\u0CB6"; // SHA
         kConsonants[32] = "\u0CB7"; // SSA
         kConsonants[33] = "\u0CB8"; // SA
         kConsonants[34] = "\u0CB9"; // HA
      }
   	
      public String[] process(String key)
      {
			
			//try finding a match for DependentVowel..
         for(int x = 0; x < kDependentVowel.length; x++)
            if(kDependentVowel[x].equals(key))
               return DependentVowel[x];
			
			// try finding a match for consonants..
			for(int x = 0; x < kConsonants.length; x++)
				if(kConsonants[x].equals(key))
					return Consonants[x];
			
			//try finding a match for consonants..
         for(int x = 0; x < kIndependentVowel.length; x++)
            if(kIndependentVowel[x].equals(key))
               return IndependentVowel[x];
			
			return null;
      }
   }