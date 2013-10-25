package amu.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import amu.Config;

public final class Database {
    
    private Database() { }

    public static Connection getConnection(String db){
        Connection connection = null;
        try {   
                switch(db){
                case "customer":
                        connection = ((DataSource) new InitialContext().lookup(Config.JDBC_RESOURCE_LOGIN)).getConnection();
                        break;
                case "book":
                        connection = ((DataSource) new InitialContext().lookup(Config.JDBC_RESOURCE_BOOK)).getConnection();
                        break;
                case "email":
                        connection = ((DataSource) new InitialContext().lookup(Config.JDBC_RESOURCE_EMAIL)).getConnection();
                        break;
                case "order":
                        connection = ((DataSource) new InitialContext().lookup(Config.JDBC_RESOURCE_ORDER)).getConnection();
                        break;
                case "opinion":
                        connection = ((DataSource) new InitialContext().lookup(Config.JDBC_RESOURCE_OPINION)).getConnection();
                default:
                        connection = ((DataSource) new InitialContext().lookup(Config.JDBC_RESOURCE)).getConnection();
                };
        } catch (NamingException exception) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Getting DataSource failed. "+db, exception);
        } catch (SQLException exception) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Opening Connection failed. "+db, exception);
        }
        return connection;      
    }
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = ((DataSource) new InitialContext().lookup(Config.JDBC_RESOURCE)).getConnection();
        } catch (NamingException exception) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Getting DataSource failed.", exception);
        } catch (SQLException exception) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Opening Connection failed.", exception);
        }
        
        return connection;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exception) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Closing Connection failed.", exception);
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Closing Statement failed.", exception);
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException exception) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Closing ResultSet failed.", exception);
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(resultSet);
        close(statement);
        close(connection);
    }
    
    public static void close(Connection connection, Statement statement) {
        close(statement);
        close(connection);
    }
}
