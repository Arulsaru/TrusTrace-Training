const squares = document.querySelectorAll('.square');
const newGame = document.getElementById('new-game-button');
const colorCode = document.getElementById('color-code');
let selectedSquareIndex;
let red;
let green;
let blue;
let correctIndex;
let flag = 0;

newGame.addEventListener('click', () => {
    flag = 1;
    setRandomColors();
})

squares.forEach((square, index) => {
    square.addEventListener('click', function() {
        if(checkNewGameOrNot()) {
            selectedSquareIndex = index;
            
            if(selectedSquareIndex == correctIndex) {
                console.log(selectedSquareIndex, correctIndex);
            }
            else {
                square.style = 'pointer-event: none';
                square.style = 'cursor: not-allowed';
            }
        }
        else {
            colorCode.innerText = 'Confirm new game first';   
        }
    })
})

function checkNewGameOrNot() {
    return flag;
}

function setRandomColors() {
    correctIndex = Math.floor(Math.random() * squares.length);
    squares.forEach((square, index) => {
        red = generateColor();
        green = generateColor();
        blue = generateColor();
        square.style.backgroundColor = `rgb(${red},${green},${blue})`;

        if(index === correctIndex) {
            displayMainColorCode();
        }
    })
    console.log(red + " " + green + " " + blue)
}

function displayMainColorCode() {
    colorCode.innerText = `rgb(${red},${green},${blue})`;
}

function generateColor() {
    return Math.floor(Math.random() * 256);
}