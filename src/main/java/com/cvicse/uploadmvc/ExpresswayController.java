package com.cvicse.uploadmvc;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class ExpresswayController {

    private final ExpresswayRepository expresswayRepository;

    public ExpresswayController(ExpresswayRepository expresswayRepository) {
        this.expresswayRepository = expresswayRepository;
    }


    @PostMapping(value = "/upload-filePart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ExpresswayInfo upload(@RequestParam("file") MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        ExpresswayInfo expresswayInfo = new ExpresswayInfo(JSONObject.parseObject(content));
        return expresswayRepository.save(expresswayInfo);
    }
}
