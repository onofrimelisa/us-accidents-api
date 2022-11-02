db = connect( 'mongodb://localhost/accidents' );
console.log("Conexión", db);
db.createCollection("accidents");

db.accidents.createIndex( { "accident_id" : 1 } )
db.accidents.createIndex( { "start_point" : "2dsphere" } )