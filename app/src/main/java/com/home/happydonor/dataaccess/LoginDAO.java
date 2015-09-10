package com.home.happydonor.dataaccess;

import com.parse.ParseUser;

/**
 * Created by amitvikramjaiswal on 09/09/15.
 */
public interface LoginDAO extends BaseDAO {

    /**
     * login to the app.
     *
     * @param user ParseUser object containing username and password.
     */
    void login(ParseUser parseUser);

    /**
     * logout the user.
     *
     * @param parseUser ParseUser object that has to logout.
     */
    void logout(ParseUser parseUser);

}
