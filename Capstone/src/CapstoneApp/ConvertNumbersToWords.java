package CapstoneApp;

import javax.swing.JOptionPane;

public class ConvertNumbersToWords {
	public ConvertNumbersToWords() {

		String userInput;
		String numberConvertedToWords = "";
		String theDecimal = null;
		int intDecimal;
		
		while (true)
		{
			//Gets the user input
			userInput = obtainUserInput();
			if (userInput == null)
			{
				JOptionPane.showMessageDialog(null, "bad input");
				continue;
			}

			//If input is negative add the word minus
			numberConvertedToWords = dealWithSign(userInput);

			//Remove the signs
			userInput = removeSign(userInput);

			//Get the number after the decimal point if there is one
			if (userInput.length() >1 && userInput.contains("."))
				theDecimal= separateDecimalDigit(userInput);

			//Get all of the numbers before the decimal
			if(userInput.contains("."))
			{
				int decimalLocation = userInput.indexOf('.');
				userInput = userInput.substring(0, decimalLocation);
			}


			int n = Integer.parseInt(userInput);
			String Decimal = "";
			String Ones = "";
			String Tens = "";
			String Hundreds = "";
			String Thousands = "";
			String tenThousand = "";
			String hundredThousand = "";
			int count = 0;
			//Reads each number one at a time from right to left
			while (n > 0) {
				count++;
				int x = n % 10;
				n = n / 10;
				//Conditional statement based on positioning in the array for example if the second digit is being read its in the tens place
				if (count == 1) {
					Ones = convertOnes(x);
				} else if (count == 2) {
					Tens = convertTens(x);
				} else if (count == 3) {
					Hundreds = convertHundreds(x);
				} else if (count == 4) {
					Thousands = convertThousands(x);
				} else if (count == 5) {
					tenThousand = convertTenThousands(x);
				} else if (count == 6) {
					hundredThousand = convertHundredThousands(x);
				} else {
					JOptionPane.showMessageDialog(null, "too many digits");
				}
			}
			//Combine text for everything larger than the tens place
			numberConvertedToWords += hundredThousand + tenThousand + Thousands + Hundreds;
			if (Tens.equals("ten ")) {
				//Special case for when the number is in the teens place
				if (Ones.equals("one")) {
					numberConvertedToWords += "eleven";
				} else if (Ones.equals("two ")) {
					numberConvertedToWords += "twelve";
				} else if (Ones.equals("three ")) {
					numberConvertedToWords += "thirteen";
				} else if (Ones.equals("four ")) {
					numberConvertedToWords += "fourteen";
				} else if (Ones.equals("five ")) {
					numberConvertedToWords += "fifteen";
				} else if (Ones.equals("six ")) {
					numberConvertedToWords += "sixteen";
				} else if (Ones.equals("seven ")) {
					numberConvertedToWords += "seventeen";
				} else if (Ones.equals("eight ")) {
					numberConvertedToWords += "eightteen";
				} else if (Ones.equals("nine ")) {
					numberConvertedToWords += "ninteen";
				} else {
					numberConvertedToWords += "ten";
				}

			} else {
				//Adds text for the tens and ones place if there is no teen case
				numberConvertedToWords += Tens + Ones;
			}
			//Adds the decimal if there is one
			if (theDecimal != null) {
				intDecimal = Integer.parseInt(theDecimal);
				Decimal = convertOnes(intDecimal);
				if(!Decimal.equals("")) {
					numberConvertedToWords += "point " + Decimal;
				}
			}
			JOptionPane.showMessageDialog(null, numberConvertedToWords);
		}
	}
	// converts numbers in the ones place
	public String convertOnes(int n) {
		String tempString = "";
		if (n == 1) {
			tempString = tempString + "one ";
			n = 0;
		} else if (n == 2) {
			tempString = tempString + "two ";
			n = 0;
		} else if (n == 3) {
			tempString = tempString + "three ";
			n = 0;
		} else if (n == 4) {
			tempString = tempString + "four ";
			n = 0;
		} else if (n == 5) {
			tempString = tempString + "five ";
			n = 0;
		} else if (n == 6) {
			tempString = tempString + "six ";
			n = 0;
		} else if (n == 7) {
			tempString = tempString + "seven ";
			n = 0;
		} else if (n == 8) {
			tempString = tempString + "eight ";
			n = 0;
		} else if (n == 9) {
			tempString = tempString + "nine ";
			n = 0;
		} 
		return tempString;
	}
	// converts numbers in the tens place
	public String convertTens(int n) {
		String tempString = "";
		if (n == 1) {
			tempString = tempString + "ten ";
			n = 0;
		} else if (n == 2) {
			tempString = tempString + "twenty ";
			n = 0;
		} else if (n == 3) {
			tempString = tempString + "thirty ";
			n = 0;
		} else if (n == 4) {
			tempString = tempString + "fourty ";
			n = 0;
		} else if (n == 5) {
			tempString = tempString + "fifty ";
			n = 0;
		} else if (n == 6) {
			tempString = tempString + "sixty ";
			n = 0;
		} else if (n == 7) {
			tempString = tempString + "seventy ";
			n = 0;
		} else if (n == 8) {
			tempString = tempString + "eighty ";
			n = 0;
		} else if (n == 9) {
			tempString = tempString + "ninty ";
			n = 0;
		} 
		return tempString;
	}
	// converts numbers in the hundreds place
	public String convertHundreds(int n) {
		String tempString = "";
		if (n == 1) {
			tempString = tempString + "one hundred ";
			n = 0;
		} else if (n == 2) {
			tempString = tempString + "two hundred ";
			n = 0;
		} else if (n == 3) {
			tempString = tempString + "three hundred ";
			n = 0;
		} else if (n == 4) {
			tempString = tempString + "four hundred ";
			n = 0;
		} else if (n == 5) {
			tempString = tempString + "five hundred ";
			n = 0;
		} else if (n == 6) {
			tempString = tempString + "six hundred ";
			n = 0;
		} else if (n == 7) {
			tempString = tempString + "seven hundred ";
			n = 0;
		} else if (n == 8) {
			tempString = tempString + "eight hundred ";
			n = 0;
		} else if (n == 9) {
			tempString = tempString + "nine hundred ";
			n = 0;
		} 
		return tempString;
	}
	// converts numbers in the Thousands place
	public String convertThousands(int n) {
		String tempString = "";
		if (n == 1) {
			tempString = tempString + "one thousand ";
			n = 0;
		} else if (n == 2) {
			tempString = tempString + "two thousand ";
			n = 0;
		} else if (n == 3) {
			tempString = tempString + "three thousand ";
			n = 0;
		} else if (n == 4) {
			tempString = tempString + "four thousand ";
			n = 0;
		} else if (n == 5) {
			tempString = tempString + "five thousand ";
			n = 0;
		} else if (n == 6) {
			tempString = tempString + "six thousand ";
			n = 0;
		} else if (n == 7) {
			tempString = tempString + "seven thousand ";
			n = 0;
		} else if (n == 8) {
			tempString = tempString + "eight thousand ";
			n = 0;
		} else if (n == 9) {
			tempString = tempString + "nine thousand ";
			n = 0;
		} 
		return tempString;
	}
	// converts numbers in the Ten-Thousands place
	public String convertTenThousands(int n) {
		String tempString = "";
		if (n == 1) {
			tempString = tempString + "ten ";
			n = 0;
		} else if (n == 2) {
			tempString = tempString + "twenty ";
			n = 0;
		} else if (n == 3) {
			tempString = tempString + "thirty ";
			n = 0;
		} else if (n == 4) {
			tempString = tempString + "fourty ";
			n = 0;
		} else if (n == 5) {
			tempString = tempString + "fifty ";
			n = 0;
		} else if (n == 6) {
			tempString = tempString + "sixty ";
			n = 0;
		} else if (n == 7) {
			tempString = tempString + "seventy ";
			n = 0;
		} else if (n == 8) {
			tempString = tempString + "eighty ";
			n = 0;
		} else if (n == 9) {
			tempString = tempString + "ninty ";
			n = 0;
		} 
		return tempString;
	}
	// converts numbers in the Hundred-Thousands place
	public String convertHundredThousands(int n) {
		String tempString = "";
		if (n == 1) {
			tempString = tempString + "one hundred ";
			n = 0;
			// System.out.println(n);
		} else if (n == 2) {
			tempString = tempString + "two hundred ";
			n = 0;
		} else if (n == 3) {
			tempString = tempString + "three hundred ";
			n = 0;
		} else if (n == 4) {
			tempString = tempString + "four hundred ";
			n = 0;
		} else if (n == 5) {
			tempString = tempString + "five hundred ";
			n = 0;
		} else if (n == 6) {
			tempString = tempString + "six hundred ";
			n = 0;
		} else if (n == 7) {
			tempString = tempString + "seven hundred ";
			n = 0;
		} else if (n == 8) {
			tempString = tempString + "eight hundred ";
			n = 0;
		} else if (n == 9) {
			tempString = tempString + "nine hundred ";
			n = 0;
		} 
		return tempString;
	}

