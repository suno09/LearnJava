package abstract_factory2;

class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        Phone phone;

        PhoneFactory iphoneFactory = /* write your code here */new iPhoneFactory();
        PhoneFactory samsungFactory = /* write your code here */new SamsungFactory();

        System.out.println("-Hello, I need Android phone");
        System.out.println("-Okay! Please wait for a sec, - Calling to the SamsungFactory. -Bring me the Samsung Galaxy S10");
        Thread.sleep(1500);

        phone = /* write your code here */samsungFactory.createPhone();
        System.out.println(phone.getDescription());
        System.out.println("There it is!\n");

        System.out.println("-Hello, I need iOS phone");
        System.out.println("-Okay! Please wait for a sec, - Calling to the iPhoneFactory. -Bring me the iPhoneXS\"");
        Thread.sleep(1500);

        phone = /* write your code here */iphoneFactory.createPhone();
        System.out.println(phone.getDescription());
        System.out.println("There it is!");
    }
}

interface PhoneFactory {
    Phone createPhone();
}

class iPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        PhoneDetailsFactory detailsFactory = /* write your code here */new iPhoneDetailsFactory();

        return /* write your code here */new iPhone(detailsFactory);
    }
}

class SamsungFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        PhoneDetailsFactory detailsFactory = /* write your code here */new SamsungDetailFactory();

        return /* write your code here */new Samsung(detailsFactory);
    }
}

interface PhoneDetailsFactory {
    Camera createCamera();
    Display createDisplay();
    Processor createProcessor();
    Security createSecurity();
}

class iPhoneDetailsFactory implements PhoneDetailsFactory {
    @Override
    public Camera createCamera() {
        return /* write your code here */new iPhoneCamera();
    }

    @Override
    public Display createDisplay() {
        return /* write your code here */new iPhoneDisplay();
    }

    @Override
    public Processor createProcessor() {
        return /* write your code here */new iPhoneProcessor();
    }

    @Override
    public Security createSecurity() {
        return /* write your code here */new iPhoneSecurity();
    }
}

class SamsungDetailFactory implements PhoneDetailsFactory {
    @Override
    public Camera createCamera() {
        return /* write your code here */new SamsungCamera();
    }

    @Override
    public Display createDisplay() {
        return /* write your code here */new SamsungDisplay();
    }

    @Override
    public Processor createProcessor() {
        return /* write your code here */new SamsungProcessor();
    }

    @Override
    public Security createSecurity() {
        return /* write your code here */new SamsungSecurity();
    }
}

abstract class Phone {
    Camera camera;
    Display display;
    Processor processor;
    Security security;

    public abstract String getDescription();

    public String toString() {
        return "Camera: " + camera.toString() + "\n"
                + "Display: " + display.toString() + "\n"
                + "Processor: " + processor.toString() + "\n"
                + "Security: " + security.toString();
    }
}

class iPhone extends Phone {
    iPhone(PhoneDetailsFactory detailsFactory) {
        camera = /* write your code here */detailsFactory.createCamera();
        display = /* write your code here */detailsFactory.createDisplay();
        processor = /* write your code here */detailsFactory.createProcessor();
        security = /* write your code here */detailsFactory.createSecurity();
    }

    @Override
    public String getDescription() {
        return "This is THE iPhoneXs\n" + super.toString();
    }
}

class Samsung extends Phone {
    Samsung(PhoneDetailsFactory detailsFactory) {
        camera = /* write your code here */detailsFactory.createCamera();
        display = /* write your code here */detailsFactory.createDisplay();
        processor = /* write your code here */detailsFactory.createProcessor();
        security = /* write your code here */detailsFactory.createSecurity();
    }

    @Override
    public String getDescription() {
        return "Samsung Galaxy S10\n" + super.toString();
    }
}

interface Camera {
    String toString();
}

class iPhoneCamera implements Camera {
    @Override
    public String toString() {
        return "12MP";
    }
}

class SamsungCamera implements Camera {
    @Override
    public String toString() {
        return "16MP+12MP+12MP";
    }
}

interface Display {
    String toString();
}

class iPhoneDisplay implements Display {
    @Override
    public String toString() {
        return "5.8\" OLED";
    }
}

class SamsungDisplay implements Display {
    @Override
    public String toString() {
        return "6.1\" Dynamic AMOLED";
    }
}

interface Processor {
    String toString();
}

class iPhoneProcessor implements Processor {
    @Override
    public String toString() {
        return "A12";
    }
}

class SamsungProcessor implements Processor {
    @Override
    public String toString() {
        return "Exynos 9820";
    }
}

interface Security {
    String toString();
}

class iPhoneSecurity implements Security {
    @Override
    public String toString() {
        return "FaceID";
    }
}

class SamsungSecurity implements Security {
    @Override
    public String toString() {
        return "FingerPrint";
    }
}
