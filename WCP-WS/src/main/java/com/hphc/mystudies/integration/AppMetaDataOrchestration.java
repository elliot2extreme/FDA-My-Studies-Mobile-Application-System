/*******************************************************************************
 * Copyright © 2017-2019 Harvard Pilgrim Health Care Institute (HPHCI) and its Contributors. 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction,including without limitation the rights to use, copy,modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 * 
 * Funding Source: Food and Drug Administration (“Funding Agency”) effective 18 September 2014 as
 * Contract no. HHSF22320140030I/HHSF22301006T (the “Prime Contract”).
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/

package com.hphc.mystudies.integration;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hphc.mystudies.bean.AppResponse;
import com.hphc.mystudies.bean.AppUpdatesResponse;
import com.hphc.mystudies.bean.NotificationsResponse;
import com.hphc.mystudies.bean.StudyUpdatesResponse;
import com.hphc.mystudies.bean.TermsPolicyResponse;
import com.hphc.mystudies.dao.AppMetaDataDao;
import com.hphc.mystudies.exception.OrchestrationException;
import com.hphc.mystudies.util.Mail;
import com.hphc.mystudies.util.StudyMetaDataConstants;
import com.hphc.mystudies.util.StudyMetaDataUtil;

/**
 * App metadata service that communicates with app metadata
 * {@link AppMetaDataDao} repository.
 * 
 * @author BTC
 *
 */
public class AppMetaDataOrchestration {

	private static final Logger LOGGER = LogManager
			.getLogger(AppMetaDataOrchestration.class);

	@SuppressWarnings("unchecked")
	HashMap<String, String> propMap = StudyMetaDataUtil.getAppProperties();

	AppMetaDataDao appMetaDataDao = new AppMetaDataDao();

	/**
	 * Get terms and policy for the app
	 * 
	 * @author BTC
	 * @return {@link TermsPolicyResponse}
	 * @throws OrchestrationException
	 */
	public TermsPolicyResponse termsPolicy() throws OrchestrationException {
		LOGGER.info("INFO: AppMetaDataOrchestration - termsPolicy() :: Starts");
		TermsPolicyResponse termsPolicyResponse = new TermsPolicyResponse();
		try {
			termsPolicyResponse = appMetaDataDao.termsPolicy();
		} catch (Exception e) {
			LOGGER.error("AppMetaDataOrchestration - termsPolicy() :: ERROR", e);
		}
		LOGGER.info("INFO: AppMetaDataOrchestration - termsPolicy() :: Ends");
		return termsPolicyResponse;
	}

	/**
	 * Fetch available notifications
	 * 
	 * @author BTC
	 * @param skip
	 *            the skip count
	 * @param authorization
	 *            the Basic Authorization
	 * @return {@link NotificationsResponse}
	 * @throws OrchestrationException
	 */
	public NotificationsResponse notifications(String skip, String authorization)
			throws OrchestrationException {
		LOGGER.info("INFO: AppMetaDataOrchestration - notifications() :: Starts");
		NotificationsResponse notificationsResponse = new NotificationsResponse();
		try {
			notificationsResponse = appMetaDataDao.notifications(skip,
					authorization);
		} catch (Exception e) {
			LOGGER.error("AppMetaDataOrchestration - notifications() :: ERROR",
					e);
		}
		LOGGER.info("INFO: AppMetaDataOrchestration - notifications() :: Ends");
		return notificationsResponse;
	}

	/**
	 * Notify admin's about the feedback
	 * 
	 * @author BTC
	 * @param subject
	 *            the Subject Details
	 * @param body
	 *            the Body Details
	 * @return {@link AppResponse}
	 * @throws OrchestrationException
	 */
	public AppResponse feedback(String subject, String body)
			throws OrchestrationException {
		LOGGER.info("INFO: AppMetaDataOrchestration - feedback() :: Starts");
		AppResponse response = new AppResponse();
		Boolean flag = false;
		try {
			String feedbackSubject = "My Studies App Feedback: " + subject;
			String feedbackBody = "<div>"
					+ "<div><span>Hi</span></div><br>"
					+ "<div><span>A user of the FDA My Studies mobile app has provided feedback via the app. Here&#39;s the content of the feedback:</span></div><br>"
					+ "<div><span><i>"
					+ body
					+ "</i></span></div><br>"
					+ "<div>"
					+ "<span>Thanks,</span><br><span>"
					+ propMap.get("fda.smd.email.title")
					+ "</span><br>"
					+ "<span>---------------------------------------------------------</span><br>"
					+ "<span style='font-size:9px;'>PS - This is an auto-generated email. Please do not reply.</span>"
					+ "</div>" + "</div>";
			flag = Mail.sendemail(propMap.get("fda.smd.feedback"),
					feedbackSubject, feedbackBody);
			if (flag) {
				response.setMessage(StudyMetaDataConstants.SUCCESS);
			}
		} catch (Exception e) {
			LOGGER.error("AppMetaDataOrchestration - feedback() :: ERROR", e);
		}
		LOGGER.info("INFO: AppMetaDataOrchestration - feedback() :: Ends");
		return response;
	}

