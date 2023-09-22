package in.fssa.turf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.fssa.turf.model.Booking;
import in.fssa.turf.model.TurfEntity;
import in.fssa.turf.util.ConnectionUtil;

public class BookingDAOImpl implements BookingDAO {

    private Connection connection; // Initialize this in the constructor

    @Override
    public Booking findById(int id) {
		return null;
        // Implement finding by ID
    }

    @Override
    public List<Booking> findAll() {
    	
        List<Booking> bookings = new ArrayList<>();
        try {
        	connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Bookings");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                booking.setUseremail(resultSet.getString("useremail"));
                booking.setTurfid(resultSet.getInt("turfid"));
                booking.setGameDate(resultSet.getDate("game_date").toLocalDate());
                booking.setOpeninghours(resultSet.getString("openinghours"));
                booking.setClosinghours(resultSet.getString("closinghours"));
                booking.setStatus(resultSet.getString("Status"));
                booking.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());
                booking.setModified_at(resultSet.getTimestamp("modified_at").toLocalDateTime());
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

	@Override
	public void save(Booking booking) {
		// TODO Auto-generated method stub
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int generatedId = 0;
		try {
			con = ConnectionUtil.getConnection();
			String query = "INSERT INTO Bookings (Useremail , Turfid ,game_date, Openinghours , Closinghours  , Status ) "
					+ "VALUES(? , ? ,? , ? , ? , ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, booking.getUseremail());
			ps.setInt(2, booking.getTurfid());
			ps.setDate(3, Date.valueOf(booking.getGameDate())); //convert localdate to mysql date
			ps.setString(4, booking.getOpeninghours());
			ps.setString(5, booking.getClosinghours());
			ps.setString(6, booking.getStatus());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Bookings had been created successfully");
			} else {
				throw new RuntimeException("Bookings had not been created successfully");
			}


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

		


	@Override
	public void update(Booking booking) {
		// TODO Auto-generated method stub
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = ConnectionUtil.getConnection();
				String query = "UPDATE Bookings SET  Useremail = ? , Turfid = ? , game_date = ? , Openinghours = ? , Closinghours = ? , Status = ? WHERE  id = ?";
				ps = con.prepareStatement(query);
				ps.setString(1, booking.getUseremail());
				ps.setInt(2, booking.getTurfid());
				ps.setDate(3, Date.valueOf(booking.getGameDate())); //convert localdate to mysql date
				ps.setString(4, booking.getOpeninghours());
				ps.setString(5, booking.getClosinghours());
				ps.setString(6, booking.getStatus());
				ps.setInt(7, booking.getId());
				
				int rowsAffected = ps.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Bookings had been updated successfully");
				} else {
					throw new RuntimeException("Bookings had not been updated successfully");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			} finally {
				ConnectionUtil.close(con, ps);
			}
		}

	@Override
	public void updatestatus(int bookingid,String status) {
		// TODO Auto-generated method stub
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = ConnectionUtil.getConnection();
				String query = "UPDATE Bookings SET  Status = ? WHERE  id = ?";
				ps = con.prepareStatement(query);
				ps.setString(1, status);
				ps.setInt(2, bookingid);
				int rowsAffected = ps.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Bookings had been updated successfully");
				} else {
					throw new RuntimeException("Bookings had not been updated successfully");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			} finally {
				ConnectionUtil.close(con, ps);
			}
		}

	  @Override
	    public List<Booking> findUserBookings(int userId) {
	    	
	        List<Booking> bookings = new ArrayList<>();
	        try {
	        	connection = ConnectionUtil.getConnection();
	        	
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Bookings WHERE userId=?");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {
	                Booking booking = new Booking();
	                booking.setId(resultSet.getInt("id"));
	                booking.setUseremail(resultSet.getString("useremail"));
	                booking.setTurfid(resultSet.getInt("turfid"));
	                booking.setGameDate(resultSet.getDate("game_date").toLocalDate());
	                booking.setOpeninghours(resultSet.getString("openinghours"));
	                booking.setClosinghours(resultSet.getString("closinghours"));
	                booking.setStatus(resultSet.getString("Status"));
	                booking.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());
	                booking.setModified_at(resultSet.getTimestamp("modified_at").toLocalDateTime());
	                bookings.add(booking);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bookings;
	    }


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

    // Implement save, update, delete methods
}

