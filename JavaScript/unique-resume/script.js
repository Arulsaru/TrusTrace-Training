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

showNextPage(1);  // initial page

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
            button.style.backgroundColor = '#90EE90';
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

            if (element.value === '' ) 
            // && ( ! element.checked && (temp = 1))
            {
                if(temp) {
                    genderError.textContent = 'bla bla';
                }
                else {
                    errorMsg.textContent = `${name[0].toUpperCase()}${name.slice(1, name.length).split('_').join(' ')} is required`;
                    genderError.textContent = '';
                }
                if(errorIcon) {
                    errorIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
                }
            }
            else if (!element.value.match(myObject.regex)) {
                console.log(myObject.regex)
                errorMsg.textContent = `Enter the correct ${name.split('_').join(' ')}`;
            }
            else if (!myObject.max === element.value.length) {                       // logic maathanu
                errorMsg.textContent = `${name.split('_').join(' ')} should be of ${myObject.max} characters`;
            }
            else {
                errorMsg.textContent = '';
                genderError.textContent = '';
                // errorIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#10003;</i>';
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
        currentPageNumber ? enableNextPage(++currentPageNumber, false) : enableNextPage(++pageNumber, true);
        pageMenus.style = 'background-color: #90EE90 !important';
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

    // const firstName = document.getElementById('first-name').value;
    // const lastName = document.getElementById('last-name').value;
    // const phoneNumber = document.getElementById('phone-number').value;
    // const email = document.getElementById('email').value;
    // const state = document.getElementById('state').value;
    // const city = document.getElementById('city').value;
    // const image = document.getElementById('profile-picture').value;

    // const collegeName = document.getElementById('college-name').value;
    // const course = document.getElementById('field-of-study').value;
    // const collegeLocation = document.getElementById('college-location').value;
    // const endYear = document.getElementById('end-year').value;

    // const schoolName = document.getElementById('school-name').value;
    // const schoolLocation = document.getElementById('school-location').value;
    // const hscPercentage = document.getElementById('hsc-percentage').value;
    // const sslcPercentage = document.getElementById('sslc-percentage').value; 


    // const description = document.getElementById('text-area').value;
    // const spilittedDescription = doc.splitTextToSize(description, 200);


    // doc.setFontSize(20);
    // doc.text(firstName.toUpperCase() + ' ' + lastName.toUpperCase(), 55, 20);
    // doc.setFontSize(12);
    // // doc.lineHeight(1.5);
    // doc.text(spilittedDescription, 55, 30);
    // doc.setLineWidth(0.5);
    // doc.line(0, 65, 220, 65);

    // doc.setFontSize(15);
    // doc.setFontType('bold');
    // doc.text('CONTACT DETAILS', 10, 80);
    // doc.setFontSize(12);
    // doc.setFontType('normal');

    // // doc.setFont('fa-solid-900', 'normal');
    // // doc.setFontSize(10);
    // doc.text('+91 ' + phoneNumber, 15, 95);
    // doc.text( email, 15, 105);
    // doc.text(state + ', ' + city, 15, 115);
    // // doc.text(city, 15, 125);

    // doc.setFontSize(15);
    // doc.setFontType('bold');
    // doc.text('ACADEMIC DETAILS', 120, 80);
    // doc.setFontSize(13);
    // doc.setFontType('normal');
    // doc.text('\u2022   ' + collegeName, 100, 95);
    // doc.text(course + '  -  ' + endYear + ' - batch', 100, 105);
    // doc.text(collegeLocation, 100, 115);

    // doc.text('\u2022   ' + schoolName, 100, 130);
    // doc.text('HSC - ' + hscPercentage + ' %, ' + 'SSLC - ' + sslcPercentage + ' %', 100, 140);
    // doc.text(schoolLocation, 100, 150);

    // doc.setFontSize(15);
    // doc.setFontType('bold');

    // doc.text('TECHNICAL SKILLS', 10, 135);
    // addSkillInsidePdf(doc);
    

    // doc.addImage(image.value, 'PNG', 40, 20, 100, 100, 'profile-picture');





// form-id-submit ---> serialize array -- object
// Array ku className vechi loop pottu kudukanu



// const pageMenus = document.getElementsByClassName('page-menu');
// let outerIdx = 0;
// while (outerIdx < pageMenus.length) {
//     const pageMenu = pageMenus[outerIdx];

//     pageMenu.addEventListener('click', function (event) {
//         const page = this.getAttribute('data-page');
//         nextPage(page);
//     });

//     outerIdx += 1;
// }

// nextPage(1);  // 1 ah maathanu

// function nextPage(pageIdx) {
//     let innerIdx = 0;
//     const pageDetails = document.getElementsByClassName('page-details');

//     while (innerIdx < pageDetails.length) {
//         const pageDetail = pageDetails[innerIdx];
//         pageDetail.style = 'display: none';
//         innerIdx += 1;
//     }

//     document.getElementById(`page-${pageIdx}`).style = '';

// }

// const firstNameErrorMsg = document.getElementById('fname-error');
// const lastNameErrorMsg = document.getElementById('lname-error');
// const phoneNumberErrorMsg = document.getElementById('phone-error');
// const emailErrorMsg = document.getElementById('email-error');

// const fName = document.getElementById('first-name');
// const lName = document.getElementById('last-name');
// const phone = document.getElementById('phone-number');
// const email = document.getElementById('email');

// const fnameIcon = document.getElementById('fname-icon');
// const lnameIcon = document.getElementById('lname-icon');
// const phoneNumberIcon = document.getElementById('phone-icon');
// const emailIcon = document.getElementById('email-icon');

// const personalDatas = document.getElementsByClassName('personal-info');

// let count = 0;
// nextPageEnable(1);

// function nextPageEnable(page) {
//     if (page === 1) {
//         let ctr = 2;
//         while (ctr <= pageMenus.length) {
//             const button = document.getElementById(`button-${ctr}`);
//             button.disabled = true;
//             button.style.cursor = 'not-allowed';
//             ctr += 1;
//         }
//     }
//     else {
//         const button = document.getElementById(`button-${page}`);
//         button.disabled = false;
//         button.style.cursor = 'pointer';
//         nextPage(page);
//     }
// }

// document.getElementById('personal-details-button').addEventListener('click', personalDetailsValidation);
// document.getElementById('education-button').addEventListener('click', educationDetailsValidation);
// document.getElementById('experience-button').addEventListener('click', experienceValidation);
// document.getElementById('skills-button').addEventListener('click', skillsValidation);
// document.getElementById('address-button').addEventListener('click', next);
// document.getElementById('summary-button').addEventListener('click', next);

// let pageNo = 2;

// function next() {
//     nextPageEnable(pageNo++);
// }

// // ----------------------------------------------------------------------------------------------------------------------------------------------------------------


// function personalDetailsValidation() {
//     count = 0;
//     validateFirstName();
//     validateLastName();
//     validatePhoneNumber();
//     validateEmail();
//     if (allInputCorrect(personalDatas, count)) {
//         nextPageEnable(pageNo++);
//     }
// }

// function validateFirstName() {
//     const firstName = fName.value;
//     removeFMark();
//     if (isNull(firstName)) {
//         showFCrossMark();
//         firstNameErrorMsg.textContent = 'First Name shouldn\'t be empty';
//     }
//     else if (firstName[0] === ' ') {
//         showFCrossMark();
//         firstNameErrorMsg.textContent = 'First Name shouldn\'t start with space';
//     }
//     else if (!checkAlphabets(firstName)) {
//         showFCrossMark();
//         firstNameErrorMsg.textContent = 'First Name should contain alphabets';
//     }
//     else {
//         count += 1;
//         showFTickMark();
//         firstNameErrorMsg.textContent = '';
//     }
// }

// function validateLastName() {
//     const lastName = lName.value;
//     removeLMark();
//     if (isNull(lastName)) {
//         showLCrossMark();
//         lastNameErrorMsg.textContent = 'Last Name shouldn\'t be empty';
//     }
//     else if (lastName[0] === ' ') {
//         showLCrossMark();
//         lastNameErrorMsg.textContent = 'Last Name shouldn\'t start with space';
//     }
//     else if (!checkAlphabets(lastName)) {
//         showLCrossMark();
//         lastNameErrorMsg.textContent = 'Last Name should contain alphabets';
//     }
//     else {
//         count += 1;
//         showLTickMark();
//         lastNameErrorMsg.textContent = '';
//     }
// }

// function validateEmail() {
//     const emailId = email.value;
//     removeMailMark();
//     if (isNull(emailId)) {
//         showMailCrossMark();
//         emailErrorMsg.innerText = 'Email is Required';
//         return false;
//     }
//     else if (!emailId.match(/^[a-z0-9.]+@[a-z]+(?:\.[a-z]+)$/)) {
//         showMailCrossMark();
//         emailErrorMsg.innerText = 'Please Enter Valid email';
//         return false;
//     }
//     else {
//         count += 1;
//         showMailTickMark();
//         emailErrorMsg.innerText = '';
//         return true;
//     }
// }

// function validatePhoneNumber() {
//     const number = phone.value;
//     removePhMark();
//     if (isNull(number)) {
//         showPhCrossMark();
//         phoneNumberErrorMsg.innerHTML = 'Phone Number is Required';
//     }
//     else if (!checkPhoneNumber(number)) {
//         showPhCrossMark();
//         phoneNumberErrorMsg.innerHTML = 'Please Enter Valid Phone Number';
//     }
//     else {
//         count += 1;
//         showPhTickMark();
//         phoneNumberErrorMsg.innerHTML = '';
//     }
// }

// function showFCrossMark() {
//     fnameIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showLCrossMark() {
//     lnameIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showPhCrossMark() {
//     phoneNumberIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showMailCrossMark() {
//     emailIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showFTickMark() {
//     fnameIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function showLTickMark() {
//     lnameIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2714;</i>';
// }

// function showPhTickMark() {
//     phoneNumberIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function showMailTickMark() {
//     emailIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function removeFMark() {
//     fnameIcon.innerHTML = '';
// }

// function removeLMark() {
//     lnameIcon.innerHTML = '';
// }

// function removePhMark() {
//     phoneNumberIcon.innerHTML = '';
// }

// function removeMailMark() {
//     emailIcon.innerHTML = '';
// }

// function checkAlphabets(name) {
//     return (/^[A-Za-z]*$/.test(name));
// }

// function checkPhoneNumber(number) {
//     return number.match(/^\d{10}$/);
// }

// function isNull(name) {
//     return (name.length ? false : true);
// }

// function allInputCorrect(datas, count) {
//     if (count === datas.length) {
//         return true;
//     }
//     else return false;
// }

// // ----------------------------------------------------------------------------------------------------------------------------------------------------------------

// const clgName = document.getElementById('college-name');
// const clgLocation = document.getElementById('college-location');
// const course = document.getElementById('field-of-study');

// const collegeNameError = document.getElementById('college-name-error');
// const collegeLocationError = document.getElementById('college-location-error');
// const collegeCourseError = document.getElementById('fos-error');

// const collegeNameIcon = document.getElementById('college-name-icon');
// const collegeLocationIcon = document.getElementById('college-location-icon');
// const collegeCourseIcon = document.getElementById('fos-icon');

// let educationDatas = document.getElementsByClassName('education-info');

// function educationDetailsValidation() {
//     count = 0;
//     validateCollegeName();
//     validateCollegeLocation();
//     validateCollegeCourse();
//     if (allInputCorrect(educationDatas, count)) {
//         nextPageEnable(pageNo++);
//     }
// }


// function validateCollegeName() {
//     const collegeName = clgName.value;
//     if (collegeName.length === 0) {
//         showCollegeNameCrossMark();
//         collegeNameError.textContent = 'College name is required';
//     }
//     else if (!checkAlphabets(collegeName)) {
//         showCollegeNameCrossMark();
//         collegeNameError.textContent = 'College name should be of alphabets';
//     }
//     else {
//         count += 1;
//         showCollegeNameTickMark();
//         collegeNameError.textContent = '';
//     }
// }

// function validateCollegeLocation() {
//     const collegeLocation = clgLocation.value;
//     if (collegeLocation.length === 0) {
//         showCollegeLocationCrossMark();
//         collegeLocationError.textContent = 'College location is required';
//     }
//     else if (!checkAlphabets(collegeLocation)) {
//         showCollegeLocationCrossMark();
//         collegeLocationError.textContent = 'College location should be of alphabets';
//     }
//     else {
//         count += 1;
//         showCollegeLocationTickMark();
//         collegeLocationError.textContent = '';
//     }
// }

// function validateCollegeCourse() {
//     const collegeCourse = course.value;

//     if (collegeCourse.length === 0) {
//         showCollegeCourseCrossMark();
//         collegeCourseError.textContent = 'College course is required';
//     }
//     else if (!checkAlphabets(collegeCourse)) {
//         showCollegeLocationCrossMark();
//         collegeCourseError.textContent = 'College course should be of alphabets';
//     }
//     else {
//         count += 1;
//         showCollegeCourseTickMark();
//         collegeCourseError.textContent = '';
//     }

// }

// function showCollegeNameTickMark() {
//     collegeNameIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function showCollegeLocationTickMark() {
//     collegeLocationIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function showCollegeCourseTickMark() {
//     collegeCourseIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function showCollegeNameCrossMark() {
//     collegeNameIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showCollegeLocationCrossMark() {
//     collegeLocationIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showCollegeCourseCrossMark() {
//     collegeCourseIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function removeCollegeNameMark() {
//     collegeNameIcon.innerHTML = '';
// }

// function removeCollegeLocationMark() {
//     collegeLocationIcon.innerHTML = '';
// }

// function removeCollegeCourseMark() {
//     collegeCourseIcon.innerHTML = '';
// }

// // ----------------------------------------------------------------------------------------------------------------------------------------------------------------

// const companyName = document.getElementById('company-name');
// const designation = document.getElementById('designation');

// const companyNameError = document.getElementById('company-name-error');
// const designationError = document.getElementById('designation-error');

// const companyNameIcon = document.getElementById('company-name-icon');
// const designationIcon = document.getElementById('designation-icon');

// let experienceDatas = document.getElementsByClassName('experience-info');

// function experienceValidation() {
//     count = 0;
//     validateCompanyName();
//     validateDesignation();
//     if (allInputCorrect(experienceDatas, count)) {
//         nextPageEnable(pageNo++);
//     }
// }

// function validateCompanyName() {
//     const name = companyName.value;
//     if (isNull(name)) {
//         showCompanyNameCrossMark();
//         companyNameError.textContent = 'Name is required';
//     }
//     else if (!checkAlphabets(name)) {
//         showCompanyNameCrossMark();
//         companyNameError.textContent = 'Name shouldn\'t contain numbers';
//     }
//     else {
//         count += 1;
//         showCompanyNameTickMark();
//         companyNameError.textContent = '';
//     }
// }

// function validateDesignation() {
//     const role = designation.value;
//     removeDesignationMark();
//     if (isNull(role)) {
//         showDesignationCrossMark();
//         designationError.textContent = 'Designation is required';
//     }
//     else if (!checkAlphabets(role)) {
//         showDesignationCrossMark();
//         designationError.textContent = 'Designation shouldn\'t contain numbers';
//     }
//     else {
//         count += 1;
//         showDesignationTickMark();
//         designationError.innerHTML = '';
//     }
// }

// function showCompanyNameTickMark() {
//     companyNameIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function showDesignationTickMark() {
//     designationIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function showCompanyNameCrossMark() {
//     companyNameIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showDesignationCrossMark() {
//     designationIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function removeCompanyNameMark() {
//     companyNameIcon.innerHTML = '';
// }

// function removeDesignationMark() {
//     designationIcon.innerHTML = '';
// }

// // ----------------------------------------------------------------------------------------------------------------------------------------------------------------

// const skillName = document.getElementById('skills-name');

// const skillNameError = document.getElementById('skills-error');

// const skillNameIcon = document.getElementById('skills-icon');

// let skillDatas = document.getElementsByClassName('skills-info');

// function skillsValidation() {
//     console.log(skillDatas);
//     count = 0;
//     validateSkillName();
//     if (allInputCorrect(skillDatas, count)) {
//         nextPageEnable(pageNo++);
//     }
// }

// function validateSkillName() {
//     removeSkillNameMark();

//     const name = skillName.value;

//     if (isNull(name)) {
//         showSkillNameCrossMark();
//         skillNameError.textContent = 'Skill name shouldn\'t be empty';
//     }
//     else {
//         count += 1;
//         showSkillNameTickMark();
//         skillNameError.textContent = '';
//     }
// }

// function showSkillNameCrossMark() {
//     console.log('arulmozhi');
//     skillNameIcon.innerHTML = '<i style="color: red"; class="fa-solid fa-xmark"></i>';
// }

// function showSkillNameTickMark() {
//     skillNameIcon.innerHTML = '<i style="font-size:20px; color: green;" class="fa">&#x2713;</i>';
// }

// function removeSkillNameMark() {
//     skillNameIcon.innerHTML = '';
// }