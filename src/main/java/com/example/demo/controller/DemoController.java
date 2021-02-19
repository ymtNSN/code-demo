package com.example.demo.controller;

import com.example.demo.event.PayService;
import com.example.demo.response.R;
import com.example.demo.service.DemoService;
//import com.user.sdk.annotation.HpcUserPermission;
//import com.user.sdk.controller.BaseController;
//import com.user.sdk.response.AppUserVO;
//import com.user.sdk.response.BaseResponse;
//import com.hpcang.icposauth.sdk.annotation.HasPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by @author ymtNSN on 2020/4/8
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private PayService payService;

    //    @HpcUserPermission
    @GetMapping("/test")
//    @HasPermission("deviceMng:device:getDetail")
    public R test() {
//        Long userId = this.getUserId();
//        BaseResponse<AppUserVO> demo = demoService.demo(userId);
        demoService.testDest();
//        System.out.println("ddgdsg");
//        throw new NullPointerException("wo de wen ti");
        return R.ok();
    }

    @GetMapping("/test2")
    public R test2() {
//        Long userId = this.getUserId();
//        return demoService.demo(userId);
        new ArrayList<>().stream().collect(Collectors.toList());
        return R.ok();
    }

    @PostMapping("ymt")
    public void ymt(@RequestParam String sb) {
        payService.paySuccess(sb);
    }
}
