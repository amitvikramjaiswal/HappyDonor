package com.home.happydonor.dataaccess;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Created by amitvikramjaiswal on 21/08/15.
 */
public abstract class BaseDAOImpl implements BaseDAO {
    @Override
    public void fetchAll(String pTable, FindCallback pFindCallback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(pTable);
        query.findInBackground(pFindCallback);
    }

    @Override
    public void fetchRecordForKey(String pTable, String pKey, String pValue, GetCallback<ParseObject> pGetCallback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(pTable);
        query.whereEqualTo(pKey, pValue);
        query.getFirstInBackground(pGetCallback);
    }

    @Override
    public void addObject(ParseObject parseObject, SaveCallback pSaveCallback) {

    }

    @Override
    public void updateRecord(ParseObject parseObject, GetCallback<ParseObject> pGetCallback, SaveCallback pSaveCallback) {

    }

    @Override
    public void deleteRecordForKey(ParseObject parseObject, DeleteCallback pDeleteCallback) {

    }

    @Override
    public abstract Class getDAO();

}
