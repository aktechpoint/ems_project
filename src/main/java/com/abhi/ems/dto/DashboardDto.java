package com.abhi.ems.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardDto {
	
	
	private Integer totlaEnqs;
	private Integer avail_Enq_inwaiting;
	private Integer meeting_Done;
	private Integer not_in_que;
	
	
	
	public Integer getTotlaEnqs() {
		return totlaEnqs;
	}
	public void setTotlaEnqs(Integer totlaEnqs) {
		this.totlaEnqs = totlaEnqs;
	}
	public Integer getAvail_Enq_inwaiting() {
		return avail_Enq_inwaiting;
	}
	public void setAvail_Enq_inwaiting(Integer avail_Enq_inwaiting) {
		this.avail_Enq_inwaiting = avail_Enq_inwaiting;
	}
	public Integer getMeeting_Done() {
		return meeting_Done;
	}
	public void setMeeting_Done(Integer meeting_Done) {
		this.meeting_Done = meeting_Done;
	}
	public Integer getNot_in_que() {
		return not_in_que;
	}
	public void setNot_in_que(Integer not_in_que) {
		this.not_in_que = not_in_que;
	}

	
}
