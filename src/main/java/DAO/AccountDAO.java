package DAO;

import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    
    //login
    Account login(String userName, String password)
    {
        Connection newConnection = ConnectionUtil.getConnection();

        String request = "SELECT * FROM Account WHERE username = ? AND password = ?;";

        try {
            PreparedStatement preparedStatement = newConnection.prepareStatement(request);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2,password);
        } catch(SQLException e){

        }
        return null;
    }

    //creat account
    Account insertAccount(Account newAccount)
    {
        return null;
    }
}
