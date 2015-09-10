package com.home.happydonor.dataaccess;

import com.home.happydonor.entity.BaseTO;
import com.home.happydonor.entity.User;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Created by amitvikramjaiswal on 21/08/15.
 */
public interface BaseDAO {

    /**
     * find all records from db.
     *
     * @param pTable the table name to query.
     * @param pFindCallback callback method that will be invoked after fetch.
     */
    void fetchAll(String pTable, FindCallback<ParseObject> pFindCallback);

    /**
     * finds record based on key.
     *
     * @param pTable the table name to query.
     * @param pKey key to search object.
     * @param pValue value for the key.
     * @param pGetCallback callback method that will be invoked after fetch is complete.
     */
    void fetchRecordForKey(String pTable, String pKey, String pValue, GetCallback<ParseObject> pGetCallback);

    /**
     * adds a new record to db.
     *
     * @param parseObject object to add.
     * @param pSaveCallback callback method that will be invoked after adding the object.
     */
    void addObject(ParseObject parseObject, SaveCallback pSaveCallback);

    /**
     * updates an existing record.
     *
     * @param parseObject object to update (new values and the old ones).
     * @param pGetCallback callback method that will be invoked after finding the updating object.
     * @param pSaveCallback callback method that will be invoked after saving the changes.
     */
    void updateRecord(ParseObject parseObject, GetCallback<ParseObject> pGetCallback, SaveCallback pSaveCallback);

    /**
     *deletes a record if match found.
     *
     * @param parseObject object to delete.
     * @param pDeleteCallback callback method that will be invoked after deleting.
     */
    void deleteRecordForKey(ParseObject parseObject, DeleteCallback pDeleteCallback);

    /**
     *returns the related DAO class object.
     *
     * @return related class object.
     */
    Class getDAO();

}