	/**
	 * Notify admin's about the user contact information
	 * 
	 * @author BTC
	 * @param subject
	 *            the Subject Details
	 * @param body
	 *            the Body Details
	 * @param firstName
	 *            the First Name
	 * @param email
	 *            the Email Details
	 * @return {@link AppResponse}
	 * @throws OrchestrationException
	 */
	public AppResponse contactUsDetails(String subject, String body,
			String firstName, String email) throws OrchestrationException {
		LOGGER.info("INFO: AppMetaDataOrchestration - contactUsDetails() :: Starts");
		AppResponse response = new AppResponse();
		Boolean flag = false;
		try {
			String contactUsSubject = "My Studies App HelpDesk: '" + subject
					+ "'";
			String contactUsContent = "<div>"
					+ "<div><span>Hi</span></div><br>"
					+ "<div style='padding-bottom:10px;'><span>A user of the FDA My Studies mobile app has reached out to the Helpdesk."
					+ " Below are the contact form details:</span></div>"
					+ "<div>"
					+ "<div>___________________________________________</div>"
					+ "<div style='padding-top:20px;'>First Name: "
					+ firstName
					+ "</div>"
					+ "<div style='padding-top:10px;'>Email: <a href='mailto:"
					+ email
					+ "'>"
					+ email
					+ "</a></div>"
					+ "<div style='padding-top:10px;'>Subject: "
					+ subject
					+ "</div>"
					+ "<div style='padding-top:10px;padding-bottom:10px'>Message: "
					+ body
					+ "</div>"
					+ "</div>"
					+ "<div>___________________________________________</div><br>"
					+ "<div style='padding-top:10px;'><span>Please respond to the app user at the email he/she has provided.</span></div><br>"
					+ "<div>"
					+ "<span>Thanks,</span><br><span>"
					+ propMap.get("fda.smd.email.title")
					+ "</span><br>"
					+ "<span>---------------------------------------------------------</span><br>"
					+ "<span style='font-size:9px;'>PS - This is an auto-generated email. Please do not reply.</span>"
					+ "</div>" + "</div>";
			flag = Mail.sendemail(propMap.get("fda.smd.contactus"),
					contactUsSubject, contactUsContent);

			if (flag) {
				response.setMessage(StudyMetaDataConstants.SUCCESS);
			}
		} catch (Exception e) {
			LOGGER.error(
					"AppMetaDataOrchestration - contactUsDetails() :: ERROR", e);
		}
		LOGGER.info("INFO: AppMetaDataOrchestration - contactUsDetails() :: Ends");
		return response;
	}

	/**
	 * Check for app updates
	 * 
	 * @author BTC
	 * @param appVersion
	 *            the App Version
	 * @param app
	 *            the Basic Authorization
	 * @return {@link AppUpdatesResponse}
	 * @throws OrchestrationException
	 */
	public AppUpdatesResponse appUpdates(String appVersion, String app)
			throws OrchestrationException {
		LOGGER.info("INFO: AppMetaDataOrchestration - appUpdates() :: Starts");
		AppUpdatesResponse appUpdates = new AppUpdatesResponse();
		try {
			appUpdates = appMetaDataDao.appUpdates(appVersion, app);
		} catch (Exception e) {
			LOGGER.error("AppMetaDataOrchestration - appUpdates() :: ERROR", e);
		}
		LOGGER.info("INFO: AppMetaDataOrchestration - appUpdates() :: Ends");
		return appUpdates;
	}

	/**
	 * Check for study updates
	 * 
	 * @author BTC
	 * @param studyId
	 *            the Study Identifier
	 * @param studyVersion
	 *            the Study Version
	 * @return {@link StudyUpdatesResponse}
	 * @throws OrchestrationException
	 */
	public StudyUpdatesResponse studyUpdates(String studyId, String studyVersion)
			throws OrchestrationException {
		LOGGER.info("INFO: AppMetaDataOrchestration - studyUpdates() :: Starts");
		StudyUpdatesResponse studyUpdates = new StudyUpdatesResponse();
		try {
			studyUpdates = appMetaDataDao.studyUpdates(studyId, studyVersion);
		} catch (Exception e) {
			LOGGER.error("AppMetaDataOrchestration - studyUpdates() :: ERROR",
					e);
		}
		LOGGER.info("INFO: AppMetaDataOrchestration - studyUpdates() :: Ends");
		return studyUpdates;
	}

	/**
	 * Update app version
	 * 
	 * @author BTC
	 * @param forceUpdate
	 *            the Force Update Flag
	 * @param osType
	 *            the Platform Type
	 * @param appVersion
	 *            the App Version
	 * @param bundleId
	 *            the Bundle Identifier
	 * @param customStudyId
	 *            the Study Name
	 * @param message
	 *            the Description about the Update
	 * @return the success or failure
	 * @throws OrchestrationException
	 */
	public String updateAppVersionDetails(String forceUpdate, String osType,
			String appVersion, String bundleId, String customStudyId,
			String message) throws OrchestrationException {
		LOGGER.info("INFO: AppMetaDataOrchestration - updateAppVersionDetails() :: Starts");
		String updateAppVersionResponse = "OOPS! Something went wrong.";
		try {
			updateAppVersionResponse = appMetaDataDao.updateAppVersionDetails(
					forceUpdate, osType, appVersion, bundleId, customStudyId,
					message);
		} catch (Exception e) {
			LOGGER.error(
					"AppMetaDataOrchestration - updateAppVersionDetails() :: ERROR",
					e);
		}
		LOGGER.info("INFO: AppMetaDataOrchestration - updateAppVersionDetails() :: Ends");
		return updateAppVersionResponse;
	}
}
