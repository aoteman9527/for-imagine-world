package com.imagine.world.crawler.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuanlhd on 12/10/14.
 */
public class SqliteDAO {
    private static Connection c = null;
    private static final String JDBC_URL = "jdbc:sqlite:crawler.db";// this must be a symlink

    public SqliteDAO(){
        Statement stmt = null;
        if(c==null)
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(JDBC_URL);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS CHAPTERS " +
                    "( ID INTEGER PRIMARY KEY ," +
                    " link           TEXT    NOT NULL UNIQUE," +
                    " title           TEXT    NOT NULL" +
                    " )";
            stmt.executeUpdate(sql);
            stmt.close();
//            c.close();//Do not close connection it is used long app lifetime
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public void insertChapter(String link, String title) throws SQLException {
        Statement stmt = c.createStatement();
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO CHAPTERS (link,title) ");
        sb.append(String.format("VALUES ('%s','%s')", link, title));
        stmt.executeUpdate(sb.toString());
        stmt.close();

    }

    public List<String> findChapterByLink(String link) throws SQLException {
        Statement stmt = c.createStatement();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT link FROM CHAPTERS ");
        sb.append(String.format(" WHERE link='%s' ", link));
        ResultSet rs = stmt.executeQuery(sb.toString());
        List<String> linkList = new ArrayList<String>(1);
        while (rs.next()) {
            linkList.add(rs.getString("link"));
        }
        stmt.close();
        return linkList;
    }
}
