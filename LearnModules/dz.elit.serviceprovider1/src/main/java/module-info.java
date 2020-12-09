module dz.elit.serviceprovider1 {
    requires dz.elit.serviceproviderinterface;
    provides dz.elit.serviceproviderinterface.spi.ServiceProviderInterface with dz.elit.serviceprovider1.ServiceProvider1;
}
