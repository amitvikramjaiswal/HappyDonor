package com.home.happydonor.dataaccess;

import com.home.happydonor.entity.BaseTO;

import java.util.List;

/**
 * Created by amitvikramjaiswal on 21/08/15.
 */
public abstract class BaseDAOImpl implements BaseDAO {
    @Override
    public List<BaseTO> fetchAll() {
        return null;
    }

    @Override
    public BaseTO fetchRecordForKey(BaseTO key) {
        return null;
    }

    @Override
    public void addObject(BaseTO baseTO) {

    }

    @Override
    public void updateRecord(BaseTO baseTO) {

    }

    @Override
    public void deleteRecordForKey(BaseTO baseTO) {

    }

    @Override
    public abstract Class getDAO();

}
