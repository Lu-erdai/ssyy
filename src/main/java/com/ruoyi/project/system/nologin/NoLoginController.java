package com.ruoyi.project.system.nologin;

import com.ruoyi.project.system.skyzt.domain.SkyZt;
import com.ruoyi.project.system.skyzt.service.ISkyZtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class NoLoginController {

    @Autowired
    private ISkyZtService iSkyZtService;

    @GetMapping("/skyWeb/skydp")
    public String exemptLogin(ModelMap mmap) {


        SkyZt skyZt = iSkyZtService.selectSkyZtById(1L);
        String ztUrl = skyZt.getZtUrl();

        mmap.put("ztUrl",ztUrl);
        return "skydp3";
    }



}
