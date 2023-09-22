package in.fssa.turf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.Turf;
import in.fssa.turf.model.TurfEntity;
import in.fssa.turf.model.User;
import in.fssa.turf.util.ConnectionUtil;

public class TurfDAO {
/** 
 * 
 * @return
 */
	public Set<Turf> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<Turf> turfList = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT id, name, address, area, city, image, is_active, opening_hours, closing_hours FROM Turf WHERE is_active = 1";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			turfList = new HashSet<Turf>();
			while (rs.next()) {
				Turf turf = new Turf();
				turf.setId(rs.getInt("id"));
				turf.setName(rs.getString("name"));
				turf.setAddress(rs.getString("address"));
				turf.setArea(rs.getString("area"));
				turf.setCity(rs.getString("city"));
				turf.setImage(rs.getString("image"));
				turf.setActive(rs.getBoolean("is_active"));
				turf.setOpeningHours(rs.getString("opening_hours"));
				turf.setClosingHours(rs.getString("closing_hours"));

				turfList.add(turf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return turfList;
	}
  /** 
   * 
   * @param newTurf
   * @throws RuntimeException
   */
	public void create(TurfEntity newTurf) throws RuntimeException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "INSERT INTO Turf (name , address , area , city , image, opening_hours , closing_hours) VALUES(? , ? , ? , ? , ? , ? , ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, newTurf.getName());
			ps.setString(2, newTurf.getAddress());
			ps.setString(3, newTurf.getArea());
			ps.setString(4, newTurf.getCity());
			ps.setString(5, newTurf.getImage());
			ps.setString(6, newTurf.getOpeningHours());
			ps.setString(7, newTurf.getClosingHours());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Turf had been created successfully");
			} else {
				throw new RuntimeException("Turf had not been created successfully");
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
 * @param newTurf
 */
	public void update(int id, TurfEntity newTurf) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "UPDATE Turf SET name = ? , address = ? , area = ? , city = ? , opening_hours = ? , closing_hours = ? WHERE is_active = 1 AND id = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, newTurf.getName());
			ps.setString(2, newTurf.getAddress());
			ps.setString(3, newTurf.getArea());
			ps.setString(4, newTurf.getCity());
			ps.setString(5, newTurf.getOpeningHours());
			ps.setString(6, newTurf.getClosingHours());
			ps.setInt(7, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Turf had been updated successfully");
			} else {
				throw new RuntimeException("Turf had not been updated successfully");
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
			String query = "UPDATE Turf SET is_active = 0 WHERE id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Turf had been deleted successfully");
			} else {
				throw new RuntimeException("Turf does not exist");
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
	public TurfEntity findByTurfId(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TurfEntity turf = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT id, name, address, area, city, opening_hours, closing_hours, is_active , image FROM Turf WHERE is_active = 1 AND id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				turf = new TurfEntity();
				turf.setId(rs.getInt("id"));
				turf.setName(rs.getString("name"));
				turf.setAddress(rs.getString("address"));
				turf.setArea(rs.getString("area"));
				turf.setCity(rs.getString("city"));
				turf.setOpeningHours(rs.getString("opening_hours"));
				turf.setClosingHours(rs.getString("closing_hours"));
				turf.setActive(rs.getBoolean("is_active"));
				turf.setImage(rs.getString("image"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return turf;
	}
	/** 
	 * 
	 * @param area
	 * @return
	 */
	public Set<TurfEntity> findAllByArea(String area) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<TurfEntity> turfs = new HashSet<TurfEntity>();
		TurfEntity turf = null;
		try {
			con = ConnectionUtil.getConnection();
			String query = "SELECT id, name, address, area, city, opening_hours, closing_hours, is_active FROM Turf WHERE is_active = 1 AND area = ?";
		    ps = con.prepareStatement(query);
			ps = con.prepareStatement(query);
			ps.setString(1, area);
			rs = ps.executeQuery();
			if (rs.next()) {
				turf = new TurfEntity();
				turf.setId(rs.getInt("id"));
				turf.setName(rs.getString("name"));
				turf.setAddress(rs.getString("address"));
				turf.setArea(rs.getString("area"));
				turf.setCity(rs.getString("city"));
				turf.setOpeningHours(rs.getString("opening_hours"));
				turf.setClosingHours(rs.getString("closing_hours"));
				turf.setActive(rs.getBoolean("is_active"));
				
				turfs.add(turf);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return turfs;
	}
	/** 
	 * 
	 * @param turfCity
	 * @return
	 */
	public Set<TurfEntity> findAllByCity(String turfCity) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<TurfEntity> turfs = new HashSet<TurfEntity>();
		TurfEntity turf = null;
		try {
			con = ConnectionUtil.getConnection();
			String query ="SELECT id, name, address, area, city, opening_hours, closing_hours, is_active FROM Turf WHERE is_active = 1 AND city = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, turfCity);
			rs = ps.executeQuery();
			if (rs.next()) {
				turf = new TurfEntity();
				turf.setId(rs.getInt("id"));
				turf.setName(rs.getString("name"));
				turf.setAddress(rs.getString("address"));
				turf.setArea(rs.getString("area"));
				turf.setCity(rs.getString("city"));
				turf.setOpeningHours(rs.getString("opening_hours"));
				turf.setClosingHours(rs.getString("closing_hours"));
				turf.setActive(rs.getBoolean("is_active"));
				
				turfs.add(turf);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return turfs;
	}

	
	public static int id(int id) {
		
	
	int targetId = 123; // Replace with the actual ID you want to delete

	Connection con = ConnectionUtil.getConnection();

    try  {
    	
        String deleteQuery = "DELETE FROM Locations WHERE ID = ?";
        
        try (PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, targetId);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows deleted.");
            } 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return targetId; 
	
}


}