	private String separateDecimalDigit(String userInput)
	{
		int length = userInput.length();

		return userInput.substring(length - 1);

	}

	public String removeSign(String userInput)
	{
		if (userInput.charAt(0) == '+' || userInput.charAt(0) == '-')
			return userInput.substring(1);

		return userInput;
	}


	private String dealWithSign(String userInput)
	{
		//deal with sign
		if (userInput.charAt(0) == '+')
			return null;

		if (userInput.charAt(0) == '-')
			return "minus ";

		return null;
	}

	private String obtainUserInput()
	{
		String userInput;

		userInput = JOptionPane.showInputDialog("please input the number that I will convert   ");
		if( userInput == null) {
			System.exit(0);
		}
		// Checks that the user input is valid
		if (canBeDouble(userInput))
			return userInput;
		else
			return null;
	}

	public boolean canBeDouble(String item)
	{
		int n = 0;
		boolean hasDecimalPoint = false;

		if (item.charAt(0) == '+' || item.charAt(0) == '-')
			n++;

		for (; n < item.length(); n++)
		{
			char character = item.charAt(n);
			if (!hasDecimalPoint && character == '.')
			{
				hasDecimalPoint = true;
				continue;
			}

			// If any character other than the first isn't a digit, the input is invalid
			if (!Character.isDigit(character))
				return false;
		}

		return true;
	}

}
