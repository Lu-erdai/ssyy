package com.ruoyi.project.system.user.controller;

import com.ruoyi.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/exemptLog")
public class ExemptLoginController extends BaseController
{


    @GetMapping("/exemptLoginslqfnc")
    public String exemptLoginslqfnc()
    {

        return "exemptLoginslqfnc";
    }
    @GetMapping("/exemptLoginzlscy")
    public String exemptLoginzlscy()
    {

        return "exemptLoginzlscy";
    }
    @GetMapping("/exemptLogincmzqh")
    public String exemptLogincmzqh()
    {

        return "exemptLogincmzqh";
    }
    @GetMapping("/exemptLoginscsxb")
    public String exemptLoginscsxb()
    {

        return "exemptLoginscsxb";
    }



}




