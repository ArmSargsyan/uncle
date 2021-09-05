package todo;

import todo.manager.ToDoManager;
import todo.manager.UserManager;
import todo.model.ToDo;
import todo.model.ToDoStatus;
import todo.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ToDoMain implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    public static UserManager userManager = new UserManager();
    public static ToDoManager todoManager = new ToDoManager();
    private static User currentUser = null;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            Commands.printMainCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                case LOGIN:
                    loginUser();
                    break;
                case REGISTER:
                    registerUser();
                    break;
            }
        }
    }

    private static void registerUser() {
        System.out.println("Please input user data " +
                "name,surname,email,password");
        try {
            String userDataStr = scanner.nextLine();
            String[] userDataArr = userDataStr.split(",");
            User userFromStorage = userManager.getByEmail(userDataArr[2]);
            if (userFromStorage == null) {
                User user = new User();
                user.setName(userDataArr[0]);
                user.setSurname(userDataArr[1]);
                user.setEmail(userDataArr[2]);
                user.setPassword(userDataArr[3]);

                userManager.register(user) ;{
                    System.out.println("Users added");
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong Data");
        }
    }

    private static void loginUser() {
        System.out.println("Please input email, password");
        try {
            String loginStr = scanner.nextLine();
            String[] loginArr = loginStr.split(",");
            User user = userManager.getByEmailAndPassword(loginArr[0], loginArr[1]);
            if (user != null) {
                currentUser = user;
                loginSuccess();
            } else {
                System.out.println("wrong email or password");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("WRONG data!");
        }
    }

    private static void loginSuccess() {
        System.out.println("Welcome " + currentUser + " !");
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_NEW_TODO:
                    addNewTodo();
                    break;
                case MY_ALL_LIST:
                    printToDos(todoManager.getAllTodosByUser(currentUser.getId()));
                    break;
                case MY_TODO_LIST:
                    printToDos(todoManager.getAllTodosByUserAndStatus(currentUser.getId(), ToDoStatus.TODO));
                    break;
                case MY_IN_PROGRESS_LIST:
                    printToDos(todoManager.getAllTodosByUserAndStatus(currentUser.getId(), ToDoStatus.IN_PROGRESS));
                    break;
                case MY_FINISHED_LIST:
                    printToDos(todoManager.getAllTodosByUserAndStatus(currentUser.getId(), ToDoStatus.FINISHED));
                    break;
                case CHANGE_TODO_STATUS:
                    changeTodoStatus();
                    break;
                case DELETE_TODO:
                    deleteTodo();
                    break;

            }
        }
    }

    private static void printToDos(List<ToDo> allTodosByUser) {

        for (ToDo toDo : allTodosByUser) {
            System.out.println(toDo);
        }
    }

    private static void addNewTodo() {
        System.out.println("Please input title, deadline(yyyy-MM-dd HH:mm:ss)");
        String toDoDataStr = scanner.nextLine();
        String[] split = toDoDataStr.split(",");
        ToDo todo = new ToDo();
        try {
            String title = split[0];
            todo.setTitle(title);
            try {
                if (split[1] != null) {
                    try {
                        todo.setDeadline(sdf.parse(split[1]));
                    }catch (IndexOutOfBoundsException e){
                    } catch (ParseException e) {
                        System.out.println("Please input yyyy-MM-dd HH:mm:ss");
                    }
                }
            } catch (IndexOutOfBoundsException e){
            }
            todo.setStatus(ToDoStatus.TODO);
            todo.setUser(currentUser);
            if (todoManager.create(todo)) {
                System.out.println("todo was added");
            }else {
                System.out.println("something wos wrong");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("wrong data");
        }
    }

    private static void deleteTodo() {
        System.out.println("Please choose todo from list:");
        List<ToDo> list  = todoManager.getAllTodosByUser(currentUser.getId());
        for (ToDo toDo : list) {
            System.out.println(toDo);
        }
        long id = Long.parseLong(scanner.nextLine());
        ToDo byId = todoManager.getById(id);
        if (byId.getUser().getId() == currentUser.getId()){
            todoManager.delete(id);
        }else {
            System.out.println("Wrong id");
        }
    }

    private static void changeTodoStatus() {
        System.out.println("Please choose todo from list:");
        List<ToDo> list  = todoManager.getAllTodosByUser(currentUser.getId());
        for (ToDo toDo : list) {
            System.out.println(toDo);
        }
        long id = Long.parseLong(scanner.nextLine());
        ToDo byId = todoManager.getById(id);
        if (byId.getUser().getId() == currentUser.getId()){
            System.out.println("Please choose Status");
            System.out.println(Arrays.toString(ToDoStatus.values()));
            ToDoStatus status = ToDoStatus.valueOf(scanner.nextLine());
            if(todoManager.update(id,status)){
                System.out.println("Status was changed");
            }else {
                System.out.println("something went wrong");
            }
        }else {
            System.out.println("Wrong id");
        }
    }
}
