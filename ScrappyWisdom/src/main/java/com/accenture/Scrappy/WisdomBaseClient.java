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

}
