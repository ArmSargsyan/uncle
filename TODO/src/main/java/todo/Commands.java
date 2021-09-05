package todo;

public interface Commands {

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;

    int LOGOUT = 0;
    int ADD_NEW_TODO = 1;
    int MY_ALL_LIST = 2;
    int MY_TODO_LIST = 3;
    int MY_IN_PROGRESS_LIST = 4;
    int MY_FINISHED_LIST = 5;
    int CHANGE_TODO_STATUS = 6;
    int DELETE_TODO = 7;

    static void printMainCommands() {
        System.out.println("please input " + EXIT + " for EXIT ");
        System.out.println("please input " + LOGIN + " for LOGIN ");
        System.out.println("please input " + REGISTER + "  for REGISTER");
    }

    static void printUserCommands() {
        System.out.println("please input " + LOGOUT + " for LOGOUT ");
        System.out.println("please input " + ADD_NEW_TODO + " for ADD_NEW_TODO ");
        System.out.println("please input " + MY_ALL_LIST + " for MY_ALL_LIST ");
        System.out.println("please input " + MY_TODO_LIST + " for  MY_TODO_LIST");
        System.out.println("please input "  + MY_IN_PROGRESS_LIST + " for MY_IN_PROGRESS_LIST ");
        System.out.println("please input " + MY_FINISHED_LIST + " for MY_FINISHED_LIST ");
        System.out.println("please input " + CHANGE_TODO_STATUS + " for CHANGE_TODO_STATUS ");
        System.out.println("please input " + DELETE_TODO + " for  DELETE_TODO");
    }
}
