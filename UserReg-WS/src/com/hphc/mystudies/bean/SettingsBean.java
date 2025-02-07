/*
 * Copyright © 2017-2019 Harvard Pilgrim Health Care Institute (HPHCI) and its Contributors. Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * Funding Source: Food and Drug Administration (“Funding Agency”) effective 18 September 2014 as Contract no. HHSF22320140030I/HHSF22301006T (the “Prime Contract”).
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.hphc.mystudies.bean;

/**
 * Created by Ravinder on 2/3/2017.
 */
public class SettingsBean
{
    private Boolean _remoteNotifications;
    private Boolean _localNotifications;
    private Boolean _touchId;
    private Boolean _passcode;
    private String _reminderLeadTime;
    private String _locale="";

    public Boolean getRemoteNotifications()
    {
        return _remoteNotifications;
    }

    public void setRemoteNotifications(Boolean remoteNotifications)
    {
        _remoteNotifications = remoteNotifications;
    }

    public Boolean getLocalNotifications()
    {
        return _localNotifications;
    }

    public void setLocalNotifications(Boolean localNotifications)
    {
        _localNotifications = localNotifications;
    }

    public Boolean getTouchId()
    {
        return _touchId;
    }

    public void setTouchId(Boolean touchId)
    {
        _touchId = touchId;
    }

    public Boolean getPasscode()
    {
        return _passcode;
    }

    public void setPasscode(Boolean passcode)
    {
        _passcode = passcode;
    }

    public String getReminderLeadTime()
    {
        return _reminderLeadTime;
    }

    public void setReminderLeadTime(String reminderLeadTime)
    {
        _reminderLeadTime = reminderLeadTime;
    }

    public String getLocale()
    {
        return _locale;
    }

    public void setLocale(String locale)
    {
        _locale = locale;
    }
}
