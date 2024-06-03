package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.Notification;
import biz.picosoft.demo.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepository;

    public Notification saveNotification(Notification notification) {
        //notification.setUsername(username);
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }


    public long countUnreadNotifications() {

        return notificationRepository.countBySeen(false);
    }

    public List<Notification> getNotificationsByUsername(String username) {
        return notificationRepository.findByUsername(username);
    }
    public void markNotificationsAsSeen(String username) {

        List<Notification> notifications = notificationRepository.findByUsernameAndSeenFalse(username);

        for (Notification notification : notifications) {
            notification.setSeen(true);
        }

        notificationRepository.saveAll(notifications);
    }

    public long countUnreadNotificationsByUsername(String username) {
        return notificationRepository.countByUsernameAndSeenFalse(username);
    }
}
