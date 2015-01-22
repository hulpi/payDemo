package com.uaf.pay.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uaf.pay.constants.TranxCon;

public class CMBBatchPaymentDto {
	
	public static String HEADER_COLUMN1 = "SYSCODE";
	public static String HEADER_COLUMN2 = "VERSION";
	public static String HEADER_COLUMN3 = "TYPE";
	public static String HEADER_COLUMN4 = "MAKEDATE";
	public static String HEADER_COLUMN5 = "OPERATOR";
	public static String HEADER_COLUMN6 = "SUM";
	public static String HEADER_COLUMN7 = "TOTAL";
	public static String HEADER_COLUMN8 = "STATUS";
	
	private String cityCode;
	private String trxCode;
	//private String genDate;//yymmdd
	private String seqNo;
	
	private String sysCode;//5464
	private String version;
	private String type;
	private String makedDate;
	private String operator;
	private String sum;
	private String total;
	
	private List<CMBPaymentDetailDto> paymentDetails;
	
	
	public String getFileName() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String genDate = dateFormat.format(new Date());
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(cityCode);
		strBuffer.append(trxCode);
		strBuffer.append(genDate);
		strBuffer.append(TranxCon.HYPHEN);
		strBuffer.append(seqNo);
		strBuffer.append(TranxCon.CMB_RF_FILE_NAME);
		
		return strBuffer.toString();
		
	}
	
	private String getHeader() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(TranxCon.NUMBER_SIGN);
		strBuffer.append(HEADER_COLUMN1).append(TranxCon.EQUALS_SIGN).append(sysCode).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(HEADER_COLUMN2).append(TranxCon.EQUALS_SIGN).append(version).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(HEADER_COLUMN3).append(TranxCon.EQUALS_SIGN).append(TranxCon.CMB_TYPE_DISBURES).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(HEADER_COLUMN4).append(TranxCon.EQUALS_SIGN).append(makedDate).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(HEADER_COLUMN5).append(TranxCon.EQUALS_SIGN).append(operator).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(HEADER_COLUMN6).append(TranxCon.EQUALS_SIGN).append(sum).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(HEADER_COLUMN7).append(TranxCon.EQUALS_SIGN).append(total).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(HEADER_COLUMN8).append(TranxCon.EQUALS_SIGN);
		
		return strBuffer.toString();
	}
	
	private String getRowData(CMBPaymentDetailDto paymentDetail) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN1).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getYurRef()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN2).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getEptDate()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN3).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getEptTime()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN4).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getDbtAcc()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN5).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getDbtBbk()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN6).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getTrsAmt()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN7).append(TranxCon.EQUALS_SIGN).append(TranxCon.C_CCYNBR).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN8).append(TranxCon.EQUALS_SIGN).append(TranxCon.C_STLCHN).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN9).append(TranxCon.EQUALS_SIGN).append(TranxCon.N_USAGE).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN10).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getBusNar()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN11).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getCrtAcc()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN12).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getCrtNam()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN13).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getCrtBnk()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN14).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getCrtPvc()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN15).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getCrtCty()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN16).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getCrtDtr()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN17).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getNtfCh1()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN18).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getNtfCh2()).append(" ").append(TranxCon.SEMICOLON);
		strBuffer.append(CMBPaymentDetailDto.HEADER_COLUMN19).append(TranxCon.EQUALS_SIGN).append(paymentDetail.getCrtSQN());
		
	    return strBuffer.toString();
	}
	
	public String getFileContent() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(getHeader());
		
		if(paymentDetails != null) {
			String lineSeparator = System.getProperty("line.separator");
			if(lineSeparator == null || lineSeparator.isEmpty()) {
				lineSeparator = TranxCon.NEW_LINE;
			}
			
			for(CMBPaymentDetailDto paymentDetail: paymentDetails) {
				String rowData = getRowData(paymentDetail);
				strBuffer.append(lineSeparator);
				strBuffer.append(rowData);
			}
		}
		
		return strBuffer.toString();
		
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getTrxCode() {
		return trxCode;
	}

	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMakedDate() {
		return makedDate;
	}

	public void setMakedDate(String makedDate) {
		this.makedDate = makedDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<CMBPaymentDetailDto> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<CMBPaymentDetailDto> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	public void addPaymentDetails(CMBPaymentDetailDto paymentDetail) {
		if(this.paymentDetails == null) {
			this.paymentDetails = new ArrayList<CMBPaymentDetailDto>();
		}
		
		paymentDetails.add(paymentDetail);
		
	}

}
