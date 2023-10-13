public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        UserView view = new UserView();
        UserController controller = new UserController(model, view);
        
        controller.run();
    }
}
