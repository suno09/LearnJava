package dz.sundev.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncryptedTransaction {
    String userId;
    //AES encrypted transaction information
    String payload;
    //RSA encypted AES key
    String encAesKey;
}