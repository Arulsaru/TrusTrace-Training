const express = require('express');
const body = require('body-parser');
const _ = require('lodash');
const fs = require('fs');
const {MAX_LIMIT} = require('./constant.js');
var cors = require('cors');

const app = express();
app.use(body.json());
app.use(cors());

const port = 8000;

app.use(function (req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
    next();
});

function parseJSON() {
    const data = fs.readFileSync('employee-details.json');
    return JSON.parse(data);
}

app.get('/employees', (req, res) => {
    const employees = parseJSON();
    res.json(employees)
    return false;
})  

app.get('/employees/pagination', (req, res) => {
    const employees = parseJSON();
    let pageNumber = parseInt(req.query.page);
    let limit = parseInt(req.query.limit);

    !pageNumber ? pageNumber = 1 : null;
    !limit ? limit = 30 : null;
    MAX_LIMIT < limit ? limit = MAX_LIMIT : null;

    const startIdx = (pageNumber - 1) * limit;
    const endIdx = pageNumber * limit;
    const result = employees.slice(startIdx, endIdx);
    const perPage = employees.length / limit;

    const data = {
        page: pageNumber,
        per_page: limit,
        total: employees.length,
        total_pages: Math.ceil(perPage),
        details: result
    }

    res.send(data);
    return false;
})

app.post('/employees/create', (req, res) => {
    const employees = parseJSON();
    const employee = _.find(employees, {'phone_number': parseInt(req.body.phone_number)});

    console.log(employee);
    if (employee) {
        res.status(400).json({err: 'This phone number is already in use'});
        return false;
    }

    const ids = employees.map(object => {
        return object.user_id;
    })
    const input = req.body;
    const maxId = _.max(ids) + 1;
    input.user_id = maxId;
    employees.push(input);
    fs.writeFileSync('./employee-details.json', JSON.stringify(employees));
    res.json({msg: 'New Employee has been created and updated successfully'});
    return false;
})

app.put('/employees/:user_id/update', (req, res) => {

    const employees = parseJSON();
    let flag = 1;
    const idx = _.findIndex(employees, {'user_id': parseInt(req.params['user_id'])});

    if (idx === -1) {
        res.status(400).json({err: 'No user id found'});
        return false;
    }

    const tempEmployees = employees.map((tempEmployee, tempIdx) => {

        if (idx !== tempIdx) {
            return tempEmployee;
        }

    });

    if (req.body.first_name) {
        employees[idx].first_name = req.body.first_name;
        flag = 0;
    }

    if (req.body.last_name) {
        employees[idx].last_name = req.body.last_name;
        flag = 0;
    }

    if (req.body.phone_number) {
        flag = 0;
        const numberCheck = _.find(tempEmployees, {'phone_number': parseInt(req.body.phone_number)});

        if (numberCheck) {
            res.status(400).json({err: 'This phone number is already in use'});
            return false;
        }

        employees[idx].phone_number = parseInt(req.body.phone_number);
    }

    if (flag) {
        res.status(400).json({err: 'No operations donee'});
        return false;
    }

    fs.writeFileSync('employee-details.json', JSON.stringify(employees));
    res.json({msg: 'Employee updated successfully'});
    return false;
})

app.delete('/employees/:user_id/delete', (req, res) => {
    const employees = parseJSON();
    const employee = _.find(employees, {user_id: parseInt(req.params['user_id'])});
    const idx = _.findIndex(employees, {'user_id': parseInt(req.params['user_id'])});
    
    if (idx === -1) {
        res.status(400).json({err: 'No user id found'});
        return false;
    }

    _.remove(employees, employee);

    fs.writeFileSync('employee-details.json', JSON.stringify(employees));
    res.json({msg: 'Employee deleted successfully'});
    return false;
});

app.get('/employees/getone/:user_id', (req, res) => {
    const employees = parseJSON();
    const employee = _.find(employees, {'user_id': parseInt(req.params['user_id'])});

    if (!employee) {
        res.status(400).json({err: 'No user id found'});
        return false;
    }

    res.json(employee);
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
