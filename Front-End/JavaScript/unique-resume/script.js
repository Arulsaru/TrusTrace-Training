const pageMenus = document.getElementsByClassName('page-menu');
let outerIdx = 0;
let currentPageNumber;
let pageNumber = 1;
let pageLoad = true;

const previousButton = document.getElementById('previous-button');

const personalContinueButton = document.getElementById('personal-details-button');
const educationContinueButton = document.getElementById('education-button');
const experienceContinueButton = document.getElementById('experience-button');
const skillsContinueButton = document.getElementById('skills-button');
const extraContinueButton = document.getElementById('extra-button');
const summaryContinueButton = document.getElementById('summary-button');

const personalDatas = document.getElementsByClassName('personal-info');
const educationDatas = document.getElementsByClassName('education-info');
const experienceDatas = document.getElementsByClassName('experience-info');
const skillDatas = document.getElementsByClassName('skills-info');
const extraDatas = document.getElementsByClassName('extra-info');

while (outerIdx < pageMenus.length) {
    const pageMenu = pageMenus[outerIdx];

    pageMenu.addEventListener('click', function (event) {
        const page = this.getAttribute('data-page');
        currentPageNumber = page;
        showNextPage(page);
    });

    outerIdx += 1;
}

showNextPage(2);  // initial page

function showNextPage(pageIdx) {

    let innerIdx = 0;
    const pageDetails = document.getElementsByClassName('page-details');

    while (innerIdx < pageDetails.length) {
        const currentPage = pageDetails[innerIdx];
        currentPage.style = 'display: none';
        innerIdx += 1;
    }

    document.getElementById(`page-${pageIdx}`).style = '';

    if (pageIdx === 1) {
        previousButton.disabled = true;
    }
    else if (pageIdx === pageDetails.length - 1) {
        summaryContinueButton.disabled = true;
    }
    else {
        previousButton.disabled = false;
    }

}

enableNextPage(1, true); // enable pandrathuku initial uh

function enableNextPage(page, bool) {

    if (pageLoad) {
        if (page === 1) {
            let ctr = 2;
            while (ctr <= pageMenus.length) {
                const button = document.getElementById(`button-${ctr}`);
                button.disabled = true;
                button.style.cursor = 'not-allowed';
                    
                ctr += 1;
            }
        }
        pageLoad = false;
    }
    else {
        const button = document.getElementById(`button-${page}`);
        button.disabled = false;
        button.style.cursor = 'pointer';
        
        if(true && bool) {
            let temp = page - 1;
            temp === 0 ? temp = 1 : temp;
            const button = document.getElementById(`button-${temp}`);
            console.log(page, temp);
            button.style.backgroundColor = 'lightgreen';
        }
       
        showNextPage(page);
    }

}

const elements = document.querySelectorAll('.technical-skills');
let correctInputCount = 0;

const pageValidation = (myObjects) => {
    
    let temp = 0;
    let idx = 0;
    correctInputCount = 0;
    const genderError = document.getElementById('gender-error');

    while (idx < myObjects.length) {

        const myObject = myObjects[idx];
        const name = myObject.name;
        if (myObject.type !== 'Array') {
            const element = document.querySelector(`[name=${name}]`);
            const errorMsg = element.nextElementSibling;
            const errorIcon = errorMsg.nextElementSibling;

            if (element.value === '' ) {
            // && ( ! element.checked && (temp = 1))

                if(temp) {
                    genderError.textContent = 'bla bla';
                }
                else {
                    errorMsg.textContent = `${name[0].toUpperCase()}${name.slice(1, name.length).split('_').join(' ')} is required`;
                    genderError.textContent = '';
                }

                displayErrorMessage(errorIcon);
            }
            else if (!element.value.match(myObject.regex)) {
                console.log(myObject.regex)
                errorMsg.textContent = `Enter the correct ${name.split('_').join(' ')}`;
                displayErrorMessage(errorIcon);
            }
            else if (!myObject.max === element.value.length) {                       // logic maathanu
                errorMsg.textContent = `${name.split('_').join(' ')} should be of ${myObject.max} characters`;
                displayErrorMessage(errorIcon);
            }
            else {
                errorMsg.textContent = '';
                genderError.textContent = '';
                errorIcon ? errorIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#10003;</i>':'';
                correctInputCount += 1;
            }

        }
        else {
            const elements = document.querySelectorAll(`.technical-skills`);
            if (skillsMainInput.value === '') {
                mainSkillsErrorMsg.textContent = 'Enter any input';
            }
            else {
                let innerIdx = 1;
                while (innerIdx < elements.length) {
                    const childError = document.getElementById(`child-skill-error-id-${innerIdx}`);
                    if (elements[innerIdx].value === '') {
                        childError.innerText = 'Please Enter this field';
                    }
                    else {
                        childError.textContent = '';
                        correctInputCount += 1;
                    }

                    innerIdx += 1;
                }
            }
        }

        idx += 1;
    }
    return correctInputCount;
}

