package dz.sundev.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Controller
public class LocaleServiceController {

    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public ResponseEntity<Object> locale(
            @RequestParam(value = "language", required = false, defaultValue = "") String ln) {
        Map<String, String> properties = new HashMap<>();
        Resource resource = new ClassPathResource("messages" + (ln.isEmpty() ? "" : "_" + ln) + ".properties");
        try {
            Properties loadedProperties = PropertiesLoaderUtils.loadProperties(resource);
            loadedProperties.forEach((key, value) -> {
                properties.put(key.toString(), value.toString());
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(properties.values(), HttpStatus.OK);
    }
}
