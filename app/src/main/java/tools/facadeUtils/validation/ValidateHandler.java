package tools.facadeUtils.validation;

import java.security.PublicKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.facadeModule.FacadeBasic;

/**
 * Created by yym on 2018/5/23.
 */

public class ValidateHandler extends FacadeBasic{
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";

    public boolean isTrue(String pattern_str, String s){
        Pattern pattern = Pattern.compile(pattern_str);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public boolean isEmailAdress(String email_address){
        return isTrue(EMAIL_PATTERN, email_address);
    }


}
