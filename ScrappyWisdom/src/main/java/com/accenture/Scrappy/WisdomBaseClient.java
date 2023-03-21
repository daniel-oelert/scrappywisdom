package com.accenture.Scrappy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WisdomBaseClient {
    public int postToWisdomBase(Connection connection, String content, long id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO posts (post_content,mastodon_id) VALUES (?,?)");
        preparedStatement.setString(1, content);
        preparedStatement.setLong(2,id);
        return preparedStatement.executeUpdate();
    }

    public List<MastodonPost> getStats(Connection conn) {
        List<MastodonPost> entries = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT * FROM `wisdombase`.`posts`");
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                entries.add(new MastodonPost(resultSet.getLong(3),resultSet.getString(2)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entries;
    }
}
