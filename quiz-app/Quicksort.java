import java.util.ArrayList;


public class Quicksort {
	
	/**
     * Sorts the users' data by score in descending order using the Quicksort algorithm.
     *
     * @param users     The list of users to be sorted
     * @param start     The starting index of the user range
     * @param end       The ending index of the user range
     */
	public static void quickSortByScore(ArrayList<User> users, int start, int end) {
		if (end - start < 1) {
			return;
		}
		
		int pivot = partitionByScore(users, start, end);
		quickSortByScore(users, start, pivot - 1);
		quickSortByScore(users, pivot +1 , end);
		
	}
	
	/**
	 * Partitions the users' data by score and returns the pivot index.
	 *
	 * @param users     The list of users to be partitioned
	 * @param start     The starting index of the partition range
	 * @param end       The ending index of the partition range
	 * @return The pivot index
	 */
	public static int partitionByScore(ArrayList<User> users, int start, int end) {
		int pivot = users.get(end).getScore();
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (users.get(j).getScore() >= pivot) {
				i = i + 1;
				swap(users, i, j);
			}
		}
		swap(users, i + 1, end);
		return i + 1;
	}
	
	/**
     * Sorts the users' data by name in alphabetical order using the Quicksort algorithm.
     *
     * @param users     The list of users to be sorted
     * @param start     The starting index of the user range
     * @param end       The ending index of the user range
     */
	public static void quickSortByName(ArrayList<User> users, int start, int end) {
		if (end - start < 1) {
			return;
		}
		
		int pivot = partitionByName(users, start, end);
		quickSortByName(users, start, pivot - 1);
		quickSortByName(users, pivot +1 , end);
		
	}
	
	/**
	 * Partitions the users' data by name and returns the pivot index.
	 *
	 * @param users     The list of users to be partitioned
	 * @param start     The starting index of the partition range
	 * @param end       The ending index of the partition range
	 * @return The pivot index
	 */
	public static int partitionByName(ArrayList<User> users, int start, int end) {
		String pivot = users.get(end).getName();
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (users.get(j).getName().compareTo(pivot) <= 0) {
				i = i + 1;
				swap(users, i, j);
			}
		}
		swap(users, i+1, end);
		return i + 1;
	}
	
	/**
	 * Swaps two elements in the user list.
	 *
	 * @param userList  The list of users
	 * @param i         The index of the first element
	 * @param j         The index of the second element
	 */
	public static void swap(ArrayList<User> userList, int i, int j) {
        User temp = userList.get(i);
        userList.set(i, userList.get(j));
        userList.set(j, temp);
    }
}
