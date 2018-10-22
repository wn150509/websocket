package com.example.websocket.controller;

import com.example.websocket.config.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value = "/socket")
public class WebSocketController {
    //推送数据接口
    @RequestMapping("/push")
    public String pushMsg(HttpServletRequest request) {
        String message=request.getParameter("info");
        try {
            WebSocketServer.sendInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
