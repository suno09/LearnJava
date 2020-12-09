module dz.elit.serviceprovider2 {
    requires dz.elit.serviceproviderinterface;
    provides dz.elit.serviceproviderinterface.spi.ServiceProviderInterface with dz.elit.serviceprovider2.ServiceProvider2;
}