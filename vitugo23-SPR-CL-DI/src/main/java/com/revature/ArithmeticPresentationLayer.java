package com.revature;

import com.revature.components.Adder;
import com.revature.components.Multiplier;
import com.revature.components.Squarer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.revature.components")
@Component
public class ArithmeticPresentationLayer {

    // Field Injection
    @Autowired
    private Adder adder;

    // Setter Injection
    private Multiplier multiplier;
    @Autowired
    public void setMultiplier(Multiplier multiplier) {
        this.multiplier = multiplier;
    }

    // Constructor Injection
    private Squarer squarer;
    @Autowired
    public ArithmeticPresentationLayer(Squarer squarer) {
        this.squarer = squarer;
    }

    public static void main(String[] args) {
        // Use this main method for manual testing (optional)
        // Create the Spring container
        ApplicationContext context =  new AnnotationConfigApplicationContext(ArithmeticPresentationLayer.class);

        // Retrieve the RoryApplication bean from the container
        ArithmeticPresentationLayer app = context.getBean(ArithmeticPresentationLayer.class);
    }

    /**
     * @param a - number 1
     * @param b - number 2
     * @return the addition operation as a String, see tests for specific formatting
     */
    public String addConvertToString(double a, double b){
        return String.format("The result of %.1f + %.1f is %.1f", a, b, adder.add(a,b));
    }
    /**
     * @param a - number 1
     * @param b - number 2
     * @return the multiplication operation as a String, see tests for specific formatting
     */
    public String multiplyConvertToString(double a, double b){
        return String.format("The result of %.1f * %.1f is %.1f", a, b, multiplier.multiply(a,b));
    }

    /**
     * @param a - number 1
     * @return the square operation as a String, see tests for specific formatting
     */
    public String squareConvertToString(double a){
        return String.format("The result of %.1f squared is %.1f", a, squarer.getSquare(a));
    }
}