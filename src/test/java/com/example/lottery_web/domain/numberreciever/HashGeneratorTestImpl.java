package com.example.lottery_web.domain.numberreciever;

import com.example.lottery_web.domain.numberreciever.HashGenerable;

public class HashGeneratorTestImpl implements HashGenerable {


    private final String hash;

    HashGeneratorTestImpl(String hash) {
        this.hash = hash;
    }

    public HashGeneratorTestImpl() {
        hash = "123";
    }

    @Override
    public String getHash() {
        return hash;
    }
}
