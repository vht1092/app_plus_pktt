package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import entity.UserCW;

@Repository
public class LoginDAO extends JdbcDaoSupport {

	@Autowired
	public LoginDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public UserCW findUserLogin(String username, String password) {
		
		UserCW user = new UserCW();
		StringBuilder sqlString = new StringBuilder();
		
		sqlString 	.append("Select * from ATM_USERS where USER_USERNAME = ? and USER_PASSWORD = ?");
		
		Connection connect = getConnection();
		
		ResultSet rs;
		try {
			PreparedStatement preStmt = connect.prepareStatement(sqlString.toString());
			preStmt.setString(1, username);
			preStmt.setString(2, password);
			rs = preStmt.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString("USER_USERNAME"));
				user.setFullname(rs.getString("USER_FULLNAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				user.setUsercount(Byte.parseByte(rs.getString("USER_COUNT")));
				user.setUserLevel(rs.getString("USER_LEVEL"));

			}
			
			preStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}

	public int updatePasswordUserLogin(String username, String password) {
		String sql = "UPDATE ATM_USERS SET USER_PASSWORD = '" + password + "', USER_COUNT = 1 WHERE USER_USERNAME = '"
				+ username + "'";
		return getJdbcTemplate().update(sql);
	}
}