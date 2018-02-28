/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desafio.api.util;

import java.util.List;
import lombok.Data;

/**
 *
 * @author deoprog
 * @param <T>
 */
@Data
public class Response<T> {
    
    private T data;
    private List<String> errors;    
    
}
