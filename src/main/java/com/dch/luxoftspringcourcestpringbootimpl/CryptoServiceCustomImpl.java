package com.dch.luxoftspringcourcestpringbootimpl;

import com.dch.crypto.CryptoService;
import org.springframework.stereotype.Component;

//@Component
public class CryptoServiceCustomImpl implements CryptoService {
    @Override
    public String decode(String s) {
        return s.replace("crypted:", "");
    }

    @Override
    public String encode(String s) {
        return String.format("crypted:%s", s);
    }
}
