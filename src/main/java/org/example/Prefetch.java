package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Prefetch {

    public static List<StudentRecord> studentRecords = new ArrayList<>();

    static {
        String filePath = "D:\\SA\\src\\main\\resources\\StudentRecords.json";
        getSampleDate();
    }
    public static List<StudentRecord> getSampleDate(){
        String filePath = "D:\\SA\\src\\main\\resources\\StudentRecords.json";
        studentRecords = parseStudentRecordsFromFile(filePath);
        return studentRecords;
    }

    private static java.util.List parseStudentRecordsFromFile(String filepath){
        List<StudentRecord> studentRecords = new ArrayList<>();

        try {
            File file = new File(filepath);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            JsonNode jsonNode = objectMapper.readTree(file);
            for (JsonNode studentNode : jsonNode) {
                StudentRecord studentRecord = objectMapper.treeToValue(studentNode, StudentRecord.class);
                studentRecords.add(studentRecord);
            }
        } catch (IOException e){
            e.printStackTrace();
            // Handle the exception according to your requirements
        }

        return studentRecords;
    }

}
