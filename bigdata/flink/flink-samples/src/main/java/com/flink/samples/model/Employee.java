package com.flink.samples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    public int id;
    public String fname;
    public String lname;
    public int age;
    public String email;
}
