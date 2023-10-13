public class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel model, UserView view){
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean KeepRunning = true;

        while(KeepRunning){
            view.displayMenu();
            String option = view.getInput("");

            switch(option){
                case "1":
                    createUser();
                    break;
                case "2":
                    consultUser();
                    break;
                case "3":
                    modifyUser();
                    break;
                case "4":
                    deleteUser();
                    break;
                case "5":
                    KeepRunning = false;
                    break;
                default:
                    view.showMessage("Opcion invalida");
            }
        }
        view.showMessage("Hasta pronto!");
    }

    private void createUser(){
        String username = view.getInput("Introduce el nombre de usuario: ");
        String password = view.getInput("Introduce la contraseña: ");
        String email = view.getInput("Introduce la direccion de correo electronico: ");

        model.addUser(new User(username, password, email));
        view.showMessage("Usuario creado exitosamente");
    }

    private void consultUser(){
        String username = view.getInput("Introduce el nombre de usuario a consultar: ");
        User user = model.getUserByUsername(username);
        if(user != null){
            view.printUserDetails(user);
        } else {
            view.showMessage("El usuario no existe");
        }
    }

    private void modifyUser(){
        String username = view.getInput("Introduce el nombre de usuario a modificar: ");
        User user = model.getUserByUsername(username);
        if(user != null){
           String newEmail = view.getInput("Introduce la nueva direccion de correo electronico (actual: " + user.getEmail() + "): ");
              user.setEmail(newEmail);
                view.showMessage("Usuario modificado exitosamente");
        } else {
            view.showMessage("El usuario no existe");
        }
    }

    private void deleteUser(){
        String username = view.getInput("Introduce el nombre de usuario a eliminar: ");
        User user = model.getUserByUsername(username);
        if(user != null){
            model.deleteUser(user);
            view.showMessage("Usuario eliminado exitosamente");
        } else {
            view.showMessage("El usuario no existe");
        }
    }
}
