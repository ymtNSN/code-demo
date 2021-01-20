package com.example.demo.design.factoryabstract;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public class Demo {

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.equals("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }
}
