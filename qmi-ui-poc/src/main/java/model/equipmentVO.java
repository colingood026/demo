package model;

public class equipmentVO {
	private java.util.Date REC_DATE; //收料日期
	private String PUR_NO;	//採購單號
	private String MAT_01;	//基準料號
	private String COL_NO;	//色號
	private Double WID_TH;	//幅寬
	private String CNT_NO;	//箱號
	private String LOT_ID;	//缸號
	private String LOC_CODE;	//儲位
	private Double STOCK_QTY;	//庫存量
	private String UNT_RQ;	//庫存單位
	public java.util.Date getREC_DATE() {
		return REC_DATE;
	}
	public void setREC_DATE(java.util.Date rEC_DATE) {
		REC_DATE = rEC_DATE;
	}
	public String getPUR_NO() {
		return PUR_NO;
	}
	public void setPUR_NO(String pUR_NO) {
		PUR_NO = pUR_NO;
	}
	public String getMAT_01() {
		return MAT_01;
	}
	public void setMAT_01(String mAT_01) {
		MAT_01 = mAT_01;
	}
	public String getCOL_NO() {
		return COL_NO;
	}
	public void setCOL_NO(String cOL_NO) {
		COL_NO = cOL_NO;
	}
	public Double getWID_TH() {
		return WID_TH;
	}
	public void setWID_TH(Double wID_TH) {
		WID_TH = wID_TH;
	}
	public String getCNT_NO() {
		return CNT_NO;
	}
	public void setCNT_NO(String cNT_NO) {
		CNT_NO = cNT_NO;
	}
	public String getLOT_ID() {
		return LOT_ID;
	}
	public void setLOT_ID(String lOT_ID) {
		LOT_ID = lOT_ID;
	}
	public String getLOC_CODE() {
		return LOC_CODE;
	}
	public void setLOC_CODE(String lOC_CODE) {
		LOC_CODE = lOC_CODE;
	}
	public Double getSTOCK_QTY() {
		return STOCK_QTY;
	}
	public void setSTOCK_QTY(Double sTOCK_QTY) {
		STOCK_QTY = sTOCK_QTY;
	}
	public String getUNT_RQ() {
		return UNT_RQ;
	}
	public void setUNT_RQ(String uNT_RQ) {
		UNT_RQ = uNT_RQ;
	}
	@Override
	public String toString() {
		return "equipmentVO [REC_DATE=" + REC_DATE + ", PUR_NO=" + PUR_NO + ", MAT_01=" + MAT_01 + ", COL_NO=" + COL_NO
				+ ", WID_TH=" + WID_TH + ", CNT_NO=" + CNT_NO + ", LOT_ID=" + LOT_ID + ", LOC_CODE=" + LOC_CODE
				+ ", STOCK_QTY=" + STOCK_QTY + ", UNT_RQ=" + UNT_RQ + "]";
	}
	
	
	
	
	
	
	
	
	
}
