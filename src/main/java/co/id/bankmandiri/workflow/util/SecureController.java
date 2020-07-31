package co.id.bankmandiri.workflow.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SecureController {

    public boolean checkCookie(HttpServletRequest httpServletRequest){
        boolean valid = false;
        if (httpServletRequest.getCookies() == null){
            valid = false;
        }else{
            for (Cookie cookie : httpServletRequest.getCookies()){
                if (cookie.getName().equals("token")){
                    valid = true;
                }
            }
        }
        return valid;
    }
}