function displayErrorMessage(errorIcon) {

    if(errorIcon) {
        errorIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
    }

}

const pageOneDatas = [
    {
        name: 'first_name',
        is_required: true,
        regex: new RegExp('[A-Z][a-zA-Z]+')
    },
    {
        name: 'last_name',
        is_required: true,
        regex: new RegExp('[A-Z][a-zA-Z]+')
    },
    {
        name: 'phone_number',
        is_required: true,
        regex: new RegExp('[0-9]{10}'),
        max: 10
    },
    {
        name: 'email',
        is_required: true,
        regex: new RegExp('([a-zA-Z0-9][a-zA-Z0-9\\.]+@[a-zA-Z0-9]+([\\.][a-zA-Z]+)+)')
    },
    {
        name: 'city',
        is_required: true,
        regex: new RegExp('[A-Z][a-zA-z]')
    },
    {
        name: 'state',
        is_required: true,
        regex: new RegExp('[A-Z][a-zA-Z]')
    }
]

const pageTwoDatas = [
    {
        name: 'college_name',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'field_of_study',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'college_location',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'end_year',
        is_required: true,
        regex: new RegExp('[0-9]')
    },
    {
        name: 'CGPA',
        is_required: true,
        regex: new RegExp('[0-9]')
    },
    {
        name: 'school_name',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'school_location',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'HSC_percentage',
        is_required: true,
        regex: new RegExp('[0-9]')
    },
    {
        name: 'SSLC_percentage',
        is_required: true,
        regex: new RegExp('[0-9]')
    }
]

const pageThreeDatas = [
    {
        name: 'company_name',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'designation',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'company_location',
        is_required: true,
        regex: new RegExp('[A-Za-z]')
    },
    {
        name: 'e_end_year',
        is_required: true,
        regex: new RegExp('[0-9]')
    },
    {
        name: 'start_year',
        is_required: true,
        regex: new RegExp('[0-9]')
    }, 
    {
        name: 'linkedin_profile',
        is_required: true
    },
    {
        name: 'github_profile',
        is_required: true
    },  
    {
        name: 'project_name',
        is_required: true
    },
    {
        name: 'project_description',
        is_required: true
    }
]

const pageFourDatas = [
    {
        name: 'technical_skills[]',
        is_required: true,
        regex: new RegExp('[A-Za-z0-9]'),
        message: 'Please Enter atleast 3 skills',
        type: 'Array',
        selector_class: 'technical-skills'
    }
]

const pageFiveDatas = [
    {
        name: 'birthday',
        is_required: true,
    },
    {
        name: 'gender',
        is_required: true
    },
    {
        name: 'description',
        is_required: true
    }
]

previousButton.addEventListener('click', showPreviousPage)

personalContinueButton.addEventListener('click', function(event) {
    event.preventDefault();
    validatePersonalDetails();
});

educationContinueButton.addEventListener('click', function(event) {
    event.preventDefault();
    validateEducationDetails();
});

experienceContinueButton.addEventListener('click', function(event) {
    event.preventDefault();
    validateExperienceDetails();
});

skillsContinueButton.addEventListener('click', function(event) {
    event.preventDefault();
    validateSkills();
});

extraContinueButton.addEventListener('click', function(event) {
    event.preventDefault();
    validateExtraFields();
});

