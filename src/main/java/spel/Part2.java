package spel;

import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomasz on 25.10.14.
 */
public class Part2 {

    class Simple  {
        public List<Boolean> booleanList = new ArrayList<Boolean>();
        public List<String> stringList = new ArrayList<String>();
    }

    private void init() {
        System.out.println("\n================ Part 2 ================");
    }

    public void run() {
        init();

        // Dynamic conversion

        Simple simple = new Simple();
        simple.booleanList.add(true);

        StandardEvaluationContext contex = new StandardEvaluationContext(simple);
        SpelExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(contex, false);

        Boolean aBoolean = simple.booleanList.get(0);
        System.out.println(aBoolean);

        // Parser configuration
        SpelParserConfiguration parserConfiguration = new SpelParserConfiguration(true, true);
        SpelExpressionParser parser2 = new SpelExpressionParser(parserConfiguration);
        Boolean value = parser2.parseExpression("stringList[1]").getValue(simple, Boolean.class);
        System.out.println(value);




    }
}
