/*
git add .
git commit -m "json"
git push origin master

*/
var express = require('express')
var bodyParser = require('body-parser');
var app = express();
var jsonParser = bodyParser.json();
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var mongourl = 'mongodb://ansonanson:ansonanson@ds243325.mlab.com:43325/anson';


app.get('/', function(req, res) {
    res.end("hello world vvvv");
})

app.get('/test', function(req, res) {
    res.end("hello world vvvv test");
})

app.get('/json', function(req, res) {
    res.json({ "test1": "aaa" });
})

app.post('/post', jsonParser, function(req, res) {
    console.log(req.body);
    //res.end(JSON.stringify(req.body));
    res.json({aaa:aaa});
})

app.post('/db', jsonParser, function(req, res) {
    var obj = req.body;
    var myCollection = obj.collection;
    switch (obj.operation) {
        case "insert":
            delete obj.operation;
            delete obj.collection;
            console.log("insert");
            console.log(obj);
            MongoClient.connect(mongourl, function(err, database) {
            	assert.equal(err,null);
                console.log("errrr:");
                console.log(err);
                const myDB = database.db('anson')
                myDB.collection(myCollection).insert(obj, function(err, result) {
                    database.close();
                    assert.equal(err, null);
                    console.log("Insert was successful!");
                    res.end("insert ok");
                });
            });
            break;
        case "remove":
            delete obj.operation;
            delete obj.collection;
            console.log("remove");
            console.log(obj);
            MongoClient.connect(mongourl, function(err, database) {
            	assert.equal(err,null);
                console.log("errrr:");
                console.log(err);
                const myDB = database.db('anson')
                myDB.collection(myCollection).remove(obj, function(err, result) {
                    database.close();
                    assert.equal(err, null);
                    console.log("remove was successful!");
                    res.end("remove ok");
                });
            });
            break;
        case "update":
            var updateVal = obj.updateVal;
            delete obj.operation;
            delete obj.updateVal;
            delete obj.collection;
            console.log("remove");
            console.log(obj);
            MongoClient.connect(mongourl, function(err, database) {
            	assert.equal(err,null);
                console.log("errrr:");
                console.log(err);
                const myDB = database.db('anson')
                myDB.collection(myCollection).update(obj, { $set: updateVal }, function(err, result) {
                    database.close();
                    assert.equal(err, null);
                    console.log("update was successful!");
                    res.end("update ok");
                });
            });
            break;
        case "find":
            delete obj.operation;
            delete obj.collection;
            console.log("find");
            console.log(obj);
            MongoClient.connect(mongourl, function(err, database) {
            	assert.equal(err,null);
                console.log("errrr:");
                console.log(err);
                const myDB = database.db('anson')
                cursor = myDB.collection(myCollection).find(obj);
                var objj = [];
                cursor.each(function(err, doc) {
                    assert.equal(err, null);
                    if (doc != null) {
                        objj.push(doc);
                    } else {
                        res.json(objj);
                    }
                });
                database.close();
            });
            break;
    }
})


app.listen(process.env.PORT || 8099);