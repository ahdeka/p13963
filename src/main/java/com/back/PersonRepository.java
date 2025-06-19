package com.back;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonRepository {
    private final int version;

    public long count() {
        System.out.println("PersonRepository version: " + version);
        return 3;
    }

}
