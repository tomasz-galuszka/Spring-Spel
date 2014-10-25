package spel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spel.beans.SimpleCoffe;
import spel.part4.Application;

/**
 * Created by tomasz on 25.10.14.
 */
public class Part4 {

    private void init() {
        System.out.println("\n================ Part 4 ================");
    }

    public void run() {
        init();

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        SimpleCoffe bean = ctx.getBean(SimpleCoffe.class);
        System.out.println(bean);

        ((AbstractApplicationContext)ctx).registerShutdownHook();


    }
}
