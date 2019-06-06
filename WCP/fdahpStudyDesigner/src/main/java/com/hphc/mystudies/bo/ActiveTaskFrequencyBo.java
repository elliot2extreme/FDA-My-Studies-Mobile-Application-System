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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the active_task_frequencies database table.
 *
 * @author BTC
 */
@Entity
@Table(name = "active_task_frequencies")
@NamedQuery(name = "ActiveTaskFrequencyBo.findAll", query = "SELECT a FROM ActiveTaskFrequencyBo a")
public class ActiveTaskFrequencyBo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "active_task_id")
	private Integer activeTaskId;

	@Column(name = "frequency_date")
	private String frequencyDate;

	@Column(name = "frequency_time")
	private String frequencyTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_launch_study")
	private boolean isLaunchStudy = false;

	@Column(name = "is_study_life_time")
	private boolean isStudyLifeTime = false;

	public ActiveTaskFrequencyBo() {
		// Do nothing
	}

	public Integer getActiveTaskId() {
		return activeTaskId;
	}

	public String getFrequencyDate() {
		return this.frequencyDate;
	}

	public String getFrequencyTime() {
		return this.frequencyTime;
	}

	public Long getId() {
		return this.id;
	}

	/**
	 * @return the isLaunchStudy
	 */
	public boolean getIsLaunchStudy() {
		return isLaunchStudy;
	}

	/**
	 * @return the isStudyLifeTime
	 */
	public boolean getIsStudyLifeTime() {
		return isStudyLifeTime;
	}

	public void setActiveTaskId(Integer activeTaskId) {
		this.activeTaskId = activeTaskId;
	}

	public void setFrequencyDate(String frequencyDate) {
		this.frequencyDate = frequencyDate;
	}

	public void setFrequencyTime(String frequencyTime) {
		this.frequencyTime = frequencyTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param isLaunchStudy
	 *            the isLaunchStudy to set
	 */
	public void setIsLaunchStudy(boolean isLaunchStudy) {
		this.isLaunchStudy = isLaunchStudy;
	}

	/**
	 * @param isStudyLifeTime
	 *            the isStudyLifeTime to set
	 */
	public void setIsStudyLifeTime(boolean isStudyLifeTime) {
		this.isStudyLifeTime = isStudyLifeTime;
	}

}