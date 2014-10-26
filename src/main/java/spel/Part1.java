package spel;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import spel.beans.SimpleCup;
import spel.part1.Utils1;

import java.util.List;
import java.util.Map;

public class Part1 {

    private void init() {
        System.out.println("\n================ Part 1 ================");
    }

    public void run() throws NoSuchMethodException {
        init();

        SpelExpressionParser parser = new SpelExpressionParser();

        // Simple message
        Expression exp = parser.parseExpression("'Hello world!'");
        String value = (String) exp.getValue();
        System.out.println(value);

        // calling Java Bean property
        Expression exp1 = parser.parseExpression("'Hello world'.bytes");
        byte[] bytes = (byte[]) exp1.getValue();
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

        // evaluate litteral to list
        List<Integer> integers = (List<Integer>)parser.parseExpression("{1,2,3,4}").getValue();
        System.out.println(integers);

        // evaluate to nested list
        List<List<Integer>> nestedLists = (List<List<Integer>>) parser.parseExpression("{{1,2} ,{1,2}}").getValue();
        System.out.println(nestedLists);

        // evalutate to map
        Map<String,Integer> map = (Map<String, Integer>) parser.parseExpression("{name: 'Tom', age: 23}").getValue();
        System.out.println(map);

        // evaluate to nested map
        Map<Map<String,String>, Map<String, String>> nestedMap =
                (Map<Map<String,String>, Map<String, String>>)parser.parseExpression("{cup: {color: 'white', capacity: '350ml'}, coffe: {color: 'transparent', capacity: '200ml'}}").getValue();
        System.out.println(nestedMap);

        //  arrays
        System.out.println(((int[])parser.parseExpression("new int[4]").getValue()).length);
        System.out.println(((int[])parser.parseExpression("new int[] {1,2,3,4}").getValue()).length);

        // method invocations
        System.out.println(parser.parseExpression("new String('Example').contains('le')").getValue());

        // assigments
        SimpleCup cup2 = new SimpleCup("Green");
        StandardEvaluationContext context2 = new StandardEvaluationContext(cup2);

        parser.parseExpression("color").setValue(context2, "yellow");
        System.out.println(cup2);

        parser.parseExpression("color = 'brown'").getValue(context2);
        System.out.println(cup2);

        // types ,but java.lang do not need to be fully qualified other types must be
        System.out.println(parser.parseExpression("T(String)").getValue(Class.class));
        System.out.println(parser.parseExpression("T(java.util.Date)").getValue(Class.class));
        System.out.println(parser.parseExpression("T(java.util.Date).from(T(java.time.Instant).EPOCH)").getValue());

        // constructors  requires package name

        // variables #syntax
        SimpleCup cup3 = new SimpleCup("Red");
        StandardEvaluationContext context3 = new StandardEvaluationContext(cup3);
        context3.setVariable("newColor", "Grey");
        parser.parseExpression("color = #newColor").getValue(context3);
        System.out.println(cup3.getColor());

        // functions
        StandardEvaluationContext context4 = new StandardEvaluationContext();
        context4.registerFunction("reverseString", Utils1.class.getDeclaredMethod("reverseString", new Class[] {String.class}));
        System.out.println(parser.parseExpression("#reverseString('Tomasz')").getValue(context4));

    }
}