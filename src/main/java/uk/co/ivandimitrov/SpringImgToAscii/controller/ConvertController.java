package uk.co.ivandimitrov.SpringImgToAscii.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import uk.co.ivandimitrov.SpringImgToAscii.util.ImageToAsciiConverter;

@Controller
public class ConvertController {

    @Autowired
    ImageToAsciiConverter converter;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("convert")
    public ModelAndView convert(@RequestParam(value = "imageUrl", required = false) String url,
            @RequestParam(value = "imageFile", required = false) MultipartFile file) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("image");
        mv.addObject("ascii", converter.convertImageToAscii(url, file));
        return mv;
    }

}