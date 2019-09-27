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
@Path("/decimal")

//http://localhost:49000/api/decimal/1079
public class Decimal {
    Double decimalInput;
    Double R;
    String romanNum;
    
   /*-----------------------------------------------------------------------------------
    *** 1=I, 4=IV, 5=V, 9=IX, 10=X, 40=XL, 50=L, 90=XC, 100=C, 400=CD, 500=D, 1000=M ***
    -----------------------------------------------------------------------------------*/
    public static String decimalNum(int dec, String one, String five, String ten){

        //Double decimalInput = decimal;
        switch (dec) {
            case 1:
                return one;
            case 2:
                return one + one;
            case 3:
                return one + one + one;
            case 4:
                return one + five;
            case 5:
                return five;
            case 6:
                return five + one;
            case 7:
                return five + one + one;
            case 8:
                return five + one + one + one;
            case 9:
                return one + ten;
            case 10:
                return ten;
            default:
                break;
        }
           
            return "";
       
    }
        public static String decToRoman(int decimal){
        
        if(decimal < 0 || decimal > 3999){
            return "This decimal is not convertable";
        }
        
        String RomOne = decimalNum(decimal%10, "I","V","X");
        decimal /= 10;
        String RomTen = decimalNum(decimal%10, "X","L","C");
        decimal /= 10;
        String RomHundred = decimalNum(decimal%10, "C","D","M");
        decimal /= 10;
        String RomThousand = decimalNum(decimal%10, "M","","");
       
        String result = RomThousand + RomHundred + RomTen + RomOne;
        return result;
    }

    @GET
    @Path("/{param}")
    public Response decimal(@PathParam("param") int decimal)
    {   
        String output = "Decimal num is: " + decimal  +"\n" + " Roman Numeral is: " + (decToRoman(decimal));
        return Response.status(200).entity(output).build();
        
    }
}
