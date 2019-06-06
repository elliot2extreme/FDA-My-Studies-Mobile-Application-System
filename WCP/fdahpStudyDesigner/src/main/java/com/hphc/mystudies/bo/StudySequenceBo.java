/*
 * Copyright © 2017-2018 Harvard Pilgrim Health Care Institute (HPHCI) and its Contributors.
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * Funding Source: Food and Drug Administration ("Funding Agency") effective 18 September 2014 as Contract no.
 * HHSF22320140030I/HHSF22301006T (the "Prime Contract").
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package com.hphc.mystudies.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * The persistent class for the study_sequence database table.
 * 
 * @author BTC
 *
 */

@Entity
@Table(name = "study_sequence")
@NamedQueries({
		@NamedQuery(name = "getStudySequenceById", query = " From StudySequenceBo SSBO WHERE SSBO.studySequenceId =:studySequenceId"),
		@NamedQuery(name = "getStudySequenceByStudyId", query = " From StudySequenceBo SSBO WHERE SSBO.studyId =:studyId") })
public class StudySequenceBo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3573683893623838475L;

	@Column(name = "actions")
	@Type(type = "yes_no")
	private Boolean actions = false;

	@Column(name = "basic_info")
	@Type(type = "yes_no")
	private Boolean basicInfo = false;

	@Column(name = "check_list")
	@Type(type = "yes_no")
	private Boolean checkList = false;

	@Column(name = "comprehension_test")
	@Type(type = "yes_no")
	private Boolean comprehensionTest = false;

	@Column(name = "consent_edu_info")
	@Type(type = "yes_no")
	private Boolean consentEduInfo = false;

	@Column(name = "e_consent")
	@Type(type = "yes_no")
	private Boolean eConsent = false;

	@Column(name = "eligibility")
	@Type(type = "yes_no")
	private Boolean eligibility = false;

	@Column(name = "miscellaneous_branding")
	@Type(type = "yes_no")
	private Boolean miscellaneousBranding = false;

	@Column(name = "miscellaneous_notification")
	@Type(type = "yes_no")
	private Boolean miscellaneousNotification = false;

	@Column(name = "miscellaneous_resources")
	@Type(type = "yes_no")
	private Boolean miscellaneousResources = false;

	@Column(name = "over_view")
	@Type(type = "yes_no")
	private Boolean overView = false;

	@Column(name = "setting_admins")
	@Type(type = "yes_no")
	private Boolean settingAdmins = false;

	@Column(name = "study_dashboard_chart")
	@Type(type = "yes_no")
	private Boolean studyDashboardChart = false;

	@Column(name = "study_dashboard_stats")
	@Type(type = "yes_no")
	private Boolean studyDashboardStats = false;

	@Column(name = "study_exc_active_task")
	@Type(type = "yes_no")
	private Boolean studyExcActiveTask = false;

	@Column(name = "study_exc_questionnaries")
	@Type(type = "yes_no")
	private Boolean studyExcQuestionnaries = false;

	@Column(name = "study_id")
	private Integer studyId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "study_sequence_id")
	private Integer studySequenceId;

	public Integer getStudyId() {
		return studyId;
	}

	public Integer getStudySequenceId() {
		return studySequenceId;
	}

	public Boolean isActions() {
		return actions;
	}

	public Boolean isBasicInfo() {
		return basicInfo;
	}

	public Boolean isCheckList() {
		return checkList;
	}

	public Boolean isComprehensionTest() {
		return comprehensionTest;
	}

	public Boolean isConsentEduInfo() {
		return consentEduInfo;
	}

	public Boolean iseConsent() {
		return eConsent;
	}

	public Boolean isEligibility() {
		return eligibility;
	}

	public Boolean isMiscellaneousBranding() {
		return miscellaneousBranding;
	}

	public Boolean isMiscellaneousNotification() {
		return miscellaneousNotification;
	}

	public Boolean isMiscellaneousResources() {
		return miscellaneousResources;
	}

	public Boolean isOverView() {
		return overView;
	}

	public Boolean isSettingAdmins() {
		return settingAdmins;
	}

	public Boolean isStudyDashboardChart() {
		return studyDashboardChart;
	}

	public Boolean isStudyDashboardStats() {
		return studyDashboardStats;
	}

	public Boolean isStudyExcActiveTask() {
		return studyExcActiveTask;
	}

	public Boolean isStudyExcQuestionnaries() {
		return studyExcQuestionnaries;
	}

	public void setActions(Boolean actions) {
		this.actions = actions;
	}

	public void setBasicInfo(Boolean basicInfo) {
		this.basicInfo = basicInfo;
	}

	public void setCheckList(Boolean checkList) {
		this.checkList = checkList;
	}

	public void setComprehensionTest(Boolean comprehensionTest) {
		this.comprehensionTest = comprehensionTest;
	}

	public void setConsentEduInfo(Boolean consentEduInfo) {
		this.consentEduInfo = consentEduInfo;
	}

	public void seteConsent(Boolean eConsent) {
		this.eConsent = eConsent;
	}

	public void setEligibility(Boolean eligibility) {
		this.eligibility = eligibility;
	}

	public void setMiscellaneousBranding(Boolean miscellaneousBranding) {
		this.miscellaneousBranding = miscellaneousBranding;
	}

	public void setMiscellaneousNotification(Boolean miscellaneousNotification) {
		this.miscellaneousNotification = miscellaneousNotification;
	}

	public void setMiscellaneousResources(Boolean miscellaneousResources) {
		this.miscellaneousResources = miscellaneousResources;
	}

	public void setOverView(Boolean overView) {
		this.overView = overView;
	}

	public void setSettingAdmins(Boolean settingAdmins) {
		this.settingAdmins = settingAdmins;
	}

	public void setStudyDashboardChart(Boolean studyDashboardChart) {
		this.studyDashboardChart = studyDashboardChart;
	}

	public void setStudyDashboardStats(Boolean studyDashboardStats) {
		this.studyDashboardStats = studyDashboardStats;
	}

	public void setStudyExcActiveTask(Boolean studyExcActiveTask) {
		this.studyExcActiveTask = studyExcActiveTask;
	}

	public void setStudyExcQuestionnaries(Boolean studyExcQuestionnaries) {
		this.studyExcQuestionnaries = studyExcQuestionnaries;
	}

	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}

	public void setStudySequenceId(Integer studySequenceId) {
		this.studySequenceId = studySequenceId;
	}
}
