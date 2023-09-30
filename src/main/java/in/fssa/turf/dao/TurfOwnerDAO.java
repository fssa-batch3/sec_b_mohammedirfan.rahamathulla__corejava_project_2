package in.fssa.turf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.TurfOwner;
import in.fssa.turf.service.TurfOwnerService;
import in.fssa.turf.util.ConnectionUtil;

public class TurfOwnerDAO {
	/*
	 * 
	 * @return
	 */
	public Set<TurfOwner> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<TurfOwner> turfOwnerList = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT id, first_name, last_name, email, is_active FROM TurfOwner WHERE is_active = 1";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			turfOwnerList = new HashSet<TurfOwner>();
			while (rs.next()) {
				TurfOwner turfowner = new TurfOwner();
				turfowner.setId(rs.getInt("id"));
				turfowner.setName(rs.getString("name"));
				turfowner.setEmail(rs.getString("email"));
				turfowner.setPassword(rs.getString("password"));
				turfowner.setActive(rs.getBoolean("is_active"));

				turfOwnerList.add(turfowner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return turfOwnerList;
	}

	/**
	 * 
	 * @param newUser
	 * @throws RuntimeException
	 */
	public void create(TurfOwner newTurfOwner) throws RuntimeException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int generatedId = 0;
		try {
			con = ConnectionUtil.getConnection();
			String query = "INSERT INTO TurfOwner (name , email , password) " + "VALUES(? , ? , ? )";
			ps = con.prepareStatement(query);
			ps.setString(1, newTurfOwner.getName());
			ps.setString(2, newTurfOwner.getEmail());
			ps.setString(3, newTurfOwner.getPassword());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Turfowner had been created successfully");
			} else {
				throw new RuntimeException("Turfowner had not been created successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	/**
	 * 
	 * @param id
	 * @param newUser
	 */
	public void update(int id, TurfOwner newTurfOwner) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "UPDATE TurfOwner SET name = ? , email = ?  , password = ? WHERE is_active = 1 AND id = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, newTurfOwner.getName());
			ps.setString(2, newTurfOwner.getEmail());
			ps.setString(3, newTurfOwner.getPassword());
			ps.setInt(4, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("TurfOwner had been updated successfully");
			} else {
				throw new RuntimeException("TurfOwner had not been updated successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "UPDATE TurfOwner SET is_active = 0 WHERE id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("TurfOwner had been deleted successfully");
			} else {
				throw new RuntimeException("TurfOwner does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public TurfOwner findById(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TurfOwner turfowner = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT id, name, email, password, is_active FROM TurfOwner WHERE is_active = 1 AND id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				turfowner = new TurfOwner();
				turfowner.setId(rs.getInt("id"));
				turfowner.setName(rs.getString("name"));
				turfowner.setEmail(rs.getString("email"));
				turfowner.setPassword(rs.getString("password"));
				turfowner.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return turfowner;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public TurfOwner findByEmail(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TurfOwner turfowner = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT id, name,  email, password, is_active FROM TurfOwner WHERE is_active = 1 AND email = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				turfowner = new TurfOwner();
				turfowner.setId(rs.getInt("id"));
				turfowner.setName(rs.getString("name"));
				turfowner.setEmail(rs.getString("email"));
				turfowner.setPassword(rs.getString("password"));
				turfowner.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("turfowner already exists");
			}
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return turfowner;
	}

	public void update(int id, TurfOwnerService turfowner) {
		// TODO Auto-generated method stub
		
	}

}