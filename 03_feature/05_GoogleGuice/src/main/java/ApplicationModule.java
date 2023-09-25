import com.google.inject.AbstractModule;
import com.technomad.service.NotificationService;
import com.technomad.service.impl.SMSService;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NotificationService.class).to(SMSService.class);
    }
}
