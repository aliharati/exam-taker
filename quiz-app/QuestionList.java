import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuestionList {
	private ArrayList<MultipleChoiceQuestion> questions;
	
	/**
	 * Constructs an empty QuestionList object.
	 */
	public QuestionList() {
	    questions = new ArrayList<>();
	}

	/**
	 * Constructs a QuestionList object with the specified list of questions.
	 *
	 * @param questions The list of questions to initialize the QuestionList
	 */
	public QuestionList(ArrayList<MultipleChoiceQuestion> questions) {
	    this.questions = questions;
	}

	/**
	 * Sets the list of questions.
	 *
	 * @param newQuestions The new list of questions
	 */
	public void setQuestions(ArrayList<MultipleChoiceQuestion> newQuestions) {
	    questions = newQuestions;
	}

	/**
	 * Creates the question list by prompting the user to enter questions.
	 *
	 * @param scanner       Scanner object to read user input
	 * @param minimumAmount The minimum number of questions to create
	 */
	public void createQuestionList(Scanner scanner, int minimumAmount) {
	    while (questions.size() < minimumAmount - 1) {
	        System.out.println("Question " + (questions.size() + 1) + ":");
	        addQuestionToList(scanner);
	    }
	    String moreQuestions = "yes";

	    do {
	        System.out.println("Question " + (questions.size() + 1) + ":");
	        addQuestionToList(scanner);
	        System.out.println("Do you want to add another question? ");
	        moreQuestions = scanner.nextLine();
	    } while (moreQuestions.equalsIgnoreCase("yes"));
	}

	/**
	 * Adds a question to the question list after validating its uniqueness.
	 *
	 * @param scanner Scanner object to read user input
	 */
	public void addQuestionToList(Scanner scanner) {
	    MultipleChoiceQuestion newQuestion = MultipleChoiceQuestion.createQuestion(scanner);
	    boolean validQuestion = false;
	    while (!validQuestion) {
	        if (questionIsValid(newQuestion)) {
	            questions.add(newQuestion);
	            validQuestion = true;
	        } else {
	            System.out.println("Question id or text already exists. Please try again.");
	            newQuestion = MultipleChoiceQuestion.createQuestion(scanner);
	        }
	    }
	}

	/**
	 * Checks if a question is valid by ensuring its id and text are unique.
	 *
	 * @param newQuestion The question to validate
	 * @return true if the question is valid, false otherwise
	 */
	public boolean questionIsValid(MultipleChoiceQuestion newQuestion) {
	    for (MultipleChoiceQuestion question : questions) {
	        if (question.getId() == newQuestion.getId() || question.getQuestionText().equals(newQuestion.getQuestionText())) {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * Shuffles and retrieves a question from the question list that hasn't been asked before.
	 *
	 * @param askedQuestions List of previously asked question IDs
	 * @return A shuffled question object
	 */
	public MultipleChoiceQuestion questionShuffle(ArrayList<Integer> askedQuestions) {
	    Random random = new Random();
	    
	    while (true) {
	        int index = random.nextInt(questions.size());
	        MultipleChoiceQuestion newQuestion = questions.get(index);

	        if (!askedQuestions.contains(newQuestion.getId())) {
	            askedQuestions.add(newQuestion.getId());
	            newQuestion.shuffleAnswers();
	            return newQuestion;
	        }
	    }
	}

	/**
	 * Adds a question to the question list.
	 *
	 * @param question The question to add
	 */
	public void addQuestionToList(MultipleChoiceQuestion question) {
	    questions.add(question);
	}

	/**
	 * Searches questions by text and displays the matching questions.
	 *
	 * @param scanner Scanner object to read user input
	 */
	public void searchQuestionsByWord(Scanner scanner) {
	    System.out.print("Enter text to search: ");
	    String searchWord = scanner.nextLine();
	    boolean wordFound = false;
	    for (MultipleChoiceQuestion question : questions) {
	        if (question.getQuestionText().toLowerCase().contains(searchWord.toLowerCase())) {
	            question.printQuestionInfo();
	            wordFound = true;
	        }
	    }
	    if (!wordFound) {
	        System.out.println("Question not found");
	    }
	}

	/**
	 * Searches questions by ID and displays the matching questions.
	 *
	 * @param scanner Scanner object to read user input
	 */
	public void searchQuestionsById(Scanner scanner) {
	    System.out.print("Enter question ID to search: ");
	    boolean idFound = false;
	    try {
	        int searchId = Integer.parseInt(scanner.nextLine());

	        for (MultipleChoiceQuestion question : questions) {
	            if (question.getId() == searchId) {
	                idFound = true;
	                question.printQuestionInfo();
	            }
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("ID should be an integer.");
	    }
	    if (!idFound) {
	        System.out.println("Question not found");
	    }
	}
	
	/**
     * Clears the question list, list of asked questions, and the user list.
     */
	public void clear() {
		questions.clear();
	}
}
