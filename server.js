/*
git add .
git commit -m "coord"
git push origin master

curl -H "Content-Type: application/json" -X POST -d '{"username":"xyz","password":"xyz"}' https://testdbdb.herokuapp.com/post

*/
var express = require('express');
var bodyParser = require('body-parser');
var app = express();
var jsonParser = bodyParser.json();
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var mongourl = 'mongodb://ansonanson:ansonanson@ds243325.mlab.com:43325/anson';

var geolib = require('geolib');

app.get('/', function(req, res) {
    console.log(0.000807 % 100);

    var tf = geolib.isPointInCircle({ latitude: 22.318166, longitude: 114.180750 }, { latitude: 22.316610, longitude: 114.180547 },
        100
    );
    console.log(tf);
    res.end("hello world vvvv");
})

app.get('/json', function(req, res) {
    res.json({ "test1": "aaa" });
})

app.post('/post', jsonParser, function(req, res) {
    console.log(req.body);
    //res.end(JSON.stringify(req.body));
    res.json({ aaa: "bbb wifi" });
})

app.post('/register', jsonParser, function(req, res) {
    var obj = req.body;
    console.log(obj);
    MongoClient.connect(mongourl, function(err, database) {
        assert.equal(err, null);
        console.log("errrr:");
        console.log(err);
        const myDB = database.db('anson');
        cursor = myDB.collection("account").find({ account_id: obj.account_id });
        var objj = [];
        cursor.each(function(err, doc) {
            assert.equal(err, null);
            if (doc != null) {
                objj.push(doc);
            } else {
                console.log(objj);
                if (objj.length == 0) {
                    console.log("not repeat");
                    myDB.collection("account").insert(obj, function(err, result) {
                        assert.equal(err, null);
                        console.log("added new account");
                        res.end("ok");
                    });
                } else {
                    console.log("already exist");
                    res.end("exist");
                }
            }
        });

    });
    //username password email phone;
});

app.post('/login', jsonParser, function(req, res) {
    var obj = req.body;
    console.log(obj);
    MongoClient.connect(mongourl, function(err, database) {
        assert.equal(err, null);
        console.log("errrr:");
        console.log(err);
        const myDB = database.db('anson');
        cursor = myDB.collection("account").find({ account_id: obj.account_id });
        var objj = [];
        cursor.each(function(err, doc) {
            assert.equal(err, null);
            console.log(doc)
            if (doc != null) {
                console.log(doc);
                if (doc.password == obj.password) {
                    res.end("ok");
                } else {
                    res.end("wrong");
                }
            } else {
                res.end("notExist");
            }
        });
    });
});

app.post('/coord', jsonParser, function(req, res) {
    function findAllCoord(y2, y1, x2, x1) {
        console.log(y2 + " " + y1 + " " + x2 + " " + x1);
        parseFloat(y2);
        parseFloat(y1);
        parseFloat(x2);
        parseFloat(x1);
        //console.log((y2-y1));
        //console.log((x2-x1));
        var m = (y2 - y1) / (x2 - x1); //0.000451/-0.001581
        //console.log(m);
        var anArray = [];
        if (x2 > x1) {
            var repNum = x2 * 1000000 - x1 * 1000000;
            var aVar = parseFloat(x1);
            anArray.push({ lat: x1, long: y1 });
            //console.log("vvvv1");
            //console.log(repNum);
            //console.log(parseInt(repNum/100));
        } else {
            var repNum = x1 * 1000000 - x2 * 1000000;
            var aVar = parseFloat(x2);
            anArray.push({ lat: x2, long: y2 });
            //console.log("vvvv12");
            //console.log(repNum);
            //console.log(parseInt(repNum/100));            
        }
        for (i = 1; i < repNum / 100; i++) {
            //console.log("whyyy");
            //console.log(y1);
            //console.log(m * ((aVar+i*0.000100)-x1));
            var resultt = parseFloat(y1) + parseFloat(m * ((aVar + i * 0.000100) - x1));
            var latFloat = parseFloat(aVar + i * 0.000100);
            anArray.push({ lat: latFloat.toFixed(6).toString(), long: resultt.toFixed(6).toString() });
        }
        if (x2 > x1) {
            anArray.push({ lat: x2, long: y2 });
        } else {
            anArray.push({ lat: x1, long: y1 });
        }
        return anArray;
    }
    var obj = req.body;
    console.log(obj);
    MongoClient.connect(mongourl, function(err, database) {
        const myDB = database.db('anson');
        cursor = myDB.collection("road").find();
        var objj = {};
        var result = [];
        cursor.each(function(err, doc) {
            assert.equal(err, null);
            console.log(doc)
            if (doc != null) {
                console.log(doc.roadName);
                var allCoordSet = [];
                for (i in doc.coord) {
                    var allCoord = findAllCoord(doc.coord[i].lineE.long, doc.coord[i].lineS.long, doc.coord[i].lineE.lat, doc.coord[i].lineS.lat);
                    //console.log(allCoord);
                    allCoordSet = allCoordSet.concat(allCoord);
                    //console.log("whyyyyy");
                    //console.log(allCoordSet);
                }
                objj[doc.roadName] = allCoordSet;
            } else {
                //console.log(objj);
                for (key in objj) {
                    console.log(key);
                    for (i = 0; i < objj[key].length; i++) {
                        //console.log(objj[key][i]);
                        var userLat = parseFloat(obj.lat);
                        var userLong = parseFloat(obj.long);
                        var targetLat = parseFloat(objj[key][i].lat);
                        var targetLong = parseFloat(objj[key][i].long);
                        var tf = geolib.isPointInCircle({
                                latitude: targetLat,
                                longitude: targetLong
                            }, {
                                latitude: userLat,
                                longitude: userLong
                            },
                            100
                        );
                        if(tf==true){
                            console.log("found!");
                            result.push(key);
                            //console.log(key);
                            break;
                        }
                    }
                }
                console.log(result);
                if(result.length!=0){
                    res.end(result.toString());
                }else{
                    res.end("Sorry, no any road nearby");
                }     
            }
        });
    });
});

app.post('/test', jsonParser, function(req, res) {
    var obj = req.body;
    console.log(obj);
    res.end("ok");
});

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
                assert.equal(err, null);
                console.log("errrr:");
                console.log(err);
                const myDB = database.db('anson');
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
                assert.equal(err, null);
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
                assert.equal(err, null);
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
                assert.equal(err, null);
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
                        res.json({ result: objj });
                    }
                });
                database.close();
            });
            break;
    }
})


app.listen(process.env.PORT || 8099);