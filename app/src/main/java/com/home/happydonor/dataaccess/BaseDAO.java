package com.home.happydonor.dataaccess;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.Map;

/**
 * Created by amitvikramjaiswal on 21/08/15.
 */
public interface BaseDAO {

    /**
     * find all records from db.
     *
     * @param pTable        the table name to query.
     * @param pFindCallback callback method that will be invoked after fetch.
     * @param includeKeys   column(pointer) names to include in result.
     */
    void fetchAll(String pTable, FindCallback<ParseObject> pFindCallback, String... includeKeys);

    /**
     * finds record based on key.
     *
     * @param pTable       the table name to query.
     * @param pMap         key value pairs to match in query.
     * @param pGetCallback callback method that will be invoked after fetch is complete.
     * @param includeKeys  column(pointer) names to include in result.
     */
    void fetchRecordForKeys(String pTable, Map<String, Object> pMap, GetCallback<ParseObject> pGetCallback, String... includeKeys);

    /**
     * finds list of records based on keys.
     *
     * @param pTable        the table name to query.
     * @param pMap          key value pairs to match in query.
     * @param pFindCallback callback method that will be invoked after fetch is complete.
     * @param includeKeys   column(pointer) names to include in result.
     */
    void fetchRecordsForKeys(String pTable, Map<String, Object> pMap, FindCallback<ParseObject> pFindCallback, String... includeKeys);

    /**
     * adds a new record to db.
     *
     * @param parseObject   object to add.
     * @param pSaveCallback callback method that will be invoked after adding the object.
     */
    void addObject(ParseObject parseObject, SaveCallback pSaveCallback);

    /**
     * deletes a record if match found.
     *
     * @param parseObject     object to delete.
     * @param pDeleteCallback callback method that will be invoked after deleting.
     */
    void deleteRecordForKey(ParseObject parseObject, DeleteCallback pDeleteCallback);

    /**
     * returns the related DAO class object.
     *
     * @return related class object.
     */
    Class getDAO();

}
