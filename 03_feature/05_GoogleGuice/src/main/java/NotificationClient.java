import com.google.inject.Guice;
import com.google.inject.Injector;

public class NotificationClient {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ApplicationModule());
        AppConsumer app = injector.getInstance(AppConsumer.class);
        app.sendNotification("hello", "123456789");
    }
}
