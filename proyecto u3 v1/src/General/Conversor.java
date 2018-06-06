/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 */
public class Conversor {
    
    int decimal;
    
    ArrayList<Character> hex(List<String> numDecimal)
    { 
        decimal=0;
        int resto=0; 
        String Hexadecimal=""; 
        System.out.println("imput:"+numDecimal);
        
        for (int x=0; x<numDecimal.size(); x++){
            decimal=decimal*10;
            decimal += Integer.parseInt(numDecimal.get(x));
        }
        
        while(decimal>0) 
        { 
           
           resto=(decimal%16); 
           if(resto>9) 
               Hexadecimal=letras(resto)+Hexadecimal; 
           else 
               Hexadecimal=resto+Hexadecimal; 
            decimal=decimal/16; 
        } 
        
        ArrayList<Character> charList = new ArrayList<Character>();      
        for(int i = 0; i<Hexadecimal.length();i++){
            charList.add(Hexadecimal.charAt(i));
        }
        
        ArrayList<String> finalList=new ArrayList<>();
        for (Character character : charList) {
            finalList.add(Character.toString(character));
        }
        
        System.out.println("hex:"+finalList);
        return charList;
    } 
     
    static String letras(int n) 
    { 
        String letra=""; 
        switch(n) 
        { 
        case 10: 
        letra="A"; 
        break; 
        case 11: 
        letra="B"; 
        break; 
        case 12: 
        letra="C"; 
        break; 
        case 13: 
        letra="D"; 
        break; 
        case 14: 
        letra="E"; 
        break; 
        case 15: 
        letra="F"; 
        break; 
        } 
        return letra; 
    } 
    
}

