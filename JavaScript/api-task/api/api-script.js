sessionData = JSON.parse(sessionStorage.getItem('value'));

let ctr = 0;
const tableEle = document.getElementById('myTable');
const bool = true;

while(ctr < 10) {

    let rowCount = myTable.rows.length;
    const row = myTable.insertRow(rowCount);
    row.insertCell(0).innerHTML = sessionData[ctr].id;
    row.insertCell(1).innerHTML = sessionData[ctr].title;
    row.insertCell(2).innerHTML = sessionData[ctr].completed;  
    
    if(sessionData[ctr].completed == bool) {
        tableEle.rows[ctr+1].cells[2].style.backgroundColor = 'green';
    }
    else {
        tableEle.rows[ctr+1].cells[2].style.backgroundColor = 'red';
    }

    row.insertCell(3).innerHTML = '<input type="button" value="Edit" onClick="editCell(this)">';
    ctr += 1;

}

function editCell(myObj) {
    const idx = myObj.parentNode.parentNode.rowIndex;
    sessionStorage.setItem('index',idx);
    window.location.href = 'edit-page.html';
}

// function clearStorage() {
//     sessionStorage.clear();
//     alert('Storage cleared');
//     location.reload();
// }

function functionCall() {
    console.log('arulmozhi');
}

// const pages = document.getElementsByClassName('page-link');
