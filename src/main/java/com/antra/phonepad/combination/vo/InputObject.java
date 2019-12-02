package com.antra.phonepad.combination.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InputObject {
    private String content;

    public InputObject() {

    }

    public InputObject(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
