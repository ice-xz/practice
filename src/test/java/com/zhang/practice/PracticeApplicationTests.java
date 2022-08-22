package com.zhang.practice;

import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.CompareTo;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
class PracticeApplicationTests {

    @Test
    void contextLoads() {
        String s = "0123";
        Integer t = Integer.parseInt(s);
        System.out.println(t);
    }

}