summaryContinueButton.addEventListener('click', function(event) {
    event.preventDefault();
    summa();
});

function validatePersonalDetails() {
    pageValidation(pageOneDatas);

    if (personalDatas.length === correctInputCount) {

        // setTimeout(() => {
            currentPageNumber ? enableNextPage(++currentPageNumber, false) : enableNextPage(++pageNumber, true);
            pageMenus.style = 'background-color: #90EE90 !important';
        // }, 2000)

    }

}

function validateEducationDetails() {
    pageValidation(pageTwoDatas);
    if (educationDatas.length === correctInputCount) {
        currentPageNumber ? enableNextPage(++currentPageNumber, false) : enableNextPage(++pageNumber, true);
    }
}

function validateExperienceDetails() {
    pageValidation(pageThreeDatas);
    if (experienceDatas.length === correctInputCount) {
        currentPageNumber ? enableNextPage(++currentPageNumber, false) : enableNextPage(++pageNumber, true);
    }
}

// const childSkillErrorMessage = document.getElementById('child-skill-error-id-1');
const skillInputs = document.getElementsByClassName('skills-info');

function validateSkills() {

    pageValidation(pageFourDatas);
    if (correctInputCount >= 0) {
        correctInputCount += 1;
        if (correctInputCount > 2 && skillInputs.length - 1 > 2) {
            currentPageNumber ? enableNextPage(++currentPageNumber, false) : enableNextPage(++pageNumber, true);
        }
        else {
            mainSkillsErrorMsg.textContent = 'Please add atleast three fields';
        }
    }
}

function validateExtraFields() {
    pageValidation(pageFiveDatas);
    addSelectedLanguages();
    if(extraDatas.length - 1 === correctInputCount) {
        currentPageNumber ? enableNextPage(++currentPageNumber, false) : enableNextPage(++pageNumber, true);
    }
}

function summa() {
    currentPageNumber ? enableNextPage(++currentPageNumber, false) : enableNextPage(++pageNumber, true);
}

function showPreviousPage() {
    currentPageNumber ? enableNextPage(--currentPageNumber, false) : enableNextPage(--pageNumber, true);
}


const addSkillButton = document.getElementById('skill-add-button');
addSkillButton.addEventListener('click', function(event) {
    event.preventDefault();
    addSkill();
});

const mainSkillsErrorMsg = document.getElementById('skills-error');

const skillsLeftDiv = document.getElementById('skills-left-div');
const skillsMainInput = document.getElementById('skills-name');

let index;
let lastTextBoxValue;
let idCount = 1;

function checkElements() {
    let ctr = 0;
    while (ctr < elements.length) {
        if (elements[ctr].value === '') {
            return true;
        }
        ctr += 1;
    }
    return false;
}

function addSkill() {

    if (skillsMainInput.value === '') {
        mainSkillsErrorMsg.textContent = 'Add any skill';
    }
    else {
        const inputGroupDiv = document.createElement('div');
        inputGroupDiv.className = 'input-group';

        const inputEle = document.createElement('input');
        inputEle.type = 'text';
        inputEle.id = `skill-input-id-${idCount}`;
        inputEle.className = 'form-control technical-skills skills-info';
        inputEle.name = 'technical_skills[]';
        inputGroupDiv.appendChild(inputEle);
        skillsLeftDiv.appendChild(inputGroupDiv);

        // skillInputs.push(inputEle.value);

        const removeButton = document.createElement('button');
        removeButton.innerHTML = 'Remove';
        removeButton.className = 'skills-remove';
        skillsLeftDiv.appendChild(removeButton);

        const childSkillError = document.createElement('span');
        childSkillError.id = `child-skill-error-id-${idCount}`;
        childSkillError.className = 'child-skill-error-class';
        skillsLeftDiv.appendChild(childSkillError);

        removeButton.addEventListener('click', function () {
            removeButton.remove();
            inputGroupDiv.remove();
            inputEle.remove();
            childSkillError.remove();
        });

        mainSkillsErrorMsg.textContent = '';
        idCount += 1;
    }

}

