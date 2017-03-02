package fr.amrane.amranetest.utils;

import java.util.Map;

import fr.amrane.amranetest.account.model.User;

/**
 * Created by aaitzeouay on 01/03/2017.
 */

public class ConvertJsonToModel {
    public User convertJsonToUser(Map<String, Object> json){
        User user = new User();
        user.setId((Long) json.get("id"));
        return user;
    }
}
