package com.mth.codesnippet.utils;

import com.intellij.notification.NotificationGroupManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.mth.codesnippet.constants.Constants;

/**
 * @author 木土禾
 * Created on 2022/11/15 22:40:18
 */
public class NotifyUtils {

    private NotifyUtils() {
    }

    public static void sendErrorMsg(Project project, String content) {
        NotificationGroupManager.getInstance().getNotificationGroup(Constants.NOTIFY_GROUP)
                .createNotification(content, MessageType.ERROR).notify(project);
    }

    public static void sendWarnMsg(Project project, String content) {
        NotificationGroupManager.getInstance().getNotificationGroup(Constants.NOTIFY_GROUP)
                .createNotification(content, MessageType.WARNING).notify(project);
    }

    public static void sendInfoMsg(Project project, String content) {
        NotificationGroupManager.getInstance().getNotificationGroup(Constants.NOTIFY_GROUP)
                .createNotification(content, MessageType.INFO).notify(project);
    }
}
