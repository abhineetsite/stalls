package com.desicabana.stalls.controller.employee;

import com.desicabana.stalls.model.Employee;
import com.desicabana.stalls.model.FileUploadResponse;
import com.desicabana.stalls.repository.EmployeeRepository;
import com.desicabana.stalls.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestParam("idProof") MultipartFile idProof,
            @RequestParam("profilePicture") MultipartFile profilePicture,
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("employee") String employeeJson) throws IOException {
        Employee employee = new ObjectMapper().readValue(employeeJson, Employee.class);

        String idProofPath = employeeService.storeFile(idProof);
        String profilePicturePath = employeeService.storeFile(profilePicture);
        String resumePath = employeeService.storeFile(resume);

        employee.setIdProof(idProofPath);
        employee.setProfilePicture(profilePicturePath);
        employee.setResume(resumePath);

        return employeeService.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id,
            @RequestParam("idProof") MultipartFile idProof,
            @RequestParam("profilePicture") MultipartFile profilePicture,
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("employee") String employeeJson) throws IOException {
        Employee employee = new ObjectMapper().readValue(employeeJson, Employee.class);

        String idProofPath = employeeService.storeFile(idProof);
        String profilePicturePath = employeeService.storeFile(profilePicture);
        String resumePath = employeeService.storeFile(resume);

        employee.setIdProof(idProofPath);
        employee.setProfilePicture(profilePicturePath);
        employee.setResume(resumePath);

        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    
    // future use
    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile file) {

        FileUploadResponse response = new FileUploadResponse();
        try {
            String filePath = employeeService.storeFile(file); // or fileService.storeFile(file);
            response.setFilePath(filePath);
            response.setStatus("success");
            response.setMessage("File uploaded successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatus("failure");
            response.setMessage("Could not upload the file: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
