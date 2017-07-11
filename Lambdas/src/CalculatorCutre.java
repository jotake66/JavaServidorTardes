public class CalculatorCutre {
  
    interface IntegerMath {
        int operation(int a, int b);   
    }
  
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
 
    public static void main(String[] args) {
    
        CalculatorCutre myApp = new CalculatorCutre();
        
        IntegerMath addition = new IntegerMath() {
			
			@Override
			public int operation(int a, int b) {
				return a + b;
			}
		};
		
        IntegerMath subtraction = new Resta(); // SIN STATIC myApp.new Resta();
        
        System.out.println("40 + 3 = " +
            myApp.operateBinary(40, 3, addition));
        System.out.println("20 - 11 = " +
            myApp.operateBinary(20, 11, subtraction));    
    }
    
    public static class Resta implements IntegerMath {

		@Override
		public int operation(int a, int b) {
			return a - b;
		}
    	
    }
}