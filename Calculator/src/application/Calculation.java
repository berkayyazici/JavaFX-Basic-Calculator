package application;

public class Calculation {
	
	
	public float calculate(float number1, long number2, String operation) { 
		
		// This class will be using for calculation. We will call this method in Controller class.
		// When we do basic	arithmetic	calculations such as sum, subtraction, multiplication and division.
		// We assigned this method as float.													  
		// Because we might get decimal numbers for the result.
		// We can't divide the number by 0. So, if we try to divide by 0, it gives 0 as a result.
		
		
		if(operation=="+") {   // Sum operation
			return number1 + number2;
		}
		
		else if(operation=="-") {  // Minus operation
			return number1 - number2;
		}
		
		else if(operation=="*") {  // Multiply operation
			return number1 * number2;
		}
		
		else if(operation=="/") {  // Division operation
								  // It gives error when we try to divide the number by 0.
			if (number2== 0) {
				throw new ArithmeticException(); // If our operation symbol is "/" and our second number is 2,
												// then it throws Arithmetic Exception.
			}
			return number1/number2; 
		}
	
		else {
			return 0;
		}
		
	}

}
