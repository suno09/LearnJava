package dz.elit.serviceprovider2;

import dz.elit.serviceproviderinterface.spi.ServiceProviderInterface;

public class ServiceProvider2 implements ServiceProviderInterface {
    @Override
    public void printServiceName() {
        System.out.println("This is Service Provider 2");
    }
}
