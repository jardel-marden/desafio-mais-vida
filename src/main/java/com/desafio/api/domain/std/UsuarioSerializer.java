/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.domain.std;

import com.desafio.api.domain.Medico;
import com.desafio.api.domain.Usuario;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/**
 *
 * @author deoprog
 */
public class UsuarioSerializer extends StdSerializer<Usuario>{

    
    public UsuarioSerializer() {
        this(null);
    }       

    public UsuarioSerializer(Class<Usuario> t) {
        super(t);
    }           
    
    @Override
    public void serialize(Usuario value, JsonGenerator jgen, SerializerProvider sp) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("username", value.getUsername());        
        jgen.writeEndObject();
    }
    
}
