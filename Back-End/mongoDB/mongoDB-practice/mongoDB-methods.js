db.students.insertMany([
{
    "name" : "Arulmozhi Karunagaran",
    "phoneNumber" : 1234567101,
    "gender" : "Male",
    "languagesKnown" : [
        "Tamil",
        "English",
        "Hindi"
    ],
    "collegeName" : "Bannari Amman Institute Of Technology",
    "schoolName" : "Kamalam International School",
    "projects" : [
        {
            "company" : "TrusTrace",
            "projectDomain" : "Machine Learning"
        }
    ],
    "age" : 10
},
{
    "name" : "Preethi Arulmozhi",
    "phoneNumber" : 1234567102,
    "gender" : "Female",
    "languagesKnown" : [
        "Tamil",
        "English"
    ],
    "collegeName" : "Bannari Amman Institute Of Technology",
    "schoolName" : "Kamalam International School",
    "projects" : [
        {
            "company" : "TrusTrace",
            "projectDomain" : "Full Stack Development"
        },
        {
            "company" : "Informatica",
            "projectDomain" : "Technical Support"
        }
    ],
    "age" : 15
},
{
    "name" : "Keerthick Subramaniyam",
    "phoneNumber" : 1234567103,
    "gender" : "Male",
    "languagesKnown" : [
        "Tamil",
        "English"
    ],
    "collegeName" : "Sri Sakthi Institute Of Technology",
    "schoolName" : "Senthil Public School",
    "projects" : [
        {
            "company" : "Zoho",
            "projectDomain" : "Back End"
        },
        {
            "company" : "Rently",
            "projectDomain" : "Front End"
        }
    ],
    "age" : 17
},
{
    "name" : "Gowtham  Baluswamy",
    "phoneNumber" : 1234567104,
    "gender" : "Male",
    "languagesKnown" : [
        "Tamil",
        "English"
    ],
    "collegeName" : "Sri Sakthi Institute Of Technology",
    "schoolName" : "Senthil Public School",
    "projects" : [
        {
            "company" : "Zoho",
            "projectDomain" : "Front End"
        }
    ],
    "age" : 18
},
{
    "name" : "Hari Haran",
    "phoneNumber" : 1234567105,
    "gender" : "Male",
    "languagesKnown" : [
        "Tamil",
        "English",
        "Hindi"
    ],
    "collegeName" : "Coimbatore Insititue Of Technology",
    "schoolName" : "Vijay Boys Public School",
    "projects" : [
        {
            "company" : "TrusTrace",
            "projectDomain" : "Machine Learning"
        }
    ],
    "age" : 19
},
{
    "name" : "Swetha Krishnan",
    "phoneNumber" : 1234567106,
    "gender" : "Female",
    "languagesKnown" : [
        "Tamil",
        "English",
        "Hindi"
    ],
    "collegeName" : "Bannari Amman Institute Of Technology",
    "schoolName" : "Vijay Girls Public School",
    "projects" : [
        {
            "company" : "TrusTrace",
            "projectDomain" : "Machine Learning"
        }
    ],
    "age" : 24,
}
])


db.students.countDocuments() // get the number of documents
db.students.find({ gender: "Female" }) // Case Sensitive
db.students.find({ gender: {$regex: /female/i}}) // Case Insensitive
db.students.insertOne({
        "name": "Gayathri NandhaKumar",
        "phoneNumber": 1234567107,
        "gender": "Female",
        "languagesKnown": [
            "Tamil",
            "English"
        ],
        "collegeName": "Vellore Insititute Of Technology",
        "schoolName": "Kamalam International School",
        "projects": [
            {
                "company": "Odessa",
                "projectDomain": "Visual Studio Code"
            }
        ]
    })
    
db.students.updateOne({phoneNumber: 1234567107}, {"$set": {collegeName: "Coimbatore Institute Of Technology"}}); // edited the already existing file
db.students.updateOne({phoneNumber: 1234567107}, {"$set": {asd: "Random"}}); // new field added
db.students.updateOne({phoneNumber: 1234567106}, {"$set": {asd: "Random"}}); 
db.students.updateOne({phoneNumber: 1234567107}, {"$inc": {age: 5}}); // incrementing age with 5 since it is not present it creates and increments
db.students.updateOne({phoneNumber: 1234567106}, {"$unset": {asd: ""}}); // remove field 
db.students.find({"$or": [{phoneNumber: 1234567104}, {gender: "Female"}]}) // or condition
db.students.updateMany({}, {"$set": {age: 10}}) // setting age field to entire user
db.students.find({age: {"$lt": 16}}) // value lesser than
db.students.find({age: {"$gt": 16}}) // value greater than
db.students.find({age: {"$gte": 10}}) // value greater than or equals
db.students.find({age: {"$lte": 17}}) // value greater than or equals

db.students.find({
    age: {
        "$and": [
            {"$gte": 15},
            {"$lte": 20}
        ]
    }
}) // value greater than or equal to && lesser than or equal to

db.students.updateOne({phoneNumber: 1234567106}, {"$set": {newField: 1121}}, {upsert: true});  // creating new field for age if age is not present in the list
db.students.find({}).sort({name: 1}) // sort all the datas with respect to name (ascending)
db.students.find({}).sort({phoneNumber: -1}) // sort all the datas with respect to name (descending)
db.students.find({}).limit(2); // displays only 2 values from the list
db.students.find({}).limit(2).skip(2); // skips 2 values and displays 2 values from the list
db.students.find(
    {
        projects: [{
            company : "Odessa", 
            projectDomain : "Visual Studio Code"
        }]
    }) // finding nested object
db.students.aggregate({$match: {gender: "Female"}}) // seperates all the gender with female

db.students.find({}) // to list all the datas
//db.students.drop(); // deletes the entire data base
db.createCollection('data'); // creates the new collection
db.students.aggregate([
    {
        $match: {gender: "Female"} // finds match
    }, 
    {
        $group: {_id: "$name", age: {$min: "$age"}} // group only with name and minimum age
    } 
]) // Here group is a stage, _id is the expression, min is the accumulator

show collections // list the entire collections in the db
