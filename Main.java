/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2;


/**
 *
 * @author Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        

        byte[][] b = { { 2 ,  3,  4, 5} ,
                       { 1 ,  3, 14, 6} , 
                       {12,  11, 15, 0} , 
                       {10,   9,  8, 7} };
                
        NoSolucao noRaiz = new NoSolucao(b);

        System.err.println(noRaiz.getPecasForaDoLugar());

    }

}
