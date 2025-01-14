package ie.hotelbooking.gui;

import ie.hotelbooking.util.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.AbstractTableModel;

abstract class ResultSetTableModel extends AbstractTableModel {
    private Database database;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase;

    public ResultSetTableModel(String query) throws SQLException {
        database = new Database();
        connection = DriverManager.getConnection(database.getDatabaseURL(), database.getDatabaseUser(), database.getDatabasePassword());
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        connectedToDatabase = true;
        setQuery(query);
    }

    public void setQuery(String query) throws SQLException, IllegalStateException {
        if(!connectedToDatabase) throw new IllegalStateException("Not connected to database");
        resultSet = statement.executeQuery(query);
        metaData = resultSet.getMetaData();
        resultSet.last();
        numberOfRows = resultSet.getRow();
        fireTableStructureChanged();
    }

    public Class getColumnClass(int column) throws IllegalStateException  {
        if(!connectedToDatabase) throw new IllegalStateException("Not connected to database");
        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return Object.class;
    }

    public int getColumnCount() throws IllegalStateException {
        if(!connectedToDatabase) throw new IllegalStateException("Not connected to database");
        try {
            return metaData.getColumnCount();
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
    public int getRowCount() throws IllegalStateException {
        if(!connectedToDatabase) throw new IllegalStateException("Not connected to database");
        return numberOfRows;
    }
    public String getColumnName(int column) throws IllegalStateException {
        if(!connectedToDatabase) throw new IllegalStateException("Not connected to database");
        try {
            return metaData.getColumnName(column + 1);
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return "";
    }

    public void disconnectFromDatabase() {
        if(connectedToDatabase) {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch(SQLException sqlException) {
                sqlException.printStackTrace();
            } finally {
                connectedToDatabase = false;
            }
        }
    }
}
