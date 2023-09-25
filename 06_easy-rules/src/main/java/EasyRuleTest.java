import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.FileReader;

public class EasyRuleTest {
    public static void main(String[] args) {

        Facts facts = new Facts();
        facts.put("rain", true);

        MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rule weatherRule = null;
        try {
            weatherRule = ruleFactory.createRule(new FileReader("weather-rule.yml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Rules rules = new Rules();
        rules.register(weatherRule);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}
