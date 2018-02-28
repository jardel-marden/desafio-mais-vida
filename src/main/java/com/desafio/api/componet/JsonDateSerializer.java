/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.componet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Date;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author deoprog
 */
@Component
public class JsonDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
        DateTime dateTime = new DateTime(t);
        jg.writeString(dateTime.toString("MM-dd-yyyy HH:mm:ss"));
    }
    
    
}
