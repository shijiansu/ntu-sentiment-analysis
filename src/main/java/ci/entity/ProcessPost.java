package ci.entity;

import java.util.Date;

public class ProcessPost {
	private int id;
	private String facebookPage;
	private int cw;
	private String postId;
	private double ssp;
	private int cpc;
	private int cnc;
	private int cnlc;
	private Date sysdate;
	private int processStatus;
	private int collectionPostId;

	public int getCollectionPostId() {
		return collectionPostId;
	}

	public void setCollectionPostId(int collectionPostId) {
		this.collectionPostId = collectionPostId;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacebookPage() {
		return facebookPage;
	}

	public void setFacebookPage(String facebookPage) {
		this.facebookPage = facebookPage;
	}

	public int getCw() {
		return cw;
	}

	public void setCw(int cw) {
		this.cw = cw;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public double getSsp() {
		return ssp;
	}

	public void setSsp(double ssp) {
		this.ssp = ssp;
	}

	public int getCpc() {
		return cpc;
	}

	public void setCpc(int cpc) {
		this.cpc = cpc;
	}

	public int getCnc() {
		return cnc;
	}

	public void setCnc(int cnc) {
		this.cnc = cnc;
	}

	public int getCnlc() {
		return cnlc;
	}

	public void setCnlc(int cnlc) {
		this.cnlc = cnlc;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

	@Override
	public String toString() {
		return "ProcessPost [id=" + id + ", facebookPage=" + facebookPage
				+ ", cw=" + cw + ", postId=" + postId + ", ssp=" + ssp
				+ ", cpc=" + cpc + ", cnc=" + cnc + ", cnlc=" + cnlc
				+ ", sysdate=" + sysdate + ", processStatus=" + processStatus
				+ "]";
	}

}
