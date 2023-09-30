package in.fssa.turf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public List<Booking> findAllById(int id) {
		List<Booking> bookings = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM Bookings WHERE id = ?")) {
			ps.setInt(1, id);
			try (ResultSet resultSet = ps.executeQuery()) {
				while (resultSet.next()) {
					Booking booking = new Booking();
					booking.setId(resultSet.getInt("id"));
					booking.setUseremail(resultSet.getString("useremail"));
					booking.setTurfid(resultSet.getInt("turfid"));
					booking.setGameDate(resultSet.getString("game_date"));
					booking.setOpeninghours(resultSet.getString("openinghours"));
					booking.setClosinghours(resultSet.getString("closinghours"));
					booking.setStatus(resultSet.getString("Status"));
					booking.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());
					booking.setModified_at(resultSet.getTimestamp("modified_at").toLocalDateTime());
					bookings.add(booking);
				}
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
			ps.setDate(3, Date.valueOf(booking.getGameDate())); // convert localdate to mysql date
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
			ps.setDate(3, Date.valueOf(booking.getGameDate())); // convert localdate to mysql date
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
	public void updatestatus(int bookingid, String status) {
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

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Booking> bookings = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();

			statement = connection.prepareStatement("SELECT * FROM Bookings WHERE userId=?");

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Booking booking = new Booking();
				booking.setId(resultSet.getInt("id"));
				booking.setUseremail(resultSet.getString("useremail"));
				booking.setTurfid(resultSet.getInt("turfid"));
				booking.setGameDate(java.time.LocalDate.now().toString());
				booking.setOpeninghours(resultSet.getString("openinghours"));
				booking.setClosinghours(resultSet.getString("closinghours"));
				booking.setStatus(resultSet.getString("Status"));
				booking.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());
				booking.setModified_at(resultSet.getTimestamp("modified_at").toLocalDateTime());
				bookings.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, statement, resultSet);
		}
		return bookings;

	}

	public List<Booking> findByEmail(String userEmail) {

		List<Booking> bookings = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("SELECT * FROM Bookings Where Useremail = ?");
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Booking booking = new Booking();
				booking.setId(resultSet.getInt("id"));
				booking.setUseremail(resultSet.getString("useremail"));
				booking.setTurfid(resultSet.getInt("turfid"));
				booking.setGameDate(java.time.LocalDate.now().toString());
				booking.setOpeninghours(resultSet.getString("openinghours"));
				booking.setClosinghours(resultSet.getString("closinghours"));
				booking.setStatus(resultSet.getString("Status"));
				booking.setCreated_at(resultSet.getTimestamp("created_at").toLocalDateTime());
				booking.setModified_at(resultSet.getTimestamp("modified_at").toLocalDateTime());
				bookings.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, ps, resultSet);
		}
		return bookings;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Booking> findUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, String>> findByDate(String string) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, String> timings = null;
		List<Map<String, String>> listOfTimings = null;
		try {
			connection = ConnectionUtil.getConnection();
			String query = "SELECT Openinghours , Closinghours FROM Bookings WHERE game_date = ?";
			ps = connection.prepareStatement(query);
			java.sql.Date game_date = Date.valueOf(string);
			ps.setDate(1, game_date);
			rs = ps.executeQuery();
			if (rs.next()) {
				timings.put("start_time", rs.getString("Openinghours"));
				timings.put("end_time", rs.getString("Closinghours"));

				listOfTimings.add(timings);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, ps, rs);
		}
		return listOfTimings;
	}

	@Override
	public List<Booking> findAllByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
