package com.home.happydonor.dataaccess;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.Map;
import java.util.Set;

/**
 * Created by amitvikramjaiswal on 21/08/15.
 */
public abstract class BaseDAOImpl implements BaseDAO {
    @Override
    public void fetchAll(String pTable, FindCallback pFindCallback, String... includeKeys) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(pTable);
        for (String key : includeKeys) {
            query.include(key);
        }
        query.findInBackground(pFindCallback);
    }

    @Override
    public void fetchRecordForKeys(String pTable, Map<String, Object> pMap, GetCallback<ParseObject> pGetCallback, String... includeKeys) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(pTable);
        Set<String> keys = pMap.keySet();
        for (String key : keys) {
            query.whereEqualTo(key, pMap.get(key));
        }
        for (String key : includeKeys) {
            query.include(key);
        }
        query.getFirstInBackground(pGetCallback);
    }

    @Override
    public void fetchRecordsForKeys(String pTable, Map<String, Object> pMap, FindCallback<ParseObject> pFindCallback, String... includeKeys) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(pTable);
        Set<String> keys = pMap.keySet();
        for (String key : keys) {
            query.whereEqualTo(key, pMap.get(key));
        }
        for (String key : includeKeys) {
            query.include(key);
        }
        query.findInBackground(pFindCallback);
    }

    @Override
    public void addObject(ParseObject parseObject, SaveCallback pSaveCallback) {

    }

    @Override
    public void deleteRecordForKey(ParseObject parseObject, DeleteCallback pDeleteCallback) {

    }

    @Override
    public abstract Class getDAO();

}
