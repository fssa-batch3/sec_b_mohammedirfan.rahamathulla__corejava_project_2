package in.fssa.turf.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    @Override
	public String toString() {
		return "Booking [id=" + id + ", useremail=" + useremail + ", turfid=" + turfid + ", openinghours="
				+ openinghours + ", closinghours=" + closinghours + ", status=" + status + ", gameDate=" + gameDate
				+ ", created_at=" + created_at + ", modified_at=" + modified_at + "]";
	}

	private int id;
    private String useremail;
    private int turfid;
    private String openinghours;
    private String closinghours;
    private String status;
    public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String string) {
		this.gameDate = string;
	}

	private String gameDate;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getTurfid() {
        return turfid;
    }

    public void setTurfid(int turfid) {
        this.turfid = turfid;
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openinghours) {
        this.openinghours = openinghours;
    }

    public String getClosinghours() {
        return closinghours;
    }

    public void setClosinghours(String closinghours) {
        this.closinghours = closinghours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }
}
