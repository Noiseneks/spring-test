package com.github.Noiseneks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HelloController {

    @GetMapping("/")
    public HashMap<String, Integer> index(@RequestParam("line") String line) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < line.length(); ++i) {
            String ch = String.valueOf(line.charAt(i));
            map.merge(ch, 1, Integer::sum);
        }

        return map;
    }

}
