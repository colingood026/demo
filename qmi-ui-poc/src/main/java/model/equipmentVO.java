package model;

public class equipmentVO {
	private java.util.Date buy_date; //收料日期
	private String buy_no;	//採購單號
	private String eq_no;	//基準料號
	private String color;	//色號
	private String width;	//幅寬
	private String box_no;	//箱號
	private String cylinder_no;	//缸號
	private String stored;	//儲位
	private double amount;	//庫存量
	private String unit;	//庫存單位
	
	
	
	
	@Override
	public String toString() {
		return "equipmentVO [buy_date=" + buy_date + ", buy_no=" + buy_no + ", eq_no=" + eq_no + ", color=" + color
				+ ", width=" + width + ", box_no=" + box_no + ", cylinder_no=" + cylinder_no + ", stored=" + stored
				+ ", amount=" + amount + ", unit=" + unit + "]";
	}
	public java.util.Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(java.util.Date buy_date) {
		this.buy_date = buy_date;
	}
	public String getBuy_no() {
		return buy_no;
	}
	public void setBuy_no(String buy_no) {
		this.buy_no = buy_no;
	}
	public String getEq_no() {
		return eq_no;
	}
	public void setEq_no(String eq_no) {
		this.eq_no = eq_no;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getBox_no() {
		return box_no;
	}
	public void setBox_no(String box_no) {
		this.box_no = box_no;
	}
	public String getCylinder_no() {
		return cylinder_no;
	}
	public void setCylinder_no(String cylinder_no) {
		this.cylinder_no = cylinder_no;
	}
	public String getStored() {
		return stored;
	}
	public void setStored(String stored) {
		this.stored = stored;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
	
}
