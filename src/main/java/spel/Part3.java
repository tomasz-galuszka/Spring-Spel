package spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spel.beans.SimpleCup;

public class Part3 {

    private void init() {
        System.out.println("\n================ Part 3 ================");
    }

    public void run() {
        init();

        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"context.xml"});
        System.out.println((SimpleCup) ctx.getBean("whiteCup"));
        System.out.println((SimpleCup) ctx.getBean("transparentCup"));

        ((AbstractApplicationContext) ctx).registerShutdownHook();
    }
}