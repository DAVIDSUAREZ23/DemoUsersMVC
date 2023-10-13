import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public User getUserByUsername(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public void deleteUser (User user){
        users.remove(user);
    }
}