let flag = 1;   
let selectedLanguages = [];
const optionError = document.getElementById('select-error');
function addSelectedLanguages() {

    // save button kudukurakurathuku munnadi options oda length evlo paakanu..! 
    if(flag) {
        const options = document.getElementsByClassName('option');
        let ctr = 0;
        while(ctr < options.length) {
            if(options[ctr].selected) {
                selectedLanguages.push(options[ctr].value);
                flag = 0;
            }
            ctr += 1;
        }

        if(flag) {
            optionError.textContent = 'Select atleast one language';
        }
        else {
            optionError.style.color = 'green';
            optionError.textContent = 'Saved';
            flag = 0;
        }
    }
    else {
        optionError.innerText = 'One time save will be considered';
    }
}

let convertedImage = '';

function showImage(input) {

    if (input.files && input.files[0]) {
        const reader = new FileReader();

        reader.onload = function (event) { 
            $('#image-preview').attr('src', event.target.result);
        };

        reader.onloadend = function() {  
            convertedImage = reader.result;  
        }     

        reader.readAsDataURL(input.files[0]);
        const userIcon = document.getElementById('preview-icon');
        userIcon.remove();
    }
}

// let base64data;
// const getBase64FromUrl = async (url) => {
//     const data = await fetch(url);
//     const blob = await data.blob();
//     return new Promise((resolve) => {
//       const reader = new FileReader();
//       reader.readAsDataURL(blob); 
//       reader.onloadend = () => {
//         base64data = reader.result;   
//         resolve(base64data);
//       }
//       console.log(base64data);
//     });
// }

const datas = [];
const newSkillDatas = [];
let selectedGender;
let splittedDescription;

