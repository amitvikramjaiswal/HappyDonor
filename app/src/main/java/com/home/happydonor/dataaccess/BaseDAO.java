package com.home.happydonor.dataaccess;

import com.home.happydonor.entity.User;

import java.util.List;

/**
 * Created by amitvikramjaiswal on 21/08/15.
 */
public interface BaseDAO {

    List<User> getAllDonors();

}
