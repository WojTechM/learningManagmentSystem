package com.company.dao.notUsedDao;

import com.company.dao.UserDao;
import com.company.models.users.User;

import java.util.List;

public class RegularEmployeeDao implements UserDao {
    @Override
    public void write(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public String[] toStringArray(User user) {
        return new String[0];
    }

    @Override
    public User readUserByUsernameAndPassword(String usernameGiven, String passwordGiven) {
        return null;
    }

    @Override
    public List<User> extractUsersFromListOfRecordsByRoleGiven(String roleForList) {
        return null;
    }

    @Override
    public int getLastIndex() {
        return 0;
    }


}
