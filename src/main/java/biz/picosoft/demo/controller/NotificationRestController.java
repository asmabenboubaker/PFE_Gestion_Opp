package biz.picosoft.demo.controller;


import biz.picosoft.demo.domain.Notification;
import biz.picosoft.demo.service.impl.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationRestController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PutMapping("/mark-as-seen/{username}")
    public ResponseEntity<Void> markNotificationsAsSeen(@PathVariable String username) {
        notificationService.markNotificationsAsSeen(username);
        return ResponseEntity.ok().build();
    }
}
