package com.dch.luxoftspringcourcestpringbootimpl;

import com.dch.crypto.CryptoProperties;
import com.dch.crypto.CryptoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Objects;

@SpringBootTest
public class CustomStarterTests {

    @Autowired
    private CryptoService cryptoService;

    @Autowired
    private CryptoProperties cryptoProperties;

    @Test
    void notNullCryptoServiceTest() {
        Assert.notNull(cryptoService);
    }

    @Test
    void notNullPropertiesServiceTest() {
        Assert.notNull(cryptoProperties);
    }

    //For test @ConditionalOnMissingBean annotation - comment/uncomment annotation component on CryptoServiceCustomImpl class
    @Test
    void decodeTest() {
        String group = cryptoProperties.getGroupKey();
        String person = cryptoProperties.getPersonKey();
        String testPhrase = "Hello world";
        String inputMessage = String.format("%s%s%s", group, testPhrase, person);

        String result = cryptoService.decode(inputMessage);
        Assert.isTrue(Objects.equals(result, testPhrase)
                , String.format("\nInput:%s\nExpect:%s\nResult:%s", inputMessage, testPhrase, result));
    }

    //For test @ConditionalOnMissingBean annotation - comment/uncomment annotation component on CryptoServiceCustomImpl class
    @Test
    void encodeTest() {
        String group = cryptoProperties.getGroupKey();
        String person = cryptoProperties.getPersonKey();
        String inputMessage = "Hello world";
        String outputMessage = String.format("%s%s%s", group, inputMessage, person);

        String result = cryptoService.encode(inputMessage);
        Assert.isTrue(Objects.equals(outputMessage, result), String.format("\nInput:%s\nExpect:%s\nResult:%s", inputMessage, outputMessage, result));
    }
}
