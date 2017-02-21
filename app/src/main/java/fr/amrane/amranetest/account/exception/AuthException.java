package fr.amrane.amranetest.account.exception;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class AuthException extends Exception{
    public AuthException(){
        // empty constructor
    }

    public AuthException(String msg){
        super(msg);
    }

    public AuthException(Exception e){
        super(e);
    }
}
