package br.com.opah.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opah.vo.NotificationVo;

@RestController
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    private NotificationVo notifications = new NotificationVo(0);

    @GetMapping("/notify")
    public String getNotification() {

        notifications.increment();

        template.convertAndSend("/topic/notification", notifications);

        return "Notifications successfully sent to Angular !";
    }
}