function generatePdf() {
    swal("Your resume is being downloaded..Kindly check your downloads", "success");  
    console.log(datas);
    const button = document.getElementById(`button-${6}`);
    button.style.backgroundColor = '#90EE90';
    let doc = new jsPDF({lineHeight: 1.5});

    // const inputs = document.querySelectorAll(`.personal-info, .education-info, .experience-info, .extra-info, .technical-skills`);

    let idx = 0;
    const inputs = document.querySelectorAll(`input, select, textarea`);
    
    while(idx < inputs.length) {    
        const input = inputs[idx];
        if(input.multiple && input.type === 'text') {

            let skillClassName = input.getAttribute(`name`);  
            skillClassName = skillClassName.replace('[]', ''); 
            skillClassName = skillClassName.replace('_','-'); 
            const tempInputs = document.querySelectorAll(`.${skillClassName}`); 
            let idx = 0;

            while(idx < tempInputs.length) {
                let tempInput = tempInputs[idx];

                newSkillDatas.push ({
                    name: tempInput.getAttribute(`name`),
                    value: tempInput.value
                });

                idx += 1;
            }
        }
        else if(input.type === 'radio') {
            const male = document.getElementById('male-gender');
            const female = document.getElementById('female-gender');
            if(male.checked) {
                selectedGender = 'male';
            }
            else if(female.checked) {
                selectedGender = 'female';
            }
        }
        else {

            datas.push({
                name: input.getAttribute(`name`), 
                value: input.value 
            });

        }
        
        idx += 1;
    }    

    // doc.setFillColor(0, 79, 175);    
    // doc.rect(0, 0, 220, 60, 'F');

    doc.setFont('Times-Roman', 'bold');
    doc.setFontSize(15);
    doc.text(`${getValue('first_name').toUpperCase()} ${getValue('last_name').toUpperCase()}`, 55, 15);

    doc.setFontSize(13);
    doc.text('Front End Developer', 55, 25);

    doc.setFontSize(12);
    doc.setFontType('normal');

    splittedDescription = doc.splitTextToSize(getValue('description'), 145);
    doc.text(splittedDescription, 55, 35);

    if(convertedImage){
        // doc.circle(20, 20, 10, 'S');
        doc.addImage(convertedImage, 'JPEG', 7, 10, 40, 45, 'profile-picture');
    }

    // else {
        // eludhanu.. avatar image ku
    // }

    doc.setLineWidth(0.2);
    doc.line( 55, 60, 400, 60);
    
    // doc.setDrawColor(255, 0, 0);    
    // doc.rect(10, 70, 200, 10, 'F');   // x-axis, y-axis, width, height

    doc.setFontSize(13);
    doc.setFontType('bold');
    doc.text('TECHNICAL SKILLS', 7, 75);
    addSkillInsidePdf(doc);

    doc.setFontSize(13);
    doc.setFontType('bold');
    doc.text('EXPERIENCE', 7, 110);

    doc.setFontSize(12);
    doc.setFontType('normal');
    doc.text(`${'\u2022'}   ${getValue('company_name')} (${getValue('exp_start_year')} - ${getValue('exp_end_year')})`, 20, 120);
    doc.text(getValue('designation'), 25, 130);
    doc.text(getValue('company_location'), 25, 140);

    doc.setFontSize(13);
    doc.setFontType('bold');
    doc.text('ACADEMIC DETAILS', 10, 150);

    doc.setFontSize(12);
    doc.setFontType('italic');
    doc.text(`${'\u2022'}   ${getValue('college_name')} - (${getValue('edu_end_year')}batch)`, 20, 160);
    doc.setFontType('normal');
    doc.text( `${getValue('field_of_study')} - (${getValue('CGPA')} - CGPA)`, 25, 170);
    doc.text(getValue('college_location'), 25, 180);

    doc.setFontSize(12);
    doc.setFontType('italic');
    doc.text(`${'\u2022'}   ${getValue('school_name')}`, 20, 190);
    doc.setFontType('normal');
    doc.text( `HSC - ${getValue('HSC_percentage')}, SSLC - ${getValue('SSLC_percentage')}`, 25, 200);
    doc.text(getValue('school_location'), 25, 210);

    doc.setFontSize(13);
    doc.setFontType('bold');
    doc.text('ADDITIONAL INFORMATION', 10, 220);
    doc.setFontType('italic');
    doc.text('Languages Known', 20, 230);
    doc.setFontType('normal');
    addLanguagesInsidePdf(doc);

    doc.setFontType('normal');
    doc.text(`Birthday  -  ${getValue('birthday')}`, 20, 250);
    doc.text(`LinkedIn profile - ${getValue('linkedin_profile')}`, 20, 260);
    doc.text(`Github profile - ${getValue('github_profile')}`, 20, 270);

    doc.setFontSize(13);
    doc.setFontType('bold');
    doc.text(`PROJECTS`, 10, 280);

    doc.setFontSize(12);
    doc.setFontType('normal');
    splittedDescription = doc.splitTextToSize(getValue('project_description'), 145);
    doc.text(`${splittedDescription}`, 20, 290);

    doc.save(`${getValue('first_name')} ${' ',getValue('last_name')}.pdf`);
}

function getValue(name) {  //last_name
    let ctr = 0;

    while(ctr < datas.length) {
        if(name === datas[ctr].name) {
            return datas[ctr].value;
        }
        ctr += 1;
    }

    return '';
}

function addSkillInsidePdf(doc) {
    doc.setFontSize(12);
    doc.setFontType('normal');
    let xAxis = 16;
    let yAxis = 85;
    let maxLength = 3;
    let nextTime = 0;
    let ctr = 0;

    while(ctr < newSkillDatas.length) {

        if(maxLength === ctr) {
            xAxis = 60 + nextTime;
            yAxis = 85;
            maxLength += 3;
            nextTime = 40;
        }

        doc.text('\u2022   ' + newSkillDatas[ctr].value, xAxis, yAxis);
        ctr += 1;
        yAxis += 10;
    }
     
}

function addLanguagesInsidePdf(doc) {
    doc.setFontSize(12);
    doc.setFontType('normal');
    let xAxis = 30;
    let yAxis = 240;
    let maxLength = 1;
    let nextTime = 0;
    let ctr = 0;
    while(ctr < selectedLanguages.length) {
        
        if(maxLength === ctr) {
            xAxis = 60 + nextTime;
            yAxis = 240;
            maxLength += 1;
            nextTime = 40;
        }
        doc.text('\u2022   ' + selectedLanguages[ctr], xAxis, yAxis);
        ctr += 1;
        yAxis += 10;
    }

}