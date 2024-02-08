package fib.asw.waslab01_ss;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TweetDAO {
	private Connection conn;
	
	public TweetDAO(Connection dbcon) {
		conn = dbcon;
	}

	public List<Tweet> getAllTweets() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tweets ORDER BY twtime DESC");
			while (rs.next()) {
				Tweet tweet = new Tweet();
				tweet.setTwid(rs.getLong("twid"));
				tweet.setAuthor(rs.getString("twauthor"));
				tweet.setText(rs.getString("twtext"));
				tweet.setCreated_at(rs.getTimestamp("twtime"));
				tweets.add(tweet);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tweets;
	}

	public long insertTweet(String author, String text) throws SQLException
	// returns the id (long) of the newly created tweed, if successful.
	{
		long twid = -1;
		if (text != null && !text.equals(""))
		{
			if (author == null || author.equals("")) author ="Anonymous";
			String insert = "insert into tweets(twAUTHOR, twTEXT) values (?, ?)";
			PreparedStatement pst = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, author);
			pst.setString(2, text);
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs != null && rs.next())
				twid = rs.getLong(1);
			rs.close();
			pst.close();
		}
		return twid;
	}

	public boolean deleteTweet(int id) {
		int dts = 0;
		String delete = "delete from tweets where twID = "+id;
		try {
			Statement stmt = conn.createStatement();
			dts = stmt.executeUpdate(delete);
			stmt.close();
		}
		catch (SQLException ex) {
			System.err.println(ex.getStackTrace());
		}
		return dts > 0;
	}

}
