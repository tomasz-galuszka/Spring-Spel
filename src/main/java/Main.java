import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by tomasz on 25.10.14.
 *
 */
public class Main {

    public static void main(String[] args) {


        SpelExpressionParser parser = new SpelExpressionParser();

        // Simple message
        Expression exp = parser.parseExpression("'Hello world!'");
        String value = (String) exp.getValue();
        System.out.println(value);

        // calling Java Bean property
        Expression exp1 = parser.parseExpression("'Hello world'.bytes");
        byte [] bytes = (byte[]) exp1.getValue();
        System.out.println(bytes);

        // calling JavaBean nested property
        Expression exp2 = parser.parseExpression("'Hello world'.bytes.length");
        int length = (Integer) exp2.getValue();
        System.out.println(length);

        // calling JavaBean constructor and method inline
        Expression exp3 = parser.parseExpression("new String('Hello world').toUpperCase()");
        String upperCaseS = exp.getValue(String.class);

        // evaluate expresion to specific context
        SimpleCup simpleCup = new SimpleCup("White");
        StandardEvaluationContext context = new StandardEvaluationContext(simpleCup);

        Expression exp4 = parser.parseExpression("color");
        String color = exp4.getValue(context, String.class);
        System.out.println(color);


    }
}
