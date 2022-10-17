const names = [];

function checkResetValue() {

    if (inputName.value.length !== 0) {
        return document.getElementById('inputName').value = '';
    }
    else {
        return alert('No values entered');
    }

}

function createRow() {

    const nameElement = document.getElementById('inputName');

    if (nameElement.value.length === 0) {
        return alert('Enter any input');
    }

    if (document.getElementById("inputSubmit").value === 'Update') {
        inputSubmit.value = 'Add';
    }

    const newTable = document.getElementById('myTable');
    names.push(inputName.value);
    const rowCount = newTable.rows.length;
    const row = myTable.insertRow(rowCount);
    console.log(names.length);
    row.insertCell(0).innerHTML = names.length;
    row.insertCell(1).innerHTML = names[names.length - 1];
    row.insertCell(2).innerHTML = '<input type="button" value="Edit" onClick="Javascript:editCell(this)">';
    row.insertCell(3).innerHTML = '<input type="button" value="Delete" onClick="Javacsript:deleteRow(this)">';
    document.getElementById('inputName').value = '';

}

function editCell(obj) {

    inputSubmit.value = 'Update';
    const index = obj.parentNode.parentNode.rowIndex;
    inputName.value = names[index - 1];
    deleteRow(obj);

}

function updateRowCount() {

    var tableEle = document.getElementById("myTable");
    var rowcountAfterDelete = document.getElementById("myTable").rows.length;

    for (let idx = 1; idx < rowcountAfterDelete; idx += 1) {
        tableEle.rows[idx].cells[0].innerHTML = idx;
    }

}

function deleteRow(obj) {

    const index = obj.parentNode.parentNode.rowIndex; // idhu yen nu therila 
    const table = document.getElementById('myTable');
    table.deleteRow(index);
    deleteArrayElement(index);
    updateRowCount();

}

function deleteArrayElement(idx) {

    if (names.length === 1) {
        names.shift();
    }

    if (idx > -1) {
        names.splice(idx, 1);
    }

    console.log(names);
    console.log(names.length);

}