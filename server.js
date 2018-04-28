/*
git add .
git commit -m "details"
git push origin master

curl -H "Content-Type: application/json" -X POST -d '{"username":"xyz","password":"xyz"}' https://testdbdb.herokuapp.com/post

*/
/**/
var express = require('express');
var bodyParser = require('body-parser');
var app = express();
var jsonParser = bodyParser.json();
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var mongourl = 'mongodb://ansonanson:ansonanson@ds243325.mlab.com:43325/anson';

var geolib = require('geolib');

function findAllCoord(y2, y1, x2, x1) {
    //console.log(y2 + " " + y1 + " " + x2 + " " + x1);
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
app.get('/', function(req, res) {
    //console.log(0.000807 % 100);

    var tf = geolib.isPointInCircle({ latitude: 22.318166, longitude: 114.180750 }, { latitude: 22.316610, longitude: 114.180547 },
        100
    );
    //console.log(tf);
    res.end("hello world vvvvv");
})

app.get('/json', function(req, res) {
    res.json({ "test1": "aaa" });
})

app.post('/post', jsonParser, function(req, res) {
    //console.log(req.body);
    //res.end(JSON.stringify(req.body));
    res.json({ aaa: "bbb wifi" });
})

app.post('/register', jsonParser, function(req, res) {
    console.log("register");
    var obj = req.body;
    //console.log(obj);
    MongoClient.connect(mongourl, function(err, database) {
        assert.equal(err, null);
        //console.log("errrr:");
        //console.log(err);
        const myDB = database.db('anson');
        cursor = myDB.collection("account").find({ account_id: obj.account_id });
        var objj = [];
        cursor.each(function(err, doc) {
            assert.equal(err, null);
            if (doc != null) {
                objj.push(doc);
            } else {
                //console.log(objj);
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
    console.log("login");
    var obj = req.body;
    //console.log(obj);
    MongoClient.connect(mongourl, function(err, database) {
        assert.equal(err, null);
        //console.log("errrr:");
        //console.log(err);
        const myDB = database.db('anson');
        cursor = myDB.collection("account").find({ account_id: obj.account_id });
        var objj = [];
        cursor.each(function(err, doc) {
            assert.equal(err, null);
            //console.log(doc)
            if (doc != null) {
                //console.log(doc);
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

    function findAccident(obj, callback) {
        console.log("findAccident");
        MongoClient.connect(mongourl, function(err, database) {
            const myDB = database.db('anson');
            var accidentObj = {};

            function recursive1(i) {
                //console.log("I:::");
                //console.log(i);
                if (i == obj.length) {

                    //console.log(accidentObj);
                    callback(accidentObj);
                    return;
                } else {
                    //console.log("else");
                    if (obj[i].accident.length == 0) {
                        i++;
                        recursive1(i);
                        return;
                    }
                    var counter = 0;
                    for (j = 0; j < obj[i].accident.length; j++) {
                        myDB.collection("accident").findOne({ id: obj[i].accident[j] }, function(err, result) {
                            if (err) throw err;
                            //console.log(result);
                            counter++;
                            accidentObj[result.id] = result;
                            //console.log(accidentObj);
                            if (counter == obj[i].accident.length) {
                                //console.log("xcczxczdczx");
                                i++;
                                recursive1(i);
                                return;
                            }
                        });
                    }
                }
            }
            recursive1(0);
        });
    }

    function findRoadDetails(res, callback) {
        console.log("findRoadDetails");
        var roadObjArray = [];
        MongoClient.connect(mongourl, function(err, database) {
            const myDB = database.db('anson');
            var counter = 0;
            for (i = 0; i < res.length; i++) {
                myDB.collection("road").findOne({ roadName: res[i] }, function(err, result) {
                    if (err) throw err;
                    counter++;
                    var roadObj = {};
                    roadObj.roadName = result.roadName;
                    roadObj.coordinator = result.centerCoord;
                    roadObj.speedLimit = result.speed;
                    roadObj.accident = result.accident;
                    roadObj.carpark = result.carPark;
                    //console.log("vvvv whyyyy");
                    //console.log(roadObj);
                    roadObjArray.push(roadObj);
                    if (counter == res.length) {
                        //console.log("finish");
                        //console.log(roadObjArray);
                        database.close();
                        findAccident(roadObjArray, function(ress) {
                            //console.log("callback1");
                            //console.log(ress);
                            for (i in roadObjArray) {
                                var tempArray = [];
                                for (j in roadObjArray[i].accident) {
                                    tempArray.push(ress[roadObjArray[i].accident[j]]);
                                }
                                roadObjArray[i].accident = tempArray;
                            }
                            //console.log("resss");
                            //console.log(roadObjArray);
                            callback(roadObjArray);
                        })

                    }
                });
            }
        });
    }

    var obj = req.body;
    //console.log(obj);
    MongoClient.connect(mongourl, function(err, database) {
        const myDB = database.db('anson');
        cursor = myDB.collection("road").find();
        var objj = {};
        var result = [];
        cursor.each(function(err, doc) {
            assert.equal(err, null);
            //console.log(doc)
            if (doc != null) {
                //console.log(doc.roadName);
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
                    //console.log(key);
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
                        if (tf == true) {
                            //console.log("found!");
                            result.push(key);
                            //console.log(key);
                            break;
                        }
                    }
                }
                //console.log(result);
                if (result.length != 0) {
                    findRoadDetails(result, function(obj) {
                        //console.log("vvvv endddd");
                        //console.log(obj);
                        res.json(obj);
                    });
                    //res.end(result.toString());
                } else {
                    res.end("Sorry, no any road nearby");
                }
            }
        });
    });
});
app.post("/getCond", jsonParser, function(req, res) {
    console.log("getCond");
    MongoClient.connect(mongourl, function(err, database) {
        const myDB = database.db('anson');
        var cursor2 = myDB.collection("road").find({});
        cursor2 = cursor2.project({ "coord": 1, "_id": 0 });
        var objj = [];
        cursor2.each(function(err, doc) {
            assert.equal(err, null);
            if (doc != null) {
                //console.log(doc.coord);
                objj = objj.concat(doc.coord);
            } else {
                res.json(objj);
            }
        });
    });
})
app.post("/getReport", jsonParser, function(req, res) {
    console.log("getReport");
    var obj = req.body;
    //console.log(obj);
    MongoClient.connect(mongourl, function(err, database) {
        const myDB = database.db('anson');
        var cursor = myDB.collection("accident").find({ "roadName": obj.roadName });
        var objj = [];
        cursor = cursor.sort({ "id": -1 });
        cursor.each(function(err, doc) {
            assert.equal(err, null);
            if (doc != null) {
                objj.push(doc);
            } else {
                res.json({ result: objj });
            }
        });
    });
})
app.post('/report', jsonParser, function(req, res) {
    console.log("report");
    var obj = req.body;
    //console.log(obj);
    var newObj = {};
    newObj.id = new Date().getTime();
    newObj.account_id = obj.UserName;
    newObj.type = obj.type;
    newObj.description = obj.accident_description;
    newObj.roadName = obj.RoadName;
    newObj.up = 0;
    newObj.down = 0;
    var latLngStr = obj.accident_position;
    latLngStr = latLngStr.replace("lat/lng: (", "").replace(")", "");
    //console.log("latLngStr");
    //console.log(latLngStr);
    var latLngStrArray = latLngStr.split(",");
    //console.log("latLngStrArray");
    //console.log(latLngStrArray);
    latLngStrArray[0] = parseFloat(latLngStrArray[0]).toFixed(6);
    latLngStrArray[1] = parseFloat(latLngStrArray[1]).toFixed(6);
    newObj.coord = { "lat": latLngStrArray[0], "long": latLngStrArray[1] }
    newObj.comments = [];
    //console.log(newObj);
    MongoClient.connect(mongourl, function(err, database) {
        assert.equal(err, null);
        const myDB = database.db('anson');
        myDB.collection("accident").insert(newObj, function(err2, result2) {
            //database.close();
            assert.equal(err2, null);
            console.log("Insert report was successful!");
            myDB.collection("road").update({ roadName: obj.RoadName }, { $push: { "accident": newObj.id } }, function(err3, result3) {
                assert.equal(err3, null);
                console.log("Update report was successful!");
                database.close();
                res.end("ok");
            })

        });
    });
});

app.post('/test', jsonParser, function(req, res) {
    function extractText(str) {
        var ret = "";

        if (/"/.test(str)) {
            ret = str.match(/"(.*?)"/g);
        } else {
            ret = str;
        }

        return ret;
    }
    console.log("testttttestttt2");
    var obj = req.body;
    if (JSON.stringify(obj) != "{}") {
        console.log(JSON.stringify(obj));
        var routes = obj.routes;
        var allArray = [];
        for (i = 0; i < routes.length; i++) {
            var tempArr = [];
            console.log("legs length:");
            console.log(routes[i].legs.length);
            var steps = routes[i].legs[0].steps;
            for (j = 0; j < steps.length; j++) {
                var newStr = steps[j].html_instructions.replace(/<b>/g, "\"");
                newStr = newStr.replace(/<\/b>/g, "\"");
                console.log("newStr");
                console.log(newStr);
                var arrrr = extractText(newStr);
                for (ii = 0; ii < arrrr.length; ii++) {
                    arrrr[ii] = arrrr[ii].replace(/"/g, "");
                }
                console.log(arrrr);
                tempArr = tempArr.concat(arrrr);
            }
            allArray[i] = tempArr;
        }
        console.log(allArray);
        MongoClient.connect(mongourl, function(err, database) {
            assert.equal(err, null);
            //console.log("errrr:");
            //console.log(err);
            const myDB = database.db('anson');
            var cursor = [];
            /*for (iii = 0; iii < allArray.length; iii++) {
                console.log(allArray[iii]);
                cursor[iii] = myDB.collection("accident").find({
                    "roadName": {
                        "$in": allArray[iii]
                    }
                });
                cursor[iii] = cursor[iii].sort({ "id": -1 });
            }*/
            //for (iii = 0; iii < allArray.length; iii++) {
                console.log("allArray[0]");
                console.log(allArray[0]);
                cursor[0] = myDB.collection("accident").find({
                    "roadName": {
                        "$in": allArray[0]
                    }
                });
                cursor[0] = cursor[0].sort({ "id": -1 });
            //}
            var bigObjj = [];

            function recursive(i) {
                if (i == cursor.length) {
                    console.log(bigObjj);
                    res.json(bigObjj);
                    return;
                };
                var objj = [];
                cursor[iii].each(function(err, doc) {
                    assert.equal(err, null);
                    if (doc != null) {
                        objj.push(doc);
                    } else {
                        bigObjj.push(objj);
                        i++;
                        recursive(i);
                        return;
                    }
                });

            }
            recursive(0);
        });
    } else {
        res.end("ok");
    }
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