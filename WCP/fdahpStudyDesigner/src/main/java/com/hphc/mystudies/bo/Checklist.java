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
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * The persistent class for the study_checklist database table.
 * 
 * @author BTC
 *
 */

@Entity
@Table(name = "study_checklist")
@NamedQueries({ @NamedQuery(name = "getchecklistInfo", query = "SELECT CBO FROM Checklist CBO WHERE CBO.studyId =:studyId"), })
public class Checklist implements Serializable {

	private static final long serialVersionUID = 7206666243059395497L;

	@Column(name = "checkbox1", length = 1)
	private Boolean checkbox1 = false;

	@Column(name = "checkbox10", length = 1)
	private Boolean checkbox10 = false;

	@Column(name = "checkbox11", length = 1)
	private Boolean checkbox11 = false;

	@Column(name = "checkbox12", length = 1)
	private Boolean checkbox12 = false;

	@Column(name = "checkbox2", length = 1)
	private Boolean checkbox2 = false;

	@Column(name = "checkbox3", length = 1)
	private Boolean checkbox3 = false;

	@Column(name = "checkbox4", length = 1)
	private Boolean checkbox4 = false;

	@Column(name = "checkbox5", length = 1)
	private Boolean checkbox5 = false;

	@Column(name = "checkbox6", length = 1)
	private Boolean checkbox6 = false;

	@Column(name = "checkbox7", length = 1)
	private Boolean checkbox7 = false;

	@Column(name = "checkbox8", length = 1)
	private Boolean checkbox8 = false;

	@Column(name = "checkbox9", length = 1)
	private Boolean checkbox9 = false;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checklist_id")
	private Integer checklistId;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_on")
	private String createdOn;

	@Column(name = "custom_study_id")
	private String customStudyId;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_on")
	private String modifiedOn;

	@Column(name = "study_id")
	private Integer studyId;

	public Integer getChecklistId() {
		return checklistId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public String getCustomStudyId() {
		return customStudyId;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public Integer getStudyId() {
		return studyId;
	}

	public Boolean isCheckbox1() {
		return checkbox1;
	}

	public Boolean isCheckbox10() {
		return checkbox10;
	}

	public Boolean isCheckbox11() {
		return checkbox11;
	}

	public Boolean isCheckbox12() {
		return checkbox12;
	}

	public Boolean isCheckbox2() {
		return checkbox2;
	}

	public Boolean isCheckbox3() {
		return checkbox3;
	}

	public Boolean isCheckbox4() {
		return checkbox4;
	}

	public Boolean isCheckbox5() {
		return checkbox5;
	}

	public Boolean isCheckbox6() {
		return checkbox6;
	}

	public Boolean isCheckbox7() {
		return checkbox7;
	}

	public Boolean isCheckbox8() {
		return checkbox8;
	}

	public Boolean isCheckbox9() {
		return checkbox9;
	}

	public void setCheckbox1(Boolean checkbox1) {
		this.checkbox1 = checkbox1;
	}

	public void setCheckbox10(Boolean checkbox10) {
		this.checkbox10 = checkbox10;
	}

	public void setCheckbox11(Boolean checkbox11) {
		this.checkbox11 = checkbox11;
	}

	public void setCheckbox12(Boolean checkbox12) {
		this.checkbox12 = checkbox12;
	}

	public void setCheckbox2(Boolean checkbox2) {
		this.checkbox2 = checkbox2;
	}

	public void setCheckbox3(Boolean checkbox3) {
		this.checkbox3 = checkbox3;
	}

	public void setCheckbox4(Boolean checkbox4) {
		this.checkbox4 = checkbox4;
	}

	public void setCheckbox5(Boolean checkbox5) {
		this.checkbox5 = checkbox5;
	}

	public void setCheckbox6(Boolean checkbox6) {
		this.checkbox6 = checkbox6;
	}

	public void setCheckbox7(Boolean checkbox7) {
		this.checkbox7 = checkbox7;
	}

	public void setCheckbox8(Boolean checkbox8) {
		this.checkbox8 = checkbox8;
	}

	public void setCheckbox9(Boolean checkbox9) {
		this.checkbox9 = checkbox9;
	}

	public void setChecklistId(Integer checklistId) {
		this.checklistId = checklistId;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public void setCustomStudyId(String customStudyId) {
		this.customStudyId = customStudyId;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}
}
