package dz.elit.jpmshello;

import dz.elit.jpmshi.HiModules;
import dz.elit.serviceproviderinterface.Service;
import java.lang.reflect.Method;

import static javax.xml.XMLConstants.XML_NS_PREFIX;

public class HelloModules {
    public static void main(String[] args) {
        System.out.println("Hello Modules!");
        System.out.println("The XML namespace prefix is: " + XML_NS_PREFIX);

        HiModules hiModules = new HiModules();
        System.out.println(hiModules.getHi());

        checkExportsDirectiveWithReflection();

        checkProvidesWith();
    }

    private static void checkExportsDirectiveWithReflection() {
        try {
            Class c = Class.forName("dz.elit.jpmsopens.OpensModules");
            Method m = c.getMethod("getHiOpens");
            System.out.println(m.invoke(c.getDeclaredConstructor().newInstance()));
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    private static void checkProvidesWith() {
        Service service = Service.getInstance();
        service.printServiceNames();
    }

}
