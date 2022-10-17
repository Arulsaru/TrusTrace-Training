const apiFile = 'https://jsonplaceholder.typicode.com/todos/';
getApi();
async function getApi() {
    const res = await fetch(apiFile);
    const myData = await res.text();
    sessionStorage.setItem('value',myData);
}