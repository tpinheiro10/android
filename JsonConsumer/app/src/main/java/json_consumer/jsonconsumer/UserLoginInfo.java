package json_consumer.jsonconsumer;

/**
 * Created by thiago on 13/12/15.
 */
public class UserLoginInfo {

    private String id;
    private String name;
    private String pwd;

    public UserLoginInfo(String ID, String name, String pwd) {
        this.id = ID;
        this.name = name;
        this.pwd = pwd;
    }

    public String getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getpwd() {
        return pwd;
    }

    @Override
    public String toString(){
        return "ID: " + getid() + "\nName: " + getname() + "\nPwd: " + getpwd();
    }
}
