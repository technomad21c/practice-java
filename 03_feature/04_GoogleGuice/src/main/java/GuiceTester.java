import com.google.inject.Guice;
import com.google.inject.Injector;
import com.technomad.TextEditor;
import com.technomad.TextEditorModule;
import com.technomad.service.SpellChecker;
import com.technomad.service.SpellCheckerImpl;

public class GuiceTester {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TextEditorModule());
        SpellChecker spellChecker = new SpellCheckerImpl();
        injector.injectMembers(spellChecker);

        TextEditor editor = injector.getInstance(TextEditor.class);
        editor.makeSpellCheck();
    }
}
