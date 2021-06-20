package com.geek.lesson7.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geek.lesson7.feign.StudentsFeignClient;
import com.geek.lesson7.models.Student;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Component
public class JspUsers {

    private static StudentsFeignClient studentFeignClient;

    public static List<Student> getAllStudents() {
        return studentFeignClient.findAll();
    }


}
