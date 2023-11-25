package com.desicabana.stalls.service;

import com.desicabana.stalls.model.Employee;
import com.desicabana.stalls.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setHireDate(employee.getHireDate());
            existingEmployee.setIdProof(employee.getIdProof());
            existingEmployee.setProfilePicture(employee.getProfilePicture());
            existingEmployee.setResume(employee.getResume());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public String storeFile(MultipartFile file) throws IOException {
        // Normalize file name
        Path uploadDir = Paths.get("./uploads");

        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        /*
         * could be used without using the FilenameUtils class
         */
        // Additional depenbdency required for FilenameUtils
        /* <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.8.0</version> <!-- Use the latest version available -->
        </dependency> */
        /* String extension = "";
        int i = originalFilename.lastIndexOf('.');
        if (i >= 0) {
           extension = originalFilename.substring(i+1);
        }
        String newFilename = UUID.randomUUID().toString() + "." + extension; */
        
        // TODO: Check if the file already exists in the uploads directory same file but different name
        // TODO: to handle any exceptions that may occur during the file upload process, such as file size limit exceeded, file not supported, etc.

        // Generate a unique filename using a UUID
        String originalFilename = file.getOriginalFilename();
        String newFilename = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(originalFilename);

        //Path filePath = uploadDir.resolve(file.getOriginalFilename());
        Path filePath = uploadDir.resolve(newFilename);
        file.transferTo(filePath);
        return filePath.toString();
    }
}
