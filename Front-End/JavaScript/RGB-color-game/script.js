const squares = document.querySelectorAll('.square');
const newGame = document.getElementById('new-game-button');
const colorCode = document.getElementById('color-code');
const message = document.getElementById('message');
let selectedSquareIndex;
let red;
let green;
let blue;
let correctIndex;
let verifyNewGame = 0;
let verifyWrongIcon = 0;

newGame.addEventListener('click', () => {
    verifyNewGame = 1;
    message.innerText = '';
    removeWrongIcons()
    // square.innerHTML = '';
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
                showWrongIcon(square);
                square.style = 'cursor: not-allowed';
                message.innerText = 'Wrong selection try another';
                verifyWrongIcon = 1;
            }

        } 
        else {
            colorCode.innerText = 'Click on new game to start the game..';   
        }
    })
})

function checkNewGameOrNot() {
    return verifyNewGame;
}

function removeWrongIcons() {
    squares.forEach((square) => {
        square.innerHTML = '';
        square.style = 'cursor: pointer';
    })
}

function showWrongIcon(square) {
    square.innerHTML = '<i id="wrong-icon" class="fa-solid fa-circle-xmark"></i>';
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
            console.log(red + " " + green + " " + blue)
        }
    })
}

function displayMainColorCode() {
    colorCode.innerText = `rgb(${red},${green},${blue})`;
}

function generateColor() {
    return Math.floor(Math.random() * 256);
}