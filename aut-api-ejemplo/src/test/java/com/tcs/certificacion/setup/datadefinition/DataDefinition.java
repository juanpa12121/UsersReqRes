package com.tcs.certificacion.setup.datadefinition;

import com.tcs.certificacion.enums.Constants;
import com.tcs.certificacion.models.Employee;
import io.cucumber.java.DataTableType;

import java.util.Map;

import static com.tcs.certificacion.enums.Constants.*;

public class DataDefinition {
    @DataTableType
    public Employee employeeEntry(Map<String, String> entry){
        return new Employee(entry.get(NAME),entry.get(JOB));
    }
}
