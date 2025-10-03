package Lab;

import Lab.Beans.ScopedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Application {
    
    @Bean
    @Scope("singleton")
    public ScopedBean sampleBean(){
        return new ScopedBean();
    }

    /**
     * Use @Scope("prototype") to ensure a new instance is created 
     * each time the bean is requested
     */
    @Bean
    @Scope("prototype")
    public ScopedBean labBean(){
        return new ScopedBean();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        ScopedBean b1 = (ScopedBean) applicationContext.getBean("sampleBean");
        ScopedBean b2 = (ScopedBean) applicationContext.getBean("sampleBean");

        System.out.println("sampleBean is singleton-scoped, so any sampleBean retrieved from the app context ");
        System.out.println("should be the same object. Let's test it with ==, are b1 and b2 the same object?");
        
        if(b1 == b2){
            System.out.println("b1 and b2 are the same object.");
        }else{
            System.out.println("b1 and b2 are not the same object.");
        }
        
        ScopedBean b3 = (ScopedBean) applicationContext.getBean("labBean");
        ScopedBean b4 = (ScopedBean) applicationContext.getBean("labBean");

        System.out.println("You'll need to scope labBean such that b3 and b4 are different objects.");
        System.out.println("Let's test it with ==, are b3 and b4 the same object?");
        
        if(b3 == b4){
            System.out.println("failure: b3 and b4 are the same object.");
        }else{
            System.out.println("success: b3 and b4 are not the same object.");
        }
    }
}
