/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;
/**
 *
 * @author ADMIN
 */
public class EvaluateString {
    
    public boolean evaluate(String expression,Hashtable<String, Integer> variable ){
        boolean bandera1= false;
        char[] tokens = expression.toCharArray();
        HashSet<Character> valid = new HashSet<Character>();
        Stack<Boolean> values =new Stack<Boolean>();       
        Stack<Character> ops = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i]==' '){
                continue;
            }
            if(!isOperator(tokens[i])){
                StringBuilder sbuf = new StringBuilder();
                while(i<tokens.length &&!isOperator(tokens[i])){
                    sbuf.append(tokens[i++]);
                }
                bandera1=tratadeobtenervalor(variable,sbuf.toString());
                values.push(bandera1);
                i--;
            }else if (tokens[i] == '(')
            {
                ops.push(tokens[i]);
            }
            else if (tokens[i] == ')'){
                 while (ops.peek() != '('){
                     char operator = ops.pop();
                     if (operator == '¬'){
                         values.push(applyOp(operator, values.pop()));
                     } else
                    {
                        values.push(applyOp(operator, values.pop()));
                    }
                     ops.pop(); 
                 }
            }
            else if (tokens[i] == '¬' || tokens[i] == '&' || tokens[i] == '|' || tokens[i] == '>' || tokens[i] == '='){
             while (ops.capacity() > 0 && hasPrecedence(tokens[i], ops.peek())){
                 
             }    
                ops.push(tokens[i]);
            }
        }
        while (ops.capacity() > 0 ){
            char operator = ops.pop();
            if (operator == '¬'){
                values.push(applyOp(operator, values.pop()));
            }
             else
            {
                values.push(applyOp(operator, values.pop()));
            }
        }
          return values.pop();     
    }
    HashSet<Character> GetVariables(Expresion exp){
        exp.Left = exp.Left.replace(',', '&');
        exp.Right = exp.Right.replace(',', '&');
        HashSet<Character> variables = GetVariablesFromString(exp.Left);
        variables = variables.union(GetVariablesFromString(exp.Right)).ToHashSet();
        
        return new HashSet<Character>(); 
    }
    HashSet<Character> GetVariablesFromString(String toExtract){
        
        return new HashSet<Character>();
    }
        
    
            
    public boolean tratadeobtenervalor(Hashtable<String, Integer> variable, String busqueda){
        boolean bandera = false;
        Enumeration e = variable.elements();
        Object valor;
        while( e.hasMoreElements() ){
            valor = e.nextElement();
            //System.out.println( "Valor : " + valor );
            if(valor.toString().contains(busqueda)){
                bandera=true;
                return bandera;
            }            
            
        }       
        
        return bandera;
    }
   
    public boolean isOperator(char symbol){
         switch ( symbol)
        {
            case '(':
            case ')':
            case '¬':
            case '&':
            case '|':
            case '>':
            case '=':
                return true;
            default:
                return false;
        }
    }
    public static boolean applyOp(char op, boolean a)
    {
        switch (op)
        {
            case '¬':
                return !a;
        }
        return false;
    }
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
        {
            return false;
        }
        if ((op1 == '&' || op1 == '|') && (op2 == '¬' || op2 == '>' || op2 == '='))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    
}
