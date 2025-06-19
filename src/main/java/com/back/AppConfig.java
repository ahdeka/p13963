package com.back;

import com.back.domain.member.member.entity.Member;
import com.back.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final MemberService memberService;


    @Autowired
    @Lazy
    private AppConfig self;

    @Bean
    int version() {
        return 55;
    }

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            this.work1();
            this.work2();
        };
    }

    @Transactional
    private void work1() {
        if (memberService.count() > 0) return;

        Member memberSystem = memberService.join("system", "1234", "시스템");
        Member memberAdmin = memberService.join("admin", "1234", "관리자");
        Member memberUser1 = memberService.join("user1", "1234", "사용자1");
        Member memberUser2 = memberService.join("user2", "1234", "사용자2");
        Member memberUser3 = memberService.join("user3", "1234", "사용자3");
    }

    @Transactional
    private void work2() {
        Member member2 = memberService.findByUsername("user2").get();

        member2.setNickname("유저2 New");
    }

}
