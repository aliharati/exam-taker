import java.util.ArrayList;

public class QuizTest {
	
	public ArrayList<User> users;

	public static void main(String[] args) {
		QuizTest test = new QuizTest();
		test.users = UserTest.giveUserList();
		test.printScores();
		
		int arraySize = test.users.size();
		System.out.println(arraySize);
		Quicksort.quickSortByName(test.users, 0, arraySize - 1);
		test.printScores();
		
		Quicksort.quickSortByScore(test.users, 0, arraySize - 1);
		test.printScores();

	}
	
public void printScores() {
		
		int maxNameLength = 0;
		for (User user : users) {
		    maxNameLength = Math.max(maxNameLength, user.getName().length());
		}
		System.out.println("==================");
		String title = String.format("%-" + maxNameLength + "s : %s", "Name", "SCORE");
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

}
