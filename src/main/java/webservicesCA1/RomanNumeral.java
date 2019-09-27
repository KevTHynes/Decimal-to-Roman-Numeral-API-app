/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicesCA1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; 
import javax.ws.rs.core.Response;

/**
 *
 * @author x09092943/x14110768
 */
@Path("/romannumeral")
//  http://localhost:49000/api/romannumeral/MLXXIX
public class RomanNumeral {
    
    /*-----------------------------------------------------------------------------------
    *** 1=I, 4=IV, 5=V, 9=IX, 10=X, 40=XL, 50=L, 90=XC, 100=C, 400=CD, 500=D, 1000=M ***
    -----------------------------------------------------------------------------------*/
    public int romNum(char rom){
        
        switch (rom) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                default:
                return 1000;
            //default:
               //break;
        }       
        //return 0;       
    }
    public int romToDec(String romanNum){
      
        int result = 0, count = 0;
      
         for( count = 0; count <romanNum.length(); count++) 
         {
             int num = romNum(romanNum.charAt(count));
             int nxtNum;
             
             if (count + 1 < romanNum.length())
             {
                 nxtNum = romNum(romanNum.charAt(count + 1));
             }
             else nxtNum = 0;
             if(num >= nxtNum )
             {
                 result += num;
             }
             else
             {
                 result += nxtNum - num;
                 count++;
             }
         }
         return result;
    }
     @GET
    @Path("/{param}")
    public Response romanNumeral(@PathParam("param") String romanNum)
    {   
        String output = "Roman Numeral is: " + romanNum  +"\n" + " Decimal num is: " + (romToDec(romanNum));
        return Response.status(200).entity(output).build();
        
    }
}
