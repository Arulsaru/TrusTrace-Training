package com.trustrace.repository;
import com.trustrace.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Employee> getAllEmployee() {
        return mongoTemplate.findAll(Employee.class);
    }
    public Employee getOneEmployee(String employeeId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("employeeId").is(employeeId)), Employee.class);
    }
    public void create(Employee employee) {
        mongoTemplate.save(employee);
    }
    public void delete(String employeeId) {
        mongoTemplate.remove(Query.query(Criteria.where("employeeId").is(employeeId)), Employee.class);
    }
    public void update(Employee employee) {
        Query query = new Query().addCriteria(Criteria.where("employeeId").is(employee.getEmployeeId()));
        Update update = new Update();
        update.set("name", employee.getName());
        update.set("phoneNumber", employee.getPhoneNumber());
        update.set("email", employee.getEmail());
        mongoTemplate.findAndModify(query, update, Employee.class);
    }
    public List<Employee> getAllEmployeePaginated(String pageNumber, String pageSize) {
        Query query = new Query().skip(Integer.parseInt(pageNumber) * Integer.parseInt(pageSize)).limit(Integer.parseInt(pageSize));
        return mongoTemplate.find(query, Employee.class);
    }
}
