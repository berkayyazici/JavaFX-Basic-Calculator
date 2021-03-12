package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class MainController {
	
	
	@FXML
	public TextField text; // It is text field that takes our inputs.
	public TextField result;  // It is result field that shows the result of operations.
	
	private float fnumber;  // our first number
	private long snumber;  // our second number
	private String operation; // operation symbol (like + , - , * , /)
	Calculation calculation = new Calculation(); // I created an object from Calculation class.
												//	It is for calculate the result by using first and second numbers.
	
	
	private void setNumber(String number) {  // If we click a button of numbers, the text field prints the number 
																		
		String value = text.getText();  // and it saves a digit of the number that we enter.
		text.setText(value + number);  // I used this method, because otherwise the code would be repeating itself.
	}
	
	private void setOperation(String operation) {// If we click a button of operations, the text field prints the operation symbol 
												// and it saves the operation that we are going to apply.
		String value = text.getText();
		float number = Float.parseFloat(value); // Same thing like setNumber method
		this.fnumber = number;
		text.setText("");
		result.setText(value + operation);
		this.operation = operation;
	}
	
	public void number_zero(){  // for number zero
		setNumber("0");  	    // I assigned this function to the 0 key from SceneBuilder - code section.
	}
	
	public void number_one(){ // for number one
		setNumber("1");      // I assigned this function to the 1 key from SceneBuilder - code section.
	}
	
	public void number_two(){ // for number two
		setNumber("2");		  // I assigned this function to the 2 key from SceneBuilder - code section.
	
	}

	public void number_three(){ // for number three
		setNumber("3");       // I assigned this function to the 3 key from SceneBuilder - code section.
	}
	

	public void number_four(){ // for number four
		setNumber("4");     // I assigned this function to the 4 key from SceneBuilder - code section.
	}
	
	public void number_five(){ // for number five
		setNumber("5"); 	// I assigned this function to the 5 key from SceneBuilder - code section.
	}
	
	public void number_six(){ // for number six
		setNumber("6"); 	// I assigned this function to the 6 key from SceneBuilder - code section.
	}

	public void number_seven(){ // for number seven
		setNumber("7"); 		// I assigned this function to the 7 key from SceneBuilder - code section.
	}
	
	public void number_eight(){ // for number eight
		setNumber("8"); 		// I assigned this function to the 8 key from SceneBuilder - code section.
	}
	
	public void number_nine(){ // for number nine
		setNumber("9"); 	// I assigned this function to the 9 key from SceneBuilder - code section.
	}
	
	public void operation_sum(){ // for sum operation
		setOperation("+");		// I assigned this function to the "+" key from SceneBuilder - code section.
	} 
	
	public void operation_minus(){ // for minus operation
		setOperation("-"); 			// I assigned this function to the "-" key from SceneBuilder - code section.
	}

	public void operation_multiply(){ // for multiply operation
		setOperation("*"); 			// I assigned this function to the "*" key from SceneBuilder - code section.
	}
	
	public void operation_divide(){ // for divide operation
		setOperation("/");			// I assigned this function to the "/" key from SceneBuilder - code section.
	}
	
	public void operation_equal(){ // for equal operation
									// I assigned this function to the "=" key from SceneBuilder - code section.
		String value = text.getText();
		this.snumber = Long.parseLong(value);
		
		try {    // We will be using try-catch block for the division by zero case.
			float final_result = calculation.calculate(fnumber,snumber,operation); // calculating the result
			result.setText(String.valueOf(final_result)); // then it prints the result to the result field
			String old_result = result.getText(); // We keep the number in the result field to use the result we obtained in the ongoing operations.
			text.setText(old_result); // It prints the old result that we obtained before. Then we can use that result in the ongoing operations.
		}
		
		catch (ArithmeticException exception){  
			Alert alert = new Alert(AlertType.INFORMATION); // Our error message box
			alert.setTitle("ERROR !");
			alert.setHeaderText("You can't divide the number by zero");
			alert.showAndWait();	// It shows the error message box.
			text.setText("");  // We assign blank to text and result fields.
			result.setText(""); // After we get the error, the calculator is like starting over. We enter 2 numbers again.
		}
	}
	
	public void operation_clear(){ // After we press C (clear) button, we assign blank to text field, 0 to result field.
		text.setText("");  		  
		result.setText("0");
		this.fnumber = 0;  // Also we assign 0 as first and second numbers.
		this.snumber = 0;

	}

}
