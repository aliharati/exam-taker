import java.util.ArrayList;

public class UserTest {
	
	
    public static ArrayList<User> giveUserList() {
        // Create a list of users
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("Ali", 20);
        User user2 = new User("zara", 10);
        User user3 = new User("d", 30);
        User user4 = new User("h", 0);
        
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        
        return users;

            }
}