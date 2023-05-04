package Library.src.components;

import java.util.HashMap;
import java.util.Map;

public class AdminUser extends Users {

    public AdminUser(){}

    public static Map<String,String> adminMapName(){

        HashMap<String, String> adminUserName = new HashMap<String, String>();
        adminUserName.put("admin", "admin");

        return adminUserName;
    }

    public static Map<String,String> adminMapPass(){

        HashMap<String, String> adminUserPass = new HashMap<String, String>();
        adminUserPass.put("admin", "admin");

        return adminUserPass;
    }

}

