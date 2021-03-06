package com.cvicse.uploadmvc;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.NotNull;

@Component
//@Document(collection = "ExpresswayInfo")
@Document(indexName = "test")
public class ExpresswayInfo {
    @Id
    private String id;

    @NotNull
    private JSONObject content;

    public ExpresswayInfo() {
    }

    public ExpresswayInfo(JSONObject content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONObject getContent() {
        return content;
    }

    public void setContent(JSONObject content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ExpresswayTollInfo{" +
                "id='" + id + '\'' +
                ", content=" + content +
                '}';
    }
}