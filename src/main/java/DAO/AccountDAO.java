package DAO;

import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    
    //login
    public Account login(String userName, String password)
    {
        Connection newConnection = ConnectionUtil.getConnection();

        String request = "SELECT * FROM Account WHERE username = ? AND password = ?;";

        try {
            PreparedStatement preparedStatement = newConnection.prepareStatement(request);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2,password);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            Account returnAccount = new Account(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"));

            return returnAccount;
        } catch(SQLException e){

        }
        return null;
    }

    //creat account
    public Account insertAccount(Account newAccount)
    {
        Connection newConnection = ConnectionUtil.getConnection();

        String request = "INSERT INTO Account(username, password) values(?, ?);";

        try {
            PreparedStatement preparedStatement = newConnection.prepareStatement(request);

            preparedStatement.setString(1, newAccount.getUsername());
            preparedStatement.setString(2, newAccount.getPassword());

            preparedStatement.executeUpdate();

            return login(newAccount.getUsername(), newAccount.getPassword());
        } catch (SQLException e)
        {

        }

        return null;
    }

    public Boolean isIn(String userCheck)
    {
        Connection newConnection = ConnectionUtil.getConnection();

        String request = "SELECT * FROM Message;";

        try{
            PreparedStatement newStatment = newConnection.prepareStatement(request);
            ResultSet rs = newStatment.executeQuery();

            while(rs.next())
            {
                if(userCheck.equals(rs.getString("username")))
                {
                    return true;
                }
            }
        } catch (SQLException e) {

        }
        return false;
    }
}
