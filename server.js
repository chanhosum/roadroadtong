var express = require('express')
 
var app = express()
 
app.get('/notes', function(req, res) {
	res.write("hello world2");
  //res.json({notes: "This is your notebook. Edit this to start saving your notes!"})
})
 
app.listen(3000)