package com.example.ykd.controller;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiTestController {

    @GetMapping("/test/ai")
    public String testAi() {
        try {
            Generation gen = new Generation();

            Message userMsg = Message.builder()
                    .role(Role.USER.getValue())
                    .content("你好，请说一句话")
                    .build();

            GenerationParam param = GenerationParam.builder()
                    .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                    .model("qwen-turbo")
                    .messages(java.util.Arrays.asList(userMsg))
                    .build();

            GenerationResult result = gen.call(param);

            // ✅ 旧版API用 getText() 获取结果
            String text = result.getOutput().getText();
            if (text != null && !text.isEmpty()) {
                return "✅ " + text;
            }
            return "⚠️ 返回为空";

        } catch (Exception e) {
            return "❌ " + e.getMessage();
        }
    }
}