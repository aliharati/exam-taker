import java.util.Scanner;

/**
 * The Question class represents a basic question with an ID and question text.
 */
public class Question {
    private int id;
    private String questionText;

    /**
     * Constructs a Question object with the specified ID and question text.
     *
     * @param id           The ID of the question
     * @param questionText The text of the question
     */
    public Question(int id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    /**
     * Returns the text of the question.
     *
     * @return The question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Returns the ID of the question.
     *
     * @return The question ID
     */
    public int getId() {
        return id;
    }

    /**
     * Creates a new Question object by prompting the user to enter the question details.
     *
     * @param scanner The Scanner object to read user input
     * @return The created Question object
     */
    public static Question createQuestion(Scanner scanner) {     
        int id = -1;
        while (id < 0) {
            try {
            	System.out.print("Enter question ID: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id < 0) {
                	System.out.println("Invalid ID, please enter a positive value.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a numeric value.");
            }
        }

        System.out.println();
        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();
        while (questionText.trim().isEmpty() || isNumeric(questionText)) {
            System.out.println("Invalid question text. Please enter a non-empty text that is not a numeric value.");
            System.out.print("Enter question text: ");
            questionText = scanner.nextLine();
        }
        System.out.println();

        return new Question(id, questionText);
    }

    /**
     * Checks whether a given string is numeric.
     *
     * @param str The string to check
     * @return true if the string is numeric, false otherwise
     */
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Prints the question text.
     */
    public void printQuestion() {
        System.out.println(questionText);
    }

    /**
     * Prints detailed information about the question.
     */
    public void printQuestionInfo() {
        System.out.println("ID: " + id + " | Question: " + questionText);
        System.out.println();
    }
}
