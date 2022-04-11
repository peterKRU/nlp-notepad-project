package client.module;

import java.util.HashMap;

public class CommandController {

    public CommandController() {

        System.out.println("CommandController running...");

    }

    public User createUser(Integer user_id, String user_name, String user_password){

        User user = new User(user_id, user_name, user_password);

        return user;

    }

}
