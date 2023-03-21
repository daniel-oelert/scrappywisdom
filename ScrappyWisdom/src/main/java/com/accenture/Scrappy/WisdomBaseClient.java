package com.accenture.Scrappy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WisdomBaseClient {
    public int postToWisdomBase(Connection connection, String content) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO posts (post_content) VALUES (?)");
        preparedStatement.setString(1, content);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public List<String> getStats(Connection conn) {
        PreparedStatement preparedStatement = null;
        List<String> entries = new ArrayList<>();
        try {
            preparedStatement =
                    conn.prepareStatement("SELECT * FROM `wisdombase`.`posts`");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            var result = preparedStatement.executeQuery();

            while (result.next()) {
                entries.add(result.getInt(1) + " " + result.getString(2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entries;
    }
}
