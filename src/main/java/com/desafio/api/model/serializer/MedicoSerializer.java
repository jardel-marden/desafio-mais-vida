/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.model.serializer;

import com.desafio.api.model.Medico;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/**
 *
 * @author deoprog
 */
public class MedicoSerializer extends StdSerializer<Medico>{

    
    public MedicoSerializer() {
        this(null);
    }       

    public MedicoSerializer(Class<Medico> t) {
        super(t);
    }           
    
    @Override
    public void serialize(Medico value, JsonGenerator jgen, SerializerProvider sp) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("nome", value.getNome());
        jgen.writeStringField("sobrenome", value.getSobreNome());
        jgen.writeStringField("especialidade", value.getEspecialidade().name());
        jgen.writeStringField("email", value.getEmail());
        jgen.writeStringField("ativo", String.valueOf(value.isAtivo()));
        jgen.writeStringField("status", value.getStatus().name());
        jgen.writeStringField("cidade", value.getCidade());
        jgen.writeStringField("cidade_id", String.valueOf(value.getCidadeId()));
        jgen.writeStringField("uf", value.getUf());
        jgen.writeStringField("uf_id", String.valueOf(value.getUfId()));
        jgen.writeEndObject();
    }
    
}
