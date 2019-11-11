/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

/**
 *
 * @author ADMIN
 */
public class Expresion {
    //Variable propiedades
    public String Left;
    public String Right;
    public String OLeft;
    public String ORight;
    private  boolean isConsequence=true;
    //constructor de clase
    public Expresion(String left,String right){
         Left = left;
         Right = right;
         OLeft = left;
         ORight = right;
    }
    //Metodos
    public String left(){
        return this.Left;
    }
    public String right(){
        return this.Right;
    }
     public String Oright(){
        return this.ORight;
    }
      public String Oleft(){
        return this.OLeft;
    }
    public boolean IsConsequence(boolean left, boolean right){
        if (!isConsequence) return false;
            if (left)
            {
                if (right)
                {
                    isConsequence = true;
                    return true;
                }
                else
                {
                    isConsequence = false;
                    return false;
                }
            }
            return true;
    }
    public boolean Result()
    {
            return isConsequence;
    }
}
