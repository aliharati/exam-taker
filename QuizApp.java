import java.util.ArrayList;
import java.util.Scanner;


public class QuizApp {
	
	private QuestionList questions;
	private ArrayList<Integer> askedQuestions;
	private ArrayList<User> users;

	
	public QuizApp() {
		questions = new QuestionList();
		askedQuestions = new ArrayList<>();
		users = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		QuizApp quizApp = new QuizApp();
		quizApp.runQuiz();
		
		
	}
	
	/**
     * Runs the quiz application, including creating the question list,
     * allowing users to attempt the quiz, and running the admin interface.
     */
	public void runQuiz() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to quiz creator.");
		System.out.println("In order to start please enter the questions");
		questions.createQuestionList(scanner,5);
//		the line below is meant for testing it outputs a Questionlist 
//		so that we can test the class without inputing question info.
//		questions.setQuestions(QuestionTest.giveQuestionList());
		String moreUsers = "yes";
		do {
			askedQuestions.clear();
			
			System.out.print("Enter Your Name: ");
			String userName = scanner.nextLine();
			User newUser = new User(userName);
			users.add(newUser);
			
			for (int i = 0; i < 3; i++) {
				System.out.print("QUESTION " + (i + 1) + ": ");
				askQuestion(scanner, newUser);
			}
			
			System.out.print("Is there another user who wants to attempt the quiz? ");
			moreUsers = scanner.nextLine();
			  
		}while(moreUsers.equalsIgnoreCase("yes"));
		
		
		printScores("");
		printEndMessage();
		runInterface(scanner);
	}
	
	/**
     * Runs the admin interface, allowing the administrator to perform various actions
     * such as sorting users, searching questions, and restarting the quiz.
     *
     * @param scanner Scanner object to read user input
     */
	public void runInterface(Scanner scanner) {
		int arraySize = users.size();
		boolean endInterface = false;
		while (endInterface == false) {
			printOptions();
			System.out.print("Enter your option: ");
			try {
				int userChoice = Integer.parseInt(scanner.nextLine());
				System.out.println();
				switch (userChoice) {
					case 1:
						Quicksort.quickSortByScore(users, 0, arraySize - 1);
						printScores("(Users’ data sorted by score)");
						break;
					case 2:
						Quicksort.quickSortByName(users, 0, arraySize - 1);
						printScores("(Users’ data sorted by name)");
						break;
					case 3:
						questions.searchQuestionsById(scanner);
						break;
					case 4:
						questions.searchQuestionsByWord(scanner);
						break;
					case 5:
						questions.clear();
						askedQuestions.clear();
						users.clear();
						endInterface = true;
						runQuiz();
						break;
					case 0:
						System.out.println("THANK YOU FOR USING THE QUIZ APPLICATION");
						endInterface = true;
						System.exit(0);
				
					default:
						System.out.println("Invalid option. Please enter a valid option.");
						break;
				}
				
			}catch (Exception e) {
				System.out.println("please enter a number");
			}
		}
		
	}
	
	/**
     * Prints the available options for the admin interface.
     */
	public static void printOptions() {
	    System.out.println("*************************************************");
	    System.out.println("Admin Options");
	    System.out.printf("%-60s Press [1]%n", "Sort users by score");
	    System.out.printf("%-60s Press [2]%n", "Sort users by name");
	    System.out.printf("%-60s Press [3]%n", "Search the questions by ID");
	    System.out.printf("%-60s Press [4]%n", "Search the questions by text");
	    System.out.printf("%-60s Press [5]%n", "Restart the quiz");
	    System.out.printf("%-60s Press [0]%n", "To exit");
	    System.out.println("*************************************************");
	}
	
	/**
     * Asks a question to the user and checks if the answer is correct.
     *
     * @param scanner   Scanner object to read user input
     * @param user      The user attempting the quiz
     */
	public void askQuestion(Scanner scanner, User user) {
		MultipleChoiceQuestion newQuestion = questions.questionShuffle(askedQuestions);
		newQuestion.printQuestion();
		System.out.print("Enter correct option [press 1, 2 or 3]: ");
		int answer = -1;
	    while (answer < 1 || answer > 3 ) {
	    	
	        try {
	            answer = Integer.parseInt(scanner.nextLine());
	            if(answer < 1 || answer > 3) {
		    		System.out.println("Invalid answer. Please enter 1,2 or 3");
		    	}
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid answer. Please enter 1,2 or 3");
	            System.out.print("Enter correct option [press 1, 2 or 3]: ");
	        }
	    }
		System.out.println();
		if(newQuestion.validateAnswer(answer)) {
			user.addToScore(10);
			System.out.println("Right answer!");
		}else {
			System.out.println("Wrong answer!");
		}
	}
	
	
	/**
     * Prints the scores of all users in a formatted manner.
     *
     * @param message   Additional message to display along with the scores
     */
	public void printScores(String message) {
		
		int maxNameLength = 0;
		for (User user : users) {
		    maxNameLength = Math.max(maxNameLength, user.getName().length());
		}
		System.out.println("==================");
		String title = String.format("%-" + maxNameLength + "s : %s", "Name", "SCORE" + message);
		System.out.println(title);
		System.out.println("==================");
		// Print the scores with aligned notation
		for (User user : users) {
		    String name = user.getName();
		    int score = user.getScore();

		    String scoreLine = String.format("%-" + maxNameLength + "s : %d", name, score);
		    System.out.println(scoreLine);
		}
	}
	
	/**
     * Prints the end message of the quiz.
     */
	public void printEndMessage() {
		System.out.println("------------------------------");
		System.out.println("END OF THE QUIZ");
		System.out.println("------------------------------");
	}

}
