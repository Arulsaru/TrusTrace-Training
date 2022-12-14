const sessionValue = JSON.parse(sessionStorage.getItem('value'));
const idx = sessionStorage.getItem('index');

id.value = sessionValue[idx-1].id;
const tempTitle = titleId.value = sessionValue[idx-1].title;
trueEle = document.getElementById('trueId');  
falseEle = document.getElementById('falseId');  

const bool = true;

if(sessionValue[idx-1].completed) {
    trueEle.checked = true;  
}
else {
    falseEle.checked = true;  
}

function updateName() {

    sessionValue[idx-1].title = titleId.value;
        if(trueEle.checked == bool) {
        sessionValue[idx-1].completed = trueEle.checked;
    }
    else {
        sessionValue[idx-1].completed = 'false';
    }

    console.log(sessionValue[idx-1].title);
    sessionStorage.setItem('value',JSON.stringify(sessionValue));
    alertMessage();
}

function alertMessage() {
    window.alert(tempTitle + ' is updated to ' + sessionValue[idx-1].title);
    location.href = 'file:///A:/Jeevan-Anna-Task/api/api/api.html';
}

function cancelButton() {
    return location.href = 'file:///A:/Jeevan-Anna-Task/api/api/api.html';
}