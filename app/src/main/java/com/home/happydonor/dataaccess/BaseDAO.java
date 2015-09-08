package com.home.happydonor.dataaccess;

import com.home.happydonor.entity.BaseTO;
import com.home.happydonor.entity.User;

import java.util.List;

/**
 * Created by amitvikramjaiswal on 21/08/15.
 */
public interface BaseDAO {

    /**
     * find all records from db.
     *
     * @return list of objects.
     */
    List<BaseTO> fetchAll();

    /**
     * finds record based on key.
     *
     * @param key key to search object.
     * @return object found. returns null if no result found.
     */
    BaseTO fetchRecordForKey(BaseTO key);

    /**
     * adds a new record to db.
     *
     * @param baseTO object to add.
     */
    void addObject(BaseTO baseTO);

    /**
     * updates an existing record.
     *
     * @param baseTO object to update (new values and the old ones).
     */
    void updateRecord(BaseTO baseTO);

    /**
     *deletes a record if match found.
     *
     * @param baseTO object to delete.
     */
    void deleteRecordForKey(BaseTO baseTO);

    /**
     *returns the related DAO class object.
     *
     * @return related class object.
     */
    Class getDAO();

}
