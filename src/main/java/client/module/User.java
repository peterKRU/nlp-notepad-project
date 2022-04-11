package client.module;

public class User {

    Integer user_id;
    String user_name;
    String user_password;

    public User(Integer user_id, String user_name, String user_password) {

        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;

    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

}
