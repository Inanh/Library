package Library.src.logic;

import Library.src.components.AdminUser;
import Library.src.components.Users;
public class Login {

    public Login() {
    }

    private final Users user = new Users();

    public boolean isAdmin(String userName,String pass) {
        String user = AdminUser.adminMapName().get("admin");
        String p = AdminUser.adminMapPass().get("admin");

        return user.equals(userName) && p.equals(pass);
    }

    public boolean verifyParameters( String pass, String userName){

        if(userName.equals(user.getUserName()) && pass.equals(user.getPass()))
            return true;
        else
            return false;
    }
}
