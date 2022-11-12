package ca.concordia.webapp.vo;

public class Flight {
	private String flightNumber;
	private String hex;
	private String regNumber;
	private double lat;
	private double lng;
	private int alt;
	private String arrIata;
	private String depIata;
	private String flag;
	private int speed;
	private String status;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public int getAlt() {
		return alt;
	}

	public void setAlt(int alt) {
		this.alt = alt;
	}

	public String getArrIata() {
		return arrIata;
	}

	public void setArrIata(String arrIata) {
		this.arrIata = arrIata;
	}

	public String getDepIata() {
		return depIata;
	}

	public void setDepIata(String depIata) {
		this.depIata = depIata;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", hex=" + hex + ", regNumber=" + regNumber + ", lat=" + lat
				+ ", lng=" + lng + ", alt=" + alt + ", arrIata=" + arrIata + ", depIata=" + depIata + ", flag=" + flag
				+ ", speed=" + speed + ", status=" + status + "]";
	}

}
