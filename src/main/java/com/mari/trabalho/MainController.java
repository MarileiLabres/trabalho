package com.mari.trabalho;

import com.mari.trabalho.service.ValidaJson;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Base64;

@RestController
public class MainController {
    @GetMapping("/")
    public String index() {
        return "My Aplication SpringBoot - subiu!!!!";
    }
    
    @GetMapping("/teste")
    public String teste(){
        return "Chamada de teste!!!!!!!!";

    }

    @PostMapping("/api/valor")
    public String valor(@RequestBody String info){
        return "Informação recebida:"+info;

    }
    @GetMapping("/status")
    public String status(){
        OperatingSystemMXBean op = ManagementFactory.getOperatingSystemMXBean();
        return op.getArch() + " - " +op.getAvailableProcessors() + " - " +op.getName();
    }
    @GetMapping("/json")
    public String json(){
        JSONObject myjson = new JSONObject();
        myjson.put("ARQUITETURA DO PROCESSADOR","amd64");
        myjson.put("QUANTIDADE DE NUCLEOS DO PROCESSADOR",4);
        myjson.put("SITEMA OPERACIONAL"," WINDOWS 10 ");
        String dadocodificado = Base64.getEncoder().encodeToString(myjson.toString().getBytes());
        return  dadocodificado;
    }
    @PostMapping("/api/validacao")
    public String validacao(@RequestBody String info){
        ValidaJson validaJson = new ValidaJson();
        boolean isJson = validaJson.isJsonValid(info);
        return info + " Sucesso: " + isJson;
    }
}

