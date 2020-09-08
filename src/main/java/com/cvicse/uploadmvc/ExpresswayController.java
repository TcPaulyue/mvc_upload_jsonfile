package com.cvicse.uploadmvc;


import com.alibaba.fastjson.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class ExpresswayController {

    private final ExpresswayRepository expresswayRepository;

    public ExpresswayController(ExpresswayRepository expresswayRepository) {
        this.expresswayRepository = expresswayRepository;
    }


//    @GetMapping(value = "/api/schemas")
//    public String getTestInfo(){
//        return "ok";
//    }


    @PostMapping(value = "/upload-filePart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ExpresswayInfo upload(@RequestParam("file") MultipartFile file) throws IOException {
        //System.out.println(CPUMonitorCalc.getInstance().getProcessCpu());
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        try{
            File file1 =new File("javaio-appendfile.txt");

            //if file doesnt exists, then create it
            if(!file1.exists()){
                file1.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(file1.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(content);
            bufferWritter.close();
            file1.delete();
        }catch(IOException e){
            e.printStackTrace();
        }
        JSONArray array = JSONArray.parseArray(content);
        //System.out.println(CPUMonitorCalc.getInstance().getProcessCpu());
        ExpresswayInfo expresswayInfo = new ExpresswayInfo(array.getJSONObject(0));
        return expresswayRepository.save(expresswayInfo);
       // System.out.println(CPUMonitorCalc.getInstance().getProcessCpu());
        // return expresswayInfo1;
    }
}
