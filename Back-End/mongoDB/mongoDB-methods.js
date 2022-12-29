db.students.insertMany([


db.students.countDocuments() // get the number of documents
db.students.find({ gender: "Female" }) // Case Sensitive
db.students.find({ gender: {$regex: /female/i}}) // Case Insensitive
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

db.students.find({}) // to list all the datas


 

