var express = require('express')
 
var app = express()
 
app.get('/', function(req, res) {
	res.end("hello world vvvv");
  //res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})
 
app.listen(process.env.PORT||8099);