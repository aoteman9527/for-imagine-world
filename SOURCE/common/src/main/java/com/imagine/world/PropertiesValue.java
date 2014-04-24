package com.imagine.world;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by letuan on 4/22/14.
 */
@Component
public class PropertiesValue {

    @Value("${vbb.host}")
    public String VBB_HOST;

    @Value("${vbb.request.create.context}")
    public String VBB_REQUEST_CREATE_CONTEXT;

}
