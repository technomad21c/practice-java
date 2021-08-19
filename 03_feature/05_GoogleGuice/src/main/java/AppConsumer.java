import com.technomad.service.NotificationService;

import javax.inject.Inject;

public class AppConsumer {
    private NotificationService notificationService;

    @Inject
    public void setService(NotificationService service) {
        this.notificationService = service;
    }

    public boolean sendNotification(String message, String recipient) {
        return notificationService.sendNotification(message, recipient);
    }
}
