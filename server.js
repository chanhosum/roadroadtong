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
    JSON.stringify(req.body);
    res.end(JSON.stringify(req.body));
    //res.json(req.body);
})

app.post('/db', jsonParser, function(req, res) {
    var obj = req.body;
    MongoClient.connect(mongourl, function(err, db) {
        switch (obj.operation) {
            case "insert":
            	delete obj.operation;
                db.collection('roadroadtong').insert(obj);
                break;
        }
    });
})


app.listen(process.env.PORT || 8099);