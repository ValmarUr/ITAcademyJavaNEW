
db.createCollection('localidad', {
    validator: {
        $jsonSchema: {
            bsonType: 'object',
            title:'localidad',
            required: ['provincia', 'nombre'],
            properties: {
                provincia: {bsonType: 'objectId'},
                nombre: {bsonType: 'string'}
            }
        }
    }
});  