package dz.elit.serviceprovider1;

import dz.elit.serviceproviderinterface.spi.ServiceProviderInterface;

public class ServiceProvider1 implements ServiceProviderInterface {
    @Override
    public void printServiceName() {
        System.out.println("This is Service Provider 1");
    }
}
