package ru.pflb.emulator.service.impl;

import org.springframework.stereotype.Service;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientDto getUserById(long id) {
        ClientDto one_client = ClientDto.builder()
                .id(id)
                .firstName(getRandomStringValue())
                .lastName(getRandomStringValue())
                .cardNumber(getRandomSequanceDigits(16))
                .isActive(getRandomBooleanValue())
                .build();
        return one_client;
    }
    private Integer getRandomIntValue(int start, int end){
        return (int)(start + Math.random()*end);
    }
    private boolean getRandomBooleanValue(){
        if (getRandomIntValue(0,99) < 50){
            return true;
        } else {
            return false;
        }
    }
    private String getRandomStringValue(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        int n = getRandomIntValue(7,10);
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    private String getRandomSequanceDigits(int sequanceLength){
        StringBuilder sb = new StringBuilder(sequanceLength);
        for(int i = 0; i < sequanceLength;i++){
            sb.append(getRandomIntValue(0,9));
        }
        return sb.toString();
    }
}