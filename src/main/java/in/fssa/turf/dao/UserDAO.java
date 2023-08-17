package in.fssa.turf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

import in.fssa.turf.model.UserEntity;
import in.fssa.turf.util.ConnectionUtil;

public class UserDAO {
	public Set<UserEntity> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<UserEntity> userList = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT * FROM User WHERE is_active = 1";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			userList = new HashSet<UserEntity>();
			while (rs.next()) {
				UserEntity user = new UserEntity();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmailId(rs.getString("email"));
				user.setArea(rs.getString("area"));
				user.setCity(rs.getString("city"));
				user.setActive(rs.getBoolean("is_active"));

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return userList;
	}

	
	
	
	public void create(UserEntity newUser) throws RuntimeException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int generatedId = 0;
		try {
			con = ConnectionUtil.getConnection();
			String query = "INSERT INTO User (email , password , first_name , last_name  , area , city) "
					+ "VALUES(? , ? , ? , ? , ? , ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, newUser.getEmailId());
			ps.setString(2, newUser.getPassword());
			ps.setString(3, newUser.getFirstName());
			ps.setString(4, newUser.getLastName());
			ps.setString(5, newUser.getArea());
			ps.setString(6, newUser.getCity());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("User had been created successfully");
			} else {
				throw new RuntimeException("User had not been created successfully");
			}


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	
	public void update(int id, UserEntity newUser) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "UPDATE User SET first_name = ? , last_name = ?  , area = ? , city = ? , password = ? WHERE is_active = 1 AND id = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, newUser.getFirstName());
			ps.setString(2, newUser.getLastName());
			ps.setString(3, newUser.getArea());
			ps.setString(4, newUser.getCity());
			ps.setString(5, newUser.getPassword());
			ps.setInt(6, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("User had been updated successfully");
			} else {
				throw new RuntimeException("User had not been updated successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	
	public void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "UPDATE User SET is_active = 0 WHERE id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("User had been deleted successfully");
			} else {
				throw new RuntimeException("User does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	
	public UserEntity findById(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserEntity user = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT * FROM User WHERE is_active = 1 AND id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new UserEntity();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setArea(rs.getString("area"));
				user.setCity(rs.getString("city"));
				user.setEmailId(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;
	}

	
	public UserEntity findByEmail(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserEntity user = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT * FROM User WHERE is_active = 1 AND email = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new UserEntity();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setArea(rs.getString("area"));
				user.setCity(rs.getString("city"));
				user.setEmailId(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("User already exists");
			}
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;
	}

	
}
