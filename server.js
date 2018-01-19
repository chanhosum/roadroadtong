var express = require('express')
var bodyParser = require('body-parser');
var app = express()
var jsonParser = bodyParser.json();

app.get('/', function(req, res) {
    res.end("hello world vvvv");
    //res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})

app.get('/test', function(req, res) {
    res.end("hello world vvvv test");
    //res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})

app.get('/json', function(req, res) {
    res.json({ "test1": "aaa" });
    //res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})

app.post('/post',jsonParser,function(req, res) {
    console.log(req.body);
    res.json(req.body);
    //res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})

app.get('/db', function(req, res) {
    res.json({ "test1": "aaa" });
    //res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})


app.listen(process.env.PORT || 8099);