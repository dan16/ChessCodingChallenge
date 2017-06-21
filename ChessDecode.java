import java.util.Scanner;

public class ChessDecode {
    public static void main(String[] args) {
        String outputString = "";
        boolean errorFound = false;
        String errorMessage= "";

        System.out.println("Please enter a valid chess string");
        Scanner input = new Scanner(System.in);
        //Stores the chess string input
        String answer = input.nextLine();
        //Checks the correct amount of rows are in the input string
        if( countCharacter(answer, "/".charAt(0))!=7){
            errorFound = true;
            errorMessage= "Error: Invalid amount of rows";
        }else {
            int rowCharacterCount = 0;
            for (int i = 0; i < answer.length(); i++) {
                String tempCharacter = answer.charAt(i) + "";
                if (tempCharacter.equals("/")) {
                    //Checks a row has the right amount of characters
                    if (rowCharacterCount < 8) {
                        errorFound = true;
                        errorMessage = "Error: A row contains not enough characters";
                    }
                    outputString = outputString + "\n";
                    rowCharacterCount = 0;
                } else if (tempCharacter.matches("^[0-9]*$")) {
                    //Loops and adds empty spaces based on number
                    for (int i1 = 0; i1 < Integer.parseInt(tempCharacter); i1++) {
                        outputString = outputString + ".";
                        rowCharacterCount++;
                    }
                } else {
                    //Checks only valid characters are used
                    if (!tempCharacter.matches("[KkQqRrBbNnPp]")) {
                        errorFound = true;
                        errorMessage = "Error: Invalid character entered";
                    }
                    outputString = outputString + tempCharacter;
                    rowCharacterCount++;
                }
                //Checks that a row contains less than 8 characters
                if (rowCharacterCount > 8) {
                    errorFound = true;
                    errorMessage = "Error: A row contains too many characters";
                }
            }
            //Checks the final row of the chess board
            if (rowCharacterCount < 8) {
                errorFound = true;
                errorMessage = "Error: A row contains not enough characters";
            }
        }
        //If an error has been found with the user input then return the error, else display the chess board
        if(!errorFound) {
            System.out.println(outputString);
        }else{
            System.out.println(errorMessage);
        }
    }
    //Used to count the number of a specific character which appears
    public static int countCharacter(String s, char c) {
        return s.length()==0 ? 0 : (s.charAt(0)==c ? 1 : 0) + countCharacter(s.substring(1),c);
    }
}
