package com.imagine.world.mvc.model.bom;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by letuan on 6/9/14.
 */
@Component("ShopBomService")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShopBOMModel {
    List<MultipartFile> multipartFileList = new LinkedList<>();

    public List<MultipartFile> getMultipartFileList() {
        return multipartFileList;
    }

    public void setMultipartFileList(List<MultipartFile> multipartFileList) {
        this.multipartFileList = multipartFileList;
    }

    public void addMultipartFileList(MultipartFile file){
        this.multipartFileList.add(file);
    }

    public void clearMultipartFileList(){
        this.multipartFileList.clear();
    }
}
