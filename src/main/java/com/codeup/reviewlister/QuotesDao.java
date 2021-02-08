package com.codeup.reviewlister;
import com.codeup.reviewlister.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class QuotesDao {
    private Connection connection = null;

    public QuotesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public List<Quote> all() {
        List<Quote> quotes = new ArrayList<>();
        String query = "SELECT * FROM quotes";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                quotes.add(
                    new Quote(
                        rs.getLong("id"),
                        rs.getString("author"),
                        rs.getString("quote"),
                        rs.getLong("stars")
                    )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quotes;

    }

    public Quote random() {
        List<Quote> quotes = all();

        int randomIndex = (int) Math.floor(Math.random() * quotes.size());

        return quotes.get(randomIndex);
    }

    public void star(long id) {
        try {
            String insertQuery = "UPDATE quotes SET stars = stars + 1 WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error starring quote #" + id, e);
        }
    }
}
