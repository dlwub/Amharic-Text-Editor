
package frequentreminder;

import java.awt.Font;
import java.util.ArrayList;

public class KeyBoard {
    
   
    public static char[] a1 = {'h','l','H','m','s','r','S','q','b','v','t','c','n','X','k','w','x',
                              'z','Z','Y','d','j','g','T','C','P','f','p'}; 
    public static char[] a2 = {'s','h','n','H','t','T'};
    public static char[] a3 = {'e','u','i','a','y','o'};
    public static char[] a4 = {':',',',';'};
    public static char[] a5 = {':','-','#'};
    public static char[] a6 = {'!','(',')','+','-','=','_','.','/','?','"'}; // Letters to be types as they are
    public static String[] a7 = {"\u1200", "\u1208", "\u1210", "\u1218", "\u1220", "\u1228", "\u1230", "\u1240", "\u1260", 
                                 "\u1268", "\u1270", "\u1278",  "\u1290", "\u12A0", "\u12A8",  "\u12C8", "\u12D0", "\u12D8", 
                                 "\u12E0", "\u12E8", "\u12F0", "\u1300", "\u1308", "\u1320", "\u1328", "\u1330", "\u1348", 
                                 "\u1350", "\u1360"};
    public static String[] a8 = {"\u1238", "\u1280", "\u1298", "\u12B8", "\u1338", "\u1340"};  
    public static String[] n = {"\u1369", "\u136A", "\u136B", "\u136C", "\u136D", "\u136E", "\u136F", "\u1370", "\u1371",
            "\u1372", "\u1373", "\u1374", "\u1375", "\u1376", "\u1377", "\u1378", "\u1379", "\u137A", "\u137B"};
    public static Font myFont = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);  
    
    public static ArrayList< String > l = new ArrayList<  >(); 
    public static String T = "";
    
    public static String[] en_to_am(char s)
    {
        String[] S = new String[2];
        // Check if the key typed is among those in array a1
        
        switch (l.size())
        {
            case 0:
                if (s=='\\') // if input is back slash
                {                    
                    S[0] = "";
                    S[1] = "a";
                    l.add(Character.toString(s)) ;
                    break;
                }                
                else if(Character.isSpaceChar(s))
                {
                    S[0] = " ";
                    S[1] = "a"; 
                    break;  
                }                
                else if(new String(a1).indexOf(s)!=-1) // if the input is in a1
                {
                     S[0] = new String(Character.toChars(a7[new String(a1).indexOf(s)].codePointAt(0)+5));
                     S[1] = "a"; // Append the above element to the JTextArea 
                     l.add(Character.toString(s));
                     break;    
                }
                else if(new String(a4).indexOf(s)!=-1) // if the input is in a4
                {
                    l.clear();
                    switch (new String(a4).indexOf(s))
                    {                        
                        case 0:
                        case 1:
                            S[0] = new String(Character.toChars(a7[a7.length -1].codePointAt(0)+ 2*(new String(a4).indexOf(s))+1));
                            S[1] = "a"; // Append the above element to the JTextArea  
                            l.add(Character.toString(s));
                            break;
                        case 2:
                            S[0] = new String(Character.toChars(a7[a7.length -1].codePointAt(0)+ 2*(new String(a4).indexOf(s))));
                            S[1] = "a"; // Append the above element to the JTextArea                            
                            break;                                             
                    }                    
                }
                else if (Character.isDigit(Character.toString(s).charAt(0)))  // If input is a digit
                {
                    l.clear();
                    S[0] = Character.toString(s);
                    S[1] = "a"; 
                    break;  
                }
                else if(new String(a6).indexOf(s)!=-1)
                {
                    l.clear();
                    S[0] = Character.toString(s);
                    S[1] = "a"; 
                    break;  
                }         
                else                             // For any other key press
                {
                     S[0] = "";
                     S[1] = "a"; // Append the above element to the JTextArea                     
                     break;    
                } 
                break;
            case 1:
                if (s=='\\')
                {
                    l.clear();
                    S = en_to_am(s); 
                    break;                    
                }
                else if(l.get(0).equals(Character.toString('\\'))) //if the first element of the arraylist is '\'
                {
                    if (new String(a2).indexOf(s)!=-1)
                    {
                        T = "";
                        l.add(1, Character.toString(s));
                        // Returns the sixth element of the Amharic alphabet
                        S[0] = new String(Character.toChars(a8[new String(a2).indexOf(s)].codePointAt(0)+5)); 
                        S[1] = "a"; // Append 
                        break; 
                    }
                    else if (Character.isDigit(Character.toString(s).charAt(0)))
                    {                        
                        T = T + Character.toString(s);
                        int t = Integer.parseInt(T);
                        if (1<=t && t<=9)
                        {
                            S[0] = geez_numeral(t);
                            S[1] = "a";                            
                        }
                        else if (t<1 || t>10000)
                        {
                            S[0] = "";
                            S[1] = "a"; 
                        }
                        else
                        {
                            S[0] = geez_numeral(t);
                            S[1] = "r";
                        }                                               
                        break;                         
                    }
                    else if (s==',')
                    {
                        T = "";
                        l.clear();
                        S[0] = Character.toString(s);
                        S[1] = "a"; 
                        break;                        
                    }
                    else
                    {
                        T = "";
                        l.clear();
                        S[0] = ""; 
                        S[1] = "a";
                        break; 
                    }                                                   
                }
                else if(new String(a1).contains(l.get(0))) // if the first element of the array list is an element of a1 
                {
                    switch(s)
                    {
                        case 'o': 
                            S[0] = new String(Character.toChars(a7[new String(a1).indexOf(l.get(0))].codePointAt(0)+6));
                            S[1] = "r"; //Replace the previous character in the JTextArea
                            l.clear();
                            break;
                        case 'u':
                            l.add(1, Character.toString(s));
                            S[0] = new String(Character.toChars(a7[new String(a1).indexOf(l.get(0))].codePointAt(0)+ new String(a3).indexOf(s)));
                            S[1] = "r"; //Replace the previous character in the JTextArea
                            break;
                        case 'e':
                        case 'i':
                        case 'a':
                        case 'y':
                            S[0] = new String(Character.toChars(a7[new String(a1).indexOf(l.get(0))].codePointAt(0)+ new String(a3).indexOf(s)));
                            S[1] = "r"; //Replace the previous character in the JTextArea
                            l.clear();
                            break;
                        default:
                            l.clear();
                            S = en_to_am(s); 
                            break;
                    }                    
                }
                else if (new String(a4).contains(l.get(0))) // if the first element of the array list is an element of a4
                { 
                    if (l.get(0).equals(",") && s==',')
                    {
                        S[0] = new String(Character.toChars(a7[a7.length -1].codePointAt(0)+ 5));
                        S[1] = "r"; // Append the above element to the JTextArea
                        l.clear();
                        break;                        
                    }
                    else if (l.get(0).equals(":")&& new String(a5).indexOf(s)!= -1)
                    {
                        switch(new String(a5).indexOf(s))
                        {
                            case 0:
                            case 1:                                
                                S[0] = new String(Character.toChars(a7[a7.length -1].codePointAt(0)+ 4*(new String(a5).indexOf(s))+2));
                                S[1] = "r"; // Append the above element to the JTextArea
                                l.clear();
                                break; 
                            case 2:
                                S[0] = new String(Character.toChars(a7[a7.length -1].codePointAt(0)+ 4*(new String(a5).indexOf(s))));
                                S[1] = "r"; // Append the above element to the JTextArea
                                l.clear();
                                break;
                        }
                    } 
                    else
                    {
                        S[0] = "";
                        S[1] = "a"; // Append the above element to the JTextArea
                        l.clear();
                        break;                        
                    }
                }
                else if (Character.isDigit(Character.toString(s).charAt(0)))
                {
                    l.clear();
                    S[0] = Character.toString(s);
                    S[1] = "a"; 
                    break;  
                }
                break;
            case 2:
                if(l.get(0).equals(Character.toString('\\'))) //if the first element of the arraylist is '\'
                {
                    if (new String(a2).contains(l.get(1)))    // if the second element of the array list is an element of a2 
                    {
                        switch(s)
                        {
                            case 'o':                                 
                                S[0] = new String(Character.toChars(a8[new String(a2).indexOf(l.get(1))].codePointAt(0)+6));
                                S[1] = "r"; //Replace the previous character in the JTextArea
                                l.clear();
                                break;
                            case 'u':
                                l.add(2, Character.toString(s));
                                S[0] = new String(Character.toChars(a8[new String(a2).indexOf(l.get(1))].codePointAt(0)+ 1));
                                S[1] = "r"; //Replace the previous character in the JTextArea
                                break;
                            case 'e':
                            case 'i':
                            case 'a':
                            case 'y':
                                S[0] = new String(Character.toChars(a8[new String(a2).indexOf(l.get(1))].codePointAt(0)+ new String(a3).indexOf(s)));
                                S[1] = "r"; //Replace the previous character in the JTextArea
                                l.clear();
                                break;
                            default:
                                l.clear(); 
                                S = en_to_am(s);
                                break;                                
                        }                        
                    }
                }
                else if (new String(a1).contains(l.get(0))) // if the first element of the array list is in a1
                {
                    if(l.get(1).equals(Character.toString('u'))&&s=='a') // if the second element of the array list is 'u' and input is 'a'
                    { 
                        switch(l.get(0))
                        {
                            case "q":
                            case "k":
                            case "g":                                
                                S[0] = new String(Character.toChars(a7[new String(a1).indexOf(l.get(0))].codePointAt(0)+11));
                                S[1] = "r"; //Replace the previous character in the JTextArea
                                l.clear();
                                break;
                            default:                                
                                S[0] = new String(Character.toChars(a7[new String(a1).indexOf(l.get(0))].codePointAt(0)+7));                                
                                S[1] = "r"; //Replace the previous character in the JTextArea
                                l.clear();
                                break;
                        } 
                    }
                    else
                    {
                        l.clear();
                        S = en_to_am(s); 
                        break;                        
                    }
                }
                else if (Character.isDigit(Character.toString(s).charAt(0)))
                {
                    l.clear();
                    S[0] = Character.toString(s);
                    S[1] = "a"; 
                    break;  
                }
                break;
            case 3:
                //if the first element of the arraylist is '\' and the third element is 'u' and input is 'a'
                if(l.get(0).equals(Character.toString('\\')) && l.get(2).equals(Character.toString('u')) && s=='a') 
                {
                    if (new String(a2).contains(l.get(1))) // if the second element of the array list is in a2
                    {
                        switch(l.get(1))
                        {
                            case "h":
                            case "H": 
                                S[0] = new String(Character.toChars(a8[new String(a2).indexOf(l.get(1))].codePointAt(0)+11));                                
                                S[1] = "r"; //Replace the previous character in the JTextArea
                                l.clear();
                                break;
                            default:
                                S[0] = new String(Character.toChars(a8[new String(a2).indexOf(l.get(1))].codePointAt(0)+7));
                                S[1] = "r"; //Replace the previous character in the JTextArea
                                l.clear();
                                break;
                        } 
                    }
                }
                else if (Character.isDigit(Character.toString(s).charAt(0)))
                {
                    l.clear();
                    S[0] = Character.toString(s);
                    S[1] = "a"; 
                    break;  
                }
                else
                {
                    l.clear();
                    S = en_to_am(s);                    
                    break;                     
                }
                break;            
        }
        return S;           
        
    }
    
    public static String geez_numeral(int m) {
        String S2 = "";
        
        if ((1 <= m) && (m <= 10)) {
            S2 = n[m - 1];
        } else if ((10 < m) && (m <= 100)) {
            int q = m / 10;
            int r = m % 10;
            if (r == 0) {
                S2 = n[8 + q];
            } else {
                S2 = n[8 + q] + n[r - 1];
            }
        } else if ((100 < m) && (m <= 10000)) {
            int q = m / 100;
            int r = m % 100;
            if (q == 1) {
                String num = geez_numeral(r);
                S2 = n[18] + num;
            } else if (r == 0) {
                String num = geez_numeral(q);
                S2 = num + n[18];
            } else {
                String num = geez_numeral(q);
                String num2 = geez_numeral(r);
                S2 = num + n[18] + num2;
            }
        }
        return S2;
    }
}

