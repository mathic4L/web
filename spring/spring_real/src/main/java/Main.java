import com.me.beans.Person;
import com.me.config.ContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        System.out.println(context.getBean("person", Person.class));
        context.close();
    }
}
