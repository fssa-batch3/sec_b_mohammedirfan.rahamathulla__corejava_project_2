package in.fssa.turf.model;
public class TurfEntity  implements Comparable<TurfEntity>{

		private int id;
		private String name;
		private String address;	    
		private String area;
		private String city;
		private String openingHours;
		private String closingHours;
		private String image;
		private int turfownerid;
		
		public int getTurfownerid() {
			return turfownerid;
		}

		public void setTurfownerid(int turfownerid) {
			this.turfownerid = turfownerid;
		}

		private boolean isActive = true;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer userId) {
			this.id = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
		public String getOpeningHours() {
			return openingHours;
		}

		public void setOpeningHours(String openinghours) {
			this.openingHours = openinghours;
		}
		public String getClosingHours() {
			return closingHours;
		}

		public void setClosingHours(String closinghours) {
			this.closingHours = closinghours;
		}
		@Override
		public String toString() {
			return "TurfEntity [id=" + id + ", name=" + name + ", address=" + address + ", area=" + area + ", city="
					+ city + ", openingHours=" + openingHours + ", closingHours=" + closingHours + ", image=" + image
					+ ", turfownerid=" + turfownerid + ", isActive=" + isActive + "]";
		}
		
		@Override
		public int compareTo(TurfEntity o) {

			if (this.getId() == o.getId()) {
				return 0;
			} else {
				if (this.getId() > o.getId()) {
					return 1;
				} else {
					return -1;
				}
			}
	}


		









}
