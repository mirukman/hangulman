package com.mirukman.hangulman.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = {HangulEnglishKeyTransformer.class})
public class HangulEnglishKeyTransformerTest {

    HangulEnglishKeyTransformer hangulEnglishKeyTransformer = new HangulEnglishKeyTransformer();

    @Test
    public void transformHangulToEnglishTest() {
        
        //노멀
        assertEquals("rkskekfk", hangulEnglishKeyTransformer.transformHangulToEnglish("가나다라"));
        assertEquals("gksrmfaos", hangulEnglishKeyTransformer.transformHangulToEnglish("한글맨"));
        assertEquals("rldjqdmsogd", hangulEnglishKeyTransformer.transformHangulToEnglish("기업으냏ㅇ"));
        assertEquals("tlstprP", hangulEnglishKeyTransformer.transformHangulToEnglish("신세계"));
        assertEquals("skRtldydvna", hangulEnglishKeyTransformer.transformHangulToEnglish("낚시용품"));

        //띄어쓰기
        assertEquals("gks rmfaos", hangulEnglishKeyTransformer.transformHangulToEnglish("한 글맨"));
        assertEquals("gksrm faos", hangulEnglishKeyTransformer.transformHangulToEnglish("한그 ㄹ맨"));
        assertEquals("wpsptltm znvp tlwjehdj", hangulEnglishKeyTransformer.transformHangulToEnglish("제네시스 쿠페 시저도어"));

        //이중모음
        assertEquals("dhksehrns", hangulEnglishKeyTransformer.transformHangulToEnglish("완도군"));
        assertEquals("dnjswnshdguq", hangulEnglishKeyTransformer.transformHangulToEnglish("원주농협"));
        assertEquals("dnpqgkem", hangulEnglishKeyTransformer.transformHangulToEnglish("웹하드"));


        //겹받침
        assertEquals("rkqtdjcl", hangulEnglishKeyTransformer.transformHangulToEnglish("값어치"));
        assertEquals("rkqtdjcl", hangulEnglishKeyTransformer.transformHangulToEnglish("갑ㅅ어치"));
        assertEquals(hangulEnglishKeyTransformer.transformHangulToEnglish("값어치"),
                hangulEnglishKeyTransformer.transformHangulToEnglish("갑ㅅ어치"));
        assertEquals("tlfmatlfmadkfgdmaus", hangulEnglishKeyTransformer.transformHangulToEnglish("시름시름앓으면"));
        assertEquals("tlfmatlfmadkfgdmaus", hangulEnglishKeyTransformer.transformHangulToEnglish("시름시름알ㅎ으면"));
        assertEquals(hangulEnglishKeyTransformer.transformHangulToEnglish("시름시름앓으면"),
                hangulEnglishKeyTransformer.transformHangulToEnglish("시름시름알ㅎ으면"));

        //영어포함
        assertEquals("wjdtkddjgkrdnjs", hangulEnglishKeyTransformer.transformHangulToEnglish("wjdtkddjgkrdnjs"));
        assertEquals("dnlenfkd", hangulEnglishKeyTransformer.transformHangulToEnglish("dnlenfkd"));
        assertEquals("benzyi chloride", hangulEnglishKeyTransformer.transformHangulToEnglish("benzyi chloride"));

        //특수 기호
        assertEquals("tneh 25*13fpebti", hangulEnglishKeyTransformer.transformHangulToEnglish("수도 25*13fpebti"));
        assertEquals("ghaxortm\\", hangulEnglishKeyTransformer.transformHangulToEnglish("홈택스\\"));
        assertEquals("s[d;qk", hangulEnglishKeyTransformer.transformHangulToEnglish("ㄴ[ㅇ;바"));
        assertEquals("znvkdqhtkd.com", hangulEnglishKeyTransformer.transformHangulToEnglish("쿠팡보상.채ㅡ"));

    }

    @Test
    public void transformEnglishToHangulTest() {

        //노멀
        assertEquals("가나다라", hangulEnglishKeyTransformer.transformEnglishToHangul("rkskekfk"));
        assertEquals("원주농협", hangulEnglishKeyTransformer.transformEnglishToHangul("dnjswnshdguq"));
        assertEquals("기업으냏ㅇ", hangulEnglishKeyTransformer.transformEnglishToHangul("rldjqdmsogd"));

        //띄어쓰기
        assertEquals("줌 인터넷", hangulEnglishKeyTransformer.transformEnglishToHangul("wna dlsxjspt"));
        assertEquals("줌이 ㄴ터넷", hangulEnglishKeyTransformer.transformEnglishToHangul("wnadl sxjspt"));
        assertEquals("제네시스 쿠페 시저도어", hangulEnglishKeyTransformer.transformEnglishToHangul("wpsptltm znvp tlwjehdj"));

        //이중모음
        assertEquals("유롸리그", hangulEnglishKeyTransformer.transformEnglishToHangul("dbfhkflrm"));
        assertEquals("원주농협", hangulEnglishKeyTransformer.transformEnglishToHangul("dnjswnshdguq"));
        assertEquals("웹하드", hangulEnglishKeyTransformer.transformEnglishToHangul("dnpqgkem"));

        //겹받침
        assertEquals("값어치", hangulEnglishKeyTransformer.transformEnglishToHangul("rkqtdjcl"));
        assertEquals("시름시름앓으면", hangulEnglishKeyTransformer.transformEnglishToHangul("tlfmatlfmadkfgdmaus"));


        //영어포함
        assertEquals("정상어학원", hangulEnglishKeyTransformer.transformEnglishToHangul("wjdtkddjgkrdnjs"));
        assertEquals("위두랑", hangulEnglishKeyTransformer.transformEnglishToHangul("dnlenfkd"));
        assertEquals("ㅠ두쿄ㅑ 최ㅐ걍ㄷ", hangulEnglishKeyTransformer.transformEnglishToHangul("benzyi chloride"));

        //특수기호
        assertEquals("수도 25*13레듀샤", hangulEnglishKeyTransformer.transformEnglishToHangul("tneh 25*13fpebti"));
        assertEquals("홈택스\\", hangulEnglishKeyTransformer.transformEnglishToHangul("ghaxortm\\"));
        assertEquals("쿠팡보상.채ㅡ", hangulEnglishKeyTransformer.transformEnglishToHangul("znvkdqhtkd.com"));

    }
}
