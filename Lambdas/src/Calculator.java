public class Calculator {
  
    interface IntegerMath {
        int operation(int a, int b);   
    }
  
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
 
    public static void main(String... args) {
    
        Calculator myApp = new Calculator();
        
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        IntegerMath comparacion = (a, b) -> a > b ? 1 : a == b ? 0 : -1;
        IntegerMath maximo = (a, b) -> a > b ? a : b;
        
        System.out.println("Máximo de 5 y 6 = " + myApp.operateBinary(5, 6, maximo));
        
        System.out.println("Comparar 3 y 5 = " + myApp.operateBinary(3, 5, comparacion));
        
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));    
    }
}