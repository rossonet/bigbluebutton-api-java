package net.rossonet.bbb.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Object for a BigBlueButton meeting.
 *
 * @author Adrian Fish Based on:
 *         https://github.com/sakaicontrib/bbb-tool/blob/master/api/src/java/org/sakaiproject/bbb/api/BBBMeeting.java
 *
 *         Last modified by Andrea Ambrosini
 */

public class BBBMeeting {
	private Boolean allowStartStopRecording = null;
	private String attendeePW = null;
	private Boolean autoStartRecording = null;
	private String copyright = null;
	private String dialNumber = null;
	private Long duration = null;
	private Date endDate = null;
	private String logo = null;
	private String logoutURL = null;
	private String meetingID;
	private Map<String, String> meta = new HashMap<String, String>();
	private String moderatorOnlyMessage = null;

	private String moderatorPW = null;

	private Boolean muteOnStart = null;
	private String name = null;
	private Boolean record = null;
	private Date startDate = null;
	private String voiceBridge = null;
	private Boolean webcamsOnlyForModerator = null;
	private String webVoice = null;
	private String welcome = null;

	public BBBMeeting(final String meetingID) {
		this.meetingID = meetingID;
	}

	public void addMeta(final String key, final String value) {
		meta.put(key, value);
	}

	public Boolean getAllowStartStopRecording() {
		return allowStartStopRecording;
	}

	public String getAttendeePW() {
		return attendeePW;
	}

	public Boolean getAutoStartRecording() {
		return autoStartRecording;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getDialNumber() {
		return dialNumber;
	}

	public Long getDuration() {
		return duration;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getLogo() {
		return logo;
	}

	public String getLogoutURL() {
		return logoutURL;
	}

	public String getMeetingID() {
		return meetingID;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public String getModeratorOnlyMessage() {
		return moderatorOnlyMessage;
	}

	public String getModeratorPW() {
		return moderatorPW;
	}

	public Boolean getMuteOnStart() {
		return muteOnStart;
	}

	public String getName() {
		return name;
	}

	public Boolean getRecord() {
		return record;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getVoiceBridge() {
		return voiceBridge;
	}

	public Boolean getWebcamsOnlyForModerator() {
		return webcamsOnlyForModerator;
	}

	public String getWebVoice() {
		return webVoice;
	}

	public String getWelcome() {
		return welcome;
	}

	public void removeMeta(final String key) {
		if (meta.containsKey(key))
			meta.remove(key);
	}

	public void setAllowStartStopRecording(final Boolean allowStartStopRecording) {
		this.allowStartStopRecording = allowStartStopRecording;
	}

	public void setAttendeePW(final String attendeePW) {
		this.attendeePW = attendeePW;
	}

	public void setAutoStartRecording(final Boolean autoStartRecording) {
		this.autoStartRecording = autoStartRecording;
	}

	public void setCopyright(final String copyright) {
		this.copyright = copyright;
	}

	public void setDialNumber(final String dialNumber) {
		this.dialNumber = dialNumber;
	}

	public void setDuration(final Long duration) {
		this.duration = duration;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public void setLogo(final String logo) {
		this.logo = logo;
	}

	public void setLogoutURL(final String logoutURL) {
		this.logoutURL = logoutURL;
	}

	public void setMeetingID(final String meetingID) {
		this.meetingID = meetingID;
	}

	void setMeta(final Map<String, String> meta) {
		this.meta = meta;
	}

	public void setModeratorOnlyMessage(final String moderatorOnlyMessage) {
		this.moderatorOnlyMessage = moderatorOnlyMessage;
	}

	public void setModeratorPW(final String moderatorPW) {
		this.moderatorPW = moderatorPW;
	}

	public void setMuteOnStart(final Boolean muteOnStart) {
		this.muteOnStart = muteOnStart;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setRecord(final Boolean record) {
		this.record = record;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public void setVoiceBridge(final String voiceBridge) {
		this.voiceBridge = voiceBridge;
	}

	public void setWebcamsOnlyForModerator(final Boolean webcamsOnlyForModerator) {
		this.webcamsOnlyForModerator = webcamsOnlyForModerator;
	}

	public void setWebVoice(final String webVoice) {
		this.webVoice = webVoice;
	}

	public void setWelcome(final String welcome) {
		this.welcome = welcome;
	}

	@Override
	public String toString() {
		return "BBBMeeting [name=" + name + ", meetingID=" + meetingID + ", attendeePW=" + attendeePW + ", moderatorPW="
				+ moderatorPW + ", dialNumber=" + dialNumber + ", voiceBridge=" + voiceBridge + ", webVoice=" + webVoice
				+ ", logoutURL=" + logoutURL + ", record=" + record + ", duration=" + duration
				+ ", moderatorOnlyMessage=" + moderatorOnlyMessage + ", autoStartRecording=" + autoStartRecording
				+ ", allowStartStopRecording=" + allowStartStopRecording + ", webcamsOnlyForModerator="
				+ webcamsOnlyForModerator + ", logo=" + logo + ", copyright=" + copyright + ", muteOnStart="
				+ muteOnStart + ", welcome=" + welcome + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
