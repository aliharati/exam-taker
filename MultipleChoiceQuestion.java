import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The MultipleChoiceQuestion class represents a multiple-choice question, extending the base Question class.
 * It adds functionality for handling options and correct option.
 */
public class MultipleChoiceQuestion extends Question {
    private ArrayList<String> options;
    private int correctOption;

    /**
     * Constructs a MultipleChoiceQuestion object with the specified ID, question text, options, and correct option.
     *
     * @param id            The ID of the question
     * @param questionText  The text of the question
     * @param options       The list of options for the question
     * @param correctOption The index of the correct option (1-based)
     */
    public MultipleChoiceQuestion(int id, String questionText, ArrayList<String> options, int correctOption) {
        super(id, questionText);
        this.options = options;
        this.correctOption = correctOption;
        
    }

    /**
     * Shuffles the order of options for the question.
     */
    public void shuffleAnswers() {
        Random random = new Random();
        int n = options.size();
        for (int i = n - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swapAnswers(i, j);
        }
    }

    /**
     * Swaps the positions of two options in the options list and updates the correct option if necessary.
     *
     * @param i The index of the first option
     * @param j The index of the second option
     */
    public void swapAnswers(int i, int j) {
        if (correctOption == i + 1) {
            correctOption = j + 1;
        } else if (correctOption == j + 1) {
            correctOption = i + 1;
        }
        String temp = options.get(i);
        options.set(i, options.get(j));
        options.set(j, temp);
    }

    /**
     * Validates whether the provided answer matches the correct option.
     *
     * @param answer The user's answer
     * @return true if the answer is correct, false otherwise
     */
    public boolean validateAnswer(int answer) {
        return answer == correctOption;
    }

    /**
     * Creates a new MultipleChoiceQuestion object by prompting the user to enter the question details,
     * including options and correct option.
     *
     * @param scanner The Scanner object to read user input
     * @return The created MultipleChoiceQuestion object
     */
    public static MultipleChoiceQuestion createQuestion(Scanner scanner) {
        // Call the base class method to create the question
        Question question = Question.createQuestion(scanner);

        System.out.println("Enter options:");
        ArrayList<String> options = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter option " + i + ": ");
            String option = scanner.nextLine();
            while (option.trim().isEmpty() || options.contains(option)) {
                System.out.println("Invalid option. Option cannot be empty or repeated.");
                System.out.print("Enter option " + i + ": ");
                option = scanner.nextLine();
            }
            options.add(option);
            System.out.println();
        }

        int correctOption = -1;
        while (correctOption < 1 || correctOption > options.size()) {
            System.out.print("Enter correct option's number (1-" + options.size() + "): ");
            try {
                correctOption = Integer.parseInt(scanner.nextLine());
                if (correctOption < 1 || correctOption > options.size()) {
                    System.out.println("Invalid correct option. Please enter a value between 1 and " + options.size() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid correct option. Please enter a numeric value.");
            }
        }

        return new MultipleChoiceQuestion(question.getId(), question.getQuestionText(), options, correctOption);
    }
    
    /**
     * Overrides the base class method to include the options and correct option.
     */
    @Override
    public void printQuestion() {
        super.printQuestion();
        System.out.print("Options: ");
        for (int i = 1; i <= options.size(); i++) {
            System.out.print("(" + i + ") " + options.get(i - 1) + "\t");
        }
        System.out.println();
    }

    /**
     * Overrides the base class method to include the options and correct option.
     */
    @Override
    public void printQuestionInfo() {
        super.printQuestionInfo();
        for (int i = 1; i <= options.size(); i++) {
            System.out.println("Option " + i + ": " + options.get(i - 1));
        }
        System.out.println("Correct Option: " + correctOption);
        System.out.println();
    }

    
}
