package dz.elit.serviceproviderinterface;

import dz.elit.serviceproviderinterface.spi.ServiceProviderInterface;
import java.util.ServiceLoader;

public class Service {
    private static Service ourInstance = new Service();

    public static Service getInstance() {
        return ourInstance;
    }

    private Service() {}

    public void printServiceNames() {
        ServiceLoader <ServiceProviderInterface> serviceLoader = ServiceLoader.load(ServiceProviderInterface.class);
        serviceLoader.iterator().forEachRemaining(ServiceProviderInterface::printServiceName);
    }
}
