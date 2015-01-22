package com.uaf.pay.dto;

public class CMBPaymentDetailDto {
	public static String HEADER_COLUMN1 = "YURREF";
	public static String HEADER_COLUMN2 = "EPTDAT";
	public static String HEADER_COLUMN3 = "EPTTIM";
	public static String HEADER_COLUMN4 = "DBTACC";
	public static String HEADER_COLUMN5 = "C_DBTBBK";
	public static String HEADER_COLUMN6 = "TRSAMT";
	public static String HEADER_COLUMN7 = "C_CCYNBR";
	public static String HEADER_COLUMN8 = "C_STLCHN";
	public static String HEADER_COLUMN9 = "NUSAGE";
	public static String HEADER_COLUMN10 = "BUSNAR";
	public static String HEADER_COLUMN11 = "CRTACC";
	public static String HEADER_COLUMN12 = "CRTNAM";
	public static String HEADER_COLUMN13 = "CRTBNK";
	public static String HEADER_COLUMN14 = "CRTPVC";
	public static String HEADER_COLUMN15 = "CRTCTY";
	public static String HEADER_COLUMN16 = "CRTDTR";
	public static String HEADER_COLUMN17 = "NTFCH1";
	public static String HEADER_COLUMN18 = "NTFCH2";
	public static String HEADER_COLUMN19 = "CRTSQN";
	
	private String yurRef;
	private String eptDate; //yyyymmdd
	private String eptTime;
	private String dbtAcc;
	private String dbtBbk; //开户地区
	private String trsAmt;
	private String ccyNbr;
	private String stlChn;
	private String nusAge;
	private String busNar;
	private String crtAcc;
	private String crtNam;
	private String crtBnk;
	private String brdNbr;
	private String crtPvc;
	private String crtCty;
	private String crtDtr;
	private String ntfCh1;
	private String ntfCh2;
	private String crtSQN;
	
	public String getYurRef() {
		return yurRef;
	}
	public void setYurRef(String yurRef) {
		this.yurRef = yurRef;
	}
	public String getEptDate() {
		return eptDate;
	}
	public void setEptDate(String eptDate) {
		this.eptDate = eptDate;
	}
	public String getEptTime() {
		return eptTime;
	}
	public void setEptTime(String eptTime) {
		this.eptTime = eptTime;
	}
	public String getDbtAcc() {
		return dbtAcc;
	}
	public void setDbtAcc(String dbtAcc) {
		this.dbtAcc = dbtAcc;
	}
	public String getDbtBbk() {
		return dbtBbk;
	}
	public void setDbtBbk(String dbtBbk) {
		this.dbtBbk = dbtBbk;
	}
	public String getTrsAmt() {
		return trsAmt;
	}
	public void setTrsAmt(String trsAmt) {
		this.trsAmt = trsAmt;
	}
	public String getCcyNbr() {
		return ccyNbr;
	}
	public void setCcyNbr(String ccyNbr) {
		this.ccyNbr = ccyNbr;
	}
	public String getStlChn() {
		return stlChn;
	}
	public void setStlChn(String stlChn) {
		this.stlChn = stlChn;
	}
	public String getNusAge() {
		return nusAge;
	}
	public void setNusAge(String nusAge) {
		this.nusAge = nusAge;
	}
	public String getBusNar() {
		return busNar;
	}
	public void setBusNar(String busNar) {
		this.busNar = busNar;
	}
	public String getCrtAcc() {
		return crtAcc;
	}
	public void setCrtAcc(String crtAcc) {
		this.crtAcc = crtAcc;
	}
	public String getCrtNam() {
		return crtNam;
	}
	public void setCrtNam(String crtNam) {
		this.crtNam = crtNam;
	}
	public String getCrtBnk() {
		return crtBnk;
	}
	public void setCrtBnk(String crtBnk) {
		this.crtBnk = crtBnk;
	}
	public String getBrdNbr() {
		return brdNbr;
	}
	public void setBrdNbr(String brdNbr) {
		this.brdNbr = brdNbr;
	}
	public String getCrtPvc() {
		return crtPvc;
	}
	public void setCrtPvc(String crtPvc) {
		this.crtPvc = crtPvc;
	}
	public String getCrtCty() {
		return crtCty;
	}
	public void setCrtCty(String crtCty) {
		this.crtCty = crtCty;
	}
	public String getCrtDtr() {
		return crtDtr;
	}
	public void setCrtDtr(String crtDtr) {
		this.crtDtr = crtDtr;
	}
	public String getNtfCh1() {
		return ntfCh1;
	}
	public void setNtfCh1(String ntfCh1) {
		this.ntfCh1 = ntfCh1;
	}
	public String getNtfCh2() {
		return ntfCh2;
	}
	public void setNtfCh2(String ntfCh2) {
		this.ntfCh2 = ntfCh2;
	}
	public String getCrtSQN() {
		return crtSQN;
	}
	public void setCrtSQN(String crtSQN) {
		this.crtSQN = crtSQN;
	}
	
	

}
