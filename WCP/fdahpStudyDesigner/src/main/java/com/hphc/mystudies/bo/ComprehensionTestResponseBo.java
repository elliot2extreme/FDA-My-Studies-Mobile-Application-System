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

/**
 * The persistent class for the comprehension_test_response database table.
 * 
 * @author BTC
 *
 */
@Entity
@Table(name = "comprehension_test_response")
public class ComprehensionTestResponseBo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7739882770594873383L;

	@Column(name = "comprehension_test_question_id")
	private Integer comprehensionTestQuestionId;

	@Column(name = "correct_answer")
	private Boolean correctAnswer;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "response_option")
	private String responseOption;

	public Integer getComprehensionTestQuestionId() {
		return comprehensionTestQuestionId;
	}

	public Boolean getCorrectAnswer() {
		return correctAnswer;
	}

	public Integer getId() {
		return id;
	}

	public String getResponseOption() {
		return responseOption;
	}

	public void setComprehensionTestQuestionId(
			Integer comprehensionTestQuestionId) {
		this.comprehensionTestQuestionId = comprehensionTestQuestionId;
	}

	public void setCorrectAnswer(Boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setResponseOption(String responseOption) {
		this.responseOption = responseOption;
	}

}
