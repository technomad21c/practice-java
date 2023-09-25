package com.technomad.service.impl;

import com.technomad.service.NotificationService;

import javax.inject.Singleton;

@Singleton
public class SMSService implements NotificationService {
    public boolean sendNotification(String message, String recipient) {
        System.out.println("SMS has been sent to " + recipient);
        return true;
    }
}
