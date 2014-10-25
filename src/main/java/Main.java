import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spel.Part1;
import spel.Part2;
import spel.beans.SimpleCup;

/**
 * Created by tomasz on 25.10.14.
 */
public class Main {

    public static void main(String[] args) {
        new Part1().run();
        new Part2().run();

        // Part 3 spel in xml context
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"context.xml"});
        SimpleCup whiteCup = (SimpleCup) ctx.getBean("whiteCup");
        System.out.println(whiteCup);

        ((AbstractApplicationContext)ctx).registerShutdownHook();

    }
}
