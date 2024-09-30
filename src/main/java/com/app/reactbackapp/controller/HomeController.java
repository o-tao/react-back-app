package com.app.reactbackapp.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Server Start!";
    }

    @GetMapping("/form1")
    public Map<String, String> form1(@RequestParam Map<String, String> paramMap) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("token", setToken(paramMap));
        return resultMap;
    }

    @PostMapping("/form2")
    public Map<String, String> form2(@RequestBody Map<String, String> resultMap) {
        return resultMap;
    }

    private String setToken(Map<String, String> paramMap) {
        // 키 생성
        String strKey = "69db341155939ac8dccbfd800fcb89b1f3e105b488fe57c68d23773967053584";
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));

        // 유효 날짜 생성
        Calendar data = Calendar.getInstance();
        data.add(Calendar.MINUTE, 10);

        // Token 헤더 정보 생성
        Map<String, String> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        // Token Payload 영역에 사용자 이름 생성
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", paramMap.get("name"));

        // Token 발행
        return Jwts.builder()
                .header().add(header).and()
                .claims(userMap)
                .issuer("BackProject")
                .subject("UserInfo")
                .expiration(data.getTime())
                .issuedAt(Calendar.getInstance().getTime())
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

}
